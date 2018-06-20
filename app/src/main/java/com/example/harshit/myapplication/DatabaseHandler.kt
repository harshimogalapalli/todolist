package com.example.harshit.myapplication

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import com.example.harshit.myapplication.Tasks
import java.util.*

class DatabaseHandler(context: Context) : SQLiteOpenHelper(context, DatabaseHandler.DB_NAME, null, DatabaseHandler.DB_VERSION) {

    override fun onCreate(db: SQLiteDatabase) {
        val CREATE_TABLE = "CREATE TABLE $TABLE_NAME ($ID INTEGER PRIMARY KEY, $TASKDETAILS TEXT);"
        db.execSQL(CREATE_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        val DROP_TABLE = "DROP TABLE IF EXISTS $TABLE_NAME"
        db.execSQL(DROP_TABLE)
        onCreate(db)
    }

    fun addTask(tasks: Tasks): Boolean {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(TASKDETAILS, tasks.taskdetails)
        val _success = db.insert(TABLE_NAME, null, values)
        db.close()
        Log.v("InsertedId", "$_success")
        return (Integer.parseInt("$_success") != -1)
    }

    fun getTask(_id: Int): Tasks {
        val tasks = Tasks()
        val db = writableDatabase
        val selectQuery = "SELECT  * FROM $TABLE_NAME WHERE $ID = $_id"
        val cursor = db.rawQuery(selectQuery, null)

        cursor?.moveToFirst()
        tasks.taskdetails = cursor.getString(cursor.getColumnIndex(TASKDETAILS))
        cursor.close()
        return tasks
    }

    fun task(): List<Tasks> {
        val taskList = ArrayList<Tasks>()
        val db = writableDatabase
        val selectQuery = "SELECT  * FROM $TABLE_NAME"
        val cursor = db.rawQuery(selectQuery, null)
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    val tasks = Tasks()
                     tasks.taskdetails = cursor.getString(cursor.getColumnIndex(TASKDETAILS))
                    taskList.add(tasks)
                } while (cursor.moveToNext())
            }
        }
        cursor.close()
        return taskList
    }

    fun gettasklist(): List<String> {
        val taskList = ArrayList<String>()
        val db = writableDatabase
        val selectQuery = "SELECT  * FROM $TABLE_NAME"
        val cursor = db.rawQuery(selectQuery, null)
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    //val tasks = Tasks()
                    val taskdetails = cursor.getString(cursor.getColumnIndex(TASKDETAILS))
                    taskList.add(taskdetails)
                } while (cursor.moveToNext())
            }
        }
        cursor.close()
        return taskList
    }

    fun update(tasks: Tasks): Boolean {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(TASKDETAILS, tasks.taskdetails)
        val _success = db.update(TABLE_NAME, values, ID + "=?", arrayOf(tasks.id.toString())).toLong()
        db.close()
        return Integer.parseInt("$_success") != -1
    }

    fun update(taskold:String, tasknew:String): Boolean {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(TASKDETAILS, tasknew)
        val _success = db.update(TABLE_NAME, values, "taskdetails" + "=?", arrayOf(taskold)).toLong()
        db.close()
        return Integer.parseInt("$_success") != -1
    }

    fun delete(taskdetails:String): Boolean {
        val db = this.writableDatabase
        val _success = db.delete(TABLE_NAME, "taskdetails" + "=?", arrayOf(taskdetails)).toLong()
        db.close()
        return Integer.parseInt("$_success") != -1
    }
    fun delete(_id: Int): Boolean {
        val db = this.writableDatabase
        val _success = db.delete(TABLE_NAME, ID + "=?", arrayOf(_id.toString())).toLong()
        db.close()
        return Integer.parseInt("$_success") != -1
    }


    companion object {
        private val DB_VERSION = 1
        private val DB_NAME = "MyTasks"
        private val TABLE_NAME = "Tasks"
        private val ID = "Id"
        private val TASKDETAILS = "Taskdetails"
         }
}