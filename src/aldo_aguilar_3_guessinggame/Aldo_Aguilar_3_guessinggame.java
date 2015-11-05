/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aldo_aguilar_3_guessinggame;

import java.util.Random;
import java.util.Scanner;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author aguilara42
 */
public class Aldo_Aguilar_3_guessinggame extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    
    static Scanner sc = new Scanner(System.in);
    static Random rand = new Random();
    static String name;
    static boolean playTheGame = true;
    static int wins = 0; 
    static int lose = 0; 
    static int chance = 5;
    
    public static void main(String[] args) {
        System.out.println("Welcome to the guessing game you have 5 attempts guess a number from 1-10");
        System.out.println("You need to guess right 3 times to win. Hit enter to start the game.");
        sc.nextLine();
        
        System.out.println("   ");
        System.out.println("What is your name?");
        name = sc.nextLine();
       
        while(playTheGame){
            playGame();
            if (wins == 3){
                playTheGame = false;
                System.out.println("You won the game good job.");
            }
            else if(lose == 5){
                playTheGame = false;
                System.out.println("You lost the game 'good' job.");
            }
        } 
    }
    
    static void playGame(){
        
        System.out.println("    ");
        System.out.println(name +  " Guess a number from 0 - 10");
        int number = sc.nextInt();
        
        int i = rand.nextInt(11);
        
        if(number == i){
        System.out.println("Correct plus 1 point.");
        System.out.println("You have " + chance + " guesses left." );
        wins++;
        chance--;
        }
        else if (number > i){
             int difference = number - i;
            System.out.println("Sorry you were " + difference + " off,the number was " + i);
            System.out.println("You have " + chance + " guesses left." );
            lose++;
            chance--;
        }
        else if (number < i){
            int diffrence1 = i - number;
            System.out.println("You have " + chance + " guesses left." );
            System.out.println("Sorry you were " + diffrence1 + " off,the number was " + i);
            lose++;
            chance--;
        }
}
    
}
