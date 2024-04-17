package edu.guopengl.controller;

import edu.guopengl.controller.response.Response;
import edu.guopengl.entity.User;
import edu.guopengl.params.LoginParams;
import edu.guopengl.service.UserService;
import edu.guopengl.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Response login(@RequestBody LoginParams request, HttpSession httpSession){
        Response res =  new Response();
        try{
            User user = userService.findByNameAndPassword(request);
            if(user == null){
                res.setErr(true);
                res.setMessage("username or password wrong");
                return res;
            }
            String token = JWTUtil.generateJWT(user);
            if(token == null){
                res.setErr(true);
                res.setMessage("wrong token");
                return res;
            }
            httpSession.setAttribute("token", token);
        } catch (Exception e){
            res.setErr(true);
            res.setMessage(e.getMessage());
        }
        return res;
    }

    @PostMapping("/register")
    public Response register(){
        return null;
    }

    @PostMapping("/logout")
    public Response logout(){
        return null;
    }

}
