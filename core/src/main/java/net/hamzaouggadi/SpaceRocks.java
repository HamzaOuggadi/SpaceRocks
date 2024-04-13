package net.hamzaouggadi;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import net.hamzaouggadi.game.BaseGame;
import net.hamzaouggadi.screens.LevelScreen;
import net.hamzaouggadi.screens.MenuScreen;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class SpaceRocks extends BaseGame {

    @Override
    public void create() {
        super.create();
        setActiveScreen(new MenuScreen());
    }

}
