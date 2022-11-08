package cm.django.bankaccountservice;

import cm.django.bankaccountservice.entities.BankAccount;
import cm.django.bankaccountservice.enums.AccountType;
import cm.django.bankaccountservice.repositories.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
public class BankAccountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankAccountServiceApplication.class, args);
	}

   @Bean
   CommandLineRunner start(BankAccountRepository bankAccountRepository){
		return  args -> {
			for (int i = 0; i < 10; i ++){
				BankAccount bankAccount =BankAccount.builder()
						.id(UUID.randomUUID().toString())
						.type(Math.random()>0.5? AccountType.CURRENT_ACCOUNT:AccountType.SAVING_ACCOUNT)
						.balance(10000+Math.random()*9000)
						.createdAt(new Date())
						.currency("EUR")
						.build();

				bankAccountRepository.save(bankAccount);
			}
		};
   }
}
