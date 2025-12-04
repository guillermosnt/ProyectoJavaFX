package org.example.proyectojavafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.*;

public class HelloController {

    @FXML
    public void cerrarVentana(ActionEvent event) {
        ((Stage) ((Node) event.getSource()).getScene().getWindow()).close();
    }

    @FXML
    protected void abrirSegundaVentana() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("segunda-ventana.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage newStage = new Stage();
        newStage.setTitle("Ventana de bienvenida");
        newStage.setScene(scene);
        newStage.show();
    }

    @FXML
    protected void abrirVentanaCrearCuenta() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ventana-registro.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage newStage = new Stage();
        newStage.setTitle("Ventana de bienvenida");
        newStage.setScene(scene);
        newStage.show();
    }

    @FXML
    private TextField usuario_nombreUnico;
    @FXML
    private TextField usuario_contrasenia;

    @FXML
    public boolean validarDatos() {
        File archivo = new File("src/datos.txt");

        try {
            BufferedReader br = new BufferedReader(new FileReader(archivo));

            String linea;
            while ((linea = br.readLine()) != null) {
                String[] separador = linea.split(";");

                if (separador.length < 4) continue;

                String usuario = separador[2];
                String contrasenia = separador[3];

                if (usuario_nombreUnico.getText().equals(usuario) && usuario_contrasenia.getText().equals(contrasenia)) {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("segunda-ventana.fxml"));
                    Scene scene = new Scene(fxmlLoader.load());
                    Stage newStage = new Stage();
                    newStage.setTitle("Ventana de bienvenida");
                    newStage.setScene(scene);
                    newStage.show();

                    Alert alertInfo = new Alert(Alert.AlertType.INFORMATION);
                    alertInfo.setTitle("Información");
                    alertInfo.setHeaderText("¡Inicio de sesión correcto!");
                    alertInfo.setContentText("Has iniciado sesión en la aplicación MindTask correctamente. ¡Bienvenid@ a la aplicación!");
                    alertInfo.showAndWait();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return false;

    }
}
