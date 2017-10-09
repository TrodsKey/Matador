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
public class Field {

    private String name;
    private int number; //mellem 0 og 39
    
    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }
    
    public Field(String name, int number){
        this.name = name;
        this.number = number;
    }

    @Override
    public String toString() {
        return "Du står på felt nr " + number + ": " + name;
    }
    
    
}

