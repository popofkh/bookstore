package edu.zju.cst.bookstore.service.impl;

import edu.zju.cst.bookstore.common.Audit;
import edu.zju.cst.bookstore.mbg.mapper.AccountMapper;
import edu.zju.cst.bookstore.mbg.model.Account;
import edu.zju.cst.bookstore.mbg.model.AccountExample;
import edu.zju.cst.bookstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 方康华
 * @description TODO
 * @date 2019/10/3 8:42
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public Account userRegister() {
        Account account = new Account();
        account.setUsername("fkh");
        account.setPassword("123456");
        account.setEmail("1004@qq.com");
        account.setMobile("18867151879");
        account.setAudit(Audit.notAudit);

        accountMapper.insertSelective(account);
        return account;
    }
}
