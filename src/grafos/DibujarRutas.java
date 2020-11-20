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
import java.util.List;

/**
 *
 * @author criss
 */
public class DibujarRutas {

   public static void dibujarRutas(Graphics g, Grafo G)
   {      
      for (Vertice v:G.getListaVertices())
      {
         for (Arista a:v.getAristas())
         {
            ((Graphics2D)g).setStroke(new BasicStroke(2));
            ((Graphics2D)g).setColor(Color.GRAY);
            ((Graphics2D)g).drawLine(a.getOrigen().getX() + 5, a.getOrigen().getY() + 5, a.getDestino().getX() + 5, a.getDestino().getY() + 5);
         }
      }
      
      for(Vertice vertice:G.getListaVertices())
      {
         ((Graphics2D)g).setColor(Color.white);
         ((Graphics2D)g).drawOval(vertice.getX(), vertice.getY(), 10, 10);
         ((Graphics2D)g).fillOval(vertice.getX(), vertice.getY(), 10, 10);
      }
   }
   
   public static void dibujarRutaMinima(Graphics g, Grafo G)
   {
      for (Vertice V:G.getListaVertices())
      {
         ((Graphics2D)g).setColor(Color.BLUE);
         ((Graphics2D)g).drawOval(V.getX(), V.getY(), 10, 10);
         ((Graphics2D)g).fillOval(V.getX(), V.getY(), 10, 10);
         
         for (Arista A:V.getAristas())
         {
            ((Graphics2D)g).setStroke(new BasicStroke(2));
            ((Graphics2D)g).setColor(Color.BLUE);
            ((Graphics2D)g).drawLine(A.getOrigen().getX() + 5, A.getOrigen().getY() + 5, A.getDestino().getX() + 5, A.getDestino().getY() + 5);
         }
      }
   }
   
   public static void seleccionarVertice(Graphics g, Vertice v)
   {
      ((Graphics2D)g).setColor(Color.RED);
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
