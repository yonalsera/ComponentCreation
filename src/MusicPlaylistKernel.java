import components.standard.Standard;

/**
 * Music playlist kernel component with primary methods.
 *
 * @initially <pre>
 * ():
 *  ensures
 *   this = {}
 * </pre>
 */
public interface MusicPlaylistKernel extends Standard<MusicPlaylist> {

        /**
         * Adds a singular song to the playlist, given as a song object.
         *
         * @param song
         *                song that will be added to playlist
         * @updates this
         * @ensures this = #this union song
         */
        void add(Song song);

        /**
         * Removes a singular song from the playlist given the song title, and
         * returns the removed song as a Song object.
         *
         * @param title
         *                the name of the song, key value of object
         * @return the Song object that was removed from the playlist
         * @updates this
         * @requires title is in DOMAIN(this)
         * @ensures <pre>
         * remove.title = title  and
         * remove is in #this  and
         * this = #this \ {remove}
         * </pre>
         */
        Song remove(String title);

        /**
         * @param song
         *                song that is being searched for
         * @return boolean true if song is present or false otherwise
         * @ensures hasSong = (song is in this)
         */
        boolean hasSong(Song song);

        /**
         *
         * @return number of songs in playlist
         * @ensures length = |this|
         */
        int length();

        /**
         * @param placement
         *                placement of song within the playlist
         * @return Song song including title and artist
         * @requires placement < this.length
         * @ensures (key, value) is in this
         */
        Song getSong(int placement);

}
