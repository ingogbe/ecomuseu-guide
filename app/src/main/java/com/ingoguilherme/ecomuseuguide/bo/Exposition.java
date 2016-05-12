package com.ingoguilherme.ecomuseuguide.bo;

import java.util.ArrayList;

/**
 * Created by IngoGuilherme on 11-May-16.
 */
public class Exposition {
    int id;
    String name;
    String description;
    ArrayList<Panel> panels;
    String coverImageSrc;

    private static Exposition ourInstance = new Exposition();

    public static Exposition getInstance() {
        return ourInstance;
    }

    public Exposition() {
        setId(0);
        setName("");
        setDescription("");
        setPanels(new ArrayList<Panel>());
    }

    public Exposition(String name) {
        setId(0);
        setName(name);
        setDescription("");
        setPanels(new ArrayList<Panel>());
    }

    public Exposition(String name, String description) {
        setId(0);
        setName(name);
        setDescription(description);
        setPanels(new ArrayList<Panel>());
    }

    public void addPanel(Panel panel){
        panels.add(panel);
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

    public ArrayList<Panel> getPanels() {
        return panels;
    }

    public void setPanels(ArrayList<Panel> panels) {
        this.panels = panels;
    }

    public String getCoverImageSrc() {
        return coverImageSrc;
    }

    public void setCoverImageSrc(String coverImageSrc) {
        this.coverImageSrc = coverImageSrc;
    }
}
