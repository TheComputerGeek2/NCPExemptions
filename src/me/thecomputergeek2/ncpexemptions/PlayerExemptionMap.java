package me.thecomputergeek2.ncpexemptions;

import java.util.EnumMap;
import java.util.HashSet;
import java.util.Set;

import fr.neatmonster.nocheatplus.checks.CheckType;

public class PlayerExemptionMap extends EnumMap<CheckType, Set<ExemptionTicket>> {

	
	public PlayerExemptionMap() {
		super(CheckType.class);
		initializeTicketSets();
	}
	
	public void addExemptionTicket(ExemptionTicket ticket) {
		for (CheckType type: ticket.checkTypes) {
			super.get(type).add(ticket);
		}
	}
	
	public void removeExemptionTicket(ExemptionTicket ticket) {
		for (CheckType type: ticket.checkTypes) {
			super.get(type).remove(ticket);
		}
	}
	
	private void initializeTicketSets() {
		for (CheckType type: CheckType.values()) {
			super.put(type, new HashSet<ExemptionTicket>());
		}
	}
	
	public boolean isExempt(CheckType type) {
		return !super.get(CheckType.ALL).isEmpty() || !super.get(type).isEmpty();
	}

}
