package edu.zju.cst.bookstore.service;

import edu.zju.cst.bookstore.dto.AccountForm;
import edu.zju.cst.bookstore.mbg.model.Account;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author 方康华
 * @description TODO
 * @date 2019/10/3 8:41
 */
public interface UserService {

    Account userRegister(AccountForm account);

    String userLogin(Account account, HttpServletResponse response);

    List<Account> queryUsers(Account account);

    Integer auditUser(List<String> accountIds, Boolean accept);
}
