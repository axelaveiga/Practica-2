/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.controller;

import ec.edu.espol.mavenproject2.App;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author ronal
 */
public class PerfilController implements Initializable {

    @FXML
    private Button btRegresar;
    @FXML
    private Label idLabel;
    @FXML
    private Label nombresLabel;
    @FXML
    private Label apellidosLabel;
    @FXML
    private Label organizacionLabel;
    @FXML
    private Label correoLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void ventanaRegresar(MouseEvent event) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("vendedor.fxml"));
            Parent root = fxmlLoader.load();
            App.scene.setRoot(root);
        } catch (IOException ex) {
            ex.printStackTrace();
        }        
    }
    
    public void setValues(String id, String nombres, String apellidos,
            String organizacion, String correo) {
        idLabel.setText(id);
        nombresLabel.setText(nombres);
        apellidosLabel.setText(apellidos);
        organizacionLabel.setText(organizacion);
        correoLabel.setText(correo);
    }
    
}
