package edu.zju.cst.bookstore;

import edu.zju.cst.bookstore.dto.Audit;
import edu.zju.cst.bookstore.mbg.mapper.AccountMapper;
import edu.zju.cst.bookstore.mbg.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookstoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookstoreApplication.class, args);
    }

}
