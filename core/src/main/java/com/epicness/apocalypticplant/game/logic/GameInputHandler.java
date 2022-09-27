package com.epicness.apocalypticplant.game.logic;

import com.badlogic.gdx.Input;
import com.epicness.apocalypticplant.game.stuff.GameStuff;
import com.epicness.fundamentals.input.InputHandler;

public class GameInputHandler extends InputHandler<GameLogic, GameStuff> {

    @Override
    public void touchDown(float x, float y) {
        logic.handler(CounterHandler.class).touchDown();
        logic.handler(MusicHandler.class).playMusic();
    }

    @Override
    public void keyDown(int keycode) {
        if (keycode == Input.Keys.I) {
            logic.handler(InstructionsHandler.class).iPressed();
        }
        if (keycode == Input.Keys.R) {
            logic.initialLogic();
        }
        if (keycode == Input.Keys.Z) {
            logic.handler(CounterHandler.class).disable();
            logic.handler(FishHandler.class).disable();
            logic.handler(ScoreHandler.class).disable();
            logic.handler(LivesHandler.class).disable();
            logic.handler(InstructionsHandler.class).disable();
        }
    }
}