/**
 * Use case class for MusicPlaylist, program that contains useful functions for
 * DJ's.
 */
public class DJ {

    /**
     * MusicPlaylist object.
     */
    private MusicPlaylist playlist;

    /**
     * Create DJ playlist.
     *
     * @param title
     *            title of a song
     * @param artist
     *            name of artist for the song
     * @param feat
     *            name of any featured artists
     */
    public DJ(String title, String artist, String feat) {
        String singer = artist + feat;
        this.playlist = new MusicPlaylistOnSequence(title, singer);
    }

    /**
     * Add songs to the playlist.
     * 
     * @param s
     *            song to be added
     */
    public void addSongs(Song s) {
        this.playlist.add(s);
    }

    /**
     * Creates a mix for the DJ.
     */
    public void djMix() {
        this.playlist.shuffle();
    }

    /**
     * Removes repeat songs.
     */
    public void noRepeats() {
        MusicPlaylist temp = this.playlist.newInstance();
        while (this.playlist.length() > 0) {
            temp.add(this.playlist.remove(this.playlist.getSong(0).title(),
                    this.playlist.getSong(0).artist()));
            for (int i = 0; i < this.playlist.length(); i++) {
                Song s1 = temp.getSong(temp.length() - 1);
                Song s2 = this.playlist.getSong(i);
                if (s1.title().equals(s2.title())
                        && s1.artist().equals(s2.artist())) {
                    this.playlist.remove(s2.title(), s2.artist());
                }
            }
        }
    }
}
