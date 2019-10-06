package edu.zju.cst.bookstore.controller;

import edu.zju.cst.bookstore.common.api.CommonResult;
import edu.zju.cst.bookstore.dto.AccountForm;
import edu.zju.cst.bookstore.mbg.model.Account;
import edu.zju.cst.bookstore.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 方康华
 * @description 用户管理模块
 * @date 2019/10/3 0:03
 */
@RestController
@RequestMapping("/user")
@Api(tags = "UserController", description = "用户管理模块")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/register")
    public CommonResult<Account> userRegister(AccountForm accountForm) {
        Account account = userService.userRegister(accountForm);
        return CommonResult.success(account);
    }

}
