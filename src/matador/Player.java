/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matador;

import dice_Solution.DiceCup;

/**
 *
 * @author Alex og Sille
 */
public class Player {

    private String name;
    private FieldInterface currentField;
    private int rounds;
    private int money;
    private int ownedShips = 0;
    private int latestMove;

    public int getLatestMove() {
        return latestMove;
    }

    public void setLatestMove(int latestMove) {
        this.latestMove = latestMove;
    }

    public int getOwnedShips() {
        return ownedShips;
    }

    public void addShips() {
        this.ownedShips ++;
    }
    public boolean inJail = false;

    public void setRounds(int round) {
        this.rounds += round;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money += money;
    }

    public Player(String name, FieldInterface currentField) {
        this.name = name;
        this.currentField = currentField;
        this.money = 10000;
    }

    public int getField(int numberOfMoves) {
        this.setLatestMove(numberOfMoves);
        int newField;
        int numberOfTries = 3;
        if (inJail) {
            
            if (latestMove == 7) {
                inJail = false;
                System.out.println(this.getName() + " er ude af fængsel");
                return newField = this.currentField.getNumber() + numberOfMoves;
                
            }/* else if (numberOfTries>0)
            {
                numberOfTries --;
                Matador.cup.throwCup();
            }*/else {
                System.out.println(this.getName() + " er i fængsel");
                return newField = this.currentField.getNumber();
            }
        } else {
            return newField = this.currentField.getNumber() + numberOfMoves;
        }
    }

    public String getName() {
        return name;
    }

    public void movePlayer(FieldInterface newField) {
        this.currentField = newField;
    }

    @Override
    public String toString() {
        return "Player{" + "name=" + name + ", currentField=" + currentField + ", rounds played= " + rounds + " money=" + money +  '}';
    }

    /*public int move(DiceCup cup) {
        //this.currentField = cup;
        return 0;
    }*/
}
