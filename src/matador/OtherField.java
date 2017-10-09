/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matador;

import java.util.Random;

/**
 *
 * @author Alex og Sille
 */
public class OtherField implements FieldInterface {

    private String name;
    private int number;

    public OtherField(String name, int number) {
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
        System.out.println("You have have landed on chance");
       /* Random ranGen = new Random();

        int ranNum = ranGen.nextInt(4);
        switch (ranNum) {
            case 0:
                System.out.println("Go to start");
                player.movePlayer(Matador.fields[0]);
                //tilføj penge
                break;
            case 1:
                System.out.println("Go back 3 spaces");
                int nextField = player.getField(-3);
                player.movePlayer(Matador.fields[nextField]);
                break;
            case 2:
                System.out.println("Placeholder");
                break;
            case 3:
                System.out.println("Placeholder");
                break;
            default:
                System.out.println("Blank card");
                break;
        }*/
    }

}
