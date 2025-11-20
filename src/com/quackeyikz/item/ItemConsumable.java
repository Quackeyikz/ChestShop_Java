package com.quackeyikz.item;

import com.quackeyikz.effect.Effect;
import com.quackeyikz.interfaces.Usable;
import java.util.ArrayList;
import java.util.List;

public class ItemConsumable extends Item implements Usable {
        List<Effect> effects = new ArrayList<>();
        
        public ItemConsumable(String name){
                this(name, "buff", new Effect());
        }
        
        public ItemConsumable(String name, String type, Effect effect){
                this(name, type, 64, effect);
        }
        
        public ItemConsumable(String name, String type, int stackSize, Effect effect){
                super(name, type, stackSize);
                this.addEffect(effect);
        }

        public List<Effect> getEffects() {
                return effects;
        }

        public void setEffects(List<Effect> effects) {
                this.effects = effects;
        }
        
        public void addEffect(Effect effect){
                this.effects.add(effect);
        }
        
        @Override
        public void use(){
                System.out.println("Item use");
        }
}
