# RandomPotion

Provides a function that can convert a potion into a potion randomly. Use: `randompotion:random_potion` as your item function on an item that can have a potion applied to it.

You can blacklist specific potion types by adding them to the `c:random_potion_blacklist` tag.

# Example

Here is an example for 1.20:

```json
{
  "type": "minecraft:chest",
  "pools": [
    {
      "bonus_rolls": 0.0,
      "entries": [
        {
          "type": "minecraft:item",
          "functions": [
            {
              "add": false,
              "count": 1.0,
              "function": "minecraft:set_count"
            },
            {
              "function": "randompotion:random_potion"
            }
          ],
          "name": "minecraft:potion"
        }
      ],
      "rolls": 1.0
    }
  ],
  "random_sequence": "randompotion:test_loot_table"
}
```