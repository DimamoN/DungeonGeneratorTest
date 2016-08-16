package com.dimamon.playingground.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by dimamon on 16.08.16.
 */
public class Item {

    private Texture texture;

    public Item(Texture texture) {
        this.texture = texture;
    }

    public void render(SpriteBatch batch, int x, int y){
        batch.draw(texture,x,y);
    }

    public Texture getTexture() {
        return texture;
    }
}
