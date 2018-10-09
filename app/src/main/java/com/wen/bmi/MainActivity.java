package com.wen.bmi;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
//快捷鍵:CTRL+ALT+F       CTRL+P(提醒)        AIT+SHIFT(移動換行)

public class MainActivity extends AppCompatActivity {
    EditText edWeight;
    EditText edHeight;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edWeight = findViewById(R.id.ed_weight);
        edHeight = findViewById(R.id.ed_height);
    }
    public void bmi (View view){
        Log.d("MainActivity","bmi");
        String w = edWeight.getText().toString();
        String h = edHeight.getText().toString();
        Log.d("MainActivity",w + "/" + h);
        float weight = Float.parseFloat(w);
        float height = Float.parseFloat(h);
        float bmi = weight/(height*height);
        Log.d("MainActivity","bmi"+" ");
        Toast.makeText(this,"Your BMI is "+bmi,Toast.LENGTH_LONG).show();
        new AlertDialog.Builder(this)  //跑出對話框
                .setMessage("Your BMI is"+ bmi)
                .setTitle("BMI")
                .setPositiveButton("ok", new DialogInterface.OnClickListener() { //按下OK後執行的方法
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        edWeight.setText(" ");  //重置TEXT內容
                        edHeight.setText(" ");
                    }
                })
                .show();
    }
}
