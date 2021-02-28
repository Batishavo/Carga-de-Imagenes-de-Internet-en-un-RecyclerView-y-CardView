package net.vyl.imagenesdeinternet.model;

public class Heroes {

    private String name;
    private String imageurl;

    public Heroes(String name, String urlImagen) {
        this.name = name;
        this.imageurl = urlImagen;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }
}
