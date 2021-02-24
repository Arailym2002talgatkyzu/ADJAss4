package com.example.quizappjava;

public final class Question {
    private final int id;
    private final String question;
    private final int image;
    private final String optionOne;
    private final String optionTwo;
    private final String optionThree;
    private final String optionFour;
    private final int correctAnswer;

    public Question(int id, String question, int image, String optionOne, String optionTwo, String optionThree, String optionFour, int correctAnswer){
        super();
        this.id = id;
        this.question = question;
        this.image = image;
        this.optionOne = optionOne;
        this.optionTwo = optionTwo;
        this.optionThree = optionThree;
        this.optionFour = optionFour;
        this.correctAnswer = correctAnswer;
    }

    public final int getId() {
        return this.id;
    }


    public final String getQuestion() {
        return this.question;
    }

    public final int getImage() {
        return this.image;
    }


    public final String getOptionOne() {
        return this.optionOne;
    }


    public final String getOptionTwo() {
        return this.optionTwo;
    }


    public final String getOptionThree() {
        return this.optionThree;
    }


    public final String getOptionFour() {
        return this.optionFour;
    }

    public final int getCorrectAnswer() {
        return this.correctAnswer;
    }
}
