/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.controller;

import ec.edu.espol.model.Camioneta;
import ec.edu.espol.model.Carro;
import ec.edu.espol.model.Moto;
import ec.edu.espol.model.Vehiculo;
import ec.edu.espol.proyectofinal.App;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class CompradorController implements Initializable {
    
    private ArrayList<Vehiculo> vehiculos;

    @FXML
    private TextField tipovehiculo;
    @FXML
    private TextField iniciorec;
    @FXML
    private TextField inicioAnio;
    @FXML
    private TextField inicioPrecio;
    @FXML
    private ComboBox cbox;
    @FXML
    private TextField finrec;
    @FXML
    private TextField finAnio;
    @FXML
    private TextField finPrecio;
    @FXML
    private Button btncontinuar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ArrayList<String> opciones = new ArrayList<>();
        opciones.add("Precio");
        opciones.add("Año");
        cbox.setItems((FXCollections.observableArrayList(opciones)));
        //vehiculos = Vehiculo.readFile("vehiculos.ser");
    }    

    @FXML
    private void continuar(MouseEvent event) {
        try {
            FXMLLoader fxmlloader = App.loadFXMLoader("OfertasComprador");
            App.setRoot(fxmlloader);
            OfertasCompradorController oc = fxmlloader.getController();
            if (tipovehiculo.getText().equals("Carro")){
                Vehiculo.filtrarVehiculos(vehiculos, new Carro(), Integer.parseInt(iniciorec.getText()), Integer.parseInt(finrec.getText()), Integer.parseInt(inicioAnio.getText()), Integer.parseInt(finAnio.getText()), Integer.parseInt(inicioPrecio.getText()), Integer.parseInt(finPrecio.getText()));
            }
            if (tipovehiculo.getText().equals("Camioneta")){
                Vehiculo.filtrarVehiculos(vehiculos, new Camioneta(), Integer.parseInt(iniciorec.getText()), Integer.parseInt(finrec.getText()), Integer.parseInt(inicioAnio.getText()), Integer.parseInt(finAnio.getText()), Integer.parseInt(inicioPrecio.getText()), Integer.parseInt(finPrecio.getText()));
            }
            if (tipovehiculo.getText().equals("Moto")){
                Vehiculo.filtrarVehiculos(vehiculos, new Moto(), Integer.parseInt(iniciorec.getText()), Integer.parseInt(finrec.getText()), Integer.parseInt(inicioAnio.getText()), Integer.parseInt(finAnio.getText()), Integer.parseInt(inicioPrecio.getText()), Integer.parseInt(finPrecio.getText()));
            }
            String orden = (String)cbox.getValue();
            Vehiculo.ordenPor(vehiculos, orden);
            oc.setVehiculos(vehiculos);
        } catch (IOException ex) {
            Alert a  = new Alert(Alert.AlertType.WARNING,"No se pudo abrir la siguiente pantalla");
            a.show();
        }
    }

    
    
}
