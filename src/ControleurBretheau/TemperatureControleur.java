package ControleurBretheau;

import ModeleBretheau.TemperatureModele;

/**
 * Created by Yann on 05/11/2015.
 * Yann Bretheau S3C
 */

public class TemperatureControleur {
    private TemperatureModele modele;

    // Constructeur
    public TemperatureControleur(TemperatureModele modele){
        this.modele = modele;
    }

    /**
     * Méthodes qui modifient la température. Elles utilisent les accesseurs du modele et elles sont utilisées
     * en réponse aux actions présentent dans les vues.
     *
     */

    // Augment la température Celsuis
    public void augmenterTemperatureCelsuis(){
        modele.setTeperatureCelsuis(modele.getTemperatureCelsuis() + 1.0);
    }

    // Diminue la température Celsuis
    public void diminuerTemperatureCelsuis(){
        modele.setTeperatureCelsuis(modele.getTemperatureCelsuis() - 1.0);
    }

    // Augment la température Farenheit
    public void augmentertemperatureFarenheint(){
        modele.setTemperatureFarenheit(modele.getTemperatureFarenheit() + 1.0);
    }

    // Diminue la température Celsuis
    public void diminuerTemperatureFarenheit(){
        modele.setTemperatureFarenheit(modele.getTemperatureFarenheit() - 1.0);
    }
}
