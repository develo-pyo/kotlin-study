package basic

fun main() {

    val numbers = listOf(1L, 2L, 3L)    // Arrays.asList(1L, 2L, 3L)

    // 1 부터 3까지 춮력
    for (number in numbers) {   // ':' 대신 in 사용하여 for문 사용
        println(number)
    }

    // 1부터 3까지 출력
    for ( i in 1..3 ) {
        println(i)
    }

    // 3부터 1까지 출력
    for ( i in 3 downTo 1 ) {
        println(i)
    }

    // 1부터 5까지 2++
    for ( i in 1..5 step 2 ) {
        println(i)
        // 내부적으로 1~5 등차수열 생성 후, step함수 호출 (중위함수 개념)
        // : 등차수열.step(2)
    }

    /** while 문은 JAVA 와 완전 동일 */
    var i = 1   // i 는 가변이므로 var로 선언
    while (1 <= 3) {
        println(i)
        i++
    }

    /**
     * .. 은 내부적으로 IntRange -> IntProgression
     * */
}
