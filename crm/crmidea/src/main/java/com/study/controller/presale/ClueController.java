package com.study.controller.presale;

import com.study.model.pojo.presale.Clue;
import com.study.model.services.presale.ClueService;
import com.study.utils.MyResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("clue")
public class ClueController {
    MyResult myResult =new MyResult();
    @Autowired
    ClueService clueService;

    @RequestMapping("/selectClue")
    public MyResult selectClue(@RequestBody Clue clue){
        System.out.println(clue);
        return MyResult.SUCCESS_Object(clueService.selectClueByPage(clue.getPageNo(),clue.getSize(),
                clue.getClueName()));
    }

    @GetMapping
    public MyResult seClue(){
        return MyResult.SUCCESS_DATA(clueService.seClue());
    }
}
