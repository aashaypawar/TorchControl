package com.example.so

import android.content.Context
import android.hardware.camera2.CameraAccessException
import android.hardware.camera2.CameraManager
import android.os.Build
import android.os.Bundle
import android.widget.Button
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnTorch = findViewById<Button>(R.id.btn)
        var isTorchOn = false

        btnTorch.setOnClickListener {
            
            isTorchOn = !isTorchOn

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                val camManager = getSystemService(Context.CAMERA_SERVICE) as CameraManager
                var cameraId: String? = null
                cameraId = camManager.cameraIdList[0]

                camManager.setTorchMode(cameraId, isTorchOn)
            }
        }
    }
}