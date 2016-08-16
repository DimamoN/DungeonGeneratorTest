package com.dimamon.playingground.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by dimamon on 16.08.16.
 */
public class Floor {

    private Texture texture;
    boolean canMove;

    public Floor (Texture texture, boolean canMove){
        this.texture = texture;
        this.canMove = canMove;
    }

    public void render(SpriteBatch batch, int x, int y){
        batch.draw(texture,x,y);
    }

    public Texture getTexture() {
        return texture;
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
    }

    public boolean isCanMove() {
        return canMove;
    }
}
