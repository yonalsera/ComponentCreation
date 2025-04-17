import components.map.Map;
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
         * Adds a singular song to the playlist, given as a Map.Pair.
         *
         * @param song
         *                Map.Pair<String, String> that will be added to
         *                playlist
         * @updates this
         * @ensures this = #this union {(key, value)}
         */
        void add(Map.Pair<String, String> song);

        /**
         * Removes a singular song from the playlist given the song title, and
         * returns the removed song as a Map.Pair.
         *
         * @param title
         *                the name of the song and key of the map pair
         * @return the map pair that was removed from the playlist
         * @updates this
         * @requires title is in DOMAIN(this)
         * @ensures <pre>
         * remove.title = title  and
         * remove is in #this  and
         * this = #this \ {remove}
         * </pre>
         */
        Map.Pair<String, String> remove(String title);

        /**
         * @param song
         *                song that is being searched for
         * @return boolean true if song is present or false otherwise
         * @ensures hasSong = (song.key is in DOMAIN(this)) && song.value ==
         *          this.song.value
         */
        boolean hasSong(Map.Pair<String, String> song);

        /**
         *
         * @return number of songs in playlist
         * @ensures length = |this|
         */
        int length();

        /**
         * @param placement
         *                placement of song within the playlist
         * @return Map pair of the song including title and artist
         * @requires placement < this.length
         * @ensures (key, value) is in this
         */
        Map.Pair<String, String> getSong(int placement);

}
