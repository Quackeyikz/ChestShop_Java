package com.quackeyikz.manager;

import com.quackeyikz.chestshop.ChestShop;
import com.quackeyikz.interfaces.DataManager;
import com.quackeyikz.item.Item;
import com.quackeyikz.item.ItemUsable;
import java.sql.*;

public class ChestShopsManager implements DataManager<ChestShop> {
        /*public ChestShopsManager(){
                this.up();
        }*/
        
        @Override
        public void commands(String args[]){
                if(args.length > 1 && !args[1].isEmpty()){
                        switch(args[1]){
                                case "info":
                                        System.out.println(
                                                "\n\u001B[1m\u001B[33mChestShop:" +
                                                "\u001B[0m A Java terminal program that simulates ChestShop Plugin by Acrobot\n" + 
                                                "inside a terminal with Minecraft-like command execution. This program is made\n" + 
                                                "by Quackeyikz or also known as Eyyikz. The program is not advertised, \n" + 
                                                "not publicly distributed in plugin website, and for educational purpose only.\n"
                                        );
                                        break;
                                case "create":
                                        try {
                                                ChestShop cs = new ChestShop(args[2], new Item(args[3]), Integer.parseInt(args[4]), Integer.parseInt(args[5]), args[6]);
                                                this.insert(cs);
                                                System.out.println("\u001B[33m[ChestShop]\u001B[0m Successfully created a shop!");
                                        }
                                        catch (Exception e) {
                                                System.out.println("/chestshop create [shop name] [item] [count] [price] [owner's name]");
                                        }
                                        break;
                                case "remove":
                                        break;
                                case "search":
                                        break;
                                case "list":
                                        this.queryAll();
                                        break;
                                case "up":
                                        this.up();
                                        break;
                                case "down":
                                        this.down();
                                        break;
                                default:
                                        help();
                        }
                } else {
                        help();
                }       
        }
        
        @Override
        public void up(){
                final String CREATE_TABLE =
                        "CREATE TABLE IF NOT EXISTS chestshops (" +
                        "id SERIAL PRIMARY KEY NOT NULL," +
                        "shop_name VARCHAR(255)," +
                        "item_count INT DEFAULT 0, " +
                        "item_price INT DEFAULT 0," +
                        "owner_name VARCHAR(255)," +
                        "is_selling BOOLEAN DEFAULT TRUE NOT NULL" +
                        ")";
                
                try {
                        Connection conn = DBConnection.getConnection();
                        Statement stmt = conn.createStatement();
                        stmt.execute(CREATE_TABLE);
                        
                        System.out.println("\u001B[34m[DB] \u001B[0mCreating chestshops table... \u001B[32mSUCCESS\u001B[0m");
                } 
                catch (SQLException e) {
                        e.printStackTrace();
                }
        }
        
        @Override
        public void down(){
                final String DROP_TABLE = "DROP TABLE IF EXISTS chestshops CASCADE";
                
                try (Connection conn = DBConnection.getConnection();
                        Statement stmt = conn.createStatement();) {
                        
                        stmt.execute(DROP_TABLE);
                        System.out.println("\u001B[31m[DB] \u001B[0mDELETING table and its contents");
                }
                catch (SQLException e){
                        e.printStackTrace();
                }
        }
        
