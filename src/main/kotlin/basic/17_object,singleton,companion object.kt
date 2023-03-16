package basic

/**
 * static 대신 companion object 키워드 사용
 * companion object : 클래스와 동행하는 유일한 오브젝트
 * */
class PersonObject private constructor(
    private val name: String,
    private val age: Int
) {
    /**
     * 정적 팩토리 패턴, static 변수를 companion object 로 선언하여 사용
     * companion object 는 객체로 취급된다.
     *     -> 이름을 붙일 수 있음(Factory)
     *     -> interface 구현도 가능( : Log)
     * */
    companion object Factory : Log {
        private const val MIN_AGE = 1   /** const 키워드를 붙이면 컴파일시 변수 할당됨
                                          *   -> primitive type+String 에만 사용 가능
                                          * const 없을 경우 runtime시 할당
                                          * */

        /**
         * Java 파일에서 Kotlin companion object 사용하려면
         * @JvmStatic annotation 을 붙여
         * 평소 static 함수/필드 호출하듯 호출 가능
         * */
        @JvmStatic
        fun newBaby(name: String): PersonObject {
            return PersonObject(name, MIN_AGE)
        }

        override fun log() {
            println("나는 동행객체")
        }
    }
}

interface Log {
    fun log()
}

fun main() {
    /** companion object 에 이름이 없을 경우 Companion 키워드 사용 */
    //PersonObject.Companion.newBaby("")
    PersonObject.Factory.newBaby("")
    PersonObject.newBaby("")

    var singletonTest = Singleton.singletonField;
    println(++singletonTest);
}

/**
 * 싱글톤은 object 키워드 사용하면 끝
 * */
object Singleton {
    var singletonField: Int = 0
}


/**
 * <익명클래스 사용>
 * object : Type {} 과 같이 한다
 * JAVA 와 같이 new Impl(){} 과 같이 하지 않음
 * */
fun annonymousUsingFun() {
    annonymousImpl(object : Movable {
        override fun move() {
            println("움직인다")
        }
    })
}

fun annonymousImpl(action: Movable) {
    action.move()
}

interface Movable {
    fun move()
}


