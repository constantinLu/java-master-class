package MasterClass.TestDB.Model82;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lunguc on 28.08.2017.
 */
public class Datasource {

    // defining the constants
    // name of the database, name of the table, nme of the columns etc..
    public static final String DB_NAME = "music.db";

    // always in front of the declaration path is the library , like exemple : "jdbc:sqlite:"
    public static final String CONNECTION_STRING = "jdbc:sqlite:C:\\Users\\lunguc\\Desktop\\J\\xx Tools\\databases\\" + DB_NAME;

    public static final String TABLE_ALBUMS = "albums";
    public static final String COLUMN_ALBUM_ID = "_id";
    public static final String COLUMN_ALBUM_NAME = "name";
    public static final String COLUMN_ALBUM_ARTIST = "artist";
    public static final int INDEX_ALBUM_ID = 1;
    public static final int INDEX_ALBUM_NAME = 2;
    public static final int INDEX_ALBUM_ARTIST = 3;

    public static final String TABLE_ARTISTS = "artists";
    public static final String COLUMN_ARTIST_ID = "_id";
    public static final String COLUMN_ARTIST_NAME = "name";
    public static final int INDEX_ARTIST_ID = 1;
    public static final int INDEX_ARTIST_NAME = 2;

    public static final String TABLE_SONGS = "songs";
    public static final String COLUMN_SONG_ID = "_id";
    public static final String COLUMN_SONG_TRACK = "track";
    public static final String COLUMN_SONG_TITLE = "title";
    public static final String COLUMN_SONG_ALBUM = "album";
    public static final int INDEX_SONG_ID = 1;
    public static final int INDEX_SONG_TRACK = 2;
    public static final int INDEX_SONG_TITLE = 3;
    public static final int INDEX_SONG_ALBUM = 4;


    //building other constatns for ease the work
    // constant for selection
    public static final String QUERY_ALBUMS_BY_ARTIST_START =
            "SELECT " + TABLE_ALBUMS + '.' + COLUMN_ALBUM_NAME + " FROM " + TABLE_ALBUMS +
                    " INNER JOIN " + TABLE_ARTISTS + " ON " + TABLE_ALBUMS + "." + COLUMN_ALBUM_ARTIST +
                    " = " + TABLE_ARTISTS + "." + COLUMN_ARTIST_ID + " WHERE " + TABLE_ARTISTS + "." +
                    COLUMN_ARTIST_NAME + " = \"";

    // constant for ORDER BY CLAUSE
    public static final String QUERY_ALBUMS_BY_ARTIST_SORT =
            " ORDER BY " + TABLE_ALBUMS + "." + COLUMN_ALBUM_NAME + " COLLATE NOCASE ";


    // constants for QUERY ARTISTS
    public static final String QUERY_ARTISTS = "SELECT * FROM " + TABLE_ARTISTS;
    public static final String QUERY_ARTISTS_SORT = " ORDER BY " + COLUMN_ARTIST_NAME + " COLLATE NOCASE ";


    // constants for QueryArtistsForSongMethod
//    SELECT artists.name, albums.name, songs.track
//    FROM songs INNER JOIN albums ON songs.album  = albums._id
//    INNER JOIN artists ON  albums.artist = artists._id
//    WHERE songs.title = "Go Your Own Way"
//    ORDER BY artists.name, albums.name collate NOCASE ASC;

    public static final String QUERY_ARTISTS_FOR_SONG_START = "SELECT " + TABLE_ARTISTS + "." + COLUMN_ARTIST_NAME +
            ", " + TABLE_ALBUMS + "." + COLUMN_ALBUM_NAME + ", " + TABLE_SONGS + "." + COLUMN_SONG_TRACK +
            " FROM " + TABLE_SONGS + " INNER JOIN " + TABLE_ALBUMS + " ON " + TABLE_SONGS + "." + COLUMN_SONG_ALBUM +
            " = " + TABLE_ALBUMS + "." + COLUMN_ALBUM_ID + " INNER JOIN " + TABLE_ARTISTS + " ON " + TABLE_ALBUMS +
            "." + COLUMN_ALBUM_ARTIST + " = " + TABLE_ARTISTS + "." + COLUMN_ARTIST_ID + " WHERE " + TABLE_SONGS +
            "." + COLUMN_SONG_TITLE + " = \"";

    public static final String QUERY_ARTISTS_FOR_SONG_SORT = "ORDER BY " + TABLE_ARTISTS + "." + COLUMN_ARTIST_NAME +
            ", " + TABLE_ALBUMS + "." + COLUMN_ALBUM_NAME + " COLLATE NOCASE ";

