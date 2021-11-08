package com.study.controller.presale;

import com.study.model.pojo.presale.Clue;
import com.study.model.services.presale.ClueService;
import com.study.utils.MyResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


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
    @PostMapping("inClue")
    public MyResult inClue(@RequestBody Clue clue){
        System.out.println("新增"+clue);
        Integer a = clueService.inClue(clue);
        if (a>0){
            myResult.setCode(1);
            System.err.println("新增成功");
            return MyResult.SUCCESS;
        }
        return MyResult.FAILURE("新增失败");
    }
}
