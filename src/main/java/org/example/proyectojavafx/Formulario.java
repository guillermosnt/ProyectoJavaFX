package org.example.proyectojavafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class Formulario {

    @FXML
    private TextField email;
    @FXML
    private Slider slider;
    @FXML
    private RadioButton sexoHombre;
    @FXML
    private RadioButton sexoMujer;
    @FXML
    private RadioButton sexoNC;
    @FXML
    private MenuButton estado;
    @FXML
    private CheckBox check;

    private String estadoSeleccionado = null;

    @FXML
    private void seleccionarEstado(ActionEvent e) {
        MenuItem item = (MenuItem) e.getSource();
        estadoSeleccionado = item.getText();
        estado.setText(item.getText());
    }

    @FXML
    protected void enviarFormulario() {

        if (email.getText().trim().isEmpty()) {
            alertaError("Debe ingresar un correo electrónico.");
            return;
        }

        if (slider.getValue() == 0) {
            alertaError("Debe indicar la valoración de la aplicación.");
            return;
        }

        if (sexoHombre == null) {
            alertaError("Debe seleccionar una opción de sexo.");
            return;
        }

        if (estadoSeleccionado == null) {
            alertaError("Debe seleccionar el estado civil.");
            return;
        }

        if (!check.isSelected()) {
            alertaError("Debe aceptar los términos y condiciones.");
            return;
        }

        System.out.println("Formulario enviado correctamente.");
    }

    @FXML
    protected void alertaError(String mensaje) {
        Alert alertError = new Alert(Alert.AlertType.ERROR);
        alertError.setTitle("Error en la aplicación");
        alertError.setHeaderText("Ha ocurrido un error");
        alertError.setContentText(mensaje);
        alertError.showAndWait();
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
    protected void abrirGuiaFormulario() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("formulario-ayuda.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage newStage = new Stage();
        newStage.setTitle("Guia Formulario");
        newStage.setScene(scene);
        newStage.show();

    }

}
