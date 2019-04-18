package net.thederpgamerx.fantasyhorses.npc;

import org.bukkit.craftbukkit.v1_13_R2.entity.CraftPlayer;
import org.bukkit.craftbukkit.v1_13_R2.inventory.CraftItemStack;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import net.minecraft.server.v1_13_R2.BlockPosition;
import net.minecraft.server.v1_13_R2.EntityHuman;
import net.minecraft.server.v1_13_R2.IChatBaseComponent;
import net.minecraft.server.v1_13_R2.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_13_R2.IMerchant;
import net.minecraft.server.v1_13_R2.MerchantRecipe;
import net.minecraft.server.v1_13_R2.MerchantRecipeList;
import net.minecraft.server.v1_13_R2.World;

public class StableKeepShopGUI {

	 private String invname;
	    private MerchantRecipeList recipieList = new MerchantRecipeList();

	    /**
	     * @param invname Inventory display name, (May contain color)
	     *
	     */
	    public StableKeepShopGUI(String invname) {
	        this.invname = invname;
	    }

	    /**
	     * @param inOne The itemstack in the first input slot.
	     * @param out The itemstack output.
	     * @return ForceVillagerTrade object so you can invoke the next method like:
	     * addTrade(...).addTrade(...).addTrade(...).openTrade(player);
	     */
	    public StableKeepShopGUI addTrade(ItemStack in, ItemStack out) {
	        recipieList.add(new MerchantRecipe(CraftItemStack.asNMSCopy(in), CraftItemStack.asNMSCopy(out)));
	        return this;
	    }

	    /**
	     * @param inOne The itemstack in the first input slot.
	     * @param inTwo The itemstack on the second input slot.
	     * @param out The itemstack output.
	     * @return ForceVillagerTrade object so you can invoke the next method like:
	     * addTrade(...).addTrade(...).addTrade(...).openTrade(player);
	     */
	    public StableKeepShopGUI addTrade(ItemStack inOne, ItemStack inTwo,
	            ItemStack out) {
	        recipieList.add(new MerchantRecipe(CraftItemStack.asNMSCopy(inOne),
	                CraftItemStack.asNMSCopy(inTwo), CraftItemStack.asNMSCopy(out)));
	        return this;
	    }

	    /**
	     * @param who The player who will see the Trade
	     */
	    public void openTrade(Player player) {
	        final EntityHuman e = ((CraftPlayer) player).getHandle();
	        e.openTrade(new IMerchant() {
	            @Override
	            public MerchantRecipeList getOffers(EntityHuman arg0) {
	                return recipieList;
	            }

				@Override
				public void a(MerchantRecipe arg0) {
					
				}

				@Override
				public void a(net.minecraft.server.v1_13_R2.ItemStack arg0) {
					
				}

				@Override
				public BlockPosition getPosition() {
					return null;
				}

				@Override
				public IChatBaseComponent getScoreboardDisplayName() {
					return ChatSerializer.a(invname);
				}

				@Override
				public EntityHuman getTrader() {
					return null;
				}

				@Override
				public World getWorld() {
					return null;
				}

				@Override
				public void setTradingPlayer(EntityHuman arg0) {
					
				}

	      
	        });
	    }

}
