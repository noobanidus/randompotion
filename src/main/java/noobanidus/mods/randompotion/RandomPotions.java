package noobanidus.mods.randompotion;

import net.minecraft.DetectedVersion;
import net.minecraft.data.metadata.PackMetadataGenerator;
import net.minecraft.network.chat.Component;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.metadata.pack.PackMetadataSection;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import noobanidus.mods.randompotion.gen.LootTableGenerator;
import noobanidus.mods.randompotion.gen.PotionTagGenerator;
import noobanidus.mods.randompotion.init.ModLoot;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

@Mod("randompotion")
public class RandomPotions {

  public static final Logger LOG = LogManager.getLogger();
  public static final String MODID = "randompotion";

  public RandomPotions() {
    IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
    modBus.addListener(this::onDataGen);

    ModLoot.register(modBus);
  }

  public void onDataGen(GatherDataEvent event) {
    event.getGenerator().addProvider(event.includeServer(), new PotionTagGenerator(event.getGenerator().getPackOutput(), event.getLookupProvider(), event.getExistingFileHelper()));
    event.getGenerator().addProvider(event.includeDev(), LootTableGenerator.create(event.getGenerator().getPackOutput()));
    event.getGenerator().addProvider(true, new PackMetadataGenerator(event.getGenerator().getPackOutput()).add(PackMetadataSection.TYPE, new PackMetadataSection(
        Component.literal("Resources for RandomPotions"),
        DetectedVersion.BUILT_IN.getPackVersion(PackType.CLIENT_RESOURCES),
        Arrays.stream(PackType.values()).collect(Collectors.toMap(Function.identity(), DetectedVersion.BUILT_IN::getPackVersion)))));
  }
}
