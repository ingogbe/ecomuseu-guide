package com.ingoguilherme.ecomuseuguide.bo;

/**
 * Created by IngoGuilherme on 14-May-16.
 */
public class Language {
    int id;
    String language;
    String countryCode;

    private static Room ourInstance = new Room();

    public static Room getInstance() {
        return ourInstance;
    }

    public Language(){
        setId(0);
        setLanguage("");
        setCountryCode("");
    }

    public Language(String language, String countryCode){
        setId(0);
        setLanguage(language);
        setCountryCode(countryCode);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
}
