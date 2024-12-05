package org.example.qualiter;

public abstract class JouetDecorator implements IJouet {

    protected IJouet jouet;

    public JouetDecorator(IJouet jouet) {
        this.jouet = jouet;
    }

    @Override
    public String afficherMatiere(){
       return jouet.afficherMatiere();
    };
}
