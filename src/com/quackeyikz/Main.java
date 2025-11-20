package com.quackeyikz;

import com.quackeyikz.chestshop.ChestShop;
import com.quackeyikz.effect.*;
import com.quackeyikz.item.*;
import com.quackeyikz.manager.*;
import com.quackeyikz.player.Player;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

/*
 Total hours spent: 14 hours
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
        public static List<Enchantment> enchantmentsList = new ArrayList<>();
        public static List<Effect> effectsList = new ArrayList<>();
        public static List<Item> itemsList = new ArrayList<>();
//        public static List<ItemUsable> itemsUsableList = new ArrayList<>();
//        public static List<ItemConsumable> itemsConsumableList = new ArrayList<>();
        public static List<Player> playersList = new ArrayList<>();
        public static List<ChestShop> chestshopsList = new ArrayList<>();

        public static void main(String args[]) {
                Scanner in = new Scanner(System.in);
                String input = new String();

                welcomeBanner();

                do {
                        System.out.print("> ");
                        input = in.nextLine();

                        if (input.charAt(0) != '/') {
                                chat(input);
                                continue;
                        }
                        
                        mainCommands(input);
                        
                } while (!input.equalsIgnoreCase("/exit"));

                in.close();
        }

        public static void mainCommands(String input) {
                String args[] = input.split(" ");
                String cmd = args[0];
                
                EnchantmentsManager enchantsManager = new EnchantmentsManager();
                EffectsManager effectsManager = new EffectsManager();
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
                                chsp.commands(args, chestshopsList);
//                                ChestShop csTemp = chsp.commands(args, chestshopsList);
                                /* Already handled at /chestshop create
                                if(csTemp != null){
                                        chestshopsList.add(csTemp);
                                        System.out.println("[List] Successfully created chestshop!");
                                }
                                */
                                break;
                        case "/player":
                                playersManager.commands(args, playersList);
                                /*
                                Player plTemp = playersManager.commands(args, playersList);
                                if(plTemp != null){
                                        playersList.add(plTemp);
                                        System.out.println("[List] Successfully created a player!");
                                }
                                */
                                break;
                        case "/item":
                                itemsManager.commands(args, itemsList);
                                /*
                                Item itemTemp = itemsManager.commands(args, itemsList);
                                if(itemTemp != null){
                                        if(itemTemp instanceof ItemUsable)
                                                itemsUsableList.add((ItemUsable) itemTemp);
                                        else if(itemTemp instanceof ItemConsumable)
                                                itemsConsumableList.add((ItemConsumable) itemTemp);
                                        else
                                                itemsList.add(itemTemp);
                                        
                                        System.out.println("[List] Successfully created an item!");
                                }
                                */
                                break;
                        case "/enchantment":
                                enchantsManager.commands(args, enchantmentsList);
                                /*
                                Enchantment enTemp = enchantsManager.commands(args, enchantmentsList);
                                if(enTemp != null){
                                        enchantmentsList.add(enTemp);
                                        System.out.println("[List] Successfully created an enchantment!");
                                }
                                */
                                break;
                        case "/effect":
                                effectsManager.commands(args, effectsList);
                                /*
                                Effect efTemp = effectsManager.commands(args);
                                if(efTemp != null){
                                        effectsList.add(efTemp);
                                        System.out.println("[List] Successfully created an effect");
                                }
                                */
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
                System.out.println("/enchantment\tManage enchanting effects.");
                System.out.println("/effect\t\tManage effects that could be applied.\n");
        }
        
        public static void delay(int time) {
                try {
                        Thread.sleep(time);
                } catch (Exception e) {
                        e.printStackTrace();
                }
        }
}
