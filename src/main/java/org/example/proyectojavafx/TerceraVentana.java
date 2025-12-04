package org.example.proyectojavafx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class TerceraVentana {

    @FXML
    public void cerrarVentana(javafx.event.ActionEvent event) {
        ((Stage) ((Node) event.getSource()).getScene().getWindow()).close();
    }

    @FXML
    protected void abrirVentanaTienda() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ventana-tienda.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage newStage = new Stage();
        newStage.setTitle("Tienda");
        newStage.setScene(scene);
        newStage.show();
    }

    @FXML
    protected void abrirFormulario() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("formulario.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage newStage = new Stage();
        newStage.setTitle("Formulario");
        newStage.setScene(scene);
        newStage.show();
    }

    @FXML
    protected void abrirAjustes() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ajustes.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage newStage = new Stage();
        newStage.setTitle("Ajustes");
        newStage.setScene(scene);
        newStage.show();
    }
    
}
