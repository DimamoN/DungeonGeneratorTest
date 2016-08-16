package com.dimamon.playingground.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.dimamon.playingground.Application;

public class SplashScreen implements Screen{

    private final Application app;

    public SplashScreen(Application app){
        this.app = app;
    }

    @Override
    public void show() {
        //Код который выполняется, когда устанавливается этот Screen
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.25f, 0.25f, 0.25f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {
        //Код который выполняется, когда этот Screen убирают
    }

    @Override
    public void dispose() {

    }
}
