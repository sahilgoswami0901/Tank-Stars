package com.mygdx.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.MyGdxGame;

public class Winning2 extends ScreenAdapter {

    MyGdxGame game;
    Texture player1;
    Sprite sprite1;

    Texture win;
    Sprite winn;
    Stage stage;
    Skin myskin;
    Button exit;
    Texture back;
    Sprite backk;

    public Winning2(MyGdxGame game){
        this.game=game;
        stage=new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        myskin=new Skin(Gdx.files.internal(MyGdxGame.skin));
        if(Player2.player2hellio==1){
            player1=new Texture("Helios.jpg");
            sprite1=new Sprite(player1,0,0,200,150);
            sprite1.setPosition(700,200);
            sprite1.setSize(300,250);
        }else if(Player2.player2blazer==2){
            player1=new Texture("Blazer.jpg");
            sprite1=new Sprite(player1,0,0,200,150);
            sprite1.setPosition(700,200);
            sprite1.setSize(300,250);
        }
        else if(Player2.player2pumpkin==1){
            player1=new Texture("Pumpkin_Tank_transparent.jpg");
            sprite1=new Sprite(player1,0,0,350,202);
            sprite1.setPosition(700,200);
            sprite1.setSize(350,202);
        }
        win=new Texture("congratulation.jpg");
        winn=new Sprite(win,0,0,800,826);
        winn.setPosition(150,50);
        winn.setSize(400,400);

        back=new Texture("background.jpg");
        backk=new Sprite(back,0,0,284,177);
        backk.setSize(1300,700);
        backk.setPosition(0,0);

        exit=new TextButton("Exit",myskin,"small");
        exit.setSize(100,50);
        exit.setPosition(1100,20);
        exit.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){
                Gdx.app.exit();
            }
        });
        stage.addActor(exit);


    }
    @Override
    public void show(){
        super.show();

    }
    @Override
    public void render(float delta){
        Gdx.gl.glClearColor(117/255f, 6/255f, 161/255f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.begin();

        backk.draw(game.batch);
        sprite1.draw(game.batch);
        winn.draw(game.batch);

        stage.act();
        stage.draw();
        game.batch.end();
    }

}

