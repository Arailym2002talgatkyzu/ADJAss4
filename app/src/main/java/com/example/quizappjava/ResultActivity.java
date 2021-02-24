package com.example.quizappjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result2);
        String username=this.getIntent().getStringExtra(Constants.USER_NAME);
        ((TextView)this.findViewById(R.id.tv_name)).setText(username);
        int totalQuestions = this.getIntent().getIntExtra(Constants.TOTAL_QUESTIONS, 0);
        int correctAnswer = this.getIntent().getIntExtra(Constants.CORRECT_ANSWERS, 0);
        ((TextView)this.findViewById(R.id.tv_score)).setText("Your Score is "+correctAnswer+" out of "+totalQuestions);

        ((Button)this.findViewById(R.id.btn_finish)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ResultActivity.this.startActivity(new Intent((Context)ResultActivity.this,MainActivity.class));
            }
        });
    }
}