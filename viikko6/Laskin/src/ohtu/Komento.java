
package ohtu;

import javax.swing.JTextField;

public class Komento {
    private JTextField tuloskentta;
    protected JTextField syotekentta;
    protected Sovelluslogiikka sovellus;
    protected int previousResult ;
    
    public Komento(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta) {
        this.sovellus = sovellus;
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
    }

    public void suorita() {
        saveResult();
        this.tuloskentta.setText("" + sovellus.tulos());
    }
    
    public int textToInt(String string) {
        int arvo = 0;
        try {
            arvo = Integer.parseInt(string);
        } catch (Exception e) {
        }
        return arvo;
    }
    
    public void saveResult() {
        this.previousResult = textToInt(tuloskentta.getText());
    }

    public void peru() {
        this.sovellus.setTulos(this.previousResult);
        this.tuloskentta.setText("" + sovellus.tulos());
    }
    
}
