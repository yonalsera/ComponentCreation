import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Test MusicPlaylistOnSequence class.
 */
public abstract class MusicPlaylistOnSequenceTest {
    /**
     * Test no parameter constructor.
     */
    @Test
    public void testConstructorNoParam() {
        MusicPlaylist p1 = new MusicPlaylistOnSequence();
        MusicPlaylist p2 = new MusicPlaylistOnSequence();

        assertEquals(p2, p1);
    }

    /**
     * Test String paramter constructor.
     */
    @Test
    public void testConstructorStringParam() {
        MusicPlaylist p1 = new MusicPlaylistOnSequence("20cm", "TXT");
        MusicPlaylist p2 = new MusicPlaylistOnSequence("20cm", "TXT");

        assertEquals(p2, p1);
    }

    /**
     * Test String paramter constructor.
     */
    @Test
    public void testConstructorSongParam() {
        Song s1 = new Song("20cm", "TXT");

        MusicPlaylist p1 = new MusicPlaylistOnSequence(s1);
        MusicPlaylist p2 = new MusicPlaylistOnSequence(s1);

        assertEquals(p2, p1);
    }
    /**
     * Test newInstance method.
     */
    @Test
    public void testNewInstanceOnEmpty() {
        MusicPlaylist p1 = new MusicPlaylistOnSequence();
        MusicPlaylist p2 = p1.newInstance();

        assertEquals(p1, p2);
    }

    /**
     * Test newInstance on MusicPlaylist with elements.
     */
    @Test
    public void testNewInstanceWithElements() {
        MusicPlaylist p1 = new MusicPlaylistOnSequence("Tomorrow Never Came",
                "Lana Del Rey");
        MusicPlaylist p2 = new MusicPlaylistOnSequence();
        MusicPlaylist p3 = p1.newInstance();

        assertEquals(p2, p3);
    }

    /**
     * Test transferFrom method.
     */
    @Test
    public void testTransferFromOneElement() {
        MusicPlaylist p1 = new MusicPlaylistOnSequence();
        MusicPlaylist p2 = new MusicPlaylistOnSequence("Tomorrow Never Came",
                "Lana Del Rey");
        MusicPlaylist p3 = new MusicPlaylistOnSequence();
        MusicPlaylist p4 = new MusicPlaylistOnSequence("Tomorrow Never Came",
                "Lana Del Rey");

        p1.transferFrom(p2);

        assertEquals(p4, p1);
        assertEquals(p3, p2);
    }

    /**
     * Test transferFrom method.
     */
    @Test
    public void testTransferFromMultiElement() {
        MusicPlaylist p1 = new MusicPlaylistOnSequence();
        MusicPlaylist p2 = new MusicPlaylistOnSequence("Tomorrow Never Came",
                "Lana Del Rey");
        MusicPlaylist p3 = new MusicPlaylistOnSequence();
        MusicPlaylist p4 = new MusicPlaylistOnSequence("Tomorrow Never Came",
                "Lana Del Rey");
        Song s = new Song("20cm", "TXT");

        p2.add(s);
        p4.add(s);
        p1.transferFrom(p2);

        assertEquals(p4, p1);
        assertEquals(p3, p2);
    }

    /**
     * Test for clear method with one element.
     */
    public void testClearOneElement() {
        MusicPlaylist p1 = new MusicPlaylistOnSequence("Tomorrow Never Came",
                "Lana Del Rey");
        MusicPlaylist p2 = new MusicPlaylistOnSequence();

        p1.clear();

        assertEquals(p2, p1);
    }

    /**
     * Test for clear method with one element.
     */
    public void testClearMultiElement() {
        MusicPlaylist p1 = new MusicPlaylistOnSequence("Tomorrow Never Came",
                "Lana Del Rey");
        MusicPlaylist p2 = new MusicPlaylistOnSequence();

        Song s = new Song("20cm", "TXT");
        p1.add(s);

        p1.clear();

        assertEquals(p2, p1);
    }

    /**
     * Test add method when MusicPlaylist is empty.
     */
    @Test
    public void testAddOnEmpty() {
        MusicPlaylist p1 = new MusicPlaylistOnSequence();
        MusicPlaylist p2 = new MusicPlaylistOnSequence("Tomorrow Never Came",
                "Lana Del Rey");

        Song s = new Song("Tomorrow Never Came", "Lana Del Rey");

        p1.add(s);

        assertEquals(p2, p1);
    }

    /**
     * Test add method when MusicPlaylist is not empty.
     */
    @Test
    public void testAddOnNonEmpty() {
        MusicPlaylist p1 = new MusicPlaylistOnSequence("Tomorrow Never Came",
                "Lana Del Rey");
        MusicPlaylist p2 = new MusicPlaylistOnSequence("Tomorrow Never Came",
                "Lana Del Rey");

        Song s = new Song("20cm", "TXT");

        p1.add(s);
        p2.add(s);

        assertEquals(p2, p1);
    }

