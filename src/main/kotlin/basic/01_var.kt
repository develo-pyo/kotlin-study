package basic

fun main() {
    /**
     * var 은 가변
     * val 은 불변
     * */
    var number1 = 1
    number1 = 2

    val number2 = 2
    //number2 = 3  //에러

    /**
     * 1. 선언시 타입을 명시하지 않으면 에러
     * 2. 선언시 타입을 선언했지만 초기화 하지 않은 상태로 사용시 에러
     * 3. val 은 불변 변수이나 최초 선언 1번은 가능
     */
    val number3: Long
    //println(number3)    //에러

    val number3_1: Long
    number3_1 = 1
    println(number3_1)

    /**
     * val 로 변수 선언 후, 변경이 필요한 경우에만 var 로 수정하는 방향으로 개발
     * */

    /** 인스턴스 생성시 new 키워드 사용하지 않음 */
    var obj = Object()

}
