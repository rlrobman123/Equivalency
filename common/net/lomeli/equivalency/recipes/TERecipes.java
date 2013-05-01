package net.lomeli.equivalency.recipes;

import net.lomeli.equivalency.helper.TransmutationHelper;
import net.minecraft.item.ItemStack;

import thermalexpansion.api.item.ItemRegistry;

public class TERecipes 
{
	public static ItemStack copperIngot = ItemRegistry.getItem("ingotCopper", 1);
	public static ItemStack tinIngot = ItemRegistry.getItem("ingotTin", 1);
	public static ItemStack silverIngot = ItemRegistry.getItem("ingotSilver", 1);
	public static ItemStack leadIngot = ItemRegistry.getItem("ingotLead", 1);
	
	public static void loadRecipes(ItemStack transmutationStone)
	{
		UniversalRecipes.ingotCopper.add(copperIngot);
		UniversalRecipes.ingotTin.add(tinIngot);
		UniversalRecipes.ingotSilver.add(silverIngot);
		UniversalRecipes.ingotLead.add(leadIngot);
		
		// 3 Copper Ingot -> Tin Ingot
		TransmutationHelper.addRecipe(tinIngot, transmutationStone, 
			new Object[]{ copperIngot, copperIngot, copperIngot });
		// 1 Tin Ingot -> 3 Copper Ingot
		TransmutationHelper.addRecipe(new ItemStack(copperIngot.getItem(), 3), transmutationStone, 
			new Object[]{ tinIngot });
		
		// 1 Silver Ingot -> 2 Lead Ingot
		TransmutationHelper.addRecipe(silverIngot, 
			transmutationStone, new Object[]{ leadIngot, leadIngot });
		// 2 Lead -> 1 Silver Ingot
		TransmutationHelper.addRecipe(new ItemStack(leadIngot.getItem(), 2), transmutationStone, 
			new Object[]{ silverIngot});
	}
}
