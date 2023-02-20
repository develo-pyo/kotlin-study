package basic

/** < sealed >
 * 상속이 가능하도록 추상클래스를 만들었을 때,
 * 외부에서는 이 클래스를 상속받지 않도록 할 때 사용
 * */

sealed class HyundaiCar (
    val name: String,
    val price: Long,
)
class Avante : HyundaiCar("아반떼",1_000L)
class Sonata : HyundaiCar("소나타", 2_000L)

/**
 * 컴파일 타임 때 하위 클래스의 타입을 모두 기억한다.
 * 런타임 때 클래스 타입이 추가될 수 없다.
 *  => https://codechacha.com/ko/kotlin-sealed-classes/
 * */
private fun handleCar(car: HyundaiCar) {
    when(car) { /** 처리되지 않은 인스턴스가 존재할 경우 밑줄(경고) 가 생기는 장점 */
        is Avante -> println(car.name)
    }
}

fun main() {
    handleCar(Sonata())
}
