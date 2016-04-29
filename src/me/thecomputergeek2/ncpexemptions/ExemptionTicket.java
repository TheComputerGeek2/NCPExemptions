package me.thecomputergeek2.ncpexemptions;

import java.util.concurrent.ThreadLocalRandom;

import fr.neatmonster.nocheatplus.checks.CheckType;

public class ExemptionTicket {
	
	private int rID;
	public CheckType[] checkTypes;
	
	public ExemptionTicket(CheckType... checkTypes) {
		this.checkTypes = checkTypes;
		rID = ThreadLocalRandom.current().nextInt();
	}
	
}
