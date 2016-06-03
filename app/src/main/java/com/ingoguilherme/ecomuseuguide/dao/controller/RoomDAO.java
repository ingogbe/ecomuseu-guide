package com.ingoguilherme.ecomuseuguide.dao.controller;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.ingoguilherme.ecomuseuguide.bo.Achievement;
import com.ingoguilherme.ecomuseuguide.bo.Language;
import com.ingoguilherme.ecomuseuguide.bo.Room;
import com.ingoguilherme.ecomuseuguide.dao.handler.DatabaseHandler;

import java.util.ArrayList;

/**
 * Created by IngoGuilherme on 14-May-16.
 */
public class RoomDAO {

    private DatabaseHandler dbHandler;

    public RoomDAO(DatabaseHandler dbHandler) {
        this.dbHandler = dbHandler;
    }

    public ArrayList<Room> queryRoomsByLanguage(Language lang){
        ArrayList<Room> roomList = new ArrayList<Room>();
        SQLiteDatabase db = dbHandler.getReadableDatabase();

        Cursor cursor = db.rawQuery("" +
                "SELECT " +
                    "r.id, " +
                    "r.coverImageSrc, " +
                    "r.mapIdentification, " +
                    "rl.name, " +
                    "rl.description " +
                "FROM " +
                    "Room r, " +
                    "RoomLanguage rl, " +
                    "Language l " +
                "WHERE " +
                    "r.id = rl.idRoom AND " +
                    "l.id = rl.idLanguage AND " +
                    "l.id = " + lang.getId(), null);

        while (cursor.moveToNext()) {
            Room room = new Room();
            room = fromCursorRoom(cursor);
            roomList.add(room);
        }

        cursor.close();

        return roomList;
    }

    public Room queryRoomsByAchievementAndLanguage(Achievement achi, Language lang){
        Room room = new Room();
        SQLiteDatabase db = dbHandler.getReadableDatabase();

        Cursor cursor = db.rawQuery("" +
                "SELECT " +
                "r.id, " +
                "r.coverImageSrc, " +
                "r.mapIdentification, " +
                "rl.name, " +
                "rl.description " +
                "FROM " +
                "Room r, " +
                "RoomLanguage rl, " +
                "Language l ," +
                "Achievement a " +
                "WHERE " +
                "r.id = rl.idRoom AND " +
                "l.id = rl.idLanguage AND " +
                "l.id = " + lang.getId() + " AND " +
                "a.idRoom = r.id AND " +
                "a.id = " + achi.getId(), null);

        while (cursor.moveToNext()) {
            room = fromCursorRoom(cursor);
        }

        cursor.close();

        return room;
    }

    private Room fromCursorRoom(Cursor cursor) {
        Room room = new Room();
        room.setId(cursor.getInt(cursor.getColumnIndex("id")));
        room.setName(cursor.getString(cursor.getColumnIndex("name")));
        room.setDescription(cursor.getString(cursor.getColumnIndex("description")));
        room.setCoverImageSrc(cursor.getString(cursor.getColumnIndex("coverImageSrc")));
        room.setMapIdentification(cursor.getString(cursor.getColumnIndex("mapIdentification")));

        return room;
    }

}
