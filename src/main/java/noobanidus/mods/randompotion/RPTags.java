package noobanidus.mods.randompotion;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.alchemy.Potion;

public class RPTags {

  public static class Potions extends RPTags {
    public static TagKey<Potion> RANDOM_BLACKLIST = compatTag("random_potion_blacklist");

    static TagKey<Potion> modTag(String name) {
      return TagKey.create(Registry.POTION_REGISTRY, new ResourceLocation(RandomPotions.MODID, name));
    }

    static TagKey<Potion> compatTag(String name) {
      return TagKey.create(Registry.POTION_REGISTRY, new ResourceLocation("forge", name));
    }
  }
}
