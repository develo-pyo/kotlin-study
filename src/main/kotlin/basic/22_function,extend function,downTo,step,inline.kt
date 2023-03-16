package basic

/**
 * < 확장 함수 >
 * fun 확장할클래스.함수이름(param): returnType {
 *      this 를 통해 실제 클래스 안의 값에 접근
 * }
 * => 여기서 this 는 수신객체, 확장할클래스는 수신객체 타입이라고 한다
 * => !캡슐화를 보장하기 위해 확장 함 수 내에서 수신객체의 private / protected 멤버는 가져올 수 없다!
 * */
fun String.lastChar(): Char {
    return this[this.length-1]
}

fun String.toString(): String {
    return this+"확장함수"
}

fun main() {
    val str = "ABC"
    println(str.lastChar())


    /** < 시그니쳐(네이밍)이 동일한 멤버함수와 확장함수가 존재할 경우 >
     *  멤버함수가 호출된다
     *  => !동일한 시그니쳐 사용시 멤버함수가 호출됨을 주의!
     * */
    println(str.toString())

    /** 변수의 현재타입(변수의 정적인 타입)에 의해 어떤 확장 함수가 호출될지 결정된다 */
    val trainTrainType: Train = Train()
    println(trainTrainType.isSrt())
    val srtTrainType: Train = Srt()
    println(srtTrainType.isSrt())   /** 인스턴스는 Srt 지만 Train 타입이므로 Train 확장함수 호출됨 */
    val srtSrtType: Srt = Srt()
    println(srtSrtType.isSrt())

    /** 일반함수 */
    3.add(4)
    /** 중위함수 */
    println(3 addUsingInfix 4)
}

open class Train(
    val name: String = "기차"
)
fun Train.isSrt(): Boolean = false

class Srt : Train("SRT") {
    /** < 확장프로퍼티 >
     * 확장함수 같이 선언 및 사용 가능
     * */
    val String.lastChar: Char
        get() = this[this.length-1]
}
fun Srt.isSrt(): Boolean = true


/** < 중위 함수 >
 * ex: downTo, step
 * '변수.함수명(argument)' 대신
 * '변수 함수이름 argument'
 * */
/** 일반 함수 '3.add(4)' 와 같이 사용 */
fun Int.add(other: Int): Int {
    return this + other
}

/** 중위함수 '3 addUsingInfix 4' 와 같이 사용 */
infix fun Int.addUsingInfix(other: Int): Int {
    return this + other
}

/** < Inline 함수 >
 * 함수가 호출되는 대신,
 * 함수를 호출한 지점에 함수 본문을 그대로 복붙하고 싶은 경우
 *   => 함수를 파라미터로 전달할 때 발생하는 오버헤드를 줄일 수 있다
 * */
inline fun Int.add3(other: Int): Int {
    return this + other
}

/** add3 inline함수 사용시 바이트코드로 변환시 아래와 같이 add3 로직 자체가 복붙 된다 */
//public static final void main() {
//    byte $this$add$iv = 3;
//    int other$iv = 4;
//    int var1000 = $this$add$iv + other$iv;
//}

/** < 지역함수 >
 * 함수 안에 함수 선언
 *  => 중복 로직을 제거하기 위해 함수로 분리하는데, 특정 함수 내에서만 사용되면 될 경우 사용
 * */
fun createPerson(firstName: String, lastName: String): Person {
    /** 지역함수를 사용하여 중복로직 제거 */
    fun validateName(name: String, fieldName: String) {
        if(name.isEmpty()) {
            throw java.lang.IllegalArgumentException("")
        }
    }
    validateName(firstName, "jp")
    validateName(lastName, "lee")
    return Person(firstName+lastName, 1)
}


