import java.util.List;
import java.util.ArrayList;


public class MealItem {
	double itemId;
	double menuItem;
	String serviceDate, diningHall, servedWhen, course, itemName, portion;
	double courseSort;
	double sortOrder;
	List<Nutrient> nutrients = new ArrayList<>();
	
	
	public MealItem(double itemId, double menuItem, String serviceDate, String diningHall, String servedWhen, String course,
			String itemName, String portion, double courseSort, double sortOrder) {
		this.itemId = itemId;
		this.menuItem = menuItem;
		this.serviceDate = serviceDate;
		this.diningHall = diningHall;
		this.servedWhen = servedWhen;
		this.course = course;
		this.itemName = itemName;
		this.portion = portion;
		this.courseSort = courseSort;
		this.sortOrder = sortOrder;
	}
	
	public void addNutrientToMealItem(Nutrient n) {
		nutrients.add(n);
	}

	public double getItemId() {
		return itemId;
	}

	public void setItemId(double itemId) {
		this.itemId = itemId;
	}

	public double getMenuItem() {
		return menuItem;
	}

	public void setMenuItem(double menuItem) {
		this.menuItem = menuItem;
	}

	public String getServiceDate() {
		return serviceDate;
	}

	public void setServiceDate(String serviceDate) {
		this.serviceDate = serviceDate;
	}

	public String getDiningHall() {
		return diningHall;
	}

	public void setDiningHall(String diningHall) {
		this.diningHall = diningHall;
	}

	public String getServedWhen() {
		return servedWhen;
	}

	public void setServedWhen(String servedWhen) {
		this.servedWhen = servedWhen;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getPortion() {
		return portion;
	}

	public void setPortion(String portion) {
		this.portion = portion;
	}

	public double getCourseSort() {
		return courseSort;
	}

	public void setCourseSort(double courseSort) {
		this.courseSort = courseSort;
	}

	public double getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(double sortOrder) {
		this.sortOrder = sortOrder;
	}

	public List<Nutrient> getNutrients() {
		return nutrients;
	}

	public void setNutrients(List<Nutrient> nutrients) {
		this.nutrients = nutrients;
	}

	@Override
	public String toString() {
		return "MealItem [itemId=" + itemId + ", menuItem=" + menuItem + ", serviceDate=" + serviceDate
				+ ", diningHall=" + diningHall + ", servedWhen=" + servedWhen + ", course=" + course + ", itemName="
				+ itemName + ", portion=" + portion + ", courseSort=" + courseSort + ", sortOrder=" + sortOrder
				+ ", nutrients=" + nutrients + "]";
	}
	
	

}
