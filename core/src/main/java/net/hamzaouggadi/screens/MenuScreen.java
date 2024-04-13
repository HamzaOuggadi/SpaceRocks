package net.hamzaouggadi.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

import net.hamzaouggadi.SpaceRocks;
import net.hamzaouggadi.entities.BaseActor;

public class MenuScreen extends BaseScreen {

    @Override
    public void initialize() {
        BaseActor background = new BaseActor(0, 0, mainStage);
        background.loadTexture("imgs/space.png");
        background.setSize(800, 600);

        BaseActor menu = new BaseActor(0, 0, mainStage);
        menu.loadTexture("imgs/MenuScreen.png");
        menu.setSize(menu.getWidth()/2, menu.getHeight()/2);
        menu.centerAtPosition((float) Gdx.graphics.getWidth() /2, (float) Gdx.graphics.getHeight() / 2);

    }

    @Override
    public void update(float dt) {
        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            SpaceRocks.setActiveScreen(new LevelScreen());
        }
    }
}
