package basic

/**
 * kotlin 에서의 backing field 란?
 * https://manorgass.tistory.com/80
 *
 * 필드 : 클래스 내 맴버변수
 * 프로퍼티 : 필드 + 게터 + 세터
 *
 * kotlin에선 멤버변수를 프로퍼티라 칭한다. ( 자동으로 val (getter) , var (getter,setter) 생성해주므로)
 * 프로퍼티 값을 저장하는 필드(멤버변수) 를 코틀린에선 backing field 라고 부름
 * */

interface Flyable {
    /** default method : default 키워드 생략 */
    fun act() {
        println("난다")
    }
}

interface  Swimable {
    /** backing field 가 없는 프로퍼티를 interface 에 만들 수 있다 */
    /** swimAbility 초기값 1 로.. */
    val swimAbility: Int
        get() = 1

    fun act() {
        println("수영한다")
    }
}
