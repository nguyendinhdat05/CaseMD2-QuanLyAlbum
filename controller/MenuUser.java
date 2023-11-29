package controller;

import models.User;
import sevices.ManagerUser;

import java.io.IOException;
import java.util.Scanner;

public class MenuUser {
    ManagerUser user = new ManagerUser();
    Scanner inputInt = new Scanner(System.in);
    Scanner inputString = new Scanner(System.in);

    int choice = -1;

    public void showMenuUser() throws IOException {
        do {
            System.out.println(
                    "-----Menu-----" +
                            "\n 0.thoat"+
                            "\n 1.Đăng Nhập" +
                            "\n 2.Đăng Ký"

            );
            choice = inputInt.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("nhập tên đăng nhập");
                    String name = inputString.nextLine();
                    System.out.println("nhập mật khẩu");
                    String pass = inputString.nextLine();
                    user.checkAcc(name, pass);
                    break;

                case 2:
                    System.out.println("nhập tên đăng ký");
                    String newName = inputString.nextLine();
                    System.out.println("nhập mật khẩu");
                    String newPass = inputString.nextLine();
                    User user1 = new User(newName, newPass);
                    user.addAcount(user1);
                    break;

            }

        } while (choice != 0);
    }

}
