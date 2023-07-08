package com.mygdx.game.screen;

import com.badlogic.gdx.*;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
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

import java.util.ArrayList;

public class GameScreen extends ScreenAdapter implements InputProcessor {

    MyGdxGame game;

    Button Next;

    ArrayList<ShapeRenderer> fuel=new ArrayList<>();

    Button Back1;

    private Sprite sprite;

    private Stage stage;
    Float arr[];

    Texture background;

    Texture cannontexture;

    Texture cannontexture2;

    Sprite cannonsprite;

    Sprite cannonsprite2;

    private Button button;
    private Label label;

    private Skin myskin;

    Label angleforTank1;
    Label angleforTank2;
    Label PowerforTank1;
    Label PowerforTank2;

    Texture gamescreen;
    Texture player2;
    Sprite sprite2;
    ShapeRenderer shapeRenderer;
    ShapeRenderer shapeRenderer1;

    ShapeRenderer shapeRenderer2;

    float anglecannon;

    float anglecannon2;


    private Button Back;
    Color brown;

    Sprite sprite1;
    Texture player1;
    int x=20;

    int y=1100;
    int coloringx=0;

    Color yellow;


    SpriteBatch spriteBatch;

    SpriteBatch spriteBatch2;
    Sprite ball;

    Sprite ball2;
    Texture ballTex;

    Texture balltex2;
    boolean isFired;

    boolean isFired2;
    double disofball1fromtank1;
    double disofball1fromtank2;
    double disofball2fromtank1;
    double disofball2fromtank2;

    Vector2 gravity;
    private float throwAngle=90-anglecannon;

    private float throwAngle2=90-anglecannon2;
    private float deltaTime=1f;

    private float deltaTime2=1f;

    int finalfuel=150;

    int finalfuel2=150;
    private Vector2 initialVelocity;

    private  Vector2 initialVelocity2;


    int playertank=1 ;

    int health=100;

    int health2=100;
    GameScreen m;
    public GameScreen getInstance(int i){
        if(m == null){
            m = new GameScreen(i);
        }
        return m;
    }
    private GameScreen(int i){

    }
    public GameScreen(final MyGdxGame game){
        this.game=game;

        stage=new Stage(new ScreenViewport());

        myskin=new Skin(Gdx.files.internal(MyGdxGame.skin));
        arr=new Float[1200];

        cannontexture=new Texture("cannonfortank.png");
        cannonsprite=new Sprite(cannontexture,0,0,666,375);
        cannonsprite.setSize(50,30);
        cannonsprite.setPosition(x+30,320);
        cannonsprite.setOrigin(0,0);


        cannontexture2=new Texture("Rightcannon.png");
        cannonsprite2=new Sprite(cannontexture2,0,0,666,375);
        cannonsprite2.setSize(50,30);
        cannonsprite2.setPosition(y+55,321);
        cannonsprite2.setOrigin(0,0);

        Gdx.input.setInputProcessor(stage);
        for(int i=0;i<50;i++){
            ShapeRenderer ss=new ShapeRenderer();
            ss.setAutoShapeType(true);
            fuel.add(ss);

        }

        shapeRenderer2=new ShapeRenderer();
        shapeRenderer2.setAutoShapeType(true);
        yellow=new Color(252/225f, 123/225f, 3/225f,0);

        shapeRenderer =new ShapeRenderer();
        shapeRenderer.setAutoShapeType(true);
        shapeRenderer1=new ShapeRenderer();
        shapeRenderer1.setAutoShapeType(true);
        brown=new Color(87/225f,38/225f,1/225f,1);



        gamescreen=new Texture("a439b065333621.5af0ea8ca23f5.png");
        sprite=new Sprite(gamescreen,0,0,1200,675);
        sprite.setPosition(0,0);
        sprite.setSize(1200,600);



        if(Player1.player1hellio==1){
            player1=new Texture("Helios.jpg");
            sprite1=new Sprite(player1,0,0,200,150);
            sprite1.setPosition(x,298);
            sprite1.setSize(60,60);
        }else if(Player1.player1blazer==1){
            player1=new Texture("Blazer.jpg");
            sprite1=new Sprite(player1,0,0,200,150);
            sprite1.setPosition(x,300);
            sprite1.setSize(60,50);
        }
        else if(Player1.player1pumpkin==1){
            player1=new Texture("Pumpkin_Tank_transparent.jpg");
            sprite1=new Sprite(player1,0,0,350,202);
            sprite1.setPosition(x,300);
            sprite1.setSize(60,50);
        }

        if(Player2.player2hellio==1){
            player2=new Texture("Helios1.png");
            sprite2=new Sprite(player2,0,0,200,150);
            sprite2.setPosition(1100,301);
            sprite2.setSize(60,60);
        }else if(Player2.player2blazer==1){
            player2=new Texture("Blazer1.png");
            sprite2=new Sprite(player2,0,0,200,150);
            sprite2.setPosition(1100,301);
            sprite2.setSize(60,50);
        }
        else if(Player2.player2pumpkin==1){
            player2=new Texture("Pumpkin1.png");
            sprite2=new Sprite(player2,0,0,350,202);
            sprite2.setPosition(1100,301);
            sprite2.setSize(60,50);
        }


        spriteBatch=new SpriteBatch();
        ballTex=new Texture("fireball.png");
        Gdx.input.setInputProcessor(this);
        ball=new Sprite(ballTex,0,0,670,372);
        ball.setSize(30,20);
        ball.setPosition(x+20,310);

        gravity=new Vector2(0, -100);
        float throwVelocity=200;
        initialVelocity=new Vector2((float)(throwVelocity*Math.sin(throwAngle * Math.PI / 180)),(float)(throwVelocity*Math.cos(throwAngle * Math.PI / 180)));


        //projectile for Tank2

        spriteBatch2=new SpriteBatch();
        balltex2=new Texture("Rightfireball.png");
        Gdx.input.setInputProcessor(this);
        ball2=new Sprite(balltex2,0,0,670,372);
        ball2.setSize(30,20);
        ball2.setPosition(1100-x+20,310);

        gravity=new Vector2(0, -100);
        float throwVelocity2=200;
        initialVelocity2=new Vector2((float)(throwVelocity2*Math.sin(throwAngle2 * Math.PI / 180)),(float)(throwVelocity2*Math.cos(throwAngle2 * Math.PI / 180)));

    }

