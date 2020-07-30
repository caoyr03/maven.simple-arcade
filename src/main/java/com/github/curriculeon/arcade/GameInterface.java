package com.github.curriculeon.arcade;

/**
 * Created by leon on 7/21/2020.
 */
public interface GameInterface extends Runnable {//Runnable interface is the primary template for any object that is intended to be executed by a thread. It defines a single method run(), which is meant to contain the code that is executed by the thread.
    /**
     * adds a player to the game
     * @param player the player to be removed from the game
     */
    void add(PlayerInterface player);

    /**
     * removes a player from the game
     * @param player the player to be removed from the game
     */
    void remove(PlayerInterface player);

    /**
     * specifies how the game will run
     */
    void run();
}
