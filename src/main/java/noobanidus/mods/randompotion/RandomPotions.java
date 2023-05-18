package noobanidus.mods.randompotion;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import noobanidus.mods.randompotion.init.ModLoot;

@Mod("randompotion")
public class RandomPotions {
  public static final String MODID = "randompotion";

  public RandomPotions() {
    IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
    ModLoot.registration(modBus);
  }
}
