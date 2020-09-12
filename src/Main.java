import model.Billetera;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static void cliente(){
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            Billetera billetera = Billetera.getInstance();
            System.out.println("\nIngrese en consola: \nA para agregar dinero a la cuenta\nB para retirar dinero\nC para consultar saldo\nD para salir");
            switch (reader.readLine().toUpperCase()){
                case "A":
                    System.out.println("Ingrese un valor (Sin decimales)");
                    billetera.agregarDinero(Long.parseLong(reader.readLine()));
                    cliente();
                    break;
                case "B":
                    System.out.println("Ingrese un valor (Sin decimales)");
                    billetera.retirarDinero(Long.parseLong(reader.readLine()));
                    cliente();
                    break;
                case "C":
                    billetera.consultarSaldo();
                    cliente();
                    break;
                case "D":
                    return;
                default:
                    System.out.println("Opción incorrecta, intente de nuevo");
                    cliente();
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        cliente();
    }
}
