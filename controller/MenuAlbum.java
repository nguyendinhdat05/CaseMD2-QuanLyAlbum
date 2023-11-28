package controller;

import models.Song;
import sevices.Album;
import sevices.Songs;
import sevices.User;

import java.util.Scanner;

public class MenuAlbum {
    User user=new User();
    Songs songs = new Songs();
    Scanner inputInt = new Scanner(System.in);
    Scanner inputString = new Scanner(System.in);
    int choice;
    public void showMenuAlbum() {
        do {
            System.out.println("-----Menu-----" +
                    "\n 0.Thoát" +
                    "\n 1.Hiển thị danh sách album" +
                    "\n 2.Thêm mới album" +
                    "\n 3.Sửa Album"+
                    "\n 4.Xóa Album"+
                    "\n 5.Tìm kiếm Album");
            choice = inputInt.nextInt();
            switch (choice) {
                case 1:
                    user.showAll();
                    break;
                case 2:
                    System.out.println("nhập ID mới của Album");
                    int id = inputInt.nextInt();
                    System.out.println("nhập tên Album mới");
                    String nameAlbum = inputString.nextLine();
                    Album album = new Album(id,nameAlbum);
                    user.add(album);
                    break;
                case 3:
                    System.out.println("nhập ID Album muốn sửa");
                    int idAlbum = inputInt.nextInt();
                    System.out.println("sửa id Album");
                    int newIdAlbum = inputInt.nextInt();
                    System.out.println("sửa tên Album");
                    String newNameAlbum = inputString.nextLine();
                    Album album1 = new Album(newIdAlbum,newNameAlbum);
                    user.editAlbum(idAlbum,album1);
                    break;
                case 4:
                    System.out.println("nhập ID Album muốn xóa");
                    int idAlbums = inputInt.nextInt();
                    user.deleteAlbum(idAlbums);
                    break;
                case 5:
                    System.out.println("nhập tên Album muốn tìm ");
                    String nameAlbums = inputString.nextLine();
                    user.findNameAlbum(nameAlbums);
                    break;
            }
        } while (choice != 0);
    }
}
