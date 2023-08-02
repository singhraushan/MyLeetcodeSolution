package com.rau.leetcode.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class RockPaperScissor {
    private Scanner console = new Scanner(System.in);

    public static void main(String[] args) {
        RockPaperScissor obj = new RockPaperScissor();
        obj.start();
        System.out.println("Thank you.");
    }

    public void start() {
        System.out.println("Enter 1 for: Player vs Computer\nEnter 2 for: Computer vs Computer\nEnter anything else to exit");
        PlayGame obj;
        switch (console.nextInt()) {
            case 1:
                obj = new playerVsComputerGame();
                break;
            case 2:
                obj = new ComputerVsComputerGame();
                break;
            default:
                System.out.println("Exiting.");
                return;
        }
        obj.playGame();
    }

}

abstract class PlayGame {
    protected Scanner console = new Scanner(System.in);
    protected int seedSize = 3;
    protected Random random = new Random();
    protected Map<Integer, String> numberMoveMap;

    protected abstract void playGame();

    protected String applyGameRule(int player1, int player2) {
        if (player1 == player2) {
            return "TIE";
        }
        if (player1 > player2) {
            return "WIN";
        }
        return "LOSE";
    }

    {
        numberMoveMap = getNumberMoveMap();
    }

    private Map<Integer, String> getNumberMoveMap() {
        Map<Integer, String> m = new HashMap<>();
        m.put(1, "ROCK");
        m.put(2, "PAPER");
        m.put(3, "SCISSOR");
        return m;
    }
}

class ComputerVsComputerGame extends PlayGame {
    protected void playGame() {
        do {
            int player1 = random.nextInt(seedSize) + 1;
            int player2 = random.nextInt(seedSize) + 1;
            System.out.println("Computer move: " + numberMoveMap.get(player1) + " and " + numberMoveMap.get(player2));
            String result = applyGameRule(player1, player2);
            System.out.println("Computer1 game result: " + result + "\nDo you want to play again? Y/N");

        } while (console.next().trim().equalsIgnoreCase("Y"));
    }
}

class playerVsComputerGame extends PlayGame {
    protected void playGame() {
        System.out.println("Enter R for: ROCK\nEnter P for: PAPER\nEnter S for: SCISSOR\nEnter anything else to quit");
        String pressedKey = console.next().trim().toUpperCase();
        Map<String, Integer> map = getKeywordIdentityMap();
        while (map.get(pressedKey) != null) {
            int computerInput = random.nextInt(seedSize) + 1;
            System.out.println("Computer input: " + numberMoveMap.get(computerInput));
            String result = applyGameRule(map.get(pressedKey), computerInput);
            System.out.println("Your game result: " + result + "\nDo you want to play again? Enter R/P/S for: ROCK/PAPER/SCISSOR respectively.Anything else to quit");
            pressedKey = console.next().trim().toUpperCase();
        }
    }

    private Map<String, Integer> getKeywordIdentityMap() {
        Map<String, Integer> m = new HashMap<>();
        m.put("R", 1);
        m.put("P", 2);
        m.put("S", 3);
        return m;
    }
}