package net.hamzaouggadi.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;

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
        // Prepare for multiple classes stages to receive discrete input
        InputMultiplexer inputMultiplexer = new InputMultiplexer();
        Gdx.input.setInputProcessor(inputMultiplexer);
    }
}
