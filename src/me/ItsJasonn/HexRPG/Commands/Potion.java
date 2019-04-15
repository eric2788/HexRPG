package me.ItsJasonn.HexRPG.Commands;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionType;

/**
 * This class is created by Eric Lam
 */
public class Potion {
    private PotionType type;
    private int level;
    private boolean splash;

    public Potion(PotionType type, int level, boolean splash) {
        this.type = type;
        this.level = level;
        this.splash = splash;
    }

    public ItemStack toItemStack(int amount) {
        ItemStack item = new ItemStack(splash ? Material.SPLASH_POTION : Material.POTION);
        PotionData data = new PotionData(type);
        PotionMeta meta = (PotionMeta) item.getItemMeta();
        meta.setBasePotionData(data);
        item.setAmount(amount);
        return item;
    }
}
