
/**
 * {@code MusicPlaylistKernel} enhanced with secondary methods.
 */
public interface MusicPlaylist extends MusicPlaylistKernel {
    /**
     * Checks whether the playlist is empty and returns the result.
     *
     * @return boolean of whether playlist is empty or not
     */
    boolean isEmpty();

    /**
     * Find and return all artists with a song of the given title.
     *
     * @param title
     *            Name of the song to find the corresponding artst
     * @return Array of String with names of the artists
     */
    String[] getArtist(String title);

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
