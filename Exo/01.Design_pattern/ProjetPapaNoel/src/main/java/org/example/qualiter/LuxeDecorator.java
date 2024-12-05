package org.example.qualiter;

public class LuxeDecorator extends JouetDecorator{
    public LuxeDecorator(IJouet jouet) {
        super(jouet);
    }

    public String afficherMatiere(){
        return jouet.afficherMatiere() + " version de luxe";
    };
}
