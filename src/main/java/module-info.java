module org.example.proyectojavafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.desktop;


    opens org.example.proyectojavafx to javafx.fxml;
    exports org.example.proyectojavafx;
}