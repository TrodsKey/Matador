/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matador;

import dice_Solution.DiceCup;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
//import dice_solution.*;
import java.util.Arrays;

/**
 *
 * @author Alex og Sille
 */
public class Matador {

    public static DiceCup cup;
    private FieldInterface testFelt;
    public static FieldInterface[] fields = new FieldInterface[40];
    public Scanner scan = new Scanner(System.in);
    public Player player1;
    public Player player2;
    public static boolean gameWon = false;
    private int fieldAmount = 39;
    private final int START_MONEY = 2000;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        //DiceCup cup = new DiceCup(6);
        new Matador().buildGame();

//        FieldInterface testFelt = new FieldInterface("Vejringevej", 32);
//        System.out.println(testFelt.toString());
//        
    }

    public void buildGame() {
        cup = new DiceCup(6);
        createBoard();
        declarePlayer();
        startRound();
    }

    /*public void createBoard() {
        String[] fieldNames = {"Start", "Rødovrevej", "Prøv lykken", "Hvidovrevej", "Indkomstskat", "Øresund A/S",
            "Roskildevej", "?", "Valby Langgade", "Allégade", "Fængsel", "Frederiksberg Allé", "Tuborg",
            "Büllowsvej", "Gl. Kongevej", "D.F.D.S A/S", "Bernstorffsvej", "?", "Hellerupvej", "Strandvejen",
            "Parkering", "Trianglen", "?", "Østerbrogade", "Grønningen", "Ø.K. A/S", "Bredgade",
            "Kgs Nytorv", "Carlsberg", "Østergade", "Gå i Fængsel!", "Amagertorv", "Vimmelskaftet", "?", "Nygade",
            "D/S Bornholm 1866", "?", "Frederiksberg Allé", "Statsskat", "Rådhuspladsen"};

        for (int i = 0; i < 40; i++) {
            fields[i] = new Field(fieldNames[i], i);
            System.out.println(fields[i]);
        }
    }*/
    public void createBoard() {

        String fileName = "fieldNames.txt";
        Scanner inputStream = null;
        System.out.println("The file " + fileName + " contains: ");
        try {
            inputStream = new Scanner(new File(fileName));
            for (int i = 0; i < fields.length; i++) {

                String line = inputStream.nextLine();
                String[] columns = line.split(",");
                String place = columns[0];
                int price = 0;
                if (columns.length > 1) {
                    price = Integer.parseInt(columns[1]);
                };
                //System.out.println(line);
                //System.out.println("what is in this flle: the place " + place + " it's price " + price);
                switch (i) {
                    // Andre felter:
                    case 0:
                        fields[i] = new StartField(place, i);
                        break;
                    case 2:
                    case 4:
                    case 7:
                    case 10:
                    case 17:
                    case 20:
                    case 22:
                    case 33:
                    case 36:
                    case 38:
                        fields[i] = new OtherField(place, i);
                        break;
// Gå i spjældet:
                    case 30:
                        fields[i] = new GoToJailField(place, i);
                        break;
// Rederier:
                    case 5:
                    case 15:
                    case 25:
                    case 35:
                        fields[i] = new ShipField(place, i);
                        break;
//Bryggerier:
                    case 12:
                    case 28:
                        fields[i] = new BreweryField(place, i);
                        break;
// Her er dice en parameter, da betaling afhænger af antal øjne der er slået plate[i] = new Brewery(dice, MonopolyConstants.FIELD_NAMES[i], i+1, 150); break;
// Gader:
                    default:
                        fields[i] = new StreetField(place, i, price);
                        break;
// Afgift for at lande på feltet og pris for at købe feltet er her simuleret
// med hhv 3*i og 10*i. I er velkomne til at finde på noget smartere. plate[i] = new StreetField(3*i, MonopolyConstants.FIELD_NAMES[i], i+1, 10*i); }

                }
            }
            inputStream.close();
        } catch (FileNotFoundException e) {
            System.out.println("Can't find file " + fileName);
            //System.exit(0);
        }
        /*catch (IOException e) {
            System.out.println("Problem with input from file " + fileName);
        }*/
        inputStream.close();

    }

    public void declarePlayer() {

        /*for (int i = 0; i < playerCount; i++) {
            p
        }*/
        player1 = new Player("Adena", fields[0]);
        player2 = new Player("Jacob", fields[0]);
        System.out.println(player1.toString());
        System.out.println(player2.toString());
        fields[30].consequence(player1);
    }

    public void rollPlayer1() {
        int roll = cup.throwCup();
        int newField = player1.getField(roll);
        System.out.println("Player 1 rolled " + roll);
        if (newField > fieldAmount) {
            newField = newField - fieldAmount;
            System.out.println("You past the Start point");
            player1.setMoney(START_MONEY);
            player1.setRounds(1);
            //gameWon = true;
        }
        player1.movePlayer(fields[newField]);
        fields[newField].consequence(player1);
        System.out.println("" + player1);
    }

    public void rollPlayer2() {
        int roll = cup.throwCup();
        int newField = player2.getField(roll);
        System.out.println("Player 2 rolled " + roll);
        if (newField > fieldAmount) {
            newField = newField - fieldAmount;
            System.out.println("You past the Start point");
            player2.setMoney(START_MONEY);
            player2.setRounds(1);
            //gameWon = true;
        }
        player2.movePlayer(fields[newField]);
        fields[newField].consequence(player2);
        System.out.println("" + player2);
    }

    public void startRound() {
        while (!gameWon) {
            rollPlayer1();
            rollPlayer2();
        }

    }
}
