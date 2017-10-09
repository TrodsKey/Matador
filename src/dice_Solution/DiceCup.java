/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dice_Solution;

/**
 * Raflebaeger med to vilkaarlige terninger.
 * @author erso
 */
public class DiceCup {

    private Die d1;
    private Die d2;
    private int eyes1; // Husker sidste kast
    private int eyes2;

    public DiceCup(int size) {
        d1 = new Die(size);
        d2 = new Die(size);
    }

    public int throwCup() {
        eyes1 = d1.throwDie();
        eyes2 = d2.throwDie();
        return eyes1 + eyes2;
    }

    // Tjek for 2 ens
    public boolean isEqual() {
        return eyes1 == eyes2;  
    }

    @Override
    public String toString() {
        return "DiceCup{" + "eyes1=" + eyes1 + ", eyes2=" + eyes2 + " equal? " + isEqual();
    }

    /**
     * @param args the command line arguments
     */
    
    //ruller terningerne 12 gange
    public static void main(String[] args) {
        // TODO code application logic here
        DiceCup cup = new DiceCup(6);
        for (int i = 0; i < 12; i++) {   // Slaar tolv gange
            System.out.print("" + cup.throwCup());
            System.out.println("\t" + cup);  // Kalder automatisk toString() metoden
        }
    }

}
