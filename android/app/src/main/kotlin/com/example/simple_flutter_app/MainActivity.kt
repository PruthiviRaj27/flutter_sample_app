package com.example.simple_flutter_app

import AndroidHostApi
import MessageData
import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.annotation.NonNull
import com.example.mylibrary.LibraryActivity
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine

private class PigeonApiImplementation(val context: Context) : AndroidHostApi {

    override fun openFragment(name: String, callback: (Result<Unit>) -> Unit) {
        context.startActivity(
            Intent(
                context,
                LibraryActivity::class.java
            )
        )
        Toast.makeText(context,name,Toast.LENGTH_SHORT).show()
    }

    override fun sendMessage(message: MessageData, callback: (Result<Boolean>) -> Unit) {
//        if (message.code == Code.ONE) {
//            callback(Result.failure(FlutterError("code", "message", "details")))
//            return
//        }
//        callback(Result.success(true))
    }
}
class MainActivity : FlutterActivity() {

    override fun configureFlutterEngine(@NonNull flutterEngine: FlutterEngine) {
        super.configureFlutterEngine(flutterEngine)

        val api = PigeonApiImplementation(this)
        AndroidHostApi.setUp(flutterEngine.dartExecutor.binaryMessenger, api)
    }

}
