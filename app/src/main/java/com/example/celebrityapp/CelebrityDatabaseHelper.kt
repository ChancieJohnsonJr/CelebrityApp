package com.example.celebrityapp

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.core.content.contentValuesOf
import com.example.celebrityapp.*

class CelebrityDatabaseHelper(context : Context) : SQLiteOpenHelper(context, DATABASE_NAME,
        factory: null, DATABASE_VERSION){
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
        contentValues.put(COL_CELEB_ID, celebrity.celebId)
        contentValues.put(COL_IS_FAVORITE, celebrity.isFavorite)

        database.insert(TABLE_NAME, nullColumnHack: null, contentValues)
        database.close()

    }

    fun getOneCelebrityFromDatabase(id: String): Celebrity? {
        val database = readableDatabase
        var celebrity: Celebrity? = null
        val cursor = database.rawQuery(sql:
                "SELECT * FROM $TABLE_NAME WHERE $COL_CELEB_ID" + "= '$celebid'", selectionArgs: null)

        if (cursor.moveToFirst()) {
            val firstName = cursor.getString(cursor.getColumnIndex(COL_FIRST_NAME))
            val lastName = cursor.getString(cursor.getColumnIndex(COL_LAST_NAME))
            val job = cursor.getString(cursor.getColumnIndex(COL_CELEB_ID))
            val id= cursor.getString(cursor.getColumnIndex(COL_IS_FAVORITE))
            celebrity = Celebrity(firstName, lastName, celebId, isFavorite)
        }
        cursor.close()
        database.close()
        return celebrity
    }

    fun getAllCelebritiesFromDatabase(): ArrayList<Celebrity> {
        val database = readableDatabase
        var celebrityList: ArrayList<Celebrity> = ArrayList<Celebrity>()
        val cursor = database
            .rawQuery(sql: "SELECT * FROM $TABLE_NAME", selectionArgs: null)

        if (cursor.moveToFirst()) {
            do {
                val firstName = cursor.getString(cursor.getColumnIndex(COL_FIRST_NAME))
                val lastName = cursor.getString(cursor.getColumnIndex(COL_LAST_NAME))
                val celebId = cursor.getString(cursor.getColumnIndex(COL_CELEB_ID))
                val isFavorite = cursor.getString(cursor.getColumnIndex(COL_IS_FAVORITE))
                val celebrity = Celebrity(firstName, lastName, celebId, isFavorite)
                celebrityList.add(celebrity)
            } while (cursor.moveToNext())
        }

        cursor.close()
        database.close()
        return celebrityList
    }

    fun updateCelebrityInDatabase(celebrity: Celebrity) {
        val database = writableDatabase
        val contentValues = ContentValues()
        contentValues.put(COL_FIRST_NAME, celebrity.firstName)
        contentValues.put(COL_LAST_NAME, celebrity.lastName)
        contentValues.put(COL_CELEB_ID, celebrity.celebId)
        contentValues.put(COL_IS_FAVORITE, celebrity.isFavorite)

        database.update(TABLE_NAME, contentValues, whereClause: "$COL_CELEB_ID = ?", arrayOf(celebrity.celebId))
        database.close()
    }

    fun removeCelebrityFromDatabase(celebId: String) {
        val database = writableDatabase
        database.delete(TABLE_NAME, whereClause: "$COL_CELEB_ID = ?", arrayOf(celebId))
        database.close()
    }

    fun updateFavoriteInDatabase(celebrity: Celebrity) {
        val database = writableDatabase
        val contentValues = ContentValues()
        contentValues.put(COL_FIRST_NAME, celebrity.firstName)
        contentValues.put(COL_LAST_NAME, celebrity.lastName)
        contentValues.put(COL_CELEB_ID, celebrity.celebId)
        contentValues.put(COL_IS_FAVORITE, celebrity.isFavorite)

        database.update(TABLE_NAME, contentValues, whereClause: "$COL_CELEB_ID = ?", arrayOf(celebrity.celebId))
        database.close()
    }
}
