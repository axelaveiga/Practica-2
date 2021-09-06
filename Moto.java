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
public class Moto extends Vehiculo
{
    
    public Moto (int id, String placa, String marca, String modelo, String tipo_motor, 
            int anio, int recorrido, String color, String tipo_combustible, double precio)
    {
        super(id, placa, marca, modelo, tipo_motor, anio, recorrido, color, tipo_combustible, precio);
    }
    
    public Moto( String marca,String modelo, String placa, String tipo_motor, int anio, String color, int recorrido, double precio){
        super( marca, modelo, placa, tipo_motor, anio,color, recorrido, precio);
    }
    public Moto(){}
    
}
