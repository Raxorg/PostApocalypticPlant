package com.epicness.apocalypticplant.game;

import static com.epicness.fundamentals.SharedConstants.CAMERA_WIDTH;

public class GameConstants {

    public static final float PLANT_RADIUS = 5f;

    private static final float LEAF_IMG_WIDTH = 307f;
    private static final float LEAF_IMG_HEIGHT = 193f;
    private static final float LEAF_SCALE = 0.6f;
    public static final float LEAF_WIDTH = LEAF_IMG_WIDTH * LEAF_SCALE;
    public static final float LEAF_HEIGHT = LEAF_IMG_HEIGHT * LEAF_SCALE;
    public static final float LEAF_ORIGIN_X = LEAF_WIDTH * 0.16f;
    public static final float LEAF_ORIGIN_Y = LEAF_HEIGHT * 0.55f;

    public static final float BUTTON_SIZE = 80f;
    public static final float BUTTON_X = CAMERA_WIDTH - BUTTON_SIZE;
}