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
public class Vehiculo implements Serializable{
    protected int id;
    protected String placa;
    protected String marca;
    protected String modelo;
    protected String tipo_motor;
    protected int anio;
    protected int recorrido;
    protected String color;
    protected String tipo_combustible;
    protected double precio;
    protected ArrayList<Oferta> ofertas;
    
    public Vehiculo(int id,String placa, String marca, String modelo, String tipo_motor, int anio, int recorrido, String color, String tipo_combustible, double precio){
        this.id = id;
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.tipo_motor = tipo_motor;
        this.anio = anio;
        this.recorrido = recorrido;
        this.color = color;
        this.tipo_combustible = tipo_combustible;
        this.precio = precio;
        this.ofertas = new ArrayList<>();
    }
    
    public Vehiculo( String marca,String modelo, String placa, String tipo_motor, int anio, String color, int recorrido, double precio){
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.tipo_motor = tipo_motor;
        this.anio = anio;
        this.recorrido = recorrido;
        this.color = color;
        this.precio = precio;
    }

    public void setId(int id)
    {
        this.id = id;
    }
    public int getId()
    {
        return id;
    }
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getTipo_motor() {
        return tipo_motor;
    }

    public void setTipo_motor(String tipo_motor) {
        this.tipo_motor = tipo_motor;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTipo_combustible() {
        return tipo_combustible;
    }

    public void setTipo_combustible(String tipo_combustible) {
        this.tipo_combustible = tipo_combustible;
    }
    
    public void setRecorrido(int recorrido)
    {
        this.recorrido = recorrido;
    }
    
    public int getRecorrido()
    {
        return recorrido;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public ArrayList<Oferta> getOfertas() {
        return ofertas;
    }

    public void setOfertas(ArrayList<Oferta> ofertas) {
        this.ofertas = ofertas;
    }
    
    

        
    
    
    public static ArrayList<Vehiculo> readFile(String archivo){
        try {
            ObjectInputStream in = new ObjectInputStream( new FileInputStream(archivo));
            ArrayList<Vehiculo> lista = (ArrayList<Vehiculo>)in.readObject();
            return lista;
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } return null;
    }
    
    public static void saveFile(String archivo, ArrayList<Vehiculo> vehiculos)
    {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(archivo));
            out.writeObject(vehiculos);
            out.flush();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }   
    
    public void aggOferta(Oferta o)
    {
        this.ofertas.add(o);
    }
    
    public void removerOferta(Vehiculo v, Usuario u){
        for (Oferta o: v.ofertas){
            if ( u.getId()==o.getIdComprador()){
                v.ofertas.remove(o);
            }
        }
        
    }
   public static ArrayList<String> marcasModelos (ArrayList<Vehiculo> vehiculos){
        ArrayList<String> nombres = new ArrayList<>();
        for (Vehiculo v:vehiculos){
            nombres.add(""+v.marca+","+v.modelo);
        }
        return nombres;
    }
   
   public static ArrayList<Vehiculo> ordenPrecio(ArrayList<Vehiculo> vehiculos){
        vehiculos.sort((Vehiculo v1,Vehiculo v2)-> {
            double resthis = (double)(v1.precio);
            double resp = (double)(v2.precio);
            if (resthis == resp)
            return 0;
            if (resthis>resp)
            return 1;
            else
            return -1;
        });
        return vehiculos;        
   }
}
