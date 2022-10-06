package com.epicness.apocalypticplant.game.logic;

import static com.badlogic.gdx.graphics.Color.CLEAR;
import static com.badlogic.gdx.graphics.Color.WHITE;
import static com.badlogic.gdx.utils.Align.center;
import static com.epicness.fundamentals.SharedConstants.CAMERA_HEIGHT;
import static com.epicness.fundamentals.SharedConstants.CAMERA_WIDTH;

import com.epicness.fundamentals.stuff.Text;

public class ScoreHandler extends GameLogicHandler {

    private int score;

    @Override
    protected void init() {
        score = 0;
        Text scoreText = stuff.getScoreText();
        scoreText.setY(CAMERA_HEIGHT - 20f);
        scoreText.setText(score + "");
        scoreText.setTextTargetWidth(CAMERA_WIDTH);
        scoreText.setHorizontalAlignment(center);
        scoreText.setColor(WHITE);
    }

    public void showFinalScore() {
        Text scoreText = stuff.getScoreText();
        scoreText.setText("Game over\nYour score is " + score);
    }

    public void addScore() {
        stuff.getScoreText().setText(++score + "");
    }

    public void disable() {
        stuff.getScoreText().setColor(CLEAR);
    }
}