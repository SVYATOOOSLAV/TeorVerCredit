package model

class ProbabilityConstants {
    companion object{
        val plusIncomeAndCredit = 0.4272
        val minusIncomeAndCredit = 0.3524
        val plusCreditDoesNotExist = 0.1545
        val plusDebtCreditDoesNotExist = 0.1225
        val minusDebtCreditGraterThanBorder = 0.0342
        val plusDebtCreditSmallerThanBorder = 0.0652
        val minusOtherDebt = 0.1564
        val plusOtherDebt = 0.1496
        val plusWithoutOtherDebt = 0.1987
        val plusDebitCard = 0.1055
        val plusCollateralCoverage = 0.1496
        val plusCreditCard = 0.07455
        val minusCreditCard = 0.1556

        val percentForOtherDebtBorder = 12
        val percentForCreditDebtBorder = 15
        val percentCoverageCreditByDeposit = 10
    }
}