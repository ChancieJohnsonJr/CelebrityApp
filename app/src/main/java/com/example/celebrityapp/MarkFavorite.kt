package com.example.celebrityapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_my_favorites*


class MarkFavorite : AppCompatActivity() {


    val databaseHelper by lazy { CelebrityDatabaseHelper(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mark_favorite)
    }
}