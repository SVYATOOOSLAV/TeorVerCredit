package model

data class ClientInfo(
    val income: Double,
    val debtInfo: DebtInfo,
    val debitCardExist: Boolean,
    val deposit: Deposit,
) {
}

data class DebtInfo(
    val credit: Credit,
    val otherDebt: OtherDebt,
    val creditCard: CreditCard
)