package Dependances;

import java.util.HashSet;
import java.util.Set;

public class ReunionPrivee extends ReunionStandard{
    private Set<Personne> personnesAutorisees;

    public ReunionPrivee(String nom, String sujet, String dateDebut, int duree, String ordreJourTexte, Personne organisateur, Personne animateur) {
        super(nom, sujet, dateDebut, duree, ordreJourTexte, organisateur, animateur);
        this.personnesAutorisees = new HashSet<>();
        // L'organisateur et l'animateur sont automatiquement autorisés
        personnesAutorisees.add(organisateur);
        personnesAutorisees.add(animateur);
    }

    public boolean ajouterPersonneAutorisee(Personne organisateur, Personne personne) {
        if (this.organisateur.equals(organisateur)) {
            personnesAutorisees.add(personne);
            return true;
        }
        return false;
    }

    public boolean retirerPersonneAutorisee(Personne organisateur, Personne personne) {
        if (this.organisateur.equals(organisateur) && !personne.equals(this.organisateur) && !personne.equals(this.animateur)) {
            personnesAutorisees.remove(personne);
            if (participants.containsKey(personne)) {
                participants.remove(personne);
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean peutRejoindre(Personne personne) {
        return personnesAutorisees.contains(personne);
    }
}
