package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner sc = new Scanner(System.in);
        int fighterHP = 100;
        int monsterHP = 100;

        do {
            System.out.print("== Fighter's turn == Press enter to hurt the monster");
            sc.nextLine();
            int damageF = 0;
            int damageM = 0;
            int again = 0;
            int attack;
            do {
                attack = (int)(Math.random()*6+1);
                System.out.println("The value of the throw: " + attack);
                if (attack != 1){
                    damageF += attack;
                    System.out.println("Your full points in this turn: " + damageF);
                    System.out.print("Do you want to throw again? (1:Yes, 0:No) ");
                    again = sc.nextInt();
                }else {
                    System.out.print("You fell, you made no demage.");
                    damageF = 0;
                }
            }while (attack != 1 && again != 0);
            System.out.println("Your full points in this turn: " + damageF + ", Monster HP: " + (monsterHP-=damageF));

            System.out.print("\n== Monster's turn ==");
            sc.nextLine();
            for (int i = 0; i<3; i++){
                attack = (int)(Math.random()*6+1);
                damageM += attack;
            }
            System.out.println("\nThe monster's full points in this turn: " + damageM + ", Fighter HP: " + (fighterHP-=damageM) + "\n");
        }while (fighterHP > 0 && monsterHP > 0);

        if (fighterHP > monsterHP){
            System.out.println("The fighter won!");
        }else {
            System.out.println("The monster won!");
        }
    }
}