    private void updateBall2(){

        if(isFired2){
            finalfuel=150;


            if(arr[(int)ball2.getX()]>ball2.getY()){

                disofball2fromtank1=Math.sqrt((int)(((ball2.getX()-x)*(ball2.getX()-x))+((ball2.getY()-arr[x])*(ball2.getY()-arr[x]))));

                disofball2fromtank2=Math.sqrt((int)(((ball2.getX()-y)*(ball2.getX()-y))+((ball2.getY()-arr[y])*(ball2.getY()-arr[y]))));
//                System.out.println(disofball2fromtank2);

                if(disofball2fromtank1<=50 ){
                    health-=40;
                }

                if(disofball2fromtank2<=50 ){
                    health2-=40;
                }


                isFired2=false;
                playertank=1;



            }



            float delta2=Gdx.graphics.getDeltaTime();

            initialVelocity2.x=initialVelocity2.x+gravity.x*delta2*deltaTime2;
            initialVelocity2.y=initialVelocity2.y+gravity.y*delta2*deltaTime2;

//            System.out.println(initialVelocity2.y);

            ball2.setPosition(ball2.getX()+initialVelocity2.x * delta2 * deltaTime2,ball2.getY()+initialVelocity2.y * delta2 * deltaTime2);
            if(health<=0){
                game.setScreen(new Winning2(game));
            }else if(health2<=0){
                game.setScreen(new Winning1(game));
            }
        }

    }
    private void updateBall(){

        if(isFired){
            finalfuel2=150;

            if(arr[(int)ball.getX()]>ball.getY()){

                isFired=false;
                playertank=2;
                disofball1fromtank1=Math.sqrt((int)(((ball.getX()-x)*(ball.getX()-x))+((ball.getY()-arr[x])*(ball.getY()-arr[x]))));
                disofball1fromtank2=Math.sqrt((int)(((ball.getX()-y)*(ball.getX()-y))+((ball.getY()-arr[y])*(ball.getY()-arr[y]))));

                if(disofball1fromtank1<=50 ){
                    health-=40;
                }

                if(disofball1fromtank2<=50 ){
                    health2-=40;
                }

            }



            float delta=Gdx.graphics.getDeltaTime();

            initialVelocity.x=initialVelocity.x+gravity.x*delta*deltaTime;
            initialVelocity.y=initialVelocity.y+gravity.y*delta*deltaTime;
            System.out.println(initialVelocity.y);

            ball.setPosition(ball.getX()+initialVelocity.x * delta * deltaTime,ball.getY()+initialVelocity.y * delta * deltaTime);
            if(health<=0){
                game.setScreen(new Winning2(game));
            }else if(health2<=0){
                game.setScreen(new Winning1(game));
            }
        }

    }



    //projectile for tank2


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


