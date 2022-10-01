package com.epicness.apocalypticplant.game.logic;

import static com.epicness.fundamentals.SharedConstants.CAMERA_HEIGHT;
import static com.epicness.fundamentals.SharedConstants.CAMERA_WIDTH;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.epicness.apocalypticplant.game.stuff.Fish;

public class FishHandler extends GameLogicHandler {

    private float time;
    private boolean disabled;

    @Override
    protected void init() {
        disabled = false;
    }

    public void update(float delta) {
        if (disabled) {
            return;
        }
        time -= delta;
        if (time <= 0f) {
            spawnFish();
            time = MathUtils.random(-1.2f, 4.5f);
        }
        moveFish(delta);
    }

    private void spawnFish() {
        Fish fish = new Fish(assets.getFishGlow(), assets.getFish(), assets.getSmallerPixelFont());
        fish.translateX(CAMERA_WIDTH);
        fish.translateY(MathUtils.random(CAMERA_HEIGHT - fish.getBackgroundHeight()));
        stuff.getFishes().add(fish);
    }

    private void moveFish(float delta) {
        DelayedRemovalArray<Fish> fishes = stuff.getFishes();
        fishes.begin();
        for (int i = 0; i < fishes.size; i++) {
            Fish fish = fishes.get(i);
            fish.translateX(-fish.speed * delta);
            if (fish.getX() < -500f) {
                fishes.removeValue(fish, true);
            }
        }
        fishes.end();
    }

    public void disable() {
        disabled = true;
        stuff.getFishes().clear();
    }
}