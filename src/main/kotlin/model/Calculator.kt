package model

class Calculator(var client: Client) {
    private var resultProbability: Double = 0.0 // min = 0% max = 100%
    private var baseRateForZeroLosses = 10.5
    private var baseRate = 12.5
    fun calculateProbabilityDefault(): Double {
        // Доход и сумма кредита
        if (client.clientInfo.income >= client.desiredCredit / 24) {
            resultProbability += ProbabilityConstants.plusIncomeAndCredit
            if(client.clientInfo.debtInfo.credit.creditExist) {
                // Долг по другим кредитам
                if (client.clientInfo.debtInfo.credit.debtCreditExist) {
                    val debtFromAnotherCreditPercent = client.clientInfo.debtInfo.credit.debtCreditCost * 100 /
                            client.clientInfo.debtInfo.credit.creditSum
                    if (debtFromAnotherCreditPercent >= ProbabilityConstants.percentForCreditDebtBorder) {
                        resultProbability -= ProbabilityConstants.minusDebtCreditGraterThanBorder
                    }
                    else{
                        resultProbability += ProbabilityConstants.plusDebtCreditSmallerThanBorder
                    }
                }
                else{
                    resultProbability += ProbabilityConstants.plusDebtCreditDoesNotExist
                }
            }
            else{
                resultProbability += ProbabilityConstants.plusCreditDoesNotExist
            }
        }
        else{
            resultProbability -= ProbabilityConstants.minusIncomeAndCredit
        }


        // Оплата по остальным долгам
        if(client.clientInfo.debtInfo.otherDebt.otherDebtExist){
            val otherDebtCost = client.clientInfo.debtInfo.otherDebt.otherDebtCost
            val percentCreditPayments = otherDebtCost * 100 / client.clientInfo.income
            if (percentCreditPayments >= ProbabilityConstants.percentForOtherDebtBorder) {
                resultProbability -= ProbabilityConstants.minusOtherDebt
            }
            else{
                resultProbability += ProbabilityConstants.plusOtherDebt
            }
        }
        else{
            resultProbability += ProbabilityConstants.plusWithoutOtherDebt
        }


        // Наличие дебетовой карты банка
        if (client.clientInfo.debitCardExist) {
            resultProbability += ProbabilityConstants.plusDebitCard
        }

        // Взять кредит с использованием залога
        if(client.clientInfo.deposit.depositExist){
            val collateralCoveragePercent = client.clientInfo.deposit.depositCost * 100 / client.desiredCredit
            if (collateralCoveragePercent >= ProbabilityConstants.percentCoverageCreditByDeposit) {
                resultProbability += ProbabilityConstants.plusCollateralCoverage
            }
        }

        // Кредитная карта банка
        if(client.clientInfo.debtInfo.creditCard.creditCardExist){
            resultProbability += ProbabilityConstants.plusCreditCard
            if(client.clientInfo.debtInfo.creditCard.debtCreditCardExist){
                resultProbability -= ProbabilityConstants.minusCreditCard
            }
        }

        if(resultProbability < 0){
            resultProbability = 0.0
        }
        else if(resultProbability > 1){
            resultProbability = 1.0
        }
        return 1 - resultProbability
    }

    fun calculateCreditRate(default: Double, desiredCredit: Double): Double{
        val losses = default * desiredCredit // ожидаемые потери банка
        if(losses == 0.0){
            return baseRateForZeroLosses
        }
        println("\nСреднее значение потерь при выдаче кредита банком: $losses")
        val rate: Double = (losses / (desiredCredit * (1-default))) * 100 // ставка
        return if(rate > baseRate) rate else (baseRate + rate)/2
    }
}
