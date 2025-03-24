package Dependances;


import java.net.InetSocketAddress;
import java.net.http.WebSocket;
import java.util.HashMap;
import java.util.Map;

public class ServeurReunion extends WebSocketServer {

    private Map<WebSocket, Personne> personne = new HashMap<>();
    private Map<String, Reunion> reunions = new HashMap<>();

    public ServeurReunion(int port) {
        super(new InetSocketAddress(port));
    }

    @Override
    public void onOpen(WebSocket conn, ClientHandshake handShake) {
        System.out.println("Nouvelle connexion : " + conn.getRemoteSocketAddress());
    }

    @Override
    public void onClose(WebSocket conn, int code, String reason, boolean remote) {
        System.out.println("Connexion fermée : " + conn.getRemoteSocketAddress());
        if (personne.containsKey(conn)) {
            Personne user = personne.get(conn);
            //deconnexion de l'utilisateur
            personne.remove(conn);
        }
    }

    @Override
    public void onMessage(WebSocket conn, String message){
        System.out.println("Message reçu : "+ message);
    }

    @Override
    public void onError(WebSocket conn, Exception ex){
        System.err.println("Erreur: " + ex.getMessage());
        if (conn != null) {
            personne.remove(conn);
        }
    }

    @Override
    public void onStart() {
        System.out.println("Serveur démarré sur le port: " + getPort());
    }

    public static void main(String[] args) {
        int port = 1056; // Port par défaut
        ServeurReunion server = new ServeurReunion(port);
        server.start();
        System.out.println("Serveur démarré sur le port: " + port);
    }
}
