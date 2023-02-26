package basic

import Person

/**
 * primitive type 기본타입인 byte, short, int, long, float, double
 * 코틀린에선 선언된 기본값을 보고 타입 추론
 * */

fun main() {
    /** 코틀린은 선언된 기본값을 보고 타입 추론 */
    val number = 1      // Int 로 간주
    var number2 = 1L    // Long 로 간주
    val number3 = 1.0f  // Float 으로 간주
    val number4 = 1.0   // Double 로 간주

    /** 자바에선 기본타입간 형변환을 암시적으로 이뤄지지만 (오토캐스팅)
     *  코틀린에서의 기본타입간 변환은 명시적으로 이뤄져야 함
     * */
    // 자바에선 하기 코드가 가능
    // int number_1 = 1;
    // long number_2 = number_1;
    // number_1 + number_2

    val num1: Int = 1;
    val num2: Long = num1.toLong()   // 여기서 .toLong()을 제거하면 컴파일 에러

    val num3 = 3
    val num4 = 5
    val result = num3 / num4.toDouble() // 여기서 .toDouble 을 해줘야 Int가 아닌 Double 로 반환

    var n1: Int? = 3
    val n2: Long = n1?.toLong() ?: 0L

}

/**
 * 객체의 형변환
 * instanceof (java) == is (kotlin)
 * (type) instance (java) == var as instance (kotlin)
 * */
// 자바코드
//public static void printAgeIfPerson(Object obj) {
//    if (obj instanceof Person) {
//        Person person = (Person) obj;
//        println(person.getName());
//    }
//}

fun printAgeIfPerson(obj: Any) {
    if (obj is Person) {
        val person = obj as Person
        println(person.name)
    }
}

fun printAgeIfPerson2(obj: Any) {
    if (obj is Person) {
        println(obj.name)   // 스마트 캐스트 ( obj as Person 을 자동으로 수행 )
    }
}

fun printAgeIfPerson3(obj: Any?){
    val person = obj as? Person // obj 가 null인 경우 Null 반환, null 아닌 경우 형변환
    println(person?.name)   // person 이 nullable 이므로 person? 사용
}
