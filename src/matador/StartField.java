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
public class StartField implements FieldInterface {

    private String name;
    private int number;
    
    public StartField(String name, int number) {
        this.name = name;
        this.number = number;
    }
    
   @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getNumber() {
        return this.number;
    }
    
    @Override
    public String toString() {
        return "Du står på felt nr " + number + ": " + name;
    }

    @Override
    public void consequence(Player player) {
        //you landed on start
    }
}
