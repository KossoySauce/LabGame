public abstract class Entity{

	private String sprite;
	private boolean passable;
	private boolean visible = false;
	private int refNum;

	public Entity(String sprite, boolean passable){
		this.sprite = sprite;
		this.passable = passable;
	}

	public int getRefNum(){
		return refNum;
	}
	public void setRefNum(int refNum){
		this.refNum = refNum;
	}

	public String getSprite(){
		return sprite;
	}

	public void setSprite(String sprite){
		this.sprite = sprite;
	}

	public boolean getPassable(){
		return passable;
	}

	public void setPassable(boolean passable){
		this.passable = passable;
	}

	public String toString(){
		return sprite;
	}

	public boolean isVisible(){
		return visible;
	}

	public void makeVisble(){
		visible = true;
	}

}
