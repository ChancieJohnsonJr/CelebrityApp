package com.example.celebrityapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_data_base.*
import kotlinx.android.synthetic.main.activity_remove_celeb.*
import kotlinx.android.synthetic.main.activity_remove_celeb.etCelebID
import kotlinx.android.synthetic.main.activity_view_celebrity.*

class ViewCelebrity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_celebrity)
    }

    fun onClick(view: View){
        when(view.id){
            R.id.btnUpdateCeleb-> {
                val firstName = etFirstName.text.toString()
                val lastName = etLastName.text.toString()
                val celebId = etCelebID.text.toString()
                val isFavorite = "false"
                databaseHelper.updateCelebrityInDatabase(Celebrity(firstName, lastName, celebId, isFavorite))
            }

        }
    }
}
