package com.mycompany.ohmawebkauppa.sovelluslogiikka.ohjaus;

import com.mycompany.webkauppa.ohjaus.Komentotehdas;
import com.mycompany.webkauppa.sovelluslogiikka.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class OstoksenLisaysKoriinTest {
    Varasto varasto;
    Ostoskori kori;    
    long tuoteid = 1;
    Tuote tuote;
    Komentotehdas komentotehdas;
    
    @Before
    public void setUp() {
        varasto = new Varasto();
        tuote = varasto.etsiTuote(tuoteid);     
        if ( tuote.getSaldo()==0 ) {
            tuote.setSaldo(1);
        } 
        kori = new Ostoskori(); 
        komentotehdas = new Komentotehdas();
    }
    
    @Test
    public void koriSisaltaaLisatynTuotteen() {
        komentotehdas.ostoksenLisaysKoriin(kori, tuoteid).suorita(varasto);
    
        assertEquals(1, kori.tuotteitaKorissa());
        assertEquals(tuote.getHinta(), kori.hinta());
        assertEquals(tuote.getNimi(), kori.ostokset().get(0).tuotteenNimi());
    }
    
    @Test
    public void tuotteenMaaraVahentyy(){
        int varastossaAluksi = varasto.etsiTuote(tuoteid).getSaldo();
        komentotehdas.ostoksenLisaysKoriin(kori, tuoteid).suorita(varasto);
    
        assertEquals(varastossaAluksi-1, varasto.etsiTuote(tuoteid).getSaldo());
    }
    
    @Test
    public void josTuotteenVarastosaldoNollaEiTuotettaLaitetaOstoskoriin() {
        varasto.etsiTuote(tuoteid).setSaldo(0);
        komentotehdas.ostoksenLisaysKoriin(kori, tuoteid).suorita(varasto);
    
        assertEquals(0, kori.tuotteitaKorissa());
        assertEquals(0, kori.hinta());
        assertEquals(0, kori.ostokset().size() );
    }
}
