package com.epicness.apocalypticplant.game.assets;

import static com.badlogic.gdx.graphics.Texture.TextureFilter.Linear;
import static com.epicness.apocalypticplant.game.assets.GameAssetPaths.LEAF_BASE;
import static com.epicness.apocalypticplant.game.assets.GameAssetPaths.LEAF_GLOW;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.epicness.fundamentals.assets.Assets;

public class GameAssets extends Assets {

    // Sprites
    private Sprite leaf, leafGlow;

    @Override
    public void queueAssetLoading() {
        loadTexture(LEAF_BASE);
        loadTexture(LEAF_GLOW);
    }

    @Override
    public void initializeAssets() {
        leaf = getSprite(LEAF_BASE, Linear);
        leafGlow = getSprite(LEAF_GLOW, Linear);
    }

    // Sprites
    public Sprite getLeaf() {
        return leaf;
    }

    public Sprite getLeafGlow() {
        return leafGlow;
    }
}