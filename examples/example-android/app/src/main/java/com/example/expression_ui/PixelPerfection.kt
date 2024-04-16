@file:OptIn(ExperimentalAssetLoader::class)

package com.example.expression_ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.startup.AppInitializer
import app.rive.runtime.kotlin.RiveAnimationView
import app.rive.runtime.kotlin.RiveInitializer
import app.rive.runtime.kotlin.controllers.RiveFileController
import app.rive.runtime.kotlin.core.ExperimentalAssetLoader
import app.rive.runtime.kotlin.core.RiveEvent


class PixelPerfection : ComponentActivity() {
    private val yourRiveAnimationView: RiveAnimationView by lazy(LazyThreadSafetyMode.NONE) {
        findViewById(R.id.pixel_perfection_view)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AppInitializer.getInstance(applicationContext)
            .initializeComponent(RiveInitializer::class.java)

        setContentView(R.layout.pixel_perfection)

        yourRiveAnimationView.addEventListener(eventListener)
        super.onCreate(savedInstanceState)
    }

    override fun onDestroy() {
        yourRiveAnimationView.removeEventListener(eventListener);
        super.onDestroy()
    }

    private val eventListener = object : RiveFileController.RiveEventListener {
        override fun notifyEvent(event: RiveEvent) {
            if (event.name == "next_tapped") {

                startActivity(Intent(baseContext, Compossable::class.java))
            }
        }
    }
}