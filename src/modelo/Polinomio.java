/*
 * Copyright (C) 2020 Oscar Arenas
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package modelo;

/**
 *
 * @author Oscar Arenas
 */
public class Polinomio {

    // Campos
    private double[] datos;
    private int n;

    // Métodos
    public Polinomio() {
        datos = new double[2];
        n = 0;
    }

    public boolean agregar(double coeficiente, int exponente) {
        if (coeficiente == 0 || exponente < 0 || contiene(exponente)) {
            return false;
        }
        if (datos.length == 2 * n) {
            cambiarCapacidad(2 * datos.length);
        }
        int i = 2 * n - 1;

        while (i > 0 && exponente > datos[i]) {
            datos[i + 2] = datos[i];
            datos[i + 1] = datos[i - 1];
            i -= 2;
        }

        datos[i + 1] = coeficiente;
        datos[i + 2] = exponente;
        n++;
        return true;
    }

    public boolean eliminar(int exponente) {
        for (int i = 1; i < 2 * n; i = i + 2) {
            if (exponente == datos[i]) {
                n--;
                for (int j = i; j < 2 * n; j = j + 2) {
                    datos[j] = datos[j + 2];
                    datos[j - 1] = datos[j + 1];
                }
                if (datos.length / 4 == n) {
                    cambiarCapacidad(datos.length / 2);
                }
                return true;
            }
        }
        return false;
    }

    private void cambiarCapacidad(int nc) {
        if (nc > 1 && nc >= 2 * n) {
            double[] nuevoVector = new double[nc];

            for (int i = 0; i < 2 * n; i++) {
                nuevoVector[i] = datos[i];
            }
            datos = nuevoVector;
        }
    }

    public boolean contiene(int exponente) {
        int i = 0;
        while (i < n && datos[2 * i + 1] > exponente) {
            i++;
        }
        return i < n && datos[2 * i + 1] == exponente;
    }

    /**
     * Genera una representación en cadena (String) del polinomio. La cadena
     * contiene todos los términos del polinomio en orden descendente de los
     * exponentes.
     *
     * @return Cadena que representa el polinomio.
     */
    @Override
    public String toString() {
        String cadena = "";

        if (n > 0) {
            int k = 0;
            double coeficiente = datos[k];
            int exponente = (int) datos[k + 1];
            String signo = "";
            if (coeficiente < 0) {
                signo = "-";
            }
            cadena += signo + convertirTermino(coeficiente, exponente);

            for (int i = 1; i < n; i++) {
                k = 2 * i;
                coeficiente = datos[k];
                exponente = (int) datos[k + 1];

                if (coeficiente < 0) {
                    signo = " - ";
                } else {
                    signo = " + ";
                }
                cadena += signo + convertirTermino(coeficiente, exponente);
            }
        }
        return cadena;
    }

    /*
     * Convierte los parámetros en una representación en cadena (String) del 
     * término en función de x. Por ejemplo, si el coeficiente es 5 y el 
     * exponente es 3 el método retorna la cadena "5x^3"
     */
    private String convertirTermino(double coeficiente, int exponente) {
        coeficiente = Math.abs(coeficiente);
        int valorEntero = (int) coeficiente;
        String cadena = "";

        if (valorEntero == coeficiente) {
            cadena += valorEntero;
        } else {
            cadena += coeficiente;
        }
        if (exponente > 0) {
            if (coeficiente == 1) {
                cadena = "";
            }
            if (exponente == 1) {
                cadena += "x";
            } else {
                cadena += "x^" + exponente;
            }
        }
        return cadena;
    }
}
