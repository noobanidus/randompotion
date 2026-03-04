package noobanidus.mods.randompotion.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.storage.loot.functions.LootItemFunctionType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import noobanidus.mods.randompotion.RandomPotions;
import noobanidus.mods.randompotion.loot.functions.RandomPotionFunction;

public class ModLoot {
  private static final DeferredRegister<LootItemFunctionType<?>> FUNCTION_TYPES = DeferredRegister.create(Registries.LOOT_FUNCTION_TYPE, RandomPotions.MODID);

  public static final DeferredHolder<LootItemFunctionType<?>, LootItemFunctionType<RandomPotionFunction>> RANDOM_POTION = FUNCTION_TYPES.register("random_potion", () -> new LootItemFunctionType<>(RandomPotionFunction.CODEC));

  public static void register(IEventBus bus) {
    FUNCTION_TYPES.register(bus);
  }
}
