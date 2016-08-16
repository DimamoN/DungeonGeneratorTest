package com.dimamon.playingground.entities.creatures;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.dimamon.playingground.Application;
import com.dimamon.playingground.entities.Map;

/**
 * Created by dimamon on 16.08.16.
 *
 * Существо, будь то монстр или человек
 */
public class Creature {

    Texture texture;

    //Координаты персонажа (на карте)
    int x;
    int y;

    public Creature(Texture texture) {
        this.texture = texture;
    }

    public void render(SpriteBatch batch, int x, int y){
        batch.draw(texture,x,y);
    }


//    public String moveUpDebug(){
//        if(canMove(x,y+1))
//            y++;
//        return new String("CAN MOVE UP : " + canMove(x,y+1));
//    }


    public void moveUp(){
        if(canMove(x,y+1))
            y++;
    }

    public void moveDown(){
        if(canMove(x,y-1))
            y--;
    }

    public void moveRight(){
        if(canMove(x+1,y))
            x++;
    }

    public void moveLeft(){
        if(canMove(x-1,y))
            x--;
    }

    public boolean canMove(int x, int y){
        return Map.canMove(x, y);
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
}
