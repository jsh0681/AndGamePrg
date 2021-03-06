package kr.ac.kpu.game.andgp.SeongHo.game;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "HelloWorld";
    public static final String MSG = "Created";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//리소스를 쫙 훑어서 알아서 r.java라는 파일을 만들어줌 알아서 파일내임 가지고 상수들을 만들어줌

        Log.d(TAG,MSG);
        TextView tv = findViewById(R.id.textView3);
        tv.setText("Launched");

    }

    public void onBtnFirst(View v) {//함수이름이 회색이면 불리지 않은것이다.
        TextView tv = findViewById(R.id.textViewMessage);
        tv.setText("First Button Pressed");

        ImageView iv = findViewById(R.id.catImageView);
        iv.setImageResource(R.mipmap.cat1);
    }
    public void onBtnSecond(View view) {
        ImageView iv = findViewById(R.id.catImageView);
        iv.setImageResource(R.mipmap.cat2);

        Random random  = new Random();
         final int value = random.nextInt(100) + 1;

         final TextView v = findViewById(R.id.textViewMessage);
        v.setText("Random Number : "+value);

        Handler h = new Handler();
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                v.setText("Timer has Changed : "+ (value+100));
            }
        },1000);

    }
    public void onBtnThird(View view) {
        TextView tv = findViewById(R.id.textView);
        int count = 0;
        try
        {
            count = Integer.parseInt((String) tv.getText());
        } catch (Exception e)
        {

        }
                count++;
                tv.setText(String.valueOf(count));
                new AlertDialog.Builder(this).setTitle("Hello").setMessage("World").setPositiveButton("Hahaha", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                            TextView v = findViewById(R.id.textViewMessage);
                            v.setText("Hahaha Dialog Button Pressed");
                    }
                }).setNegativeButton("NONONO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        TextView v = findViewById(R.id.textViewMessage);
                        v.setText("NONONO Dialog Button Pressed");
                    }
                }).create().show();
    }
}
