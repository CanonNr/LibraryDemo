package com.lksun.library.Controller.Readers;

import com.lksun.library.Service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller("ReadsIndexController")
@RequestMapping("/reader")
public class IndexController {

    private final ReaderService readerService;

    public IndexController(ReaderService readerService) {
        this.readerService = readerService;
    }

    @RequestMapping(value = "",method = RequestMethod.GET)
    public String list(){
        System.out.println(readerService.get());
        return "/reader/index";
    }
}
