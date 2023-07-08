package com.mygdx.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.MyGdxGame;

public class MainScreen extends ScreenAdapter {
    MyGdxGame game;
    private Sprite sprite;

    private Texture frontpicture;

    private Skin myskin;
    private Button NewGame;
    private Button ResumeGame;
    private Button ExitGame;

    Music music;

    public Sprite getSprite() {
        return sprite;
    }

    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }

    public Texture getFrontpicture() {
        return frontpicture;
    }

    public void setFrontpicture(Texture frontpicture) {
        this.frontpicture = frontpicture;
    }

    public Skin getMyskin() {
        return myskin;
    }

    public void setMyskin(Skin myskin) {
        this.myskin = myskin;
    }

    public Button getNewGame() {
        return NewGame;
    }

    public void setNewGame(Button newGame) {
        NewGame = newGame;
    }

    public Button getResumeGame() {
        return ResumeGame;
    }

    public void setResumeGame(Button resumeGame) {
        ResumeGame = resumeGame;
    }

    public Button getExitGame() {
        return ExitGame;
    }

    public void setExitGame(Button exitGame) {
        ExitGame = exitGame;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    private Stage stage;

    public MainScreen(final MyGdxGame game){

        stage=new Stage(new ScreenViewport());

        Gdx.input.setInputProcessor(stage);
        this.game=game;
        frontpicture=new Texture("tank-stars-pc-full-version.jpg");
        sprite=new Sprite(frontpicture,0,0,1200,600);
        sprite.setPosition(0,0);
        sprite.setSize(900,600);

        myskin=new Skin(Gdx.files.internal(MyGdxGame.skin));
        music=Gdx.audio.newMusic(Gdx.files.internal("Cowboy-Bebop-tank.wav"));

        music.setLooping(true);
        music.setVolume(0.3f);
        music.play();

        NewGame=new TextButton("NewGame",myskin,"small");

        NewGame.setSize(200,120);
        NewGame.setPosition(950,420);


        NewGame.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){
                music.stop();
                game.setScreen(new Player1(game));

            }
        });
        stage.addActor(NewGame);


        ResumeGame =new TextButton("ResumeGame",myskin,"small");
        ResumeGame.setSize(200,120);
        ResumeGame.setPosition(950,235);
        stage.addActor(ResumeGame);

        ResumeGame.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event,float x,float y){
                music.stop();
                game.setScreen(new ResumeScreen(game));

            }
        });




        ExitGame =new TextButton("ExitGame",myskin,"small");
        ExitGame.setSize(200,120);
        ExitGame.setPosition(950,50);
        stage.addActor(ExitGame);
        ExitGame.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event,float x,float y){
                music.stop();
//				setScreen(new Testing(game));
                game.setScreen(new ExitScreen(game));

//                game.setScreen(new TestGame(game));
            }
        });





    }
    @Override
    public void show(){
        super.show();

    }
    @Override
    public void render(float delta){
        Gdx.gl.glClearColor(0
                , 0, 0.25f, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.begin();
        stage.act();
        stage.draw();
        sprite.draw(game.batch);
        game.batch.end();
    }
}
