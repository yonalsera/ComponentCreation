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
         * Adds a second playlist to the end of the first one.
         *
         * @param p2
         *                playlist to be added to the end of the first playlist
         */
        void merge(MusicPlaylist p2);

        /**
         * Adds a singular song to the playlist, given as a Map.Pair.
         *
         * @param song
         *                Map.Pair<String, String> that will be added to
         *                playlist
         */
        void add(Map.Pair<String, String> song);

        /**
         * Removes a singular song from the playlist given the song title, and
         * returns the removed song as a Map.Pair.
         *
         * @param title
         *                the name of the song and key of the map pair
         * @return the map pair that was removed from the playlist
         */
        Map.Pair<String, String> remove(String title);

        /**
         * Removes all elements from playlist.
         */
        @Override
        void clear();

        /**
         * @param song
         *                song that is being searched for
         * @return boolean whether song is present or not
         */
        boolean hasSong(Map.Pair<String, String> song);

        /**
         *
         * @return number of songs in playlist
         */
        int length();

        /**
         * @param placement
         *                placement of song within the playlist
         * @return String of title of the song
         */
        String getTitle(int placement);

}
