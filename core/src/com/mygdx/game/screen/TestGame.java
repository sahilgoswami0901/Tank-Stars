package com.mygdx.game.screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.MyGdxGame;

public class TestGame extends ScreenAdapter implements InputProcessor {
    MyGdxGame game;
    SpriteBatch spriteBatch;
    Sprite ball;
    Texture ballTex;
    boolean isFired;

    Vector2 gravity;
    private float throwAngle=80;
    private float deltaTime=0.1f;
    private Vector2 initialVelocity;

    public TestGame(MyGdxGame game){
        this.game=game;
        spriteBatch=new SpriteBatch();
        ballTex=new Texture("images.jpg");
        ball=new Sprite(ballTex,0,0,128,122);
        ball.setSize(50,50);
        ball.setPosition(0,0);

        Gdx.input.setInputProcessor(this);
        gravity=new Vector2(0, -5000);
        float throwVelocity=2000;
        initialVelocity=new Vector2((float)(throwVelocity*Math.sin(throwAngle * Math.PI / 180)),(float)(throwVelocity*Math.cos(throwAngle * Math.PI / 180)));
    }





    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(1,1,1,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        updateBall();

        spriteBatch.begin();
        ball.draw(spriteBatch);
        spriteBatch.end();
    }

    private void updateBall(){

        if(isFired){

            float delta=Gdx.graphics.getDeltaTime();
            initialVelocity.x=initialVelocity.x+gravity.x*delta*deltaTime;
            initialVelocity.y=initialVelocity.y+gravity.y*delta*deltaTime;

            ball.setPosition(ball.getX()+initialVelocity.x * delta * deltaTime,ball.getY()+initialVelocity.y * delta * deltaTime);
        }

    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
    }

    @Override
    public void dispose() {
        super.dispose();
        ballTex.dispose();
        spriteBatch.dispose();
    }

    @Override
    public boolean keyDown(int keycode) {

        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {

        isFired=true;
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }


}
