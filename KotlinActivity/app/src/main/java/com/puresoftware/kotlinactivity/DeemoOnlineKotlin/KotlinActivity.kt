package com.puresoftware.kotlinactivity.DeemoOnlineKotlin

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi
import com.puresoftware.kotlinactivity.R


class KotlinActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin2)


        // 코틀린은 변수를 두가지로 선언.
        // var , val
        // 세미콜론을 쓰지 않는다.

        // 기본적으로 null 허용을 하지 않으므로, 값을 넣어야 한다.
        var a: Int = 123
        println(a)

        // nullable , null이 필요한 객체인 경우, NullPointerException 뜸.
        var b: Int? = null

        // 자료형
        var charValue: Char = 'a'
        var koreanCharValue: Char = '가'
        var booleanvalue: Boolean = true
        var exteption: Boolean = true

        // 명시적 형 변환(얘는 이렇게 한다)
        var c: Int = 54321
        var d: Long = c.toLong()

        // 지정 배열
        var intArr = arrayOf(1, 2, 3, 4, 5) // 자동으로 타입이 지정이 된 듯 하다.

        // null 배열
        var nullArr = arrayOfNulls<Int>(5)
        nullArr[0] = 10

        // 타입추론
        // 알아서 변수를 넣으면 타입이 지정된다.
        // 그러나 클래스를 입력한 경우에는 잘 입력해야 하는 듯 하다.
        var e = 10
        var f = 10.5
        var g = 30.269f
        var h = true
        var i = '라'
        var j = "배가 고파요"

        // 메소드(메소드 안에서 메소드가 만들어진다!)
        fun add(a: Int, b: Int, c: Int): Int { // 이 큰 Int는 return type
            return a + b + c
        }
        println(add(5, 6, 7))

        // 한줄로 처리하는 단일표현식 메소드
        fun add2(a: Int, b: Int, c: Int) = a + b + c // 타입추론이 가능해서 return type을 생략
        println(add2(3, 4, 5))

        // 조건문
        var k = 7
        if (k > 10) {
            println()
        } else {
            println()
        }

        // when
        // switch문의 접근법 + if-else을 다중으로 사용가능한 것
        fun doWhen(a: Any) { // Any는 최상위 자료형 - Objcet
            when (a) {
                1 -> println("정수 1")
                "Dimo" -> println("디모")
                is Long -> println("Long")
                !is String -> println("String이 아님")
                else -> println("어떤것도 만족안함")
            }
        }
        doWhen("")

        // when의 변수 할당
        fun doWhen2(a: Any) { // Any는 최상위 자료형 - Objcet
            var result = when (a) {
                1 -> "정수 1"
                "Dimo" -> "디모"
                is Long -> "Long"
                !is String -> "String이 아님"
                else -> "어떤것도 만족안함"
            }
            println(result)
        }
        doWhen2(100)

        // while
        var o = 0
        while (o < 5) {
            println(o++)
        }

//        // do-whlie
//        var p = 0
//        do {
//            println("start")
//        } while (p > 10){
//            println(p++)
//        }

        // for(정말로 다르다)
        // 변수지정시 int,val등 X
        for (i in 0..9) { // 0부터..9까지 i에 넣는다. 다른변수도 가능
            println(i)
        }

        for (i in 0..9 step 3) { // 0부터..9까지 i에 3씩 증가해서 넣는다. 다른변수도 가능
            println(i)
        }

        for (i in 9 downTo 0) { // 9부터..0까지 i에 감소시켜 넣는다. 다른변수도 가능
            println(i)
        }

        for (i in 'a'..'e') { // a부터..e까지 증가시킨다고...?
            println(i)
        }

//        for (i in '가'..'하') { // 가부터..하까지 증가시킨다고...? 실험결과 100자 이상이 나와버림. 촕은 뭐고 츦은 뭐임.
//            println(i)
//        }

        // 코드 제어
        // return, continue, break
