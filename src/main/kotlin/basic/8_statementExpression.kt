package basic

fun main() {

}

/**
 * Statement (문) : 프로그램 문장, 하나의 값으로 도출되지 않음
 * Expression (식) : 하나의 값으로 도출되는 문장 (자바 삼항연산자)
 * */

/**
 * 1. if
 * kotlin 에선 if 는 식이다. if else 가 삼항연산자를 대체하므로 코틀린에선 삼항연산자가 없음
 * */
fun getPassOrFail(score: Int): String {
    return if(score >= 50) {
        "P"
    } else {
        "F"
    }
}

/**
 * 2. in : 범위 연산자
 * a..b 는 a<= ? <= b 를 의미
 * */
fun validateScoreIsNotNegativ(score: Int) {
    if (score !in 0..100) {
        throw java.lang.IllegalArgumentException("score 범위가 0~100 사이가 아님")
    }
}

/**
 * 3. when : java의 switch case 와 비슷
 * */
fun getGradeWithWhen(score: Int): String {
    return when(score / 10) {
        9 -> "A"
        8 -> "B"
        7 -> "C"
        else -> "D"
    }
}

fun getGradeWithWhen2(score: Int): String {
    return when(score) {
        in 90..99 -> "A"
        in 80..89 -> "B"
        in 70..79 -> "C"
        else -> "D"
    }
}

/**
 * when 조건으로 식도 들어갈 수 있음
 * */
fun startsWithA(obj: Any): Boolean {
    return when (obj) {
        is String -> obj.startsWith("A")
        else -> false
    }
}

/**
 * when () 괄호 생략 가능
 * */
fun judgeNumber(number: Int): String {
    return when {
        number in 0..9 -> "0~9사이 수"
        else -> "한자리 수 아님"
    }
}
