
package com.mycompany.webkauppa.ohjaus;

import com.mycompany.webkauppa.sovelluslogiikka.Ostoskori;
import com.mycompany.webkauppa.ulkoiset_rajapinnat.PankkiFasaadi;

public class Komentotehdas {
    
    public Komento ostoksenLisaysKoriin(Ostoskori ostoskori, long tuoteId) {
        return new OstoksenLisaysKoriin(ostoskori, tuoteId);
    }
    
    public Komento ostoksenPoistoKorista(Ostoskori ostoskori, long tuoteId) {
        return new OstoksenPoistoKorista(ostoskori, tuoteId);
    }
    
    public Komento ostoksenSuoritus(String nimi, String osoite, String luottokorttinumero, Ostoskori kori) {
        return new OstoksenSuoritus(nimi, osoite, luottokorttinumero, kori);
    }
    
    public Komento ostoksenSuoritus(String nimi, String osoite, String luottokorttinumero, Ostoskori kori, PankkiFasaadi pankki) {
        OstoksenSuoritus ostoksenSuoritus = new OstoksenSuoritus(nimi, osoite, luottokorttinumero, kori);
        ostoksenSuoritus.setPankki(pankki);
        return ostoksenSuoritus;
    }
}
