package Dependances;

public class ReunionStandard extends Reunion{
    public ReunionStandard(String nom, String sujet, String dateDebut, int duree, String ordreJourTexte, Personne organisateur, Personne animateur) {
        super(nom, sujet, dateDebut, duree, ordreJourTexte, organisateur, animateur);
    }

    @Override
    public boolean demanderParole(Personne personne) {
        if(ouverte && participants.containsKey(personne)){
            participants.put(personne, true);
            return true;
        }
        return false;
    }

    @Override
    public Personne choisirProchainIntervenant() {
        // Dans une réunion standard, c'est l'animateur qui choisit manuellement
        // Cette méthode retourne null car la sélection est faite via une méthode séparée
        return null;
    }

    public boolean donnerParole(Personne animateur, Personne intervenant) {
        if (this.animateur.equals(animateur) && participants.containsKey(intervenant) && participants.get(intervenant)) {
            for (Personne p : participants.keySet()) {
                if (!p.equals(intervenant)) {
                    participants.put(p, false);
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean peutIntervenir(Personne personne) {
        // Une personne peut intervenir si elle a la parole
        return participants.get(personne);
    }

}
