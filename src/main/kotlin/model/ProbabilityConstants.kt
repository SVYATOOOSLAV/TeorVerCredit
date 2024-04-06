package model

class ProbabilityConstants {
    companion object{
        val plusIncomeAndCredit = 0.3723
        val minusIncomeAndCredit = 0.4264
        val plusCreditDoesNotExist = 0.1745
        val plusDebtCreditDoesNotExist = 0.2325
        val minusDebtCreditGraterThanBorder = 0.3342
        val plusDebtCreditSmallerThanBorder = 0.1352
        val minusOtherDebt = 0.2464
        val plusOtherDebt = 0.1346
        val plusWithoutOtherDebt = 0.2547
        val plusDebitCard = 0.1355
        val plusCollateralCoverage = 0.2546
        val plusCreditCard = 0.1455
        val minusCreditCard = 0.2556

        val percentForOtherDebtBorder = 15
        val percentForCreditDebtBorder = 18
        val percentCoverageCreditByDeposit = 20
    }
}