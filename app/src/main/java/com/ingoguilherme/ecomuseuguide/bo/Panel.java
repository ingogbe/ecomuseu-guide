package com.ingoguilherme.ecomuseuguide.bo;

import java.util.ArrayList;

/**
 * Created by IngoGuilherme on 11-May-16.
 */
public class Panel {
    int id;
    String qrCodeLink;
    ArrayList<String> paragraphs;
    String audioSource;
    ArrayList<String> imageSources;

    private static Panel ourInstance = new Panel();

    public static Panel getInstance() {
        return ourInstance;
    }

    public Panel() {
        setId(0);
        setQrCodeLink("");
        setParagraphs(new ArrayList<String>());
        setAudioSource("");
        setImageSources(new ArrayList<String>());
    }

    public Panel(ArrayList<String> paragraphs) {
        setId(0);
        setQrCodeLink("");
        setParagraphs(paragraphs);
        setAudioSource("");
        setImageSources(new ArrayList<String>());
    }

    public void addParagraph(String paragraph){
        paragraphs.add(paragraph);
    }

    public void addImageSource(String imageSource){
        imageSources.add(imageSource);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQrCodeLink() {
        return qrCodeLink;
    }

    public void setQrCodeLink(String qrCodeLink) {
        this.qrCodeLink = qrCodeLink;
    }

    public ArrayList<String> getParagraphs() {
        return paragraphs;
    }

    public void setParagraphs(ArrayList<String> paragraphs) {
        this.paragraphs = paragraphs;
    }

    public String getAudioSource() {
        return audioSource;
    }

    public void setAudioSource(String audioSource) {
        this.audioSource = audioSource;
    }

    public ArrayList<String> getImageSources() {
        return imageSources;
    }

    public void setImageSources(ArrayList<String> imageSources) {
        this.imageSources = imageSources;
    }

}
