package com.dimamon.playingground.entities.creatures;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by dimamon on 16.08.16.
 *
 * Существо, будь то монстр или человек
 */
public class Creature {

    Texture texture;

    public Creature(Texture texture) {
        this.texture = texture;
    }

    public void render(SpriteBatch batch, int x, int y){
        batch.draw(texture,x,y);
    }

}
