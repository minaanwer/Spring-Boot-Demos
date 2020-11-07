package ebc.demo.helpers.entities;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Setter
@Builder
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(schema = "dbo", name = "\"PayTrasnaction\"")
public class PayTransaction implements Serializable {

    @Column(name = "\"Id\"")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @OneToOne
    @JoinColumn(name = "\"PayerBanKId\"")
    private BankEntity payerBank;


    @OneToOne
    @JoinColumn(name = "\"PayeeBanKId\"")
    private BankEntity payeeBank;


    @OneToOne
    @JoinColumn(name = "\"PayerPSPBankId\"")
    private BankEntity payerPSPBank;

    @OneToOne
    @JoinColumn(name = "\"PayeePSPBankId\"")
    private BankEntity payeePSPBank;


    @OneToOne
    @JoinColumn(name = "\"PayerPSPId\"")
    private PSP payerPSP;

    @OneToOne
    @JoinColumn(name = "\"PayeePSPId\"")
    private PSP payeePSP;

    @Column(name = "\"TxnId\"",unique = true)
    private UUID txnId;




    @Column(name = "\"SwitchDate\"")
    private LocalDate switchDate;

    @Column(name = "\"Version\"", length = 5)
    private String version;



    @Column(name = "\"TxnTimeStamp\"")
    private LocalDateTime txnTimeStamp;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "\"TxnType\"")
    private TransactionType txnType;






    @Column(name = "\"Amount\"", columnDefinition = "Decimal(17,2)")
    private BigDecimal amount;

    @Column(name = "\"Currency\"", length = 3)
    private String currency;

    @Column(name = "\"SettlementAmount\"", columnDefinition = "Decimal(17,2)")
    private BigDecimal settlementAmount;

    @Column(name = "\"SettlementCurrency\"", length = 3)
    private String settlementCurrency;

    @Column(name = "\"ConversionRate\"", columnDefinition = "Decimal(17,2)")
    private BigDecimal conversionRate;


    @Column(name = "\"PSPFeesAmount\"", columnDefinition = "Decimal(17,2)")
    private BigDecimal pspFeesAmount;

    @Column(name = "\"PSPFeesCurrency\"", length = 3)
    private String pspFeesCurrency;


    @Column(name = "\"BankFeesAmount\"", columnDefinition = "Decimal(17,2)")
    private BigDecimal bankFeesAmount;

    @Column(name = "\"BankFeesCurrency\"", length = 3)
    private String bankFeesCurrency;


    @Column(name = "\"InterchangeCurrency\"", length = 3)
    private String interchangeCurrency;

    @Column(name = "\"PayerBankInterchangeAmount\"", columnDefinition = "Decimal(17,2)")
    private BigDecimal payerBankInterchangeAmount;

    @Column(name = "\"PayerBankInterchangeAction\"", length = 10)
    private String payerBankInterchangeAction;

    @Column(name = "\"PayeeBankInterchangeAmount\"", columnDefinition = "Decimal(17,2)")
    private BigDecimal payeeBankInterchangeAmount;

    @Column(name = "\"PayeeBankInterchangeAction\"", length = 10)
    private String payeeBankInterchangeAction;

    @Column(name = "\"PayerPSPBankInterchangeAmount\"", columnDefinition = "Decimal(17,2)")
    private BigDecimal payerPSPBankInterchangeAmount;

    @Column(name = "\"PayerPSPBankInterchangeAction\"", length = 10)
    private String payerPSPBankInterchangeAction;

    @Column(name = "\"PayeePSPBankInterchangeAmount\"", columnDefinition = "Decimal(17,2)")
    private BigDecimal payeePSPBankInterchangeAmount;

    @Column(name = "\"PayeePSPBankInterchangeAction\"", length = 10)
    private String payeePSPBankInterchangeAction;

    @Column(name = "\"Result\"", length = 10)
    private String result;

    @Column(name = "\"ResponseCode\"", length = 5)
    private String responseCode;


    @Column(name = "\"BearFeesAmount\"", columnDefinition = "Decimal(17,2)")
    private BigDecimal BearFeesAmount;

    @Column(name = "\"BearFeesCurrency\"", length = 3)
    private String BearFeesCurrency;

    @Column(name = "\"PayerMobileNumber\"", length = 14)
    private String payerMobileNumber;

    @Column(name = "\"PayerIPA\"", length = 100)
    private String payerIPA;

    @Column(name = "\"PayerName\"", length = 100)
    private String payerName;

    @Column(name = "\"PayerAccountUniqueIdentifier\"")
    private UUID payerAccountUniqueIdentifier;

    @Column(name = "\"PayerIdentificationType\"", length = 8)
    private String payerIdentificationType;

    @Column(name = "\"PayerIdentificationNumber\"", length = 30)
    private String payerIdentificationNumber;

    @Column(name = "\"PayeeMobileNumber\"", length = 14)
    private String payeeMobileNumber;

    @Column(name = "\"PayeeIPA\"", length = 100)
    private String payeeIPA;

    @Column(name = "\"PayeeAccountUniqueIdentifier\"")
    private UUID payeeAccountUniqueIdentifier;

    @Column(name = "\"PayeeIdentificationType\"", length = 8)
    private String payeeIdentificationType;

    @Column(name = "\"PayeeIdentificationNumber\"", length = 30)
    private String payeeIdentificationNumber;

    @Column(name = "\"TerminalLocation\"", length = 40)
    private String terminalLocation;

    @Column(name = "\"TerminalLongitude\"", length = 15)
    private String terminalLongitude;

    @Column(name = "\"TerminalLatitude\"", length = 15)
    private String terminalLatitude;

    @Column(name = "\"TransactionRemark\"", length = 100)
    private String transactionRemark;

    @Column(name = "\"PayeeName\"", length = 100)
    private String payeeName;

    @Column(name = "\"SettlementCycleId\"", length = 10)
    private String settlementCycleId;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "\"BusinessType\"")
    private BusinessType businessTxnType;

    @Column(name = "\"ProcessingFeesAmount\"", columnDefinition = "Decimal(17,2)")
    private BigDecimal processingFeesAmount;

    @Column(name = "\"ProcessingFeesCurrency\"", length = 3)
    private String processingFeesCurrency;


}