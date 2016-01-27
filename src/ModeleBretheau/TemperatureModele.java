package ModeleBretheau;

import java.util.Observable;
/**
 * Created by Yann on 05/11/2015.
 * Yann Bretheau S3C
 */

public class TemperatureModele extends Observable  {
    private double temperatureCelsuis = 20;

    /**
     * Accesseurs
     */

    // Accesseur de lecture pour la température en Celsuis
    public double getTemperatureCelsuis(){
        return temperatureCelsuis;
    }

    // Accesseur d'écriture pour la température en Celsuis
    // La méthode envoie une notification à son observateur avec setChanged() et notifyObserves()
    // pour lui signaler que la température a changé. Son observateur pourra ainsi appeller la méthode update
    // en réponse à cette notification ce qui modifiera la température afficher dans la vue.
    public void setTeperatureCelsuis(double tempC){
        temperatureCelsuis = tempC;
        setChanged();
        notifyObservers();
    }

    // Accesseur de lecture pour la température en Farenheit
    public double getTemperatureFarenheit(){
        return temperatureCelsuis*9.0/5.0+32.0;
    }

    // Accesseur d'écriture pour la température en Farenheit
    // La méthode envoie une notification à son observateur avec setChanged() et notifyObserves()
    // pour lui signaler que la température a changé. Son observateur pourra ainsi appeller la méthode update
    // en réponse à cette notification ce qui modifiera la température afficher dans la vue.
    public void setTemperatureFarenheit(double tempF){
        temperatureCelsuis = (tempF-32.0)*5.0/9.0;
        setChanged();
        notifyObservers();
    }
}
