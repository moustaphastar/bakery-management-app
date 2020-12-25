package com.cayirozu.accounting;

import com.cayirozu.db.entity.CashAccount;
import com.cayirozu.db.entity.Merchant;
import com.cayirozu.repository.CashAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/demo", produces = MediaType.APPLICATION_JSON_VALUE)
public class ApiController {
    private final CashAccountRepository accountRepository;

    public ApiController(CashAccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    //private AccountHome accountHome;

//    @GetMapping(path="/get/{id}")
//    @Transactional
//    public @ResponseBody
//    ResponseEntity getAccount (@PathVariable Integer id) {
//    //CashAccount getAccount (@RequestParam Integer id) {
//        Optional<CashAccount> account = accountRepository.findById(id);
//        assert account.orElse(null) != null;
//        Merchant merchant = account.orElse(null).getMerchant();
//        //Account account = accountHome.findById(id);
//        return account.orElse(null);
//    }

    @GetMapping(path="/all")
    @ResponseBody
    public List<CashAccount> getAllUsers() {
        //return result;
        return accountRepository.findAll();
    }
}
