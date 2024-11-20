package com.example.feigndemo.functional_interface;

public class FunctionalInterfaceTest {

    @FunctionalInterface
    public interface FeelingLucky {
        void gamble();
        static void hitJackpot() {
            System.out.println("You have won 80M dollars.");
        }

        default void playGame() {
            System.out.println("Playing game...");
        }


    }
}
