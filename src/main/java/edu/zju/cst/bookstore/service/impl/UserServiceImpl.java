package edu.zju.cst.bookstore.service.impl;

import edu.zju.cst.bookstore.common.exception.BizServiceException;
import edu.zju.cst.bookstore.common.utils.RedisUtil;
import edu.zju.cst.bookstore.dto.Audit;
import edu.zju.cst.bookstore.dto.AccountForm;
import edu.zju.cst.bookstore.mbg.mapper.AccountMapper;
import edu.zju.cst.bookstore.mbg.model.Account;
import edu.zju.cst.bookstore.mbg.model.AccountExample;
import edu.zju.cst.bookstore.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * @author 方康华
 * @description TODO
 * @date 2019/10/3 8:42
 */
@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private AccountMapper accountMapper;

    /**
     * 用户注册
     * @param accountForm
     * @return
     */
    @Override
    public Account userRegister(AccountForm accountForm) {
        //检查不可重复选项
        AccountExample example = new AccountExample();
        example.or().andUsernameEqualTo(accountForm.getUsername());
        example.or().andEmailEqualTo(accountForm.getEmail());
        example.or().andMobileEqualTo(accountForm.getMobile());
        example.or().andNameEqualTo(accountForm.getName());
        if(accountMapper.selectByExample(example).size() != 0) {
            throw new BizServiceException("User.Already.Exist");
        }
        Account account = buildAccount(accountForm);
        accountMapper.insertSelective(account);
        return account;
    }

    /**
     * 用户登录
     * @param account
     * @return
     */
    @Override
    public String userLogin(Account account, HttpServletResponse response) {
        AccountExample example = new AccountExample();
        example.or().andUsernameEqualTo(account.getUsername());
        List<Account> accounts = accountMapper.selectByExample(example);
        String sessionId = "";
        if(accounts.size() != 1) {
            throw new BizServiceException("User.NotFound");
        } else {
            if(accounts.get(0).getPassword() != account.getPassword()) {
                throw new BizServiceException("User.PassWord.Error");
            }

            // 生成一个session id，保存在redis中
            sessionId = UUID.randomUUID().toString();
            RedisUtil.setString(sessionId, account.getUsername(), 2 * RedisUtil.EXRPIRE_HOUR);
            Cookie cookie = new Cookie("session-id", sessionId);
            response.addCookie(cookie);
        }
        return sessionId;
    }

    @Override
    public List<Account> queryUsers(Account account) {
        AccountExample example = new AccountExample();
        AccountExample.Criteria criteria =example.createCriteria();

        if(Objects.nonNull(account)) {
            if(Objects.nonNull(account.getAvailable())) {
                criteria.andAvailableEqualTo(account.getAvailable());
            }
            else if(StringUtils.isNotBlank(account.getUsername())) {
                criteria.andUsernameEqualTo(account.getUsername());
            }
            else if(StringUtils.isNotBlank(account.getName())) {
                criteria.andNameEqualTo(account.getName());
            }
            else if(Objects.nonNull(account.getGender())) {
                criteria.andGenderEqualTo(account.getGender());
            }
            else if(Objects.nonNull(account.getAge())) {
                criteria.andAgeEqualTo(account.getAge());
            }
            else if(StringUtils.isNotBlank(account.getEmail())) {
                criteria.andEmailEqualTo(account.getEmail());
            }
            else if(StringUtils.isNotBlank(account.getMobile())) {
                criteria.andMobileEqualTo(account.getMobile());
            }
            else if(StringUtils.isNotBlank(account.getOrgId())) {
                criteria.andMobileEqualTo(account.getOrgId());
            }
            else if(Objects.nonNull(account.getAudit())) {
                criteria.andAuditEqualTo(account.getAudit());
            }
            else if(Objects.nonNull(account.getUserType())) {
                criteria.andUserTypeEqualTo(account.getUserType());
            }
        }
        List<Account> accounts = accountMapper.selectByExample(example);
        return accounts;
    }

    /**
     * 用户审核
     * @param accountIds
     * @param accept
     * @return
     */
    @Override
    public Integer auditUser(List<String> accountIds, Boolean accept) {
        AccountExample example = new AccountExample();
        AccountExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(accountIds).andAuditEqualTo(Audit.notAudit);

        Account account = new Account();
        if(accept) {
            account.setAudit(Audit.accepted);
        }
        else {
            account.setAudit(Audit.rejected);
        }
        int record = accountMapper.updateByExampleSelective(account, example);

        return record;
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
