package com.dimamon.playingground.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.dimamon.playingground.entities.creatures.Creature;

/**
 * Created by dimamon on 16.08.16.
 * Tile - это квадратный блок карты, который состоит из пола и из предмета, который на нем стоит или лежит
 */
public class Tile {

    private Floor floor;
    private Item item;
    private Creature creature;


    public Tile(Floor floor) {
        this.floor = floor;
    }

    public Tile(Floor floor, Item item, Creature creature) {
        this.floor = floor;
        this.item = item;
        this.creature = creature;
    }

    //Отрисовка тайла в строгом порядке 1)Земля 2)Айтемы 3)Существа
    public void render(SpriteBatch batch, int x, int y){
        floor.render(batch,x,y);
        if(item != null)
        item.render(batch,x,y);
        if(creature != null)
        creature.render(batch,x,y);
    }

}
