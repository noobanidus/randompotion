package noobanidus.mods.randompotion.loot.functions;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.functions.LootItemConditionalFunction;
import net.minecraft.world.level.storage.loot.functions.LootItemFunctionType;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import noobanidus.mods.randompotion.RPTags;
import noobanidus.mods.randompotion.RandomPotions;
import noobanidus.mods.randompotion.init.ModLoot;

import java.util.List;

public class RandomPotionFunction extends LootItemConditionalFunction {
  public static final MapCodec<RandomPotionFunction> CODEC = RecordCodecBuilder.mapCodec(
      p_344674_ -> commonFields(p_344674_)
          .apply(p_344674_, RandomPotionFunction::new)
  );

  protected RandomPotionFunction(List<LootItemCondition> conditions) {
    super(conditions);
  }

  public ItemStack run(ItemStack stack, LootContext context) {
    RandomSource random = context.getRandom();

    var potions = BuiltInRegistries.POTION.holders().filter(o -> !o.is(RPTags.Potions.RANDOM_BLACKLIST)).toList();
    if (potions.isEmpty()) {
      RandomPotions.LOG.error("Unable to find a random potion suitable for '" + stack + "': all available potions appear to be blacklisted.");
      return stack;
    }

    var potion = potions.get(random.nextInt(potions.size()));
    stack.update(DataComponents.POTION_CONTENTS, PotionContents.EMPTY, potion, PotionContents::withPotion);
    return stack;
  }

  @Override
  public LootItemFunctionType<RandomPotionFunction> getType() {
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
}

