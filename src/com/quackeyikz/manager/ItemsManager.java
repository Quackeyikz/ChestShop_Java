package com.quackeyikz.manager;

import static com.quackeyikz.Main.enchantmentsList;
import com.quackeyikz.effect.*;
import com.quackeyikz.item.*;
import com.quackeyikz.interfaces.DataManager;
import java.sql.*;
import java.util.List;
import java.util.Scanner;

public class ItemsManager implements DataManager<Item> {
        /*public ItemsManager(){
                this.up();
        }*/
        
        public Item commands(String args[], List<Item> itemsList){
                Scanner sc = new Scanner(System.in);
                // add instance type for usable or consumable, diffentiate by /item create
                if(args.length > 1 && !args[1].isEmpty()){
                        switch(args[1]){
                                case "create":
                                        try {
                                                System.out.print("Enter item name: ");
                                                String name = sc.nextLine();
                                                System.out.print("Enter item type (default | usable | consumable): ");
                                                String type = sc.nextLine();

                                                int stackSize = 64;
                                                Enchantment enchant = null;

                                                if(type.equalsIgnoreCase("usable")){
                                                        System.out.print("Enter item stack size (default: 1): ");
                                                        stackSize = Integer.parseInt(sc.nextLine().isEmpty() ? "1" : sc.nextLine());

                                                        System.out.print("Enter item durability (default: 150): ");
                                                        int durability = Integer.parseInt(sc.nextLine().isEmpty() ? "150" : sc.nextLine());

                                                        System.out.print("Enter enchantment name & tier (enter to skip): ");
                                                        String findEnchant = sc.nextLine();

                                                        if(!findEnchant.isEmpty()){
                                                                String var[] = findEnchant.split(" ");
                                                                for(Enchantment e : enchantmentsList){
                                                                        boolean name_check = false;
                                                                        boolean tier_check = true;

                                                                        if(e.getName().equalsIgnoreCase(var[0]))
                                                                                name_check = true;

                                                                        if(var.length > 1 && !var[1].isEmpty()){
                                                                                if(e.getTier() == Integer.parseInt(var[1]))
                                                                                        tier_check = true;
                                                                        }

                                                                        if(name_check && tier_check)
                                                                                enchant = e;
                                                                }
                                                        }

                                                        itemsList.add(new ItemUsable(name, type, stackSize, durability, enchant));
                                                } else {
                                                        itemsList.add(new Item(name, type, stackSize));
                                                }

                                                System.out.println("[Item] Successfully added a new item!");
                                        }
                                        catch (Exception e){
                                                e.printStackTrace();
                                        }
                                        break;
                                case "list":
                                        System.out.println("=========== ITEMS LIST ==========");
                                        for(Item e : itemsList){
                                                System.out.println("- " + e.getName() + ", x" + e.getStackSize() + " (" + e.getType() + ")");
                                        }
                                        break;
                                case "up":
                                        this.up();
                                        break;
                                case "down":
                                        this.down();
                                        break;
                                default:
                                        this.help();
                        }
                } else
                        this.help();
                
                return null;
        }
        
        @Override
        public void up(){
                final String CREATE_TABLE =
                        "CREATE TABLE IF NOT EXISTS items (" +
                        "id SERIAL PRIMARY KEY NOT NULL," +
                        "item_name VARCHAR(255), " +
                        "type VARCHAR(255), " +
                        "stack_size INT, " +
                        "durability INT, " +
                        "chestshop_id INT, " +
                        "CONSTRAINT fk_cs FOREIGN KEY (chestshop_id) REFERENCES chestshops(id) ON DELETE CASCADE"+
                        ")";
                
                try {
                        Connection conn = DBConnection.getConnection();
                        Statement stmt = conn.createStatement();
                        stmt.execute(CREATE_TABLE);
                        
                        System.out.println("\u001B[34m[DB] \u001B[0mCreating items table... \u001B[32mSUCCESS\u001B[0m");
                } 
                catch (SQLException e) {
                        e.printStackTrace();
                }
        }
        
        @Override
        public void down(){
                final String DROP_TABLE = "DROP TABLE IF EXISTS items CASCADE";
                
                try {
                        Connection conn = DBConnection.getConnection();
                        Statement stmt = conn.createStatement();
                        stmt.execute(DROP_TABLE);
                        
                        System.out.println("\u001B[31m[DB] \u001B[0mDELETING items table and its contents");
                }
                catch (SQLException e) {
                        e.printStackTrace();
                }
        }
        
        @Override
        public void insert(Item item){
                final String INSERT_SQL = "INSERT INTO items (item_name, type, stack_size, durability, chestshop_id) VALUES (?, ?, ?, ?, ?)";
        }
        
        @Override
        public void delete(Item item){
        
        }
        
        @Override
        public Item find(String s){
                return null;
        }
        
        public void help(){
        
        }
}
