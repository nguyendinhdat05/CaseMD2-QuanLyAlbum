package controller;

import data.FileSong;
import models.Song;
import sevices.Album;
import sevices.ManagerSongs;
import sevices.ManagerAlbum;

import java.io.IOException;
import java.util.Scanner;

public class MenuSong {
    ManagerAlbum managerAlbum =MenuAlbum.managerAlbum;
    ManagerSongs songs = new ManagerSongs();
    Scanner inputInt = new Scanner(System.in);
    Scanner inputString = new Scanner(System.in);
    int choice ;

    public MenuSong() throws IOException {
    }

    public void showMenuSong() throws IOException {
        do {
            System.out.println("-----Menu-----" +
                    "\n 0.thoat" +
                    "\n 1.xem danh sách bài hát" +
                    "\n 2.thêm mới bài hát" +
                    "\n 3.xóa bài hát" +
                    "\n 4.tim kiem bài hát theo tên" +
                    "\n 5.sửa bài hát "+
                    "\n 6.thêm bài hát vào trong Album "+
                    "\n 7.xóa bài hát trong Album");
            choice = inputInt.nextInt();
            switch (choice) {
                case 1:
                    songs.showAll();
                    break;
                case 2:
                    System.out.println("nhập id của bài hát mới");
                    int id = inputInt.nextInt();
                    System.out.println("nhập tên bài hát mới");
                    String nameSong = inputString.nextLine();
                    System.out.println("nhập tên tác giả cho bài hát");
                    String nameSinger = inputString.nextLine();
                    Song song = new Song(id, nameSong, nameSinger);
                    songs.addSong(song);
                    FileSong.writerFileSong("songs.csv",songs.getSongs());
                    break;
                case 3:
                    System.out.println("nhập tên bài hát muốn xóa");
                    String name = inputString.nextLine();
                    songs.deleteSong(name);
                    FileSong.writerFileSong("songs.csv",songs.getSongs());
                    break;
                case 4:
                    System.out.println("nhập tên bài hát muốn tìm");
                    String music = inputString.nextLine();
                    songs.findNameSong(music);
                    FileSong.writerFileSong("songs.csv",songs.getSongs());
                    break;
                case 5:
                    System.out.println("nhập tên bài hát bạn muốn sửa");
                    String name1 = inputString.nextLine();
                    System.out.println("sửa tên id");
                    int idSong = inputInt.nextInt();
                    System.out.println("sửa tên bài hát");
                    String nameSong1 = inputString.nextLine();
                    System.out.println("sửa tên tác giả");
                    String nameSinger1 = inputString.nextLine();
                    Song song1 = new Song(idSong, nameSong1, nameSinger1);
                    songs.editNameSong(name1, song1);
                    FileSong.writerFileSong("songs.csv",songs.getSongs());
                    break;
                case 6:
                    addSongToAlbum();
                    break;
                case 7:
                    removeSongFromAlbum();
                    break;
            }
        } while (choice != 0);
        }
    public void addSongToAlbum(){
        managerAlbum.showAll();
        System.out.print("Nhập ID album muốn thêm: ");
        int albumId = inputInt.nextInt();
        Album album = managerAlbum.findById(albumId);
        songs.showAll();
        System.out.println("Nhập ID bài hát muốn thêm");
        int songId = inputInt.nextInt();
        Song song = songs.findById(songId);
        album.add(song);
        System.out.println("thêm thành công");
        managerAlbum.showAll();
    }
    public void removeSongFromAlbum(){
        managerAlbum.showAll();
        System.out.print("Nhập ID album muốn xóa: ");
        int albumId = inputInt.nextInt();
        Album album = managerAlbum.findById(albumId);
        System.out.println("Nhập ID bài hát muốn xóa");
        int songId = inputInt.nextInt();
        Song song = songs.findById(songId);
        album.remove(song);
        System.out.println("xóa thành công");
        managerAlbum.showAll();
    }
}
