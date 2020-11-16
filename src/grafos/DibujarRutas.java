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

   public static void dibujarVertices(Graphics g, List<Vertice> listaVertices)
   {      
      for(Vertice vertice:listaVertices)
      {
         ((Graphics2D)g).setColor(Color.white);
         ((Graphics2D)g).drawOval(vertice.getX(), vertice.getY(), 10, 10);
         ((Graphics2D)g).fillOval(vertice.getX(), vertice.getY(), 10, 10);
      }
   }
   
   public static void dibujarAristas(Graphics g, List<Vertice> listaVertices)
   {
      for (Vertice v:listaVertices)
      {
         for (Arista a:v.getAristas())
         {
            ((Graphics2D)g).setStroke(new BasicStroke(2));
            ((Graphics2D)g).setColor(Color.GRAY);
            ((Graphics2D)g).drawLine(a.getOrigen().getX() + 5, a.getOrigen().getY() + 5, a.getDestino().getX() + 5, a.getDestino().getY() + 5);
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