    // CREATING THE VIEW
    // DEFINING THE STATIC VARIABLES
//    CREATE VIEW IF NOT EXISTS list AS SELECT artists.name, albums.name AS album, songs.track, songs.title FROM songs
//    INNER JOIN albums ON songs.album = albums._id
//    INNER JOIN artists ON albums.artist = artists._id
//    ORDER BY  artists.name, albums.name, songs.track;

    public static final String TABLE_ARTIST_SONG_VIEW = "list";
    public static final String CREATE_ARTIST_FOR_SONG_VIEW = "CREATE VIEW IF NOT EXISTS " + TABLE_ARTISTS +
            " AS SELECT " + TABLE_ARTISTS + "." + COLUMN_ARTIST_NAME + " ," + TABLE_ALBUMS + "." + COLUMN_ALBUM_NAME +
            " AS " + COLUMN_SONG_ALBUM + "," + TABLE_SONGS + "." + COLUMN_SONG_TRACK + ", " + TABLE_SONGS + "." +
            COLUMN_SONG_TITLE + " FROM " + TABLE_SONGS + " INNER JOIN " + TABLE_ALBUMS + " ON " + TABLE_SONGS + "." +
            COLUMN_SONG_ALBUM + " =  " + TABLE_ALBUMS + COLUMN_ALBUM_ID + " INNER JOIN " + TABLE_ARTISTS + " ON " +
            TABLE_ALBUMS + "." + COLUMN_ALBUM_ARTIST + " = " + TABLE_ARTISTS + COLUMN_ARTIST_ID + " ORDER BY " +
            TABLE_ARTISTS + COLUMN_ARTIST_NAME + "," + TABLE_ALBUMS + COLUMN_ALBUM_NAME + "," + TABLE_SONGS + COLUMN_SONG_TRACK;


    // static varabiles for 288 - writing a method for query - view
    //SELECT name, album, track FROM list WHERE title = "title";

    public static final String QUERY_VIEW_SONG_INFO = "SELECT " + COLUMN_ARTIST_NAME + ", " + COLUMN_SONG_ALBUM +
            ", " + COLUMN_SONG_TRACK + " FROM " + TABLE_ARTIST_SONG_VIEW + " WHERE " + COLUMN_SONG_TITLE + " = \"";


    // 289 - for injection

    // SQL STatement -  SELECT name, album, track, FROM list WHERE title = ?
    public static final String QUERY_VIEW_SONG_INFO_PREP = "SELECT " + COLUMN_ARTIST_NAME + ", " + COLUMN_SONG_ALBUM +
            ", " + COLUMN_SONG_TRACK + " FROM " + TABLE_ARTIST_SONG_VIEW + " WHERE " + COLUMN_SONG_TITLE + " = ?"; // it will be replace every time because of the prepareStatment


    public static final int ORDER_BY_NONE = 1;
    public static final int ORDER_BY_ASC = 2;
    public static final int ORDER_BY_DESC = 3;


    //creating  a method; (for closing and opening the connections database
    private Connection conn;
    // for injection (from java.sql)
    private PreparedStatement querySongInfoView;

    public boolean open() {
        try {
            conn = DriverManager.getConnection(CONNECTION_STRING);
            querySongInfoView = conn.prepareStatement(QUERY_VIEW_SONG_INFO_PREP); // adding the prepareStatement in the open();
            return true;
        } catch (SQLException e) {
            System.out.println("Couldn`t connect to the database: " + e.getMessage()); //egetmassage is for showing the error
            e.printStackTrace();
            return false;
        }
    }


    public void close() {
        try {
            //fist close the statements
            if (querySongInfoView != null) {
                querySongInfoView.close();
            }
            if (conn != null) {
                conn.close();

            }
        } catch (SQLException e) {
            System.out.println("Couldn`t close the connection: " + e.getMessage());  //e.getMessage is for showing the error;
        }
    }

    // creating the method for query;
    // 2nd ! - >> method for : retrive all the albums for a particular artist


//    public List<Artist> queryArtists(int sortOrder) {
//
//        StringBuilder sb = new StringBuilder("SELECT * FROM ");
//        sb.append(TABLE_ARTISTS);
//        if (sortOrder != ORDER_BY_NONE) {
//            sb.append(" ORDER BY ");
//            sb.append(COLUMN_ARTIST_NAME);
//            sb.append(" COLLATE NOCASE ");
//            if (sortOrder == ORDER_BY_DESC) {
//                sb.append(" DESC ");
//            } else {
//                sb.append(" ASC ");
//            }
//        }


