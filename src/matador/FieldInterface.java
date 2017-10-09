/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matador;

/**
 *
 * @author Alex og Sille
 */
public interface FieldInterface {
    
     public abstract String getName();

    public abstract int getNumber();
    
    public abstract void consequence(Player player);
}
