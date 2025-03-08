import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
public class Jukebox1 {
    public static void main(String[] args) {
        new Jukebox1().go();
    }
    public void go(){
        List<String> songlist=MSongs.getSongsStrings();
        Collections.sort(songlist);
        System.out.println(songlist);
    }
}
class MSongs{
    public static List<String> getSongsStrings(){
        List<String> songs=new ArrayList<>();
        songs.add("Akasam enatidho");
        songs.add("Hello rockstar");
        songs.add("Baghtoy rikshawala");
        songs.add("Amma amma nee vennela");
        songs.add("Vennelave vennelave");
        return songs;
    }
}
