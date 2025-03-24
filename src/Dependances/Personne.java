package Dependances;

public class Personne {
    private String login;
    private String motDePasse;
    private boolean connecter;

    public Personne(){
        this.login = "";
        this.motDePasse = "";
        this.connecter = false;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public String getLogin() {
        return login;
    }

    public void setConnecter(boolean connecter) {
        this.connecter = connecter;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }
}
