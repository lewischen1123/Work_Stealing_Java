package house;

import java.util.concurrent.atomic.AtomicBoolean;

public class BuildingMaterial {
 
	private int x;
	private int y;
	private int width;
	private int height;
	private AtomicBoolean isVisible;
	
	public BuildingMaterial(int x, int y, int width, int height, boolean isVisible) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.isVisible = new AtomicBoolean(isVisible);
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public boolean isVisible() {
		return isVisible.get();
	}

	public boolean getAndSetVisible(boolean isVisible) {
		return this.isVisible.getAndSet(isVisible);
	}
}
