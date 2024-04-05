package model

data class Credit(
    val creditExist: Boolean,
    val creditSum: Double,
    val debtCreditExist: Boolean,
    val debtCreditCost: Double
) {}