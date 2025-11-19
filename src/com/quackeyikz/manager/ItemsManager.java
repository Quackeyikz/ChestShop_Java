package com.quackeyikz.manager;

import com.quackeyikz.item.Item;
import com.quackeyikz.interfaces.DataManager;
import java.sql.*;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class ItemsManager implements DataManager<Item> {
        /*public ItemsManager(){
                this.up();
        }*/
        
        public void commands(String args[]){
                if(args.length > 1 && !args[1].isEmpty()){
                        switch(args[1]){
                                case "up":
                                        this.up();
                                        break;
                                case "down":
                                        this.down();
                                        break;
                        }
                }       
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
}
