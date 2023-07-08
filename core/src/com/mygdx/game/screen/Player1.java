package com.mygdx.game.screen;

import com.badlogic.gdx.Gdx;
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
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.MyGdxGame;
import org.w3c.dom.Text;

public class Player1 extends ScreenAdapter {
    MyGdxGame game;
    public static int  player1hellio=0;
    public static int player1pumpkin=0;
    public static int player1blazer=0;


    private Label player1;

    private Label choosetank;

    private Label drdo;
    private Label Pumpkin;
    private Label bhisma;
    private Sprite sprite1;

    private Sprite sprite2;

    private Sprite sprite3;
    private Texture tank1;
    private  Texture tank2;
    private Texture tank3;

    private Button Next;

    private Button Back;


    private Skin myskin;
    private Skin myskin2;
    Music music;
    public Label getPlayer1() {
        return player1;
    }

    public void setPlayer1(Label player1) {
        this.player1 = player1;
    }

    public Label getChoosetank() {
        return choosetank;
    }

    public void setChoosetank(Label choosetank) {
        this.choosetank = choosetank;
    }

    public Label getDrdo() {
        return drdo;
    }

    public void setDrdo(Label drdo) {
        this.drdo = drdo;
    }

    public Label getPumpkin() {
        return Pumpkin;
    }

    public void setPumpkin(Label pumpkin) {
        Pumpkin = pumpkin;
    }

    public Label getBhisma() {
        return bhisma;
    }

    public void setBhisma(Label bhisma) {
        this.bhisma = bhisma;
    }

    public Sprite getSprite1() {
        return sprite1;
    }

    public void setSprite1(Sprite sprite1) {
        this.sprite1 = sprite1;
    }

    public Sprite getSprite2() {
        return sprite2;
    }

    public void setSprite2(Sprite sprite2) {
        this.sprite2 = sprite2;
    }

    public Sprite getSprite3() {
        return sprite3;
    }

    public void setSprite3(Sprite sprite3) {
        this.sprite3 = sprite3;
    }

    public Texture getTank1() {
        return tank1;
    }

    public void setTank1(Texture tank1) {
        this.tank1 = tank1;
    }

    public Texture getTank2() {
        return tank2;
    }

    public void setTank2(Texture tank2) {
        this.tank2 = tank2;
    }

    public Texture getTank3() {
        return tank3;
    }

    public void setTank3(Texture tank3) {
        this.tank3 = tank3;
    }

    public Button getNext() {
        return Next;
    }

    public void setNext(Button next) {
        Next = next;
    }

    public Button getBack() {
        return Back;
    }

    public void setBack(Button back) {
        Back = back;
    }

    public Skin getMyskin() {
        return myskin;
    }

    public void setMyskin(Skin myskin) {
        this.myskin = myskin;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    private Stage stage;

    Texture notSelected;
    Texture selected;
    TextureRegionDrawable image;
    TextureRegionDrawable image1;


    public Player1(final MyGdxGame game){
        this.game=game;
        stage=new Stage(new ScreenViewport());
        myskin=new Skin(Gdx.files.internal(MyGdxGame.skin));
        myskin2=new Skin(Gdx.files.internal(MyGdxGame.skin2));
        Gdx.input.setInputProcessor(stage);
        music=Gdx.audio.newMusic(Gdx.files.internal("Shark Tank Walk.mp3"));

        music.setLooping(true);
        music.setVolume(0.5f);
        music.play();

        drdo=new Label("DRDO" ,myskin,"big");
        drdo.setSize(100,50);
        drdo.setPosition(80,50);
        stage.addActor(drdo);

        bhisma =new Label("BHISMA" ,myskin,"big");
        bhisma.setSize(100,50);
        bhisma.setPosition(490,50);
        stage.addActor(bhisma);

        Pumpkin =new Label("DEVIL" ,myskin,"big");
        Pumpkin.setSize(100,50);
        Pumpkin.setPosition(920,50);
        stage.addActor(Pumpkin);


        player1 =new Label("PLAYER 1" ,myskin,"big");
        player1.setSize(300,100);
        player1.setPosition(370,450);
        stage.addActor(player1);

        choosetank=new Label("CHOOSE YOUR TANK",myskin,"big");
        choosetank.setSize(500,100);
        choosetank.setPosition(200,350);

        stage.addActor(choosetank);

        final ImageButton button3 = new ImageButton(new TextureRegionDrawable(new Texture(Gdx.files.internal("Hellio_front.png"))));
        button3.setSize(250,250);


        button3.setPosition(50,100);


        button3.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){
//                button3.setRotation(78);
                player1hellio=1;

                button3.getStyle().imageUp = new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("Hellio_back.png"))));

            }
        });
        stage.addActor(button3);

        final ImageButton button4 = new ImageButton(new TextureRegionDrawable(new Texture(Gdx.files.internal("Blazer_front.png"))));
        button3.setSize(250,250);


        button4.setPosition(450,100);
//        button4.setTransform(true);
        button4.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){
                player1blazer=1;
//                button4.setRotation(45);
                button4.getStyle().imageUp = new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("Blazer_back.jpg.png"))));

            }
        });
        stage.addActor(button4);

        final ImageButton button5 = new ImageButton(new TextureRegionDrawable(new Texture(Gdx.files.internal("pumpkin_tank_front.png"))));
        button5.setSize(400,400);


        button5.setPosition(780,30);
        button5.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){
                player1pumpkin=1;
                button5.getStyle().imageUp = new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("pumpkin_tank_back.png"))));
//                game.setScreen(new Player2(game));

            }
        });
        stage.addActor(button5);

        Next=new TextButton("NEXT",myskin,"small");
        Next.setSize(100,50);
        Next.setPosition(1050,500);
        Next.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){
                music.stop();
                game.setScreen(new Player2(game));

            }
        });

        stage.addActor(Next);




        Back=new TextButton("<<",myskin,"small");
        Back.setSize(100,50);
        Back.setPosition(50,500);
        Back.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){
                music.stop();
                game.setScreen(new MainScreen(game));

            }
        });
        stage.addActor(Back);

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
        game.batch.end();
    }
}
