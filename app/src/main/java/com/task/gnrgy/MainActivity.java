package com.task.gnrgy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements MyResultReceiver.GetResultInterface {


    Fragment fragment ;
    ComponentName Count ;
    MyResultReceiver myResultReceiver;
    TextView text_time;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text_time=findViewById(R.id.text_time);




        FragmentManager fm = getSupportFragmentManager();
        fragment = fm.findFragmentByTag("myFragmentTag");
        if (fragment == null) {
            FragmentTransaction ft = fm.beginTransaction();
            fragment =new FragmentA();
            ft.add(R.id.frame_container,fragment,"myFragmentTag");
            ft.commit();
        }

      /*  Thread thread = new Thread()
        {
            @Override
            public void run() {
                try {
                    while(true) {
                       Intent intent = new Intent(MainActivity.this,service.class);
                       intent.putExtra("result","myResultReceiver");
                       startService(intent);

                    }
                } catch (Exception e) {

                }
            }
        };

        thread.start();*/

    }

    @Override
    public void getResult(int resultCode, Bundle resultData) {
        if(resultData!=null){
            switch (resultCode){
                case 100:
                    String color=resultData.getString("color");
                    text_time.setText(color);
                    break;
            }
        }
    }
}