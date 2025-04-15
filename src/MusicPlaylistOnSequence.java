import components.map.Map;
import components.map.Map1L;
import components.sequence.Sequence;
import components.sequence.Sequence1L;

/**
 * {@code MusicPlaylist} represented as a Sequence of Map.Pair with
 * implementations of primary methods.
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
    private Sequence<Map.Pair<String, String>> rep;

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
        Map<String, String> map = new Map1L<>();
        map.add(title, artist);
        this.rep.add(0, map.remove(title));
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
    public final void add(Map.Pair<String, String> song) {
        this.rep.add(this.rep.length(), song);
    }

    @Override
    public final Map.Pair<String, String> remove(String title) {
        boolean check = true;
        int i = 0;
        Map<String, String> songs = new Map1L<>();
        while (i < this.rep.length() && check) {
            if (this.rep.entry(i).key().equals(title)) {
                songs.add(this.rep.entry(i).key(), this.rep.entry(i).value());
                this.rep.remove(i);
                check = false;
            }
            i++;
        }
        return songs.removeAny();
    }

    @Override
    public final void clear() {
        this.rep.clear();
    }

    @Override
    public final boolean hasSong(Map.Pair<String, String> song) {
        boolean present = false;
        for (Map.Pair<String, String> s : this.rep) {
            if (s.key().equals(song.key()) && s.value().equals(song.value())) {
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
    public final Map.Pair<String, String> getSong(int placement) {
        return this.rep.entry(placement);
    }

}
