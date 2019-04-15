package me.ItsJasonn.HexRPG.Tools.Screen;

import net.minecraft.server.v1_13_R2.IChatBaseComponent;
import net.minecraft.server.v1_13_R2.PacketPlayOutChat;
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_13_R2.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class ActionBar {
	private PacketPlayOutChat packet;

	public ActionBar(String text) {
		PacketPlayOutChat packet = new PacketPlayOutChat(IChatBaseComponent.ChatSerializer.a("{\"text\":\"" + text + "\"}"));
		this.packet = packet;
	}

	public void sendToPlayer(Player player) {
		((CraftPlayer) player).getHandle().playerConnection.sendPacket(this.packet);
	}

	public void sendToAll() {
		for (Player players : Bukkit.getServer().getOnlinePlayers()) {
			((CraftPlayer) players).getHandle().playerConnection.sendPacket(this.packet);
		}
	}
}