    // Simplyfied method for query artists using constants'

    public List<Artist> queryArtists(int sortOrder) {

        StringBuilder sb = new StringBuilder(QUERY_ARTISTS);
        if (sortOrder != ORDER_BY_NONE) {
            sb.append(QUERY_ARTISTS_SORT);
            if (sortOrder == ORDER_BY_DESC) {
                sb.append(" DESC ");
            } else {
                sb.append(" ASC ");
            }
        }


//        Statement statement = null;
//        ResultSet results = null;

        //SECOND METHOD IN THE TRY STATEMEMENT
        try (Statement statement = conn.createStatement();
             ResultSet results = statement.executeQuery(sb.toString())) {

            // FIRST METHOD
            //            statement = conn.createStatement();
//            results = statement.executeQuery("SELECT * FROM " + TABLE_ARTISTS);


            List<Artist> artists = new ArrayList<>();
            while (results.next()) {
                Artist artist = new Artist();
                artist.setId(results.getInt(INDEX_ARTIST_ID));
                artist.setName(results.getString(INDEX_ARTIST_NAME));
                artists.add(artist);

            }
            return artists;


        } catch (SQLException e) {
            System.out.println("Query failed " + e.getMessage());
            return null;


            // no need if we are ousing the second METHOD TRY implemented above because it is closing automatticly
//        } finally {
//            try {
//                if (results != null) {
//                    results.close();
//                }
//            } catch (SQLException e) {
//                System.out.println("Error closing ResultsSet" + e.getMessage());
//            }
//            try {
//                if(statement != null) {
//                    statement.close();
//                }
//            } catch(SQLException e) {
//                System.out.println("Error closing Statement" + e.getMessage());
//            }
//        }
        }

    }

    // 284-query-albums-by-artist-method

    public List<String> queryAlbumsForArtist(String artistName, int sortOrder) {

        //SELECT albums.name FROM albums INNER JOIN artists ON albums.artist = artists._id
        // WHERE artists.name = "Pink Floyd" ORDER BY albums.name COLLATE NOCASE ASC
//        StringBuilder sb = new StringBuilder(" SELECT ");
//        sb.append(TABLE_ALBUMS);
//        sb.append('.');
//        sb.append(COLUMN_ALBUM_NAME);
//        sb.append(" FROM ");
//        sb.append(TABLE_ALBUMS);
//        sb.append(" INNER JOIN ");
//        sb.append(TABLE_ARTISTS);
//        sb.append(" ON ");
//        sb.append(TABLE_ALBUMS);
//        sb.append('.');
//        sb.append(COLUMN_ALBUM_ARTIST);
//        sb.append(" = ");
//        sb.append(TABLE_ARTISTS);
//        sb.append('.');
//        sb.append(COLUMN_ARTIST_ID);
//        sb.append(" WHERE ");
//        sb.append(TABLE_ARTISTS);
//        sb.append('.');
//        sb.append(COLUMN_ALBUM_NAME);
//        sb.append(" = \"");
//        sb.append(artistName);
//        sb.append("\"");

        // simplyfied method using the constants;
        StringBuilder sb = new StringBuilder(QUERY_ALBUMS_BY_ARTIST_START);
        sb.append(artistName);
        sb.append("\"");

        if (sortOrder != ORDER_BY_NONE) {
            sb.append(QUERY_ALBUMS_BY_ARTIST_SORT);
            if (sortOrder == ORDER_BY_DESC) {
                sb.append("DESC ");
            } else {
                sb.append("ASC ");
            }
        }

        //add the code for sort order
        //SELECT albums.name FROM albums INNER JOIN artists ON albums.artist = artists._id
        // WHERE artists.name = "Pink Floyd" ORDER BY albums.name COLLATE NOCASE ASC
//        if (sortOrder != ORDER_BY_NONE) {
//            sb.append(" ORDER BY ");
//            sb.append(TABLE_ALBUMS);
//            sb.append('.');
//            sb.append(COLUMN_ALBUM_NAME);
//            sb.append(" COLLATE NOCASE ");
//            if (sortOrder == ORDER_BY_DESC) {
//                sb.append("DESC ");
//            } else {
//                sb.append("ASC ");
//            }
//        }

        System.out.println("SQL statement = " + sb.toString());


        try (Statement statement = conn.createStatement();
             ResultSet results = statement.executeQuery(sb.toString())) {

            List<String> albums = new ArrayList<String>();
            while (results.next()) {
                //Album album = new Album();
                albums.add(results.getString(1)); // index corespund to the column in the results and not in the table

            }
            return albums;

        } catch (SQLException e) {
            System.out.println("Query failed " + e.getMessage());
            e.printStackTrace();
            return null;
        }


    }

