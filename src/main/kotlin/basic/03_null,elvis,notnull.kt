package basic

fun main() {

    /**
     * null 허용할 경우 타입 뒤에 '?' 를 붙임
     */
    var nullableNumber: Long? = 10L
    nullableNumber = null

    var notNullNumber = 10L
    //notNullNumber = null 에러

    /**
     * Safe call
     * 값이 null이 아닌 경우 실행, null 인 경우 null 반환
     * */
    val str: String? = "ABC"
    // str.length // null허용하는 str을 사용하므로 npe 가능성이 있어 에러 발생
    str?.length // type? 사용시 null허용하는 변수여도 컴파일 에러 발생하지 않음
    // str이 null 값인 경우 null 반환

    /**
     * Elvis 연산자
     * 값이 null 인 경우 ?: 뒤의 값을 반환
     * 값이 null 이 아닌 경우 실행
     * */
    str?.length ?: 0 // str 값이 null 인 경우 0 반환
    // str 값이 null 이 아닌 경우 length 반환
}

/**
 * 아래의 자바 코드를 코틀린으로 바꿔보자
 */
// 1. 자바코드
//public boolean startWithA1(String str){
//    if (str == null) {
//        throw new IllegalArgumentException("null 들어왔음");
//    }
//    return str.startsWith("A");
//}

fun startWithA1(str: String?): Boolean {
    if (str == null) {
        throw java.lang.IllegalArgumentException("null 들어왔음")
    }
    return str.startsWith("A")
}

fun startWithA1_2(str: String?): Boolean {
    return str?.startsWith("A")
        ?: throw java.lang.IllegalArgumentException("null 들어왔음")
}

// 2. 자바코드
//public boolean startWithA2(String str){
//    if (str == null) {
//        return null;
//    }
//    return str.startsWith("A");
//}
fun startWithA2(str: String?): Boolean? {
    if (str == null) {
        return null
    }
    return str.startsWith("A")
}

fun startWithA2_2(str: String?): Boolean? {
    return str?.startsWith("A")
}

// 3. 자바코드
//public boolean startWithA3(String str){
//    if (str == null) {
//        return false
//    }
//    return str.startsWith("A");
//}
fun startWithA3(str: String?): Boolean {
    if (str == null) {
        return false
    }
    return str.startsWith("A")
}

fun startWithA3_2(str: String?): Boolean {
    return str?.startsWith("A") ?: false
}


/**
 * early return 에서의 Elvis 사용
 * */
// 자바코드
//public long calculate(Long number) {
//    if (number == null) {
//        return 0;
//    }
//    return number+1;
//}

fun calculate(number: Long?): Long {
    number ?: return 0
    return number+1
}


/**
 * NOT NULL 단언 : 절대 null 값이 아닌 경우 사용
 *                만약 null 값이 들어갈 경우 NPE 발생
 * */
fun startWithA4(str: String?): Boolean {
    return str!!.startsWith("A")    // str 은 nullable 파라미터지만
                                           // !! 를 붙여 compile 에러 발생하지 않음
}
