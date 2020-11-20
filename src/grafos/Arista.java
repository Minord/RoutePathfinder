/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

/**
 *
 * @author criss
 */
public class Arista {
   private Vertice origen;
   private Vertice destino;
   private double peso; //inesesario
   
   public Arista(Vertice origen, Vertice destino){
       this.origen = origen;
       this.destino = destino;
   }
   
   public Arista(Vertice origen, Vertice destino, double peso)
   {
      this.origen = origen;
      this.destino = destino;
      this.peso = peso;
   }
   
   public Vertice getOrigen()
   {
      return origen;
   }

   public Vertice getDestino()
   {
      return destino;
   }

   public void setPeso(double peso) //Inesesario
   {
      this.peso = peso;
   }
  
   public double getPeso()
   {
      return  Math.sqrt(Math.pow(origen.getX() - destino.getX(), 2) 
                      + Math.pow(origen.getY() - destino.getY(), 2));
   }
   
   public int getSegundoVertice(int primerVerticeId){
        if (destino.getId() != primerVerticeId){
            return destino.getId();
        }
        else if(origen.getId() != primerVerticeId){
            return origen.getId();
        }
        return -1;
    }
}
