package com.quackeyikz.item;

import com.quackeyikz.effect.Effect;
import com.quackeyikz.interfaces.Usable;
import java.util.List;

public class ItemConsumable extends Item implements Usable {
        List<Effect> effects;
        
        public ItemConsumable(String name){
                this(name, "Unclassified Consumable Item", new Effect("saturation", 1, "buff", "Regenerate hunger points for player"));
        }
        
        public ItemConsumable(String name, String type, Effect effect){
                super(name, type);
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
