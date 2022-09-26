package com.epicness.apocalypticplant.game.logic;

import static com.badlogic.gdx.graphics.Color.CLEAR;
import static com.badlogic.gdx.graphics.Color.WHITE;
import static com.badlogic.gdx.utils.Align.center;
import static com.epicness.fundamentals.SharedConstants.CAMERA_HEIGHT;
import static com.epicness.fundamentals.SharedConstants.CAMERA_WIDTH;

import com.epicness.fundamentals.stuff.Text;

public class InstructionsHandler extends GameLogicHandler {

    @Override
    protected void init() {
        Text instructions = stuff.getInstructions();
        instructions.setY(CAMERA_HEIGHT * 0.8f);
        instructions.setText("Click the screen before 0\n.3 error margin\ni to hide");
        instructions.setTextTargetWidth(CAMERA_WIDTH);
        instructions.setHorizontalAlignment(center);
        instructions.setColor(WHITE);
    }

    public void iPressed() {
        stuff.getInstructions().setColor(CLEAR);
    }
}