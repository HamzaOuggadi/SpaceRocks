package net.hamzaouggadi.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class SpaceShip extends BaseActor {

    private Thrusters thrusters;
    private Shield shield;
    public int shieldPower;

    public SpaceShip(float x, float y, Stage stage) {

        super(x, y, stage);

        loadTexture("imgs/spaceship.png");
        setBoundaryPolygon(8);

        setAcceleration(200);
        setMaxSpeed(200);
        setDeceleration(10);

        thrusters = new Thrusters(0, 0, stage);
        addActor(thrusters);
        thrusters.setPosition(-thrusters.getWidth(), getHeight()/2 - thrusters.getHeight()/2);

        shield = new Shield(0, 0, stage);
        addActor(shield);
        shield.centerAtPosition(getWidth() / 2, getHeight() / 2);
        shieldPower = 100;

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
            thrusters.setVisible(true);
        } else {
            thrusters.setVisible(false);
        }

        applyPhysics(delta);

        wrapAroundWorld();

        shield.setOpacity(shieldPower / 100f);
        if (shieldPower <= 0) {
            shield.setVisible(false);
        }

    }

    public void warp() {
        if (getStage() == null) {
            return;
        }
        Warp warp1 = new Warp(0, 0, this.getStage());
        warp1.centerAtActor(this);
        setPosition(MathUtils.random(800), MathUtils.random(800));
        Warp warp2 = new Warp(0, 0, this.getStage());
        warp2.centerAtActor(this);
    }

    public void shoot() {
        if (getStage() == null) {
            return;
        }

        Laser laser = new Laser(0, 0, getStage());
        laser.centerAtActor(this);
        laser.setRotation(this.getRotation());
        laser.setMotionAngle(this.getRotation());
    }
}
