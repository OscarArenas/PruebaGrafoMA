/*
 * Copyright (C) 2019 Oscar Arenas
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

import java.util.ArrayList;

/**
 *
 * @author Oscar Arenas
 */
public class GrafoMAP implements IGrafo {

    private double[][] matrizAdyacencia;
    private int aristas;

    public GrafoMAP(int vertices) {
        matrizAdyacencia = new double[vertices][vertices];
        aristas = 0;
    }

    @Override
    public boolean existeVertice(int vertice) {
        return vertice >= 0 && vertice < matrizAdyacencia.length;
    }

    public boolean agregarArista(int vertice1, int vertice2, double peso) {
        // Precondiciones
        boolean ans = vertice1 != vertice2 && existeVertice(vertice1);
        ans = ans && existeVertice(vertice2) && peso != 0;
        ans = ans && matrizAdyacencia[vertice1][vertice2] == 0;

        if (ans) {
            matrizAdyacencia[vertice1][vertice2] = peso;
            matrizAdyacencia[vertice2][vertice1] = peso;
            aristas++;
        }
        return ans;
    }

    @Override
    public boolean agregarArista(int vertice1, int vertice2) {
        return agregarArista(vertice1, vertice2, 1);
    }

    @Override
    public String toString() {
        String cadena = "";
        int n = matrizAdyacencia.length;
        int longitudPrimeraColumna = (n + "").length();
        int[] mayorPorColumnas = new int[n];
        String[][] pesos = new String[n][n];

        longitudPrimeraColumna++;
        for (int i = 0; i < n; i++) {
            mayorPorColumnas[i] = 2;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                pesos[i][j] = pesoAristaString(i, j);
                int caracteres = pesos[i][j].length();
                if (caracteres > mayorPorColumnas[j]) {
                    mayorPorColumnas[j] = caracteres;
                }
                caracteres = (j + "").length() + 1;
                if (caracteres > mayorPorColumnas[j]) {
                    mayorPorColumnas[j] = caracteres;
                }
            }
        }
        // Encabezado columnas
        longitudPrimeraColumna++;
        for (int i = 0; i < longitudPrimeraColumna; i++) {
            cadena += " ";
        }
        for (int i = 0; i < n; i++) {
            mayorPorColumnas[i]++;//Sumamos el espacio en blanco entre columnas
            int cifras = (i + "").length() + 1;
            int delta = mayorPorColumnas[i] - cifras;
            for (int k = 0; k < delta; k++) {
                cadena += " ";
            }
            cadena += i + ":";
        }
        cadena += "\n";
        // Mostrar pesos y encabezado de filas
        for (int i = 0; i < n; i++) {
            int cifras = (i + "").length() + 1;
            int delta = longitudPrimeraColumna - cifras;
            for (int r = 0; r < delta; r++) {
                cadena += " ";
            }
            cadena += i + ":";
            for (int j = 0; j < n; j++) {
                cifras = pesos[i][j].length();
                delta = mayorPorColumnas[j] - cifras;
                for (int k = 0; k < delta; k++) {
                    cadena += " ";
                }
                cadena += pesos[i][j];
            }
            cadena += "\n";
        }

        return cadena;
    }

    private String pesoAristaString(int vertice1, int vertice2) {
        String cadena;

        double real = matrizAdyacencia[vertice1][vertice2];
        int entero = (int) real;

        if (entero == real) {
            cadena = entero + "";
        } else {
            cadena = real + "";
        }
        return cadena;
    }

    @Override
    public boolean eliminarVertice(int vertice) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminarArista(int vertice1, int vertice2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean existeArista(int vertice1, int vertice2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Integer> adyacentes(int vertice) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int grado(int vertice) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void borrar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean esVacio() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int cantidadVertices() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int cantidadAristas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean agregarVertice() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
