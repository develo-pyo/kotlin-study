package basic

/**
 * DTO (Data Transfer Object) 를 만들 땐 'data' 키워드 사용
 * Kotlin 은 data class 의 데이터(필드), 생성자, getter, equals, hashCode, toString 을 자동으로 생성
 * */
data class PersonDto(
    val name: String,
    val age: Int,
)
/** constructor, getter, equals, hashCode, toString 자동으로 생성됨 */

fun main() {
    val dto1 = PersonDto("jpp", 30)
    val dto2 = PersonDto("jpp", 30)
    println(dto1 == dto2)
    println(dto1)


    println(Country.JAPAN.code)
    println(handleCountry(Country.KOREA))
}

/** kotlin 에서의 ENUM 사용법 */
enum class Country(
    val code: String
) {
    KOREA("KO"),
    JAPAN("JP")
    ;
}

fun handleCountry(country: Country): String {
    return when(country) {
        Country.KOREA -> Country.KOREA.code
        Country.JAPAN -> Country.JAPAN.code
    }
}


