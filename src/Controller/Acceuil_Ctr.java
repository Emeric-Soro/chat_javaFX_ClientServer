package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Acceuil_Ctr {

    public void handleLogout(ActionEvent actionEvent) {
        try {
            // Charger la vue de connexion
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vues/connexion.fxml"));
            Parent root = loader.load();

            // Obtenir la scène actuelle
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);

            // Changer de scène
            stage.setScene(scene);
            stage.setTitle("Connexion");
            stage.show();

            System.out.println("Déconnexion réussie, passage à la page de connexion.");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Erreur lors du chargement de la page de connexion.");
        }
    }

    public void handleLogin(ActionEvent actionEvent) {
        try {
            // Charger la vue de connexion
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vues/connexion.fxml"));
            Parent root = loader.load();

            // Obtenir la scène actuelle
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);

            // Changer de scène
            stage.setScene(scene);
            stage.setTitle("Connexion");
            stage.show();

            System.out.println("Passage à la page de connexion.");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Erreur lors du chargement de la page de connexion.");
        }
    }
}
