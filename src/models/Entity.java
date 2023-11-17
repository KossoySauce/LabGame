public abstract class Entity{

	private String sprite;
	private boolean passable;
	private boolean visible = false;

	public Entity(String sprite, boolean passable){
		this.sprite = sprite;
		this.passable = passable;
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
