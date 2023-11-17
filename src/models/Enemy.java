public class Enemy extends Character{

	private int level;

	public Enemy(String sprite,int level){
		super(sprite);
		this.level = level;
	}

	public void setLevel(int level){
		this.level=level;
	}

	public int getLevel(){
		return level;
	}
	
}
