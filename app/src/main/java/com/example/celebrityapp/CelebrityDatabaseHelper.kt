package com.example.celebrityapp

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.core.content.contentValuesOf
import com.example.celebrityapp.*

class CelebrityDatabaseHelper(context : Context)
    : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    override fun onCreate(sqLiteDatabase: SQLiteDatabase?) {
        sqLiteDatabase?.execSQL(CREATE_CELEBRITY_TABLE)
    }

    override fun onUpgrade(sqLiteDatabase: SQLiteDatabase?, previousVersion: Int, newVersion: Int) {
        onCreate(sqLiteDatabase)
    }

    fun insertCelebrityIntoDatabase(person: Celebrity) {
        val database = writableDatabase
        val contentValues = ContentValues()

        contentValues.put(COL_FIRST_NAME, celebrity.firstName)
        contentValues.put(COL_LAST_NAME, celebrity.lastName)
        contentValues.put(COL_JOB, celebrity.job)
        contentValues.put(COL_ID, celebrity.id)

        database.insert(TABLE_NAME, null, contentValues)
        database.close()

    }

    fun getOneCelebrityFromDatabase(ssn: String): Celebrity? {
        val database = readableDatabase
        var celebrity: Celebrity? = null
        val cursor = database
            .rawQuery(
                "SELECT * FROM $TABLE_NAME WHERE $COL_ID = '$id'",
                null
            )

        if (cursor.moveToFirst()) {
            val firstName = cursor.getString(cursor.getColumnIndex(COL_FIRST_NAME))
            val lastName = cursor.getString(cursor.getColumnIndex(COL_LAST_NAME))
            val job = cursor.getString(cursor.getColumnIndex(COL_JOB))
            val id= cursor.getString(cursor.getColumnIndex(COL_ID))
            celebrity = Celebrity(firstName, lastName, job, id)
        }
        cursor.close()
        database.close()
        return celebrity
    }

    fun getAllCelebritiesFromDatabase(): ArrayList<Celebrity> {
        val database = readableDatabase
        var personList: ArrayList<Celebrity = ArrayList<Celebrity>()
        val cursor = database
            .rawQuery(
                "SELECT * FROM $TABLE_NAME",
                null
            )

        if (cursor.moveToFirst()) {
            do {
                val firstName = cursor.getString(cursor.getColumnIndex(COL_FIRST_NAME))
                val lastName = cursor.getString(cursor.getColumnIndex(COL_LAST_NAME))
                val job = cursor.getString(cursor.getColumnIndex(COL_JOB))
                val id = cursor.getString(cursor.getColumnIndex(COL_ID))
                val celebrity = Celebrity(firstName, lastName, job, id)
                celebrityList.add(celebrity)
            } while (cursor.moveToNext())
        }

        cursor.close()
        database.close()
        return celebrityList
    }

    fun updatePCelebrityInDatabase(celebrity: Celebrity) {
        val database = writableDatabase
        val contentValues = ContentValues()
        contentValues.put(COL_FIRST_NAME, celebrity.firstName)
        contentValues.put(COL_LAST_NAME, celebrity.lastName)
        contentValues.put(COL_JOB, celebrity.job)
        contentValues.put(COL_ID, celebrity.id)

        database.update(TABLE_NAME, contentValues, "$COL_ID = ?", arrayOf(celebrity.id))
        database.close()
    }

    fun removeCelebrityFromDatabase(ssn: String) {
        val database = writableDatabase
        database.delete(TABLE_NAME, "$COL_ID = ?", arrayOf(id))
        database.close()
    }
}
