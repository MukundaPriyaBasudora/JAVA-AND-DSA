import java.util.*;
public class Hashsets {
    public static void main(String[] args) {
        new Hashsets().go();
    }
    public void go(){
        List<Song> song=new ArrayList<>();
        song.add(new Song("natu natu","dsp",4000));
        song.add(new Song("bava ding ding","thaman",6000));
        song.add(new Song("chikkini chameli","shreyA",20000));
        song.add(new Song("Mounangane edagamani","suneetha",4000));
        song.add(new Song("Mounangane edagamani","suneetha",4000));

        System.out.println(song);
        song.sort((one,two)->one.getArtist().compareTo(two.getArtist()));
        System.out.println(song);
        Set<Song> songs=new HashSet<>(song);
        System.out.println(songs);
        Set<Song> songs1=new TreeSet<>(song);
        System.out.println(songs1);
    }
}
class Song implements Comparable<Song>{
    private String title;
    private String artist;
    private int bpm;
    public boolean equals(Object asong){
        Song song=(Song) asong;
        return title.equals(song.getTitle());
    }
    public int hashCode(){
        return title.hashCode();
    }
    public int compareTo(Song s){
        return title.compareTo(s.getTitle());
    }
    Song(String title,String artist,int bpm){
        this.title=title;
        this.artist=artist;
        this.bpm=bpm;
    }
    public String getTitle(){
        return  title;
    }
    public String getArtist(){
        return artist;
    }
    public int getBpm(){
        return bpm;
    }
    public String toString(){
        return title;
    }

}
