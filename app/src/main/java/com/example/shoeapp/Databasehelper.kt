package com.example.shoeapp

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import android.database.sqlite.SQLiteOpenHelper

class Databasehelper(context: Context) : SQLiteOpenHelper(context,DATABASE_NAME,null,DATABASE_VERSION) {
    companion object {
        private val DATABASE_VERSION = 1
        private val DATABASE_NAME = "UserDatabase"
        private val TABLE_USERS = "UserTable"
        private val KEY_PRICE = "Price"
        private val KEY_NUMBER = "Number"
        private val KEY_NAME = "Name"
        private val KEY_BRAND = "Brand"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val CREATE_CONTACTS_TABLE = ("CREATE TABLE IF NOT EXISTS " + TABLE_USERS + "(" + KEY_PRICE + " INTERGER PRIMARY KEY," + KEY_NUMBER + " TEXT," + KEY_NAME + " TEXT," + KEY_BRAND + " TEXT" + ")")
        db?.execSQL(CREATE_CONTACTS_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS" + TABLE_USERS)
        onCreate(db)
    }

    fun addUsers(sqlLiteModel: UploadModel): Long {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(KEY_PRICE, sqlLiteModel.price)
        contentValues.put(KEY_NUMBER, sqlLiteModel.number)
        contentValues.put(KEY_NAME, sqlLiteModel.Name)
        contentValues.put(KEY_BRAND, sqlLiteModel.brandSelected)
        val success = db.insert(TABLE_USERS, null, contentValues)
        db.close()
        return success
    }
    fun readData() : List<UploadModel>{
        val userArray: ArrayList<UploadModel> = ArrayList<UploadModel>()
        val  selectQuery = "SELECT * FROM $TABLE_USERS"
        val db = this.readableDatabase
        var cursor: Cursor? = null
        try {
            cursor = db.rawQuery(selectQuery,null)
        } catch (e: SQLiteException){
            db.execSQL(selectQuery)
            return ArrayList()
        }
        var userPrice: Int
        var userNumber: Int
        var userName: String
        var userBrand: String
        if (cursor.moveToFirst()){
            do {
                userPrice = cursor.getInt(cursor.getColumnIndex("Price"))
                userNumber = cursor.getInt(cursor.getColumnIndex("Number"))
                userName = cursor.getString(cursor.getColumnIndex("Name"))
                userBrand = cursor.getString(cursor.getColumnIndex("Brand"))

                val users = UploadModel(price = userPrice, number = userNumber, Name = userName, brandSelected = userBrand)
                userArray.add(users)
            } while (cursor.moveToNext())
        }
        return userArray
    }
}