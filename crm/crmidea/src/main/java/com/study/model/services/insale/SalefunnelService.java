package com.study.model.services.insale;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.study.model.mapper.insale.SalefunnelMapper;
import com.study.model.pojo.insale.Salefunnel;
import com.study.model.pojo.power.Users;
import com.study.model.pojo.presale.Activity;
import com.study.model.pojo.presale.Client;
import com.study.model.pojo.presale.Contacts;
import com.study.model.vojo.insale.ProductVo;
import com.study.model.vojo.insale.SalefunnelNewVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class SalefunnelService {

    @Autowired private SalefunnelMapper mapper;
    @Autowired private SaleproService saleproService;

    /**
     * 连接客户表，员工表，市场活动表，联系人表，查询销售机会
     * @return
     */
    public PageInfo<Salefunnel> selectAll(Integer no,Integer size){
        PageHelper.startPage(no,size);
        List<Salefunnel> list = mapper.selectAll();
        return PageInfo.of(list);
    }

    /**
     * 根据机会编号和机会名称查询所有
     * @param id
     * @param name
     * @return
     */
    public PageInfo<Salefunnel> selectMany(Integer no,Integer size,Integer id, String name){
        PageHelper.startPage(no,size);
        List<Salefunnel> list = mapper.selectMany(id, name);
        return PageInfo.of(list);
    }


    /**
     * 新增 销售机会
     * @param salefunnelNewVo
     * @return
     */
    public Integer insert(SalefunnelNewVo salefunnelNewVo){
        Integer num = 0;

        BigDecimal mm = new BigDecimal(salefunnelNewVo.getMoney());
        System.out.println("机会金额："+mm);

        //负责人
        Users users = new Users();
        users.setUsersId(salefunnelNewVo.getEmp());
        //客户
        Client client = new Client();
        client.setClientId(salefunnelNewVo.getCustom());
        //联系人
        Contacts contacts = new Contacts();
        contacts.setContactsId(salefunnelNewVo.getPerson());
        //关联活动
        Activity activity = new Activity();
        activity.setActivityId(salefunnelNewVo.getActivity());

        Salefunnel salefunnel = new Salefunnel();
        salefunnel.setSfName(salefunnelNewVo.getName());//机会名称
        salefunnel.setSfMoney(mm);////机会金额
        salefunnel.setSfDate(Date.valueOf(salefunnelNewVo.getStarttime()));//预计日期

        salefunnel.setActivity(activity);
        salefunnel.setClient(client);
        salefunnel.setContacts(contacts);
        salefunnel.setUser(users);
        //新增销售机会表
        Integer s = mapper.insert(salefunnel);
        System.out.println("主键："+salefunnel.getSfId());
        System.out.println("销售机会返回的值："+s);
        if(s>0){
            num += 1;
            //添加产品中间表
            List<ProductVo> list = salefunnelNewVo.getProduct();
            Integer lnum = list.size();
            Integer fnum = 0;
            System.out.println("共需添加"+lnum+"条产品信息");
            if(list!=null &&list.size()>0){ //不为空
                for (ProductVo productVo : list) {
                    System.out.println("for循环");
                    Integer sp = saleproService.insert(productVo.getNum(),salefunnel.getSfId(),productVo.getProId());
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
            System.out.println("销售机会和中间表新增成功");
            return 1;
        }else {
            System.out.println("销售机会和中间表新增失败");
            return -1;
        }

    }
}
