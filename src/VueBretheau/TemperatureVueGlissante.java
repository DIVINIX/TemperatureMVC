package VueBretheau;

import ControleurBretheau.TemperatureControleur;
import ModeleBretheau.TemperatureModele;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Yann on 05/11/2015.
 * Yann Bretheau S3C
 */

public class TemperatureVueGlissante implements Observer, ChangeListener {
    protected TemperatureModele modele;
    protected TemperatureControleur controleur;

    // Attibuts de la fenetre
    private String nomFenetre;
    private JFrame maFenetre;

    // Attributs du slider
    private static final int MIN = -50;
    private static final int MAX = 50;
    private static final int INIT = 20;
    private JSlider monSlider  = new JSlider(JSlider.VERTICAL, MIN,MAX,INIT);
    Font font = new Font("Serif", Font.ITALIC, 15);

    // Constructeur
    public TemperatureVueGlissante (String nomFenetre,TemperatureModele modele ,TemperatureControleur controleur ,int x ,int y){
        this.nomFenetre = nomFenetre;
        this.modele = modele;
        this.controleur =controleur;

        /**
         * Création de la fenetre
         */

        // Création de la fenetre : le conteneur
        maFenetre = new JFrame(nomFenetre);
        // Ajout du nom en haut
        maFenetre.add(new JLabel(nomFenetre), BorderLayout.NORTH);

        // Création du slider : le composant
        monSlider.setFont(font);
        monSlider.setMajorTickSpacing(10);
        monSlider.setMinorTickSpacing(1);
        monSlider.setPaintTicks(true);
        monSlider.setPaintLabels(true);
        monSlider.setVisible(true);
        // Ajout d'un écouteur sur le slider
        monSlider.addChangeListener(this);

        // Ajout du composant au conteneur, donc ajout du slider dans la fenetre
        maFenetre.add(monSlider);

        // Définition de la taille et positionnement de la fenetre
        maFenetre.setSize (300 ,600);
        maFenetre.setLocation(x, y);

        // Options sur la fenetre
        maFenetre.setVisible(true);
        maFenetre.setDefaultCloseOperation(maFenetre.EXIT_ON_CLOSE); // Permet de fermer les trois fenetre en même temps
        // Ajout de la classe VueGlissante comme observateur de la classe Modele
        modele.addObserver(this);
    }

    // On modifie la température du slider car elle à été modifier dans le modele
    @Override
    public void update(Observable monSujet, Object o){
        monSlider.setValue((int)modele.getTemperatureCelsuis());
    }

    // On modifie la température du modele car on la modifié dans le slider
    @Override
    public void stateChanged(ChangeEvent e){
        modele.setTeperatureCelsuis((double)monSlider.getValue());
    }
}
