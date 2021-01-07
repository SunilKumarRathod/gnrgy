package com.task.gnrgy;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.ResultReceiver;

import androidx.annotation.Nullable;
import androidx.core.app.JobIntentService;

import java.util.Timer;
import java.util.TimerTask;

public class service extends IntentService {
    int count;
    String color;
    boolean status=false;

    ResultReceiver myResultReceiver;

    private final IBinder mBinder = new MyBinder();

    /**
     * @param name
     * @deprecated
     */
    public service(String name) {
        super(name);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    protected void onHandleIntent(@Nullable final Intent intent) {
        Timer T=new Timer();
        T.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                count++;
                if(count==60 && !status){
                    color="red";
                    count=0;
                    status=true;

                }
                if(count==60 && status){
                    color="green";
                    count=0;
                    status=false;
                }

                if(intent!=null){
                    myResultReceiver =  intent.getParcelableExtra("result");
                }
                Bundle bundle = new Bundle();
                bundle.putString("color",color);
                myResultReceiver.send(100,bundle);



            }
        }, 1000, 1000);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {


          return Service.START_NOT_STICKY;
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    public class MyBinder extends Binder {
         service getService() {
            return service .this;
        }
    }

    public String getRetValue() {
        return String.valueOf(count);
    }
}
