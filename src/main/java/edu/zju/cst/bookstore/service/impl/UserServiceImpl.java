package edu.zju.cst.bookstore.service.impl;

import edu.zju.cst.bookstore.dto.Audit;
import edu.zju.cst.bookstore.dto.AccountForm;
import edu.zju.cst.bookstore.mbg.mapper.AccountMapper;
import edu.zju.cst.bookstore.mbg.model.Account;
import edu.zju.cst.bookstore.mbg.model.AccountExample;
import edu.zju.cst.bookstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

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
    public Account userRegister(AccountForm accountForm) {
        AccountExample example = new AccountExample();
        AccountExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(accountForm.getUsername());
        if(Objects.nonNull(accountMapper.selectByExample(example))) {

        }
        Account account = buildAccount(accountForm);
        accountMapper.insertSelective(account);
        return account;
    }

    /**
     * 构造account
     * @param accountForm
     * @return
     */
    private Account buildAccount(AccountForm accountForm) {
        Account account = new Account();
        account.setUsername(accountForm.getUsername());
        account.setPassword(accountForm.getPassword());
        account.setName(accountForm.getName());
        account.setGender(accountForm.getGender());
        account.setAge(accountForm.getAge());
        account.setEmail(accountForm.getEmail());
        account.setMobile(accountForm.getMobile());
        account.setOrgId(accountForm.getOrgId());
        account.setAudit(Audit.notAudit);
        account.setUserType(accountForm.getUserType());
        return account;
    }
}
