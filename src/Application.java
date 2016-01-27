import ControleurBretheau.TemperatureControleur;
import ModeleBretheau.TemperatureModele;
import VueBretheau.TemperatureVueCelsuis;
import VueBretheau.TemperatureVueFarenheit;
import VueBretheau.TemperatureVueGlissante;

/**
 * Created by Yann on 05/11/2015.
 * Yann Bretheau S3C
 */
public class Application {
    // Constructeur
    public Application(){
        //Création du modele
        TemperatureModele modele = new TemperatureModele();

        // Création des controleurs, un pour chaque vue
        TemperatureControleur controleurVueCelsuis = new TemperatureControleur(modele);
        TemperatureControleur controleurVueFarenheit = new TemperatureControleur(modele);
        TemperatureControleur controleurVueGlissante = new TemperatureControleur(modele);

        // Création des vues
        TemperatureVueCelsuis vueCelsuis = new TemperatureVueCelsuis(modele, controleurVueCelsuis,600,200);
        TemperatureVueFarenheit vueFarenheit = new TemperatureVueFarenheit(modele,controleurVueFarenheit,600,400);
        TemperatureVueGlissante vueGlissante = new TemperatureVueGlissante("Temperature glissanre Celsuis", modele, controleurVueGlissante,900,200);
    }

    public static void main(String args[]){
        Application monApplication = new Application();
    }
}
