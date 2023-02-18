package basic

/**
 * open 키워드를 붙여야 다른곳에서 extends 가 가능!
 * */
open class Base (
    open val number: Int = 100
) {
    init {
        println("Base init")
        println(number)     /** 여기서 number는 필드가 아닌 getter 호출을 통해 가져오는 값 */
    }
}

class Derived(
    number: Int
) : Base(number) {
    init {
        println("Derived init")
        println(number)
    }
    override val number: Int = number
        get() {
            println("Derived getter")
            return field        // field 는 필드(멤버변수)를 의미 (getter가 아님) == backing field 라 부름
        }
}

fun main() {
    /**
     * 출력 결과는 다음과 같음
     * Base 의 init 에서 호출하는 num 은 getter 인데, 이 getter 는 Derived 에서 override 되었음
     * 그런데 Derived 의 num getter 에서 반환하는 field 는 아직 초기화되지 않아 Int 기본값 0을 반환
     * 그래서 Base 의 this.num 에서는 반환받은 0을 출력함
     *
     * => 상위클래스를 설계할 때 생성자 또는 초기화 블록에 사용되는 프로퍼티에는 open 을 하지 말아야 한다
     *    (open 한 필드는 상위클래스의 생성자 또는 초기화 블록내에서 사용하면 안된다)
     *
     * */
    Derived(300)
}
