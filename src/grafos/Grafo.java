/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author criss
 */
public class Grafo {
   private List<Vertice> listaVertices;
   
   public Grafo()
   {
      listaVertices = new ArrayList<>();
   }
   
   public void agregarVertice(Vertice v)
   {
      listaVertices.add(v);
   }
   
   public List<Vertice> getListaVertices()
   {
      return listaVertices;
   }
   
   public Vertice buscarVertice(String dato)
   {
      Vertice vertice = null;
      
      for (Vertice vertices:listaVertices)
         if (vertices.getDato().equals(dato))
            vertice = vertices;
      
      return vertice;
   }
}
