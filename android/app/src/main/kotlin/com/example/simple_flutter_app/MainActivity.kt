package com.example.simple_flutter_app

import android.content.Intent
import androidx.annotation.NonNull
import com.example.mylibrary.LibraryActivity
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.MethodChannel

class MainActivity : FlutterActivity() {

    override fun configureFlutterEngine(@NonNull flutterEngine: FlutterEngine) {
        super.configureFlutterEngine(flutterEngine)
        initializeChannel(flutterEngine)
    }

    private fun initializeChannel(flutterEngine: FlutterEngine) {
        MethodChannel(
            flutterEngine.dartExecutor.binaryMessenger,
            ANDROID_LIBRARY
        ).setMethodCallHandler { call, result ->
            when (call.method) {
                "openAndroidActivity" -> handleOpenAndroidActivity()
                else -> result.notImplemented()
            }
        }
    }

    private fun handleOpenAndroidActivity() {
        startActivity(
            Intent(
                this,
                LibraryActivity::class.java
            )
        )
    }

    companion object {
        private const val ANDROID_LIBRARY = "android_library"
    }

}
