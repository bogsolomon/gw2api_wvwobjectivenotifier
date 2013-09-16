package ca.bsolomon.gw2.wvw.objective.dao;

public class Status {

	private final String color;
	private final boolean playSound;
	private final String objective;
	public Status(String color, boolean playSound, String objective) {
		super();
		this.color = color;
		this.playSound = playSound;
		this.objective = objective;
	}
	public String getColor() {
		return color;
	}
	public boolean isPlaySound() {
		return playSound;
	}
	public String getObjective() {
		return objective;
	}
	
}
