package cm.django.bankaccountservice.entities;

import cm.django.bankaccountservice.enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
@Builder
public class BankAccount {

    @Id
    private String id;

    private Date createdAt;
    private Double balance;

    private String currency;

    private AccountType type;

}
