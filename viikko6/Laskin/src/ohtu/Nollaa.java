
package ohtu;

import javax.swing.JTextField;

public class Nollaa extends Komento {

    public Nollaa(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta) {
        super(sovellus, tuloskentta, syotekentta);
    }
    
    @Override
    public void suorita() {
        sovellus.nollaa();
        super.suorita();
    }
    
}
