package com.dimamon.playingground.entities.creatures;

import com.badlogic.gdx.graphics.Texture;
import com.dimamon.playingground.entities.Map;

/**
 * Created by dimamon on 16.08.16.
 */
public class Player extends Creature{

    public Player(Texture texture) {
        super(texture);
    }

    public boolean goToNextLevel(){
        if(Map.isStairs(this.x,this.y)) return true;
        else return false;
    }

}
