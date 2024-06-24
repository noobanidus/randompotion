package noobanidus.mods.randompotion.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.storage.loot.functions.LootItemFunctionType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import noobanidus.mods.randompotion.RandomPotions;
import noobanidus.mods.randompotion.loot.functions.RandomPotionFunction;

public class ModLoot {
  private static final DeferredRegister<LootItemFunctionType> FUNCTION_TYPES = DeferredRegister.create(Registries.LOOT_FUNCTION_TYPE, RandomPotions.MODID);

  public static final RegistryObject<LootItemFunctionType> RANDOM_POTION = FUNCTION_TYPES.register("random_potion", () -> new LootItemFunctionType(new RandomPotionFunction.Serializer()));

  public static void register(IEventBus bus) {
    FUNCTION_TYPES.register(bus);
  }
}
