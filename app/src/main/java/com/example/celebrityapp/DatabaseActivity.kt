package com.example.celebrityapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.celebrityapp.CelebrityCallback
import com.example.celebrityapp.R
import kotlinx.android.synthetic.main.activity_data_base.*


abstract class DatabaseActivity : AppCompatActivity(), CelebrityCallback {
    val databaseHelper by lazy{ CelebrityDatabaseHelper(this)}
    val adapter by lazy {CelebrityRVAdapter(databaseHelper.getAllCelebritiesFromDatabase(), this)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_base)
        initRecyclerView()
    }

    override fun passCelebrity(celebrity: Celebrity) {
        etFirstName.setText(celebrity.firstName)
        etLastName.setText(celebrity.lastName)
        etCelebID.setText(celebrity.celebId)
        etIsFavorite.setText(celebrity.isFavorite)
    }

    fun onClick(view: View) {
        when(view.id) {
            R.id.btnAddCelebrityToList -> {
                val firstName = etFirstName.text.toString()
                val lastName = etLastName.text.toString()
                val job = etJob.text.toString()
                val id = etId.text.toString()
                databaseHelper.insertCelebrityIntoDatabase(Celebrity(firstName, lastName, job, id))
            }
            R.id.btnUpdateCelebrityToList -> {
                val firstName = etFirstName.text.toString()
                val lastName = etLastName.text.toString()
                val job = etJob.text.toString()
                val id = etId.text.toString()
                databaseHelper.updateCelebrityInDatabase(Celebrity(firstName, lastName, job, id))
            }
            R.id.btnDeleteCelebrityToList -> {
                val id = etId.text.toString()
                databaseHelper.removeCelebrityFromDatabase(id)
            }
        }
        adapter.updateList(databaseHelper.getAllCelebritiesFromDatabase())
    }

    private fun initRecyclerView() {
        rvCelebrityList.layoutManager = LinearLayoutManager(this)
        rvCelebrityList.adapter = adapter
    }
}