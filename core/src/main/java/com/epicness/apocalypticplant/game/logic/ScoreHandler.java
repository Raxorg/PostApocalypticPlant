package com.epicness.apocalypticplant.game.logic;

import static com.epicness.fundamentals.SharedConstants.CAMERA_HEIGHT;

import com.epicness.fundamentals.stuff.Text;

public class ScoreHandler extends GameLogicHandler {

    private int score;

    @Override
    protected void init() {
        Text score = stuff.getGameOverText();
        score.setY(CAMERA_HEIGHT * 0.6f);
        score.setText("score: " + score);
    }

    public void showFinalScore() {
        Text scoreText = stuff.getGameOverText();
        scoreText.setText("Game over\nYour score is " + score + "\nr to restart");
    }

    public void addScore() {
        score *= 2;
        Text scoreText = stuff.getGameOverText();
        scoreText.setText("score: " + score);
    }
}