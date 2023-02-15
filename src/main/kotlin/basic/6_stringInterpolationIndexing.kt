package basic

import Person

fun main() {
    val person = Person("jpp")
    println("내이름은 ${person.name} 입니다")

    val str =
    """
        제 이름은 
        ${person.name}
        입니다.
    """.trimIndent()
    println(str)

    val str2 = "ABC"
    println(str2[0])
}