// 레이블을 $$@ 지정하고 원하는 위치에 호출하면 처음 등록한 레이블의 반복문까지 종료
        loop@ for (i in 1..10) {
            for (j in 1..10) {
                if (i == 1 && j == 2) {
                    break@loop
                }
            }
        }

        // 클래스
        // 코틀린은 클래스가 내부에서도 만들어진다!
        class Person(var name: String, val birthYear: Int)

        var ca = Person("박보영", 1990)
        var cb = Person("전정국", 1997)
        var cc = Person("장원영", 2004)

        // 코틀린은 이것도 가능하다
        class Person2(var name: String, val birthYear: Int) {
            fun introduce() {
                println("안녕하세요," + birthYear + "년생" + name + "입니다")
            }
        }

        var cd = Person2("박보영", 1990)
        var ce = Person2("전정국", 1997)
        var cf = Person2("장원영", 2004)
        cd.introduce()
        ce.introduce()
        cf.introduce()

        // 기본생성자에 보조 생성자를 만들어서 특수하게 기본값을 입력.
        class Person3(var name: String, val birthYear: Int) { // 이 생성자가 기본 생성자다.

            // init을 태그를 적어서 매개변수와 리턴값이 없는 출력용 보조 생성자.
            init {
                println("${this.birthYear}년생 ${this.name}")
            }

            // constructor 태그를 적어서 보조 생성자를 만든다.
            constructor(name: String) : this(name, 1997) {
                println("이것은 보조생성자입니다.")
            }
        }

        var cg = Person3("이루다")
        var ch = Person3("차은우")
        var ci = Person3("류수정")

        // 클래스 상속
        // 오버라이드
        var animal = Animal("별이", 5, "개")
        var dog = Dog("별이", 5) // : Animal(name,int,"개")
        var cat: Cat = Cat("융이", 6)
//        var dogs : Dog = "아 어지럽다...."
        animal.introduce()
        dog.introduce()
        cat.introduce()

        animal.eat()
        dog.eat()
        cat.eat()

        // 고차함수,람다
        fun a(str: String) {
            println(str + " 함수 a")
        }

        //   ↓ 바로 아래 함수로 연결하는 거임.
        fun b(function: (String) -> Unit) { // 이름:(타입) -> Unit을 적어준다.
            function("b가 호출함") // 그 형식으로 만들어진걸 작성해준다.
        }
        //   ↓ 함수 b에 함수 a를 넣기위해서는 ::함수명 을 쓰는것이야.

        b(::a)

        class thisIsClass(var a: Int, var b: Int) : override, overLoading() {
            init {
                System.out.println("이 클래스가 발동되었습니다. 1회만 메세지가 알려옵니다.")
            }

            fun start() {
                over1()
                over2()
                override1()
                override2()
            }

            override fun override2() {
                System.out.println("override 2 complete")
            }

            override fun override1() {
                super.override1()
            }
        }

        var wow = thisIsClass(10, 15)
        wow.start()

        var jjazang = FoodPoll("짜장")
        var jjambbong = FoodPoll("짬뻥")

        jjazang.vote()
        jjazang.vote()
        jjambbong.vote()
        jjambbong.vote()
        jjambbong.vote()

        println("${jjazang.name} ${jjazang.count}")
        println("${jjambbong.name} ${jjambbong.count}")
        println("총계: ${FoodPoll.total}")

        var drink = Drink()
        drink.drink()

        var drink2: Drink = Cola()
        drink2.drink()
