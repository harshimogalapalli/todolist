package com.example.harshit.myapplication

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.widget.RemoteViewsService

class MyService : RemoteViewsService() {
    override fun onGetViewFactory(intent: Intent?): RemoteViewsFactory {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        return remoteViewsFactory(this.applicationContext, intent)

}

    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }
}
