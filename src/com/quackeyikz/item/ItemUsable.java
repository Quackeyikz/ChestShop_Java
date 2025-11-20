package com.quackeyikz.item;

import com.quackeyikz.effect.Enchantment;
import com.quackeyikz.interfaces.Usable;
/*
 * @author Quackeyikz a.k.a Eyyikz
 */
public class ItemUsable extends Item implements Usable {
        private int durability;
        private Enchantment enchantment;
        
        public ItemUsable(String name){
                this(name, "Unclassified Usable Item", 1, 150, null);
        }
        
        public ItemUsable(String name, String type, int stackSize){
                this(name, type, 1, 150, null);
        }
        
        public ItemUsable(String name, String type, Enchantment enchantment){
                this(name, type, 1, 150, enchantment);
        }
        
        public ItemUsable(String name, String type, int stackSize, int durability){
                this(name, type, stackSize, durability, null);
        }
        
        public ItemUsable(String name, String type, int stackSize, int durability, Enchantment enchantment){
                super(name, type, stackSize);
                this.setDurability(durability);
                this.setEnchantment(enchantment);
        }

        public int getDurability() {
                return durability;
        }

        public void setDurability(int durability) {
                this.durability = durability < 0 ? 1 : durability;
        }

        public Enchantment getEnchantment() {
                return enchantment;
        }

        public void setEnchantment(Enchantment enchantment) {
                this.enchantment = enchantment;
        }
        
        @Override
        public void use(){
                System.out.println("Item use");
        }
}