package ohtuesimerkki;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class StatisticsTest {

    Statistics stats;
    Reader readerStub = new Reader() {

        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<Player>();

            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));

            return players;
        }
    };
    
    public StatisticsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.stats = new Statistics(readerStub);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void searchTest() {
        assertEquals("Semenko", stats.search("Semenko").getName());
        assertEquals(null, stats.search("test"));
    }
    
    @Test
    public void teamTest() {
        assertEquals("Semenko", stats.team("EDM").get(0).getName());
        assertEquals(0, stats.team("test").size());
    }
    
    @Test
    public void topScorersTest() {
        assertEquals(124, stats.topScorers(3).get(0).getPoints());
        assertEquals(4, stats.topScorers(3).size());
    }
}
