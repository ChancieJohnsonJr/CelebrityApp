package com.example.celebrityapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClick(view: View) {
        when(view.id){
            R.id.btnAddCelebrityToList -> startActivity(Intent(packageContext: this, CelebrityEntry::class.java))
            R.id.btnViewAllCelebs -> startActivity(Intent(packageContext: this, ViewAllCelebs::class.java))
            R.id.btnUpdateCelebrityToList -> startActivity(Intent(packageContext: this, ViewCelebrity::class.java))
            R.id.btnViewFaves -> startActivity(Intent(packageContext: this, MyFavorite::class.java))
            R.id.ibnRemoveCeleb -> startActivity(Intent(packageContext: this, RemoveCeleb::class.java))
            R.id.ibnMarkFavorite -> startActivity(Intent(packageContext: this, MarkFavorite::class.java))
        }
    }
}




