package MasterClass.InnerClasses.InnerClassesChallange;

import java.util.*;

/**
 * Created by LunguC on 12.07.2017.
 */


// x Create a program that implements a playlist for songs x
// x Create a Song class having Title and Duration for a song. x
// x The program will have an Album class containing a list of songs.
// x The albums will be stored in an ArrayList
// x Songs from different albums can be added to the playlist and will appear in the list in the order
// they are added.
// x Once the songs have been added to the playlist, create a menu of options to:-
// Quit,Skip forward to the next song, skip backwards to a previous song.  Replay the current song.
// List the songs in the playlist
// x A song must exist in an album before it can be added to the playlist (so you can only play songs that
// you own).
// Hint:  To replay a song, consider what happened when we went back and forth from a city before we
// started tracking the direction we were going.
// As an optional extra, provide an option to remove the current song from the playlist
// (hint: listiterator.remove()


public class Main {

    private static ArrayList<Album> albums = new ArrayList<Album>();

    public static void main(String[] args) {
        Album al = new Album("Strombringer", "Deep Purple");
        al.addSong("StormBringer", 4.6);
        al.addSong("heartbreaker", 2.6);
        al.addSong("Rain", 3.63);
        al.addSong("this is it", 4.11);
        al.addSong("You can`t do it ", 4.43);
        al.addSong("The gypsy", 3.66);
        al.addSong("Fortune", 5.6);
        albums.add(al);

        al = new Album("For thouse about to rock", "AC/DC");
        al.addSong("This is life", 2.20);
        al.addSong("The end is near", 4.20);
        al.addSong("Over the rainbow", 3.22);
        al.addSong("Another one bites the dust", 3.50);
        al.addSong("Blue Nights", 4.10);
        al.addSong("Extasy", 2.43);
        albums.add(al);

        LinkedList<Song> playList = new LinkedList<Song>();
        albums.get(1).addToPlayList("This is life", playList);
        albums.get(0).addToPlayList("Fortune", playList);
        albums.get(1).addToPlayList("Extasy", playList);
        albums.get(0).addToPlayList("this", playList); // doesn`t exist
        albums.get(0).addToPlayList(3, playList);
        albums.get(1).addToPlayList(4, playList);
        albums.get(1).addToPlayList(44, playList);


        play(playList);
    }


    // implementing the play method

    private static void play(LinkedList<Song> playList) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playList.listIterator();
        if (playList.size() == 0) {
            System.out.println("No songs in playList)");
            return;
        } else {
            System.out.println("Now playing: _-_oO-Oo-^_^ -> " + listIterator.next().toString());
            printMeniu();
        }

        while (!quit) {
            int action = scanner.nextInt();
            scanner.nextLine();
            switch (action) {
                case 0:
                    System.out.println("Exiting the playList .. .  .");
                    quit = true;
                    break;
                case 1:
                    if (!forward) {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if (listIterator.hasNext()) {
                        System.out.println("Skipping forward to " + listIterator.next().toString());
                    } else {
                        System.out.println("Reached the end of the playList");
                        forward = false;
                    }
                    break;
                case 2:
                    if (forward) {
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if (listIterator.hasPrevious()) {
                        System.out.println("Skipping backwards to: " + listIterator.previous());
                    } else {
                        System.out.println("Reached to the start of the playList");
                        forward = true;
                    }
                    break;
                case 3:
                    if (forward) {
                        if (listIterator.hasPrevious()) {
                            System.out.println("Now replaying " + listIterator.previous().toString());
                        } else {
                            System.out.println("We are at the start of the list ");
                        }
                    } else {
                        if (listIterator.hasNext()) {
                            System.out.println("Now replaying " + listIterator.next().toString());
                            forward = true;
                        } else {
                            System.out.println("We have reached the end of the list");
                        }
                    }
                    break;
                case 4:
                    printList(playList);
                    break;
                case 5:
                    printMeniu();
                    break;
                case 6:
                    if (playList.size() > 0) {
                        listIterator.remove();
                        if (listIterator.hasNext()) {
                            System.out.println("Now Playing " + listIterator.next());
                        } else if (listIterator.hasPrevious()) {
                            System.out.println("Now Playing " + listIterator.previous());
                        }
                    }
                    break;

            }
        }

    }

    public static void printMeniu() {
        System.out.println("\nAvailable optionss:\nPress:");
        System.out.println("\t 0 - To quit");
        System.out.println("\t 1 - To play next song");
        System.out.println("\t 2 - To play previous song");
        System.out.println("\t 3 - To replay current song");
        System.out.println("\t 4 - To List songs in the playList");
        System.out.println("\t 5 - To print available options");
        System.out.println("\t 6 - Delete current song");
    }

    private static void printList(LinkedList<Song> playList) {
        Iterator<Song> Iterator = playList.iterator();
        System.out.println("======================");
        while (Iterator.hasNext()) {
            System.out.println(Iterator.next());
        }
        System.out.println("======================");
    }


}

// Modify the playlist challenge so that the Album class uses an inner class.
// Instead of using an ArrayList to hold its tracks, it will use an inner class called SongList
// The inner SongList class will use an ArrayList and will provide a method to add a song.
// It will also provide findSong() methods which will be used by the containing Album class
// to add songs to the playlist.
// Neither the Song class or the Main class should be changed.







