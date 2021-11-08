package com.study.model.services.insale;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.study.model.mapper.insale.QuotationsMapper;
import com.study.model.pojo.insale.Quotations;
import com.study.model.pojo.insale.Salefunnel;
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
    @Autowired private QuotaproService quotaproService;

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
       return mapper.updateStage(qid);
    }

    /**
     * 新增报价单
     * @param quotationsNewVo
     * @return
     */
    public Integer insert(QuotationsNewVo quotationsNewVo){
        Integer num = 0;

        BigDecimal mm = new BigDecimal(quotationsNewVo.getMoney());
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
            List<ProductVo> list = quotationsNewVo.getProduct();
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
