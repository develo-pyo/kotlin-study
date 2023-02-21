package basic

val array = arrayOf(100, 200)

val numbers = listOf(100, 200)

/** 불변리스트 (unmodifiableList) */
var emptyList = emptyList<Int>()

/** emptyList 선언시 타입추론이 불가능하여 타입 명시 필요 */

fun getEmptyList(emptyList: List<Int>) {
}

fun main() {
    /** < 배열 사용 법 > */
    array.plus(300)
    /** array 에 값 추가 가능 */
    array.drop(300)
    /** array 의 값 제거 가능 */

    /** .indices : index 0~last */
    for (i in array.indices) {
        println("${i} ${array[i]}")
    }

    /** .withIndex : index with value */
    for ((idx, value) in array.withIndex()) {
        println("${idx} ${value}")
    }

    /** < List > */
    getEmptyList(emptyList())
    /** 타입추론이 가능한 경우 타입 명시 불필요 */

    var numbers = listOf(100, 200)
    numbers[0]
    /** 배열과 같이 val 접근 가능 */
    for (i in numbers.indices) {
        //numbers[i] = 400    /** default 가 불변컬렉션으로 setter 사용 불가 */
    }
    for ((idx, value) in numbers.withIndex()) {
    }

    /** 가변 리스트를 만들때는 mutableListOf 사용 */
    var mutableNumbers = mutableListOf<Int>(100, 200)

    /** < Set > */
    /** list 와 사용법 동일 */
    var setNumbers = setOf(100, 200)
    var mutableSetNumbers = mutableSetOf<Int>(100, 200)

    /** <Map> */
    val oldMap = mutableMapOf<Int, String>()
    oldMap.put(1, "MON")
    oldMap.put(2, "TUE")
    oldMap[3] = "WED"
    /** 배열과 같이 사용하여 put 가능 */
    mapOf(1 to "MON", 2 to "TUE")
    /** 중위 호출 to 를 사용하여 선언도 가능 */
    for (key in oldMap.keys) {
        println(key)
        println(oldMap[key])
    }
    for((key, value) in oldMap.entries) {
        println(key)
        println(value)
    }
}

/** < Collection 과 null > */
val nc1: List<Int?> = listOf(1, null)   /** 값 nullable */
val nc2: List<Int>? = null              /** list 가 nullable */
val nc3: List<Int?>? = null             /** list 와 값 nullable */


/** Java <-> Kotlin 함께 사용시 주의사항
 * Java 읽기전용, 불변 구분 없으므로 kotlin 컬렉션을 가져왔을 때 불변이 가변이 될 수 있음
 * Java 는 nullable type , non-nullable type 구분을 하지 않아 non-nullable에 null 허용해버릴 수 있음
 *      => Kotlin 쪽에서 Collections.unmodifiableXXX 을 사용, 로직 분석하여 non-null/null 확인 필요
 * */

