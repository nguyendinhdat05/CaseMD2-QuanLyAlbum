package sevices;

import data.FileSong;
import models.Song;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ManagerSongs {
    List<Song> songs ;

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    public ManagerSongs() throws IOException {
        songs= FileSong.readFileSong("songs.csv");

    }
   // hiển thị danh sách bài hát
    public void showAll() {
        for (Song s: songs) {
            System.out.println(s);
        }
    }
    public void addSong(Song song){
        songs.add(song);
    }
    public void deleteSong(String name) {
        int index = -1;
        for (int i = 0; i < this.songs.size(); i++) {
            if (this.songs.get(i).getNameSong().equals(name)){
                index=i;
            }
        }
        this.songs.remove(index);
    }
    public void editNameSong(String name,Song song){
        int index = -1;
        for (int i = 0; i < songs.size(); i++) {
            if(this.songs.get(i).getNameSong().equals(name)){
                index = i;
            }
        }
        this.songs.set(index,song);
    }

    // hàm tìm albuml của mình
    public void findNameSong(String name){
        int index = -1;
        for (int i = 0; i < songs.size(); i++) {
            if(this.songs.get(i).getNameSong().equals(name)){
                index = i;
            }
        }
        System.out.println(this.songs.get(index));
    }

    // kiểm tra bài hát có không
    public Song findById(int id){
        for (Song s: songs) {
            if (s.getId() == id) return s;
        }
        return null;
    }
}