    //285 - query - artists - for - song - method
    //method for witch artist recorded a particulary song
    // return artist name, album name, track number of the song
    // create a class in a model for returning the values

    public List<SongArtist> queryArtistsForSong(String songName, int sortOrder) {

        StringBuilder sb = new StringBuilder(QUERY_ARTISTS_FOR_SONG_START);
        sb.append(songName);
        sb.append("\"");
        if (sortOrder != ORDER_BY_NONE) {
            sb.append(QUERY_ARTISTS_FOR_SONG_SORT);
            if (sortOrder == ORDER_BY_DESC) {
                sb.append(" DESC");
            } else {
                sb.append(" ASC");
            }
        }

        System.out.println("SQL statement: " + sb.toString());

        try (Statement statement = conn.createStatement();
             ResultSet results = statement.executeQuery(sb.toString())) {

            List<SongArtist> songArtists = new ArrayList<>();
            while (results.next()) {
                SongArtist songArtist = new SongArtist();
                songArtist.setArtistName(results.getString(1));
                songArtist.setAlbumnName(results.getString(2));
                songArtist.setTrack(results.getInt(3));
                songArtists.add(songArtist);

            }
            return songArtists;


        } catch (SQLException e) {
            System.out.println(" SQL query failed: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    // 86 - functions
    // GENERAL QUERY ON THE SONGS TABLE

    public void querySongsMetadata() {
        String sql = " SELECT * FROM " + TABLE_SONGS;

        try (Statement statement = conn.createStatement();
             ResultSet results = statement.executeQuery(sql)) {

            ResultSetMetaData meta = results.getMetaData();
            int numColumns = meta.getColumnCount();
            for (int i = 1; i <= numColumns; i++) {
                System.out.format("Column %d in the songs table is names %s\n", i, meta.getColumnName(i));

            }
        } catch (SQLException e) {
            System.out.println("QUERY FAIELD : " + e.getMessage());
            e.printStackTrace();

        }
    }

    // 87  VIEWS and functions
    // SELECT count(*) FROM songs
    // creating a count method

    public int getCount(String table) {
        String sql = " SELECT COUNT(*) AS COUNT FROM " + table;
        try (Statement statement = conn.createStatement();
             ResultSet results = statement.executeQuery(sql)) {

            int count = results.getInt("COUNT");
            //int min = results.getInt("MIN_ID");

            System.out.format("Count = %d ", count);
            return count;

        } catch (SQLException e) {
            System.out.println("QUERY FAILD: " + e.getMessage());
            return -1;
        }
    }

    //287 - create the view
    // create the method for the view
    //CREATE_ARTIST_FOR_SONG_VIEW

    public boolean createViewForSongArtists() {
        try (Statement statement = conn.createStatement()) {

            statement.execute(CREATE_ARTIST_FOR_SONG_VIEW);
            return true;

        } catch (SQLException e) {
            System.out.printf("QUERY FAILD: " + e.getMessage());
            return false;
        }
    }


    // 288 - WRITING THE MOETHOD TO QUERY A VIEW
    // SELECT name, album, track FROM list WHERE title = "title";
    // QUERY_VIEW_SONG_INFO

    public List<SongArtist> querySongInfoView(String title) {
//        StringBuilder sb = new StringBuilder(QUERY_VIEW_SONG_INFO);
//        sb.append(title);
//        sb.append("\";");

//        System.out.println("\n");
        //System.out.println(sb.toString());
        try {
            querySongInfoView.setString(1, title);
            ResultSet results = querySongInfoView.executeQuery();


            //try (Statement statement = conn.createStatement();
//            ResultSet results = statement.executeQuery(sb.toString())) {
//
            List<SongArtist> songArtists = new ArrayList<SongArtist>();
            while (results.next()) {
                SongArtist songArtist = new SongArtist();
                songArtist.setArtistName(results.getString(1));
                songArtist.setAlbumnName(results.getString(2));
                songArtist.setTrack(results.getInt(3));
                songArtists.add(songArtist);

                System.out.println(title.toString());

            }
            return songArtists;

        } catch (SQLException e) {
            System.out.println("QUERY FAILED: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}



