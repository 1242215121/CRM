package com.study.controller.aftersale;

import com.study.model.pojo.aftersale.Attachment;
import com.study.model.services.aftersale.AttachmentService;
import com.study.utils.MyResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Repository
@RequestMapping("/llw")
@RestController
public class AttachmentController {
    @Autowired
    AttachmentService attachmentService;

    //根据回款编号查询附件资料
    @RequestMapping("fjzlcx")
    public MyResult getFj(String nr){
        return MyResult.SUCCESS_Object(attachmentService.fjzlcx(nr));
    }

    @RequestMapping("fjzlxz")
    public MyResult fjzlxz(@RequestBody Attachment attachment){
        return MyResult.SUCCESS_Object(attachmentService.fjzlxz(attachment));
    }
}
