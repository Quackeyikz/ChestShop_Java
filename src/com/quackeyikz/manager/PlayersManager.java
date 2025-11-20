package com.quackeyikz.manager;

import com.quackeyikz.interfaces.DataManager;
import com.quackeyikz.player.Player;
import java.sql.*;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class PlayersManager implements DataManager<Player> {
        @Override
        public Player commands(String args[], List<Player> playersList){
                if(args.length > 1 && !args[1].isEmpty()){
                        switch(args[1]){
                                case "":
                                        break;
                                default:
                                        help();
                        }
                } else {
                        help();
                }
                
                return null;
        }
        
        @Override
        public void up(){}
        
        @Override
        public void down(){
                final String DROP_TABLE = "DROP TABLE IF EXISTS players";
                
                try {
                        Connection conn = DBConnection.getConnection();
                        Statement stmt = conn.createStatement();
                        stmt.execute(DROP_TABLE);
                        System.out.println("\u001B[31m[DB] \u001B[0mDELETING players table and its contents");
                }
                catch (SQLException e){
                        e.printStackTrace();
                }
        }
        
        @Override
        public void insert(Player player){
        
        }
        
        @Override
        public void delete(Player player){
        
        }
        
        @Override
        public Player find(String s){
                return null;
        }
        
        public void help(){
                System.out.println("\n");
        }
}
