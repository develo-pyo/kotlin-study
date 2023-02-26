package basic

/**
 * 함수 선언 문법
 * 1. expression 은 block 처리 할 필요가 없음
 * 2. public 생략 가능
 * 3. 함수의 반환타입도 자동으로 추론할 수 있으므로 생략이 가능
 * 4. expression(함수 선언에서 '=' 사용시) 은 if {} else {} 에서 '{}' 중괄호 생략이 가능
 * */
fun max(a: Int, b: Int) =
    if (a > b)
        a
     else
        b

/**
 * overloading : 파라미터 갯수를 다르게 정의하기 위한 오버로딩을 default parameter를 지정하여 줄일 수 있다
 *      Int = 3
 *      Boolean = true 와 같이 default 인자값을 줄 수 있다
 * */
fun repeat(str: String, num: Int = 3, useNewLine: Boolean = true) {
    for (i in 1..num) {
        if(useNewLine){
            println(str)
        } else {
            println(str)
        }
    }
}

fun main() {
    /** 특정 파라미터만 값을 지정하여 주고 싶은 경우, 파라미터 이름을 통해 직접 지정할 수 있다
     *  -> 이를 통해 builder 사용의 장점을 가질 수 있다 (파라미터 이름을 지정하여 값을 넣을 수 있어 setter 사용과 비슷한 느낌)
     * */
    repeat("test", useNewLine = false)

    /**
     * 코틀린에서 자바 함수를 가져다 사용할 때는 named argument 를 사용할 수 없다
     * (JVM 상에서 java 가 바이트 코드로 변환될 때 argument name 을 보존하고 있지 않아 사용이 불가)
     * */
    //val money = Money(amount = 10L) // amount (named argument 사용 불가)

    /**
     * 가변인자 vararg 사용 : *변수 와 같이 변수 앞에 * (spread operand)를 붙인다
     * */
    val array = arrayOf("1","2","3")
    printAll(*array)
}

/**
 * 가변 인자 vararg
 *  JAVA 에서 String... 과 동일
 * */
fun printAll(vararg strs: String) {
    for(str in strs){
        println(str)
    }
}




