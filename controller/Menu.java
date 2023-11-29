package controller;

import java.io.IOException;
import java.util.Scanner;

public class Menu {
    Scanner inputInt=new Scanner(System.in);
  MenuAlbum menuAlbum=new MenuAlbum();
  MenuSong menuSong =new MenuSong();
    int choice ;

    public Menu() throws IOException {
    }


    public void showMenu() throws IOException {
        do {
            System.out.println(
                    "-----Menu-----" +
                            "\n 0.thoat" +
                            "\n 1.Quản Lý Bài Hát" +
                            "\n 2.Quản Lý Album");
            choice = inputInt.nextInt();
            switch (choice) {
                case 1:
                    menuSong.showMenuSong();
                    break;
                case 2:
                   menuAlbum.showMenuAlbum();
                    break;
            }

        } while (choice != 0);
    }

}
