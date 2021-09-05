package noobanidus.mods.randompotion.setup;

import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import noobanidus.mods.randompotion.init.ModLoot;

@SuppressWarnings("deprecation")
public class CommonSetup {
  public static void init(FMLCommonSetupEvent event) {
    event.enqueueWork(() -> {
      ModLoot.FUNCTION_REGISTRY.registration();
    });
  }
}
