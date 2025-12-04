package org.example.proyectojavafx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class Ajustes {

    private static Scene scene;

    @FXML
    private Button btnOscuro;

    @FXML
    private Button btnClaro;

    public static void setScene(Scene s) {
        scene = s;
    }

    @FXML
    public void initialize() {

        btnOscuro.setOnAction(e -> activarModoOscuro());
        btnClaro.setOnAction(e -> activarModoClaro());

        btnOscuro.setAccessibleText("Activar modo oscuro");
        btnClaro.setAccessibleText("Activar modo claro");
    }

    public static void activarModoOscuro() {
        if (scene == null) return;

        scene.getStylesheets().clear();
        scene.getStylesheets().add(
                Ajustes.class.getResource("/css/oscuro.css").toExternalForm()
        );
    }

    public static void activarModoClaro() {
        if (scene == null) return;

        scene.getStylesheets().clear();
        scene.getStylesheets().add(
                Ajustes.class.getResource("/css/claro.css").toExternalForm()
        );
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


}
