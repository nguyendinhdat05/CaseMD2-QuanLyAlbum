package sevices;

import models.Song;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Songs {
    List<Song> songs = new ArrayList<>();

    public Songs() {
        songs.add(new Song(1,"a", "b"));
        songs.add(new Song(2,"b", "b"));

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
    public static void writeFile(List<Song> songList) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\Users\\admin\\IdeaProjects\\Case_MD2_QuanLyAlbum\\src\\data\\songsData.csv"));
            String line = "";
            for (Song s: songList) {
                line += s.getId() + "," + s.getNameSong() + "," + s.getNameSinger();
            }
            bufferedWriter.write(line);
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public List<Song> readFile() {
        List<Song> songList = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\admin\\IdeaProjects\\Case_MD2_QuanLyAlbum\\src\\data\\songsData.csv"));
            String content = bufferedReader.readLine();
            while ((content = bufferedReader.readLine()) != null) {
                String[] value = content.split(",");
                int id = Integer.parseInt(value[0]);
                String nameSong = value[1];
                String nameSinger = value[2];
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return songList;
    }
}
