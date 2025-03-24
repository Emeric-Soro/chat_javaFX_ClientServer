package Dependances;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Personne {
    private String login;
    private String motDePasse;
    private boolean connecter;
    private List<Reunion> reunionsOrganisees;
    private List<Reunion> reunionsParticipees;

    public Personne() {
        this.login = "";
        this.motDePasse = "";
        this.connecter = false;
        this.reunionsOrganisees = new ArrayList<>();
        this.reunionsParticipees = new ArrayList<>();
    }

    public Personne(String login, String motDePasse) {
        this.login = login;
        this.motDePasse = motDePasse;
        this.connecter = false;
        this.reunionsOrganisees = new ArrayList<>();
        this.reunionsParticipees = new ArrayList<>();
    }

    public boolean authentifier(String motDePasse) {
        return this.motDePasse.equals(motDePasse);
    }

    public void ajouterReunionOrganisee(Reunion reunion) {
        reunionsOrganisees.add(reunion);
    }

    public void ajouterReunionParticipee(Reunion reunion) {
        reunionsParticipees.add(reunion);
    }

    public void retirerReunionParticipee(Reunion reunion) {
        reunionsParticipees.remove(reunion);
    }

    public String getLogin() {
        return login;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public boolean isConnecte() {
        return connecter;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public void setConnecte(boolean connecte) {
        this.connecter = connecte;
    }

    public List<Reunion> getReunionsOrganisees() {
        return reunionsOrganisees;
    }

    public List<Reunion> getReunionsParticipees() {
        return reunionsParticipees;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Personne personne = (Personne) o;
        return Objects.equals(login, personne.login);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login);
    }

}
