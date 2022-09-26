package com.epicness.apocalypticplant.game.stuff;

import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.epicness.apocalypticplant.game.assets.GameAssets;
import com.epicness.fundamentals.stuff.Sprited;
import com.epicness.fundamentals.stuff.Stuff;
import com.epicness.fundamentals.stuff.Text;

public class GameStuff extends Stuff<GameAssets> {

    private Plant plant;
    private DelayedRemovalArray<Leaf> leaves;
    private Text instructions, counter, gameOverText;
    private DelayedRemovalArray<Sprited> lives;
    private DelayedRemovalArray<Fish> fish;

    @Override
    public void initializeStuff() {
        sharedAssets.getPixelFont().getData().setScale(3f);
        plant = new Plant();
        leaves = new DelayedRemovalArray<>();
        instructions = new Text(sharedAssets.getPixelFont());
        counter = new Text(sharedAssets.getPixelFont());
        gameOverText = new Text(sharedAssets.getPixelFont());
        lives = new DelayedRemovalArray<>();
        fish = new DelayedRemovalArray<>();
    }

    public Plant getPlant() {
        return plant;
    }

    public DelayedRemovalArray<Leaf> getLeaves() {
        return leaves;
    }

    public Text getInstructions() {
        return instructions;
    }

    public Text getCounter() {
        return counter;
    }

    public Text getGameOverText() {
        return gameOverText;
    }

    public DelayedRemovalArray<Sprited> getLives() {
        return lives;
    }

    public DelayedRemovalArray<Fish> getFishes() {
        return fish;
    }
}