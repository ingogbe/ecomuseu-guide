package com.ingoguilherme.ecomuseuguide.dao.controller;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.ingoguilherme.ecomuseuguide.bo.Achievement;
import com.ingoguilherme.ecomuseuguide.dao.handler.DatabaseHandler;

import java.util.ArrayList;

/**
 * Created by IngoGuilherme on 20-May-16.
 */
public class AchievementDAO {

    private DatabaseHandler dbHandler;

    public AchievementDAO(DatabaseHandler dbHandler) {
        this.dbHandler = dbHandler;
    }

    public Achievement queryAchievementByQrCode(String qrCode){
        Achievement achi = new Achievement();
        SQLiteDatabase db = dbHandler.getReadableDatabase();

        Cursor cursor = db.rawQuery("" +
                "SELECT " +
                    "a.id, " +
                    "a.points " +
                "FROM " +
                    "Achievement a, " +
                    "Room r, " +
                    "RoomLanguage rl, " +
                    "Exposition e " +
                "WHERE " +
                    "a.idRoom = r.id AND " +
                    "rl.idRoom = r.id AND " +
                    "rl.id = e.idRoomLanguage AND " +
                    "e.qrCodeLink = '"+ qrCode +"'", null);

        while (cursor.moveToNext()) {
            achi = fromCursorAchievement(cursor);
        }

        cursor.close();

        return achi;
    }

    public ArrayList<Achievement> queryAllAchievement(){
        ArrayList<Achievement> list_achi = new ArrayList<Achievement>();
        SQLiteDatabase db = dbHandler.getReadableDatabase();

        Cursor cursor = db.rawQuery("" +
                "SELECT " +
                "a.id, " +
                "a.points " +
                "FROM " +
                "Achievement a ", null);

        while (cursor.moveToNext()) {
            list_achi.add(fromCursorAchievement(cursor));
        }

        cursor.close();

        return list_achi;
    }

    public ArrayList<Achievement> queryAllCompletedAchievement(){
        ArrayList<Achievement> list_achi = new ArrayList<Achievement>();
        SQLiteDatabase db = dbHandler.getReadableDatabase();

        Cursor cursor = db.rawQuery("" +
                "SELECT " +
                "a.id, " +
                "a.points " +
                "FROM " +
                "Achievement a, " +
                "CompletedAchievement ca " +
                "WHERE " +
                "a.id = ca.idAchievement", null);

        while (cursor.moveToNext()) {
            list_achi.add(fromCursorAchievement(cursor));
        }

        cursor.close();

        return list_achi;
    }

    public Achievement insertCompletedAchievement(Achievement achi){
        SQLiteDatabase db = dbHandler.getWritableDatabase();

        ContentValues values1 = new ContentValues();
        values1.put("idAchievement", achi.getId());

        db.insert("CompletedAchievement", null, values1);

        return achi;
    }

    private Achievement fromCursorAchievement(Cursor cursor) {
        Achievement achi = new Achievement();

        achi.setId(cursor.getInt(cursor.getColumnIndex("id")));
        achi.setPoints(cursor.getInt(cursor.getColumnIndex("points")));

        return achi;
    }
}
