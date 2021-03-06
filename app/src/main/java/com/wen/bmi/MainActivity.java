package com.wen.bmi;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
//快捷鍵:
// CTRL+ALT+F       CTRL+P(提醒)        AIT+SHIFT(移動換行)
// CTRL+ALT+M(Extract Method)   CTRL+Y(刪除一行)    ALT+ENTER(String Resourse)
//CTRL+O(Override)       CTRL+R(複製此行)

public class MainActivity extends AppCompatActivity {
    EditText edWeight;
    EditText edHeight;
    private Button help;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        Log.d("MainActivity","onCreate");

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("MainActivity","onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("MainActivity","onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("MainActivity","onDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("MainActivity","onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("MainActivity","onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("MainActivity","onRestart");
    }

    private void findViews() {
        edWeight = findViewById(R.id.ed_weight);
        edHeight = findViewById(R.id.ed_height);
        help = findViewById(R.id.help);
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("MainActivity", "OnClick:help");
                new AlertDialog.Builder(MainActivity.this)
                        .setMessage(R.string.bmi_information)
                        .setPositiveButton(R.string.ok, null)
                        .show();
            }
        });
    }

    public void bmi(View view) {
        Log.d("MainActivity", "bmi");
        String w = edWeight.getText().toString();
        String h = edHeight.getText().toString();
        Log.d("MainActivity", w + "/" + h);
        float weight = Float.parseFloat(w);
        float height = Float.parseFloat(h);
        float bmi = weight / (height * height);
        Log.d("MainActivity", "bmi" + " ");
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("result", bmi);
        startActivity(intent);
        /*Toast.makeText(this,getString(R.string.your_bmi_is)+bmi,Toast.LENGTH_LONG).show();
                 new AlertDialog.Builder(this)  //跑出對話框
                .setMessage(getString(R.string.your_bmi_is)+ bmi)
                .setTitle(R.string.bmi)
                .setPositiveButton("ok", new DialogInterface.OnClickListener() { //按下OK後執行的方法
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        edWeight.setText(" ");  //重置TEXT內容
                        edHeight.setText(" ");
                    }
                })
                .show();
                */
    }
}
