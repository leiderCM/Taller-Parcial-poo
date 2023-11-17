
package main.java.com.taller;
/**
 *
 * @author codigo: 104623010330 Estudiante: leyder ceron muñoz
 */
public class Automovil extends Vehiculo {
    private int numeroPuertas;
    private int horaDeIngreso;
    private int horaDeSlida;
   
    //completamos el codigo con metodos get y set y el costructor 
    public Automovil(int numeroPuertas,  String marca, String modelo, String placa,int horaDeIngreso, int horaDeSlida) {
        super(marca, modelo, placa);
        this.numeroPuertas = numeroPuertas;
        this.horaDeIngreso = horaDeIngreso;
        this.horaDeSlida = horaDeSlida;
    }

    public int getHoraDeIngreso() {
        return horaDeIngreso;
    }

    public void setHoraDeIngreso(int horaDeIngreso) {
        this.horaDeIngreso = horaDeIngreso;
    }

    public int getHoraDeSlida() {
        return horaDeSlida;
    }

    public void setHoraDeSlida(int horaDeSlida) {
        this.horaDeSlida = horaDeSlida;
    }
    
    public int getNumeroPuertas() {
        return numeroPuertas;
    }

    public void setNumeroPuertas(int numeroPuertas) {
        this.numeroPuertas = numeroPuertas;
    } 
}