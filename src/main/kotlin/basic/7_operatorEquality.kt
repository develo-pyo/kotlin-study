package basic

import Money

fun main() {
    /**
     * Java와 달리 객체 비교시 비교 연산자를 사용하면 자동으로 compareTo 호출
     * */
    val money1 = Money(1_000L)
    val money2 = Money(2_000L)

    if(money1 > money2) {   // '>' 부등호를 따라가보면 compareTo 자동 호출임을 확인 가능
        println("money1 이 money2 보다 큼")
    }

    equality()
    operatorOverroading()
}

/**
 * 동일성 (Equality) / 동등성 (Identity)
 * Java : 동일성에 ==, 동등성에 equals
 * Kotlin : 동일성 === , 동등성 == (equals)
 * */
fun equality() {
    val money1 = Money(1_000L)
    val money2 = Money(1_000L)
    println(money1 == money2)   // == 클릭시 오버라이딩 된 equals 를 호출함을 확인 할 수 있음
}


fun operatorOverroading() {
    val money1 = Money(1_000L)
    val money2 = Money(2_000L)
    println((money1 + money2).amount)   // + 클릭시 plus 를 호출함을 확인 할 수 있음
}


