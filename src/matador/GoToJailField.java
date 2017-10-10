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
public class GoToJailField implements FieldInterface {

    private String name;
    private int number;
    private final FieldInterface jailField = Matador.fields[10]; 

    public GoToJailField(String name, int number) {
        this.name = name;
        this.number = number;
    }

    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void consequence(Player player) {
        player.inJail = true;
        player.movePlayer(jailField);
    }
    @Override
    public String toString() {
        return "Du står på felt nr " + number + ": " + name;
    }
}
