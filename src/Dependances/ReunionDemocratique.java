package Dependances;

import java.util.LinkedList;
import java.util.Queue;

public class ReunionDemocratique extends Reunion {
    private Queue<Personne> fileAttente;
    private Personne intervenantActuel;

    public ReunionDemocratique(String nom, String sujet, String dateDebut, int duree, String ordreJourTexte, Personne orgaanisateur, Personne animateur) {
        super(nom, sujet, dateDebut, duree, ordreJourTexte, orgaanisateur, animateur);
        this.fileAttente = new LinkedList<>();
        this.intervenantActuel = null;
    }

    @Override
    public boolean demanderParole(Personne personne) {
        if (ouverte && participants.containsKey(personne) && !fileAttente.contains(personne) && intervenantActuel != personne) {
            fileAttente.add(personne);
            participants.put(personne, true);
            return true;
        }
        return false;
    }

    @Override
    public Personne choisirProchainIntervenant() {
        if(!fileAttente.isEmpty()){
            intervenantActuel = fileAttente.poll();
            return intervenantActuel;
        }
        return null;
    }

    @Override
    public boolean peutIntervenir(Personne personne){
        return personne.equals(intervenantActuel);
    }

    @Override
    public boolean ajouterIntervention(Personne personne, String texte){
        boolean result = super.ajouterIntervention(personne, texte);
        if(result){
            intervenantActuel = null;
//            Après une intervention on prend le suivant automatiquemmmennnnt
            choisirProchainIntervenant();
        }
        return result;
    }
}
