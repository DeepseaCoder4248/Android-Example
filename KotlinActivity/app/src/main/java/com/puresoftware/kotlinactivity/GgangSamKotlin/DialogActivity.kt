package com.puresoftware.kotlinactivity.GgangSamKotlin

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Context
import android.content.DialogInterface
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.DatePicker
import android.widget.TimePicker
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.annotation.RequiresApi
import com.puresoftware.kotlinactivity.R
import com.puresoftware.kotlinactivity.databinding.ActivityDialogBinding

class DialogActivity : AppCompatActivity() {

    val TAG = "DialogActivity"

    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityDialogBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnDialogActivityToast.setOnClickListener {

            // 기본적인 토스트 메세지
//            Toast.makeText(this, "toast 실행됨", LENGTH_SHORT).show()

            // 상세설정이 가능한 토스트 메세지
//            val toast = Toast.makeText(this, "toast 실행됨", LENGTH_SHORT)
//            toast.duration
//            toast.gravity
//            toast.setGravity()
//            toast.show()

            // 콜백이 가능한 토스트 메세지(API 30)
            // object의 개념
            // 람다함수의 개념
            val toast = Toast.makeText(this, "toast 실행됨", LENGTH_SHORT)
            toast.addCallback( // 아마 람다함수인 거 같으므로, 이렇게 하는 듯 하다.
                object : Toast.Callback() { // 익명클래스임을 추정.

                    // hidden
                    override fun onToastHidden() {
                        super.onToastHidden()
                        Log.i(TAG, "toast hidden")
                    }

                    // shown
                    override fun onToastShown() {
                        super.onToastShown()
                        Log.i(TAG, "toast shown")
                    }
                }
            )
            toast.show()
        }

        // 데이트 피커
        binding.btnDialogActivityDatepicker.setOnClickListener {
            DatePickerDialog(this, object : DatePickerDialog.OnDateSetListener {
                override fun onDateSet(p0: DatePicker?, p1: Int, p2: Int, p3: Int) {
                    Log.i(TAG, "year: $p1, month: ${p2 + 1}, dayOfMonth: $p3")
                }
            }, 2020, 8, 21).show()
        }

        // 타임 피커
        binding.btnDialogActivityTimepicker.setOnClickListener {
            TimePickerDialog(
                this, object : TimePickerDialog.OnTimeSetListener {
                    override fun onTimeSet(p0: TimePicker?, p1: Int, p2: Int) {
                        Log.i(TAG, "time: $p1, minute:$p2 ")
                    }
                }, 10, 20, true
            ).show()
        }

        // 노멀 다이어로그
        binding.btnDialogActivityAlert.setOnClickListener {
            AlertDialog.Builder(this).run {
                setTitle("다이어로그 제목")
                setIcon(android.R.drawable.ic_dialog_alert) // android(플랫폼 라이브러리).R.drawable~~
                setMessage("정말 종료하시겠습니까?")

                // 포지티브 버튼에 리스너 인터페이스
                setPositiveButton(
                    "ok",
                    object : DialogInterface.OnClickListener { // 첫번째는 텍스트, 두번째는 클릭시 응답여부 리스너
                        override fun onClick(p0: DialogInterface?, p1: Int) {
                            val toast = Toast.makeText(context, "종료됨", LENGTH_SHORT).show()
                        }
                    })
                setNegativeButton("cancel", null)
                setNeutralButton("more", null)

                // 버튼 핸들러
                object : DialogInterface.OnClickListener {
                    override fun onClick(p0: DialogInterface?, p1: Int) {

                        if (p1 == DialogInterface.BUTTON_POSITIVE) {
                            Log.i(TAG, "positive button click")
                        } else if (p1 == DialogInterface.BUTTON_NEGATIVE) {
                            Log.i(TAG, "negative button click")
                        }
                    }
                }

                show()
            }
        }

        // 리스트 다이어로그
        binding.btnDialogActivityList.setOnClickListener {
            val items = arrayOf<String>("사과", "복숭아", "수박", "딸기") // Any 불가능

            // 다이어로그 리스트
            AlertDialog.Builder(this).run {
                setTitle("아이템 리스트")
                setIcon(android.R.drawable.ic_dialog_alert)

                //리스트
                setItems(items, object : DialogInterface.OnClickListener {
                    override fun onClick(p0: DialogInterface?, p1: Int) {
                        Log.i(TAG, "선택한 포지션: $p1, 선택한 과일: ${items[p1]}")
                    }
                })

                setPositiveButton("닫기", null)
                show()
            }
        }

        // 체크박스 다이어로그
        binding.btnDialogActivityCheckbox.setOnClickListener {
            AlertDialog.Builder(this).run {
                setTitle("아이템 리스트")
                setPositiveButton("닫기", null)

                val items = arrayOf<String>("사과", "딸기", "고구마", "키위")
                setMultiChoiceItems(
                    items,
                    booleanArrayOf(true, false, true, false),
                    object : DialogInterface.OnMultiChoiceClickListener {
                        override fun onClick(p0: DialogInterface?, p1: Int, p2: Boolean) {
                            Log.i(TAG, "아이템: $p1, 상태: $p2")
                        }
                    }).show()
            }
        }

        // 라디오 다이어로그
        binding.btnDialogActivityRadio.setOnClickListener {
            AlertDialog.Builder(this).run {
                setTitle("아이템 리스트")
                setPositiveButton("닫기", null)

                val items = arrayOf<String>("사과", "딸기", "고구마", "키위")
                setSingleChoiceItems(items, 0, object : DialogInterface.OnClickListener {
                    override fun onClick(p0: DialogInterface?, p1: Int) {
                        Log.i(TAG, "아이템: $p1")
                    }
                }).show()
            }
        }

        // 인플레이터 기본
        var inflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val inflaterView = inflater.inflate(R.layout.inflater, null)

        // 인플레이터 커스텀 다이어로그
        binding.btnDialogActivityCustom.setOnClickListener {
            AlertDialog.Builder(this).run {

                setTitle("Input")
                setView(inflaterView)
                show()
            }
        }
    }
}