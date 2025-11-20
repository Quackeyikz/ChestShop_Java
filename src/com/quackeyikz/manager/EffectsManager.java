package com.quackeyikz.manager;

import static com.quackeyikz.Main.enchantmentsList;
import com.quackeyikz.interfaces.DataManager;
import com.quackeyikz.effect.Effect;
import java.sql.*;
import java.util.List;
import java.util.Scanner;

public class EffectsManager implements DataManager<Effect> {
        @Override
        public Effect commands(String args[], List<Effect> effectsList){
                Scanner sc = new Scanner(System.in);
                
                if(args.length > 1 && !args[1].isEmpty()){
                        switch(args[1]){
                                case "create":
                                        System.out.print("Enter effect name: ");
                                        String name = sc.nextLine();
                                        System.out.print("Enter effect tier: ");
                                        int tier = Integer.parseInt(sc.nextLine());
                                        System.out.print("Enter effect description: ");
                                        String desc = sc.nextLine();
                                        System.out.print("Enter effect type (Buff/Debuff): ");
                                        String type = sc.nextLine();
                                        
                                        effectsList.add(new Effect(name, tier, type, desc));
                                        System.out.println("[Effect] Successfully added a new effect!");
                                        break;
                                case "list":
                                        System.out.println("=========== EFFECTS LIST ==========");
                                        for(Effect e : effectsList){
                                                System.out.println("- [" + e.getName() + " " + e.getTier() + "] (Type: " + e.getType() + ")");
                                                System.out.println("   " + e.getDescription());
                                        }
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
                        "CREATE TABLE IF NOT EXISTS effects ("+
                        "id SERIAL PRIMARY KEY NOT NULL,"+
                        "effect_name VARCHAR(255)," +
                        "effect_tier INT," +
                        "effect_description TEXT," +
                        "effect_type VARCHAR(10), "+
                        "effect_exp_cost INT," +
                        "item_id INT,"+
                        "CONSTRAINT fk_item FOREIGN KEY (item_id) REFERENCES items(id) ON DELETE CASCADE"+
                        ")";
                
                try (Connection conn = DBConnection.getConnection();
                        Statement stmt = conn.createStatement()){
                        
                        stmt.execute(CREATE_TABLE);
                        
                        System.out.println("\u001B[33m[DB]\u001B[0m Creating effects table");
                }
                catch(SQLException e){
                        e.printStackTrace();
                }
        }
        
        @Override
        public void down(){
                final String DROP_TABLE = "DROP TABLE IF EXISTS effects CASCADE";
                
                try {
                        Connection conn = DBConnection.getConnection();
                        Statement stmt = conn.createStatement();
                        stmt.execute(DROP_TABLE);
                        
                        System.out.println("\u001B[31m[DB] \u001B[0mDELETING effects table and its contents");
                }
                catch (SQLException e) {
                        e.printStackTrace();
                }
        }
        
        @Override
        public void insert(Effect eff){}
        
        @Override
        public void delete(Effect eff){}
        
        @Override
        public Effect find(String name){
                return null;
        }
        
        public void help(){
                System.out.println("\n+-------- Effects Help -------+");
                System.out.println("/effect\t\tto show this help window");
                System.out.println("/effect create\tcreate a new effect");
                System.out.println("/effect list\tlist all of the created effect");
                System.out.println("/effect up\t\tcreate the 'effects' table in database");
                System.out.println("/effect down\tdrop the 'effects' table in database\n");
        }
}
