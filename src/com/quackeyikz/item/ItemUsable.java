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
                this(name, "Unclassified Usable Item", 150, null);
        }
        
        public ItemUsable(String name, String type){
                this(name, type, 150, null);
        }
        
        public ItemUsable(String name, String type, Enchantment enchantment){
                this(name, type, 150, enchantment);
        }
        
        public ItemUsable(String name, String type, int durability, Enchantment enchantment){
                super(name, type);
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