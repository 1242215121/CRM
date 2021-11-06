package com.study.controller.aftersale;

import com.study.model.services.aftersale.AttachmentService;
import com.study.utils.MyResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Repository
@RequestMapping("/llw")
@RestController
public class AttachmentController {
    @Autowired
    AttachmentService attachmentService;

    //附件资料查询
    @RequestMapping("fjzl")
    public MyResult getfj(String nr){
        return MyResult.SUCCESS_Object(attachmentService.fjzlcx(nr));
    }
}
