package com.epicness.apocalypticplant.game.logic;

import static com.badlogic.gdx.graphics.Color.CLEAR;
import static com.epicness.fundamentals.SharedConstants.CAMERA_HEIGHT;
import static com.epicness.fundamentals.SharedConstants.CAMERA_WIDTH;

import com.epicness.fundamentals.stuff.Text;

public class InstructionsHandler extends GameLogicHandler {

    @Override
    protected void init() {
        Text instructions = stuff.getInstructions();
        instructions.setPosition(20f, CAMERA_HEIGHT - 20f);
        instructions.setText("Click the screen before 0\n.3 error margin\ni to hide");
        instructions.setTextTargetWidth(CAMERA_WIDTH);
    }

    public void iPressed() {
        stuff.getInstructions().setColor(CLEAR);
    }

    public void disable() {
        stuff.getInstructions().setColor(CLEAR);
    }
}