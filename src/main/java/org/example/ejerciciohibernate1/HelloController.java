package org.example.ejerciciohibernate1;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.example.ejerciciohibernate1.models.Equipo;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private TableView<Equipo> tabla;
    @FXML
    private TableColumn<Equipo, String> categoria;
    @FXML
    private TableColumn<Equipo, String> id;
    @FXML
    private TableColumn<Equipo, String> nombre;
    @FXML
    private TableColumn<Equipo, String> disponible;
    @FXML
    private Label welcomeText;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        id.setCellValueFactory((row) -> {
            Equipo equipment = row.getValue();
            Long id = equipment.getId();
            return new SimpleStringProperty(String.valueOf(id));
        });
        nombre.setCellValueFactory((row) -> {
            if (row.getValue().getNombre().isBlank()) {
                return new SimpleStringProperty("--");
            } else {
                return new SimpleStringProperty(String.valueOf(row.getValue().getNombre()));
            }
        });
        categoria.setCellValueFactory((row) -> new SimpleStringProperty(String.valueOf(row.getValue().getCategoria()).toUpperCase()));

        disponible.setCellValueFactory((row) -> {
            var availability = row.getValue().getDisponible();
            String output = availability ? "disponible" : "no disponible";
            return new SimpleStringProperty(output);
        });
        cargarDatos();



    }


    private void cargarDatos() {

        var cfg = new Configuration().configure();
        SessionFactory sf = cfg.buildSessionFactory();

        List<Equipo> lista = sf.fromSession(session ->
                session.createQuery("from Equipo", Equipo.class)
                        .getResultList()
        );

        sf.close();

        ObservableList<Equipo> observableList = FXCollections.observableList(lista);
        tabla.setItems(observableList);
    }
}



