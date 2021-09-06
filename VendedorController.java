/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.controller;

import ec.edu.espol.mavenproject2.App;
import ec.edu.espol.model.Camioneta;
import ec.edu.espol.model.Carro;
import ec.edu.espol.exception.NoIDException;
import ec.edu.espol.model.Imagen;
import ec.edu.espol.model.Moto;
import ec.edu.espol.model.Vehiculo;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

/**
 * FXML Controller class
 *
 * @author ronal
 */
public class VendedorController implements Initializable {

    @FXML
    private Label txtVidrios;
    @FXML
    private Label txtTransmision;
    @FXML
    private Label txtTraccion;
    @FXML
    private TextField fieldId;
    @FXML
    private TextField fieldPlaca;
    @FXML
    private TextField fieldMarca;
    @FXML
    private TextField fieldModelo;
    @FXML
    private TextField fieldMotor;
    @FXML
    private TextField fieldAño;
    @FXML
    private TextField fieldRecorrido;
    @FXML
    private TextField fieldCombustible;
    @FXML
    private TextField fieldPrecio;
    @FXML
    private TextField fieldVidrios;
    @FXML
    private TextField fieldTransmision;
    @FXML
    private TextField fieldTraccion;
    @FXML
    private Button btPerfil;
    @FXML
    private ComboBox CbxTipo;
    @FXML
    private Button btImagen;
    @FXML
    private Button BtVender;
    @FXML
    private VBox preImagen;
    @FXML
    private TextField fieldColor;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ArrayList<String> categorias = new ArrayList<>();
        categorias.add("Moto");
        categorias.add("Carro");
        categorias.add("Camioneta");
        CbxTipo.setItems(FXCollections.observableArrayList(categorias));
        CbxTipo.setValue("Tipo de vehiculo");
    }    

    @FXML
    private void fileChooser(MouseEvent event) {
        try {
            String item = (String)CbxTipo.getValue();
            
            if(item.equals("Moto")) {
                Imagen.subirImagenMoto(fieldId.getText(), fieldPlaca.getText(), fieldMarca.getText(), 
                    fieldModelo.getText(), fieldMotor.getText(), fieldAño.getText(), 
                    fieldRecorrido.getText(), fieldCombustible.getText(), fieldPrecio.getText() );
            }
            else if(item.equals("Carro")) {
                Imagen.subirImagenCarro(fieldId.getText(), fieldPlaca.getText(), fieldMarca.getText(), 
                    fieldModelo.getText(), fieldMotor.getText(), fieldAño.getText(), 
                    fieldRecorrido.getText(), fieldCombustible.getText(), fieldPrecio.getText(),
                    fieldTransmision.getText(), fieldVidrios.getText());
            }
            else if(item.equals("Camioneta")) {
                Imagen.subirImagenCamioneta(fieldId.getText(), fieldPlaca.getText(), fieldMarca.getText(), 
                    fieldModelo.getText(), fieldMotor.getText(), fieldAño.getText(), 
                    fieldRecorrido.getText(), fieldCombustible.getText(), fieldPrecio.getText(),
                    fieldTransmision.getText(), fieldVidrios.getText(), fieldTraccion.getText());
            }
        } catch (ec.edu.espol.model.NoIDException ex) {
            Alert a = new Alert (AlertType.ERROR,"DEBE RELLENAR TODOS LOS CAMPOS");
            a.show();;
        }
    }

    @FXML
    private void cambiar(ActionEvent event) {
        String item = (String)CbxTipo.getValue();
        fieldId.clear();
        fieldPlaca.clear();
        fieldMarca.clear();
        fieldModelo.clear();
        fieldMotor.clear();
        fieldAño.clear();
        fieldRecorrido.clear();
        fieldColor.clear();
        fieldCombustible.clear();
        fieldPrecio.clear();
        fieldTransmision.clear();
        fieldVidrios.clear();
        fieldTraccion.clear();
                
        if(item.equals("Moto")) {
            fieldVidrios.setVisible(false);
            fieldTransmision.setVisible(false);
            fieldTraccion.setVisible(false);
            txtVidrios.setVisible(false);
            txtTransmision.setVisible(false);
            txtTraccion.setVisible(false);            
        }
        
        if(item.equals("Carro")) {
            fieldVidrios.setVisible(true);
            fieldTransmision.setVisible(true);
            fieldTraccion.setVisible(false);
            txtVidrios.setVisible(true);
            txtTransmision.setVisible(true);
            txtTraccion.setVisible(false); 
        }
        if(item.equals("Camioneta")) {
            fieldVidrios.setVisible(true);
            fieldTransmision.setVisible(true);
            fieldTraccion.setVisible(true);
            txtVidrios.setVisible(true);
            txtTransmision.setVisible(true);
            txtTraccion.setVisible(true);
        }
    }

    @FXML
    private void enviarFormulario(MouseEvent event) {
        String item = (String)CbxTipo.getValue();
        if(item.equals("Moto")) {
            Moto moto = new Moto(Integer.parseInt(fieldId.getText()), fieldPlaca.getText(), 
                    fieldMarca.getText(),fieldModelo.getText(), fieldMotor.getText(), 
                    Integer.parseInt(fieldAño.getText()), Integer.parseInt(fieldRecorrido.getText()),
                    fieldColor.getText(), fieldCombustible.getText(), 
                    Double.parseDouble(fieldPrecio.getText()) );
            ArrayList<Vehiculo> motos = new ArrayList<>();
            motos.add(moto);
            Vehiculo.saveFile("vehiculos.ser",motos);
        }
        else if(item.equals("Carro")) {
            Carro carro = new Carro(Integer.parseInt(fieldId.getText()), fieldPlaca.getText(), 
                    fieldMarca.getText(),fieldModelo.getText(), fieldMotor.getText(), 
                    Integer.parseInt(fieldAño.getText()), Integer.parseInt(fieldRecorrido.getText()),
                    fieldColor.getText(), fieldCombustible.getText(), 
                    Double.parseDouble(fieldPrecio.getText()), fieldVidrios.getText(), 
                    fieldTransmision.getText());
            ArrayList<Vehiculo> carros = new ArrayList<>();
            carros.add(carro);
            Vehiculo.saveFile("vehiculos.ser",carros);
        }
        else if(item.equals("Camioneta")) {
            Camioneta camioneta = new Camioneta(Integer.parseInt(fieldId.getText()), fieldPlaca.getText(), 
                    fieldMarca.getText(),fieldModelo.getText(), fieldMotor.getText(), 
                    Integer.parseInt(fieldAño.getText()), Integer.parseInt(fieldRecorrido.getText()),
                    fieldColor.getText(), fieldCombustible.getText(), 
                    Double.parseDouble(fieldPrecio.getText()), fieldVidrios.getText(), 
                    fieldTransmision.getText(), fieldTraccion.getText());
            ArrayList<Vehiculo> camionetas = new ArrayList<>();
            camionetas.add(camioneta);
            Vehiculo.saveFile("vehiculos.ser",camionetas);;
        }
    }

    @FXML
    private void ventanaPerfil(MouseEvent event) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("perfil.fxml"));
            Parent root = fxmlLoader.load();
            App.scene.setRoot(root);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
}
