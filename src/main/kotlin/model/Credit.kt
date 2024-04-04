package model

data class Credit(
    val creditExist: Boolean,
    val creditCount: Int,
    val debtCreditExist: Boolean,
    val debtCreditCost: Double
    ) {}