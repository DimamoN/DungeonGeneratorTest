package com.dimamon.playingground;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.dimamon.playingground.entities.Map;
import com.dimamon.playingground.screens.SplashScreen;

public class Application extends Game {

	public static final int WIDTH = 512;
	public static final int HEIGHT = 512;
	public static final float VERSION = 0.1f;
	public static final String TITLE = "Game";
	public static final int TEX_SIZE = 16;
	public static final int MAP_WIDTH = 24;
	public static final int MAP_HEIGHT = 24;

	Map gameMap;

	SpriteBatch batch;
	OrthographicCamera camera;

	@Override
	public void create () {
		batch = new SpriteBatch();
		camera = new OrthographicCamera();
		camera.setToOrtho(false, MAP_WIDTH * TEX_SIZE, MAP_HEIGHT * TEX_SIZE);
		gameMap = new Map(MAP_WIDTH,MAP_HEIGHT);

//		this.setScreen(new SplashScreen(this));
	}

	@Override
	public void render () {

		if(Gdx.input.isKeyJustPressed(Input.Keys.R))
			gameMap.generateMap();

		super.render();

		batch.setProjectionMatrix(camera.combined);
		batch.begin();

		gameMap.render(batch);

		batch.end();


	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
