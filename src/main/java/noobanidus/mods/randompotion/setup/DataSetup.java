package noobanidus.mods.randompotion.setup;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;
import noobanidus.mods.randompotion.RandomPotions;
import noobanidus.mods.randompotion.gen.PotionTagGenerator;

@Mod.EventBusSubscriber(modid = RandomPotions.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataSetup {
  @SubscribeEvent
  public static void onDataGen(GatherDataEvent event) {
    if (event.includeServer()) {
      event.getGenerator().addProvider(new PotionTagGenerator(event.getGenerator(), event.getExistingFileHelper()));
    }
  }
}
