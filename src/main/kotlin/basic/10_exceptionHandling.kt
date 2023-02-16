package basic

import java.io.BufferedReader
import java.io.FileReader
import java.io.IOException

fun parseIntOrThrow(str: String): Int {
    try {
        return str.toInt()
    } catch (e: java.lang.NumberFormatException) {
        throw java.lang.IllegalArgumentException("${str} 은 숫자가 아님")
    }
}

// 주어진 문자가 숫자가 아닌 경우 null 반환
/** try catch 도 expression 으로 return 으로 사용 가능 */
fun parseIntOrThrow2(str: String): Int? {
    return try {
        str.toInt()
    } catch (e: java.lang.NumberFormatException) {
        null
    }
}

/** try catch finally 문법은 java 와 동일 */

/** java와 달리 checked exception 을 핸들링하지 않아도 됨
 * : checked Exception , unchecked Exception 모두 unchecked Exception 으로 취급
 * */
fun checkedException() {
    throw IOException() // 함수에 throws Exception 하지 않아도 컴파일 에러가 나지 않음
}

/** try with resources
 * 코틀린엔 try with resources 가 없음 : 대신 use (inline 확장 함수) 사용
 * */
fun readFile(path: String) {
    BufferedReader(FileReader(path)).use {
        reader -> println(reader.readLine())
    }
}
