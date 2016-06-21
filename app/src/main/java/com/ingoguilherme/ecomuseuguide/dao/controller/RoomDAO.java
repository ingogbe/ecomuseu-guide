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
            Room room = fromCursorRoom(cursor);
            roomList.add(room);
        }

        cursor.close();
        db.close();
        dbHandler.close();

        return roomList;
    }

    public Room queryRoomByIdAndLanguage(int id, Language lang){
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
                "Language l " +
                "WHERE " +
                "r.id = rl.idRoom AND " +
                "r.id = " + id + " AND " +
                "l.id = rl.idLanguage AND " +
                "l.id = " + lang.getId(), null);

        while (cursor.moveToNext()) {
            room = fromCursorRoom(cursor);
        }

        cursor.close();
        db.close();
        dbHandler.close();

        return room;
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
        db.close();
        dbHandler.close();

        return room;
    }

    public ArrayList<Room> queryNonClickableRoomsByLanguage(Language lang){
        ArrayList<Room> roomList = new ArrayList<Room>();
        SQLiteDatabase db = dbHandler.getReadableDatabase();

        Cursor cursor = db.rawQuery("" +
                "SELECT " +
                "r.id, " +
                "r.name, " +
                "r.mapIdentification " +
                "FROM " +
                "NonClickableRoom r, " +
                "Language l " +
                "WHERE " +
                "r.idLanguage = l.id AND " +
                "l.id = " + lang.getId(), null);

        while (cursor.moveToNext()) {
            Room room = new Room();
            room = fromCursorNonClickableRoom(cursor);
            roomList.add(room);
        }

        cursor.close();
        db.close();
        dbHandler.close();

        return roomList;
    }

    public Room queryNonClickableRoomsByLanguageAndMapIdentification(Language lang, String mapIdentification){
        Room room = new Room();
        SQLiteDatabase db = dbHandler.getReadableDatabase();

        Cursor cursor = db.rawQuery("" +
                "SELECT " +
                "r.id, " +
                "r.name, " +
                "r.mapIdentification " +
                "FROM " +
                "NonClickableRoom r, " +
                "Language l " +
                "WHERE " +
                "r.idLanguage = l.id AND " +
                "r.mapIdentification = '" + mapIdentification + "' AND " +
                "l.id = " + lang.getId(), null);

        while (cursor.moveToNext()) {
            room = fromCursorNonClickableRoom(cursor);
        }

        cursor.close();
        db.close();
        dbHandler.close();

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

    private Room fromCursorNonClickableRoom(Cursor cursor) {
        Room room = new Room();
        room.setId(cursor.getInt(cursor.getColumnIndex("id")));
        room.setName(cursor.getString(cursor.getColumnIndex("name")));
        room.setMapIdentification(cursor.getString(cursor.getColumnIndex("mapIdentification")));

        return room;
    }

}
