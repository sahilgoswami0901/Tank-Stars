package com.mygdx.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.MyGdxGame;
import com.sun.org.apache.xerces.internal.impl.dv.xs.YearDV;
import org.w3c.dom.Text;
import com.badlogic.gdx.ScreenAdapter;

public class ExitScreen extends ScreenAdapter {
    MyGdxGame game;

    Sprite sprite;

    Texture question;

    Label exiting;

    Button yes;


    Music music;
    Button no;
    Stage stage;
    Skin myskin;


    public ExitScreen(final MyGdxGame game){
        this.game=game;

        stage=new Stage(new ScreenViewport());

        myskin=new Skin(Gdx.files.internal(MyGdxGame.skin));
        Gdx.input.setInputProcessor(stage);

        question=new Texture("final.png");
        sprite=new Sprite(question,0,0,1500,1500);
        sprite.setPosition(50,350);
        sprite.setSize(300,200);
        music=Gdx.audio.newMusic(Gdx.files.internal("Arcade-background-music-retro-style (1).wav"));

        exiting=new Label("Do You really want to Exit ?",myskin,"big");
        exiting.setSize(600,100);
        exiting.setPosition(370,400);

        stage.addActor(exiting);
        yes =new TextButton("NO",myskin,"small");
        yes.setSize(200,100);
        yes.setPosition(800,200);

        yes.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){
                music.stop();
                game.setScreen(new MainScreen(game));

            }
        });

        stage.addActor(yes);
        no=new TextButton("YES",myskin,"small");
        no.setSize(200,100);
        no.setPosition(500,200);
        no.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){
                Gdx.app.exit();
//                game.setScreen(new GameScreen2(game));
            }
        });

        stage.addActor(no);

        music.setVolume(0.3f);
        music.setLooping(true);
        music.play();



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
        stage.act();
        stage.draw();
        sprite.draw(game.batch);
        game.batch.end();
    }
}
