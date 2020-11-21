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
   private final Vertice origen;
   private final Vertice destino;
   
   public Arista(Vertice origen, Vertice destino){
       this.origen = origen;
       this.destino = destino;
   }
   
   public Vertice getOrigen()
   {
      return origen;
   }

   public Vertice getDestino()
   {
      return destino;
   }
  
   public double getPeso()
   {
      return  Math.sqrt(Math.pow(origen.getXReal() - destino.getXReal(), 2) 
                      + Math.pow(origen.getYReal() - destino.getYReal(), 2));
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
