package com.epicness.apocalypticplant.game.stuff;

import static com.epicness.apocalypticplant.game.GameConstants.BUTTON_SIZE;
import static com.epicness.apocalypticplant.game.GameConstants.BUTTON_X;
import static com.epicness.fundamentals.SharedConstants.CAMERA_HEIGHT;
import static com.epicness.fundamentals.SharedConstants.CAMERA_WIDTH;

import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.epicness.apocalypticplant.game.assets.GameAssets;
import com.epicness.fundamentals.stuff.DualSprited;
import com.epicness.fundamentals.stuff.Sprited;
import com.epicness.fundamentals.stuff.SpritedText;
import com.epicness.fundamentals.stuff.Stuff;
import com.epicness.fundamentals.stuff.Text;

public class GameStuff extends Stuff<GameAssets> {

    private Plant plant;
    private DelayedRemovalArray<DualSprited> leaves;
    private Text instructions, counter, gameOverText;
    private DelayedRemovalArray<Sprited> lives;
    private SpritedText resetButton, zenButton;
    private DelayedRemovalArray<Fish> fish;
    private Sprited overlay;

    @Override
    public void initializeStuff() {
        plant = new Plant();
        leaves = new DelayedRemovalArray<>();
        instructions = new Text(assets.getSmallerPixelFont());
        counter = new Text(assets.getPixelFont());
        gameOverText = new Text(assets.getSmallerPixelFont());
        lives = new DelayedRemovalArray<>();

        resetButton = new SpritedText(sharedAssets.getSquareInverted(), assets.getSmallerPixelFont());
        resetButton.setSize(BUTTON_SIZE, BUTTON_SIZE);
        resetButton.setPosition(BUTTON_X, BUTTON_SIZE);
        resetButton.setText("R");

        zenButton = new SpritedText(sharedAssets.getSquareInverted(), assets.getSmallerPixelFont());
        zenButton.setSize(BUTTON_SIZE, BUTTON_SIZE);
        zenButton.setX(BUTTON_X);
        zenButton.setText("Z");

        fish = new DelayedRemovalArray<>();
        overlay = new Sprited(sharedAssets.getPixel());
        overlay.setSize(CAMERA_WIDTH, CAMERA_HEIGHT);
    }

    public Plant getPlant() {
        return plant;
    }

    public DelayedRemovalArray<DualSprited> getLeaves() {
        return leaves;
    }

    public Text getInstructions() {
        return instructions;
    }

    public Text getCounter() {
        return counter;
    }

    public Text getScoreText() {
        return gameOverText;
    }

    public DelayedRemovalArray<Sprited> getLives() {
        return lives;
    }

    public SpritedText getResetButton() {
        return resetButton;
    }

    public SpritedText getZenButton() {
        return zenButton;
    }

    public DelayedRemovalArray<Fish> getFishes() {
        return fish;
    }

    public Sprited getOverlay() {
        return overlay;
    }
}