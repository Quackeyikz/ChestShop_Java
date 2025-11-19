import java.util.Scanner;

/*
 Total hours spent: 7 hours
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

                // Player & item	
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
        }

        public static void mainCommands(String input) {
                String args[] = input.split(" ");
                String cmd = args[0];
                
                switch(cmd){
                        case "/tutorial":
                        case "/help":
                                tutorial();
                                break;
                        case "/chestshop":
                                chestShopCommands(args);
                                break;
                        case "/player":
                                playerCommands(args);
                                break;
                        case "/item":
                                itemCommands(args);
                                break;
                        default:
                                System.out.println(RED + "   Invalid commands. Please refer to /help for available commands." + RESET);
                }
        }
        
        public static void chestShopCommands(String args[]){
                // TEST
                if(args[1] != null){
                        switch(args[1]){
                                case "info":
                                        System.out.println("\n\u001B[1m\u001B[33mChestShop:\u001B[0m A Java terminal program that simulates ChestShop Plugin by Acrobot\n inside a terminal with Minecraft-like command execution. This program is made\n by Quackeyikz or also known as Eyyikz. The program is not advertised, \nnot publicly distributed in plugin website, and for educational purpose only.\n");
                                        break;
                                case "create":
                                        break;
                                case "remove":
                                        break;
                                case "search":
                                        break;
                                case "list":
                                        break;
                                case "buy":
                                        break;
                                case "sell":
                                        break;
                                default:
                        }
                }       
        }
        
        public static void playerCommands(String args[]){
        
        }
        
        public static void itemCommands(String args[]){
        
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
                for (String s : msg) {
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
                System.out.println("/item\t\tManage items.\n");
        }
        
        public static void tutorialChestShop(){
                System.out.println("+-------- Chest Shop -------+");
                System.out.println("/chestshop\t\tTo show this info panel.");
                System.out.println("/chestshop info\t\tProvide the information about ChestShop.");
                System.out.println("/chestshop create\t\tCreating a new chest shop.");
                System.out.println("/chestshop remove [item]\t\tRemove your own shop that sells the item.");
                System.out.println("/chestshop search [item]\t\tWill list all the shop that sells the specific item.");
                System.out.println("/chestshop list\t\tWill list all the available shop owned by players.");
                System.out.println("/chestshop buy [item] [player]\t\tBuy item from a specific player to keep it in the inventory.");
                System.out.println("/chestshop sell [item]\t\tSell the item to an existing shop, or create a new one.");
        }

        public static void delay(int time) {
                try {
                        Thread.sleep(time);
                } catch (Exception e) {
                        e.printStackTrace();
                }
        }
}
