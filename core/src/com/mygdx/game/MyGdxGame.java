package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.screen.MainScreen;

public class MyGdxGame extends Game {
	public SpriteBatch batch;

	Skin myskin;

	Sprite sprite;



	public static final String skin=new String("skin/glassy-ui.json");
	public static final String  skin2=new String("skin3/level-plane-ui.json");

	Texture img;
	BitmapFont font;
	ShapeRenderer shapeRenderer;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		shapeRenderer =new ShapeRenderer();
		setScreen(new MainScreen(this));

	}

//	@Override
//	public void render () {
//		ScreenUtils.clear(0, 0, 0.25f, 0);
//		batch.begin();
//		batch.end();
//	}
	
	@Override
	public void dispose () {
		batch.dispose();
		shapeRenderer.dispose();
	}
}
