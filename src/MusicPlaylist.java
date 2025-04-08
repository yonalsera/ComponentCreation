import components.map.Map;
import components.sequence.Sequence;

/**
 * {@code MusicPlaylistKernel} enhanced with secondary methods.
 */
public interface MusicPlaylist extends MusicPlaylistKernel {
    /**
     * Merge two playlists together.
     *
     * @param p2
     *            The second playlist to be merged to the first
     */
    void merge(Sequence<Map.Pair<String, String>> p2);

    /**
     * Find and return the artist of the given song.
     *
     * @param title
     *            Name of the song to find the corresponding artst
     * @return String Name of the artist
     */
    String getArtist(String title);

    /**
     * Randomly shuffle the order of songs in the playlist.
     */
    void shuffle();

    /**
     * Returns a path to the given song in URL format.
     *
     * @param title
     *            Title of song that will have its path returned
     * @return String path to song in URL format
     */
    String getPath(String title);

}
