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
public class BreweryField extends OwnableField{
        public Player currentOwner = this.getOwner();
        private final int BREW_MULTIPLIER = 300;
    
    public BreweryField(String name, int number) {
        super(name, number);
        super.setPrice(500);
    }

    @Override
    public void consequence(Player player) {
        if ((super.getOwner() == null) && (player.getMoney() >= super.getPrice())) {
            super.setOwner(player);
            player.setMoney(super.getPrice()*-1);
            System.out.println(super.getOwner().getName() + " has bought "+ super.getName());
        } 
        else if (player != super.getOwner() && (super.getOwner() != null)) {
            int payment = player.getLatestMove()*BREW_MULTIPLIER;
            player.setMoney(payment*-1);
            super.getOwner().setMoney(payment);
            System.out.println(super.getOwner().getMoney() + " " + player.getMoney());
        } 
        else if (player == super.getOwner()) {
            System.out.println(super.getOwner().getName() + " already owns this field.");
        }
        else {
            System.out.println(player.getName() + " can't afford " + super.getName() + ".");
        }
    }
}
