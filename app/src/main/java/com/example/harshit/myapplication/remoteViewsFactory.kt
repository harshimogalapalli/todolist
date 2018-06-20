package com.example.harshit.myapplication

import android.content.Context
import android.content.Intent
import android.widget.RemoteViews
import android.widget.RemoteViewsService

class remoteViewsFactory(applicationContext: Context, intent: Intent?): RemoteViewsService.RemoteViewsFactory {

    override fun getLoadingView(): RemoteViews {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        return null!!
    }

    override fun getItemId(position: Int): Long {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        return 1
    }

    override fun onDataSetChanged() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hasStableIds(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        return true
    }

    override fun getViewAt(position: Int): RemoteViews {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

        val rv = RemoteViews("com.example.harshit.myapplication" , R.id.appwidget_listview)

        rv.setTextViewText(R.id.appwidget_text,"abcd")

        return rv
    }

    override fun getCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        return 1
    }

    override fun getViewTypeCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        return 1
    }

    override fun onDestroy() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}