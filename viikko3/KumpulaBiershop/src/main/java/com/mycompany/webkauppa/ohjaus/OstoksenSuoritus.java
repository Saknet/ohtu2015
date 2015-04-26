package com.mycompany.webkauppa.ohjaus;

import com.mycompany.webkauppa.sovelluslogiikka.*;
import com.mycompany.webkauppa.ulkoiset_rajapinnat.*;

public class OstoksenSuoritus implements Komento{

    private PankkiFasaadi pankki;
    private ToimitusjarjestelmaFasaadi toimitus;
    private String asiakkaanNimi;
    private String postitusosoite;
    private String luottokortti;
    private Ostoskori ostoskori;
    private Varasto varasto;

    protected OstoksenSuoritus(PankkiFasaadi pankki, ToimitusjarjestelmaFasaadi toimitus, String nimi, String osoite, String luottokorttinumero, Ostoskori kori) {
        this.varasto = new Varasto();
        this.pankki = pankki;
        this.toimitus = toimitus;
        this.asiakkaanNimi = nimi;
        this.postitusosoite = osoite;
        this.luottokortti = luottokorttinumero;
        this.ostoskori = kori;
    }

    public boolean suorita(Varasto varasto) {
        if ( asiakkaanNimi.length()==0 || postitusosoite.length()==0 || ostoskori.tuotteitaKorissa()==0 )
            return false;
        
        if (!pankki.maksa(asiakkaanNimi, luottokortti, ostoskori.hinta())) {
            return false;
        }

        toimitus.kirjaatoimitus(asiakkaanNimi, postitusosoite, ostoskori.ostokset());
        ostoskori.tyhjenna();
        
        return true;
    }

    public void setPankki(PankkiFasaadi pankki) {
        this.pankki = pankki;
    }        
}
