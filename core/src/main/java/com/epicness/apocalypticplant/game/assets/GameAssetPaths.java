package com.epicness.apocalypticplant.game.assets;

public class GameAssetPaths {

    // TODO make a parent class that asks for the location
    // of the images, audio, animations, etc folders to
    // generify the getXXXPath methods
    // Sprites
    public static final String LEAF_BASE = getPNGPath("leaf");
    public static final String LEAF_GLOW = getPNGPath("leafGlow");
    public static final String FISH_BASE = getPNGPath("fish");
    public static final String FISH_GLOW = getPNGPath("fishGlow");
    public static final String HEART = getPNGPath("heart");
    public static final String LIBGDX = getPNGPath("libgdx");
    // Music
    public static final String MUSIC = getOGGPath("mirage");
    // Sounds
    public static final String LEAF_SOUND = getOGGPath("leaf");
    // Fonts
    public static final String PIXEL_FONT = getFNTPath("pixelFont");
    public static final String SMALLER_PIXEL_FONT = getFNTPath("smallerPixelFont");

    private static String getPNGPath(String resource) {
        return "game/images/" + resource + ".png";
    }

    private static String getOGGPath(String resource) {
        return "game/audio/" + resource + ".ogg";
    }

    private static String getFNTPath(String resource) {
        return "game/fonts/" + resource + ".fnt";
    }
}