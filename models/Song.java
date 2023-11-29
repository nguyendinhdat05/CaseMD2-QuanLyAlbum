package models;

public class Song {
    private int id;
    private String nameSong;
    private String nameSinger;

    public Song(int id, String nameSong, String nameSinger) {
        this.id = id;
        this.nameSong = nameSong;
        this.nameSinger = nameSinger;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameSong() {
        return nameSong;
    }

    public void setNameSong(String nameSong) {
        this.nameSong = nameSong;
    }

    public String getNameSinger() {
        return nameSinger;
    }

    public void setNameSinger(String nameSinger) {
        this.nameSinger = nameSinger;
    }

    @Override
    public String toString() {
        return "ID Song : " + id +
                ", Song Name: " + nameSong + '\'' +
                ", Artist Name: " + nameSinger + '\'';
    }
}
