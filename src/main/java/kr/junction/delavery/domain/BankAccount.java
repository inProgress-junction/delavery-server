package kr.junction.delavery.domain;

import jakarta.persistence.*;
import kr.junction.delavery.common.base.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class BankAccount extends BaseTimeEntity {

    @Id
    private String id;

    private String userId;

    private Integer money;

    private Integer accountNumber;

    @Enumerated(EnumType.STRING)
    private BankType bankType;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private BankAccountType bankAccountType;

    public BankAccount addMoney(Integer money) {
        this.money += money;
        return this;
    }

    public BankAccount subtractMoney(Integer money) {
        this.money -= money;
        return this;
    }

    @Builder
    public BankAccount(String id, String userId, Integer money, Integer accountNumber, BankType bankType, BankAccountType bankAccountType) {
        this.id = id;
        this.userId = userId;
        this.money = money;
        this.accountNumber = accountNumber;
        this.bankType = bankType;
        this.bankAccountType = bankAccountType;
    }

}
