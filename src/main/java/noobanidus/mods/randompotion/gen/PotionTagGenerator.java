package noobanidus.mods.randompotion.gen;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.world.item.alchemy.Potion;
import noobanidus.mods.randompotion.RPTags;
import noobanidus.mods.randompotion.RandomPotions;

import java.util.concurrent.CompletableFuture;

public class PotionTagGenerator extends TagsProvider<Potion> {
  public PotionTagGenerator(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> provider) {
    super(packOutput, Registries.POTION, provider, RandomPotions.MODID, null);
  }

  @Override
  public String getName() {
    return "Potion Tag Provider";
  }

  @Override
  protected void addTags(HolderLookup.Provider provider) {
    this.tag(RPTags.Potions.RANDOM_BLACKLIST);
  }
}
