package com.company;

import java.util.ArrayList;
import java.util.List;


public class Club extends Player{

    String cname;
    List <Player> players = new ArrayList<>() ;

    public List<Player> getPlayers() {
        return players;
    }

    public void addPlayer() {

        Player temp = new Player();
        temp.setName(Input.addString("\nEnter Name of Player : "));
        temp.setAge(Input.addInteger("Enter Age of Player : "));
        this.players.add(temp);
    }


    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public  String toString(){
        String s = this.players.toString() + " " + this.cname;
        return s;
    }
}
