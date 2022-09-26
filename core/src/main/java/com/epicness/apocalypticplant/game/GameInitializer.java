package com.epicness.apocalypticplant.game;

import com.epicness.apocalypticplant.game.assets.GameAssets;
import com.epicness.apocalypticplant.game.logic.GameLogic;
import com.epicness.apocalypticplant.game.stuff.GameStuff;
import com.epicness.fundamentals.initializer.Initializer;

public class GameInitializer extends Initializer<GameAssets, GameRenderer, GameStuff> {

    public GameInitializer(GameAssets assets) {
        super(assets, new GameLogic(), new GameRenderer(), new GameStuff());
    }
}