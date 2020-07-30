package com.github.curriculeon.arcade.slots;

import com.github.curriculeon.arcade.GameInterface;
import com.github.curriculeon.arcade.PlayerInterface;
import com.github.curriculeon.utils.AnsiColor;
import com.github.curriculeon.utils.IOConsole;
import com.sun.corba.se.impl.interceptors.SlotTableStack;

import java.util.*;

/**
 * Created by leon on 7/21/2020.
 */
public class SlotsGame implements GameInterface {
    private IOConsole console = new IOConsole(AnsiColor.GREEN);
    private List<PlayerInterface> playerList = new ArrayList<>();

    @Override
    public void add(PlayerInterface player) { //playerinterface will be converted to concrete class in run()
        console.println("Adding player %s to slots game", player.getArcadeAccount().getAccountName());
        playerList.add(player);
    }

    @Override
    public void remove(PlayerInterface player) {
        playerList.remove(player);
    }

    @Override
    public void run() {
        for(PlayerInterface playerInterface: playerList){
            String userInput;
            console.println("Welcome to the slots game.");
            do{
                SlotsPlayer slotsPlayer = (SlotsPlayer) playerInterface; //convert interface to its concrete class
                console.println("Please select any of the following options to continue:");
                userInput = console.getStringInput("pull-lever, view-slot-reel, quit");
                if(!userInput.equals("quit"))
                    slotsPlayer.play(this,userInput);
            }while(!userInput.equals("quit")); //go to next player
        }
    }
}
