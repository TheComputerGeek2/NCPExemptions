package me.thecomputergeek2.ncpexemptions;

import java.util.concurrent.ThreadLocalRandom;

import fr.neatmonster.nocheatplus.checks.CheckType;

public class ExemptionTicket {
	
	private long rID;
	public CheckType[] checkTypes;
	
	public ExemptionTicket(CheckType... checkTypes) {
		this.checkTypes = checkTypes;
		rID = ThreadLocalRandom.current().nextLong();
	}
	
	@Override
	public boolean equals(Object other) {
		if (other instanceof ExemptionTicket) {
			return rID == ((ExemptionTicket)other).rID;
		}
		return false;
	}
	
}
