
package ohtu.intjoukkosovellus;

public class IntJoukko {

    public final static int KAPASITEETTI = 5, // aloitustalukon koko
                            OLETUSKASVATUS = 5;  // luotava uusi taulukko on 
    // näin paljon isompi kuin vanha
    private int kasvatuskoko;     // Uusi taulukko on tämän verran vanhaa suurempi.
    private int[] alkiot;      // Joukon luvut säilytetään taulukon alkupäässä. 
    private int alkioidenLkm;    // Tyhjässä joukossa alkioiden_määrä on nolla. 

    public IntJoukko() {
        alkiot = new int[KAPASITEETTI];
        this.kasvatuskoko = OLETUSKASVATUS;
    }

    public IntJoukko(int kapasiteetti) {
        if (kapasiteetti < 0) {
            throw new IndexOutOfBoundsException("Kapasitteetti väärin");//heitin vaan jotain :D
        }
        alusta(kapasiteetti, OLETUSKASVATUS);
    }
    
    
    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        if (kapasiteetti < 0) {
            throw new IndexOutOfBoundsException("Kapasitteetti väärin");//heitin vaan jotain :D
        }
        if (kasvatuskoko < 0) {
            throw new IndexOutOfBoundsException("kapasiteetti2");//heitin vaan jotain :D
        }
        alusta(kapasiteetti, kasvatuskoko);
    }
    
    public void alusta(int kapasiteetti, int kasvatuskoko) {
        alkiot = new int[kapasiteetti];
        for (int i = 0; i < alkiot.length; i++) {
            alkiot[i] = 0;
        }
        alkioidenLkm = 0;
        this.kasvatuskoko = kasvatuskoko;        
    }

    public boolean lisaa(int luku) {
        if (!kuuluu(luku)) {
            lisaaTaulukkoon(luku);
            if (alkioidenLkm % alkiot.length == 0) {
                kasvataTaulukkoa();
            }
            return true;
        }
        return false;
    }
    
    public void lisaaTaulukkoon(int luku) {
        alkiot[alkioidenLkm] = luku;
        alkioidenLkm++;
    }
    
    public void kasvataTaulukkoa() {
        int[] kopio = new int[alkioidenLkm + kasvatuskoko];
        System.arraycopy(alkiot, 0, kopio, 0, alkiot.length);
        alkiot = kopio;
    }

    public boolean kuuluu(int luku) {
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == alkiot[i]) {
                return true;
            }
        }
        return false;
    }

    public boolean poista(int luku) {
        if (etsiIndeksi(luku) != -99) {
            alkiot[etsiIndeksi(luku)] = alkiot[alkioidenLkm - 1];
            alkioidenLkm--;
            return true;
        }
        return false;
    }
    
    public int etsiIndeksi(int luku) {
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == alkiot[i]) {
                return i;
            }
        }
        return -99;
    }
    
    public int mahtavuus() {
        return alkioidenLkm;
    }

    @Override
    public String toString() {
        String tuloste = "{";
        for (int i = 0; i < alkioidenLkm; i++) {
            tuloste += alkiot[i];
            if (alkioidenLkm - i > 1) {
                tuloste += ", ";
            }
        } 
        return tuloste + "}";
    }

    public int[] toIntArray() {
        int[] taulu = new int[alkioidenLkm];
        for (int i = 0; i < taulu.length; i++) {
            taulu[i] = alkiot[i];
        }
        return taulu;
    }  

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko u = new IntJoukko();
        lisaaAlkiot(u, a);
        lisaaAlkiot(u, b);
        return u;
    }
    
    public static void lisaaAlkiot(IntJoukko u, IntJoukko a) {
        for (int i = 0; i < a.mahtavuus(); i++) {
            u.lisaa(a.alkiot[i]);
        }
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko is = new IntJoukko();
        for (int i = 0; i < a.mahtavuus(); i++) {
            if (b.kuuluu(a.alkiot[i])) {
                is.lisaa(a.alkiot[i]);
            }
        }
        return is;
    }
    
    public static IntJoukko erotus (IntJoukko a, IntJoukko b) {
        for (int i = 0; i < b.mahtavuus(); i++) {
            a.poista(b.alkiot[i]);
        }
        return a;
    }
}