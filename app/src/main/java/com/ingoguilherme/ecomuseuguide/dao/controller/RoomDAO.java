package com.ingoguilherme.ecomuseuguide.dao.controller;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

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
                    "r.id, r.name, r.description, r.coverImageSrc " +
                "FROM " +
                    "Room r, Language l, RoomLanguage rl " +
                "WHERE " +
                    "l.id = rl.idLanguage AND " +
                    "r.id = rl.idRoom AND " +
                    "l.id = " + lang.getId(), null);

        while (cursor.moveToNext()) {
            Room room = new Room();
            room = fromCursorRoom(cursor);
            roomList.add(room);
        }

        cursor.close();

        return roomList;
    }

    public Room queryRoomByQRCode(String qrCode){
        Room room = new Room();
        SQLiteDatabase db = dbHandler.getReadableDatabase();

        Cursor cursor = db.rawQuery("" +
            "SELECT " +
                "r.id, r.name, r.description, r.coverImageSrc " +
            "FROM " +
                "Room r, Exposition e, Panel p " +
            "WHERE " +
                "r.id = e.idRoom AND " +
                "e.id = p.idExposition AND " +
                "p.qrCodeLink = '" + qrCode + "'", null);

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

        return room;
    }

}
