package com.puresoftware.kotlinactivity

open class KotlinClass(val name: String, val age: Int) {

    init {
        println("이것은 가장기본인 init 출력용 메소드입니다.")
    }

    constructor(name: String) : this(name, 25) {
    }

    fun introduce() {
        println("KotlinClass 실행완료! ${name}님이고 ${age}살 입니다.")
    }

    fun test() {
        println("test 작동 코드")
    }
}

interface inter1 {
    fun launch() {
        println("인터페이스 1이 실행되었습니다.")
    }
}

abstract class abstractclass {
    abstract fun asf()
    fun launch() {
        println("abstract가 실행")
    }
}

// 클래스 상속                                              : 상속받을 클래스 또는 인터페이스(매개변수 똑같이)
class KotlinExtends(val language: String, var code: Long) : KotlinClass("", 0), inter1 {

    override fun launch() {
        super.launch()
    }
}

class KotlinExtends2() : abstractclass() {
    override fun asf() {
        println("오버라이드된 abstract")
    }
}