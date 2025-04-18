/**
 * Layered implementations of secondary methods for {@code MusicPlaylist}.
 */
public abstract class MusicPlaylistSecondary implements MusicPlaylist {

    /*
     * Common methods (from Object) -------------------------------------------
     */

    @Override
    public final String toString() {
        final int four = 4;
        String str = "";
        int length = this.length();
        for (int i = 0; i < length; i++) {
            str += this.getSong(i).toString().substring(four) + "\n";
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

    @Override
    public final void merge(MusicPlaylist p2) {
        String title = "";
        String artist = "";
        for (int i = 0; i < p2.length(); i++) {
            title = p2.getSong(i).title();
            artist = p2.getSong(i).artist();
            this.add(p2.remove(title, artist));
        }
    }

    @Override
    public final boolean isEmpty() {
        return this.length() == 0;
    }

    @Override
    public final String[] getArtist(String title) {
        int length = this.length();
        String[] artists = new String[this.length()];
        int j = 0;
        for (int i = 0; i < length; i++) {
            if (this.getSong(i).title().equals(title)) {
                artists[j] = this.getSong(i).artist();
                j++;
            }
        }
        return artists;
    }

    @Override
    public final String[] getSongs(String artist) {
        int length = this.length();
        String[] titles = new String[this.length()];
        int j = 0;
        for (int i = 0; i < length; i++) {
            if (this.getSong(i).artist().equals(artist)) {
                titles[j] = this.getSong(i).title();
                j++;
            }
        }
        return titles;
    }

    @Override
    public final void shuffle() {
        MusicPlaylist temp = this.newInstance();
        MusicPlaylist origPlaylist = this.newInstance();

        for (int i = 0; i < this.length(); i++) {
            origPlaylist.add(this.getSong(i));
        }
        while (this.equals(origPlaylist)) {
            int length = this.length();
            while (length != 0) {
                int i = (int) (Math.random() * this.length());
                temp.add(this.remove(this.getSong(i).title(),
                        this.getSong(i).artist()));
            }
            for (int i = 0; i < length; i++) {
                this.add(temp.remove(temp.getSong(i).title(),
                        temp.getSong(i).artist()));
            }
        }
    }
}
