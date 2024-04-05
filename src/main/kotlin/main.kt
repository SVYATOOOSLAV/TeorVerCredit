import model.Calculator
import java.text.DecimalFormat
import java.util.*


val scanner: Scanner = Scanner(System.`in`)
fun main(){
//    print("Введите сумму кредита (млн руб): ")
//    val l: Double = scanner.nextDouble() * 1_000//  losses
//    print("Вероятность невозврата долга (процент): ")
//    val p: Double =  scanner.nextDouble() / 100 // probability
//
//    val el = p * l // ожидаемые потери банка
//    val r: Double = (el / (l * (1-p))) * 100 // ставка
//
//    println("Необходимо выдать кредит со ставкой равной ${"%.2f".format(r)}%")
    val entryPoint = EntryPoint()
    val calculator = Calculator(entryPoint.readValueFromTerminal())
    val default = "%.2f".format(calculator.calculateProbabilityDefault()*100).replace(',','.').toDouble() //в процентах
    if(default <= 20){
        println("\nВероятность дефолта = $default%")
        println("Кредит можно успешно взять со ставкой ${calculator.calculateCreditRate(default/100, calculator.client.desiredCredit)}%")
    }
    else{
        println("\nВероятность дефолта = ${"%.2f".format(default * 100)}%")
        println("Отказ в кредите")
    }

}
