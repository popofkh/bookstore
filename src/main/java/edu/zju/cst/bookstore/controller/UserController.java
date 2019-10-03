package edu.zju.cst.bookstore.controller;

import edu.zju.cst.bookstore.dto.Audit;
import edu.zju.cst.bookstore.mbg.mapper.AccountMapper;
import edu.zju.cst.bookstore.mbg.model.Account;
import edu.zju.cst.bookstore.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author 方康华
 * @description 用户管理模块
 * @date 2019/10/3 0:03
 */
@Controller
@RequestMapping("/user")
@Api(tags = "UserController", description = "用户管理模块")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public Account userRegister() {
        return userService.userRegister();
    }

}
