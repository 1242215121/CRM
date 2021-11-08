package com.study.model.services.insale;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.study.model.mapper.insale.SaleorderMapper;
import com.study.model.pojo.insale.Salefunnel;
import com.study.model.pojo.insale.Saleorder;
import com.study.model.pojo.power.Users;
import com.study.model.pojo.presale.Client;
import com.study.model.pojo.presale.Contacts;
import com.study.model.vojo.insale.ProductVo;
import com.study.model.vojo.insale.SaleorderNewVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class SaleorderService {

    @Autowired private SaleorderMapper mapper;
    @Autowired private SorderproService sorderproService;

    /**
     * 查询所有销售订单
     * @return
     */
    public PageInfo<Saleorder> selectAll(Integer no, Integer size){
        PageHelper.startPage(no,size);
        List<Saleorder> list = mapper.selectAll();
        return PageInfo.of(list);
    }

    /**
     * 多条件分页查询
     * @param no
     * @param size
     * @param id
     * @param name
     * @return
     */
    public PageInfo<Saleorder> selectMany(Integer no,Integer size,Integer id, String name){
        PageHelper.startPage(no,size);
        List<Saleorder> list = mapper.selectMany(id, name);
        return PageInfo.of(list);
    }

    /**
     * 新增销售订单
     * @param saleorderNewVo
     * @return
     */
    public Integer insert(SaleorderNewVo saleorderNewVo){
        //负责人员==当前登录人员，成交金额==now，
        Integer num = 0;

        BigDecimal mm = new BigDecimal("0.00");

        List<ProductVo> list = saleorderNewVo.getProduct();
        if(list != null && list.size()>0){
            for (ProductVo productVo : list) {
//                System.out.println("产品价格："+productVo.getProPrice()+"，数量:"+productVo.getNum());
                mm = mm.add(BigDecimal.valueOf(productVo.getProPrice()).multiply(BigDecimal.valueOf(productVo.getNum())));
//                System.out.println("累加价格："+mm);
            }
        }
        java.sql.Date date=new java.sql.Date(new Date().getTime());//成交日期

        //负责人
        Users users = new Users();
        users.setUsersId(saleorderNewVo.getUser());
        //客户
        Client client = new Client();
        client.setClientId(saleorderNewVo.getCustom());
        //销售机会
        Salefunnel salefunnel = new Salefunnel();
        salefunnel.setSfId(saleorderNewVo.getPerson());

        Saleorder saleorder = new Saleorder();
        saleorder.setSoName(saleorderNewVo.getName());
        saleorder.setSoMoney(mm);//订单金额
        saleorder.setSoDate(date);
        saleorder.setSoBack(new BigDecimal("0.00"));//回款金额
        saleorder.setSoBackstatu("未回款");//回款状态
        saleorder.setSoInvoicing("未开票");//开票状态
        saleorder.setSoInvostatu(new BigDecimal("0.00"));//开票金额
        saleorder.setSoOrderstatu("已生效");//订单状态
        saleorder.setSoPay(mm); // 欠款金额 == 订单金额
        saleorder.setSoReturn(new BigDecimal("0.00"));  // 退货单金额
        saleorder.setSoWarestatu("未出库");// 出库状态

        saleorder.setClient(client);
        saleorder.setUser(users);
        saleorder.setSalefunnelBySfId(salefunnel);

        Integer pnum = 0;//产品数量
        Integer lnum = list.size();
        System.out.println("共需添加"+lnum+"条产品信息");
        if(list != null && list.size()>0){
            for (ProductVo productVo : list) {
                pnum += productVo.getNum();
            }
        }
        saleorder.setSoNonum(pnum);//未出库数量
        saleorder.setSoNum(pnum);//产品数量
        saleorder.setSoWynum(0);// // 已出库数量

        //新增销售订单
        Integer s = mapper.insert(saleorder);
        System.out.println("销售订单主键："+saleorder.getSoId());
        System.out.println("销售订单返回的值："+s);
        if(s>0){
            num += 1;
            //添加产品中间表
            Integer fnum = 0;
            if(list!=null &&list.size()>0){ //不为空
                for (ProductVo productVo : list) {
                    System.out.println("for循环");
                    Integer sp = sorderproService.insert(productVo.getNum(),saleorder.getSoId(),productVo.getProId());
                    if(sp>0){
                        fnum += 1;
                    }
                }

            }
            //判断是否完全新增
            if(lnum == fnum){
                num += 1;
            }
        }
        //判断共同新增
        if(num == 2){
            System.out.println("销售订单和中间表新增成功");
            return 1;
        }else {
            System.out.println("销售订单和中间表新增失败");
            return -1;
        }

    }

}
