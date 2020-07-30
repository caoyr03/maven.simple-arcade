package com.github.curriculeon.arcade.slots;

import com.github.curriculeon.arcade.ArcadeAccount;
import com.github.curriculeon.arcade.PlayerInterface;
import com.github.curriculeon.utils.IOConsole;
import com.github.curriculeon.utils.AnsiColor;
import java.util.*;

/**
 * Created by leon on 7/21/2020.
 */
public class SlotsPlayer implements PlayerInterface<SlotsGame> {
    private static final IOConsole console = new IOConsole(AnsiColor.YELLOW);
    private ArcadeAccount arcadeAccount;
    public enum Reel { //An enum is a special "class" that represents a group of constants (unchangeable variables, like final variables).
        CHERRY(500),
        LEMON(750),
        SEVEN(1000),
        DIAMOND(9999);

        private final Integer value; //define a final field, to assign the field value in constructor
        Reel(int value) {
            this.value = value;
        }
    }
    Reel[] ReelArray = Reel.values(); //get enum.values() as an array
    Reel[] reels;

    public SlotsPlayer(ArcadeAccount arcadeAccount){
        this.arcadeAccount = arcadeAccount;
    }

    @Override
    public ArcadeAccount getArcadeAccount() {
        return arcadeAccount;
    }

    private Reel spinReel(){
        List<Reel> ReelList = Arrays.asList(ReelArray); //convert array to a list
        Collections.shuffle(ReelList); //shuffle the values in a list
        return ReelList.get(0); //return the first from the list
    }

    private Reel[] slotsReel(){
        Reel[] results = new Reel[3];
        results[0] = spinReel();
        results[1] = spinReel();
        results[2] = spinReel();
        return results;
    }

    @Override
    public void play(SlotsGame slotsGame, String userInput) {
        if("pull-lever".equals(userInput)){
            reels = slotsReel();
        }
        else if("view-slot-reel".equals(userInput)){
            if(reels != null) {
                console.println("ReelImage 1 =" + reels[0]);
                console.println("ReelImage 2 =" + reels[1]);
                console.println("ReelImage 3 =" + reels[2]);
            }
            else console.println("You have to pull the lever first!");
        }
        else {
            console.println("This is not a valid input!");
            play(slotsGame, userInput); //iteratively call this method again
        }

    }
}