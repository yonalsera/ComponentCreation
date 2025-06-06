import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

/**
 * Test MusicPlaylistSecondary class.
 */
public abstract class MusicPlaylistSecondaryTest {
        /**
         * Test toString for no elements.
         */
        @Test
        public void testToStringEmpty() {
                MusicPlaylist p1 = new MusicPlaylistOnSequence();
                MusicPlaylist p2 = new MusicPlaylistOnSequence();

                String str = p1.toString();
                String strExpected = "";

                assertEquals(strExpected, str);
                assertEquals(p2, p1);
        }

        /**
         * Test toString for one element.
         */
        @Test
        public void testToStringOneElement() {
                MusicPlaylist p1 = new MusicPlaylistOnSequence("20cm", "TXT");
                MusicPlaylist p2 = new MusicPlaylistOnSequence("20cm", "TXT");

                String str = p1.toString();
                String strExpected = "[title=20cm, artist=TXT]\n";

                assertEquals(strExpected, str);
                assertEquals(p2, p1);
        }

        /**
         * Test toString for multiple elements.
         */
        @Test
        public void testToStringMultiElements() {
                MusicPlaylist p1 = new MusicPlaylistOnSequence("20cm", "TXT");
                MusicPlaylist p2 = new MusicPlaylistOnSequence("20cm", "TXT");

                Song s = new Song("Tomorrow Never Came", "Lana Del Rey");
                p1.add(s);
                p2.add(s);

                String str = p1.toString();
                String strExpected = "[title=20cm, artist=TXT]\n[title=Tomorrow Never Came, artist=Lana Del Rey]\n";

                assertEquals(strExpected, str);
                assertEquals(p2, p1);
        }

        /**
         * Test equals when objects are empty.
         */
        @Test
        public void testEqualsOnEmpty() {
                MusicPlaylist p1 = new MusicPlaylistOnSequence();
                MusicPlaylist p2 = new MusicPlaylistOnSequence();

                boolean result = p1.equals(p2);

                assertEquals(true, result);
                assertEquals(p2, p1);
        }

        /**
         * Test equals when objects are empty.
         */
        @Test
        public void testEqualsOneElement() {
                MusicPlaylist p1 = new MusicPlaylistOnSequence(
                                "Tomorrow Never Came", "Lana Del Rey");
                MusicPlaylist p2 = new MusicPlaylistOnSequence(
                                "Tomorrow Never Came", "Lana Del Rey");

                boolean result = p1.equals(p2);

                assertEquals(true, result);
                assertEquals(p2, p1);
        }

        /**
         * Test equals when objects are empty.
         */
        @Test
        public void testEqualsMultiElement() {
                MusicPlaylist p1 = new MusicPlaylistOnSequence(
                                "Tomorrow Never Came", "Lana Del Rey");
                MusicPlaylist p2 = new MusicPlaylistOnSequence(
                                "Tomorrow Never Came", "Lana Del Rey");

                Song s = new Song("Tell Me", "FIFTY FIFTY");
                p1.add(s);
                p2.add(s);

                boolean result = p1.equals(p2);

                assertEquals(true, result);
                assertEquals(p2, p1);
        }

        /**
         * Test merge method when MusicPlaylist is empty.
         */
        @Test
        public void testMergeIntoEmpty() {
                MusicPlaylist p1 = new MusicPlaylistOnSequence();
                MusicPlaylist p2 = new MusicPlaylistOnSequence(
                                "Tomorrow Never Came", "Lana Del Rey");
                MusicPlaylist pExpected = new MusicPlaylistOnSequence(
                                "Tomorrow Never Came", "Lana Del Rey");

                p1.merge(p2);

                assertEquals(pExpected, p1);
        }

        /**
         * Test merge method when MusicPlaylist is not empty.
         */
        @Test
        public void testMergeIntoNonEmpty() {
                MusicPlaylist p1 = new MusicPlaylistOnSequence(
                                "Tomorrow Never Came", "Lana Del Rey");
                MusicPlaylist p2 = new MusicPlaylistOnSequence("20cm", "TXT");
                MusicPlaylist pExpected = new MusicPlaylistOnSequence(
                                "Tomorrow Never Came", "Lana Del Rey");

                Song s = new Song("20cm", "TXT");
                pExpected.add(s);

                p1.merge(p2);

                assertEquals(pExpected, p1);
        }

        /**
         * Test isEmpty method when MusicPlaylist is empty.
         */
        @Test
        public void testIsEmptyEmpty() {
                MusicPlaylist p1 = new MusicPlaylistOnSequence();
                MusicPlaylist p2 = new MusicPlaylistOnSequence();

                boolean result = p1.isEmpty();

                assertEquals(true, result);
                assertEquals(p2, p1);
        }

        /**
         * Test isEmpty method when MusicPlaylist is not empty.
         */
        @Test
        public void testIsEmptyNonEmpty() {
                MusicPlaylist p1 = new MusicPlaylistOnSequence(
                                "Tomorrow Never Came", "Lana Del Rey");
                MusicPlaylist p2 = new MusicPlaylistOnSequence(
                                "Tomorrow Never Came", "Lana Del Rey");

                boolean result = p1.isEmpty();

                assertEquals(false, result);
                assertEquals(p2, p1);
        }