        @Override
        public void insert(ChestShop chest){
                final String INSERT_SQL = "INSERT INTO chestshops (shop_name, item_count, item_price, owner_name) VALUES (?, ?, ?, ?)";
                
                try (Connection conn = DBConnection.getConnection();
                        PreparedStatement pstmt = conn.prepareStatement(INSERT_SQL)) {
                        
                        pstmt.setString(1, chest.getName());
                        pstmt.setInt(2, chest.getCount());
                        pstmt.setInt(3, chest.getPrice());
                        pstmt.setString(4, chest.getOwnerName());
                        
                        int rowAffected = pstmt.executeUpdate();
                        System.out.println("\u001B[32m[DB] \u001B[0mInserting the data into the table");
                        
                        if (rowAffected == 0) {
                                throw new SQLException("Inserting item failed, no rows affected.");
                        }
                        
                        int newChestShopId;
                        
                        try (ResultSet newKeys = pstmt.getGeneratedKeys()){
                                if(newKeys.next())
                                        newChestShopId = newKeys.getInt(1);
                                else
                                        throw new SQLException("No Id obtained");
                        }
                        
                        String INSERT_ITEM = "INSERT INTO items (item_name, type, stack_size, durability, chestshop_id) VALUES (?, ?, ?, ?, ?)";
                        
                        PreparedStatement pstmt2 = conn.prepareStatement(INSERT_ITEM);
                        
                        pstmt2.setString(1, chest.getItem().getName());
                        pstmt2.setString(2, chest.getItem().getType());
                        pstmt2.setInt(3, chest.getItem().getStackSize());
                        if(chest.getItem() instanceof ItemUsable)
                                pstmt2.setInt(4, ((ItemUsable) chest.getItem()).getDurability());
                        else
                                pstmt2.setInt(4, 150);
                        pstmt2.setInt(5, newChestShopId);
                        
                        pstmt2.executeUpdate();
                        System.out.println("\u001B[32m[DB] \u001B[0mInserting the data into the item");
                        
                } catch (SQLException e) {
                        e.printStackTrace();
                }
        }
        
        @Override
        public void delete(ChestShop chest){
                final String DELETE_SQL = "DELETE FROM chestshops WHERE shop_name=? AND owner_name=?";
                
                try (Connection conn = DBConnection.getConnection();
                        PreparedStatement pstmt = conn.prepareStatement(DELETE_SQL);) {
                        
                        pstmt.setString(1, chest.getName());
                        pstmt.setString(2, chest.getOwnerName());
                        
                        pstmt.executeUpdate();
                        System.out.println("\u001B[31m[DB] \u001B[0mDeleting the data from the table");
                        
                } catch (SQLException e) {
                        e.printStackTrace();
                }
        }
        
        @Override
        public ChestShop find(String s){
                return null;
        }
        
        public void queryAll(){
                final String QUERY_SQL = 
                        "SELECT * FROM chestshops c " + 
                        "LEFT JOIN items i ON c.id=i.chestshop_id ";
//                        "LEFT JOIN enchantments en ON i.id=e.item_id " +
//                        "LEFT JOIN effects ef ON i.id=ef.item_id";
                
                try (Connection conn = DBConnection.getConnection();
                        Statement stmt = conn.createStatement()){
                        
                        ResultSet rs = stmt.executeQuery(QUERY_SQL);
                        
                        System.out.printf("%20sSHOP LIST%20s\n", " ", " ");
                        System.out.printf("\n%-20s | %-15s[%s] | %-5s | %-5s | %s\n", "Shop Name", "Item", "[Effect]", "Count", "Price", "Owner");
                        while(rs.next()){
//                                String effect = rs.getString("effect_name") == null ? rs.getString("enchant_name") : rs.getString("effect_name");
//                                effect = effect == null ? "No Effect" : effect;
                                
                                System.out.printf("%-20s |", rs.getString("shop_name"));
                                System.out.printf(" %-15s[%6s] |", rs.getString("item_name"), " ");
                                System.out.printf(" %-5s |", rs.getInt("item_count"));
                                System.out.printf(" %-5s |", rs.getInt("item_price"));
                                System.out.printf(" %s\n\n", rs.getString("owner_name"));
                        }
                        
                } catch (SQLException e) {
                        e.printStackTrace();
                }
        }
        
        public void itemTableUpdate(Item item){
                
        }
        
        public void help(){
                System.out.println("\n+-------- Chest Shop -------+");
                System.out.println("/chestshop\t\tTo show this info panel.");
                System.out.println("/chestshop info\t\tProvide the information about ChestShop.");
                System.out.println("/chestshop create \t\tCreating a new chest shop.");
                System.out.println("/chestshop remove [item]\t\tRemove your own shop that sells the item.");
                System.out.println("/chestshop search [item]\t\tWill list all the shop that sells the specific item.");
                System.out.println("/chestshop list\t\tWill list all the available shop owned by players.");
        }
}
