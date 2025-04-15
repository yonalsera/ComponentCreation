
/**
 * {@code MusicPlaylistKernel} enhanced with secondary methods.
 */
public interface MusicPlaylist extends MusicPlaylistKernel {

    /**
     * Adds a second playlist to the end of the first one.
     *
     * @param p2
     *            playlist to be added to the end of the first playlist
     */
    void merge(MusicPlaylist p2);

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
     * Find and return titles of all songs belonging to a given artist.
     *
     * @param artist
     *            Name of artist whose song titles will be returned
     * @return Array of String with titles of each song
     */
    String[] getSongs(String artist);

    /**
     * Randomly shuffle the order of songs in the playlist.
     */
    void shuffle();

}
