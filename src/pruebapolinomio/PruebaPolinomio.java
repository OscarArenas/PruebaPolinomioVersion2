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
package pruebapolinomio;

import modelo.Polinomio;

/**
 *
 * @author Oscar Arenas
 */
public class PruebaPolinomio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Polinomio polinomio = new Polinomio();

        polinomio.agregar(43, 0);
        polinomio.agregar(2, 7);
        polinomio.agregar(12, 2);
        polinomio.agregar(-8, 4);
        polinomio.agregar(2.7, 2);

        System.out.println("Polinomio 1: " + polinomio);
        polinomio.eliminar(4);
        System.out.println("Después de borrar");
        System.out.println("Polinomio 1: " + polinomio);
    }

}
