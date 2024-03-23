package net.hamzaouggadi.screens;

import net.hamzaouggadi.entities.BaseActor;
import net.hamzaouggadi.entities.SpaceShip;

public class LevelScreen extends BaseScreen {

    private SpaceShip spaceShip;

    @Override
    public void initialize() {
        BaseActor space = new BaseActor(0, 0, mainStage);
        space.loadTexture("imgs/space.png");
        space.setSize(800, 600);
        BaseActor.setWorldBounds(space);

        spaceShip = new SpaceShip(400,300, mainStage);
    }

    @Override
    public void update(float dt) {

    }

}
