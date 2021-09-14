package com.vi.lavenganza20.model;

public class Image {
    private String urlImagen;
    private String username;
    private String cantidadDiaz;
    private String cantidadMeGusta;

    public Image(String urlImagen, String username, String cantidadDiaz, String cantidadMeGusta) {
        this.setUrlImagen(urlImagen);
        this.setUsername(username);
        this.setCantidadDiaz(cantidadDiaz);
        this.setCantidadMeGusta(cantidadMeGusta);
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCantidadDiaz() {
        return cantidadDiaz;
    }

    public void setCantidadDiaz(String cantidadDiaz) {
        this.cantidadDiaz = cantidadDiaz;
    }

    public String getCantidadMeGusta() {
        return cantidadMeGusta;
    }

    public void setCantidadMeGusta(String cantidadMeGusta) {
        this.cantidadMeGusta = cantidadMeGusta;
    }
}
