package com.quackeyikz.item;

public class Item {
        private String name;
        private String type;
        private int stackSize;
//        private boolean sellable = true;
        
        public Item(String name){
                this(name, "default", 64);
        }
        
        public Item(String name, String type){
                this(name, type, 64);
        }
        
        public Item(String name, String type, int stackSize){
                this.name = name;
                this.type = type;
                this.stackSize = stackSize;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }
        
        public String getType() {
                return type;
        }

        public void setType(String type) {
                this.type = type;
        }

        public int getStackSize() {
                return stackSize;
        }

        public void setStackSize(int stackSize) {
                this.stackSize = stackSize;
        }
        
        /*
        public boolean isSellable(){
                return this.sellable;
        }
        
        public void toggleSellable(){
                if(this.sellable == true){
                        this.sellable = false;
                        System.out.println(this.getName() + " is now \u001B[31mNOT sellable. \u001B[30m");
                } else {
                        this.sellable = true;
                        System.out.println(this.getName() + " is now \u001B[32msellable. \u001B[30m");
                }
                
        }
        */
}
