package com.puresoftware.ch10_notification

import android.app.NotificationManager
import android.app.RemoteInput
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity

class ReplyReceiver : BroadcastReceiver() {
    override fun onReceive(p0: Context?, p1: Intent?) {

        // 알림의 입력 글 획득
        val replyTxt = RemoteInput.getResultsFromIntent(p1)
            ?.getCharSequence("key_text_reply")

        // 알림 취소
        val manager = p0?.getSystemService(AppCompatActivity.NOTIFICATION_SERVICE) as NotificationManager

        manager.cancel(11)

    }
}