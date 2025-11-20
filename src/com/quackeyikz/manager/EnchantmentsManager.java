package com.quackeyikz.manager;

import com.quackeyikz.effect.Enchantment;
import com.quackeyikz.interfaces.DataManager;
import java.sql.*;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class EnchantmentsManager implements DataManager<Enchantment> {
        public Enchantment commands(String args[], List<Enchantment> enchantmentsList){
                Scanner sc = new Scanner(System.in);
                
                /* ATT LIST
                private String name;
                private int tier;
                private String description;
                private int expCost;
                */
                
                if(args.length > 1 && !args[1].isEmpty()){
                        switch(args[1]){
                                case "create":
                                        try {
                                                System.out.print("Enter enchantment name: ");
                                                String eName = sc.nextLine();
                                                System.out.print("Enter enchantment tier: ");
                                                int eTier = Integer.parseInt(sc.nextLine());
                                                System.out.print("Enter enchantment description: ");
                                                String eDescription = sc.nextLine();
                                                System.out.print("Enter enchantment exp cost (Default: 1): ");
                                                int expCost = Integer.parseInt(sc.nextLine());

                                                enchantmentsList.add(new Enchantment(eName, eTier, expCost, eDescription));
                                                System.out.println("[Enchantment] Successfully added a new enchantment!");
                                        }
                                        catch (Exception e){
                                                e.printStackTrace();
                                        }
                                        break;
                                case "list":
                                        System.out.println("=========== ENCHANTMENTS LIST ==========");
                                        for(Enchantment e : enchantmentsList){
                                                System.out.println("- [" + e.getName() + " " + e.getTier() + "] (Cost: " + e.getExpCost() + ")");
                                                System.out.println("   " + e.getDescription());
                                        }
                                        break;
                                case "up":
                                        up();
                                        break;
                                case "down":
                                        down();
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
                        "CREATE TABLE IF NOT EXISTS enchantments(" +
                        "id SERIAL PRIMARY KEY NOT NULL," +
                        "name VARCHAR(255) NOT NULL," +
                        "tier INT DEFAULT 1," +
                        "exp_cost INT DEFAULT 1," +
                        "description TEXT," +
                        "item_id INT," +
                        "CONSTRAINT fk_item FOREIGN KEY (item_id) REFERENCES item(id) ON DELETE CASCADE" +
                        ")";
                
                /*
                final String INSERT_SQL =
                        "INSERT INTO enchantments (name, tier, exp_cost, description, item_id) VALUES (?, ?, ?, ?, ?)";
                        
                List<Enchantment> initialEnchantments = create_initial_enchantments();
                */
                
                try {
                        Connection conn = DBConnection.getConnection();
                        
//                        try (Statement stmt = conn.createStatement()){
                                Statement stmt = conn.createStatement();
                                stmt.execute(CREATE_TABLE);
                                System.out.println("\u001B[34m[DB] \u001B[0mCreating enchantments table... \u001B[32mSUCCESS\u001B[0m");
                        /*
                        }
                        
                        try {
                                PreparedStatement pstmt = conn.prepareStatement(INSERT_SQL);
                                System.out.println("\u001B[34m[Storage] \u001B[0mInserting data into enchantments table...");
                                
                                for(Enchantment e : initialEnchantments){
                                        pstmt.setString(1, e.getName());
                                        pstmt.setInt(2, e.getTier());
                                        pstmt.setInt(3, e.getExpCost());
                                        pstmt.setString(4, e.getDescription());
                                        
                                        pstmt.addBatch();
                                }
                                
                                pstmt.executeBatch();
                                System.out.println("\u001B[34m[Storage] \u001B[0mSuccessfully inserting data into enchantments table...");
                                
                        } catch (SQLException e) {
                                e.printStackTrace();
                        }
                        */
                } catch (SQLException e) {
                        e.printStackTrace();
                }
        }
        
        @Override
        public void down(){
                final String DROP_TABLE = "DROP TABLE IF EXISTS enchantments";
                
                try {
                        Connection conn = DBConnection.getConnection();
                        Statement stmt = conn.createStatement();
                        stmt.execute(DROP_TABLE);
                        System.out.println("\u001B[31m[DB] \u001B[0mDELETING enchantments table and its contents");
                }
                catch (SQLException e){
                        e.printStackTrace();
                }
        }
        
        @Override
        public void insert(Enchantment enchantment){
        
        }
        
        @Override
        public void delete(Enchantment enchantment){
        
        }
        
        @Override
        public Enchantment find(String s){
                return null;
        }
        
        // Bruh I won't even use this why did I even make it.
        public List<Enchantment> create_initial_enchantments(){
                return Arrays.asList(
                        new Enchantment("Efficiency", 1, 1, "Giving tools more speed to gather its respective block"),
                        new Enchantment("Efficiency", 2, 1, "Giving tools more speed to gather its respective block"),
                        new Enchantment("Efficiency", 3, 2, "Giving tools more speed to gather its respective block"),
                        new Enchantment("Efficiency", 4, 2, "Giving tools more speed to gather its respective block"),
                        new Enchantment("Efficiency", 5, 3, "Giving tools more speed to gather its respective block"),
                        new Enchantment("Unbreaking", 1, 1,"Adds more durability to the tools or armor"),
                        new Enchantment("Unbreaking", 2, 2,"Adds more durability to the tools or armor"),
                        new Enchantment("Unbreaking", 3, 3,"Adds more durability to the tools or armor"),
                        new Enchantment("Mending", 1, 2,"Grants the item the ability to repair itself using xp point whenever it is holded or used"),
                        new Enchantment("Aqua Affinity", 1, 1,"Increases the rate of underwater mining speed"),
                        new Enchantment("Bane of Arthropods", 1, 1,"Increases damage and applies Slowness IV to arthropod mobs"),
                        new Enchantment("Bane of Arthropods", 2, 1,"Increases damage and applies Slowness IV to arthropod mobs"),
                        new Enchantment("Bane of Arthropods", 3, 2,"Increases damage and applies Slowness IV to arthropod mobs"),
                        new Enchantment("Bane of Arthropods", 4, 2,"Increases damage and applies Slowness IV to arthropod mobs"),
                        new Enchantment("Feather Falling", 1, 1,"Reduces fall damages"),
                        new Enchantment("Feather Falling", 2, 2,"Reduces fall damages"),
                        new Enchantment("Feather Falling", 3, 3,"Reduces fall damages"),
                        new Enchantment("Feather Falling", 4, 4,"Reduces fall damages"),
                        new Enchantment("Fortune", 1, 2,"Increases certain item drop chances from blocks"),
                        new Enchantment("Fortune", 2, 3,"Increases certain item drop chances from blocks"),
                        new Enchantment("Fortune", 3, 4,"Increases certain item drop chances from blocks"),
                        new Enchantment("Frost Walker", 1, 3,"Changes the water source blocks beneath the player into frosted ice and prevents damage from standing on magma blocks"),
                        new Enchantment("Frost Walker", 2, 4,"Changes the water source blocks beneath the player into frosted ice and prevents damage from standing on magma blocks"),
                        new Enchantment("Knockback", 1, 1,"Increases attack knockback"),
                        new Enchantment("Knockback", 2, 1,"Increases attack knockback"),
                        new Enchantment("Looting", 1, 2,"Increases the amount of loot earned from mob"),
                        new Enchantment("Looting", 2, 5,"Increases the amount of loot earned from mob"),
                        new Enchantment("Looting", 3, 7,"Increases the amount of loot earned from mob"),
                        new Enchantment("Power", 1, 2,"Increases arrow damage"),
                        new Enchantment("Power", 2, 4,"Increases arrow damage"),
                        new Enchantment("Power", 3, 6,"Increases arrow damage"),
                        new Enchantment("Power", 4, 7,"Increases arrow damage"),
                        new Enchantment("Power", 5, 9,"Increases arrow damage"),
                        new Enchantment("Protection", 1, 2,"Reduces most types of damage by four percents for each level"),
                        new Enchantment("Protection", 2, 3,"Reduces most types of damage by four percents for each level"),
                        new Enchantment("Protection", 3, 5,"Reduces most types of damage by four percents for each level"),
                        new Enchantment("Protection", 4, 7,"Reduces most types of damage by four percents for each level"),
                        new Enchantment("Respiration", 1, 1,"Increases breathing time while underwater"),
                        new Enchantment("Respiration", 2, 3,"Increases breathing time while underwater"),
                        new Enchantment("Respiration", 3, 5,"Increases breathing time while underwater")
                );
        }
        
        public void help(){
                System.out.println("\n+-------- Enchantment Help -------+");
                System.out.println("/enchantment\t\tto show this help window");
                System.out.println("/enchantment create\tcreate a new enchantment");
                System.out.println("/enchantment list\tlist all of the created enchantment");
                System.out.println("/enchantment up\t\tcreate the 'enchantments' table in database");
                System.out.println("/enchantment down\tdrop the 'enchantments' table in database\n");
        }
}
