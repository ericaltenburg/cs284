package classses;

public class Orange extends Fruit {
	private Integer skinThickness;

	public Orange(String color, Integer skinThickness) {
		super(color);
		this.skinThickness = skinThickness;
	}

	public Integer getSkinThickness() {
		return skinThickness;
	}

	public void setSkinThickness(Integer skinThickness) {
		this.skinThickness = skinThickness;
	}
	
	
}
