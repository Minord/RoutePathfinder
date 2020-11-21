/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 *
 * @author criss
 * 
 * Sistema que renderiza el grafo.
 * 
 * - Dibuja las calles, ciudades y pueblos de formas diferentes.
 * - Sistema de seleccion de nodos de origen y destino.
 * - Dibuja la ruta que es encontrada por el algoritmo.
 */
public class DibujarRutas {

   public static void dibujarRutas(Graphics g, Grafo G)
   {      
      for (Vertice v:G.getListaVertices())
      {
         for (Arista a:v.getAristas())
         {
            ((Graphics2D)g).setStroke(new BasicStroke(3));
            ((Graphics2D)g).setColor(Color.white);
            ((Graphics2D)g).drawLine(a.getOrigen().getX() + 5, a.getOrigen().getY() + 5, a.getDestino().getX() + 5, a.getDestino().getY() + 5);
         }
      }
      
      for(Vertice vertice:G.getListaVertices())
      {
          if(vertice.getType().equals("ciudad")){
              ((Graphics2D)g).setColor(Color.orange);
              ((Graphics2D)g).fillOval(vertice.getX() - 2, vertice.getY() - 2, 15, 15);
          } else if(vertice.getType().equals("pueblo")){
            ((Graphics2D)g).setColor(Color.pink);
              ((Graphics2D)g).fillOval(vertice.getX(), vertice.getY(), 10, 10);
          }         
      }
   }
   
   public static void dibujarRutaMinima(Graphics g, Grafo G)
   {
      for (Vertice V:G.getListaVertices())
      {
         ((Graphics2D)g).setColor(Color.red);
         ((Graphics2D)g).drawOval(V.getX() , V.getY() , 9, 9);
         ((Graphics2D)g).fillOval(V.getX() , V.getY() , 9, 9);
         
         for (Arista A:V.getAristas())
         {
            ((Graphics2D)g).setStroke(new BasicStroke(3));
            ((Graphics2D)g).setColor(Color.red);
            ((Graphics2D)g).drawLine(A.getOrigen().getX() + 5, A.getOrigen().getY() + 5, A.getDestino().getX() + 5, A.getDestino().getY() + 5);
         }
      }
   }
   
   public static void seleccionarVertice(Graphics g, Vertice v)
   {
      ((Graphics2D)g).setColor(Color.red);
      ((Graphics2D)g).drawOval(v.getX(), v.getY(), 10, 10);
      ((Graphics2D)g).fillOval(v.getX(), v.getY(), 10, 10);
   }
   
   public static void deseleccionarVertice(Graphics g, Vertice v)
   {
      ((Graphics2D)g).setColor(Color.WHITE);
      ((Graphics2D)g).drawOval(v.getX(), v.getY(), 10, 10);
      ((Graphics2D)g).fillOval(v.getX(), v.getY(), 10, 10);
   }
}
