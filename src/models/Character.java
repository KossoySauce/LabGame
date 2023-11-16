public class Character extends Entity{

	private int xp = 0;
	private int health = 100;

	public Character(String sprite){
		super(sprite,false);
	}

	private int getXP(){
		return xp;
	}

	private void setXP(int xp){
		this.xp = xp;
	}

	private void addXP(int a){
		xp = xp + a;
	}

	private void subXP(int a){
		xp = xp - a;
	}

	private int getHealth(){
		return health;
	}

	private void setHealth(int health){
		this.health = health;
	}

	private void addHealth(int a){
		health = health + a;
	}

	private void subHelath(int a){
		health = health - a;
	}

}
