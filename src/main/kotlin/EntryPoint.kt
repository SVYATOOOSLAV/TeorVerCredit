import model.*
import java.util.Scanner

class EntryPoint {
    private val scanner = Scanner(System.`in`)
    fun readValueFromTerminal(): Client {
        println("В случае, если параметра нет, то указывайте значение 0. y - yes(да); n - no(нет)")
        print("Введите сумму кредита (полная стоимость в руб): ")
        val desiredCredit: Double = scanner.nextLine().toDouble()
        print("Ежемесячный доход (полная стоимость в руб): ")
        val income = scanner.nextLine().toDouble()
        val credit = getCreditInfo()
        val otherDebt = getOtherDebtInfo()
        print("Есть ли дебетовая карта банка? (y/n): ")
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
        var creditSum = 0.0
        var debtCreditExist = false
        var debtCreditCost = 0.0

        if (creditExist) {
            print("Введите стоимость кредита: ")
            creditSum = scanner.nextLine().toDouble()
            print("Есть ли задолженность по кредиту / кредитам? (y/n): ")
            debtCreditExist = scanner.nextLine() == "y"
            if (debtCreditExist) {
                print("На какую сумму долг по кредиту / кредитам у заемщика (полная стоимость в руб): ")
                debtCreditCost = scanner.nextLine().toDouble()
            }
        }

        return Credit(creditExist, creditSum, debtCreditExist, debtCreditCost)
    }

    private fun getOtherDebtInfo(): OtherDebt {
        print("Имеются ли у заемщика другие долги? (y/n): ")
        val otherDebtExist = scanner.nextLine() == "y"
        var otherDebtCost = 0.0
        if (otherDebtExist) {
            print("На какую сумму другие долги (полная стоимость в руб): ")
            otherDebtCost = scanner.nextLine().toDouble()
        }
        return OtherDebt(otherDebtExist, otherDebtCost)
    }

    private fun getInfoAboutDeposit(): Deposit {
        print("Есть ли накопительный счет / вклад в банке? (y/n): ")
        val depositExist = scanner.nextLine() == "y"
        var depositCost = 0.0
        if (depositExist) {
            print("Какая сумма лежит на вкладе / накопительном счете? (полная стоимость в руб): ")
            depositCost = scanner.nextLine().toDouble()
        }
        return Deposit(depositExist, depositCost)
    }

    private fun getInfoAboutCreditCard(): CreditCard {
        print("Есть ли кредитная карта банка? (y/n): ")
        val creditCardExist = scanner.nextLine() == "y"
        var debtCreditCardExist = false
        if (creditCardExist) {
            print("Есть ли задолженность по кредитной карте? (y/n): ")
            debtCreditCardExist = scanner.nextLine() == "y"
        }
        return CreditCard(creditCardExist, debtCreditCardExist)
    }
}
