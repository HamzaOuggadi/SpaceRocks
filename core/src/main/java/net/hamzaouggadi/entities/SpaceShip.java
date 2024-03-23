package net.hamzaouggadi.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class SpaceShip extends BaseActor {

    public SpaceShip(float x, float y, Stage stage) {

        super(x, y, stage);

        loadTexture("imgs/spaceship.png");
        setBoundaryPolygon(8);

        setAcceleration(200);
        setMaxSpeed(200);
        setDeceleration(10);

    }

    @Override
    public void act(float delta) {
        super.act(delta);

        float degreesPerSecond = 120; // Rotation speed

        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            rotateBy(degreesPerSecond * delta);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            rotateBy(-degreesPerSecond * delta);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            accelerateAtAngle(getRotation());
        }

        applyPhysics(delta);

        wrapAroundWorld();

    }
}
