/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;


/**
 *
 * @author Dell
 */
public class Oferta implements Serializable{
    private int id; 
    private int idComprador; 
    private int idVehiculo; 
    private double precio_ofertado;
    public Oferta (int id, int idComprador,int idVehiculo, double precio_ofertado)
    {
        this.idComprador = idComprador;
        this.idVehiculo = idVehiculo;
       
        this.precio_ofertado = precio_ofertado;
    }
    
    public int getId()
    {
        return this.id;
    }
    public int getIdComprador()
    {
        return this.idComprador;
    }
    public int getIdVehiculo()
    {
        return this.idVehiculo;
    }
    public double getPrecio_ofertado() {
        return precio_ofertado;
    }

    public void setPrecio_ofertado(double precio_ofertado) {
        this.precio_ofertado = precio_ofertado;
    }
    
    public static ArrayList<Oferta> readFile(String archivo){
        try {
            ObjectInputStream in = new ObjectInputStream( new FileInputStream(archivo));
            ArrayList<Oferta> lista = (ArrayList<Oferta>)in.readObject();
            return lista;
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } return null;
    }    
    
    public void saveFile(String archivo, ArrayList<Oferta> ofertas)
    {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(archivo));
            out.writeObject(ofertas);
            out.flush();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }       

    
}
