package basic
/**
 * < scope function >
 * 람다를 사용해 일시적인 영역을 만들고 method chaining 사용하여 코드 간결하게..
 * let, run, also, apply (확장삼수 : 멤버함수처럼 사용)
 * with (확잠함수가 아님)
 *
 * let , run   -> 람다 결과 return
 * also, apply -> 객체 그 자체를 반환
 *
 * */

fun main() {
    val person = Person()
    val value1 = person.let {/** value1 은 age */
        it.age                        /** it : 생략은 불가하지만(it.age or p.age와 같이 사용필수)
                                                p->p.age 와 같이 사용 가능 */
    }
    val value2 = person.run {/** value2 는 age */
        this.age                        /** this : 생략 가능하지만 다른 이름 붙일 수 없음
                                                   p->p.age 와 같이 사용 불가
                                                     T.() -> R 이므로 T의 확장함수기 때문에 this 생략가능*/
    }
    val value3 = person.also {/** value3 은 person 임 */
        it.age                         /** it : 생략은 불가하지만(it.age or p.age와 같이 사용필수)
                                                p->p.age 와 같이 사용 가능 */
    }
    val value4 = person.apply {/** value4 는 person 임 */
        this.age                          /** this : 생략 가능하지만 다른 이름 붙일 수 없음
                                                     p->p.age 와 같이 사용 불가
                                                    T.() -> R 이므로 T의 확장함수기 때문에 this 생략가능*/
    }

    with(person) {/** with(param) block */
        this.age             /** this 사용. 생략 가능 */
        age
    }
}

fun printPerson(person: Person?) {
    person?.let {
        println(person.name)
        println(person.age)
    }
}

