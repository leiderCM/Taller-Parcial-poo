
package main.java.com.taller;



import static spark.Spark.*;
import com.google.gson.Gson;
import java.util.LinkedList;
/**
 *
 * @author Leyder 
 */
public class main {

    public static void main(String[] args) {
        
        
        // Esto nos sirve para generar un formato json para retornar la data del array
        Gson gson = new Gson();
        //lista los cuales almacenan automoviles y motocicletas
        LinkedList <Automovil> automoviles = new LinkedList<>();
        LinkedList <Motocicleta> motocicletas = new LinkedList<>();
        
        // Automovil creado por defecto
        Automovil auto = new Automovil(4, "Mazda", "3", "ZYX987",0,0);
        automoviles.add(auto);
        
        Motocicleta moto = new Motocicleta(600, "Honda", "CBR600", "XYZ789",0,0);
        motocicletas.add(moto);
        // Definir endpoints
        // este endpoint es por defecto muestra solo el objeto de moto
        get("/motocicleta", (req, res) -> {
            res.type("application/json");
            return gson.toJson(moto);
        });
        
        // Listado de automovile
        get("/automoviles", (req, res) -> {
            res.type("application/json");
            return gson.toJson(automoviles);
        });
        // lostado de motocicletas
        get("/motos", (req, res) -> {
            res.type("application/json");
            return gson.toJson(motocicletas);
        });
        // muestra la hora de salida, identificado por placa y se le añade la nueva hora
        //actualiza la hora de salida del automovil sin modificar lo demas 
        get("/horaSalidaAutomovil/:hora/:placa", (req, res) -> {
            
            res.type("application/json");
             int  hora = Integer.parseInt( req.params(":hora"));
             String  placa = req.params(":placa");
             
            Automovil automovilactualizado=null;
            
            for ( Automovil automovil : automoviles) {
                 
                if(automovil.getPlaca().equals(placa)){
                    automovil.setHoraDeSlida(hora);
                    automovilactualizado=automovil;
                }
            }
            return gson.toJson(automovilactualizado);
        });
        //endpoint de hora de ingreso del vehiculo
         get("/horaIngresoAutomovil/:hora/:placa", (req, res) -> {
            
            res.type("application/json");
             int  hora = Integer.parseInt( req.params(":hora"));
             String  placa = req.params(":placa");
             
            Automovil automovilactualizado=null;
            
            for ( Automovil automovil : automoviles) {
                 
                if(automovil.getPlaca().equals(placa)){
                    automovil.setHoraDeIngreso(hora);
                    automovilactualizado=automovil;
                } 
            }
            return gson.toJson(automovilactualizado);
        }); 
        //igualmente modifiva la hora de salida del la moto sin cambier nada mas 
        get("/horaSalidaMoto/:hora/:placa", (req, res) -> {
            
            res.type("application/json");
             int  hora = Integer.parseInt( req.params(":hora"));
             String  placa = req.params(":placa");
            Motocicleta motocicletaActualizada=null; 
            for (Motocicleta motocicleta : motocicletas) {
                 
                if(motocicleta.getPlaca().equals(placa)){
                    motocicleta.setHoraDeSalida(hora);
                    motocicletaActualizada=motocicleta;
                }   
            }
            return gson.toJson(motocicletaActualizada);
        });
        //registro de hora de ingreso de moto
         get("/horaIngresoMoto/:hora/:placa", (req, res) -> {
            
            res.type("application/json");
             int  hora = Integer.parseInt( req.params(":hora"));
             String  placa = req.params(":placa");
             
            Motocicleta motocicletaActualizada=null; 
            for (Motocicleta motocicleta : motocicletas) {
                 
                if(motocicleta.getPlaca().equals(placa)){
                    motocicleta.setHoraDeIngreso(hora);
                    motocicletaActualizada=motocicleta;
                }  
            }
            return gson.toJson(motocicletaActualizada);
        });
        // Guardar automovil
        // endpoint get para agregar un automóvil
        get("/agregarAutomovil/:marca/:modelo/:placa/:numeroPuertas", (req, res) -> {
            
            // Añadimos esto para retornar en formato Json
            res.type("application/json");

            // Obtener parámetros de la URL
            String marca = req.params(":marca");
            String modelo = req.params(":modelo");
            String placa = req.params(":placa");
            
            // No olvidar convertir en integer los string numericos que llegan por url
            int numeroPuertas = Integer.parseInt(req.params(":numeroPuertas"));

            // Crear un nuevo automóvil y agregarlo al parqueadero
            Automovil nuevoAuto = new Automovil(numeroPuertas, marca, modelo,placa,0, 0);
            automoviles.add(nuevoAuto);

            return gson.toJson(nuevoAuto);
        });
        //endpoint para agregar un moto con toda su informacion por parametros
        get("/agregarMoto/:marca/:modelo/:placa/:cilindraje", (req, res) -> {
            
            // Añadimos esto para retornar en formato Json
            res.type("application/json");

            // Obtener parámetros de la URL
            String marca = req.params(":marca");
            String placa = req.params(":placa");
            String modelo = req.params(":modelo");
            int  cilindraje = Integer.parseInt( req.params(":cilindraje"));
 
           Motocicleta motocicleta = new  Motocicleta(cilindraje,marca,modelo,placa,0,0);
           motocicletas.add(motocicleta);
           
            return gson.toJson(motocicleta);
        }); 
        // Lista de motocicletas dentro del parqueadero
        get("/motosEnParqueadero", (req, res) -> {
            res.type("application/json");
            //mostos en el parqueadero
            LinkedList<Motocicleta> motosEnParqueadero = new LinkedList<>();

            for (Motocicleta motocicleta : motocicletas) {
                // Verificar si la moto no ha salido hora de salida = 0
                if (motocicleta.getHoraDeSalida() == 0) {
                    motosEnParqueadero.add(motocicleta);
                    
                }
            } 
            return gson.toJson(motosEnParqueadero);
        });
        // Lista de automóviles dentro del parqueadero
        get("/automovilesEnParqueadero", (req, res) -> {
            res.type("application/json");
            //carros en el parqueadero
            LinkedList<Automovil> autosEnParqueadero = new LinkedList<>();

            for (Automovil automovil : automoviles) {
                // Verificar si el automóvil no ha salido hora de salida = 0
                if (automovil.getHoraDeSlida() == 0) {
                    autosEnParqueadero.add(automovil);
                }
            }
            return gson.toJson(autosEnParqueadero);
        });

    }
}
