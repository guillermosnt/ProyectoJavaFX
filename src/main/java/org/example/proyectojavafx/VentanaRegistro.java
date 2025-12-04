package org.example.proyectojavafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.*;


public class VentanaRegistro {

    @FXML
    private TextField usuario_nombre;
    @FXML
    private TextField usuario_apellidos;
    @FXML
    private TextField usuario_nombreUnico;
    @FXML
    private TextField usuario_contrasenia;


    @FXML
    protected void obtenerDatos() {

        File archivo = new File("src/datos.txt");

        try {

            int contador = 0;

            if (archivo.exists()) {
                BufferedReader br = new BufferedReader(new FileReader(archivo));
                String linea;

                while ((linea = br.readLine()) != null) {
                    if (linea.startsWith("Datos del usuario:"))
                        contador++;
                }

                br.close();
            }

            BufferedWriter bw = new BufferedWriter(new FileWriter(archivo, true));

            String nombre = usuario_nombre.getText();
            String apellidos = usuario_apellidos.getText();
            String n_unico = usuario_nombreUnico.getText();
            String contrasenia = usuario_contrasenia.getText();
            
            bw.write(nombre);
            bw.write(";");
            bw.write(apellidos);
            bw.write(";");
            bw.write(n_unico);
            bw.write(";");
            bw.write(contrasenia);
            bw.newLine();

            bw.close();

            System.out.println("\n[✅] GUARDADO CORRECTAMENTE!");
            System.out.println("\nDatos almacenados en " + archivo.getPath() + " con nombre " + archivo.getName());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void cerrarVentana(ActionEvent event) {
        ((Stage) ((Node) event.getSource()).getScene().getWindow()).close();
    }
}
