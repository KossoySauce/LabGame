public class Character extends Entity{

	private int xp = 0;
	private int health = 100;

	public Character(String sprite){
		super(sprite,false);
	}

	public int getXP(){
		return xp;
	}

	public void setXP(int xp){
		this.xp = xp;
	}

	public void addXP(int a){
		xp = xp + a;
	}

	public void subXP(int a){
		xp = xp - a;
	}

	public int getHealth(){
		return health;
	}

	public void setHealth(int health){
		this.health = health;
	}

	public void addHealth(int a){
		health = health + a;
	}

	public void subHealth(int a){
		health = health - a;
	}

	public void printStats(){
		System.out.println("Player has "  + health + " health");
	}

}
