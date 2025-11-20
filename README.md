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

![UML](http://www.plantuml.com/plantuml/uml/hLXRRzis57xtho3ovCnsazxsO6n6Sp6636uJn0w6eXi2Mc9iBXBbYbGpjsj--qXH4WylYhHbBuR9S_zupk6Xtd61Sr6aoO3VKxR3EKvHb63EJuJ8wReGv2BAs99-9UXuiAKnGH7DeuGC1YKNEjiIBfRRR8U-3H2QC9oIALfAKRPHQof8EaKNybUjegnWOeee4sgrosb4cbNsm4Z-mHNdIv8aSZ55wonB26PgTo9_HetX8RGvHfwUmwUuZNzZPBmR8-DRfT7IjY52MHWU0bz7lDg41YJ3bup6bOmoesGgE9H4kMMSiFdFb4DAG4Ea-FMMyTGMk59Usm9wouHZ2rpMO7cX68eFg551-KLzGag3EQEHo3QRX2ZQiER_tkHCnZZvN10MaN3M2Ae0hn8Z9ZpAwKxGZ44UdGH6autxKyGnQlJtvHkZW1VFIOMLr6mVLBbZ7BEupurnpn2aXPnqmP_VtP58QDp5VaSyJ3M33sTWNo84DFJZQeSoB6gEe9yM1Qvaz70gDortFMHOjCLCf8HLy92_TcSPDmrBmsEu0XYr4CT8wZ8Pryts14gjiW2gRZKIfhaEpqx3UXF63f2IAvBVOLcuvrZWzvZX3SbBj1wZB4qnY_aGruO-_I6Tcg85vUAdrKngMIc-OZSqsVqOo_O2rrJMOYw6Kcm5kKX2175txoYBXnoSvyfsyORZTQ9Rp6F1YT-8LCjjwK1EPSXRChfNjw2T36NxzhB0smtKIGVF6DaMdzLh_bKvQ9bbRTtE3hFjk1T2LlNL8ZL7GChwvbL2w6gVML0QYJ2eBNGNEcreMhMw9jsrUHMGuq2PznKrw2J01iTnrQSSAuQbDTL0FaxY8iThcb2nRpAAcCgUmcPaGQHrXE49q7faLK_9Dk_-ktNPd6mG_aTL7VwgExKHi5CSxBlkMHK2-_2XUrvbHW66LcSwikOzfgpCbz4t6R2WqNTqUhauhs50FwE3tulZuvUddrwc1nRRzNmvNmNuZZs-aBRNhhfVhkVp3o76LmxZn_bYSVbRYFErmtcwk9c7-DuuV5StrrUB8ETRX_FiuqdGnnyTFd0QN9LvNUncUoR56Nb09tcEzoLnDZoqTUW-0SLrh-YKLDC-b5C9tosrI_2Uv53kgjpfbepKquVBfmyKRjv3RVAwupHAKfc8GvnlkBdRGUvQR6Vr722VauK8N2_0CoowkHv88aSBSeePqpEpno4AaUKK9q6Y71tmNWxMQSjDrI31uJGpCjEC5VIu2qwflrcKPGsddP4pxOogQQVK2GIXX9vydk3mfY3BldpNvFkJnC96PU1ATTYRNOobyk3xSqkIdT-Gpa_b7SnadijvKbza3T2_IXgilZ_ZTJJToHboanF-EPaU7ILPX9EjcYhVlddzwgX1yZPU7rYgRfRpQwYgrc9pNPqibv2BxFVq_Yil3lpqBH_JjTygAhFgc-RE0wfdjhIsYSDwSEYT959LODYeyYDCB5F36GoDrV09WoxODyRkTkfVaFr2xhusw_YxERqwSJoASYABuPOoAcGlkOLHcPaHnDGEeQgadjW5BmFmYQWNJC7whO09qZmeQdFXUFHDqpEYrejAgjN_UiUbLTLYVcojT2y-O_Yf2Di_ON9uF4rxqLA1BugyGloPtmfDtjLsrVD3K_npbS6OZx4_J2RwKAlFFPF9tpFutMq0FtPuHEVrLj9BRGxXnGj9qCEwIyga0rMh0KyVMrErwMgfjbK8i4JBMJXhtTIscdLff5bLvz-ipHNfN_-bE-3hHf1brg5Y1j5lL-tHPtKWeJRiYmUPPXP2LZFoD3ZKocsdu3qfZpwh4QuAgJc1TuJ5HPhy0m)

Alternative Image:
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


### A Mind's Voice

I am still unsure what to make of this program, it has cool concept and everything. But in the end of the day, it's not very usable nor very useful for anyone, not even me. "Oh! I'm going to make my own tools with this program and i'll make sure it serves purpose in my life or other's life!". But yeah... It's not going to happen...

Honestly, I've been through a lot these several days. All that brilliant ideas is now obsolete, i could not realize that I, myself is incapable of doing this fully. So, after several troubles and tripping stone, I am back on track. Slowly, but surely.

~ Quackeyikz

## Credit
**Repository:** https://github.com/Quackeyikz/ChestShop_Java
Driver: https://jdbc.postgresql.org/