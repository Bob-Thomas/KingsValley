package AnimatingSprite;

import explorer.Explorer;

public class AnimatedSprite {
//fields
	private Explorer explorer;
	private float timer;
	private int[] xValue = {0,18,36,54,72,90,108,126 };
	private boolean flipx;
	protected int i;
	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	//properties
	public boolean isFlipx() {
		return flipx;
	}

	public void setFlipx(boolean flipx) {
		this.flipx = flipx;
	}
	//constructor
	public AnimatedSprite(Explorer explorer){
		this.explorer = explorer;
	}
	
	public void Update(float delta){
		this.timer += delta;
        if (this.timer > 7f /60f)
        {
            this.timer = 0;
            this.i++;
            if (this.i > 7)
            {
                this.i = 0;
            }
        }
		
	}
	
	public void Draw(float delta){
		
		this.explorer.getGame().getSpriteBatch().draw( this.explorer.getText()
				,this.explorer.getPosition().x
				,this.explorer.getPosition().y
				,this.explorer.getText().getWidth()/8
				,this.explorer.getText().getHeight()
				,this.xValue[this.i]
				,0
				,18
				,32
				,flipx
				,false);
	}
}
