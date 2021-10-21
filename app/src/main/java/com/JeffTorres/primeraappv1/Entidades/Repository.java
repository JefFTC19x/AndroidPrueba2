package com.JeffTorres.primeraappv1.Entidades;

public class Repository
{

    private String anime;
    private String body;
    private String link;

    public Repository() {
    }

    public Repository(String name, String Body) {
        this.anime = name;
        this.body = Body;
    }

    public String getAnime() {
        return anime;
    }

    public void setAnime(String anime) {
        this.anime = anime;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