//        drink2.washdishes()

        // 잠시동안 다운캐스팅, is를 써야 한다.
        if (drink2 is Cola) {
            drink2.washDishes()
        }

        // as를 쓰면 변수에 할당이 가능하다. as를 써야 한다.
        var drink3 = drink2 as Cola
        drink3.washDishes()

        //        UsingGeneric(String()).doShouting() 제너릭은 지정된 클래스를 제외한 불가능. 상속된 것은 가능
        UsingGeneric(A()).doShouting()
        UsingGeneric(B()).doShouting()
        UsingGeneric(C()).doShouting()
        doShouting(B())

        // 리스트
        val list = listOf("사과", "딸기", "배")
        println(list[1])

        // 리스트 전체출력
        for (fruit in list) {
            println("${fruit}")
        }

        // 여러 기능적인 함수가 있는 리스트
        val mutable = mutableListOf(6, 3, 1)
        println(mutable)

        // 추가
        mutable.add(4) // 다음 index에 4를 추가한다.
        println(mutable)

        // 지정 index에 추가
        mutable.add(2, 8) // 2번 index에 8을 추가한다.
        println(mutable)

        // 삭제
        mutable.removeAt(1) // 1번 index를 삭제한다.
        println(mutable)

        // 랜덤
        mutable.shuffle()
        println(mutable)

        // 가장 좋은 기능이라고 생각되는 정렬
        mutable.sort()
        println(mutable)


        // 문자열을 다루는 법
        val stringTest1 = "Test.Kotlin.String"
        println(stringTest1.length)
        println(stringTest1.toLowerCase()) // 소문자들로 return
        println(stringTest1.toUpperCase()) // 대문자들로 return

        val stringTest2 = stringTest1.split(".") // 코틀린은 정규식 없이도 split이 자유롭다고 한다.
        println(stringTest2)

        val nullString: String? = null
        val emptyString = ""
        val blankString = " "
        val normalString = "A"

        // 비어있거나, null인 경우 true
        println(nullString.isNullOrEmpty())
        println(emptyString.isNullOrEmpty())
        println(blankString.isNullOrEmpty())
        println(normalString.isNullOrEmpty())
        println("--")

        // 문자열이 있는 경우 true
        println(nullString.isNullOrBlank())
        println(emptyString.isNullOrBlank())
        println(blankString.isNullOrBlank())
        println(normalString.isNullOrBlank())
        println("--")

        var stringTest3 = "kotlin.kt"
        var stringTest4 = "java.java"

        println(stringTest3.startsWith("java")) // .앞에 해당단어가 있는가
        println(stringTest4.startsWith("java"))
        println(stringTest3.endsWith(".kt")) // .뒤에 해당단어가 있는가
        println(stringTest4.endsWith(".kt"))
        println(stringTest3.contains("lin")) // 문자열에 해당 문자들이 있는가
        println(stringTest4.contains("lin"))

//        val number = "gugu@gmail.com"
//        val list = number.split("@", ".")
//        println(list)

        // null 참조 연산자
        // a? 는 컴파일 할 때 null인지 확인, a?: 는 컴파일을 할 때 null이면 defalut로 머더라? a!!는 null이라면 의도적으로 exception을 일으키는 것.
        var nullOString: String? = null
        println(nullOString?.toUpperCase()) // null이면 실행 안함
        println(nullOString ?: "default".toUpperCase()) // null이면 내가 지정한 데이터로 바꿈.
        println(nullOString!!.toUpperCase()) // null이면 그냥 에러

        fun read(x: Int) {
            println("숫자 $x 입니다.")
        }

        fun read(x: String) {
            println(x)
        }
// 필독: 같은 타입의 매개변수 디자인은 실행불가
//        fun read(y:Int){
//        }
        read(7)
        read("감사합니다")

        // 하나의 함수에는 원하는 데이터만 넣으면 원하는대로 출력이 가능
        fun deliveryItem(name: String, count: Int = 1, destination: String = "집") {
            println("${name},${count}개를 ${destination}에 배달하였습니다")
        }
        deliveryItem("짬뽕")
        deliveryItem("책", 3)
        deliveryItem("노트북", 30, "학교")
        deliveryItem("선물", destination = "친구집") // 기본값이 있는 경우 기본값을 유지하고 싶은 아무튼 그런게 있다.

        // vararg를 통한 생성, 개수가 지정되지 않은 매개변수, 마지막 매개변수에 그 기능이 적용된다.
        fun sum(vararg numbers: Int) {
            var sum = 0

            for (i in numbers) {
                sum += i
            }
            println(sum)
        }
        sum(1, 2, 3, 4) // 타입만 일치하면 매개변수의 갯수와 상관없이 무한 입력이 가능하다.

        infix fun Int.multiply(x: Int): Int = this * x // 아직 이해안됨.

        // 중첩클래스와 내부클래스는 호출방법이 달다.
        Outer.Nested().introduce()
        val outer = Outer()
        var inner = outer.Inner()
        inner.introduceInner()
        inner.introduceOuter()
        outer.text = "changed outer class"
        inner.introduceOuter()

        // Array 1
        val data1: Array<Int> = Array(3, { 0 })
        Log.i("gugu", data1.get(0).toString())
        Log.i("gugu", data1.get(1).toString())
        data1.set(2, 128)
        Log.i("gugu", data1.get(2).toString())
        Log.i("gugu", "size: ${data1.size}")

        // list, mutableList
        var list2 = listOf<Int>(10, 50, 2015, 10)
        Log.i("gugu", list2.get(1).toString())

        Log.i("gugu", "-----")

        var mutableList = mutableListOf(10, 50, "나나", 100)
        mutableList.set(2, "미쿠")
        Log.i("gugu", mutableList.get(2).toString())
        mutableList.add(4, "시로코")
        Log.i("gugu", mutableList.get(4).toString())

        // map, mutablemap
        var map2 = mapOf<String,Int>(Pair("암호코드",25),"식별코드" to 100,"보안코드" to 71,Pair("액세스 코드",-10))
        Log.i("gugu","사이즈:${map2.size}, 코드:${map2.get("암호코드")}")

        Log.i("gugu","-----")

        var map3 = mutableMapOf<String,Int>(Pair("시로코",10),"세리카" to 50,"히후미" to 80)
        map3.remove("히후미")
        map3.put("카스미",45)
        map3.replace("시로코",20)
        Log.i("gugu","$map3, ${map3.get("시로코")}")

        // if 표현식 심화
        val aerx = 52
        val result2 by lazy {
            var result:Boolean
            if (aerx > 10){
                result= true
            }else{
                result = false
            }
            result
        }
        Log.i("gugu","result: $result2")
    }
}

