package org.example.proyectojavafx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class VentanaTienda {

    @FXML
    protected void abrirFormulario() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("formulario.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage newStage = new Stage();
        newStage.setTitle("Formulario");
        newStage.setScene(scene);
        newStage.show();
    }
}
