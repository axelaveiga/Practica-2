/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;

//import ec.edu.espol.util.Util;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author Dell
 */
public class Carro extends Vehiculo 
{
    protected String vidrios;
    protected String transmision;
    
    public Carro (int id, String placa, String marca, String modelo, String tipo_motor, int año, int recorrido, String color, String tipo_combustible, double precio, String vidrios, String transmision){
        super(id, placa, marca, modelo, tipo_motor, año, recorrido, color, tipo_combustible, precio);
        this.vidrios = vidrios;
        this.transmision = transmision;
    }
    public Carro(){}

    public String getVidrios() {
        return vidrios;
    }

    public void setVidrios(String vidrios) {
        this.vidrios = vidrios;
    }

    public String getTransmision() {
        return transmision;
    }

    public void setTransmision(String transmision) {
        this.transmision = transmision;
    }
    
    
}
