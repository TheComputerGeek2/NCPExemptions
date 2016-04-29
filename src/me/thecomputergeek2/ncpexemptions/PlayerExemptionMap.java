package me.thecomputergeek2.ncpexemptions;

import java.util.Collections;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.Set;
import java.util.WeakHashMap;

import fr.neatmonster.nocheatplus.checks.CheckType;

public class PlayerExemptionMap extends EnumMap<CheckType, Set<ExemptionTicket>> {

	public PlayerExemptionMap() {
		this(false);
	}
	
	public PlayerExemptionMap(boolean clearUnheldKeys) {
		super(CheckType.class);
		initializeTicketSets(clearUnheldKeys);
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
	
	private void initializeTicketSets(boolean clearUnheldKeys) {
		for (CheckType type: CheckType.values()) {
			if (!clearUnheldKeys) {
				super.put(type, new HashSet<ExemptionTicket>());
			} else {
				super.put(type, Collections.newSetFromMap(new WeakHashMap<ExemptionTicket, Boolean>()));
			}
		}
	}
	
	public boolean isExempt(CheckType type) {
		return !super.get(CheckType.ALL).isEmpty() || !super.get(type).isEmpty();
	}

}
