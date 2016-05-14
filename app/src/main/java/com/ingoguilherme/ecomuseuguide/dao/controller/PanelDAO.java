package com.ingoguilherme.ecomuseuguide.dao.controller;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.ingoguilherme.ecomuseuguide.bo.Exposition;
import com.ingoguilherme.ecomuseuguide.bo.Panel;
import com.ingoguilherme.ecomuseuguide.dao.handler.DatabaseHandler;

import java.util.ArrayList;

/**
 * Created by IngoGuilherme on 14-May-16.
 */
public class PanelDAO {
    private DatabaseHandler dbHandler;

    public PanelDAO(DatabaseHandler dbHandler) {
        this.dbHandler = dbHandler;
    }

    public ArrayList<Panel> queryPanelByExposition(Exposition expo){
        ArrayList<Panel> panList = new ArrayList<Panel>();
        SQLiteDatabase db = dbHandler.getReadableDatabase();

        Cursor cursor = db.rawQuery("" +
                "SELECT " +
                    "p.id, " +
                    "a.source " +
                "FROM " +
                    "Panel p, " +
                    "Audio a, " +
                    "Exposition e " +
                "WHERE " +
                    "p.id = a.idPanel AND " +
                    "p.idExposition = e.id AND " +
                    "e.id = " + expo.getId(), null);

        while (cursor.moveToNext()) {
            Panel pan = new Panel();
            pan = fromCursorPanel(cursor);
            panList.add(pan);
        }

        cursor.close();

        for(Panel p: panList){
            p = queryImagesFromPanel(p);
            p = queryParagraphsFromPanel(p);
        }

        return panList;
    }

    public Panel queryImagesFromPanel(Panel pan){
        SQLiteDatabase db = dbHandler.getReadableDatabase();

        Cursor cursor = db.rawQuery("" +
                "SELECT " +
                    "i.source " +
                "FROM " +
                    "Panel p, " +
                    "Images i " +
                "WHERE " +
                    "p.id = i.idPanel AND " +
                    "p.id = " + pan.getId(), null);

        while (cursor.moveToNext()) {
            String imageSrc = fromCursorImage(cursor);
            pan.addImageSource(imageSrc);
        }

        cursor.close();

        return pan;
    }

    public Panel queryParagraphsFromPanel(Panel pan){
        SQLiteDatabase db = dbHandler.getReadableDatabase();

        Cursor cursor = db.rawQuery("" +
                "SELECT " +
                    "t.text " +
                "FROM " +
                    "Panel p, " +
                    "Text t, " +
                    "Paragraph pt " +
                "WHERE " +
                    "p.id = pt.idPanel AND " +
                    "t.id = pt.idText AND " +
                    "p.id = " + pan.getId(), null);

        while (cursor.moveToNext()) {
            String paragraph = fromCursorParagraph(cursor);
            pan.addParagraph(paragraph);
        }

        cursor.close();

        return pan;
    }

    private Panel fromCursorPanel(Cursor cursor) {
        Panel pan = new Panel();

        pan.setId(cursor.getInt(cursor.getColumnIndex("id")));
        pan.setAudioSource(cursor.getString(cursor.getColumnIndex("source")));

        return pan;
    }

    private String fromCursorImage(Cursor cursor) {
        String imageSrc = cursor.getString(cursor.getColumnIndex("source"));

        return imageSrc;
    }

    private String fromCursorParagraph(Cursor cursor) {
        String paragraph = cursor.getString(cursor.getColumnIndex("text"));

        return paragraph;
    }
}
