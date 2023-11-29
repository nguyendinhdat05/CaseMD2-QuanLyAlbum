package sevices;

import java.util.ArrayList;
import java.util.List;

public class ManagerAlbum {
    List<Album> albumList = new ArrayList<>();

    public ManagerAlbum() {
        albumList.add(new Album(1, "a"));
        albumList.add(new Album(2, "b"));
        albumList.add(new Album(3, "c"));
    }

    public void add(Album a){
        albumList.add(a);
    }
    public void showAll(){
        for (Album a:albumList) {
            System.out.println(a);
        }
    }
    public Album findById(int id) {
        for (Album a: albumList) {
            if (a.getId() == id)
                return a;
        }
        return null;
    }
    public void deleteAlbum( int album){
        int index = -1;
        for (int i = 0; i < this.albumList.size(); i++) {
            if(albumList.get(i).getId()==album){
                index=i;
            }
        }
        this.albumList.remove(index);
    }
    public void editAlbum(int id, Album album) {
        int index = -1;
        for (int i = 0; i < albumList.size(); i++) {
            if (this.albumList.get(i).getId()==id) {
                index = i;
            }
        }
        this.albumList.set(index, album);
    }
    public void findNameAlbum(String name) {
        int index = -1;
        for (int i = 0; i < albumList.size(); i++) {
            if (this.albumList.get(i).getName().equals(name)) {
                index = i;
            }
        }
        System.out.println(this.albumList.get(index));
    }
}