        if(!isFired &&playertank==1) {

            isFired = true;
            ball.setPosition(x + 20, 310);
            float throwVelocity = 200;

            throwAngle = 90 - anglecannon;
            initialVelocity = new Vector2((float) (throwVelocity * Math.sin(throwAngle * Math.PI / 180)), (float) (throwVelocity * Math.cos(throwAngle * Math.PI / 180)));
        }
        if(!isFired2 &&playertank==2) {

            isFired2 = true;
            ball2.setPosition(y + 20, 310);
            float throwVelocity2 = 200;

            throwAngle2 = 90 - anglecannon2;
            initialVelocity2 = new Vector2((float) (throwVelocity2 * Math.sin(throwAngle2 * Math.PI / 180)), (float) (throwVelocity2 * Math.cos(throwAngle2 * Math.PI / 180)));
        }
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

    @Override
    public void show(){
        super.show();

    }
    @Override
    public void render(float delta){

        float xInput = Gdx.input.getX();
        float yInput = (Gdx.graphics.getHeight() - Gdx.input.getY());

        float angle = -1;
        float angle2=-1;

        if(angle2<0){
            angle2+=360;
        }
        if(angle < 0){
            angle += 360;
        }
        if(anglecannon<0){
            anglecannon+=360;
            anglecannon=anglecannon%360;
        }
        if(anglecannon2<0){
            anglecannon2+=360;
            anglecannon2=anglecannon2%360;
        }


//        System.out.println("angle of cannon" +anglecannon);
        if(Gdx.input.isKeyPressed(Input.Keys.A)){
            if(!isFired&&playertank==1) {
                cannonsprite.rotate(-angle);
                anglecannon -= angle;
                anglecannon = anglecannon % 360;
            }
            if(!isFired2&&playertank==2){
                cannonsprite2.rotate(-angle2);
                anglecannon2 -= angle2;
                anglecannon2 = anglecannon2 % 360;
            }

        }
        if(Gdx.input.isKeyPressed(Input.Keys.D)){
            if(!isFired &&playertank==1) {
                cannonsprite.rotate(angle);
                anglecannon += angle;
                anglecannon = anglecannon % 360;
            }
            if(!isFired2&&playertank==2) {
                cannonsprite2.rotate(angle2);
                anglecannon2 += angle2;
                anglecannon2 = anglecannon2 % 360;
            }
        }

        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){

            if(!isFired&&finalfuel>0 &&playertank==1) {

                x--;
                coloringx++;
                sprite1.setPosition(x, arr[x]);
                cannonsprite.setPosition(x + 25, arr[x] + 20);
                ball.setPosition(x + 25, arr[x] + 20);
                finalfuel--;
                if(finalfuel==0){
                    finalfuel2=150;
                }
            }
            if(!isFired2 &&finalfuel2>0 &&playertank==2){
                y--;
                sprite2.setPosition(y, arr[y]);
                cannonsprite2.setPosition( y+55, arr[y] + 20);
                ball.setPosition(y + 25, arr[y] + 20);
                finalfuel2--;
                if(finalfuel2==0){
                    finalfuel=150;
                }
            }



        }if(Gdx.input.isKeyPressed(Input.Keys.P)){
            game.setScreen(new ResumeScreen(game));
        }

        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            if(!isFired &&finalfuel>0 &&playertank==1) {
                x++;
                sprite1.setPosition(x, arr[x]);
                cannonsprite.setPosition(x + 25, arr[x] + 20);
                ball.setPosition(x + 25, arr[x] + 20);
                coloringx++;
                finalfuel--;
                if(finalfuel==0){
                    finalfuel2=150;
                }
            }

            if(!isFired2 &&finalfuel2>0 &&playertank==2){
                y++;
                sprite2.setPosition(y, arr[y]);
                cannonsprite2.setPosition( y+55, arr[y] + 20);
                ball.setPosition(y + 25, arr[y] + 20);
                finalfuel2--;
                if(finalfuel2==0){
                    finalfuel=150;
                }
            }
        }

