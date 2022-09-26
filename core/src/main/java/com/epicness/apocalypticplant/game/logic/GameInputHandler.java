package com.epicness.apocalypticplant.game.logic;

import com.badlogic.gdx.Input;
import com.epicness.apocalypticplant.game.stuff.GameStuff;
import com.epicness.fundamentals.input.InputHandler;

public class GameInputHandler extends InputHandler<GameLogic, GameStuff> {

    @Override
    public void touchDown(float x, float y) {
        logic.handler(CounterHandler.class).touchDown();
    }

    @Override
    public void keyDown(int keycode) {
        if (keycode == Input.Keys.I) {
            logic.handler(InstructionsHandler.class).iPressed();
        }
        if (keycode == Input.Keys.R) {
            logic.initialLogic();
        }
    }
}