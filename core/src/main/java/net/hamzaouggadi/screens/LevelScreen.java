package net.hamzaouggadi.screens;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;

import net.hamzaouggadi.entities.BaseActor;
import net.hamzaouggadi.entities.Explosion;
import net.hamzaouggadi.entities.Rock;
import net.hamzaouggadi.entities.SpaceShip;

public class LevelScreen extends BaseScreen {

    private SpaceShip spaceShip;
    private boolean gameOver;

    @Override
    public void initialize() {
        BaseActor space = new BaseActor(0, 0, mainStage);
        space.loadTexture("imgs/space.png");
        space.setSize(800, 600);
        BaseActor.setWorldBounds(space);
        gameOver = false;

        spaceShip = new SpaceShip(400,300, mainStage);

        new Rock(600, 500, mainStage);
        new Rock(600, 300, mainStage);
        new Rock(600, 100, mainStage);
        new Rock(400, 100, mainStage);
        new Rock(200, 100, mainStage);
        new Rock(200, 300, mainStage);
        new Rock(200, 500, mainStage);
        new Rock(400, 500, mainStage);
    }

    @Override
    public void update(float dt) {

        for (BaseActor rockActor : BaseActor.getList(mainStage, "net.hamzaouggadi.entities.Rock")) {

            if (rockActor.overlaps(spaceShip)) {

                if (spaceShip.shieldPower <= 0) {
                    Explosion boom = new Explosion(0,0, mainStage);
                    boom.centerAtActor(spaceShip);
                    spaceShip.remove();
                    spaceShip.setPosition(-1000, -1000);
                    BaseActor messageLose = new BaseActor(0, 0, uiStage);
                    messageLose.loadTexture("imgs/message-lose.png");
                    messageLose.centerAtPosition(400, 300);
                    messageLose.setOpacity(0);
                    messageLose.addAction(Actions.fadeIn(1));
                    gameOver = true;
                } else {
                    spaceShip.shieldPower -= 34;
                    Explosion boomRock = new Explosion(0, 0, mainStage);
                    boomRock.centerAtActor(rockActor);
                    rockActor.remove();
                }
            }

            for (BaseActor laserActor : BaseActor.getList(mainStage, "net.hamzaouggadi.entities.Laser")) {
                if (laserActor.overlaps(rockActor)) {
                    Explosion boomLaser = new Explosion(0, 0, mainStage);
                    boomLaser.centerAtActor(rockActor);
                    laserActor.remove();
                    rockActor.remove();
                }
            }
        }

        if (!gameOver && BaseActor.count(mainStage, "net.hamzaouggadi.entities.Rock") == 0) {
            BaseActor messageWin = new BaseActor(0, 0, uiStage);
            messageWin.loadTexture("imgs/message-win.png");
            messageWin.centerAtPosition(400, 300);
            messageWin.setOpacity(0);
            messageWin.addAction(Actions.fadeIn(1));
            gameOver = true;
        }

    }

    @Override
    public boolean keyDown(int keycode) {
        if (keycode == Input.Keys.X) {
            spaceShip.warp();
        }
        if (keycode == Input.Keys.SPACE) {
            spaceShip.shoot();
        }
        return false;
    }
}
