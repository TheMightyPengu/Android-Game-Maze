package com.example.mymaze

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


class MazeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maze)

        val mazeView = MazeActivity2(this, null)

        setContentView(mazeView)
    }
}
