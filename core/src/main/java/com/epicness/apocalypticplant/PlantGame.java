package com.epicness.apocalypticplant;

import com.badlogic.gdx.Game;
import com.epicness.apocalypticplant.game.GameInitializer;
import com.epicness.apocalypticplant.game.assets.GameAssets;
import com.epicness.fundamentals.SharedResources;

public class PlantGame extends Game {

    @Override
    public void create() {
        GameAssets assets = new GameAssets();
        assets.queueAssetLoading();
        assets.finishLoading();
        assets.initializeAssets();
        new GameInitializer(assets).initialize(new SharedResources());
    }
}