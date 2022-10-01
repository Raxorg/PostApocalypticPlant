package com.epicness.apocalypticplant.game.logic;

import com.badlogic.gdx.Input;
import com.epicness.apocalypticplant.game.stuff.GameStuff;
import com.epicness.fundamentals.input.InputHandler;

public class GameInputHandler extends InputHandler<GameLogic, GameStuff> {

    @Override
    public void touchDown(float x, float y) {
        logic.get(CounterHandler.class).touchDown();
        logic.get(MusicHandler.class).playMusic();
        logic.get(ResetButtonHandler.class).touchDown(x, y);
        logic.get(ZenButtonHandler.class).touchDown(x, y);
    }

    @Override
    public void touchDragged(float x, float y) {
        logic.get(ZenButtonHandler.class).touchDragged(x, y);
        logic.get(ResetButtonHandler.class).touchDragged(x, y);
    }

    @Override
    public void touchUp(float x, float y) {
        logic.get(ResetButtonHandler.class).touchUp(x, y);
        logic.get(ZenButtonHandler.class).touchUp(x, y);
    }

    @Override
    public void keyDown(int keycode) {
        if (keycode == Input.Keys.I) {
            logic.get(InstructionsHandler.class).iPressed();
        }
        if (keycode == Input.Keys.R) {
            logic.get(ResetButtonHandler.class).buttonPressed();
        }
        if (keycode == Input.Keys.Z) {
            logic.get(ZenButtonHandler.class).buttonPressed();
        }
    }
}