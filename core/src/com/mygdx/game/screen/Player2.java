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
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.MyGdxGame;
import org.w3c.dom.Text;
import com.badlogic.gdx.ScreenAdapter;

public class Player2 extends ScreenAdapter {
    MyGdxGame game;

    private Button next;

    Button screen2;
    private Label drdo;
    private Label Pumpkin;
    private Label bhisma;
    private Label player2;
    public static int  player2hellio=0;
    public static int player2pumpkin=0;
    public static int player2blazer=0;

    private Label choosetank2;


    private Button Back;
    Label.LabelStyle label1style;

    Stage stage;
    Skin myskin;
    Label Nexttitle;
    Music music;
    public Player2(final MyGdxGame game){

        this.game=game;
        myskin=new Skin(Gdx.files.internal(MyGdxGame.skin));
        stage=new Stage(new ScreenViewport());
        myskin=new Skin(Gdx.files.internal(MyGdxGame.skin));
        Gdx.input.setInputProcessor(stage);
        Back=new TextButton("<<",myskin,"small");
        Back.setSize(100,50);
        Back.setPosition(50,500);
        Back.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){
                music.stop();
                game.setScreen(new Player1(game));

            }
        });
        stage.addActor(Back);
//        stage.addActor(screen2);

        music=Gdx.audio.newMusic(Gdx.files.internal("Shark Tank Walk.mp3"));

        music.setLooping(true);
        music.setVolume(0.4f);
        music.play();
        player2 =new Label("PLAYER 2" ,myskin,"big");
        player2.setSize(300,100);
        player2.setPosition(370,450);
        stage.addActor(player2);

        choosetank2=new Label("CHOOSE YOUR TANK",myskin,"big");
        choosetank2.setSize(500,100);
        choosetank2.setPosition(200,350);

        stage.addActor(choosetank2);
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

        final ImageButton button3 = new ImageButton(new TextureRegionDrawable(new Texture(Gdx.files.internal("Hellio_front.png"))));
        button3.setSize(250,250);


        button3.setPosition(50,100);
        button3.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){
                player2hellio=1;
                button3.getStyle().imageUp = new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("Hellio_back.png"))));
            }
        });
        stage.addActor(button3);

        final ImageButton button4 = new ImageButton(new TextureRegionDrawable(new Texture(Gdx.files.internal("Blazer_front.png"))));
        button3.setSize(250,250);


        button4.setPosition(450,100);
        button4.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){
                player2blazer=1;
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
                player2pumpkin=1;
                button5.getStyle().imageUp = new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("pumpkin_tank_back.png"))));
            }
        });
        stage.addActor(button5);

        next=new TextButton("Next",myskin,"small");
        next.setSize(100,50);
        next.setPosition(1050,500);
        next.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){
                music.stop();
                game.setScreen(new GameScreen(game));

            }
        });
        stage.addActor(next);



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
