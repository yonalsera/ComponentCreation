
/**
 * {@code MusicPlaylistKernel} enhanced with secondary methods.
 */
public interface MusicPlaylist extends MusicPlaylistKernel {

    /**
     * Adds a second playlist to the end of the first one.
     *
     * @param p2
     *            playlist to be added to the end of the first playlist
     * @updates this
     * @ensures this = #this union p2
     */
    void merge(MusicPlaylist p2);

    /**
     * Checks whether the playlist is empty and returns the result.
     *
     * @return true if playlist is empty or false otherwise
     * @ensures isEmpty = (this.length = 0)
     */
    boolean isEmpty();

    /**
     * Find and return all artists with a song of the given title.
     *
     * @param title
     *            Name of the song to find the corresponding artst
     * @return Array of String with names of the artists
     * @requires title is in DOMAIN(this)
     * @ensures getArtist = array of this.value with key == title
     */
    String[] getArtist(String title);

    /**
     * Find and return titles of all songs belonging to a given artist.
     *
     * @param artist
     *            Name of artist whose song titles will be returned
     * @return Array of String with titles of each song
     * @requires artist is in RANGE(this)
     * @ensures getSongs = array of this.key with value == artist
     */
    String[] getSongs(String artist);

    /**
     * Randomly shuffle the order of songs in the playlist.
     *
     * @requres this.length > 0
     * @ensures order of this != order of #this
     */
    void shuffle();

}
