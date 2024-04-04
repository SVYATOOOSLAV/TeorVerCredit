import model.*
import java.util.Scanner

class EntryPoint {
    private val scanner = Scanner(System.`in`)
    fun readValueFromTerminal(): Client {
        println("В случае, если параметра нет, то указывайте значение 0. y - yes(да); n - no(нет)")
        print("Введите сумму кредита (тыс руб): ")
        val desiredCredit: Double = scanner.nextDouble() * 1000
        print("Ежемесячный доход: ")
        val income = scanner.nextLine().toDouble()
        val credit = getCreditInfo()
        val otherDebt = getOtherDebtInfo()
        print("Есть ли дебетовая карта банка? (y/n)")
        val debitCardExist = scanner.nextLine() == "y"
        val deposit = getInfoAboutDeposit()
        val creditCard = getInfoAboutCreditCard()
        return Client(
            desiredCredit,
            ClientInfo(income, DebtInfo(credit, otherDebt, creditCard), debitCardExist, deposit)
        )
    }

    private fun getCreditInfo(): Credit {
        print("Есть ли кредит? (y/n): ")
        val creditExist = scanner.nextLine() == "y"
        var creditCount = 0
        var debtCreditExist = false
        var debtCreditCost = 0.0

        if (creditExist) {
            print("Введите количество кредитов: ")
            creditCount = scanner.nextInt()
            print("Есть ли задолженность по кредиту / кредитам? (y/n)")
            debtCreditExist = scanner.nextLine() == "y"
            if (debtCreditExist) {
                print("На какую сумму долг по кредиту / кредитам у заемщика: ")
                debtCreditCost = scanner.nextLine().toDouble()
            }
        }

        return Credit(creditExist, creditCount, debtCreditExist, debtCreditCost)
    }

    private fun getOtherDebtInfo(): OtherDebt {
        print("Имеются ли у заемщика долги? (y/n)")
        val otherDebtExist = scanner.nextLine() == "y"
        var otherDebtCost = 0.0
        if (otherDebtExist) {
            print("На какую сумму другие долги: ")
            otherDebtCost = scanner.nextLine().toDouble()
        }
        return OtherDebt(otherDebtExist, otherDebtCost)
    }

    private fun getInfoAboutDeposit(): Deposit {
        print("Есть ли накопительный счет / вклад в банке? (y/n)")
        val depositExist = scanner.nextLine() == "y"
        var depositCost = 0.0
        if (depositExist) {
            print("Какая сумма лежит на вкладе / накопительном счете")
            depositCost = scanner.nextLine().toDouble()
        }
        return Deposit(depositExist, depositCost)
    }

    private fun getInfoAboutCreditCard(): CreditCard {
        print("Есть ли кредитная карта банка? (y/n)")
        val creditCardExist = scanner.nextLine() == "y"
        var debtCreditCardExist = false
        var debtCreditCardCost = 0.0
        if (creditCardExist) {
            print("Есть ли задолженность по кредитной карте? (y/n)")
            debtCreditCardExist = scanner.nextLine() == "y"
            if (debtCreditCardExist) {
                print("На какую сумму задолженность по кредитной карте? ")
                debtCreditCardCost = scanner.nextLine().toDouble()
            }
        }
        return CreditCard(creditCardExist, debtCreditCardExist, debtCreditCardCost)
    }
}

fun main() {
    val entryPoint = EntryPoint()
    entryPoint.readValueFromTerminal()
}
