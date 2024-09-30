public class Potato extends Plant {
	public Potato(String n, int initneed) {
		super(n, initneed, Fertilizer.HappyFrog, Fertilizer.Manure);
	}
	
	@Override
	public void fertilize(Fertilizer fert) {
		switch(fert) {
			case Fertilizer.HappyFrog:
				need -= 8;
				break;
				
			case Fertilizer.Manure:
				need -= 1;
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
		return(this.name + " The Potato is listening to " + this.music);
	}


}
