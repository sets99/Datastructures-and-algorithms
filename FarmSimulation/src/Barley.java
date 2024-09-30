public class Barley extends Plant {
	public Barley(String n, int initneed) {
		super(n, initneed, Fertilizer.DynaGro, Fertilizer.Eggshells);
	}
	
	@Override
	public void fertilize(Fertilizer fert) {
		switch(fert) {
		case Fertilizer.DynaGro:
			if(need >= 70) {
				need -= 7;
			}
			
			else {
				need -= 3;
			}
			
			break;
			
		case Fertilizer.Eggshells:
			need -= 2;
			break;

		default:
			break;
	}

	}
	
	
	public String getMusic() {
		return music.name();
	}
	
	@Override
	public String toString() {
		return(this.name + " The Barley is listening to " + this.music);
	}


}
