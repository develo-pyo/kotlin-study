package basic

fun main() {

    /**
     * null 허용할 경우 타입 뒤에 '?' 를 붙임
     */
    var nullableNumber: Long? = 10L
    nullableNumber = null

    var notNullNumber = 10L
    //notNullNumber = null 에러

}
