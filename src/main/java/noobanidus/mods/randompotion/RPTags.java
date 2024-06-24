package noobanidus.mods.randompotion;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.alchemy.Potion;

public class RPTags {

  public static class Potions extends RPTags {
    public static TagKey<Potion> RANDOM_BLACKLIST = compatTag("random_potion_blacklist");

    static TagKey<Potion> compatTag(String name) {
      return TagKey.create(Registries.POTION, new ResourceLocation("forge", name));
    }
  }
}
