package com.example.harshit.myapplication

import android.app.Activity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_addtask.*

class addtask:Activity() { lateinit var task_details: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addtask)
        var i =intent
        var t=i.getStringExtra("taskdetails")
        taskentry.setText(t,null)
        task_details=t
    }
    var k=1
    fun save(v: View) {
        task_details = taskentry.text.toString().trim { it <= ' ' }

MyGlobal.list.add(task_details)

        var dbh = DatabaseHandler(this)

        var tasks = Tasks(k, task_details)
        dbh.addTask(tasks)

        k=k+1
        finish()
    }

    fun edit(v:View){
        var dbh = DatabaseHandler(this)

        dbh.update(task_details, taskentry.text.toString())
        finish()

    }  fun delete(v:View){
        var dbh = DatabaseHandler(this)

        dbh.delete(task_details)
        finish()

    }

}

