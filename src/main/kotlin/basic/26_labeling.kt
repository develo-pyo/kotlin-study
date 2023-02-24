package basic

fun main() {

    val numbers = listOf(1,2,3)
    numbers.map { number -> number + 1 }.forEach { number -> println(number) }

    println("----")

    /** 위 코드에서 continue 를 사용하고 싶다면 ?
     * < run >
     * run 키워드 사용하여 forEach 안에서 continue 사용하기 */
    run {
        numbers.forEach {
            number ->
            if (number == 2) {
                return@forEach
            }
            println(number)
        }
    }
    println("----")
    /** forEach 안에서 break 사용하기 */
    run {
        numbers.forEach {
            number ->
            if(number==2) {
                return@run
            }
            println(number)
        }
    }

    /** 가급적 forEach 안에서 break, continue 를 쓰기보단 for문을 사용할 것! */

    println("----")
    /**
     * < @를 사용한 labeling >
     * 바깥쪽 for문에 라벨링(이름붙이기)을 하여 안쪽에서 바깥쪽 for문을 종료(break)시키기
     * !코드 복잡도가 증가하므로 가급적 사용하지 말 것!
     * */
    outer@ for (i in 1..100) {
        for(j in 1..100) {
            if (j == 2) {
                break@outer
            }
            println("${i} ${j}")
        }
    }


}

fun getNumberOfNull(number: Int): Int? {
    return if (number <= 0) {
        null
    } else {
        number
    }
}

/** 위 함수는 아래 함수와 동일
 * < type.takeIf { block } >
 * 주어진 조건을 만족하면 그 값이, 그렇지 않으면 null 반환
 *  => 반대는 .takeUnless
 * */
fun getNumberOfNullUsingTakeIf(number: Int): Int? {
    return number.takeIf { it > 0 }
}
