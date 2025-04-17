import components.sequence.Sequence;
import components.sequence.Sequence1L;

/**
 * {@code MusicPlaylist} represented as a Sequence of Song with implementations
 * of primary methods.
 *
 * @convention |this.rep| >= 0 & !this.contains(null)
 * @correspondence this = $this.rep
 */
public class MusicPlaylistOnSequence extends MusicPlaylistSecondary {

    /*
     * Private members --------------------------------------------------------
     */

    /**
     * Representation of {@code this}.
     */
    private Sequence<Song> rep;

    /**
     * Creator of initial representation.
     */
    private void createNewRep() {
        this.rep = new Sequence1L<>();
    }

    /*
     * Constructors -----------------------------------------------------------
     */

    /**
     * No-argument constructor.
     */
    public MusicPlaylistOnSequence() {
        this.createNewRep();
    }

    /**
     * Constructor from two {@code String}.
     *
     * @param title
     *            {@code String} to initialize pair with song name
     * @param artist
     *            {@code String} to initialize pair with artist
     */
    public MusicPlaylistOnSequence(String title, String artist) {
        this.createNewRep();
        Song s = new Song(title, artist);
        this.rep.add(0, s);
    }

    /**
     * Constructor from two {@code String}.
     *
     * @param s
     *            {@code Song} to initialize pair with Song object
     */
    public MusicPlaylistOnSequence(Song s) {
        this.createNewRep();
        this.rep.add(0, s);
    }

    /*
     * Standard methods -------------------------------------------------------
     */

    @Override
    public final MusicPlaylist newInstance() {
        try {
            return this.getClass().getConstructor().newInstance();
        } catch (ReflectiveOperationException e) {
            throw new AssertionError(
                    "Cannot construct object of type " + this.getClass());
        }
    }

    @Override
    public final void transferFrom(MusicPlaylist source) {
        assert source != null : "Violation of: source is not null";
        assert source != this : "Violation of: source is not this";
        assert source instanceof MusicPlaylistOnSequence : ""
                + "Violation of: source is of dynamic type MusicPlaylistOnSequence";
        /*
         * This cast cannot fail since the assert above would have stopped
         * execution in that case.
         */
        MusicPlaylistOnSequence localSource = (MusicPlaylistOnSequence) source;
        this.rep = localSource.rep;
        localSource.createNewRep();
    }

    /*
     * Kernel methods ---------------------------------------------------------
     */

    @Override
    public final void add(Song song) {
        this.rep.add(0, song);
    }

    @Override
    public final Song remove(String title, String artist) {
        Song removeS = new Song("", "");
        for (int i = 0; i < this.rep.length(); i++) {
            Song s = this.rep.entry(i);
            if (s.title().equals(title) && s.artist().equals(artist)) {
                s = this.rep.remove(i);
            }
        }
        return removeS;
    }

    @Override
    public final void clear() {
        this.rep.clear();
    }

    @Override
    public final boolean hasSong(Song song) {
        boolean present = false;
        for (Song s : this.rep) {
            if (s.artist().equals(song.artist())
                    && s.title().equals(song.title())) {
                present = true;
            }
        }
        return present;
    }

    @Override
    public final int length() {
        return this.rep.length();
    }

    @Override
    public final Song getSong(int placement) {
        return this.rep.entry(placement);
    }

}
