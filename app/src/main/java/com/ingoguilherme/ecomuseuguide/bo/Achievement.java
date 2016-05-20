package com.ingoguilherme.ecomuseuguide.bo;

/**
 * Created by IngoGuilherme on 20-May-16.
 */
public class Achievement {
    private int id;
    private int points;

    private static Achievement ourInstance = new Achievement();

    public static Achievement getInstance() {
        return ourInstance;
    }

    public Achievement(){
        setId(0);
        setPoints(0);
    }

    public Achievement(int points){
        setId(0);
        setPoints(points);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
