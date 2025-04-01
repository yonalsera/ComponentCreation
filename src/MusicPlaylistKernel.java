import components.map.Map;
import components.sequence.Sequence;

/**
 * Music playlist kernel component with primary methods.
 *
 * @initially <pre>
 * ():
 *  ensures
 *   this = {}
 * </pre>
 */
public interface MusicPlaylistKernel extends Standard<MusicPlaylist>{

    /**
     * Checks whether the playlist is empty and returns the result.
     *
     * @param playlist
     *            playlist to be checked
     * @return boolean whether playlist is empty or not
     */
    boolean isEmpty(Sequence<Map.Pair<String, String>> playlist);

    /**
     * Adds a singular song to the playlist, given as a Map.Pair.
     *
     * @param playlist
     *            playlist to be checked
     * @param song
     *            Map.Pair<String, String> that will be added to playlist
     */
    void add(Map.Pair<String, String> song,
            Sequence<Map.Pair<String, String>> playlist);

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
    Map.Pair<String, String> remove(Sequence<Map.Pair<String, String>> playlist,
            String title, String artist);

    /**
     * Removes all elements from playlist.
     *
     * @param playlist
     *            playlist to be checked
     */
    void clear(Sequence<Map.Pair<String, String>> playlist);

    /**
     *
     * @param playlist
     *            playlist that is being checked
     * @param song
     *            song that is being searched for
     * @return boolean whether song is present or not
     */
    boolean hasSong(Sequence<Map.Pair<String, String>> playlist,
            Map.Pair<String, String> song);

}
