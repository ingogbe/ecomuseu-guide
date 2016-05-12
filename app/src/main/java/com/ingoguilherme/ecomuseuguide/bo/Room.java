package com.ingoguilherme.ecomuseuguide.bo;

import java.util.ArrayList;

/**
 * Created by IngoGuilherme on 11-May-16.
 */
public class Room {
    int id;
    String name;
    String description;
    ArrayList<Exposition> expositions;
    String coverImageSrc;

    private static Room ourInstance = new Room();

    public static Room getInstance() {
        return ourInstance;
    }

    public Room() {
        setId(0);
        setName("");
        setDescription("");
        setExpositions(new ArrayList<Exposition>());
    }

    public Room(String name) {
        setId(0);
        setName(name);
        setDescription("");
        setExpositions(new ArrayList<Exposition>());
    }

    public Room(String name, String description) {
        setId(0);
        setName(name);
        setDescription(description);
        setExpositions(new ArrayList<Exposition>());
    }

    public void addExposition(Exposition exposition){
        expositions.add(exposition);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Exposition> getExpositions() {
        return expositions;
    }

    public void setExpositions(ArrayList<Exposition> expositions) {
        this.expositions = expositions;
    }

    public String getCoverImageSrc() {
        return coverImageSrc;
    }

    public void setCoverImageSrc(String coverImageSrc) {
        this.coverImageSrc = coverImageSrc;
    }
}
