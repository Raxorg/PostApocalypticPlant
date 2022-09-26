package com.epicness.apocalypticplant.game.stuff;

import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.epicness.apocalypticplant.game.assets.GameAssets;
import com.epicness.fundamentals.stuff.Stuff;

public class GameStuff extends Stuff<GameAssets> {

    private DelayedRemovalArray<Leaf> leaves;

    @Override
    public void initializeStuff() {
        leaves = new DelayedRemovalArray<>();
        Leaf leaf = new Leaf(assets.getLeaf(), assets.getLeafGlow());
        leaves.add(leaf);
    }

    public DelayedRemovalArray<Leaf> getLeaves() {
        return leaves;
    }
}