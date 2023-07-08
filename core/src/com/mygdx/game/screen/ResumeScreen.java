package com.mygdx.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.ScreenAdapter;
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
import org.w3c.dom.Text;
import com.badlogic.gdx.ScreenAdapter;
import sun.reflect.generics.scope.DummyScope;

import javax.sql.rowset.spi.TransactionalWriter;

public class ResumeScreen extends ScreenAdapter {
        MyGdxGame game;
        private Skin myskin;

        private Button Back;

    public Skin getMyskin() {
        return myskin;
    }

    public void setMyskin(Skin myskin) {
        this.myskin = myskin;
    }

    public Button getBack() {
        return Back;
    }

    public void setBack(Button back) {
        Back = back;
    }

    Texture logo;
    Sprite logosprite;
    Button saved1;
        Button saved2;
        Button saved3;
        Button saved4;
        Button saved5;
        Button saved6;
        Button saved7;
        Button saved8;
        Button saved9;
        Button saved10;
        Button saved11;
        Button saved12;
        Button saved13;
        Button saved14;
        Button saved15;
        Button saved16;
        Button saved17;
        Button saved18;

        Sprite sprite;

        Label savedgames;
        Stage stage;

        public ResumeScreen(final MyGdxGame game){
            this.game=game;
            stage =new Stage(new ScreenViewport());
            myskin=new Skin(Gdx.files.internal(MyGdxGame.skin));
            Gdx.input.setInputProcessor(stage);
            savedgames=new Label("SAVED GAMES",myskin,"big");

            savedgames.setSize(200,100);
            savedgames.setPosition(400,500);
            stage.addActor(savedgames);

            saved1=new TextButton("Game1",myskin,"small");
            saved1.setSize(150,100);
            saved1.setPosition(30,400);
            saved1.addListener(new ClickListener(){
                @Override
                public void clicked(InputEvent event, float x, float y){
                    game.setScreen(new GameScreen(game));

                }
            });

            stage.addActor(saved1);

            saved2=new TextButton("Game2",myskin,"small");
            saved2.setSize(150,100);
            saved2.setPosition(230,400);
            saved2.addListener(new ClickListener(){
                @Override
                public void clicked(InputEvent event, float x, float y){
                    game.setScreen(new GameScreen(game));

                }
            });

            stage.addActor(saved2);

            saved3=new TextButton("Game3",myskin,"small");
            saved3.setSize(150,100);
            saved3.setPosition(430,400);
            saved3.addListener(new ClickListener(){
                @Override
                public void clicked(InputEvent event, float x, float y){

                }
            });

            stage.addActor(saved3);

            saved4=new TextButton("Game4",myskin,"small");
            saved4.setSize(150,100);
            saved4.setPosition(630,400);
            saved4.addListener(new ClickListener(){
                @Override
                public void clicked(InputEvent event, float x, float y){

                }
            });

            stage.addActor(saved4);
            saved5=new TextButton("Game5",myskin,"small");
            saved5.setSize(150,100);
            saved5.setPosition(830,400);
            saved5.addListener(new ClickListener(){
                @Override
                public void clicked(InputEvent event, float x, float y){

                }
            });

            stage.addActor(saved5);

            saved6=new TextButton("Game6",myskin,"small");
            saved6.setSize(150,100);
            saved6.setPosition(1030,400);
            saved6.addListener(new ClickListener(){
                @Override
                public void clicked(InputEvent event, float x, float y){

                }
            });

            stage.addActor(saved6);

            saved7=new TextButton("Game7",myskin,"small");
            saved7.setSize(150,100);
            saved7.setPosition(30,250);
            saved7.addListener(new ClickListener(){
                @Override
                public void clicked(InputEvent event, float x, float y){

                }
            });

            stage.addActor(saved7);

            saved8=new TextButton("Game8",myskin,"small");
            saved8.setSize(150,100);
            saved8.setPosition(230,250);
            saved8.addListener(new ClickListener(){
                @Override
                public void clicked(InputEvent event, float x, float y){

                }
            });

            stage.addActor(saved8);
            Back=new TextButton("<<",myskin,"small");
            Back.setSize(100,50);
            Back.setPosition(20,530);
            Back.addListener(new ClickListener(){
                @Override
                public void clicked(InputEvent event, float x, float y){
                    game.setScreen(new MainScreen(game));

                }
            });
            stage.addActor(Back);

            saved9=new TextButton("Game9",myskin,"small");
            saved9.setSize(150,100);
            saved9.setPosition(430,250);
            saved9.addListener(new ClickListener(){
                @Override
                public void clicked(InputEvent event, float x, float y){

                }
            });
            stage.addActor(saved9);

            saved10=new TextButton("Game10",myskin,"small");
            saved10.setSize(150,100);
            saved10.setPosition(630,250);
            saved10.addListener(new ClickListener(){
                @Override
                public void clicked(InputEvent event, float x, float y){

                }
            });

            stage.addActor(saved10);

            saved11=new TextButton("Game11",myskin,"small");
            saved11.setSize(150,100);
            saved11.setPosition(830,250);
            saved11.addListener(new ClickListener(){
                @Override
                public void clicked(InputEvent event, float x, float y){

                }
            });

            stage.addActor(saved11);

            saved12=new TextButton("Game12",myskin,"small");
            saved12.setSize(150,100);
            saved12.setPosition(1030,250);
            saved12.addListener(new ClickListener(){
                @Override
                public void clicked(InputEvent event, float x, float y){

                }
            });

            stage.addActor(saved12);

            saved13=new TextButton("Game13",myskin,"small");
            saved13.setSize(150,100);
            saved13.setPosition(30,90);
            saved13.addListener(new ClickListener(){
                @Override
                public void clicked(InputEvent event, float x, float y){

                }
            });

            stage.addActor(saved13);

            saved14=new TextButton("Game14",myskin,"small");
            saved14.setSize(150,100);
            saved14.setPosition(230,90);
            saved14.addListener(new ClickListener(){
                @Override
                public void clicked(InputEvent event, float x, float y){

                }
            });

            stage.addActor(saved14);

            saved15=new TextButton("Game15",myskin,"small");
            saved15.setSize(150,100);
            saved15.setPosition(430,90);
            saved15.addListener(new ClickListener(){
                @Override
                public void clicked(InputEvent event, float x, float y){

                }
            });
            stage.addActor(saved15);

            saved16=new TextButton("Game17",myskin,"small");
            saved16.setSize(150,100);
            saved16.setPosition(830,90);
            saved16.addListener(new ClickListener(){
                @Override
                public void clicked(InputEvent event, float x, float y){

                }
            });

            stage.addActor(saved16);

            saved18=new TextButton("Game16",myskin,"small");
            saved18.setSize(150,100);
            saved18.setPosition(630,90);
            saved18.addListener(new ClickListener(){
                @Override
                public void clicked(InputEvent event, float x, float y){

                }
            });

            stage.addActor(saved18);



            saved17=new TextButton("Game18",myskin,"small");
            saved17.setSize(150,100);
            saved17.setPosition(1030,90);
            saved17.addListener(new ClickListener(){
                @Override
                public void clicked(InputEvent event, float x, float y){

                }
            });

            stage.addActor(saved17);
//            logo=new Texture("tankstarlogo.png");
//            logosprite=new Sprite(logo,0,0,404,316);
//            logosprite.setSize(1300,700);
//            logosprite.setPosition(0,0);






        }
    @Override
    public void show(){
        super.show();

    }
    public void render(float delta){
        Gdx.gl.glClearColor(117/255f, 6/255f, 161/255f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.begin();
//        logosprite.draw(game.batch);
        stage.act();
        stage.draw();
        game.batch.end();
    }

}
