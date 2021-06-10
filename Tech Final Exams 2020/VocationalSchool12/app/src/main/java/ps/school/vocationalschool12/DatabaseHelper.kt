package ps.school.vocationalschool12

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import android.database.sqlite.SQLiteOpenHelper
class SchoolModel(
    var id: Int,
    var name: String,
    var address: String,
    var phone: Int,
    var number: Int
) {

}

class DatabaseHandler(context: Context): SQLiteOpenHelper(context,DATABASE_NAME,null,DATABASE_VERSION) {
    companion object {
        private val DATABASE_VERSION = 1
        private val DATABASE_NAME = "school_db"
        private val TABLE_NAME = "school"
        private val KEY_ID = "Id"
        private val KEY_NAME = "Name"
        private val KEY_ADDRESS = "Address"
        private val KEY_PHONE = "Phone"
        private val KEY_NUMBER = "Number"
    }
    override fun onCreate(db: SQLiteDatabase?) {
        val CREATE_TABLE = ("CREATE TABLE " + TABLE_NAME + "("
                + KEY_ID +  " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + KEY_NAME +  " TEXT,"
                + KEY_ADDRESS +  " TEXT,"
                + KEY_PHONE +  " INTEGER,"
                + KEY_NUMBER +  " INTEGER"
                + ")"
                )
        db?.execSQL(CREATE_TABLE)
    }
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }
    fun addSchool(modelClass: SchoolModel):Long{
        val db = this.writableDatabase
        val contentValues = ContentValues()
//        contentValues.put(KEY_ID, modelClass.id)
        contentValues.put(KEY_NAME, modelClass.name)
        contentValues.put(KEY_ADDRESS, modelClass.address)
        contentValues.put(KEY_PHONE, modelClass.phone)
        contentValues.put(KEY_NUMBER, modelClass.number)
        val success = db.insert(TABLE_NAME, null, contentValues)
        db.close()
        return success
    }
    fun viewSchool():ArrayList<SchoolModel>{
        val list = ArrayList<SchoolModel>()
        val selectQuery = "SELECT  * FROM $TABLE_NAME"
        val db = this.readableDatabase
        var cursor: Cursor? = null
        try{
            cursor = db.rawQuery(selectQuery, null)
        }catch (e: SQLiteException) {
            db.execSQL(selectQuery)
            return ArrayList()
        }

        if (cursor.moveToFirst()) {
            do {

                val modelClass = SchoolModel(
                    cursor.getInt(cursor.getColumnIndex(KEY_ID)),
                    cursor.getString(cursor.getColumnIndex(KEY_NAME)),
                    cursor.getString(cursor.getColumnIndex(KEY_ADDRESS)),
                    cursor.getInt(cursor.getColumnIndex(KEY_PHONE)),
                    cursor.getInt(cursor.getColumnIndex(KEY_NUMBER))
                )
                list.add(modelClass)
            } while (cursor.moveToNext())
        }
        return list
    }
    fun deleteSchool(modelClass: SchoolModel):Int{
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(KEY_ID, modelClass.id)
        val success = db.delete(TABLE_NAME,"$KEY_ID="+modelClass.id,null)
        db.close()
        return success
    }
}