        /**
         * Test getArtist when there is one match and one element in
         * MusicPlaylist.
         */
        @Test
        public void testGetArtistOneMatchOneElement() {
                MusicPlaylist p1 = new MusicPlaylistOnSequence(
                                "I Want You Around", "Snoh Aalegra");
                MusicPlaylist p2 = new MusicPlaylistOnSequence(
                                "I Want You Around", "Snoh Aalegra");

                String[] res = p1.getArtist("I Want You Around");
                String[] resExpected = { "Snoh Aalegra" };

                assertArrayEquals(resExpected, res);
                assertEquals(p2, p1);
        }

        /**
         * Test getArtist when there is one match and multiple elements in
         * MusicPlaylist.
         */
        @Test
        public void testGetArtistOneMatchMultiElement() {
                MusicPlaylist p1 = new MusicPlaylistOnSequence(
                                "I Want You Around", "Snoh Aalegra");
                MusicPlaylist p2 = new MusicPlaylistOnSequence(
                                "I Want You Around", "Snoh Aalegra");

                Song s = new Song("Tell Me", "FIFTY FIFTY");
                p1.add(s);
                p2.add(s);

                String[] res = p1.getArtist("I Want You Around");
                String[] resExpected = { "Snoh Aalegra" };

                assertArrayEquals(resExpected, res);
                assertEquals(p2, p1);
        }

        /**
         * Test getArtist when there is multiple matches.
         */
        @Test
        public void testGetArtistMultiMatchMultiElement() {
                MusicPlaylist p1 = new MusicPlaylistOnSequence(
                                "Fairy of Shampoo", "TXT");
                MusicPlaylist p2 = new MusicPlaylistOnSequence(
                                "Fairy of Shampoo", "TXT");

                Song s = new Song("Fairy of Shampoo", "dosii");
                p1.add(s);
                p2.add(s);

                String[] res = p1.getArtist("Fairy of Shampoo");
                String[] resExpected = { "TXT", "dosii" };

                assertArrayEquals(resExpected, res);
                assertEquals(p2, p1);
        }

        /**
         * Test getSong method when there is one match and one element in
         * MusicPlaylist.
         */
        @Test
        public void testGetSongsOneMatchOneElement() {
                MusicPlaylist p1 = new MusicPlaylistOnSequence(
                                "I Want You Around", "Snoh Aalegra");
                MusicPlaylist p2 = new MusicPlaylistOnSequence(
                                "I Want You Around", "Snoh Aalegra");

                String[] res = p1.getSongs("Snoh Aalegra");
                String[] resExpected = { "I Want You Around" };

                assertArrayEquals(resExpected, res);
                assertEquals(p2, p1);
        }

        /**
         * Test getSong when there is one match and multiple elements in
         * MusicPlaylist.
         */
        @Test
        public void testGetSongsOneMatchMultiElement() {
                MusicPlaylist p1 = new MusicPlaylistOnSequence(
                                "I Want You Around", "Snoh Aalegra");
                MusicPlaylist p2 = new MusicPlaylistOnSequence(
                                "I Want You Around", "Snoh Aalegra");

                Song s = new Song("Tell Me", "FIFTY FIFTY");
                p1.add(s);
                p2.add(s);

                String[] res = p1.getArtist("Snoh Aalegra");
                String[] resExpected = { "I Want You Around" };

                assertArrayEquals(resExpected, res);
                assertEquals(p2, p1);
        }

        /**
         * Test getSong method when there is multiple matches.
         */
        @Test
        public void testGetSongsMultiMatchMultiElement() {
                MusicPlaylist p1 = new MusicPlaylistOnSequence("Cologne",
                                "beabadoobee");
                MusicPlaylist p2 = new MusicPlaylistOnSequence("Cologne",
                                "beabadoobee");

                Song s = new Song("You're here that's the thing",
                                "beabadoobee");
                p1.add(s);
                p2.add(s);

                String[] res = p1.getSongs("beabadoobee");
                String[] resExpected = { "Cologne",
                                "You're here that's the thing" };

                assertArrayEquals(resExpected, res);
                assertEquals(p2, p1);
        }

        /**
         * Test shuffle method when there is one element in MusicPlaylist.
         */
        @Test
        public void testShuffleOneElement() {
                MusicPlaylist p1 = new MusicPlaylistOnSequence("Cologne",
                                "beabadoobee");
                MusicPlaylist p2 = new MusicPlaylistOnSequence("Cologne",
                                "beabadoobee");

                p1.shuffle();

                assertEquals(p2, p1);
        }

        /**
         * Test shuffle method when there is one element in MusicPlaylist.
         */
        @Test
        public void testShuffleMultiElement() {
                MusicPlaylist p1 = new MusicPlaylistOnSequence("Cologne",
                                "beabadoobee");
                MusicPlaylist p2 = new MusicPlaylistOnSequence("Cologne",
                                "beabadoobee");

                Song s = new Song("You're here that's the thing",
                                "beabadoobee");
                p1.add(s);
                p2.add(s);

                p1.shuffle();

                assertNotEquals(p2, p1);
        }
}
