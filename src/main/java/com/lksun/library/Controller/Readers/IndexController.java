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

import javax.servlet.http.HttpSession;
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
        map.put("pageResult",pageResult);
        return "/reader/index";
    }

    @RequestMapping(value = "get/{id}",method = RequestMethod.GET)
    public String getReader(@PathVariable("id") Integer id){
        Reader reader = readerService.getById(id);
        return "/reader/index";
    }

    @RequestMapping(value = "create",method = RequestMethod.GET)
    public String create(){
        return "/reader/create";
    }

    @RequestMapping(value = "create/action",method = RequestMethod.GET)
    public String createAction(Reader reader,Map<String,Object> map){
        try{
            int result = readerService.createReader(reader);
            if(result > 0){
                map.put("message","添加成功...");
                map.put("url","/reader/");
                return "common/success";
            }else{
                throw new Exception();
            }
        }catch (Exception e){
            map.put("message","添加失败...");
            map.put("url","/reader/");
            return "common/error";
        }


    }
}
