package com.quackeyikz.effect;

public class Effect extends Consequence {
        private String type;
        
        public Effect(String name){
                super(name, 1, "");
                this.type = "buff";
        }
        
        public Effect(String name, String type){
                super(name, 1, "");
                this.type = type;
        }
        
        public Effect(String name, String type, String description){
                super(name, 1, description);
                this.type = type;
        }
        
        public Effect(String name, int tier, String type, String description){
                super(name, tier, description);
                this.type = type;
        }

        public String getType() {
                return type;
        }

        public void setType(String type) {
                this.type = type;
        }
}
