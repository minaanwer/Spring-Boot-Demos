package ebc.demo.helpers.entities;


public enum TransactionType {
    ListPSP,
    ListBanks,
    ListAccounts,
    GenOTP,
    SETIPNPIN,
    Heartbeat,
    ChangeIPNPIN,
    BalInq,
    VerifyCustomerIPA,
    SetGlobalIdentifier,
    ManageVerifiedMerchants,
    PAY, R2P, DEBIT, CREDIT, REVERSAL, REFUND,
    ATMCASHIN,
    ATMCASHOUT,
    CREATE, UPDATE, REVOKE,
    AccountTransactionsInquiry,
    GlobalIdentifierInquiry,
    IPAInquiry, MobInquiry,
    BankFeesInquiry,
    VerifiedMerchantsInquiry,
    ListIPNKeys,
    GetSecurityToken,
    ListPSPKeys,
    ManageMemberKeys;
}