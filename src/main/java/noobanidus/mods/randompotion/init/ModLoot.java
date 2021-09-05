package noobanidus.mods.randompotion.init;

import net.minecraft.loot.LootFunctionType;
import net.minecraft.util.registry.Registry;
import noobanidus.libs.noobutil.registry.ConfiguredRegistry;
import noobanidus.mods.randompotion.RandomPotions;
import noobanidus.mods.randompotion.loot.functions.RandomPotion;

public class ModLoot {
  public static final ConfiguredRegistry<LootFunctionType> FUNCTION_REGISTRY = new ConfiguredRegistry<>(RandomPotions.MODID, Registry.LOOT_FUNCTION_TYPE);

  public static final LootFunctionType RANDOM_POTION = FUNCTION_REGISTRY.register("random_potion", new LootFunctionType(new RandomPotion.Serializer()));

  public static void load() {
  }
}
