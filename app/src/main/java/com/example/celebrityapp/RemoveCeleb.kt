package com.example.celebrityapp

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_remove_celeb.*

class RemoveCeleb : AppCompatActivity() {

    val databaseHelper by lazy { CelebrityDatabaseHelper(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_remove_celeb)
    }

    fun onClick(view: View){
        when(view.id){
            R.id.btnUpdateCeleb-> {
                val celebId = etCelebID.text.toString()
                databaseHelper.removeCelebrityFromDatabase(celebId)
            }

         }
     }
}
