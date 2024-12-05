package org.example.qualiter;

public class PremiumDecorator implements IJouet {

    protected IJouet jouet;

    public PremiumDecorator(IJouet jouet) {
        this.jouet = jouet;
    }

    @Override
    public String afficherMatiere(){
        return jouet.afficherMatiere() + " version Premium";
    };
}
