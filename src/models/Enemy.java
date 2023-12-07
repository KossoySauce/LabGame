public class Enemy extends Character{
	private int level;
	public Enemy(String sprite){
		super(sprite);
		super.setRefNum(4);
	}
	public void setLevel(int level){
		this.level=level;
	}

	public int getLevel(){
		return level;
	}
	
}
