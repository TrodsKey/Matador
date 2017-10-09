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
public class StreetField extends OwnableField {

    //public Player currentOwner = this.getOwner();

    public StreetField(String name, int number, int price) {
        super(name, number);
        super.setPrice(price);
    }

    @Override
    public void consequence(Player player) {
        if ((super.getOwner() == null) && (player.getMoney() >= super.getPrice())) {
            super.setOwner(player);
            player.setMoney(super.getPrice()*-1);
            System.out.println(super.getOwner().getName() + " has bought "+ super.getName());
        } 
        else if (player != super.getOwner() && (super.getOwner() != null)) {
            int payment = super.getPrice();
            player.setMoney(payment*-1);
            super.getOwner().setMoney(payment);
            System.out.println(super.getOwner().getMoney() + " " + player.getMoney());
        } 
        else if (player == super.getOwner()) {
            System.out.println(super.getOwner().getName() + " already owns this field.");
        }
        else {
            System.out.println(player.getName() + " can't afford " + player.getName() + ".");
        }
    }
}
