package basic

import Extends.Derived as asImportedCls /** as 를 사용하여 import 한 class 명 치환 가능 */

/** < typealias > */
typealias FruitFilter = (Fruit) -> Boolean

fun filterFruits2(fruits: List<Fruit>, filter: FruitFilter) {
}

data class SomethingLongClassName(
    val name: String
)
typealias  STHLCLSNMmap = Map<String, SomethingLongClassName>


/** < as import >
 * 클래스나 함수를 임포트 할 때 이름을 바꿔서 임포트 가능
 * */
val asImport = asImportedCls(2)

/** < componentN : 구조분해 >
 * data class 는 내붖덕으로 componentN 를 생성함
 * */
data class Person5(
    val name: String,
    val age: Int
)

/** < componentN 직접 구현하기 > */
class Person6(
    val name: String,
    val age: Int
) {
    operator fun component1(): String {
        return this.name
    }
    operator fun component2(): Int {
        return this.age
    }
}

fun main() {
    val person5 = Person5("jpp", 30)
    val (namne, age) = person5
    val name1 = person5.component1()    /** 첫번째 프로퍼티 */
    val age2 = person5.component2()     /** 두번째 프로퍼티 */
    println("${namne}, ${age}")

    val person6 = Person6("jpp2", 20)
    val (nm, a) = person6

}
