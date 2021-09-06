/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author Dell
 */
public class Camioneta extends Carro
{
    private String traccion;
    
    public Camioneta(int id, String placa, String marca, String modelo, 
            String tipo_motor, int anio, int recorrido, String color, String tipo_combustible, 
            double precio, String vidrios, String transmision, String traccion)
    {
        super(id, placa, marca, modelo, tipo_motor, anio, recorrido, 
                color, tipo_combustible, precio, vidrios, transmision);
        this.traccion = traccion;
    }
    public Camioneta (){}

    public String getTraccion() 
    {
        return traccion;
    }
    
    public void setTraccion(String traccion)
    {
        this.traccion = traccion;
    }
    
    
}
