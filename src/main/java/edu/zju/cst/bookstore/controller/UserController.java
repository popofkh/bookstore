package edu.zju.cst.bookstore.controller;

import com.sun.org.apache.xpath.internal.operations.Bool;
import edu.zju.cst.bookstore.common.api.CommonResult;
import edu.zju.cst.bookstore.dto.AccountForm;
import edu.zju.cst.bookstore.mbg.model.Account;
import edu.zju.cst.bookstore.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.el.parser.BooleanNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

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

    @ApiOperation("用户注册")
    @PostMapping(value = "/register")
    public CommonResult<Account> userRegister(@RequestBody AccountForm accountForm) {
        Account account = userService.userRegister(accountForm);
        return CommonResult.success(account);
    }

    @ApiOperation("用户登录")
    @PostMapping(value = "/login")
    public CommonResult<String> userLogin(@RequestBody Account account, HttpServletResponse response) {
        String sessionId = userService.userLogin(account, response);
        return CommonResult.success(sessionId);
    }

    @ApiOperation("用户查询")
    @PostMapping(value = "/users")
    public CommonResult<List<Account>> queryUsers(@RequestBody Account account) {
        List<Account> accountList = userService.queryUsers(account);
        return CommonResult.success(accountList);
    }

    @ApiOperation("用户审核")
    @PutMapping(value = "/audit")
    public CommonResult<Integer> auditUser(@RequestBody Map data) {
        List<String> accountIds = (List<String>) data.get("accountIds");
        boolean accept = Boolean.parseBoolean((String) data.get("accept"));
        return CommonResult.success(userService.auditUser(accountIds, accept));
    }

}
