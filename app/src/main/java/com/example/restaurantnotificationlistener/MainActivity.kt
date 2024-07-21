package com.example.restaurantnotificationlistener

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.service.notification.NotificationListenerService
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {

    companion object {
        private const val REQUEST_CODE_NOTIFICATION_LISTENER = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnEnableNotificationListener: Button = findViewById(R.id.btnEnableNotificationListener)
        btnEnableNotificationListener.setOnClickListener {
            if (!isNotificationServiceEnabled()) {
                val intent = Intent(Settings.ACTION_NOTIFICATION_LISTENER_SETTINGS)
                startActivityForResult(intent, REQUEST_CODE_NOTIFICATION_LISTENER)
            }
        }
    }

    private fun isNotificationServiceEnabled(): Boolean {
        val pkgName = packageName
        val flat = Settings.Secure.getString(contentResolver, "enabled_notification_listeners")
        flat?.split(":")?.forEach { name ->
            if (name.startsWith(pkgName)) {
                return true
            }
        }
        return false
    }
}