// ---------------------클래스 라인------------------------

// 중첩클래스 내부클래스
// https://shinjekim.github.io/kotlin/2019/08/29/Kotlin-%EB%82%B4%EB%B6%80-%ED%81%B4%EB%9E%98%EC%8A%A4(inner-class)%EC%99%80-%EC%A4%91%EC%B2%A9-%ED%81%B4%EB%9E%98%EC%8A%A4(nested-class)/
class Outer {
    var text = "Outer Class"
    var connectData: String = "data"

    class Nested {
        // 중첩클래스를 의미함. 중첩클래스에는 외부클래스의 내용들을 참조할 수 없음.
        fun introduce() {
            println("Nested Class")
//                connectData 불가능
        }
    }

    inner class Inner { // 내부 클래스를 의미함. 내부클래스에는 외부클래스의 내용들을 참조가능.
        var text = "Innter Class"

        fun introduceInner() {
            println(text)
        }

        fun introduceOuter() {
            println(this@Outer.text) // 객체를 초기화 할 수 없기 때문에 연결이 필요함. (this는 멤버변수, @Outer는 외부 클래스, text)를 의미한다.
//                println(connectData) // 같은 명칭이 아니라면 이런식으로도 가능하다.
        }
    }
}

fun <T : A> doShouting(t: T) {
    t.shout()
}

// 제너릭 클래스
class UsingGeneric<T : A>(val value: T) {
    fun doShouting() {
        value.shout()
    }
}


// 제너릭에 쓸 클래스들에게 상속할 클래스
open class A {
    open fun shout() {
        println("A가 소리칩니다.")
    }
}

// 제너릭으로 상속받을 클래스
class B : A() {
    override fun shout() {
//            super.shout()
        println("B가 소리칩니다.")
    }
}

// 제너릭으로 상속받을 클래스스
class C : A() {
    override fun shout() {
//            super.shout()
        println("C가 소리칩니다.")
    }
}

// 클래스의 다형성에 쓸 클래스
open class Drink {
    var name = "음료"

    open fun drink() {
        println("$name 을 마십니다.")
    }
}

// Drink를 상속
class Cola : Drink() {
    var type = "콜라"

    override fun drink() {
        println("${name}중에 ${type}을 마십니다.")
    }

    fun washDishes() {
        println("${type}으로 설거지를 합니다.")
    }
}


// object 코드를 사용하는 싱글톤 패턴 기반
object Counter {
    var count = 0

    fun countUp() {
        count++
    }

    fun clear() {
        count = 0
    }
}

class FoodPoll(val name: String) {
    companion object {
        var total = 0
    }

    var count = 0

    fun vote() {
        total++
        count++
    }
}

// 상속할 클래스
open class overLoading() {

    fun over1() {
        System.out.println("하하")
    }

    fun over2() {
        System.out.println("허허")
    }
}

// 오버라이딩 할 인터페이스
interface override {

    fun override1() {
        System.out.println("this is kotlin")
    }

    fun override2()
}
