
package ohtu.intjoukkosovellus;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class IntJoukkuYksiparametrisellaKonstruktorillaTest extends IntJoukkoTest {
    
    @Before
    @Override
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
    
    // perii kaikki testit luokasta IntJoukkoTest
}
