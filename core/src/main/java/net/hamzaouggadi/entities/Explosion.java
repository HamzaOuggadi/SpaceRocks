package net.hamzaouggadi.entities;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;

public class Explosion extends BaseActor {

    public Explosion(float x, float y, Stage stage) {

        super(x, y, stage);

        loadAnimationFromSheet("imgs/explosion.png", 6, 6, 0.03f, false);

//        addAction(Actions.delay(1));
//        addAction(Actions.after(Actions.fadeOut(0.5f)));
//        addAction(Actions.after(Actions.removeActor()));

    }

    @Override
    public void act(float delta) {
        super.act(delta);
        if (isAnimationFinished()) {
            remove();
        }
    }
}
