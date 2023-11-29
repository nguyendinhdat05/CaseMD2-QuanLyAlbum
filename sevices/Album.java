package sevices;

import models.Song;

import java.util.ArrayList;
import java.util.List;

public class Album {
    private int id;
    private String name;
    private List<Song> album = new ArrayList<>();


    public Album(int id, String name, List<Song> album) {
        this.id = id;
        this.name = name;
        this.album = album;
    }

    // thêm bài hát
    public void add(Song song) {
        album.add(song);
    }
    public void remove(Song song){
        album.remove(song);
    }

    // hiển thị danh sách bài hát
    public void showAll() {
        for (Song s : album) {
            System.out.println(s);
        }
    }

    public Album(int id, String name) {
        this.id = id;
        this.name = name;
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

    public List<Song> getAlbum() {
        return album;
    }

    public void setAlbum(List<Song> album) {
        this.album = album;
    }

    @Override
    public String toString() {
        return " ID Album: " + id +
                ", Tên Album: " + name  + "\n"+
                ", Danh Sách Bài Hát: " + album + "\n";
    }

}

