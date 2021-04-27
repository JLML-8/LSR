/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author luis_
 */

import java.util.*;

public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<Double> vectorX = new ArrayList();
        ArrayList<Double> vectorY = new ArrayList();
        vectorX.add(23.0);
        vectorX.add(26.0);
        vectorX.add(30.0);
        vectorX.add(34.0);
        vectorX.add(43.0);
        vectorX.add(48.0);
        vectorX.add(52.0);
        vectorX.add(57.0);
        vectorX.add(58.0);
        vectorY.add(651.0);
        vectorY.add(762.0);
        vectorY.add(856.0);
        vectorY.add(1063.0);
        vectorY.add(1190.0);
        vectorY.add(1298.0);
        vectorY.add(1421.0);
        vectorY.add(1440.0);
        vectorY.add(1518.0);  
        RegresionLinearSimple reg = new RegresionLinearSimple(vectorX, vectorY);
        reg.calcularRegresionSimple();
        reg.imprimirEcuacion();

        boolean aux = true;
        while (aux) {
            Scanner input = new Scanner(System.in);
            System.out.println("Ingrese un valor de X para calcular Y (por favor ingrese el valor con punto decimal): ");
            double x = 0;
            x = input.nextDouble();
            double y = reg.calcularY(x);
            System.out.println("El valor de Y cuando X vale " + x + " es " + y);
            System.out.println("¿Desea calcular otro valor? 1 para si, 2 para no");
            int continuar = input.nextInt();
            if (continuar == 2) {
                aux = false;
            }
        }
    }

}
