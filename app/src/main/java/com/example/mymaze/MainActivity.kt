package com.example.mymaze

import android.content.Intent
import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import androidx.activity.ComponentActivity
import kotlin.math.abs
import androidx.core.content.res.ResourcesCompat
import android.media.MediaPlayer


//import androidx.compose.foundation.gestures.ModifierLocalScrollableContainerProvider.value

class MainActivity : ComponentActivity(), GestureDetector.OnGestureListener {

     private lateinit var gestureDetector: GestureDetector
     private var y1: Float = 0.0f
     private var y2: Float = 0.0f

    companion object {
        const val MIN_DISTANCE = 150
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        gestureDetector = GestureDetector(this, this)

        ResourcesCompat.getDrawable(resources, R.drawable.welcome, null)

        var mMediaPlayer: MediaPlayer? = null
        if (mMediaPlayer == null) {
            mMediaPlayer = MediaPlayer.create(this, R.raw.starting)
            mMediaPlayer.start()
        } else mMediaPlayer.start()
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {

        if (event != null) {
            gestureDetector.onTouchEvent(event)
        }

        when (event?.action) {
            0 -> {
                y1 = event.y
            }

            1 -> {
                y2 = event.y

                val valueY: Float = y2 - y1

                if (abs(valueY) > MIN_DISTANCE) {
                    if (valueY > 0) {
                        //Toast.makeText(this, "Down swipe", Toast.LENGTH_SHORT).show()
                        finishAffinity()
                    } else {
                        //Toast.makeText(this, "Upper swipe", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this, MazeActivity::class.java)
                        startActivity(intent)
                    }
                }
            }
        }
        return super.onTouchEvent(event)
    }

    override fun onDown(p0: MotionEvent): Boolean {
        return false
    }

    override fun onShowPress(p0: MotionEvent) {
    }

    override fun onSingleTapUp(p0: MotionEvent): Boolean {
        return false
    }

    override fun onScroll(e1: MotionEvent?, p0: MotionEvent, p2: Float, p3: Float): Boolean {
        return false
    }

    override fun onLongPress(p0: MotionEvent) {
    }

    override fun onFling(e1: MotionEvent?, p0: MotionEvent, p2: Float, p3: Float): Boolean {
        return false
    }
}
