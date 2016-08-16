package com.dimamon.playingground;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.dimamon.playingground.entities.Map;
import com.dimamon.playingground.entities.creatures.Player;
import com.dimamon.playingground.screens.SplashScreen;

public class Application extends Game {

	public static final int WIDTH = 512;
	public static final int HEIGHT = 512;
	public static final float VERSION = 0.1f;
	public static final String TITLE = "Dungeon -B-";
	public static final int TEX_SIZE = 16;
	public static final int MAP_WIDTH = WIDTH / TEX_SIZE;
	public static final int MAP_HEIGHT = HEIGHT / TEX_SIZE;

	Texture playerTexture;

	Player player;

	public Map gameMap;

	SpriteBatch batch;
	OrthographicCamera camera;

	@Override
	public void create () {
		batch = new SpriteBatch();
		camera = new OrthographicCamera();
		camera.setToOrtho(false, MAP_WIDTH * TEX_SIZE, MAP_HEIGHT * TEX_SIZE);
		gameMap = new Map(MAP_WIDTH,MAP_HEIGHT);

		playerTexture = new Texture("player.png");
		player = new Player(playerTexture);

		player.setX(gameMap.spawnX);
		player.setY(gameMap.spawnY);

//		this.setScreen(new SplashScreen(this));
	}

	@Override
	public void render () {

		if(Gdx.input.isKeyJustPressed(Input.Keys.R)) {
			gameMap.generateMap();
			player.setX(gameMap.spawnX);
			player.setY(gameMap.spawnY);
		}

		//Тестовое управление
		if(Gdx.input.isKeyJustPressed(Input.Keys.W) || Gdx.input.isKeyJustPressed(Input.Keys.UP)){
			player.moveUp();
		}
		if(Gdx.input.isKeyJustPressed(Input.Keys.S) || Gdx.input.isKeyJustPressed(Input.Keys.DOWN)){
			player.moveDown();
		}
		if(Gdx.input.isKeyJustPressed(Input.Keys.A) || Gdx.input.isKeyJustPressed(Input.Keys.LEFT)){
			player.moveLeft();
		}
		if(Gdx.input.isKeyJustPressed(Input.Keys.D) || Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)){
			player.moveRight();
		}


		if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE)){
			if(player.goToNextLevel()) {
				gameMap.generateMap();
				player.setX(gameMap.spawnX);
				player.setY(gameMap.spawnY);
			}
		}


		super.render();

		batch.setProjectionMatrix(camera.combined);
		batch.begin();


		gameMap.render(batch);

		player.render(batch,player.getX()*TEX_SIZE,player.getY()*TEX_SIZE);

		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
