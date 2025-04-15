/**
 * Layered implementations of secondary methods for {@code MusicPlaylist}.
 */
public abstract class MusicPlaylistSecondary implements MusicPlaylist {

    /**
     * MusicPlaylist object.
     */
    private MusicPlaylist playlist;

    /*
     * Common methods (from Object) -------------------------------------------
     */
    /**
     * Turn contents of MusicPlaylist object into a string.
     *
     * @return String of contents
     */
    @Override
    public String toString() {
        String str = "";
        int length = this.playlist.length();
        for (int i = 0; i < length; i++) {
            str += this.playlist.getSong(i);
        }
        return str;
    }

    /**
     * Checks if contents of two MusicPlaylist objects are the same.
     *
     * @param obj
     *            Object with contents that will be compared to this
     * @return True if contents are the same and false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        boolean check = true;
        if (this != obj || obj == null || this.getClass() != obj.getClass()) {
            check = false;
        }
        return check;
    }

    /*
     * Other non-kernel methods -----------------------------------------------
     */

    /**
     * Adds a second playlist to the end of the first one.
     *
     * @param p2
     *            playlist to be added to the end of the first playlist
     */
    @Override
    public void merge(MusicPlaylist p2) {
        String title = "";
        for (int i = 0; i < p2.length(); i++) {
            title = p2.getSong(i).key();
            this.playlist.add(p2.remove(title));
        }
    }

    /**
     * Checks whether the playlist is empty and returns the result.
     *
     * @return boolean of whether playlist is empty or not
     */
    @Override
    public boolean isEmpty() {
        return this.playlist.length() == 0;
    }

    /**
     * Find and return all artists with a song of the given title.
     *
     * @param title
     *            Name of the song to find the corresponding artst
     * @return Array of String with names of the artists
     */
    @Override
    public String[] getArtist(String title) {
        int length = this.playlist.length();
        String[] artists = new String[this.playlist.length()];
        int j = 0;
        for (int i = 0; i < length; i++) {
            if (this.playlist.getSong(i).key().equals(title)) {
                artists[j] = this.playlist.getSong(i).value();
                j++;
            }
        }
        return artists;
    }

    /**
     * Find and return titles of all songs belonging to a given artist.
     *
     * @param artist
     *            Name of artist whose song titles will be returned
     * @return Array of String with titles of each song
     */
    @Override
    public String[] getSongs(String artist) {
        int length = this.playlist.length();
        String[] titles = new String[this.playlist.length()];
        int j = 0;
        for (int i = 0; i < length; i++) {
            if (this.playlist.getSong(i).value().equals(artist)) {
                titles[j] = this.playlist.getSong(i).key();
                j++;
            }
        }
        return titles;
    }

    /**
     * Randomly shuffle the order of songs in the playlist.
     */
    @Override
    public void shuffle() {
        MusicPlaylist temp = this.playlist.newInstance();
        while (this.playlist.length() != 0) {
            int i = (int) (Math.random() * this.playlist.length());
            temp.add(this.playlist.remove(this.playlist.getSong(i).key()));
        }
        int length = temp.length();
        for (int i = 0; i < length; i++) {
            this.playlist.add(temp.remove(temp.getSong(i).key()));
        }
    }
}
