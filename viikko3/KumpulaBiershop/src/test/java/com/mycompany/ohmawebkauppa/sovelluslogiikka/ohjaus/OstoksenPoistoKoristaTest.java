package com.mycompany.ohmawebkauppa.sovelluslogiikka.ohjaus;

import com.mycompany.webkauppa.ohjaus.Komentotehdas;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import com.mycompany.webkauppa.sovelluslogiikka.*;

public class OstoksenPoistoKoristaTest {

    Varasto varasto = new Varasto();
    Ostoskori kori;
    long tuoteid = 1;
    Komentotehdas komentotehdas;

    @Before
    public void setUp() {
        Tuote tuote = varasto.etsiTuote(tuoteid);
        kori = new Ostoskori();
        kori.lisaaTuote(tuote);
        komentotehdas = new Komentotehdas();
    }

    @Test
    public void poistettuTuoteEiEnaaKorissa() {
        komentotehdas.ostoksenPoistoKorista(kori, tuoteid).suorita(varasto);
    
        assertEquals(0, kori.tuotteitaKorissa());
        assertEquals(0, kori.hinta());
        assertEquals(0, kori.ostokset().size());
    }
    
    @Test
    public void tuotteenMaaraKasvaa(){
        int varastossaAluksi = varasto.etsiTuote(tuoteid).getSaldo();
        komentotehdas.ostoksenPoistoKorista(kori, tuoteid).suorita(varasto);
    
        assertEquals(varastossaAluksi+1, varasto.etsiTuote(tuoteid).getSaldo());
    }

}
