package me.thecomputergeek2.ncpexemptions;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.entity.Player;

import fr.neatmonster.nocheatplus.checks.CheckType;

public class NCPExemptions {

	private Map<Player, PlayerExemptionMap> exemptionMap;
	private boolean clearUnheldTickets;
	
	public NCPExemptions() {
		this(false);
	}
	
	public NCPExemptions(boolean clearUnheldTickets) {
		this.clearUnheldTickets = clearUnheldTickets;
		exemptionMap = new HashMap<Player, PlayerExemptionMap>();
	}
	
	private void ensurePlayerInitialized(Player player) {
		if (!exemptionMap.containsKey(player)) {
			exemptionMap.put(player, new PlayerExemptionMap(clearUnheldTickets));
		}
	}
	
	public void exemptPlayer(Player player, ExemptionTicket ticket) {
		if (!player.isOnline()) return;
		ensurePlayerInitialized(player);
		exemptionMap.get(player).addExemptionTicket(ticket);
	}
	
	public void unexemptPlayer(Player player, ExemptionTicket ticket) {
		if (!player.isOnline()) return;
		exemptionMap.get(player).removeExemptionTicket(ticket);
	}
	
	public boolean isExempt(Player player, CheckType check) {
		if (!player.isOnline()) return false;
		return exemptionMap.get(player).isExempt(check);
	}
	
	//make sure to do this when players logout
	private void removePlayer(Player player) {
		exemptionMap.remove(player);
	}
	
}
