/**
 * Layered implementations of secondary methods for {@code MusicPlaylist}.
 */
public abstract class MusicPlaylistSecondary implements MusicPlaylist {

    /*
     * Common methods (from Object) -------------------------------------------
     */

    @Override
    public final String toString() {
        String str = "";
        int length = this.length();
        for (int i = 0; i < length; i++) {
            str += this.getSong(i);
        }
        return str;
    }

    @Override
    public final boolean equals(Object obj) {
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
            this.add(p2.remove(title));
        }
    }

    /**
     * Checks whether the playlist is empty and returns the result.
     *
     * @return boolean of whether playlist is empty or not
     */
    @Override
    public boolean isEmpty() {
        return this.length() == 0;
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
        int length = this.length();
        String[] artists = new String[this.length()];
        int j = 0;
        for (int i = 0; i < length; i++) {
            if (this.getSong(i).key().equals(title)) {
                artists[j] = this.getSong(i).value();
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
        int length = this.length();
        String[] titles = new String[this.length()];
        int j = 0;
        for (int i = 0; i < length; i++) {
            if (this.getSong(i).value().equals(artist)) {
                titles[j] = this.getSong(i).key();
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
        MusicPlaylist temp = this.newInstance();
        while (this.length() != 0) {
            int i = (int) (Math.random() * this.length());
            temp.add(this.remove(this.getSong(i).key()));
        }
        int length = temp.length();
        for (int i = 0; i < length; i++) {
            this.add(temp.remove(temp.getSong(i).key()));
        }
    }
}
