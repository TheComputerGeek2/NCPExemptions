package me.thecomputergeek2.ncpexemptions;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.entity.Player;

import fr.neatmonster.nocheatplus.checks.CheckType;

public class NCPExemptions {

	private Map<Player, PlayerExemptionMap> exemptionMap;
	
	public NCPExemptions() {
		exemptionMap = new HashMap<Player, PlayerExemptionMap>();
	}
	
	private void ensurePlayerInitialized(Player player) {
		if (!exemptionMap.containsKey(player)) {
			exemptionMap.put(player, new PlayerExemptionMap());
		}
	}
	
	public void exemptPlayer(Player player, ExemptionTicket ticket) {
		ensurePlayerInitialized(player);
		exemptionMap.get(player).addExemptionTicket(ticket);
	}
	
	public void unexemptPlayer(Player player, ExemptionTicket ticket) {
		exemptionMap.get(player).removeExemptionTicket(ticket);
	}
	
	public boolean isExempt(Player player, CheckType check) {
		return exemptionMap.get(player).isExempt(check);
	}
	
	//make sure to do this when players logout
	private void removePlayer(Player player) {
		exemptionMap.remove(player);
	}
	
}
