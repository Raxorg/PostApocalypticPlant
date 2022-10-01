package com.epicness.apocalypticplant.game.assets;

import static com.badlogic.gdx.graphics.Texture.TextureFilter.Linear;
import static com.epicness.apocalypticplant.game.assets.GameAssetPaths.FISH_BASE;
import static com.epicness.apocalypticplant.game.assets.GameAssetPaths.FISH_GLOW;
import static com.epicness.apocalypticplant.game.assets.GameAssetPaths.HEART;
import static com.epicness.apocalypticplant.game.assets.GameAssetPaths.LEAF_BASE;
import static com.epicness.apocalypticplant.game.assets.GameAssetPaths.LEAF_GLOW;
import static com.epicness.apocalypticplant.game.assets.GameAssetPaths.LEAF_SOUND;
import static com.epicness.apocalypticplant.game.assets.GameAssetPaths.MUSIC;
import static com.epicness.apocalypticplant.game.assets.GameAssetPaths.PIXEL_FONT;
import static com.epicness.apocalypticplant.game.assets.GameAssetPaths.SMALLER_PIXEL_FONT;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.epicness.fundamentals.assets.Assets;

public class GameAssets extends Assets {

    // Sprites
    private Sprite leaf, leafGlow;
    private Sprite fish, fishGlow;
    private Sprite heart;
    // Music
    private Music music;
    // Sounds
    private Sound leafSound;
    // Fonts
    private BitmapFont pixelFont, smallerPixelFont;

    @Override
    public void queueAssetLoading() {
        loadTexture(LEAF_BASE);
        loadTexture(LEAF_GLOW);
        loadTexture(FISH_BASE);
        loadTexture(FISH_GLOW);
        loadTexture(HEART);
        loadMusic(MUSIC);
        loadSound(LEAF_SOUND);
        loadFont(PIXEL_FONT);
        loadFont(SMALLER_PIXEL_FONT);
    }

    @Override
    public void initializeAssets() {
        // Sprites
        leaf = getSprite(LEAF_BASE, Linear);
        leafGlow = getSprite(LEAF_GLOW, Linear);
        fish = getSprite(FISH_BASE, Linear);
        fishGlow = getSprite(FISH_GLOW, Linear);
        heart = getSprite(HEART, Linear);
        // Music
        music = getMusic(MUSIC);
        // Sounds
        leafSound = getSound(LEAF_SOUND);
        // Fonts
        pixelFont = getFont(PIXEL_FONT, 6f);
        smallerPixelFont = getFont(SMALLER_PIXEL_FONT, 3f);
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

    // Music
    public Music getMusic() {
        return music;
    }

    // Sounds
    public Sound getLeafSound() {
        return leafSound;
    }

    // Fonts
    public BitmapFont getPixelFont() {
        return pixelFont;
    }

    public BitmapFont getSmallerPixelFont() {
        return smallerPixelFont;
    }
}