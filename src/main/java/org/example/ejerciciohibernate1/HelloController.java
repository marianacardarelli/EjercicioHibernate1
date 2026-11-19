package org.example.ejerciciohibernate1;

import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        id.setCellValueFactory(row ->
                new SimpleStringProperty(String.valueOf(row.getValue().getId())));

        nombre.setCellValueFactory(row -> {
            String name = row.getValue().getNombre();
            return new SimpleStringProperty(name == null || name.isBlank() ? "--" : name);
        });

        categoria.setCellValueFactory(row ->
                new SimpleStringProperty(String.valueOf(row.getValue().getCategoria()).toUpperCase()));

        disponible.setCellValueFactory(row -> {
            Boolean available = row.getValue().getDisponible();
            return new SimpleStringProperty(Boolean.TRUE.equals(available) ? "disponible" : "no disponible");
        });
    }

    @FXML
    private Label welcomeText;
    @FXML
    private TableColumn categoria;
    @FXML
    private TableColumn id;
    @FXML
    private TableColumn nombre;
    @FXML
    private TableColumn disponible;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}
