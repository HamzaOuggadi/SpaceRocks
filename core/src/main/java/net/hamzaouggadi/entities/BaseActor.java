package net.hamzaouggadi.entities;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class BaseActor extends Actor {

    private Animation<TextureRegion> animation;
    private float elapsedTime;
    private boolean isAnimationPaused;
    private Vector2 velocityVec;
    private Vector2 accelerationVec;
    private float acceleration;
    private float maxSpeed;
    private float deceleration;
    private Polygon boundaryPolygon;
    private static Rectangle worldBounds;

    public BaseActor(float x, float y, Stage stage) {
        super();

        animation = null;
        elapsedTime = 0f;
        isAnimationPaused = false;
        velocityVec = new Vector2(0f,0f);
        accelerationVec = new Vector2(0f, 0f);
        acceleration = 0f;
        maxSpeed = 1000f;
        deceleration = 0f;

        setPosition(x, y);
        stage.addActor(this);
    }
}
