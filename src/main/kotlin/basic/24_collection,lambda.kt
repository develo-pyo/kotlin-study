package basic

fun main() {
    val fruitList = listOf(
        Fruit("사과", 1_000L),
        Fruit("포도", 2_000L),
        Fruit("사과", 3_000L),
        Fruit("사과", 4_000L),
        Fruit("사과", 1_000L),
    )

    /** 이름이 사과인 것만 뽑기  */
    val appleList = fruitList.filter { fruit -> fruit?.name == "사과" }

    /** 이름이 사과인 것만 뽑기  */
    val appleList2 = fruitList.filter { it -> it?.name == "사과" }

    /** 이름이 사과인 것만 뽑은 후 가격만 뽑기  */
    val applePriceList = fruitList.filter { ele -> ele?.name == "사과" }.map { fruit -> fruit?.price }
    for (fruitPrice in applePriceList) {
        println(fruitPrice)
    }

    println("----")

    val appleNotNullList = fruitList.mapNotNull { fruit -> fruit }
    for (apple in appleNotNullList) {
        println(apple.name)
    }
    println("----")
    val fruitListBiggerThan1000 = filterFruits(fruitList) { fruit -> fruit.price > 1_000L }
    for (fruit in fruitListBiggerThan1000) {
        println("${fruit.name}, ${fruit.price}")
    }

    fruitList.sortedBy { fruit -> fruit.price }
    fruitList.sortedByDescending { fruit -> fruit.price }
    println("----")
    val uniquePriceFruitNames = fruitList.distinctBy { fruit -> fruit.price }.map { fruit -> fruit.name }
    uniquePriceFruitNames.forEach { e -> println(e) }
    fruitList.first()
    fruitList.firstOrNull()
    fruitList.last()
    fruitList.lastOrNull()
    println("----")
    println(fruitList[0].name)
    println("----")

    /** .groupBy
     * 아래 형태로 만들기
     * 사과 : 사과List
     * 포도 : 포도List
     */
    val map: Map<String, List<Fruit>> = fruitList.groupBy { fruit -> fruit.name }
    map.keys.forEach { key -> map[key]?.forEach { fruit -> println(fruit.name) } }

    println("----")

    /** .groupBy
     * 아래 형태로 만들기
     * 사과 : 사과의 가격List
     */
    val mapPriceList: Map<String, List<Long>>
    = fruitList.groupBy({ fruit -> fruit.name }, { fruit -> fruit.price })
    mapPriceList.keys.forEach { key -> mapPriceList[key]?.forEach { e -> println(e) } }
    println("----")

    /** .associateBy
     * 아래 형태로 만들기
     * price : price 해당하는 객체(중복없는)
     */
    val map2: Map<Long, Fruit> = fruitList.associateBy { fruit -> fruit.price }
    map2.keys.forEach { key -> println("${key}, ${map2[key]?.name}, ${map2[key]?.price}") }


    val fruitFruitList = listOf(
        listOf(
        Fruit("사과", 1_000L),
        Fruit("포도", 2_000L),
        Fruit("사과", 3_000L),
        Fruit("사과", 4_000L),
        Fruit("사과", 1_000L),
        ),
        listOf(
            Fruit("사과", 1_000L),
            Fruit("포도", 2_000L),
            Fruit("사과", 3_000L),
            Fruit("사과", 4_000L),
            Fruit("사과", 1_000L),
        )
    )
    println("------")
    /** 중첩 리스트에서 중복 제거하기
     * */
    val distinctList = fruitFruitList.flatMap { fruitList : List<Fruit> -> fruitList }
        .distinctBy { fruit -> fruit.name }
    distinctList.forEach { fruit -> println(fruit.name) }

    /** flatten 중첩 클래스를 평탄화 하여 하나의 리스트로 만들기 */
    val flattenFruitList = fruitFruitList.flatten()
    flattenFruitList.forEach { fruit -> println(fruit.name) }
}

private fun filterFruits(
    fruits: List<Fruit>, filter: (Fruit) -> Boolean
): List<Fruit> {
    return fruits.filter(filter)
}
