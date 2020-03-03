package com.example.celebrityapp

const val DATABASE_NAME = "data_celeb_database"
const val TABLE_NAME = "celeb_table"
const val DATABASE_VERSION = 1
const val COL_FIRST_NAME = "first_name"
const val COL_LAST_NAME = "last_name"
const val COL_CELEB_ID = "celebId"
const val COL_IS_FAVORITE = "isFavorite"

const val CREATE_CELEBRITY_TABLE =
    "CREATE TABLE $TABLE_NAME (" +
            "$COL_FIRST_NAME String," +
            "$COL_LAST_NAME String," +
            "$COL_CELEB_ID String PRIMARY_KEY," +
            "$COL_IS_FAVORITE String"