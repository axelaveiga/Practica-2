/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.controller;

import ec.edu.espol.proyectofinal.App;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class AmbosController implements Initializable {

    @FXML
    private Button btnvendedor;
    @FXML
    private Button btncomprador;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void redirigirVendedor(MouseEvent event) {
        try {
            FXMLLoader fxmlloader = App.loadFXMLoader("vendedor");
            App.setRoot(fxmlloader);
            //VendedorController vc = fxmlloader.getController();
        } catch (IOException ex) {
            Alert a  = new Alert(AlertType.WARNING,"No se pudo abrir la siguiente pantalla");
            a.show();
        }
    }

    @FXML
    private void redirigirComprador(MouseEvent event) {
        try {
            FXMLLoader fxmlloader = App.loadFXMLoader("Comprador");
            App.setRoot(fxmlloader);
            CompradorController vc = fxmlloader.getController();
        } catch (IOException ex) {
            Alert a  = new Alert(AlertType.WARNING,"No se pudo abrir la siguiente pantalla");
            a.show();
        }
    }
    
}
