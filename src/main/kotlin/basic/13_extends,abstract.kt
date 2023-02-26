package basic

abstract class Animal(
    protected val speceies: String,
    protected open val legCount: Int    /** open 키워드를 사용해야(열어줘야) subclass에서
                                          *  getLegCount override 가능
                                          **/
) {
    abstract fun move()
}

/**
 * 코틀린에서의 상속은 extends 가 아닌 ': 상위클래스생성자' 을 사용
 * override 키워드를 붙여 추상메소드 구현
 * */
class Cat (
    speceies: String
    ) : Animal(speceies, 4) {
    override fun move() {
        println("고양이 움직인다")
    }

}

/**
 * abstract class, interface 모두 ' : super , interface'  와 같이 상속 및 구현
 * */
class Penguin(
    speceies: String
) : Animal(speceies, 2), Swimable, Flyable {
    private val wingCount: Int = 2
    override fun move() {
        println("펭귄이 움직인다")
    }
    /** custom getter override */
    override val legCount: Int
        get() {
            println("펭귄은 날개도 다리로 치자")
            return super.legCount + this.wingCount
        }

    /** 중복되는 인터페이스를 특정할 땐 super<타입>.함수 사용  */
    override fun act() {
        super<Swimable>.act()
        super<Flyable>.act()

        /** JAVA 에서의 default method override */
//        @Override
//        public void act() {
//            Swimable.super.act();
//            Flyable.super.act();
//        }
    }

    /** backing field 가 없는 인터페이스의 필드 구현 */
    /** 초기값 1 을 구현하여 3 으로.. */
    override val swimAbility: Int
        get() = 3
}

fun main() {
    val penguin = Penguin("peng")
    //penguin.legCount    // public 접근제한자로 해당 필드를 수정해야 접근 가능
}
