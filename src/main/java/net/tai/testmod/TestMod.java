package net.tai.testmod;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.advancement.AdvancementEntry;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.tai.testmod.block.ModBlocks;
import net.tai.testmod.item.ModItemGroups;
import net.tai.testmod.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class TestMod implements ModInitializer {
	public static final String MOD_ID = "testmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

//  CUSTOM -------------------------------------------------------------------------------------------------------------


	private static final Map<Set<String>, String[]> MODIFIERS = new HashMap<>() {{
		put(Set.of("minecraft:story/root", "minecraft:story/upgrade_tools", "minecraft:story/smelt_iron", "minecraft:story/mine_stone"),
				new String[]{"§2Crafter of Wooden Beginnings", "The one who shapes tools from nature"});
		put(Set.of("minecraft:story/smelt_iron", "minecraft:story/upgrade_tools", "minecraft:story/lava_bucket", "minecraft:story/root"),
				new String[]{"Blacksmith of Early Sparks", "The one who kindles iron dreams"});
		put(Set.of("minecraft:husbandry/root", "minecraft:husbandry/plant_seed", "minecraft:husbandry/breed_an_animal", "minecraft:story/root"),
				new String[]{"Harvester of Golden Fields", "The one who reaps and kneads"});
		put(Set.of("minecraft:story/root", "minecraft:story/smelt_iron", "minecraft:story/farm", "minecraft:story/bake_bread"),
				new String[]{"Steward of Fiery Harvests", "The one who bakes sustenance from flames"});
		put(Set.of("minecraft:story/root", "minecraft:story/mine_diamond", "minecraft:story/smelt_iron", "minecraft:story/mine_stone"),
				new String[]{"Engineer of Elemental Beginnings", "The one who forges the basics of creation"});
	}};

	private static final Map<UUID, Set<String>> fallbackNotifiedAdvancements = new HashMap<>();
	private static final Set<String> assignedModifiers = new HashSet<>();

//  CUSTOM END ---------------------------------------------------------------------------------------------------------


	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModItemGroups.registerItemGroups();
//  FUEL----------------------------------------------------------------------------------------------------------------
		FuelRegistry.INSTANCE.add(ModItems.SMASHED_COAL,2000);

//  CUSTOM -------------------------------------------------------------------------------------------------------------
		System.out.println("Constellation Mod Initialized!");
		// Check player achievements on server tick
		ServerTickEvents.END_SERVER_TICK.register(server -> {
			for (ServerPlayerEntity player : server.getPlayerManager().getPlayerList()) {
				if (!PlayerData.hasModifier(player) && hasFourAchievements(player)) {
					assignModifier(player);
				}
			}
		});

	}
		// Check if the player has 4 or more advancements
		private boolean hasFourAchievements(ServerPlayerEntity player) {
			int count = 0;
			for (AdvancementEntry advancement : player.server.getAdvancementLoader().getAdvancements()) {
				if (player.getAdvancementTracker().getProgress(advancement).isDone()) {
					count++;
				}
				if (count >= 5) {
					return true;
				}
			}
			return false;
		}

		// Assign a dynamic modifier to the player based on their achievements
		private void assignModifier(ServerPlayerEntity player) {
			Set<String> completedAdvancements = new HashSet<>();

			for (AdvancementEntry advancement : player.server.getAdvancementLoader().getAdvancements()) {
				if (player.getAdvancementTracker().getProgress(advancement).isDone()) {
					completedAdvancements.add(advancement.id().toString());
				}
			}

			for (Set<String> keySet : MODIFIERS.keySet()) {
				if (completedAdvancements.containsAll(keySet)) {
					String[] modifierData = MODIFIERS.get(keySet);
					String chosenModifier = modifierData[0];
					if (!assignedModifiers.contains(chosenModifier)) {
						String synonymicName = modifierData[1];

						PlayerData.setModifier(player, chosenModifier);
						assignedModifiers.add(chosenModifier);

						PlayerData.setModifier(player, chosenModifier);
						player.sendMessage(Text.literal("You have been granted the title: " + chosenModifier), true);
						player.sendMessage(Text.literal("Synonymic Name: " + synonymicName), true);

						Text message = Text.literal(player.getName().getString()+ " have been granted the title: " + chosenModifier);
						if (player instanceof ServerPlayerEntity serverPlayer) {
							serverPlayer.getServer().getPlayerManager().broadcast(message, false);
						}

						player.setCustomName(Text.literal(chosenModifier));
						player.setCustomNameVisible(true);
						fallbackNotifiedAdvancements.remove(player.getUuid());
						return;
					}
				}
			}

			// Fallback in case no specific combination matches
			fallbackNotifiedAdvancements.putIfAbsent(player.getUuid(), new HashSet<>());
			Set<String> notifiedAdvancements = fallbackNotifiedAdvancements.get(player.getUuid());

			for (String advancementId : completedAdvancements) {
				if (!notifiedAdvancements.contains(advancementId)) {
					player.sendMessage(Text.literal("You have achieved greatness, but no specific title matches your path!"), true);
					notifiedAdvancements.add(advancementId);
					return;
				}
			}
		}
	}

	//Utility class to store player data
	class PlayerData {
		private static final Map<UUID, String> playerModifiers = new HashMap<>();

		public static boolean hasModifier(ServerPlayerEntity player) {
			return playerModifiers.containsKey(player.getUuid());
		}

		public static void setModifier(ServerPlayerEntity player, String modifier) {
			playerModifiers.put(player.getUuid(), modifier);
		}

		public static String getModifier(ServerPlayerEntity player) {
			return playerModifiers.get(player.getUuid());
		}
	}
//  CUSTOM END ---------------------------------------------------------------------------------------------------------

