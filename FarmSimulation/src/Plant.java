public abstract class Plant{
	String name;
	int need;
	Music music;
	Fertilizer primary, secondary;
	
	public Plant(String n, int initneed, Fertilizer p, Fertilizer s) {
		name = n;
		need = initneed;
		primary = p;
		secondary = s;
		this.updateMusic();
	}
	
	public void updateMusic() {
        this.music = Music.getMusic(need);
    }
	
	public abstract void fertilize(Fertilizer fert);
	public abstract String toString();
	
	public int compare(Plant a, Plant b) {
		return Integer.compare(a.need, b.need);
	}
}
