import components.map.Map;
import components.map.Map1L;
import components.sequence.Sequence;
import components.sequence.Sequence1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Class proving viable method implementations.
 */
public final class proofOfConcept {

    /**
     * -------- Implementation of Kernal methods. ------------
     */

    /**
     * Checks whether the playlist is empty and returns the result.
     *
     * @param playlist
     *            playlist to be checked
     * @return boolean whether playlist is empty or not
     */
    public static boolean isEmpty(Sequence<Map.Pair<String, String>> playlist) {
        return (playlist.length() == 0);
    }

    /**
     * Adds a singular song to the playlist, given as a Map.Pair.
     *
     * @param playlist
     *            playlist to be checked
     * @param song
     *            Map.Pair<String, String> that will be added to playlist
     */
    public static void add(Map.Pair<String, String> song,
            Sequence<Map.Pair<String, String>> playlist) {
        playlist.add(playlist.length(), song);
    }

    /**
     * Removes a singular song from the playlist given the song title and
     * artist, and returns the removed song as a Map.Pair.
     *
     * @param playlist
     *            playlist to be checked
     * @param title
     *            the name of the song and key of the map pair
     * @param artist
     *            the artist of the song and th value of the map pair
     * @return the map pair that was removed from the playlist
     */
    public static Map.Pair<String, String> remove(
            Sequence<Map.Pair<String, String>> playlist, String title,
            String artist) {
        //Not sure how to initialize a Map.Pair object by itself
        Map.Pair<String, String> pair = playlist.remove(0);
        int length = playlist.length();
        for (int i = 1; i < length - 1; i++) {
            if (!(pair.key().equals(title) && pair.value().equals(artist))) {
                playlist.add(length, pair);
            }
            pair = playlist.remove(i);
        }
        return pair;
    }

    /**
     * Removes all elements from playlist.
     *
     * @param playlist
     *            playlist to be checked
     */
    public static void clear(Sequence<Map.Pair<String, String>> playlist) {
        playlist.clear();
    }

    /**
     *
     * @param playlist
     *            playlist that is being checked
     * @param song
     *            song that is being searched for
     * @return boolean whether song is present or not
     */
    public static boolean hasSong(Sequence<Map.Pair<String, String>> playlist,
            Map.Pair<String, String> song) {
        boolean check = false;
        for (Map.Pair<String, String> pair : playlist) {
            if (pair.key().equals(song.key())
                    && pair.value().equals(song.value())) {
                check = true;
            }
        }
        return check;
    }

    /**
     * --------------------------------------------------------
     *
     * -------------------Secondary Methods--------------------
     */

    /**
     * Merge two playlists together.
     *
     * @param playlist
     *            playlist to be checked
     * @param p2
     *            The second playlist to be merged to the first
     */
    public static void merge(Sequence<Map.Pair<String, String>> playlist,
            Sequence<Map.Pair<String, String>> p2) {
        int i = 0;
        int length = p2.length();
        while (p2.length() >= 0 && i < length - 1) {
            Map.Pair<String, String> song = p2.remove(i);
            if (!(hasSong(playlist, song))) {
                add(song, playlist);
            } else {
                p2.add(p2.length(), song);
            }
            i++;
        }
    }

    /**
     * Find and return the artist of the given song.
     *
     * @param playlist
     *            playlist to be checked
     * @param title
     *            Name of the song to find the corresponding artst
     * @return String Name of the artist
     */
    public static String getArtist(Sequence<Map.Pair<String, String>> playlist,
            String title) {
        String artist = "";
        for (Map.Pair<String, String> pair : playlist) {
            if (pair.key().equals(title)) {
                artist = pair.value();
            }
        }
        return artist;
    }

    /**
     * Main method.
     *
     *
     * @param args
     *            The command line arguments; unused
     */
    public static void main(String[] args) {
        SimpleWriter out = new SimpleWriter1L();

        //Playlist to be changed
        Sequence<Map.Pair<String, String>> playlist = new Sequence1L<>();

        //Temporary map create to acces Map paires
        Map<String, String> m = new Map1L<>();
        m.add("Telepatia", "Kali Uchis");
        m.add("A Night To Remember", "Beabaddobee, Laufey");
        m.add("Amoeba", "Clairo");
        Map.Pair<String, String> song1 = m.remove("Telepatia");
        Map.Pair<String, String> song2 = m.remove("A Night To Remember");
        Map.Pair<String, String> song3 = m.remove("Amoeba");
        add(song1, playlist);
        add(song2, playlist);
        add(song3, playlist);

        //add method tests
        out.println("------------------------------");
        out.println("Testing add method:");
        out.println(playlist);
        out.println("------------------------------");

        remove(playlist, "Telepatia", "Kali Uchis");
        remove(playlist, "A Night To Remember", "Beabaddobee, Laufey");
        remove(playlist, "Amoeba", "Clairo");

        //remove method tests
        out.println("------------------------------");
        out.println("Testing remove method:");
        out.println(playlist);
        out.println("------------------------------");

        //isEmpty method test
        out.println("------------------------------");
        out.println("Test isEmpty method:");
        out.println(isEmpty(playlist));
        out.println("------------------------------");

        //Add map pairs into playlist again
        add(song1, playlist);
        add(song2, playlist);
        add(song3, playlist);

        //Test clear method
        out.println("------------------------------");
        out.println("Test clear method:");
        out.print("Before clear method:");
        out.println(playlist);
        clear(playlist);
        out.print("After clear method:");
        out.println(playlist);
        out.println("------------------------------");

        //Add map pairs into playlist again
        add(song1, playlist);
        add(song2, playlist);
        add(song3, playlist);

        //Test hasSong method
        out.println("------------------------------");
        out.println("Test hasSong method:");
        out.println(hasSong(playlist, song1));
        out.println("------------------------------");

        //Test merge method
        out.println("------------------------------");
        out.println("Test merge method:");
        Sequence<Map.Pair<String, String>> pl2 = new Sequence1L<>();
        //Temporary map create to acces Map paires
        Map<String, String> m2 = new Map1L<>();
        m2.add("Paranoia", "The Marias");
        m2.add("A Night To Remember", "Beabaddobee, Laufey");
        m2.add("Carnival", "The Cardigans");
        Map.Pair<String, String> song4 = m2.remove("Paranoia");
        Map.Pair<String, String> song5 = m2.remove("A Night To Remember");
        Map.Pair<String, String> song6 = m2.remove("Carnival");
        add(song4, pl2);
        add(song5, pl2);
        add(song6, pl2);
        //Begin testing (duplicate song should not be added)
        out.print("Playlist before hasSong method:");
        out.println(playlist);
        merge(playlist, pl2);
        out.print("Playlist after hasSong method:");
        out.println(playlist);
        out.println("------------------------------");

        //Test getArtist method
        out.println("------------------------------");
        out.println("Testing getArtist method:");
        out.println(getArtist(playlist, song1.key()));
        out.println("------------------------------");

        out.close();
    }
}
