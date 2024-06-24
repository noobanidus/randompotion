package noobanidus.mods.randompotion.loot.functions;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.functions.LootItemConditionalFunction;
import net.minecraft.world.level.storage.loot.functions.LootItemFunctionType;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import noobanidus.mods.randompotion.RPTags;
import noobanidus.mods.randompotion.RandomPotions;
import noobanidus.mods.randompotion.init.ModLoot;

import java.util.List;

public class RandomPotionFunction extends LootItemConditionalFunction {

  protected RandomPotionFunction(LootItemCondition[] p_80678_) {
    super(p_80678_);
  }

  public ItemStack run(ItemStack stack, LootContext context) {
    RandomSource random = context.getRandom();

    HolderSet.Named<Potion> holders = BuiltInRegistries.POTION.getTag(RPTags.Potions.RANDOM_BLACKLIST).orElseThrow();
    List<Potion> potions = BuiltInRegistries.POTION.stream().filter(o -> !holders.contains(BuiltInRegistries.POTION.getHolder(BuiltInRegistries.POTION.getResourceKey(o).orElseThrow()).orElseThrow())).toList();
    if (potions.isEmpty()) {
      RandomPotions.LOG.error("Unable to find a random potion suitable for '" + stack + "': all available potions appear to be blacklisted.");
      return stack;
    }

    Potion potion = potions.get(random.nextInt(potions.size()));
    PotionUtils.setPotion(stack, potion);
    return stack;
  }

  @Override
  public LootItemFunctionType getType() {
    return ModLoot.RANDOM_POTION.get();
  }

  public static RandomPotionFunction.Builder randomPotion() {
    return new RandomPotionFunction.Builder();
  }

  public static LootItemConditionalFunction.Builder<?> randomApplicablePotion() {
    return simpleBuilder(RandomPotionFunction::new);
  }

  public static class Builder extends LootItemConditionalFunction.Builder<RandomPotionFunction.Builder> {

    @Override
    protected RandomPotionFunction.Builder getThis() {
      return this;
    }

    @Override
    public LootItemConditionalFunction build() {
      return new RandomPotionFunction(getConditions());
    }
  }

  public static class Serializer extends LootItemConditionalFunction.Serializer<RandomPotionFunction> {
    @Override
    public void serialize(JsonObject json, RandomPotionFunction function, JsonSerializationContext context) {
      super.serialize(json, function, context);
    }

    @Override
    public RandomPotionFunction deserialize(JsonObject json, JsonDeserializationContext context, LootItemCondition[] conditions) {
      return new RandomPotionFunction(conditions);
    }
  }
}

