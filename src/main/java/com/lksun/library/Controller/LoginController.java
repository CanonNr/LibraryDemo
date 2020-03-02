package com.lksun.library.Controller;

import com.lksun.library.Dao.UserRepository;
import com.lksun.library.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "",method = RequestMethod.GET)
    public String index(@ModelAttribute User user){
        return "login";
    }

    @RequestMapping(value = "action",method = RequestMethod.GET)
    public String action(HttpServletRequest request, @ModelAttribute User user, Map<String,Object> map){
        Boolean validator = this.validator(user);
        if(validator){
            // 登录成功
            HttpSession session = request.getSession();
            session.setAttribute("user",user.getUsername());
            map.put("message","登录成功，等待跳转...");
            map.put("url","/");
            return "common/success";
        }else{
            // 失败
            map.put("message","账号或密码错误，请重试...");
            map.put("url","/login");
            return "common/error";
        }
    }

    private Boolean validator(User user){
        String username = user.getUsername();
        String password = user.getPassword();
        User byUsername = userRepository.findByUsername(username);
        return (byUsername != null && password.equals(byUsername.getPassword()));
    }
}
