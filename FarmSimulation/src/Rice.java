public class Rice extends Plant {
	public Rice(String n, int initneed) {
		super(n, initneed, Fertilizer.Manure, Fertilizer.Eggshells);
	}

	
	@Override
	public void fertilize(Fertilizer fert) {
		switch(fert) {
		case Fertilizer.Manure:
			need -= 7;
			break;
			
		case Fertilizer.Eggshells:
			need -= 4;
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
		return(this.name + " The Rice is listening to " + this.music);
	}


}
