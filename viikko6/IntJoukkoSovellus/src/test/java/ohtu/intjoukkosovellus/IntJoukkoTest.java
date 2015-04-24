package ohtu.intjoukkosovellus;

import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class IntJoukkoTest {

    IntJoukko joukko;
    IntJoukko joukko2;
    IntJoukko joukko3;

    @Before
    public void setUp() {
        joukko = new IntJoukko();
        joukko.lisaa(10);
        joukko.lisaa(3);
        joukko2 = new IntJoukko();
        joukko2.lisaa(10);
        joukko2.lisaa(1);
        joukko2.lisaa(2);
        joukko3 = new IntJoukko();
        joukko3.lisaa(1);
        joukko3.lisaa(2);
    }

    @Test
    public void lukujaLisattyMaara() {
        joukko.lisaa(4);
        assertEquals(3, joukko.mahtavuus());
    }

    @Test
    public void samaLukuMeneeJoukkoonVaanKerran() {
        joukko.lisaa(10);
        joukko.lisaa(3);
        assertEquals(2, joukko.mahtavuus());
    }

    @Test
    public void vainLisatytLuvutLoytyvat() {
        assertTrue(joukko.kuuluu(10));
        assertFalse(joukko.kuuluu(5));
        assertTrue(joukko.kuuluu(3));
    }

    @Test
    public void poistettuEiOleEnaaJoukossa() {
        joukko.poista(3);
        assertFalse(joukko.kuuluu(3));
        assertEquals(1, joukko.mahtavuus());
    }
    
    @Test
    public void palautetaanOikeaTaulukko() {
        int[] odotettu = {3, 55, 99};
        
        joukko.lisaa(55);
        joukko.poista(10);
        joukko.lisaa(99);

        int[] vastaus = joukko.toIntArray();
        Arrays.sort(vastaus);
        assertArrayEquals(odotettu, vastaus);
    }
    
    
    @Test
    public void toimiiKasvatuksenJalkeen(){
        int[] lisattavat = {1,2,4,5,6,7,8,9,11,12,13,14};
        for (int luku : lisattavat) {
            joukko.lisaa(luku);
        }
        assertEquals(14, joukko.mahtavuus());
        assertTrue(joukko.kuuluu(11));
        joukko.poista(11);
        assertFalse(joukko.kuuluu(11));
        assertEquals(13, joukko.mahtavuus());
    }
    
    @Test
    public void toStringToimii(){
        assertEquals("{10, 3}", joukko.toString());
    }
    
    @Test
    public void erotusToimii() {
        IntJoukko joukko4 = IntJoukko.erotus(joukko2, joukko3);
        assertTrue(joukko4.kuuluu(10));
        assertFalse(joukko4.kuuluu(1));
        assertFalse(joukko4.kuuluu(2));
        assertEquals(1, joukko4.mahtavuus());
    }
    
    @Test
    public void leikkausToimii() {
        IntJoukko joukko4 = IntJoukko.leikkaus(joukko2, joukko3);
        assertTrue(joukko4.kuuluu(1));
        assertTrue(joukko4.kuuluu(2));
        assertFalse(joukko4.kuuluu(10));
        assertEquals(2, joukko4.mahtavuus());
    }
    
    @Test
    public void testaaLuonti() {
        try {
            IntJoukko joukko3 = new IntJoukko(-1);
            assertTrue(false);
        } catch (IndexOutOfBoundsException e) {
            
        }
        try {
            IntJoukko joukko3 = new IntJoukko(1, -1);
            assertTrue(false);
        } catch (IndexOutOfBoundsException e) {
            
        }
                
    }
}
