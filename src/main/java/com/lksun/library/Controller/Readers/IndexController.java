package com.lksun.library.Controller.Readers;

import com.lksun.library.Service.ReaderService;
import com.lksun.library.entity.Page.PageRequest;
import com.lksun.library.entity.Page.PageResult;
import com.lksun.library.entity.Reader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;
import java.util.Map;

@Controller("ReadsIndexController")
@RequestMapping("/reader")
public class IndexController {

    @Autowired
    private  ReaderService readerService;

    @RequestMapping(value = "",method = RequestMethod.GET)
    public String list(PageRequest pageRequest, Map<String,Object> map){
        List<Reader> readerList = readerService.get(pageRequest);
        PageResult pageResult = new PageResult(readerList,pageRequest,readerService.getCount());
        System.out.println(pageResult.toString());
        map.put("list",readerList);
        return "/reader/index";
    }

    @RequestMapping(value = "get/{id}",method = RequestMethod.GET)
    public String getReader(@PathVariable("id") Integer id){
        Reader reader = readerService.getById(id);
        return "/reader/index";
    }
}
