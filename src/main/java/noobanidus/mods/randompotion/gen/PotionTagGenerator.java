package noobanidus.mods.randompotion.gen;

import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeRegistryTagsProvider;
import net.minecraftforge.registries.ForgeRegistries;
import noobanidus.mods.randompotion.RPTags;
import noobanidus.mods.randompotion.RandomPotions;

public class PotionTagGenerator extends ForgeRegistryTagsProvider<Potion> {
  public PotionTagGenerator(DataGenerator generatorIn, ExistingFileHelper helper) {
    super(generatorIn, ForgeRegistries.POTIONS, RandomPotions.MODID, helper);
  }

  @Override
  protected void addTags() {
    tag(RPTags.Potions.RANDOM_BLACKLIST);
  }

  @Override
  public String getName() {
    return "Potion Tag Provider";
  }
}
