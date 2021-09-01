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
public interface IGrafo {

    boolean eliminarVertice(int vertice);

    boolean agregarArista(int vertice1, int vertice2);

    boolean eliminarArista(int vertice1, int vertice2);

    boolean existeVertice(int vertice);

    boolean existeArista(int vertice1, int vertice2);

    ArrayList<Integer> adyacentes(int vertice);

    int grado(int vertice);

    void borrar();

    boolean esVacio();

    int cantidadVertices();

    int cantidadAristas();

    boolean agregarVertice();
}
