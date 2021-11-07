package com.study.controller.presale;

import com.study.model.pojo.presale.Clue;
import com.study.model.services.presale.ClueService;
import com.study.utils.MyResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("clue")
public class ClueController {
    @Autowired
    ClueService clueService;
    @GetMapping
    public MyResult seClue(){
        return MyResult.SUCCESS_DATA(clueService.seClue());
    }
}
