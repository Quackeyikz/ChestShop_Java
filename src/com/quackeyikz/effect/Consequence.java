package com.quackeyikz.effect;

public class Consequence {
        private String name;
        private int tier;
        private String description;
        
        public Consequence(String name){
                this(name, 1, "");
        }
        
        public Consequence(String name, int tier){
                this(name, tier, "");
        }

        public Consequence(String name, int tier, String description) {
                this.name = name;
                this.setTier(tier);
                this.description = description;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }
        
        public int getTier(){
                return this.tier;
        }

        public void setTier(int tier){
                this.tier = tier < 0 ? 1 : tier;
        }
        
        public String getDescription() {
                return description;
        }

        public void setDescription(String description) {
                this.description = description;
        }
}
