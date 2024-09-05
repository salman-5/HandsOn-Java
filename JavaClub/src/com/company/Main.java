package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static Club createClub() {
        Club club = new Club();
        int n;
        try {
            club.setCname(Input.addString("Enter Name of Club : "));
            n = Input.addInteger("Number of players : ");
            for (int i = 0; i < n; i++) {
                club.addPlayer();
            }
        } catch (NumberFormatException e) {
            System.out.println("Input Positive integer!!!");
        }
        return club;

    }
    public static void editClubName(List<Club> clubs){

        for (Club c:clubs) {
            if(c.cname.equalsIgnoreCase(Input.addString("\nEnter name of club to edit : "))){
            c.setCname(Input.addString("Enter new name of club : "));
            return;
            }
        }
        System.out.println("Club  not found !!");
        return;
    }

    public static void display(List<Club> clubs) {

        System.out.printf("\n%-10s \t %-10s\t %-10s%n", "Club name", "Player name", "Player age");
        System.out.println("-------------------------------------------------------");
        for (Club c : clubs) {
            for (Player p : c.players) {
                System.out.printf("%-10s \t %-10s\t %-10s%n", c.cname, p.name, p.age);
            }
        }
    }

    public static void main(String[] args) {

        int n;
        List<Club> clubs = new ArrayList<>();

        while (true) {
            try {
                System.out.println("\n1. Create Club\t 2. Edit Club Name\t 3. Display all details");
                n = Input.addInteger("Enter a choice(1/2/3) other key to exit : ");
                switch (n) {
                    case 1:
                        clubs.add(createClub());
                        break;
                        case 2:Main.editClubName(clubs);
                            break;
                    case 3:
                        Main.display(clubs);
                        break;
                    default:
                        break;
                }
            }
            catch (NumberFormatException e) {
                break;
            }
        }
    }
}
