import model.Calculator
fun main(){
    val entryPoint = EntryPoint()
    val calculator = Calculator(entryPoint.readValueFromTerminal())
    val default = "%.2f".format(calculator.calculateProbabilityDefault()*100)
        .replace(',','.').toDouble() //в процентах
    if(default <= 30){
        println("\nВероятность дефолта = $default%")
        println("Кредит можно успешно взять со ставкой ${"%.2f".format(calculator.calculateCreditRate(default/100,
            calculator.client.desiredCredit))}%")
    }
    else{
        println("\nВероятность дефолта = ${"%.2f".format(default)}%")
        println("Отказ в кредите")
    }
}
