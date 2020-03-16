package com.example.celebrityapp

package com.example.celebrityapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class CelebEntry extends Activity {

    val databaseHelper by lazy{CelebrityDatabaseHelper(context: this)}

    override fun onCreate(savedInstanceState:Bundle?) {
        super.onCreate(savedInstance)
        setContentView(R.layout.activity_celeb_entry)
    }

    fun  onClick(View view) {
        when(view.id){
            R .id.btnAddCelebrityToList -> {
                val firstName = etFirstName.text.toString()
                val firstName = etLastName.text.toString()
                val firstName = etCelebId.text.toString()
                val isFavorite = "false"
                databaseHelper.insertCelebrityInList(Celebrity(firstName, lastName, celebId, isFavorite))
            }
        }
    }
}
