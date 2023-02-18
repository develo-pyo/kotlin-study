package basic

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
