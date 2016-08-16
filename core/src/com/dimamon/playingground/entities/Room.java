package com.dimamon.playingground.entities;

import com.badlogic.gdx.math.MathUtils;
import com.dimamon.playingground.Application;

import java.util.ArrayList;

/**
 * Created by dimamon on 16.08.16.
 * Комната на карте
 */
public class Room {

    public static final int MIN_ROOM_WIDTH = 2;
    public static final int MIN_ROOM_HEIGHT = 2;
    public static final int MAX_ROOM_WIDTH = 6;
    public static final int MAX_ROOM_HEIGHT = 6;

    //Левые нижние координаты старта комнаты
    public int x;
    public int y;

    //ширина и высота комнаты
    public int width;
    public int height;

    //Указать координаты левого нижнего угла
    public Room(int y, int x) {
        this.y = y;
        this.x = x;
        generateRoom();
    }

    /*сгенерировать комнату, чтобы она не вышла за границы карты
      Генерирует ширину и высоту комнаты
    */
    public void generateRoom(){
        boolean isPlased = false;
        do{
            width = MathUtils.random(MIN_ROOM_WIDTH-1, MAX_ROOM_WIDTH);
            height = MathUtils.random(MIN_ROOM_HEIGHT-1, MAX_ROOM_HEIGHT);

            if(x+width < Application.MAP_WIDTH && y+height < Application.MAP_HEIGHT)
                isPlased = true;

        } while (!isPlased);
    }

    //Находятся ли координаты внутри комнаты
    public boolean isIn(int x, int y){
        if(x >= this.x && x <= this.x + width &&
                y >= this.y && y <= this.y + height) return true;
        else
            return false;
    }

    //Конфликтуют ли комнаты
    public boolean conflictes(Room room){

        if(room == null) return false;

        //Если левая крайняя точка комнаты внутри другой
        if((room.x > this.x) && (room.x < (this.x + width)) &&
                (room.y > this.y) && (room.y < (this.y + height))) return true;

        //Left
        if((x >= room.x) && (x <= (room.x + room.width))){
            //Bot
            if((y >= room.y) && (y <= (room.y + room.height))) return true;

            //Top
            if((y+height >= room.y) && ((y+height) <= (room.y + room.height))) return true;
        }

        //Right
        if(((x+width) >= room.x) && ((x+width) <= (room.x + room.width))){
            //Bot
            if((y >= room.y) && (y <= (room.y + room.height))) return true;
            //Top
            if(((y+height) >= room.y) && ((y+height) <= (room.y + room.height))) return true;
        }

        return false;
    }

    public boolean conflictes (ArrayList<Room> rooms){
        for(Room room : rooms) {
            if (this.conflictes(room)) return true;
            if (room.conflictes(this)) return true;
        }

        return false;
    }
}
