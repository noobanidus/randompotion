package noobanidus.mods.randompotion.gen;

import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import noobanidus.mods.randompotion.RandomPotions;
import noobanidus.mods.randompotion.loot.functions.RandomPotionFunction;

import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;

public class LootTableGenerator {
  public static ResourceLocation TEST_TABLE = new ResourceLocation(RandomPotions.MODID, "test_loot_table");

  public static LootTableProvider create(PackOutput output) {
    return new LootTableProvider(output, Set.of(TEST_TABLE), List.of(new LootTableProvider.SubProviderEntry(TestLootTable::new, LootContextParamSets.CHEST)));
  }

  public static class TestLootTable implements LootTableSubProvider {
    @Override
    public void generate(BiConsumer<ResourceLocation, LootTable.Builder> sink) {
      sink.accept(
          TEST_TABLE,
          LootTable.lootTable()
              .withPool(
                  LootPool.lootPool()
                      .setRolls(ConstantValue.exactly(1))
                      .add(LootItem.lootTableItem(Items.POTION).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1))).apply(RandomPotionFunction.randomApplicablePotion()))));
    }
  }
}
