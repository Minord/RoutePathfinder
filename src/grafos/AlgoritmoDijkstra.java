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
public class AlgoritmoDijkstra {
   
   public static Grafo obtenerRuta(Grafo G, Vertice VI, Vertice VF)
   {
      int Destino;
      int Indice = 0;
      double Distancia;
      CambiarEstado(G);
      double Acumulado = 0;
      Grafo Ruta = new Grafo();
      List<Vertice> ListaVertices = new ArrayList<>();
      double Costos[] = Costos(G.getListaVertices().size());
      Costos[G.getListaVertices().indexOf(VI)] = 0;
      Vertice VTemp = VI;
      
      
      while(!(VTemp.getDato().equals(VF.getDato())))
      {
         System.out.println("Pass for Here");
         double min = 999;
         
         for (Arista A : VTemp.getAristas())
         {
            Destino = G.getListaVertices().indexOf(A.getDestino());
            Distancia = Acumulado + A.getPeso();

            if ((A.getDestino().getEvaluado() != true) && (Distancia < Costos[Destino]))
            {
               Costos[Destino] = (Math.round(Distancia * 100d)/100d);
            }
         }
         
         VTemp.setEvaluado(true);
         
         for (int i = 0; i < G.getListaVertices().size(); i++)
         {
            if ((Costos[i] != 0) && (G.getListaVertices().get(i).getEvaluado() != true))
            {
               if (Costos[i] < min)
               {
                  min = Costos[i];
                  Indice = i;
               }
            }
         }
         
         Vertice V = G.getListaVertices().get(Indice); //handle it by id
         Acumulado = min;
         VTemp = V;
      }
      
      Indice = 0;
      CambiarEstado(G);
      Arista AristaMin = null;
      ListaVertices.add(new Vertice(VTemp.getDato(), VTemp.getX(), VTemp.getY()));
      
      while (!(VTemp.getDato().equals(VI.getDato())))
      {  
         for (Arista A:VTemp.getAristas())
         {
            Destino = G.getListaVertices().indexOf(A.getDestino());
            Distancia = (Math.round((Acumulado - A.getPeso()) * 100d)/100d);
            
            if ((A.getDestino().getEvaluado() != true) && (Distancia == Costos[Destino]))
            {
               AristaMin = A;
            }
         }
         
         VTemp.setEvaluado(true);
         VTemp = AristaMin.getDestino();
         Acumulado -= AristaMin.getPeso();
         Vertice V = new Vertice(VTemp.getDato(), VTemp.getX(), VTemp.getY());
         ListaVertices.add(V);
         ListaVertices.get(Indice).agregarArista(new Arista(V, ListaVertices.get(Indice), AristaMin.getPeso()));
         Indice++;
      }
      
      for (int i = (ListaVertices.size() - 1); i >= 0; i--)
      {
         Ruta.agregarVertice(ListaVertices.get(i));
      }
      
      return Ruta;
   }
   
   private static double[] Costos(int tamaño)
   {
      double[] Costos = new double[tamaño];
      
      for (int i = 0; i < tamaño; i++)
      {
         Costos[i] = 999;
      }
      
      return Costos;
   }
   
   private static void CambiarEstado(Grafo G)
   {
      for (Vertice V : G.getListaVertices())
      {
         V.setEvaluado(false);
      }
   }
}
