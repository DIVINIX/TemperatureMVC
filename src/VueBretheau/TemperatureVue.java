package VueBretheau;

import ControleurBretheau.TemperatureControleur;
import ModeleBretheau.TemperatureModele;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Observer;

/**
 * Created by Yann on 05/11/2015.
 * Yann Bretheau S3C
 */

public abstract class TemperatureVue implements Observer {
    protected TemperatureModele modele;
    protected TemperatureControleur controleur;

    // Attibuts de la fenetre
    private String nomFenetre;
    private JFrame maFenetre;
    // Le texte qui affiche la température
    private JTextField temperatureAffiche = new JTextField();

    // Les boutons
    private JButton augmenterBouton = new JButton("+");
    private JButton diminuerBouton = new JButton("-");

    // Constructeur
    public TemperatureVue(String nomFenetre,TemperatureModele modele, TemperatureControleur controleur, int x, int y){
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
        // Ajout de l'affichage de la température
        maFenetre.add(temperatureAffiche,BorderLayout.CENTER);

        // Création des boutons :les composants
        JPanel mesBoutons = new JPanel();
        mesBoutons.add(augmenterBouton);
        mesBoutons.add(diminuerBouton);
        // Ajout des composants au conteneur, donc ajout des boutons dans la fenetre
        maFenetre.add(mesBoutons, BorderLayout.SOUTH);

        // Définition de la taille et positionnement de la fenetre
        maFenetre.setSize(300,200);
        maFenetre.setLocation(x,y);

        // Options sur la fenetre
        maFenetre.setDefaultCloseOperation(maFenetre.EXIT_ON_CLOSE); // Permet de fermer les trois fenetre en même temps
        maFenetre.setVisible(true);

        // Ajout de la classe Vue comme observateur de la classe Modele
        modele.addObserver(this);
    }

    // Accesseur d'écriture pour modifier la température afficher
    public void setTemperatureAffiche(String s){
        temperatureAffiche.setText(s);
    }

    // Ajout d'un écouteur sur le bouton augmenter pour capter ses actions
    public void ajoutListenerBoutonAugmenter(ActionListener action){
        augmenterBouton.addActionListener(action);
    }

    // Ajout d'un écouteur sur le bouton diminuer pour capter ses actions
    public void ajoutListenerBoutonDiminuer(ActionListener action){
        diminuerBouton.addActionListener(action);
    }
}
