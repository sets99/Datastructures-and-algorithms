public class Corn extends Plant {
	public Corn(String n, int initneed) {
		super(n, initneed, Fertilizer.Grass, Fertilizer.Jacks);
	}
	
	@Override
	public void fertilize(Fertilizer fert) {
		switch(fert) {
			case Fertilizer.Grass:
				need -= 4;
				break;
				
			case Fertilizer.Jacks:
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
		return(this.name + " The Corn is listening to " + this.music);
	}
	

}
