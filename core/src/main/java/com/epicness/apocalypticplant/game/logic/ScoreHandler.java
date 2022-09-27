package com.epicness.apocalypticplant.game.logic;

import static com.badlogic.gdx.utils.Align.center;
import static com.epicness.fundamentals.SharedConstants.CAMERA_HEIGHT;
import static com.epicness.fundamentals.SharedConstants.CAMERA_WIDTH;

import com.epicness.fundamentals.stuff.Text;

public class ScoreHandler extends GameLogicHandler {

    private int score;

    @Override
    protected void init() {
        score = 1;
        Text scoreText = stuff.getGameOverText();
        scoreText.setY(CAMERA_HEIGHT - 20f);
        scoreText.setText("score: " + score);
        scoreText.setTextTargetWidth(CAMERA_WIDTH);
        scoreText.setHorizontalAlignment(center);
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