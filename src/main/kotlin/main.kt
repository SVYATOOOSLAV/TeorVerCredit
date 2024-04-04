import java.text.DecimalFormat
import java.util.*


val scanner: Scanner = Scanner(System.`in`)
fun main(){
    print("Введите сумму кредита (млн руб): ")
    val l: Double = scanner.nextDouble() * 1_000_000 //  losses
    print("Вероятность невозврата долга (процент): ")
    val p: Double =  scanner.nextDouble() / 100 // probability

    val el = p * l // ожидаемые потери банка
    val r: Double = (el / (l * (1-p))) * 100 // ставка

    println("Необходимо выдать кредит со ставкой равной ${"%.2f".format(r)}%")
}

