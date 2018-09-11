package com.example;

public class Application {

    public static void main(String [] args)
    {
        Game game = new Game();
        game.start();
        System.out.println(game.toString());
    }
}
