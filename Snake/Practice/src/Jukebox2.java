import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Jukebox2 {
    public static void main(String[] args) {
        new Jukebox2().go();
    }
    public void go(){
        List<Song> songs=Mocksongs.getSongs();
        System.out.println(songs);
//        Collections.sort(songs);
        System.out.println(songs);
        ArtistCompare artistCompare=new ArtistCompare();
        songs.sort(artistCompare);
        System.out.println(songs);
    }
}
class Song{
    private String title;
    private String artist;
    private int bpm;
    Song(String title,String artist,int bpm){
        this.title=title;
        this.artist=artist;
        this.bpm=bpm;
    }
    public String getTitle(){
        return title;
    }
    public String getArtist(){
        return artist;
    }
    public  int getBpm(){
        return bpm;
    }
    public String toString(){
        return artist;
    }
}
class Mocksongs{
    public static List<Song> getSongs(){
        List<Song> songs=new ArrayList<>();
        songs.add(new Song("Yemi cheyamanduve","Dsp",147));
        songs.add(new Song("annayya","spb",220));
        songs.add(new Song("Amma amma nee vennela","thaman",180));
        songs.add(new Song("hello rockstar","pspk",150));
//        System.out.println(songs);
        return songs;
    }
}
class ArtistCompare implements Comparator<Song>{
    public int compare(Song one,Song two){
        return one.getArtist().compareTo(two.getArtist());
    }
}
