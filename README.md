![WelcomeBanner](./WelcomeBanner.png)

# ChestShop

**Disclaimer:** The program is still in development, so it won't be finished at demo-day. I apologize.  

**TL:DR** Unga Bunga
- "ChestShop" contains items, it sells them. One ChestShop, one item.
- "Item" has three forms, but all have names, some even have Enchantment or Effect.
- "Player" is actor, they have money, they buy, they keep the items.

## Flow
1. Run the program
2. /chestshop up
3. /item up
4. /chestshop create [shopName] [Item] [count] [price] [owner]
5. /chestshop list
6. /item create
7. /item list
8. /item create
9. /item list
10. /enchantment create
11. /enchantment list
12. /effect create
13. /effect list

## Class List

[Alternative Image](./UML_Diagram.png):
![UML](./UML_Diagram.png)


| Class Name | Package |
|---|---|
| Usable			| interfaces |
| DataManager		| interfaces |
| DBConnection      | manager |
| ItemsManager      | manager |
| PlayersManager	| manager |
| EffectsManager    | manager |
| EnchantmentsMan.  | manager |
| ChestShopsManager | manager |
| Item              | item | 
| ItemUsable        | item |
| ItemConsumable	| item |
| Effect			| effect |
| Enchantment		| effect |
| Consequence		| effect |
| ChestShop		    | chestshop |
| Player            | player |


**Relation List:**
- Composition:  ItemUsable -> Enchantment
                ChestShop -> Item
- PLS refer to the UML diagram instead.
                


### A Mind's Voice

I am still unsure what to make of this program, it has cool concept and everything. But in the end of the day, it's not very usable nor very useful for anyone, not even me. "Oh! I'm going to make my own tools with this program and i'll make sure it serves purpose in my life or other's life!". But yeah... It's not going to happen...

Honestly, I've been through a lot these several days. All that brilliant ideas is now obsolete, i could not realize that I, myself is incapable of doing this fully. So, after several troubles and tripping stone, I am back on track. Slowly, but surely.

~ Quackeyikz

## Credit
**Repository:** https://github.com/Quackeyikz/ChestShop_Java
Driver: https://jdbc.postgresql.org/