package noobanidus.mods.randompotion.gen;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.common.data.ExistingFileHelper;
import noobanidus.mods.randompotion.RPTags;
import noobanidus.mods.randompotion.RandomPotions;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class PotionTagGenerator extends TagsProvider<Potion> {


  public PotionTagGenerator(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> provider, @Nullable ExistingFileHelper existingFileHelper) {
    super(packOutput, Registries.POTION, provider, RandomPotions.MODID, existingFileHelper);
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
