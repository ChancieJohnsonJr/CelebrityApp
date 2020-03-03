package com.example.celebrityapp

import android.content.ContentUris
import android.net.Uri
import android.provider.BaseColumns

const val CONTENT_AUTHORITY = "com.example.celebrityapp"
val BASE_CONTENT_ID = Uri.parse( "content://${CONTENT_AUTHORITY}")
const val PATH_CELEBRITY = "celebrity"
val CONTENT_URI = BASE_CONTENT_ID.buildUpon().appendPath(PATH_CELEBRITY).build()

class CelebrityEntry : BaseColumns {

    //Static object in Kotlin
    companion object{
        fun buildCelebrityUrri(id: Long) : Uri = ContentUris.withAppendedId(CONTENT_URI, id)
        val CONTENT_TYPE = "vnd.android.cursor.dir/${CONTENT_URI}/${PATH_CELEBRITY}"
        val CONTENT_ITEM_TYPE = "vnd.android..cursor.item/${CONTENT_URI}/${PATH_CELEBRITY}"
    }
}
