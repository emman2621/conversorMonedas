package principal;

import modelo.ConsultaMoneda;
import modelo.ConvertirMoneda;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        int opcion = 0;
        String menu = """
                *** Escriba el numero de la opcion deseada ***
                1 - Dolar(USD) a Peso Mexicano(MXN)
                2 - Pesos Mexicanos a Dolar (USD);
                3 - Dolar(USD) a Peso Argentino(ARS)
                4 - Pesos Argentino (ARS) a Dolar(MXN)
                7 - Salir
                **********************************************
                """;
        try{
            while (opcion!=7){
                System.out.println(menu);
                opcion = lectura.nextInt();
                ConsultaMoneda consultaMoneda = new ConsultaMoneda();
                ConvertirMoneda convertirMoneda = new ConvertirMoneda(consultaMoneda);
                System.out.println("Inserte la cantidad a convertir");
                double cantidadConvertir = lectura.nextDouble();
                double montoConvertido=0;

                switch (opcion){
                    case 1:
                        montoConvertido= convertirMoneda.covertirMoneda("USD","MXN",cantidadConvertir);
                        System.out.println("El monto convertido es: $" + String.format("%.2f", montoConvertido));
                        break;
                    case 2:
                        montoConvertido=convertirMoneda.covertirMoneda("MXN","USD",cantidadConvertir);
                        System.out.println("El monto convertido es: $" + String.format("%.2f", montoConvertido));
                        break;
                    case 3:
                        montoConvertido=convertirMoneda.covertirMoneda("USD","ARS",cantidadConvertir);
                        System.out.println("El monto convertido es: $" + String.format("%.2f", montoConvertido));
                        break;
                    case 4:
                        montoConvertido=convertirMoneda.covertirMoneda("ARS","USD",cantidadConvertir);
                        System.out.println("El monto convertido es: $" + String.format("%.2f", montoConvertido));
                        break;
                    case 7:
                        System.out.println("Gracias por utilizar el programa");
                        break;
                    default:
                        System.out.println("Opcion no valida");
                }

            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
