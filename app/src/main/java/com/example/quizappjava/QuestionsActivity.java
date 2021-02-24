package com.example.quizappjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Iterator;

public class QuestionsActivity extends AppCompatActivity implements View.OnClickListener {
    private int mCurrentPosition=1;
    private ArrayList mQuestionList;
    private int mSelectedOptionosition;
    private int mCorrectAnswers;
    private String mUserName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions2);
        this.mUserName=this.getIntent().getStringExtra(Constants.USER_NAME);
        this.mQuestionList=Constants.INSTANCE.getQuestions();
        setQuestion();
        ((Button)this.findViewById(R.id.btn_submit)).setOnClickListener((View.OnClickListener)this);
        ((TextView)this.findViewById(R.id.tv_option_one)).setOnClickListener((View.OnClickListener)this);
        ((TextView)this.findViewById(R.id.tv_option_two)).setOnClickListener((View.OnClickListener)this);
        ((TextView)this.findViewById(R.id.tv_option_three)).setOnClickListener((View.OnClickListener)this);
        ((TextView)this.findViewById(R.id.tv_option_four)).setOnClickListener((View.OnClickListener)this);
    }

    private final void setQuestion(){
        ArrayList questions=this.mQuestionList;
        Object que = questions.get(this.mCurrentPosition-1);
        Question question=(Question)que;
        defaultOptionsView();
        int mCurrentPosition=this.mCurrentPosition;
        if(mCurrentPosition==questions.size()){
            ((Button)this.findViewById(R.id.btn_submit)).setText("FINISH");
        }
        else{
            ((Button)this.findViewById(R.id.btn_submit)).setText("SUBMIT");

        }

        ProgressBar progressBar=(ProgressBar)this.findViewById(R.id.progressBar);
        progressBar.setProgress(this.mCurrentPosition);
        //TextView tv_progress=(TextView)this.findViewById(R.id.tv_progress);
        StringBuilder progress=(new StringBuilder()).append(this.mCurrentPosition).append("/").append(((ProgressBar) this.findViewById(R.id.progressBar)).getMax());
        ((TextView)this.findViewById(R.id.tv_progress)).setText(progress.toString());
        TextView tv_question = (TextView)this.findViewById(R.id.tv_question);
        tv_question.setText(question.getQuestion());
        ((ImageView)this.findViewById(R.id.tv_image)).setImageResource(question.getImage());
        ((TextView)this.findViewById(R.id.tv_option_one)).setText(question.getOptionOne());
        ((TextView)this.findViewById(R.id.tv_option_two)).setText(question.getOptionTwo());
        ((TextView)this.findViewById(R.id.tv_option_three)).setText(question.getOptionThree());
        ((TextView)this.findViewById(R.id.tv_option_four)).setText(question.getOptionFour());
    }

    private final void defaultOptionsView() {
        ArrayList options = new ArrayList();
        options.add(0, (TextView)this.findViewById(R.id.tv_option_one));
        options.add(1, (TextView)this.findViewById(R.id.tv_option_two));
        options.add(2, (TextView)this.findViewById(R.id.tv_option_three));
        options.add(3, (TextView)this.findViewById(R.id.tv_option_four));
        Iterator iterator = options.iterator();

        while(iterator.hasNext()) {
            TextView option = (TextView)iterator.next();
            option.setTextColor(Color.parseColor("#7A8089"));
            option.setTypeface(Typeface.DEFAULT);
            option.setBackground(ContextCompat.getDrawable((Context)this, R.drawable.option_border_bg));
        }
    }

    private final void answerView(int answer, int drawableView) {
        TextView var10000;
        switch(answer) {
            case 1:
                ((TextView)this.findViewById(R.id.tv_option_one)).setBackground(ContextCompat.getDrawable((Context)this, drawableView));
                break;
            case 2:
                ((TextView)this.findViewById(R.id.tv_option_two)).setBackground(ContextCompat.getDrawable((Context)this, drawableView));
                break;
            case 3:
                ((TextView)this.findViewById(R.id.tv_option_three)).setBackground(ContextCompat.getDrawable((Context)this, drawableView));
                break;
            case 4:
                ((TextView)this.findViewById(R.id.tv_option_four)).setBackground(ContextCompat.getDrawable((Context)this, drawableView));
        }

    }

    private final void selectedOptionView(TextView tv, int selectedOptionNum) {
        this.defaultOptionsView();
        this.mSelectedOptionosition = selectedOptionNum;
        tv.setTextColor(Color.parseColor("#363A43"));
        tv.setTypeface(tv.getTypeface(), Typeface.BOLD);
        tv.setBackground(ContextCompat.getDrawable((Context)this, R.drawable.selected_option_border));
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.tv_option_one){
           this.selectedOptionView((TextView)this.findViewById(R.id.tv_option_one), 1);
           return;
        }
        if(v.getId()==R.id.tv_option_two){
            this.selectedOptionView((TextView)this.findViewById(R.id.tv_option_two), 2);
            return;
        }
        if(v.getId()==R.id.tv_option_three){
            this.selectedOptionView((TextView)this.findViewById(R.id.tv_option_three), 3);
            return;
        }
        if(v.getId()==R.id.tv_option_four){
            this.selectedOptionView((TextView)this.findViewById(R.id.tv_option_four), 4);
            return;
        }
        if(mSelectedOptionosition==0){
            mCurrentPosition++;

            if(mCurrentPosition<=mQuestionList.size()){
              setQuestion();
            }
            else{
                Intent intent = new Intent((Context)this, ResultActivity.class);
                intent.putExtra(Constants.USER_NAME, this.mUserName);
                intent.putExtra(Constants.CORRECT_ANSWERS, this.mCorrectAnswers);
                intent.putExtra(Constants.TOTAL_QUESTIONS, mQuestionList.size());
                startActivity(intent);
            }

        }

        else{
            Question question=(Question)mQuestionList.get(mCurrentPosition-1);
            if(question.getCorrectAnswer()!=mSelectedOptionosition){
                answerView(mSelectedOptionosition, R.drawable.wrong_option_border_bg);
            }
            else{
                mCorrectAnswers++;
            }
            answerView(question.getCorrectAnswer(), R.drawable.correct_option_border_bg);
            if(mCurrentPosition==mQuestionList.size()){
                ((TextView)this.findViewById(R.id.btn_submit)).setText("FINISH");
            }
            else{
                ((TextView)this.findViewById(R.id.btn_submit)).setText("GO TO NEXT QUESTION");
            }
            mSelectedOptionosition=0;
        }
    }
}