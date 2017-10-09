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
public abstract class OwnableField implements FieldInterface {

    private String name;
    private int number; //mellem 0 og 39
    private int price;
    private Player owner;

    public OwnableField(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    @Override
    public abstract void consequence(Player player);

    @Override
    public String toString() {
        return "Du står på felt nr " + number + ": " + name + " den koster "+price;
    }
}
