public class Player extends Entity
{
	private final int LIFE_MAX = 10;

	private int life;
	private int weapNum;
	
	private int ticksLeft;
	private boolean jumping = false;

	public int PSTATE = 0;

	/*
	 * 
	 * 0=stand 1=run 2=jump 3=fall 4=die
	 */

	public Player(int x, int y)
	{
		x_pos = x;
		y_pos = y;
		width = 45;
		height = 45;

		life = 10;
		weapNum = 1;
		
		ticksLeft = 0;
	}
	
	public boolean isJumping(){
		return jumping;
	}
	
	public int getLife()
	{
		return life;
	}

	public String getLifeText()
	{
		return "LIFE " + life + "/" + LIFE_MAX;
	}

	public void takeDamage(int damage)
	{
		life -= damage;
		
		if (life <= 0) {
			life = 0;
		}
	}

	public String getWeapText()
	{
		return "Gun# " + weapNum;
	}

	public void setWeap(int weapNum)
	{
		this.weapNum = weapNum;
	}

	public void jump()
	{
		if(!jumping)
		{
			jumping = true;
			ticksLeft = 25;
		}
	}
	
	public void setTicks( int ticks)
	{
		ticksLeft = ticks;
	}
	
	public void tick(){
		if( ticksLeft > 0 )
		{
			ticksLeft -= 1;
		}
		else
		{
			jumping = false;
		}
	}

	// generate a shot at the current position of the spaceship
	// and return this shot to the calling method
	public Shot generateShot()
	{
		Shot shot = new Shot(x_pos + (width / 2), y_pos + (height / 2), weapNum);
		return shot;
	}

}