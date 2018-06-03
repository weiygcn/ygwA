package com.ygw;

import core.ActionCode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import rto.LoginRTO;
import rvo.LoginRVO;
import rvo.RVO;

import javax.validation.Valid;

@Controller
@RequestMapping("user")
public class UserController {
    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public RVO login(@RequestBody @Valid LoginRTO login) {
        if (!login.getNickname().equals("admin") || !login.getPassword().equals("123")) {
            return new RVO<>("用户密码错误");
        }
        LoginRVO rvo = new LoginRVO();
        rvo.setUser_id(1);
        rvo.setNickname(login.getNickname());
        return new RVO<>(ActionCode.SUCCESS, rvo);
    }
}
