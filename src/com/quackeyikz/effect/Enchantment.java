package com.quackeyikz.effect;

public class Enchantment extends Consequence {
        private int expCost;
        
        public Enchantment(String name){
                super(name, 1, "");
                this.setExpCost(1);
        }
        
        public Enchantment(String name, int exp){
                super(name, 1, "");
                this.setExpCost(exp);
        }
        
        public Enchantment(String name, int exp, String description){
                super(name, 1, description);
                this.setExpCost(exp);
        }
        
        public Enchantment(String name, int tier, int exp, String description){
                super(name, tier, description);
                this.setExpCost(exp);
        }

        public int getExpCost() {
                return expCost;
        }

        public void setExpCost(int expCost) {
                this.expCost = expCost < 0 ? 1 : expCost;
        }
}
