import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String opcion = "0";
        double cantidad = 0;

        String monedaBase = "", monedaDestino = "";

        List<String> monedas = new ArrayList<>(List.of("USD", "MXN", "BRL", "COP"));

        List<Cambio> historial = new ArrayList<>();

       while (!opcion.equals("4")){
           System.out.println("""
                
                *****************************************
                
                Bienvenido al Conversor de Moneda.
                
                1) Convertir moneda
                2) Agregar moneda
                3) Historial de Conversiones
                4) Salir
                
                *****************************************
                
                """);
           System.out.println("Elige una opcion valida: ");
           opcion = scan.nextLine();

           switch (opcion){
               case "1":

                   System.out.println("\nElige una opcion para la moneda base: ");
                   for (int i = 0; i < monedas.size(); i++){
                       System.out.println((i+1)+") "+monedas.get(i));
                   }
                   int opcionMonedaBase = scan.nextInt();
                   monedaBase = monedas.get(opcionMonedaBase - 1);

                   System.out.println("\nElige una opcion para la moneda destino:");
                   for (int i = 0; i < monedas.size(); i++){
                       System.out.println((i+1)+") "+monedas.get(i));
                   }
                   int opcionMonedaDestino = scan.nextInt();
                   monedaDestino = monedas.get(opcionMonedaDestino - 1);
                   System.out.println("\nIngresa el valor que deseas convertir: ");
                   cantidad = scan.nextDouble();

                   Conversion conversion = ConsultaCambio.conversionMoneda(monedaBase, monedaDestino, cantidad);

                   Cambio cambio = new Cambio(monedaBase, monedaDestino, cantidad, conversion.conversion_result(), LocalDateTime.now());

                   historial.add(cambio);

                   System.out.println("\nEl valor "+cantidad + " [" + monedaBase + "] " + "corresponde al valor final de ===> "
                           + conversion.conversion_result() + " [" + monedaDestino + "]");
                   scan.nextLine();
                   break;
               case "2":
                   try{
                       System.out.println("Escribe la abreviatura de la moneda ha agregar");
                       String agregarMoneda = scan.nextLine().toUpperCase();
                       if (monedas.contains(agregarMoneda)){
                           System.out.println("\nMoneda ya existente");
                           continue;
                       }
                       Conversion conversion2 = ConsultaCambio.conversionMoneda("MXN", agregarMoneda, 1);
                       if(conversion2.result().equals("success")){
                           System.out.println("\nMoneda agregada con exito");
                           monedas.add(agregarMoneda);
                       }else {
                           System.out.println("\nMoneda no valida, verifique su moneda");
                       }
                   }catch (Exception e){
                       System.out.println("\nNo se pudo agregar la moneda");
                   }
                   break;
               case "3":
                   System.out.println("""
                           
                           Historial de conversiones
                           
                           """);
                   for (Cambio cam: historial){
                       System.out.println(cam);
                   }
                   break;
               case "4":
                   System.out.println("\nSaliendo de la aplicacion!!");
                   break;
               default:
                   System.out.println("\nIngrese una opcion correcta del 1 al 4");
           }
        }
    }
}
