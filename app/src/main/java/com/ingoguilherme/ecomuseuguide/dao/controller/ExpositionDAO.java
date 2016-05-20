package com.ingoguilherme.ecomuseuguide.dao.controller;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.ingoguilherme.ecomuseuguide.bo.Exposition;
import com.ingoguilherme.ecomuseuguide.bo.Language;
import com.ingoguilherme.ecomuseuguide.bo.Room;
import com.ingoguilherme.ecomuseuguide.dao.handler.DatabaseHandler;

import java.util.ArrayList;

/**
 * Created by IngoGuilherme on 14-May-16.
 */
public class ExpositionDAO {

    private DatabaseHandler dbHandler;

    public ExpositionDAO(DatabaseHandler dbHandler) {
        this.dbHandler = dbHandler;
    }

    public Exposition queryExpositionByQrCodeAndLanguage(String qrCode, Language lang){
        Exposition expo = new Exposition();
        SQLiteDatabase db = dbHandler.getReadableDatabase();

        Cursor cursor = db.rawQuery("" +
                "SELECT " +
                    "e.id, " +
                    "e.name, " +
                    "e.description, " +
                    "e.coverImageSrc, " +
                    "e.qrCodeLink " +
                "FROM " +
                    "Exposition e, " +
                    "RoomLanguage rl, " +
                    "Language l " +
                "WHERE " +
                    "e.idRoomLanguage = rl.id AND " +
                    "rl.idLanguage = l.id AND " +
                    "l.id = "+ lang.getId() +" AND " +
                    "e.qrCodeLink = '"+ qrCode +"'", null);

        while (cursor.moveToNext()) {
            expo = fromCursorExposition(cursor);
        }

        cursor.close();

        PanelDAO panelDAO = new PanelDAO(dbHandler);
        expo.setPanels(panelDAO.queryPanelByExposition(expo));

        return expo;
    }

    public ArrayList<Exposition> queryExpositionByRoomAndLanguage(Room room, Language lang){
        ArrayList<Exposition> expoList = new ArrayList<Exposition>();
        SQLiteDatabase db = dbHandler.getReadableDatabase();

        Cursor cursor = db.rawQuery("" +
                "SELECT " +
                    "e.id, " +
                    "e.name, " +
                    "e.description, " +
                    "e.coverImageSrc, " +
                    "e.qrCodeLink " +
                "FROM " +
                    "Exposition e, " +
                    "RoomLanguage rl, " +
                    "Language l, " +
                    "Room r " +
                "WHERE " +
                    "e.idRoomLanguage = rl.id AND " +
                    "r.id = rl.idRoom AND " +
                    "rl.idLanguage = l.id AND " +
                    "r.id = " + room.getId() + " AND " +
                    "l.id = " + lang.getId(), null);

        while (cursor.moveToNext()) {
            Exposition expo = new Exposition();
            expo = fromCursorExposition(cursor);
            expoList.add(expo);
        }

        cursor.close();

        PanelDAO panelDAO = new PanelDAO(dbHandler);
        for(Exposition expo: expoList) {
            expo.setPanels(panelDAO.queryPanelByExposition(expo));
        }

        return expoList;
    }

    private Exposition fromCursorExposition(Cursor cursor) {
        Exposition expo = new Exposition();

        expo.setId(cursor.getInt(cursor.getColumnIndex("id")));
        expo.setName(cursor.getString(cursor.getColumnIndex("name")));
        expo.setDescription(cursor.getString(cursor.getColumnIndex("description")));
        expo.setCoverImageSrc(cursor.getString(cursor.getColumnIndex("coverImageSrc")));
        expo.setQrCodeLink(cursor.getString(cursor.getColumnIndex("qrCodeLink")));

        return expo;
    }

}
