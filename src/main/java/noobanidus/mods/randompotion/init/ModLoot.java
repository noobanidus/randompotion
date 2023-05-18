package noobanidus.mods.randompotion.init;

import net.minecraft.core.Registry;
import net.minecraft.world.level.storage.loot.functions.LootItemFunctionType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import noobanidus.mods.randompotion.RandomPotions;
import noobanidus.mods.randompotion.loot.functions.RandomPotionFunction;

public class ModLoot {
  private static final DeferredRegister<LootItemFunctionType> FUNCTIONS = DeferredRegister.create(Registry.LOOT_FUNCTION_REGISTRY, RandomPotions.MODID);

  public static final RegistryObject<LootItemFunctionType> RANDOM_POTION = FUNCTIONS.register("random_potion", () -> new LootItemFunctionType(new RandomPotionFunction.Serializer()));

  public static void registration(IEventBus bus) {
    FUNCTIONS.register(bus);
  }
}
