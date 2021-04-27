package examples.behaviours;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author luis_
 */
public class RegresionLinearSimple {

    private double sum_x;
    private double sum_y;
    private double sum_xy;
    private double sum_x_cuad;
    private double b_cero;
    private double b_uno;

    private ArrayList<Double> vectorX;
    private ArrayList<Double> vectorY;

    public RegresionLinearSimple(ArrayList<Double> vectorX, ArrayList<Double> vectorY) {
        sum_x = 0;
        sum_y = 0;
        sum_xy = 0;
        sum_x_cuad = 0;
        b_cero = 0;
        b_uno = 0;
        this.vectorX = vectorX;
        this.vectorY = vectorY;
    }

    public void limpiarVectores() {
        vectorX.clear();
        vectorY.clear();
    }


    public void calcularRegresionSimple() {
        for (int i = 0; i < vectorX.size(); i++)//en teoria deberían ser el mismo número de elementos en ambos vectores
        {
            sum_x += vectorX.get(i);
            sum_y += vectorY.get(i);
            sum_xy += (vectorX.get(i) * vectorY.get(i));
            sum_x_cuad += (vectorX.get(i) * vectorX.get(i));
        }
        b_uno = ((vectorX.size() * sum_xy) - (sum_x * sum_y)) / ((vectorX.size() * sum_x_cuad) - (sum_x * sum_x));
        b_cero = (sum_y / vectorY.size()) - b_uno * (sum_x / vectorX.size());
    }

    public void imprimirEcuacion() {
        System.out.println("La ecuación de regresión es y_hat= " + b_cero + " + (" + b_uno + ")(X1)");
    }

    public double calcularY(double x) {
        double y = 0;
        y = b_cero + (b_uno * x);
        return y;
    }

}
