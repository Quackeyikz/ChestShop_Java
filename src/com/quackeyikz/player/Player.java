package com.quackeyikz.player;

import com.quackeyikz.item.Item;
import java.util.List;

public class Player {
        private String name;
        private List<Item> items;

        public Player(String name, Item items) {
                this.name = name;
                this.items.add(items);
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public List<Item> getItems() {
                return items;
        }

        public void addItems(Item item) {
                this.items.add(item);
        }
}
