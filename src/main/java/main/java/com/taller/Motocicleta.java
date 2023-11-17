
package main.java.com.taller;
/**
 *
 * @author Leyder
 */
public class Motocicleta extends Vehiculo {
    private int cilindrada;
    private int horaDeIngreso;
    private int horaDeSalida;

    public Motocicleta(int cilindrada,  String marca, String modelo, String placa,int horaDeIngreso, int horaDeSlida) {
        super(marca, modelo, placa);
        this.cilindrada = cilindrada;
        this.horaDeIngreso = horaDeIngreso;
        this.horaDeSalida = horaDeSlida;
    }
    
    //se creo metodos get y set y el costructor 
    public int getHoraDeIngreso() {
        return horaDeIngreso;
    }

    public void setHoraDeIngreso(int horaDeIngreso) {
        this.horaDeIngreso = horaDeIngreso;
    }

    public int getHoraDeSalida() {
        return horaDeSalida;
    }

    public void setHoraDeSalida(int horaDeSalida) {
        this.horaDeSalida = horaDeSalida;
    }

    
    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }
    
    
}
