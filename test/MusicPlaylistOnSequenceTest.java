import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.map.Map;
import components.map.Map.Pair;
import components.map.Map1L;

public abstract class MusicPlaylistOnSequenceTest {

    @Test
    public void testAddOnEmpty() {
        MusicPlaylist p1 = new MusicPlaylistOnSequence();
        MusicPlaylist p2 = new MusicPlaylistOnSequence("Tomorrow Never Came",
                "Lana Del Rey");

        Map<String, String> map = new Map1L<>();
        map.add("Tomorrow Never Came", "Lana Del Rey");
        Pair<String, String> pair = map.removeAny();

        p1.add(pair);

        assertEquals(p2, p1);
    }

    @Test
    public void testRemoveToEmpty() {
        MusicPlaylist p1 = new MusicPlaylistOnSequence("Tomorrow Never Came",
                "Lana Del Rey");
        MusicPlaylist p2 = new MusicPlaylistOnSequence();

        Map<String, String> map = new Map1L<>();
        map.add("Tomorrow Never Came", "Lana Del Rey");
        Pair<String, String> pair = map.removeAny();
        Pair<String, String> pairRemoved = p1.remove("Tomorrow Never Came");

        assertEquals(pair, pairRemoved);
        assertEquals(p2, p1);
    }

    @Test
    public void testHasSongPresent() {
        MusicPlaylist p1 = new MusicPlaylistOnSequence();
        MusicPlaylist p2 = new MusicPlaylistOnSequence();

        Map<String, String> map = new Map1L<>();
        map.add("Tomorrow Never Came", "Lana Del Rey");
        Pair<String, String> pair = map.removeAny();

        p1.add(pair);
        p2.add(pair);

        boolean check = p1.hasSong(pair);

        assertEquals(true, check);
        assertEquals(p1, p2);
    }

    @Test
    public void testHasSongNotPresentEmpty() {
        MusicPlaylist p1 = new MusicPlaylistOnSequence();
        MusicPlaylist p2 = new MusicPlaylistOnSequence();

        Map<String, String> map = new Map1L<>();
        map.add("Tomorrow Never Came", "Lana Del Rey");
        Pair<String, String> pair = map.removeAny();

        boolean check = p1.hasSong(pair);

        assertEquals(true, check);
        assertEquals(p1, p2);
    }

    @Test
    public void testHasSongNotPresentNotEmpty() {
        MusicPlaylist p1 = new MusicPlaylistOnSequence();
        MusicPlaylist p2 = new MusicPlaylistOnSequence();

        Map<String, String> map = new Map1L<>();
        map.add("Tomorrow Never Came", "Lana Del Rey");
        map.add("20cm", "TXT");
        Pair<String, String> pair1 = map.remove("Tomorrow Never Came");
        Pair<String, String> pair2 = map.remove("20cm");

        p1.add(pair1);
        p2.add(pair2);

        boolean check = p1.hasSong(pair2);

        assertEquals(false, check);
        assertEquals(p1, p2);
    }

    @Test
    public void testLengthNonEmpty() {
        MusicPlaylist p1 = new MusicPlaylistOnSequence();
        MusicPlaylist p2 = new MusicPlaylistOnSequence();

        Map<String, String> map = new Map1L<>();
        map.add("Tomorrow Never Came", "Lana Del Rey");
        Pair<String, String> pair = map.removeAny();

        p1.add(pair);
        p2.add(pair);

        int length = p1.length();

        assertEquals(1, length);
        assertEquals(p1, p2);
    }

    @Test
    public void testLengthEmpty() {
        MusicPlaylist p1 = new MusicPlaylistOnSequence();
        MusicPlaylist p2 = new MusicPlaylistOnSequence();

        int length = p1.length();

        assertEquals(0, length);
        assertEquals(p1, p2);
    }

    @Test
    public void testgetSongFront() {
        MusicPlaylist p1 = new MusicPlaylistOnSequence();
        MusicPlaylist p2 = new MusicPlaylistOnSequence();

        Map<String, String> map = new Map1L<>();
        map.add("Tomorrow Never Came", "Lana Del Rey");
        map.add("20cm", "TXT");
        map.add("ASAP", "STAYC");
        Pair<String, String> pair1 = map.remove("Tomorrow Never Came");
        Pair<String, String> pair2 = map.remove("20cm");
        Pair<String, String> pair3 = map.remove("ASAP");

        p1.add(pair1);
        p1.add(pair2);
        p1.add(pair3);
        p2.add(pair1);
        p2.add(pair2);
        p2.add(pair3);

        Pair<String, String> pairResult = p1.getSong(0);

        assertEquals(pair1, pairResult);
        assertEquals(p1, p2);
    }

    @Test
    public void testgetSongBack() {
        MusicPlaylist p1 = new MusicPlaylistOnSequence();
        MusicPlaylist p2 = new MusicPlaylistOnSequence();

        Map<String, String> map = new Map1L<>();
        map.add("Tomorrow Never Came", "Lana Del Rey");
        map.add("20cm", "TXT");
        map.add("ASAP", "STAYC");
        Pair<String, String> pair1 = map.remove("Tomorrow Never Came");
        Pair<String, String> pair2 = map.remove("20cm");
        Pair<String, String> pair3 = map.remove("ASAP");

        p1.add(pair1);
        p1.add(pair2);
        p1.add(pair3);
        p2.add(pair1);
        p2.add(pair2);
        p2.add(pair3);

        Pair<String, String> pairResult = p1.getSong(2);

        assertEquals(pair1, pairResult);
        assertEquals(p1, p2);
    }

    @Test
    public void testgetSongMiddle() {
        MusicPlaylist p1 = new MusicPlaylistOnSequence();
        MusicPlaylist p2 = new MusicPlaylistOnSequence();

        Map<String, String> map = new Map1L<>();
        map.add("Tomorrow Never Came", "Lana Del Rey");
        map.add("20cm", "TXT");
        map.add("ASAP", "STAYC");
        Pair<String, String> pair1 = map.remove("Tomorrow Never Came");
        Pair<String, String> pair2 = map.remove("20cm");
        Pair<String, String> pair3 = map.remove("ASAP");

        p1.add(pair1);
        p1.add(pair2);
        p1.add(pair3);
        p2.add(pair1);
        p2.add(pair2);
        p2.add(pair3);

        Pair<String, String> pairResult = p1.getSong(1);

        assertEquals(pair1, pairResult);
        assertEquals(p1, p2);
    }
}
