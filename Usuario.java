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
public class Usuario implements Serializable{
    protected int id;
    protected String nombres;
    protected String apellidos;
    protected String organizacion;
    protected String correo_electronico;
    protected String clave;
    protected static ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
    

    public Usuario(int id, String nombres, String apellidos, String organizacion,
            String correo_electronico, String clave) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.organizacion = organizacion;
        this.correo_electronico = correo_electronico;
        this.clave = clave;
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getOrganizacion() {
        return organizacion;
    }

    public void setOrganizacion(String organizacion) {
        this.organizacion = organizacion;
    }

    public String getCorreo_electronico() {
        return correo_electronico;
    }

    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    

    public void setVehiculos(ArrayList<Vehiculo> vehiculos)
    {
        this.vehiculos = vehiculos;
    }
    
    public ArrayList<Vehiculo> getListaVehiculos()
    {
        return vehiculos;
    }
    
    
        
    
    public void saveFile(String archivo, ArrayList<Usuario> usuarios)
    {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(archivo));
            out.writeObject(usuarios);
            out.flush();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
     public static ArrayList<Usuario> readFile(String archivo){
        try {
            ObjectInputStream in = new ObjectInputStream( new FileInputStream(archivo));
            ArrayList<Usuario> lista = (ArrayList<Usuario>)in.readObject();
            return lista;
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } return null;
    }
}
