package com.puresoftware.kotlinactivity.GgangSamKotlin

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.graphics.Color
import android.media.AudioAttributes
import android.media.MediaPlayer
import android.media.RingtoneManager
import android.net.Uri
import android.os.*
import androidx.appcompat.app.AppCompatActivity
import android.util.Log
import androidx.core.app.NotificationCompat
import com.puresoftware.kotlinactivity.R
import com.puresoftware.kotlinactivity.databinding.ActivityNotificationBinding

class NotificationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val binding = ActivityNotificationBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val btnRingtone = binding.btnGetRingtone.setOnClickListener {
            val notification: Uri =
                RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION) // Alarm File을 가져오는 듯
            val ringtone = RingtoneManager.getRingtone(this, notification)
            ringtone.play()
        }

        val btnSelfRingtone = binding.btnSelfRingtone.setOnClickListener {
            val player: MediaPlayer = MediaPlayer.create(this, R.raw.selfringtone)
            player.start()
        }

        val btnVibrator = binding.btnVibrator.setOnClickListener {
            var vibrator = vibrateMethod()

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                vibrator.vibrate(
                    VibrationEffect.createOneShot(
                        500,
                        VibrationEffect.DEFAULT_AMPLITUDE
                    )
                )
            } else {
                vibrator.vibrate(500)
            }
        }

        val btnVibratorLoop = binding.btnVibratorLoop.setOnClickListener {
            var vibrator = vibrateMethod()

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                vibrator.vibrate(
                    VibrationEffect.createWaveform(
                        longArrayOf(
                            500,
                            1000,
                            500,
                            2000
                        ), -1
                    )
                )
            }
        }

        // 알림
        val notification = binding.btnNotification.setOnClickListener {

            // System에서 권한 가져오기
            val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            val builder: NotificationCompat.Builder

            // Version 확인
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

                // 정보 등록
                val channelID = "one-channel" // ID
                val channelName = "My Channel One" // 이름
                val channel =
                    NotificationChannel(channelID, channelName, NotificationManager.IMPORTANCE_HIGH)

                // Channel에 다양한 정보들을 설정
                channel.description = "My Channel One Description"
                channel.setShowBadge(true)

                // 사운드 설정
                val uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
                val audioAttributes = AudioAttributes.Builder()
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION) // 알림의 종류(여기서는 Game Bonus 정도의 시간길이를 가짐)
                    .setUsage(AudioAttributes.USAGE_ALARM).build() // 위의 Code와 같은 종류임.

                // 상세 설정
                channel.setSound(uri, audioAttributes)
                channel.enableLights(true)
                channel.lightColor = Color.RED
                channel.enableVibration(true)
                channel.vibrationPattern = longArrayOf(200, 100, 200, 100)

                // channel를 notification에 등록
                manager.createNotificationChannel(channel)

                // channel를 생성해 builder 생성
                builder = NotificationCompat.Builder(this, channelID)

                // 실행 구현부
                builder.setSmallIcon(android.R.drawable.ic_notification_overlay)
                builder.setWhen(System.currentTimeMillis())
                builder.setContentTitle("Content  Title")
                builder.setContentText("Content Message")
                manager.notify(11, builder.build())


            } else {
                builder = NotificationCompat.Builder(this)
            }
        }

    }


    // Vibrate 객체
    fun vibrateMethod(): Vibrator {
        // 버전별 바이브레이터 권한 가져오기
        var vibrator = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            val vibratorManager =
                this.getSystemService(Context.VIBRATOR_MANAGER_SERVICE) as VibratorManager
            vibratorManager.defaultVibrator;

        } else { // 람다? 식에서 else를 넣지 않으면 값을 리턴할수 가 없다.
            getSystemService(VIBRATOR_SERVICE) as Vibrator
        }
        return vibrator
    }
}