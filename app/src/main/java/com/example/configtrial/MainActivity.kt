package com.example.configtrial

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    val TAG: String = "로그"
    var 테스트: String = "ㄹㄹ"
    val TAG_TO_UPPER = TAG.uppercase()

    var i: Int = 1
//    if해보기
    val testElseIF1: String = if(i == 1) {
        "GAY"
    } else if ( i > 1) {
        "NOT GAY"
    } else {
        "SUPER GAY"
    }
//    when 해보기
    val testWhen1: String = when {
        i == 1 -> "GAY"
        i > 1 -> "NOT GAY"
        else -> "SUPER GAY"
    }
    var alph = "1"

    fun setAl(alph: String) {
        this.alph = alph
    }
//     if 해보기
    fun getAl() : String {
        val helloWorld = if(this.alph == "hello") {
            "alph was hello"
        } else {
            "alph not hello"
        }

        this.alph = helloWorld
       return this.alph
    }
//  익명함수 해봐
    val stringLengthFunc: (String) -> Int = { input -> input.length}
//    함수안에 함수
//    val funcInFunc (str : String, mapper: (String) -> Int): Int {
//        return mapper(str)
//    }
    fun funInFun (str : String, mapper: (String) -> Int) : Int {
        return mapper(str)
    }

//    start collectionTest
//    https://taehyungk.github.io/posts/android-kotlin-high-order-function/
    fun <T> Collection<T>.joinToStringTest(separator: String = ", ",
                                       prefix: String = "",
                                       postfix: String = "",
                                       transform: (T) -> String = { it.toString() } // 함수 타입 파라미터를 선언하면서 람다를 디폴트 값으로 지정
    ): String {
        val result = StringBuilder(prefix)
        for ((index, element) in this.withIndex()) {
            if (index > 0) result.append(separator)
            result.append(transform(element))
        }
        result.append(postfix)
        return result.toString()
    }
    val iAmList = listOf("Alpha", "Beta")
    // end collectionTest

    
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        // 로그 해보기
        Log.d(TAG, "MainActivity - onCreate() called")
        Log.d(TAG, "TestWhen1 : "  + stringLengthFunc("TestWhen1"))
        Log.d(TAG, "joinToString : ${iAmList.joinToStringTest()}")
        
        val car = Car(listOf("A", "B"))
        // get 이없네
        car.gallonsOfFuelInTank
        car.testGetSet = "gg"
        Log.d(TAG, "testGetSet : ${car.testGetSet}")
    }
}

// getter setter 테스트
// 자동으로 세팅해준다고하네요 ㅇㅇ
class Car(val wheels: List<String>) {
    var gallonsOfFuelInTank: Int = 15
        private set
        get() = 100
    var testGetSet: String = "testGetSet"
//        set(value) { field = value}
}
