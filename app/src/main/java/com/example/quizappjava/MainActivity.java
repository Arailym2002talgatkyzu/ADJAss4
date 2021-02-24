package com.example.quizappjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.app.*;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn_start;
    TextView username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        btn_start = findViewById(R.id.btn_start);
        username=findViewById(R.id.et_name);
        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(username.getText().toString().isEmpty()){
                    Toast.makeText((Context)MainActivity.this, (CharSequence)"Please, enter your name", Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent intent = new Intent((Context)MainActivity.this, QuestionsActivity.class);
                            intent.putExtra(Constants.USER_NAME, String.valueOf(username.getText()));
                            MainActivity.this.startActivity(intent);
                            MainActivity.this.finish();
                }
            }
        });

    }
}