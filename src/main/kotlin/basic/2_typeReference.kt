package basic

fun main() {
    /**
     * 1. 자료형은 생략이 가능
     * 2. primitive type(ex: long) 과 reference type(ex: Long) 의 구분이 없음
     *    wrapping(reference type) 객체를 사용할 경우 메모리 비효율(boxing/unboxing)이 있을 수 있어
     *    변환이 가능한 경우, 컴파일단계에서 원시타입(primitive type) 으로 자동으로 변환 됨
     * */
    val number = 10L
    var number2: Long = 10L     // Long number2 = 10L; 과 같음

    /** JAVA <-> KOTLIN 코드 확인하기
     * Tools -> kotlin -> show kotlin bytecode -> Decompile (JAVA 코드로 변환)
     * 위 과정을 통해 Long 타입이 long 으로 자동으로 사용되고 있음을 확인 할 수 있음
     * */


}
