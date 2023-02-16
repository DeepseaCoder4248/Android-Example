package com.puresoftware.kotlinactivity.GgangSamKotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.puresoftware.kotlinactivity.R

class DataClassActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_class)

        val nonClass1 = NonDataClass("kkang", "aga@com", 10)
        val nonClass2 = NonDataClass("kkang", "aga@com", 10)

        val dataClass1 = DataClass("kkang", "aga@com", 10,"seoul")
        val dataClass2 = DataClass("kkang", "aga@com", 10,"busan")

        Log.i("DataClassActivity", "non data class - ${nonClass1.equals(nonClass2)}")
        Log.i("DataClassActivity", "data class - ${dataClass1.equals(dataClass2)}")

        Log.i("DataClassActivity","non data class- ${nonClass1.toString()}" )
        Log.i("DataClassActivity","data class - ${dataClass1.toString()}")

    }

    class NonDataClass(val name: String, val email: String, val age: Int) {
    }

    data class DataClass(val name: String, val email: String, val age: Int) {
        lateinit var address: String

        constructor(name: String, email: String, age: Int, address: String) : this(
            name,
            name,
            age
        ) {
            this.address = address
        }
    }
}