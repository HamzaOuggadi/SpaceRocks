package net.hamzaouggadi.game;

import com.badlogic.gdx.Game;

import net.hamzaouggadi.screens.BaseScreen;

public abstract class BaseGame extends Game {

    public static BaseGame game;

    public BaseGame() {
        game = this;
    }

    public static void setActiveScreen(BaseScreen baseScreen) {
        game.setScreen(baseScreen);
    }

    @Override
    public void create() {

    }
}
