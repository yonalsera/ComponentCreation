/**
 * Use case class for MusicPlaylist creating a playlist of only one artist.
 */
public class LanaFan {
    /**
     * MusicPlaylist object.
     */
    private MusicPlaylist playlist;

    /**
     * Create playlist of a given song.
     *
     * @param song
     *            Song to be added
     */
    public LanaFan(Song song) {
        this.playlist = new MusicPlaylistOnSequence(song);
    }

    /**
     * Returns all Song sung by Lana Del Rey.
     *
     * @return {@code String[]} of all song titles of Lana Del Rey
     */
    public String[] getLanaSongs() {
        return this.playlist.getSongs("Lana Del Rey");
    }

    /**
     * Removes all songs that do not have Lana Del Rey as an artist.
     */
    public void removeNonLana() {
        for (int i = 0; i < this.playlist.length(); i++) {
            Song song = this.playlist.getSong(i);
            if (!song.artist().equals("Lana Del Rey")) {
                this.playlist.remove(song.title(), song.artist());
            }
        }
    }

}
