package ebc.demo.helpers.entities;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Setter
@Builder
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(schema = "dbo", name = "\"ReturnRequest\"")
public class ReturnRequest {

    @Id
    @Column(name = "\"Id\"")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    @JoinColumn(name = "transactionId")
    private PayTransaction transaction;

    @Column(name = "\"CreationDate\"", nullable = false)
    private LocalDate creationDate;


    @Column(name="\"creationDateTime\"",nullable = false)
    private LocalDateTime CreationDateTime;



    @Column(name = "\"CreatorUserId\"", nullable = false)
    private long creatorUserId;

    @Column(name = "\"CreatorUsername\"", nullable = false)
    private String creatorUsername;

    @OneToOne
    @JoinColumn(name = "\"CreatorBankId\"")
    private BankEntity creatorBank;

    @OneToOne
    @JoinColumn(name = "\"PayerBankId\"")
    private BankEntity payerBank;


    @Column(name="\"Amount\"",nullable = false)
    private BigDecimal amount;

    @Column(name="\"currency\"",nullable = false)
    private String  currency;


    @Column(name="\"SettlementCycleId\"",nullable = true)
    private String  settlementCycleId;


    @Column(name="\"SettlementDate\"",nullable = true)
    private String  settlementDate;


    @Enumerated(value = EnumType.STRING)
    @Column(name = "\"ReturnRequestStatus\"")
    private ReturnRequestStatus returnRequestStatus;





}
