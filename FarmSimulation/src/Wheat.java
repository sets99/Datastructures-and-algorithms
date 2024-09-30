public class Wheat extends Plant {
	public Wheat(String n, int initneed) {
		super(n, initneed, Fertilizer.HappyFrog, Fertilizer.Jacks);
	}
	
	@Override
	public void fertilize(Fertilizer fert) {
		switch(fert) {
		case Fertilizer.HappyFrog:
			if(need>50) {
				need -= 6;
			}
			
			else {
				need -= 3;
			}
			
			break;
			
		case Fertilizer.Jacks:
			need -= 3;
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
		return(this.name + " The Wheat is listening to " + this.music);
	}

}
