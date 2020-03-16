package com.example.celebrityapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_mark_favorite
import kotlinx.android.synthetic.main.celebrity_item.*

*





class MarkFavorite : AppCompatActivity() {


    val databaseHelper by lazy { CelebrityDatabaseHelper(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mark_favorite)
    }

    fun onClick(view: View) {
        when(view.id){
            R.id.btnGetCelebInfo -> {
                val celebId = etCelebID.text.toString()
                databaseHelper.getOneCelebFromDatabase(celebId)
            }

            R.id.btnMakeFaveCeleb -> {
                val firstName = tvFirstName.text.toString()
                val lastName = tvLastName.text.toString()
                val celebId = tvCelebID.text.toString()
                val isFavorite = tvIsFavorite.text.toString()

            }
        }
    }
}