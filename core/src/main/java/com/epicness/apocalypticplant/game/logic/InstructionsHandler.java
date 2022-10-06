package com.epicness.apocalypticplant.game.logic;

import static com.badlogic.gdx.graphics.Color.CLEAR;
import static com.badlogic.gdx.graphics.Color.WHITE;
import static com.epicness.fundamentals.SharedConstants.CAMERA_HEIGHT;
import static com.epicness.fundamentals.SharedConstants.CAMERA_WIDTH;

import com.epicness.fundamentals.stuff.Text;

public class InstructionsHandler extends GameLogicHandler {

    private float time;
    private boolean disabled;

    @Override
    protected void init() {
        Text instructions = stuff.getInstructions();
        instructions.setPosition(20f, CAMERA_HEIGHT - 20f);
        instructions.setText("Click the screen before 0\n3 error margin\ni to toggle");
        instructions.setTextTargetWidth(CAMERA_WIDTH);
    }

    public void update(float delta) {
        if (disabled) {
            return;
        }
        time += delta;
        if (time < 10f) {
            return;
        }
        if (time > 20f) {
            time = 20f;
        }
        stuff.getInstructions().setColor(WHITE.cpy().lerp(CLEAR, (time - 10f) / 10f));
    }

    public void iPressed() {
        disabled = !disabled;
        if (disabled) {
            stuff.getInstructions().setColor(CLEAR);
        } else {
            stuff.getInstructions().setColor(WHITE);
            time = 7f;
        }
    }

    public void disable() {
        disabled = true;
        stuff.getInstructions().setColor(CLEAR);
    }
}