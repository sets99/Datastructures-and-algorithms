public enum Music {
	Pop(0, 19), HipHop(20, 39), Alternative(40, 59), Metal(60, 79), Classical(80, 99);
	
	int needmin, needmax;
	Music(int a, int b) {
		needmin = a;
		needmax = b;
	}
	
	public static Music getMusic(int need) {
		if(need <= 0) {
			return Pop;
		}
		
		if(need >= 99) {
			return Classical;
		}
		
		for(Music music : Music.values()) {
			if(need >= music.needmin && need <= music.needmax) {
				return music;
			}
		}
		
	
		throw new IllegalArgumentException();
	}
}