    /**
     * Test remove method when MusicPlaylist with one element.
     */
    @Test
    public void testRemoveToEmpty() {
        MusicPlaylist p1 = new MusicPlaylistOnSequence("Tomorrow Never Came",
                "Lana Del Rey");
        MusicPlaylist p2 = new MusicPlaylistOnSequence();

        Song s = new Song("Tomorrow Never Came", "Lana Del Rey");
        Song sRemoved = p1.remove("Tomorrow Never Came", "Lana Del Rey");

        assertEquals(s, sRemoved);
        assertEquals(p2, p1);
    }

    /**
     * Test hasSong method when song is in MusicPlaylist.
     */
    @Test
    public void testHasSongPresent() {
        MusicPlaylist p1 = new MusicPlaylistOnSequence();
        MusicPlaylist p2 = new MusicPlaylistOnSequence();

        Song s = new Song("Tomorrow Never Came", "Lana Del Rey");

        p1.add(s);
        p2.add(s);

        boolean check = p1.hasSong(s);

        assertEquals(true, check);
        assertEquals(p1, p2);
    }

    /**
     * Test hasSong method when song is not in MusicPlaylist and is empty.
     */
    @Test
    public void testHasSongNotPresentEmpty() {
        MusicPlaylist p1 = new MusicPlaylistOnSequence();
        MusicPlaylist p2 = new MusicPlaylistOnSequence();

        Song s = new Song("Tomorrow Never Came", "Lana Del Rey");

        boolean check = p1.hasSong(s);

        assertEquals(false, check);
        assertEquals(p1, p2);
    }

    /**
     * Test hasSong method when song is not in MusicPlaylist and is not empty.
     */
    @Test
    public void testHasSongNotPresentNotEmpty() {
        MusicPlaylist p1 = new MusicPlaylistOnSequence();
        MusicPlaylist p2 = new MusicPlaylistOnSequence();

        Song s1 = new Song("Tomorrow Never Came", "Lana Del Rey");
        Song s2 = new Song("20cm", "TXT");

        p1.add(s1);
        p2.add(s1);

        boolean check = p1.hasSong(s2);

        assertEquals(false, check);
        assertEquals(p1, p2);
    }

    /**
     * Test length method when MusicPlaylist is not empty.
     */
    @Test
    public void testLengthNonEmpty() {
        MusicPlaylist p1 = new MusicPlaylistOnSequence();
        MusicPlaylist p2 = new MusicPlaylistOnSequence();

        Song s = new Song("Tomorrow Never Came", "Lana Del Rey");

        p1.add(s);
        p2.add(s);

        int length = p1.length();

        assertEquals(1, length);
        assertEquals(p1, p2);
    }

    /**
     * Test length method when MusicPlaylist is empty.
     */
    @Test
    public void testLengthEmpty() {
        MusicPlaylist p1 = new MusicPlaylistOnSequence();
        MusicPlaylist p2 = new MusicPlaylistOnSequence();

        int length = p1.length();

        assertEquals(0, length);
        assertEquals(p1, p2);
    }

    /**
     * Test getSong method when accessing first song in MusicPlaylist.
     */
    @Test
    public void testgetSongFront() {
        MusicPlaylist p1 = new MusicPlaylistOnSequence();
        MusicPlaylist p2 = new MusicPlaylistOnSequence();

        Song s1 = new Song("Tomorrow Never Came", "Lana Del Rey");
        Song s2 = new Song("20cm", "TXT");
        Song s3 = new Song("ASAP", "STAYC");

        p1.add(s1);
        p1.add(s2);
        p1.add(s3);
        p2.add(s1);
        p2.add(s2);
        p2.add(s3);

        Song sResult = p1.getSong(0);

        assertEquals(s1, sResult);
        assertEquals(p1, p2);
    }

    /**
     * Test getSong when accessin last song in MusicPlaylist.
     */
    @Test
    public void testgetSongBack() {
        MusicPlaylist p1 = new MusicPlaylistOnSequence();
        MusicPlaylist p2 = new MusicPlaylistOnSequence();

        Song s1 = new Song("Tomorrow Never Came", "Lana Del Rey");
        Song s2 = new Song("20cm", "TXT");
        Song s3 = new Song("ASAP", "STAYC");

        p1.add(s1);
        p1.add(s2);
        p1.add(s3);
        p2.add(s1);
        p2.add(s2);
        p2.add(s3);

        Song sResult = p1.getSong(2);

        assertEquals(s1, sResult);
        assertEquals(p1, p2);
    }

    /**
     * Test getSong when accessing a middle song in MusicPlaylist.
     */
    @Test
    public void testgetSongMiddle() {
        MusicPlaylist p1 = new MusicPlaylistOnSequence();
        MusicPlaylist p2 = new MusicPlaylistOnSequence();

        Song s1 = new Song("Tomorrow Never Came", "Lana Del Rey");
        Song s2 = new Song("20cm", "TXT");
        Song s3 = new Song("ASAP", "STAYC");

        p1.add(s1);
        p1.add(s2);
        p1.add(s3);
        p2.add(s1);
        p2.add(s2);
        p2.add(s3);

        Song sResult = p1.getSong(1);

        assertEquals(s1, sResult);
        assertEquals(p1, p2);
    }
}
