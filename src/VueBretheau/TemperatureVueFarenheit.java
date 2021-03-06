package VueBretheau;

import ControleurBretheau.TemperatureControleur;
import ModeleBretheau.TemperatureModele;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

/**
 * Created by Yann on 05/11/2015.
 * Yann Bretheau S3C
 */

public class TemperatureVueFarenheit extends TemperatureVue {
    public TemperatureVueFarenheit(TemperatureModele modele, TemperatureControleur controleur, int x, int y){

        // Appel au constructeur de TempératureVue
        super("Temperature Farenheit",modele,controleur,x,y);

        // On affecte la température en Farenheit a la température que l'on affiche
        setTemperatureAffiche("" + modele.getTemperatureFarenheit());

        // Redéfinition de la méthode ajoutListenerBoutonAugmenter de la classe TempératureVue
        ajoutListenerBoutonAugmenter(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controleur.augmentertemperatureFarenheint();
            }
        });

        // Redéfinition de la méthodes ajoutListenerBoutonDiminuer de la classe TempératureVue
        ajoutListenerBoutonDiminuer(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controleur.diminuerTemperatureFarenheit();
            }
        });
    }

    // En retour à la notification de son sujet avec setChanged() et notifyObservers() on met à jour la vue
    // On modifie la température affichée car elle à été modifier dans le modele
    public void update(Observable monSujet, Object o){
        setTemperatureAffiche("" + modele.getTemperatureFarenheit());
    }
}
