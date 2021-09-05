package noobanidus.mods.randompotion;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import noobanidus.libs.noobutil.registrate.CustomRegistrate;
import noobanidus.mods.randompotion.gen.PotionTagGenerator;
import noobanidus.mods.randompotion.init.ModLoot;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("randompotion")
public class RandomPotions {

  public static final Logger LOG = LogManager.getLogger();
  public static final String MODID = "randompotion";

  public static CustomRegistrate REGISTRATE;

  public RandomPotions() {
/*    ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ConfigManager.COMMON_CONFIG);
    ConfigManager.loadConfig(ConfigManager.COMMON_CONFIG, FMLPaths.CONFIGDIR.get().resolve(MODID + "-common.toml"));*/

    IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
    modBus.addListener(this::onDataGen);

    ModLoot.load();
  }

  public void onDataGen(GatherDataEvent event) {
    if (event.includeServer()) {
      ModLoot.load();
      ModLoot.FUNCTION_REGISTRY.registration();
      event.getGenerator().addProvider(new PotionTagGenerator(event.getGenerator(), event.getExistingFileHelper()));
    }
  }
}