//        if(Gdx.input.isKeyPressed(Input.Keys.S)){
//            sprite1.translateY(-1f);
//        }
//        if(Gdx.input.isKeyPressed(Input.Keys.W)){
//            sprite1.translateY(+0.8f);
//        }




        Gdx.gl.glClearColor(92/255f, 49/255f, 15/255f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


        game.batch.begin();

        sprite.draw(game.batch);
        sprite1.draw(game.batch);
        sprite2.draw(game.batch);
        cannonsprite.draw(game.batch);
        cannonsprite2.draw(game.batch);



        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(brown);


        shapeRenderer.rect(0,0,200,300);
        for(int i=0;i<200;i++){
            arr[i]=(float)300;

        }

        for(int i=0;i<50;i++){
            arr[200+i]=250+(float)(Math.sqrt((2500)-(((200+i)-200)*((200+i)-200))));
            shapeRenderer.rect(200+i,0,1,250+(float)(Math.sqrt((2500)-(((200+i)-200)*((200+i)-200)))));
        }

        for(int i=0;i<50;i++){
            arr[250+i]=250-(float)(Math.sqrt((2500)-(((250+i)-300)*((250+i)-300))));
            shapeRenderer.rect(250+i,0,1,250-(float)(Math.sqrt((2500)-(((250+i)-300)*((250+i)-300)))));
        }

        shapeRenderer.rect(300,0,100,200);

        for(int i=0;i<100;i++){
            arr[300+i]=(float)200;
        }

        for(int i=0;i<35;i++){
            arr[400+i]=250-(float)(Math.sqrt((2500)-(((400+i)-400)*((400+i)-400))));

            shapeRenderer.rect(400+i,0,1,250-(float)(Math.sqrt((2500)-(((400+i)-400)*((400+i)-400)))));
        }
        for(int i=0;i<45;i++){
            arr[435+i]=(250-(float)(Math.sqrt((2500)-(((400+34)-400)*((400+34)-400))))+i);
            shapeRenderer.rect(435+i,0,1,(250-(float)(Math.sqrt((2500)-(((400+34)-400)*((400+34)-400)))))+i);
        }
        for(int i=0;i<20;i++){

            arr[480+i]=217+(float)(Math.sqrt((2500)-(((500+i)-530)*((500+i)-530))));

            shapeRenderer.rect(480+i,0,1,217+(float)(Math.sqrt((2500)-(((500+i)-530)*((500+i)-530)))));
        }
        shapeRenderer.rect(500,0,100,265);
        for(int i=0;i<100;i++){
            arr[500+i]=(float)265;
        }
        for(int i=0;i<50;i++){
            arr[600+i]=215+(float)(Math.sqrt((2500)-(((600+i)-600)*((600+i)-600))));
            shapeRenderer.rect(600+i,0,1,215+(float)(Math.sqrt((2500)-(((600+i)-600)*((600+i)-600)))));
        }
        for(int i=0;i<50;i++){
            arr[650+i]=215-(float)(Math.sqrt((2500)-(((650+i)-700)*((650+i)-700))));
            shapeRenderer.rect(650+i,0,1,215-(float)(Math.sqrt((2500)-(((650+i)-700)*((650+i)-700)))));
        }

        shapeRenderer.rect(700,0,100,165);
        for(int i=0;i<100;i++){
            arr[700+i]=(float)165;
        }

        for(int i=0;i<35;i++){
            arr[800+i]=215-(float)(Math.sqrt((2500)-(((800+i)-800)*((800+i)-800))));
            shapeRenderer.rect(800+i,0,1,215-(float)(Math.sqrt((2500)-(((800+i)-800)*((800+i)-800)))));
        }
        for(int i=0;i<115;i++){
            arr[835+i]=(215-(float)(Math.sqrt((2500)-(((400+34)-400)*((400+34)-400)))))+i;
            shapeRenderer.rect(835+i,0,1,(215-(float)(Math.sqrt((2500)-(((400+34)-400)*((400+34)-400)))))+i);
        }

        for(int i=0;i<40;i++){
            arr[950+i]=253+(float)(Math.sqrt((2500)-(((970+i)-1000)*((970+i)-1000))));
            shapeRenderer.rect(950+i,0,1,253+(float)(Math.sqrt((2500)-(((970+i)-1000)*((970+i)-1000)))));
        }
        shapeRenderer.rect(990,0,210,302);
        for(int i=0;i<210;i++){
            arr[990+i]=(float)302;
        }
        shapeRenderer.end();

    //Fuel drawing

        shapeRenderer1.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer1.setColor(Color.GREEN);
        shapeRenderer1.rect(30,30,finalfuel,20);
        shapeRenderer1.rect(800,30,finalfuel2,20);
        shapeRenderer1.end();


    //Health drawing


        shapeRenderer2.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer2.setColor(Color.YELLOW);
        shapeRenderer2.rect(30,570,health,20);
        shapeRenderer2.rect(1000,570,health2,20);
        shapeRenderer2.end();

        stage.act();
        stage.draw();



        if(isFired) {
            spriteBatch.begin();
            ball.draw(spriteBatch);
            updateBall();
            spriteBatch.end();

        }
        if(isFired2){
            spriteBatch2.begin();
            ball2.draw(spriteBatch2);
            updateBall2();
            spriteBatch2.end();
        }
        game.batch.end();

    }

}
