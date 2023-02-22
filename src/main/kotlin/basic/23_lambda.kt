package basic

/**
 * < lambda >
 * JAVA 에서의 람다
 * 1. 변수 -> 변수를 이용한 함수
 * 2. 자바에선 함수는 2급 시민으로 변수에 할당되거나 파라미터로 전달할 수 없다
 * */

/**
 * Kotlin 에서의 람다
 * 1. 함수가 그자체로 값이 될 수 있다
 * 2. 변수에 할당 가능, 파라미터로 넘길 수 있다
 * */

class Fruit(
    val name: String,
    val price: Long,
)

/** 1. 함수이름이 없이(익명함수) 람다 선언 가능 */
val isApple = fun(fruit: Fruit): Boolean {
    return fruit.name == "사과"
}

/** 2. 중괄호를 사용한 람다 */
val isApple2 = { fruit: Fruit -> fruit.name == "사과" }

/** 3. '(파라미터타입) -> 반환 타입' 과 같이 함수의 타입 표기할 수 있음 */
val isApple3: (Fruit) -> Boolean = { fruit: Fruit -> fruit.name == "사과" }

fun main() {
    val fruitList = listOf(
        Fruit("사과", 1_000L), Fruit("포도", 2_000L)
    )

    fun filterFruits(
         fruits: List<Fruit>, filter: (Fruit) -> Boolean
        ): List<Fruit> {
            val results = mutableListOf<Fruit>()
            for (fruit in fruits) {
                if (filter(fruit)) {
                    results.add(fruit)
                }
            }
        return results
    }

    /** < 함수를 파라미터로 사용하기 > */
    /** isApple 함수 자체를 파라미터로 넘길수 있다 */
    filterFruits(fruitList, isApple)    /** 1. 함수 직접 넘기기 */

    filterFruits(fruitList, { fruit: Fruit -> fruit.name == "사과" }) /** 2. 익명 함수 사용하기 */

    /** 3. 익명 함수를 사용하는 경우
     * 마지막 파라미터가 익명함수인 경우, 아래와 같이 바깥쪽으로 뺄 수 있음
     * */
    filterFruits(fruitList) { fruit: Fruit -> fruit.name == "사과" }
    filterFruits(fruitList) { fruit -> fruit.name == "사과" }     /** 3 을 축약한 형태(filterFruits 에서 Fruit 타입 추론 가능하므로 타입 생략 가능) */
    filterFruits(fruitList) { it.name == "사과" }                 /** it 키워드를 사용하여 축약한 형태(파라미터 한개인 경우 it 사용 가능)*/
    /** it 키워드 사용보단 '타입 -> 타입.함수' 를 직접 사용하는게 호출부에서의 가독성이 좋음  */
    filterFruits(fruitList) {
        println("마지막 줄이 람다의 반환값이 된다!")
        it.name == "사과"
    }

    /**
     * < Java vs Kotlin 외부참조 (Closure) >
     * Java 에선 람다 바깥쪽의 변수를 사용할 경우 해당 변수가 final 인 경우에만 사용 가능
     * Kotlin 에선 람다 바깥쪽의 변수를 제약없이 사용 가능 : lambda가 시작하는 지점의 변수를 포획하여 사용(Closure개념)
     * */
}



