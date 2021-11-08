package com.study.model.services.insale;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.study.model.mapper.insale.QuotationsMapper;
import com.study.model.mapper.insale.SaleorderMapper;
import com.study.model.pojo.insale.Quotapro;
import com.study.model.pojo.insale.Quotations;
import com.study.model.pojo.insale.Salefunnel;
import com.study.model.pojo.insale.Saleorder;
import com.study.model.pojo.power.Users;
import com.study.model.pojo.presale.Client;
import com.study.model.vojo.insale.ProductVo;
import com.study.model.vojo.insale.QuotationsNewVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class QuotationsService {

    @Autowired private QuotationsMapper mapper;
    @Autowired private SaleorderMapper saleorderMapper;//销售订单
    @Autowired private QuotaproService quotaproService;
    @Autowired private SorderproService sorderproService;//销售订单中间表

    /**
     * 关联销售机会查询所有报价单
     * @return
     */
    public PageInfo<Quotations> selectAll(Integer no,Integer size){
        PageHelper.startPage(no,size);
        List<Quotations> list = mapper.selectAll();
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
    public PageInfo<Quotations> selectMany(Integer no,Integer size,Integer id, String name){
        PageHelper.startPage(no,size);
        List<Quotations> list = mapper.selectMany(id, name);
        return PageInfo.of(list);
    }

    /**
     * 根据报价单编号修改状态
     * @param qid
     * @return
     */
    public Integer updateStage(Integer qid){
        Integer num = 0;
        //修改报价单状态的同时，新增一条销售订单记录
        Integer q = mapper.updateStage(qid);
        if(q>0){
            num += 1;
            System.out.println("报价单状态修改成功");
            Quotations quotations = selectOwn(qid);
            System.out.println("查询出来的报价单信息："+quotations);

            java.sql.Date date=new java.sql.Date(new Date().getTime());//成交日期

            Saleorder saleorder = new Saleorder();

            saleorder.setSoMoney(quotations.getqMoney());//订单金额
            saleorder.setSoName(quotations.getqName());
            saleorder.setSoDate(date);
            saleorder.setSoBack(new BigDecimal("0.00"));//回款金额
            saleorder.setSoBackstatu("未回款");//回款状态
            saleorder.setSoInvoicing("未开票");//开票状态
            saleorder.setSoInvostatu(new BigDecimal("0.00"));//开票金额
            saleorder.setSoOrderstatu("已生效");//订单状态
            saleorder.setSoPay(quotations.getqMoney()); // 欠款金额 == 订单金额
            saleorder.setSoReturn(new BigDecimal("0.00"));  // 退货单金额
            saleorder.setSoWarestatu("未出库");// 出库状态

            //负责人
            Users users = new Users();
            System.out.println("负责人编号："+quotations.getSalefunnelBySfId().getUser().getUsersId());
            users.setUsersId(quotations.getSalefunnelBySfId().getUser().getUsersId());
            //客户
            Client client = new Client();
            System.out.println("客户编号："+quotations.getSalefunnelBySfId().getClient().getClientId());
            client.setClientId(quotations.getSalefunnelBySfId().getClient().getClientId());
            //销售机会
            Salefunnel salefunnel = new Salefunnel();
            System.out.println("销售机会编号："+quotations.getSalefunnelBySfId().getSfId());
            salefunnel.setSfId(quotations.getSalefunnelBySfId().getSfId());

            saleorder.setClient(client);
            saleorder.setUser(users);
            saleorder.setSalefunnelBySfId(salefunnel);

            Integer pnum = 0;//产品数量
            List<Quotapro> list = quotations.getQuotapros();
            if(list != null && list.size()>0){
                for (Quotapro quotapro : list) {
                    pnum += quotapro.getProNum();
                }
            }
            saleorder.setSoNonum(pnum);//未出库数量
            saleorder.setSoNum(pnum);//产品数量
            saleorder.setSoWynum(0);// // 已出库数量

            //新增销售订单
            Integer s = saleorderMapper.insert(saleorder);
            System.out.println("销售订单主键："+saleorder.getSoId());
            if(s>0){
                num += 1;
                //添加产品中间表
                Integer fnum = 0;
                Integer lnum = list.size();
                System.out.println("共需添加"+lnum+"条产品信息");
                if(list != null && list.size()>0){
                    for (Quotapro quotapro : list) {
                        System.out.println("产品编号："+quotapro.getProduct().getProId());
                        Integer sp = sorderproService.insert(quotapro.getProNum(),saleorder.getSoId(),quotapro.getProduct().getProId());
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

        }
        //判断共同新增
        if(num == 3){
            System.out.println("报价单修改状态，销售订单和中间表新增成功");
            return 1;
        }else {
            System.out.println("报价单修改状态，销售订单和中间表新增失败");
            return -1;
        }
    }

    /**
     * 根据报价单编号获取报价单信息
     * @param qid
     * @return
     */
    public Quotations selectOwn(Integer qid){
        return mapper.selectOwn(qid);
    }

    /**
     * 新增报价单
     * @param quotationsNewVo
     * @return
     */
    public Integer insert(QuotationsNewVo quotationsNewVo){
        Integer num = 0;

        BigDecimal mm = new BigDecimal("0.00");

        List<ProductVo> list = quotationsNewVo.getProduct();
        if(list != null && list.size()>0){
            for (ProductVo productVo : list) {
//                System.out.println("产品价格："+productVo.getProPrice()+"，数量:"+productVo.getNum());
                mm = mm.add(BigDecimal.valueOf(productVo.getProPrice()).multiply(BigDecimal.valueOf(productVo.getNum())));
//                System.out.println("累加价格："+mm);
            }
        }

        Timestamp last  = new Timestamp(System.currentTimeMillis());//最后更新时间
        java.sql.Date date=new java.sql.Date(new Date().getTime());//报价日期

        Salefunnel salefunnel = new Salefunnel();
        salefunnel.setSfId(quotationsNewVo.getActivity());

        Quotations quotations = new Quotations();
        quotations.setqName(quotationsNewVo.getName());
        quotations.setqMoney(mm);
        quotations.setqDate(date);
        quotations.setqStage("草稿");
        quotations.setqTime(last);
        quotations.setSalefunnelBySfId(salefunnel);

        //新增报价单
        Integer s = mapper.insert(quotations);
        System.out.println("报价单主键："+quotations.getqId());
        System.out.println("报价单返回的值："+s);
        if(s>0){
            num += 1;
            //添加产品中间表
            Integer lnum = list.size();
            Integer fnum = 0;
            System.out.println("共需添加"+lnum+"条产品信息");
            if(list!=null &&list.size()>0){ //不为空
                for (ProductVo productVo : list) {
                    System.out.println("for循环");
                    Integer sp = quotaproService.insert(productVo.getNum(),quotations.getqId(),productVo.getProId());
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
            System.out.println("报价单和中间表新增成功");
            return 1;
        }else {
            System.out.println("报价单和中间表新增失败");
            return -1;
        }

    }

}
