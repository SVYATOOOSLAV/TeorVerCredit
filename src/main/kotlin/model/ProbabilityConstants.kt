package model

class ProbabilityConstants {
    companion object{
        val baseProbabilityPlus = 0.15
        val baseProbabilityPlusWithCreditCard = 0.15
        val baseProbabilityPlusWithoutCredit = 0.375
        val baseProbabilityMinus = 0.325
        val baseProbabilityMinusWithCreditCard = 0.225
        val baseProbabilityMinusWithCredit = 0.425
        val baseProbabilityPlusHasDebitCard = 0.1
        val baseProbsbilityPlusWithCollateral = 0.175

        val percentForOtherDebtBorder = 15
        val percentForCreditDebtBorder = 18
        val percentCoverageCreditByDeposit = 16
    }
}