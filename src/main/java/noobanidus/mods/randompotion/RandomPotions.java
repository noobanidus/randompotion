package noobanidus.mods.randompotion;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import noobanidus.mods.randompotion.gen.LootTableGenerator;
import noobanidus.mods.randompotion.gen.PotionTagGenerator;
import noobanidus.mods.randompotion.init.ModLoot;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("randompotion")
public class RandomPotions {

  public static final Logger LOG = LogManager.getLogger();
  public static final String MODID = "randompotion";

  public RandomPotions(ModContainer container, IEventBus modBus) {
    modBus.addListener(this::onDataGen);

    ModLoot.register(modBus);
  }

  public void onDataGen(GatherDataEvent event) {
    event.getGenerator().addProvider(event.includeServer(), new PotionTagGenerator(event.getGenerator()
        .getPackOutput(), event.getLookupProvider()));
    event.getGenerator()
        .addProvider(event.includeDev(), LootTableGenerator.create(event.getLookupProvider(), event.getGenerator().getPackOutput()));
  }
}
