
public class Nutrient {
	public String nutrientName;
	public double nutrientValue;
	public Nutrient(String nutrientName, double nutrientValue) {
		this.nutrientName = nutrientName;
		this.nutrientValue = nutrientValue;
	}
	@Override
	public String toString() {
		return "Nutrient [nutrientName=" + nutrientName + ", nutrientValue=" + nutrientValue + "]";
	}

}
