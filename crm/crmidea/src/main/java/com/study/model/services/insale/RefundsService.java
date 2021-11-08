package com.study.model.services.insale;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.study.model.mapper.insale.RefundsMapper;
import com.study.model.mapper.insale.SaleorderMapper;
import com.study.model.mapper.insale.SorderproMapper;
import com.study.model.pojo.insale.Refunds;
import com.study.model.pojo.insale.Saleorder;
import com.study.model.pojo.insale.Sorderpro;
import com.study.model.pojo.power.Users;
import com.study.model.vojo.insale.RefundsNewVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class RefundsService {

    @Autowired private RefundsMapper mapper;
    @Autowired private SaleorderMapper saleorderMapper;
    @Autowired private SorderproMapper sorderproMapper;

    public List<Refunds> select(){
        return mapper.selectAll();
    }

    /**
     * 连表查询所有退货单信息
     * @return
     */
    public PageInfo<Refunds> selectAll(Integer no, Integer size){
        PageHelper.startPage(no,size);
        List<Refunds> list = mapper.selectAll();
        return PageInfo.of(list);
    }

    /**
     * 根据编号和名称查询所有
     * @param id
     * @param name
     * @return
     */
    public PageInfo<Refunds> selectMany(Integer no,Integer size,Integer id, String name){
        PageHelper.startPage(no,size);
        List<Refunds> list = mapper.selectMany(id, name);
        return PageInfo.of(list);
    }

    /**
     * 根据销售订单查询退货信息
     * @param soid
     * @return
     */
    public List<Refunds> selectRefundsBySoid(Integer soid){
        return mapper.selectRefundsBySoid(soid);
    }

    /**
     * 新增
     * @param refundsNewVo
     * @return
     */
    public Integer insert(RefundsNewVo refundsNewVo){

        Integer num = 0;

        //根据订单编号查询产品信息
        Integer pnum = 0;
        List<Sorderpro> list = sorderproMapper.selectBySoid(refundsNewVo.getSoId());
        System.out.println("查询的产品信息："+list);
        if(list != null &&list.size()>0){
            for (Sorderpro sorderpro : list) {
                pnum += sorderpro.getProNum();
            }
        }
        System.out.println("产品数量："+pnum);

        Saleorder saleorder = new Saleorder();
        saleorder.setSoId(refundsNewVo.getSoId());

        Users users = new Users();
        users.setUsersId(refundsNewVo.getUserid());

        Saleorder saleorder1 = saleorderMapper.selectBySoid(refundsNewVo.getSoId());
        System.out.println("根据订单编号查询的信息："+saleorder1);
        System.out.println("订单金额："+saleorder1.getSoMoney());

        Refunds refunds = new Refunds();
        refunds.setrName(refundsNewVo.getName());
        refunds.setrDate(Date.valueOf(refundsNewVo.getStarttime()));//退货日期
        refunds.setrWay(refundsNewVo.getWay());//退货方式
        refunds.setrReasons(refundsNewVo.getReason());//退货原因
        refunds.setrTel(refundsNewVo.getTel());//联系电话
        refunds.setrStatu("未入库");
        refunds.setrNum(pnum);

        //退货金额，需要查询销售订单的金额
        refunds.setrMoney(saleorder1.getSoMoney());
        refunds.setSaleorderBySoId(saleorder);//关联订单
        refunds.setUsers(users);//负责人

        Integer r = mapper.insert(refunds);
        if(r>0){
            num += 1;
            System.out.println("退货单新增成功");
            //修改销售订单的退货金额
            Integer s = saleorderMapper.updateByStatu(refundsNewVo.getSoId(),saleorder1.getSoMoney());
            if(s>0){
                num += 1;
            }
        }

        //判断共同新增
        if(num == 2){
            System.out.println("退货单新增成功，销售订单修改成功");
            return 1;
        }else {
            System.out.println("退货单新增失败，销售订单修改失败");
            return -1;
        }
    }

}
