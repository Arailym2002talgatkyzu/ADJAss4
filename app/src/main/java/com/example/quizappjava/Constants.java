package com.example.quizappjava;

import java.util.ArrayList;

public final class Constants {
    public static final String USER_NAME = "user_name";
    public static final String TOTAL_QUESTIONS = "total_question";
    public static final String CORRECT_ANSWERS = "correct_answers";
    public static final Constants INSTANCE;

    public final ArrayList getQuestions() {
        ArrayList questionList = new ArrayList();
        Question que1 = new Question(1, "What country does this flag belong to?", R.drawable.kz_flag, "Kazakhstan", "Argentina", "Russia", "China", 1);
        questionList.add(que1);
        Question que2 = new Question(2, "What country does this flag belong to?", R.drawable.kr_flag, "Kazakhstan", "Korea", "Argentina", "USA", 2);
        questionList.add(que2);
        Question que3 = new Question(3, "What country does this flag belong to?", R.drawable.bz_flag, "Mexico", "Belgium", "Botswana", "Belize", 4);
        questionList.add(que3);
        Question que4 = new Question(2, "What country does this flag belong to?", R.drawable.ai_flag, "Angola", "Armenia", "Anguilla", "Andorra", 3);
        questionList.add(que4);
        Question que5 = new Question(2, "What country does this flag belong to?", R.drawable.jp_flag, "Japan", "Korea", "Bangladesh", "Greenland", 1);
        questionList.add(que5);
        return questionList;
    }

    private Constants() {
    }

    static {
        Constants var0 = new Constants();
        INSTANCE = var0;
    }
}
