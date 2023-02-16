package com.puresoftware.ch10_notification

import android.app.*
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.media.AudioAttributes
import android.media.RingtoneManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import androidx.core.app.RemoteInput
import com.puresoftware.ch10_notification.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.S)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnNotifiaction.setOnClickListener {

            val manager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager // 권한을 가져오기

            val builder: NotificationCompat.Builder // Notification의 모든 정보

            // Version별 권한
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

                // channel이라는 것을 설정
                val channelID = "one_channel "
                val channelName = "My Channel One"
                val channel = NotificationChannel(
                    channelID,
                    channelName,
                    NotificationManager.IMPORTANCE_DEFAULT
                )

                // channel 설정(system 관련 정보들을 가져오는 듯)
                channel.description = "My Channel One Description"
                channel.setShowBadge(true) // badge 유무
                val uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
                val audioAttributes = AudioAttributes.Builder()
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .setUsage(AudioAttributes.USAGE_ALARM)
                    .build()
                channel.setSound(uri, audioAttributes)
                channel.enableVibration(true)

                // channel을 manager에 등록하고 builder는 알림 디자인이 가능한 것들.
                manager.createNotificationChannel(channel)
                builder = NotificationCompat.Builder(this, channelID)
            } else {
                builder = NotificationCompat.Builder(this)
            }


            builder.setSmallIcon(R.drawable.send) // 이쪽은 상단바에 뜨는 것도 동일한 것이다.
            builder.setWhen(System.currentTimeMillis()) // 알림이 울리면 알림이 울린 시점으로부터 그 시간대를 표현하는데 왠만하면 현재시간이 좋다.
            builder.setContentTitle("홍길동")
            builder.setContentText("안녕하세요")
            builder.setLargeIcon(
                BitmapFactory.decodeResource(
                    resources,
                    R.drawable.big
                )
            ) // image를 박아두었다.
//            manager.notify(11, builder.build())

            val KEY_TEXT_REPLY = "KEY_TEXT_REPLY" // 약간 keycode같은 거인듯? 결과값을 return해주는 것인가?
            var replyLabel: String = "답장?"
            var remoteInput: androidx.core.app.RemoteInput = // android.x Library
                RemoteInput.Builder(KEY_TEXT_REPLY).run {
                    setLabel(replyLabel)
                    build()
                }

            val replyIntent = Intent(this, ReplyReceiver::class.java) // Intent는 원래 Java에서만 가능한 듯.
            val replyPendingIntent =
                PendingIntent.getBroadcast(this, 30, replyIntent, PendingIntent.FLAG_MUTABLE)

            builder.addAction(
                NotificationCompat.Action.Builder(
                    R.drawable.send,
                    "답장",
                    replyPendingIntent
                ).addRemoteInput(remoteInput).build()
            )

            manager.notify(11, builder.build())

        }

    }
}