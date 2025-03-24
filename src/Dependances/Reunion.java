package Dependances;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Reunion {
    protected String nom;
    protected String sujet;
    protected String dateDebut;
    protected int duree;
    protected String ordreJourTexte;
    protected Personne organisateur;
    protected Personne animateur;
    protected boolean ouverte;
    protected Map<Personne, Boolean> participants;
    protected List<String> interventions;

    public Reunion(String nom, String sujet, String dateDebut, int duree, String ordreJourTexte, Personne organisateur, Personne animateur){
        this.nom = nom;
        this.sujet = sujet;
        this.dateDebut = dateDebut;
        this.duree = duree;
        this.ordreJourTexte = ordreJourTexte;
        this.organisateur = organisateur;
        this.animateur = animateur;
        this.ouverte = false;
        this.participants = new HashMap<>();
        this.interventions = new ArrayList<>();
    }

//    fonction de demande de parole
    public abstract boolean demanderParole(Personne personne);

//    fonction pour la file des intervenant
    public abstract Personne choisirProchainIntervenant();

//    ce qui suit la c'est pour tous les types de reunions

    public boolean peutRejoindre(Personne personne){
        return true;
    }

    public boolean peutIntervenir(Personne personne){
        return false;
    }



    public boolean ouvrirReunion(Personne personne){
        if(personne.equals(animateur) && !ouverte){
            this.ouverte = true;
            return true;
        }
        return false;
    }

    public boolean fermerReunion(Personne personne){
        if(personne.equals(animateur) &&  ouverte){
            this.ouverte = false;
            return true;
        }
        return false;
    }

    public boolean rejoindreReunion(Personne personne){
        if(ouverte && peutRejoindre(personne)){
            participants.put(personne, false);
            return true;
        }
        return false;
    }

    public boolean quitterReunion(Personne personne){
        if(participants.containsKey(personne)){
            participants.remove(personne);
            return true;
        }
        return false;
    }

    public boolean ajouterIntervention(Personne personne, String texte){
        if(participants.containsKey(personne) && peutIntervenir(personne)){
            interventions.add(personne.getLogin() + ": "+ texte);
//            apres avoir ecrit son message on lui coupe l'acces
            participants.put(personne, false);
            return true;
        }
        return false;
    }

    // Getters et setters
    public String getNom() {
        return nom;
    }

    public String getSujet() {
        return sujet;
    }

    public String getDateDebut() {
        return dateDebut;
    }

    public int getDuree() {
        return duree;
    }

    public String getOrdreJourTexte() {
        return ordreJourTexte;
    }

    public Personne getOrganisateur() {
        return organisateur;
    }

    public Personne getAnimateur() {
        return animateur;
    }

    public boolean isOuverte() {
        return ouverte;
    }

    public List<String> getInterventions() {
        return interventions;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public void setOrdreJourTexte(String ordreJourTexte) {
        this.ordreJourTexte = ordreJourTexte;
    }

    public void setAnimateur(Personne animateur) {
        this.animateur = animateur;
    }

    public Map<Personne, Boolean> getParticipants() {
        return participants;
    }
}
