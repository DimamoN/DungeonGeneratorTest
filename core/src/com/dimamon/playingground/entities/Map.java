package com.dimamon.playingground.entities;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;

import java.util.ArrayList;

/**
 * Created by dimamon on 16.08.16.
 */
public class Map {

    public int width;
    public int heigth;
    public Tile tiledMap[][];
    private static final int TEX_SIZE = 16;

    //For map generator
    public static final int MIN_ROOMS = 3;
    public static final int MAX_ROOMS = 10;

    //Текстуры
    private Texture stoneTexture;
    private Texture stoneFloorTexture;

    //Пол
    private Floor stoneWall;
    private Floor stoneFloor;

    //Айтемы

    //Cущества

    //Тайлы
    private Tile stoneWallTile;
    private Tile stoneFloorTile;

    public Map (int width, int heigth){
        this.width = width;
        this.heigth = heigth;
        this.tiledMap = new Tile[width][heigth];

        //Текстуры
        stoneTexture = new Texture("stone.png");
        stoneFloorTexture = new Texture("stoneFloor.png");

        //Пол
        stoneFloor = new Floor(stoneFloorTexture,true);
        stoneWall = new Floor(stoneTexture,false);

        //Тайлы
        stoneFloorTile = new Tile(stoneFloor);
        stoneWallTile = new Tile(stoneWall);

        //Генерация
        generateMap();
    }


    //Генерация карты
    public void generateMap(){
        //1 Этап - все покрыть камнем
        for(int i = 0; i < width; i++)
            for(int j = 0; j < heigth; j++)
                tiledMap[i][j] = stoneWallTile;


        //Сгенерировать ОДНУ КОМНАТУ! (ТЕСТ)

//        //Можно ли разместить комнату
//        boolean isPlaced = false;
//
//        //Пока не разместили комнату, пробуем
//        do{
//
//            //Создаем комнату в слуайном месте
//            Room oneRoom = new Room(MathUtils.random(1,width - Room.MAX_ROOM_WIDTH),
//                    MathUtils.random(1,heigth - Room.MAX_ROOM_HEIGHT));
//
//            for(int i = 0; i < width; i++)
//                for(int j = 0; j < heigth; j++){
//
//                    if(oneRoom.isIn(i,j)){
//                        tiledMap[i][j] = stoneFloorTile; //ВРЕМЕННО!
//                    }
//
//                    isPlaced = true;
//
//                }
//
//        } while (!isPlaced);


        //Этап 2 - генерация комнат

        int numberOfRooms = MathUtils.random(MIN_ROOMS, MAX_ROOMS);
        ArrayList<Room> rooms = new ArrayList<Room>(numberOfRooms);

        do{
            //Создаем комнату в слуайном месте
             Room room = new Room(MathUtils.random(1,width - Room.MAX_ROOM_WIDTH -1),
                MathUtils.random(1,heigth - Room.MAX_ROOM_HEIGHT - 1));

             //Если комната не конфликтует с другими - добавить ее в лист
             if(!room.conflictes(rooms)) {
                 rooms.add(room);
                 numberOfRooms--;
             }

         } while (numberOfRooms > 0);

         //Заполняем карту полом
         for(int i = 0; i < width; i++)
             for(int j = 0; j < heigth; j++){

                 for(Room room : rooms) {
                     if (room.isIn(i, j))
                         tiledMap[i][j] = stoneFloorTile;
                 }
                }



        //ДОРОГИ


        //Старторая точка = координата первой комнаты
        int startX = rooms.get(0).x;
        int startY = rooms.get(0).y;
        //Текущая точка
        int currentX = startX;
        int currentY = startY;
        //Конечная точка = координата последней комнаты
        int nextRoom = 1;
        int nextX = rooms.get(nextRoom).x;
        int nextY = rooms.get(nextRoom).y;

        //Кол-во комнат
        int roomsCount = rooms.size();
        int maxRoomNumber = roomsCount;

        //Генерация дорог
        do{
            //Идем вправо
            if(nextX > currentX){
                tiledMap[currentX][currentY] = stoneFloorTile;
                currentX++;
            }
            //Иначе идем влево
            else if (nextX < currentX){
                tiledMap[currentX][currentY] = stoneFloorTile;
                currentX--;
            }
            //Если находятся на одной вертикали
            else{
                //Проверить, не находимся ли мы в комнате
                if(rooms.get(nextRoom).isIn(currentX,currentY)){
                    //Если да, установить следующую комнату целью
                    if(nextRoom+1 < maxRoomNumber) nextRoom++;
                    nextX = rooms.get(nextRoom).x;
                    nextY = rooms.get(nextRoom).y;
                    roomsCount--;
                }
                //Если не находимся -> продолжить движение к ней по вертикали
                else{
                    //Идем вверх
                    if(nextY > currentY){
                        tiledMap[currentX][currentY] = stoneFloorTile;
                        currentY++;
                    }
                    //Идем вниз
                    else if(nextY < currentY){
                        tiledMap[currentX][currentY] = stoneFloorTile;
                        currentY--;
                    }
                    //Если пришли
                    else{
                        if(nextRoom+1 < maxRoomNumber) nextRoom++;
                        nextX = rooms.get(nextRoom).x;
                        nextY = rooms.get(nextRoom).y;
                        roomsCount--;
                    }
                }
            }

        } while (roomsCount > 0);


    }

    //Отрисовка tiledMap
    public void render (SpriteBatch batch){
        for(int i = 0; i < width; i++)
            for(int j = 0; j < heigth; j++){
                tiledMap[i][j].render(batch,i * TEX_SIZE, j * TEX_SIZE);
            }
    }

}
