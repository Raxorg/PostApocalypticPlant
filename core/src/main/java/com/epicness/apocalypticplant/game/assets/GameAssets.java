package com.epicness.apocalypticplant.game.assets;

import static com.badlogic.gdx.graphics.Texture.TextureFilter.Linear;
import static com.epicness.apocalypticplant.game.assets.GameAssetPaths.FISH_BASE;
import static com.epicness.apocalypticplant.game.assets.GameAssetPaths.FISH_GLOW;
import static com.epicness.apocalypticplant.game.assets.GameAssetPaths.HEART;
import static com.epicness.apocalypticplant.game.assets.GameAssetPaths.LEAF_BASE;
import static com.epicness.apocalypticplant.game.assets.GameAssetPaths.LEAF_GLOW;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.epicness.fundamentals.assets.Assets;

public class GameAssets extends Assets {

    // Sprites
    private Sprite leaf, leafGlow;
    private Sprite fish, fishGlow;
    private Sprite heart;

    @Override
    public void queueAssetLoading() {
        loadTexture(LEAF_BASE);
        loadTexture(LEAF_GLOW);
        loadTexture(FISH_BASE);
        loadTexture(FISH_GLOW);
        loadTexture(HEART);
    }

    @Override
    public void initializeAssets() {
        leaf = getSprite(LEAF_BASE, Linear);
        leafGlow = getSprite(LEAF_GLOW, Linear);
        fish = getSprite(FISH_BASE, Linear);
        fishGlow = getSprite(FISH_GLOW, Linear);
        heart = getSprite(HEART, Linear);
    }

    // Sprites
    public Sprite getLeaf() {
        return leaf;
    }

    public Sprite getLeafGlow() {
        return leafGlow;
    }

    public Sprite getFish() {
        return fish;
    }

    public Sprite getFishGlow() {
        return fishGlow;
    }

    public Sprite getHeart() {
        return heart;
    }
}