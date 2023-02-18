package basic

/**
 * Kotlin 에서의 class
 * 1. constructor 키워드 생략 가능
 * 2. getter / setter 는 자동 생성
 * 3. 필드의 타입 추론이 생성자를 통해 가능하여 타입 생략 가능
 * 결과적으로 아래와 같이 생성자 작성이 가능. (== JavaPerson.java)
 * */
class Person (val name: String, var age: Int) {
    /** init 키워드 (초기화블록) 를 통해 생성자 validation 가능 */
    init {
        if ( age < 0 ) {
            throw java.lang.IllegalArgumentException("나이는 1미만일 수 없음")
        }
        println("초기화 블록")
    }
    /** 생성자 추가시(secondary constructor) 아래와 같이 추가
     *      secondary constructor 는 최종적으로 주생성자를 this로 호출해야 함
     *      body 를 가질 수 있음
     * */
    constructor(name: String): this(name, 1) {
        println("부 생성자")
    }

    constructor(): this("default name") {
        println("부 생성자2")
    }

    /**
     * custom getter 방식의 property vs function 방식의 property
     * 1. 객체 속성이라면 custom getter 사용
     * 2. 그외엔 function 방식 사용을 권장
     * */
    /** 1. custom getter 방식으로 처리한 custom property */
    val isAdult_propertyType: Boolean
        get() = this.age >= 20

    /** 2. function 으로 처리한 custom property */
    fun isAdult_funcType(): Boolean {
        return this.age >= 20
    }

}

/**
 * secondary constructor 를 굳이 쓰지 않아도 default parameter 를 사용할 수 있다
 * */
class Person2 (
    name: String = "default Name",
    var age: Int = 1
) {
    /** custom getter 를 사용하여 get name 시 대문자 반환하기
     * name.uppercase() 사용시 주생성자 get() 호출시 name(getter) 호출 name(getter) 호출시 get() 호출되어 loop
     *      -> setter 도 마찬가지
     * */
    var name = name
        get() = field.uppercase()
        set(value) {
            field = value.uppercase()
        }

    fun getUpperCaseName(): String =
        name.uppercase()

    val uppercaseName: String
        get() = name.uppercase()



    /** init 키워드를 통해 생성자 validation 가능 */
    init {
        if ( age < 0 ) {
            throw java.lang.IllegalArgumentException("나이는 1미만일 수 없음")
        }
    }
}

fun main() {
    Person()
    Person("jpp using second constructor")

    val person = Person("jpp", 30)
    println(person.name)    //getter 가 아닌 .필드 를 통해 get 가능
    person.age = 20         //setter 가 아닌 .필드 = 를 통해 set 가능
    println(person.age)

    val upperCasePerson2 = Person2("jpp")
    println(upperCasePerson2.name)
}

/** Converting (ex : A 인스턴스를 B 인스턴스로 만들어 주어야할 때) 은 부생성자를 사용할 수 있지만
 *  이 경우엔 부생성자를 사용하기보단 정적 팩토리 메소드 사용을 권장
 * */
