package basic

/**
 * 1. Any :
 *      java 의 Object 와 비슷 (최상위 타입)
 *      모든 Primitive Type의 최상위 타입도 Any
 *      Any는 null을 포함할 수 없어 Any? 를 사용하여 null 포함시킴
 *      Any에 equals / hashCode / toString 존재
 *
 * 2. Unit :
 *      java 의 void 와 동일한 역할
 *      void 와 다르게 Unit은 그 자체로 타입 인자로 사용 가능
 *      (void generic 사용시 void 클래스 사용해야하나 Unit은 직접 사용 가능)
 *      함수형 프로그래밍에서 Unit은 단 하나의 인스턴스만 갖는 타입을 의미. 코틀린의 Unit은 실제 존재하는 타입이라는 것을 표현
 *
 *  3. Nothing :
 *      함수가 정상적으로 끝나지 않았다는 사실을 표현하는 역할
 *      ex: 무조건 예외 리턴하는 함수 / 무한 루프 함수 등
 *
 */

// Nothing 예
fun fail(message: String): Nothing {
    throw java.lang.IllegalArgumentException(message)
}
