package com.epicness.apocalypticplant.game.logic;

import com.epicness.fundamentals.logic.Logic;

public class GameLogic extends Logic {

    private final CounterHandler counterHandler;
    private final FishHandler fishHandler;
    private final InstructionsHandler instructionsHandler;
    private final OverlayHandler overlayHandler;

    public GameLogic() {
        registerHandler(counterHandler = new CounterHandler());
        registerHandler(fishHandler = new FishHandler());
        registerHandler(instructionsHandler = new InstructionsHandler());
        registerHandler(new GameInputHandler());
        registerHandler(new InstructionsHandler());
        registerHandler(new LivesHandler());
        registerHandler(new MusicHandler());
        registerHandler(overlayHandler = new OverlayHandler());
        registerHandler(new PlantHandler());
        registerHandler(new ResetButtonHandler());
        registerHandler(new ScoreHandler());
        registerHandler(new ZenButtonHandler());
    }

    @Override
    public void update(float delta) {
        counterHandler.update(delta);
        fishHandler.update(delta);
        instructionsHandler.update(delta);
        overlayHandler.update(delta);
    }
}