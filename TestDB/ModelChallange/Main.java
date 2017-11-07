package MasterClass.TestDB.Model82;

import java.util.List;
import java.util.Scanner;

/**
 * Created by lunguc on 28.08.2017.
 */
public class Main {

    public static void main(String[] args) {
        Datasource datasource = new Datasource();
        if (!datasource.open()) {
            System.out.println("Can't open datasource");
            return;
        }

        List<Artist> artists = datasource.queryArtists(Datasource.ORDER_BY_ASC);
        if (artists == null) {
            System.out.println("No artists!");
            return;
        }

        for (Artist artist : artists) {
            System.out.println("ID = " + artist.getId() + ", Name = " + artist.getName());
        }


        List<String> albumsForArtists = datasource.queryAlbumsForArtist("Pink Floyd", Datasource.ORDER_BY_DESC);
        for (String album : albumsForArtists) {
            System.out.println(album);
        }

        // for songArtists

        List<SongArtist> songArtists = datasource.queryArtistsForSong("Go Your Own Way", Datasource.ORDER_BY_ASC);
        if (songArtists == null) {
            System.out.println("No song for the artist");
            return;
        }
        for (SongArtist artist : songArtists) {
            System.out.println("\n ------------------" + "\nArtist name = " + artist.getArtistName() + "\nAlbum name = " + artist.getAlbumnName() +
                    "\nTrack no. : " + artist.getTrack() + "\n ------------------");
        }


        // printing the metadata (headers of the table) if unknown
        datasource.querySongsMetadata();


        // for count methd
        int count = datasource.getCount(Datasource.TABLE_SONGS);
        System.out.printf(" Number of songs in the list  is : " + count);

        // for creating the view
        datasource.createViewForSongArtists();


        // injection 289 - ----->>>>>> continuing the queryView method;
        System.out.println("\n ------->289 - Injection <--------");
        Scanner scanner = new Scanner(System.in);
        System.out.println(" Enter a song title: ");
        String title = scanner.nextLine();
        if (!scanner.equals(songArtists)) {
            System.out.println("ERROR !");
        }


        // for querying the view
        //SELECT name, album, track FROM list WHERE title = "Go Your Own Way" or 1=1 or ""; (vulnerable for injection)

        // FIRST SCENARIO
        //SELECT name, album, track FROM list WHERE title = "Go Your Own Way or 1=1 or "";

        //THIRD SCENARIO
        //SELECT name, album, track FROM list WHERE title = ? OR artist = ?


        // SECOND WITH THE OUT " for a hakker to make a injections (PREPARED STATEMENTS)
        songArtists = datasource.querySongInfoView(title);
        if (songArtists.isEmpty()) {
            System.out.println("Could not find the title you are looking for");
            return;
        }
        for (SongArtist artist : songArtists) {
            System.out.println("FROM VIEW - Artist Name : " + artist.getArtistName() +
                    " Album name : " + artist.getAlbumnName() +
                    " Track no. : " + artist.getTrack());
        }


        datasource.close();

    }
}
