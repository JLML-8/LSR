/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author luis_
 */
package examples.behaviours;
import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import java.util.ArrayList;
import javax.swing.*;

public class SimpleLinearRegressionAgent extends Agent {

    private double x; //en esta variable se guarda el x que se ingresa a través del JOptionPane
    private double sum_x;
    private double sum_y;
    private double sum_xy;
    private double sum_x_cuad;
    private double b_cero;
    private double b_uno;
    private ArrayList<Double> vectorX = new ArrayList();
    private ArrayList<Double> vectorY = new ArrayList();

    private class OptionPaneX {
        JFrame f;
        OptionPaneX() {
            f = new JFrame();
            x = Double.parseDouble(JOptionPane.showInputDialog(f, "Ingresa el valor de X para calcular Y"));
        }
    }

    protected void setup() {
        System.out.println("Agent " + getLocalName() + " started");
        addBehaviour(new MyOneShotBehaviour());
        sum_x = 0;
        sum_y = 0;
        sum_xy = 0;
        sum_x_cuad = 0;
        b_cero = 0;
        b_uno = 0;
        x=0;
        //datos de X
        vectorX.add(23.0);
        vectorX.add(26.0);
        vectorX.add(30.0);
        vectorX.add(34.0);
        vectorX.add(43.0);
        vectorX.add(48.0);
        vectorX.add(52.0);
        vectorX.add(57.0);
        vectorX.add(58.0);
        //datos de Y
        vectorY.add(651.0);
        vectorY.add(762.0);
        vectorY.add(856.0);
        vectorY.add(1063.0);
        vectorY.add(1190.0);
        vectorY.add(1298.0);
        vectorY.add(1421.0);
        vectorY.add(1440.0);
        vectorY.add(1518.0);
    }

    private class MyOneShotBehaviour extends OneShotBehaviour {

        public void action() {
            RegresionLinearSimple reg = new RegresionLinearSimple(vectorX, vectorY);
            reg.calcularRegresionSimple();
            reg.imprimirEcuacion();
            new OptionPaneX();
            System.out.println("El valor de Y cuando X vale: "+x+" es: "+reg.calcularY(x));
        }

        public int onEnd() {
            myAgent.doDelete();
            return super.onEnd();
        }

    }

}
