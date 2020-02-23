package com.lksun.library.Controller;

import com.lksun.library.Dao.UserRepository;
import com.lksun.library.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("")
    public String index(){
        return "register";
    }

    @RequestMapping(value = "action",method = RequestMethod.GET)
    public String action(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("confirmPassword") String confirmPassword, Map<String,Object> map){
        // 判断两次密码是否相同
        if (!password.equals(confirmPassword)) {
            map.put("message","两次密码不同请重试...");
            map.put("url","/register");
            return "common/error";
        }
        // 判断用户名是否重复
        User findUser = userRepository.findByUsername(username);
        if (findUser != null){
            map.put("message","用户名重复...");
            map.put("url","/register");
            return "common/error";
        }
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        userRepository.save(user);
        map.put("message","注册成功...");
        map.put("url","/login");
        return "common/success";
    }
}
