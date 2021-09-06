/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.controller;

import ec.edu.espol.model.Oferta;
import ec.edu.espol.model.Vehiculo;
import ec.edu.espol.proyectofinal.App;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class OfertasCompradorController implements Initializable {
    private ArrayList<Vehiculo> vehiculos;
    private int idComprador;
    
    @FXML
    private TableView<Vehiculo> table;
    @FXML
    private TableColumn<Vehiculo, String> marca;
    @FXML
    private TableColumn<Vehiculo, String> modelo;
    @FXML
    private TableColumn<Vehiculo, String> placa;
    @FXML
    private TableColumn<Vehiculo, String> motor;
    @FXML
    private TableColumn<Vehiculo, Integer> anio;
    @FXML
    private TableColumn<Vehiculo, String> color;
    @FXML
    private TableColumn<Vehiculo, Integer> recorrido;
    @FXML
    private TableColumn<Vehiculo, Double> precio;
    @FXML
    private TableColumn<Vehiculo, ImageView> img;

    //ObservableList<Vehiculo> vehiculos2 = FXCollections.observableArrayList(vehiculos);
    ObservableList<Vehiculo> vehiculos1 = FXCollections.observableArrayList(
            new Vehiculo("chevrolet","bonito","123-abc","bueno",2011,"azul",100,25000),
            new Vehiculo("chevrolet","feo","321-abc","malo",2010,"rosa",105,20000)
    );
    @FXML
    private TextField oferta;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        img.setCellValueFactory(new PropertyValueFactory<Vehiculo, ImageView>("img"));
        marca.setCellValueFactory(new PropertyValueFactory<Vehiculo, String>("marca"));
        modelo.setCellValueFactory(new PropertyValueFactory<Vehiculo, String>("modelo"));
        placa.setCellValueFactory(new PropertyValueFactory<Vehiculo, String>("placa"));
        motor.setCellValueFactory(new PropertyValueFactory<Vehiculo, String>("motor"));
        anio.setCellValueFactory(new PropertyValueFactory<Vehiculo, Integer>("anio"));
        color.setCellValueFactory(new PropertyValueFactory<Vehiculo, String>("color"));
        recorrido.setCellValueFactory(new PropertyValueFactory<Vehiculo, Integer>("recorrido"));
        precio.setCellValueFactory(new PropertyValueFactory<Vehiculo, Double>("precio"));
        
        table.setItems(vehiculos1);
        table.setRowFactory(tv -> {
        TableRow<Vehiculo> row = new TableRow<>();
        row.setOnMouseClicked(event -> {
            if (! row.isEmpty() && event.getButton()==MouseButton.PRIMARY 
                 && event.getClickCount() == 2) {
                Vehiculo vehiselec = (Vehiculo)row.getItem();
                
                try {
                    FXMLLoader fxmlloader = App.loadFXMLoader("VehiculosDisponibles");
                    App.setRoot(fxmlloader);
                    VehiculosDisponiblesController vc = fxmlloader.getController();
                    
                    vehiselec.aggOferta(new Oferta(vehiselec.getIdVendedor(),idComprador,Integer.parseInt(oferta.getText()) ));
                    Alert a  = new Alert(Alert.AlertType.INFORMATION,"Se ofertó al vehiculo seleccionado");
                    a.show();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                
                
            }
        });
        return row ;
        });
        
    }
    
    public void setVehiculos(ArrayList<Vehiculo> vehiculos){
        this.vehiculos = vehiculos;
    }
}
