package controller;
import sevices.Album;
import sevices.ManagerAlbum;

import java.util.Scanner;

public class MenuAlbum {
    static ManagerAlbum managerAlbum =new ManagerAlbum();
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
                    managerAlbum.showAll();
                    break;
                case 2:
                    System.out.println("nhập ID mới của Album");
                    int id = inputInt.nextInt();
                    System.out.println("nhập tên Album mới");
                    String nameAlbum = inputString.nextLine();
                    Album album = new Album(id,nameAlbum);
                    managerAlbum.add(album);
                    break;
                case 3:
                    System.out.println("nhập ID Album muốn sửa");
                    int idAlbum = inputInt.nextInt();
                    System.out.println("sửa id Album");
                    int newIdAlbum = inputInt.nextInt();
                    System.out.println("sửa tên Album");
                    String newNameAlbum = inputString.nextLine();
                    Album album1 = new Album(newIdAlbum,newNameAlbum);
                    managerAlbum.editAlbum(idAlbum,album1);
                    break;
                case 4:
                    System.out.println("nhập ID Album muốn xóa");
                    int idAlbums = inputInt.nextInt();
                    managerAlbum.deleteAlbum(idAlbums);
                    break;
                case 5:
                    System.out.println("nhập tên Album muốn tìm ");
                    String nameAlbums = inputString.nextLine();
                    managerAlbum.findNameAlbum(nameAlbums);
                    break;
            }
        } while (choice != 0);
    }
}
