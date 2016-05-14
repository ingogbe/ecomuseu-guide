package com.ingoguilherme.ecomuseuguide.dao.controller;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.ingoguilherme.ecomuseuguide.bo.Language;
import com.ingoguilherme.ecomuseuguide.dao.handler.DatabaseHandler;
import com.ingoguilherme.ecomuseuguide.view.activities.MainActivity;

import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by IngoGuilherme on 14-May-16.
 */
public class LanguageDAO {

    private DatabaseHandler dbHandler;

    public LanguageDAO(DatabaseHandler dbHandler) {
        this.dbHandler = dbHandler;
    }

    public Language queryIdForLanguage(Language lang){
        SQLiteDatabase db = dbHandler.getReadableDatabase();

        Cursor cursor = db.rawQuery("" +
                "SELECT * FROM Language WHERE " +
                    "language = '" + lang.getLanguage() + "' AND " +
                    "countryCode = '" + lang.getCountryCode() + "'", null);

        while (cursor.moveToNext()) {
            lang = fromCursorLanguage(cursor);
        }

        cursor.close();

        return lang;
    }

    public ArrayList<Language> queryAllLanguages(){
        ArrayList<Language> langList = new ArrayList<Language>();
        SQLiteDatabase db = dbHandler.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM Language", null);

        while (cursor.moveToNext()) {
            Language lang = new Language();
            lang = fromCursorLanguage(cursor);
            langList.add(lang);
        }

        cursor.close();

        return langList;
    }

    public Language queryCurrentSysLanguage(){
        Language lang = new Language();
        lang.setId(0);
        lang.setLanguage(Locale.getDefault().getLanguage());
        lang.setCountryCode(Locale.getDefault().getCountry());

        lang = queryIdForLanguage(lang);

        if(lang.getId() == 0){
            return MainActivity.selectedLanguage;
        }

        return lang;
    }

    private Language fromCursorLanguage(Cursor cursor) {
        Language lang = new Language();
        lang.setId(cursor.getInt(cursor.getColumnIndex("id")));
        lang.setCountryCode(cursor.getString(cursor.getColumnIndex("countryCode")));
        lang.setLanguage(cursor.getString(cursor.getColumnIndex("language")));

        return lang;
    }
}
