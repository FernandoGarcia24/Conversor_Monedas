package conversor_divisas;

import java.text.DecimalFormat;
import javax.swing.JOptionPane;

public class Conversor_Divisas {

    public static void main(String[] args) {

        double PesoColombiano = 1.0;
        double Dolar = 4157.0;
        double Euro = 4524.0;
        double Libra = 5287.0;
        double Yen = 4653.0;
        double Won = 359.0;

        Object[] options = {"Convertir Divisas", "Salir"};
        int elije = JOptionPane.showOptionDialog(null, "¿Qué quieres hacer?", "Conversor", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

        if (elije == 0) {
            DecimalFormat formatiarDivisas = new DecimalFormat("#.##");
            boolean continuarPrograma = true;
            while (continuarPrograma) {
                String[] opciones = {"Pesos Colombianos", "Dólares", "Euros", "Libras", "Yenes", "Won Surcoreano"};
                String interncambio = (String) JOptionPane.showInputDialog(null, "¿Qué moneda deseas convertir?", "Conversor de monedas", JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
                String cambio = (String) JOptionPane.showInputDialog(null, "Elija una opción", "Conversor de monedas", JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
                String input = JOptionPane.showInputDialog(null, "Ingrese la cantidad de " + interncambio + ":");
                double cantidad = 0.0;

                try {
                    cantidad = Double.parseDouble(input);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Valor no válido");
                    continue;
                }

                double resultado = 0.0;

                if (interncambio.equals("Pesos Colombianos")) {
                    resultado = cantidad / getPesoColombiano(cambio);
                    JOptionPane.showMessageDialog(null, cantidad + " Pesos colombianos son: " + formatiarDivisas.format(resultado) + " " + cambio + ".");
                } else if (cambio.equals("Pesos Colombianos")) {
                    resultado = cantidad * getPesoColombiano(interncambio);
                    JOptionPane.showMessageDialog(null, cantidad + " " + interncambio + " son: " + formatiarDivisas.format(resultado) + " Pesos colombianos.");
                } else {
                    double pesoColombianoEquivalent = cantidad * getPesoColombiano(interncambio);
                    resultado = pesoColombianoEquivalent / getPesoColombiano(cambio);
                    JOptionPane.showMessageDialog(null, cantidad + " " + interncambio + " son: " + formatiarDivisas.format(resultado) + " " + cambio + ".");
                }

                int confirmar = JOptionPane.showConfirmDialog(null, "¿Deseas continuar usando el programa?", "Confirmar", JOptionPane.YES_NO_OPTION);

                if (confirmar == JOptionPane.NO_OPTION) {
                    continuarPrograma = false;
                    JOptionPane.showMessageDialog(null, "Programa Finalizado");
                }

            }
        }else if (elije == 1) {
            JOptionPane.showMessageDialog(null, "Programa Cerrado");
            System.exit(0);
        }

    }
    
    private static double getPesoColombiano(String moneda) {
        switch (moneda) {
            case "Dólares":
                return 4157.0;
            case "Euros":
                return 4524.0;
            case "Libras":
                return 5287.0;
            case "Yenes":
                return 4653.0;
            case "Won Surcoreano":
                return 359.0;
            default:
                return 1.0; // Si la moneda es Pesos Colombianos, se retorna 1.0
        }
    }
}
