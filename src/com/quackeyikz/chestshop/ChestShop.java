package com.quackeyikz.chestshop;

import com.quackeyikz.item.Item;

public class ChestShop {
        private String name;
        private Item item;
        private int count;
        private int price;
        private String ownerName;
        private boolean isSelling;
        
        public ChestShop(String name, String ownerName){
                this(name, null, 0, 0, ownerName);
        }
        
        public ChestShop(String name, Item item, int count, int price, String owner){
                this.name = name;
                this.item = item;
                this.setCount(count);
                this.setPrice(price);
                this.ownerName = owner;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public Item getItem() {
                return item;
        }

        public void setItem(Item item) {
                this.item = item;
        }

        public int getCount() {
                return count;
        }

        public void setCount(int count) {
                this.count = count < 0 ? 0 : count;
        }

        public int getPrice() {
                return price;
        }

        public void setPrice(int price) {
                this.price = price < 0 ? 0 : price;
        }

        public String getOwnerName() {
                return ownerName;
        }

        public void setOwnerName(String ownerName) {
                this.ownerName = ownerName;
        }

        public boolean isIsSelling() {
                return isSelling;
        }

        public void toggleSell() {
                if(this.isSelling == true) {
                        this.isSelling = false;
                        System.out.println(this.getName() + " is now NOT selling.");
                }
                else {
                        this.isSelling = true;
                        System.out.println(this.getName() + " is now selling.");
                }
        }
}
