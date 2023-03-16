package basic.nullannotation

import Person

fun main() {
    val person = Person("표도리")
    startsWithA(person.name)    // name getter 가 @Nullable 인 경우 컴파일 에러
                                // name getter 가 @NotNull 인 경우 컴파일 통과
                                // name getter 에 아무런 어노테이션이 없다면 컴파일은 통과하나
                                //                null 값일 경우 NPE 발생 -> '플랫폼 타입'이라고 칭한다
}

fun startsWithA(str: String): Boolean {
    return str.startsWith("A")
}
