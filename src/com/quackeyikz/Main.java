package com.quackeyikz;

import com.quackeyikz.manager.*;
import java.util.Scanner;

/*
 Total hours spent: 12 hours
 */

public class Main {
        public static final String BOLD = "\u001B[1m";
        public static final String RESET = "\u001B[0m";
        public static final String RED = "\u001B[31m";
        public static final String GREEN = "\u001B[32m";
        public static final String YELLOW = "\u001B[33m";
        public static final String BLUE = "\u001B[34m";
        public static final String PURPLE = "\u001B[35m";
        public static final String CYAN = "\u001B[36m";

        public static void main(String args[]) {
                Scanner sc = new Scanner(System.in);
                String input = new String();

                welcomeBanner();

                do {
                        System.out.print("> ");
                        input = sc.nextLine();

                        if (input.charAt(0) != '/') {
                                chat(input);
                                continue;
                        }
                        
                        mainCommands(input);
                        
                } while (input != "/exit");

                sc.close();
        }

        public static void mainCommands(String input) {
                String args[] = input.split(" ");
                String cmd = args[0];
                
                EnchantmentsManager enchantsManager = new EnchantmentsManager();
                ItemsManager itemsManager = new ItemsManager();
                ChestShopsManager chsp = new ChestShopsManager();
                PlayersManager playersManager = new PlayersManager();
                
                switch(cmd){
                        case "/exit":
                                System.exit(0);
                        case "/tutorial":
                        case "/help":
                                tutorial();
                                break;
                        case "/chestshop":
                                chsp.commands(args);
                                break;
                        case "/player":
                                playersManager.commands(args);
                                break;
                        case "/item":
                                itemsManager.commands(args);
                                break;
                        case "/enchantments":
                                enchantsManager.commands(args);
                                break;
                        default:
                                System.out.println(RED + "   Invalid commands. Please refer to /help for available commands." + RESET);
                }
        }
 
        public static void chat(String input) {
                System.out.println("\n[You] " + input);
                delay(1000);

                // me say hi to u <3
                String eyyikz = "[Eyyikz] ";
                double eyyikzChat = Math.random();

                if (eyyikzChat < 0.3) {
                        System.out.println(eyyikz + "Heya! How are you?\n");
                } else if (eyyikzChat < 0.6) {
                        System.out.println(eyyikz + "Just want to let you know tha I am doing just fine!\n");
                } else if (eyyikzChat < 0.9) {
                        System.out.println(eyyikz + "What do you think about this program so far?\n");
                } else {
                        System.out.println(eyyikz + "Be honest, were you typing the wrong command or you're just happy to chat with me?\n");
                }

                delay(1000);
        }

        public static void welcomeBanner() {
                String welcome = new String("Welcome to ChestShop!");
                String intro = new String("Minecraft inspired command-line program that simulate");
                String trade = new String("player shop creation using an object (chest) with sellable");
                String items = new String("items, automatic & manual price definition.");
                String me = new String("Made with passion, Quackeyikz");

                String msg[] = {welcome, intro, trade, items, me};

                System.out.println(YELLOW + "+=--------------------------------------------------------------=+");
                for (String s : msg)
                {
                        int padding = (65 - s.length()) / 2;
                        System.out.printf("%" + padding + "s%-" + s.length() + "s%" + padding + "s\n", " ", s, " ");
                }
                System.out.println("+=--------------------------------------------------------------=+\n" + RESET);

                tutorial();
        }

        public static void tutorial() {
                System.out.println("+--------- Basic Commands (Global) --------+");
                System.out.println("/tutorial\tTo show this tutorial message.");
                System.out.println("/exit\t\tTo exit the program.");
                System.out.println("/chestshop\tCheck all the available commands of ChestShop.");
                System.out.println("/player\t\tManage available users.");
                System.out.println("/item\t\tManage items.");
                System.out.println("/enchantments\t\tManage enchanting effects.\n");
        }
        
        public static void delay(int time) {
                try {
                        Thread.sleep(time);
                } catch (Exception e) {
                        e.printStackTrace();
                }
        }
}
