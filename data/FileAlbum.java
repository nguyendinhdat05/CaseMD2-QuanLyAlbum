package data;

import sevices.Album;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileAlbum {
    public static void writeAlbumFile(String path, List<Album> albumList) throws IOException {
        FileWriter fileWriter = new FileWriter(path);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        String line = "ID,NameAlbum,Song\n";
        for (Album album : albumList) {
            line += album.getId()+","+album.getName()+","+album.getAlbum()+"\n";
        }
        bufferedWriter.write(line);
        bufferedWriter.close();
        fileWriter.close();
    }

    public static List<Album> readAlbumFile(String path) throws IOException {

        List<Album> albumList = new ArrayList<>();
        FileReader fileReader = new FileReader(path);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String content = bufferedReader.readLine();
        while ((content = bufferedReader.readLine()) != null) {
            String[] valve = content.split(",");
            int id = Integer.parseInt(valve[0]);
            String name = valve[1];


        }
        bufferedReader.close();
        fileReader.close();
        return albumList;
    }
}
