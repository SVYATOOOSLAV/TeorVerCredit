package model

data class CreditCard(
    val creditCardExist: Boolean,
    val debtCreditCardExist: Boolean,
    val debtCreditCardCost: Double
) {
}