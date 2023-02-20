package basic

/**
 * 1. static 사용하는 중첩 클래스
 * 2. static 사용하지 않는 중첩 클래스
 *      1) Inner class  클래스 안에 클래스 : 안쪽에서 바깥 쪽 직접 참조 가능
 *      2) Local class  메소드 내에 클래스 정의
 *      3) Anonymous class
 * */

/**
 * < Inner class 문제점 >
 *      1. 내부 클래스는 숨겨진 외부 클래스 정보를 가지고 있어, 참조를 해지하지 못하는 경우 메모리 누수가 생길 수 있고,
 *          이를 디버깅 하기 어렵다
 *      2. 내부 클래스의 직렬화 형태가 명확하게 정의되지 않아 직렬화에 있어 제한이 있다
 *  => 클래스 안에 클래스를 만들 때는 내부클래스에 static 을 사용하라는 effective java 가이드가 있음
 * */
fun main() {
    val h = House("10", House.LivingRoom(20.0))

    var h2 = House2("15")
    println(h2.livingRoom.address)
}

class House(
    private val address: String,
    private val livingRoom: LivingRoom = LivingRoom(10.0),
) {
    /** kotlin 에서는 기본적으로 바깥 클래스에 대한 연결이 없는 중첩 클래스가 만들어진다
     * */
    class LivingRoom(
        private val area: Double
    ) {
        val address: String
            get() {
                println(this.address)
                return this.address
            }
    }
}


class House2(
    private val address: String,
) {
    /** kotlin 에서는 기본적으로 바깥 클래스에 대한 연결이 없는 중첩 클래스가 만들어진다
     * => 바깥클래스(House) 를 참조하고 싶으면 inner class에 'inner'키워드를 붙여주어야 한다
     * => 바깥클래스를 참조하려면 'this@바깥클래스'를 참조해야 한다
     * */
    var livingRoom = this.LivingRoom(10.0)

    inner class LivingRoom(
        private val area: Double
    ) {
        val address: String
            get() = this@House2.address
    }
}



