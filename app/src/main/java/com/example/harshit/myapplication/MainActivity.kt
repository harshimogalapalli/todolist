package com.example.harshit.myapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import com.example.harshit.myapplication.MyGlobal.list
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lvtasks.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, position, id ->
            var tv:TextView = view as TextView
            var taskdetails = tv.getText().toString()


            Toast.makeText(this, taskdetails, Toast.LENGTH_LONG).show()

           //Passing data to addtask activity.
            var intent = Intent(this,addtask::class.java)
  intent.putExtra("taskdetails", taskdetails)
           startActivity(intent)

        }
        }

    override fun onRestart() {
        super.onRestart()
        show()
    }

   fun addtask(v: View){
        val intent = Intent(this@MainActivity, addtask::class.java)
       intent.putExtra("taskdetails", "")
        startActivity(intent)
    }

    fun show(){


        var dbh = DatabaseHandler(this)

var adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, dbh.gettasklist())

        lvtasks.adapter=adapter
    }
}
