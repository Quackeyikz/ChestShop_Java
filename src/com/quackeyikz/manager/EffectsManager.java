package com.quackeyikz.manager;

import com.quackeyikz.interfaces.DataManager;
import com.quackeyikz.effect.Effect;
import java.sql.*;
import java.util.Arrays;
import java.util.List;

public class EffectsManager implements DataManager<Effect> {
        @Override
        public void commands(String args[]){ }
        
        @Override
        public void up(){}
        
        @Override
        public void down(){
                final String DROP_TABLE = "DROP TABLE IF EXISTS effects";
                
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
}
