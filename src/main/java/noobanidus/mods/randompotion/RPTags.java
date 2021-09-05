package noobanidus.mods.randompotion;

import net.minecraft.potion.Potion;
import net.minecraft.tags.ITag;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.ForgeTagHandler;
import net.minecraftforge.registries.ForgeRegistries;

public class RPTags {

  public static class Potions extends RPTags {
    public static ITag.INamedTag<Potion> RANDOM_BLACKLIST = compatTag("random_potion_blacklist");

    static ITag.INamedTag<Potion> compatTag(String name) {
      return ForgeTagHandler.createOptionalTag(ForgeRegistries.POTION_TYPES, new ResourceLocation("forge", name));
    }
  }
}
