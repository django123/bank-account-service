package cm.django.bankaccountservice.web;

import cm.django.bankaccountservice.entities.BankAccount;
import cm.django.bankaccountservice.repositories.BankAccountRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class AccountRestController {


    private final BankAccountRepository bankAccountRepository;

    public AccountRestController(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    @GetMapping("/bankAccounts")
    public List<BankAccount> bankAccounts(){
        return bankAccountRepository.findAll();
    }

    @GetMapping("/bankAccounts/{id}")
    public BankAccount bankAccount(@PathVariable String id){
        return bankAccountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Account %s not found",id)));
    }

    @PostMapping("/bankAccounts/save")
    public BankAccount save(@RequestBody BankAccount bankAccount){
        return bankAccountRepository.save(bankAccount);
    }


    @PutMapping("/bankAccounts/update/{id}")
    public BankAccount update(@PathVariable String id,@RequestBody BankAccount bankAccount){
        BankAccount account = bankAccountRepository.findById(id)
                .orElseThrow();
        account.setBalance(bankAccount.getBalance());
        account.setType(bankAccount.getType());
        account.setCurrency(bankAccount.getCurrency());
        account.setCreatedAt(new Date());
        return bankAccountRepository.save(bankAccount);
    }
}
