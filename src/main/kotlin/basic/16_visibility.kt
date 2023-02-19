package basic
/** <JAVA vs Kotlin 접근제한자 차이>
 *               java                /        kotlin
 * public       = 같음. 모든 곳에서 접근 가능
 * protected    같은패키지 또는 하위클래스  / 같은패키지 X. 선언된 클래스 또는 하위 클래스
 * default                           / default 키워드 없음. 대신 internal 사용. : 같은 모듈에서만 접근 가능
 * private      = 같음. 선언된 클래스에서 접근
 * */

/** <default 접근 제한자>
 * JAVA 기본 접근 제한자 default
 * kotlin 기본 접근 제한자 public
 *
 * 코틀린은 .kt 파일에 변수/함수/클래스를 여러개 만들 수 있음
 * */

/**
 * <Kotlin 파일에서의 접근 제한자>
 * public 기본값
 * protected 파일 최상단엔 사용 불가. 같은 패키지 X
 * internal 같은 모듈 내에서 접근 가능
 * private 같은 파일 내에서만 접근 가능
 * */

/**
 * <Kotlin 생성자에서의 접근제한자>
 * constructor 에 접근제한자를 추가하고자 할 경우 constructor 키워드를 명시해주어야 함
 * */
open class Cat2 protected constructor ( /** protected 사용시 final 키워드가 자동으로 붙으므로 open 필요 */

)

/** <fun을 JAVA 로 변환시>
 * 16_visibility.isDirectoryPath() 와 같이 16_visibility.class
 * public static final boolean isDirectoryPath() 와 같이 변환됨
 * */
fun isDirectoryPath(path: String): Boolean {
    return path.endsWith("/")
}


class Car2(
    internal val name: String,   // setter 없음 val 이므로.. getter를 internal 로
    private var owner: String,  // setter & getter 를 private 으로
    _price: Int         // setter & getter
) {
    var price = _price
        private set     // setter 만 private 으로
}

/**
 * <Java & Kotlin 함께 사용시 주의사항>
 * 1. Internal 은 바이트코드 상 public 이 된다.
 *  -> Java 코드에선 Kotlin 모듈의 internal 코드를 가져올 수 있다
 * 2. Kotlin 의 protected 와 Java 의 protected 는 다름
 *  -> Java 는 같은 패키지의 Kotlin protected 멤버에 접근 할 수 있다
 * */
