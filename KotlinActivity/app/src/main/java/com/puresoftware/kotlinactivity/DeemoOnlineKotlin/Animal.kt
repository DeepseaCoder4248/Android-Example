package com.puresoftware.kotlinactivity.DeemoOnlineKotlin

// 코틀린은 클래스에서 이런식으로 만들 수 있다. 기본생성자와, 메소드를 만들 필요가 없다는 이야기이다. 클래스명과 여기의 클래스명 일치안해도 실행가능?
open class Animal(var name: String, var age: Int, var type: String) { // 수퍼클래스(부모)

    fun introduce() {
        println("저는 ${type} ${name}이고, ${age}살 입니다") // $는 String 내에서 변수를 적을 수 있게 하고, {}는 String을 붙여넣게 하는것.
    }

    // 오버라이드 코드
    open fun eat() {
        println("음식을 먹습니다.")
    }
}

// 상속은 extends가 아닌 : 부모클래스(파라미터)
class Dog(name: String, age: Int) : Animal(name, age, "개") {

    fun bark() {
        println("멍멍")
    }

    override fun eat() {
        println("고기를 먹습니다")
    }
}

class Cat(name: String, age: Int) : Animal(name, age, "냥이") {

    fun bark() {
        println("냐이옹")
    }

    override fun eat() {
        println("우유를 마십니다")
    }
}
