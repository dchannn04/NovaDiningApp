import java.io.*;


import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.util.*;

public class ReadMealTest {
	static final String FILE_NAME = "./src/DiningHallMenuExport_May2019.xlsx";
	
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		Workbook workbook = WorkbookFactory.create(new File(FILE_NAME));
		Sheet sheet = workbook.getSheetAt(0);
		List<MealItem> meals = new ArrayList<>();
		
		for (Row row: sheet) {
			if(row.getRowNum() == 0) continue; // skip header
			meals.add(processRow(row));
		}
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		mapper.writeValue(System.out, meals); // write to output
	}
	
	public static MealItem processRow(Row row) {
		String mealRow = "";
		for(Cell c: row) {
			switch(c.getCellType()) {
			case NUMERIC:
				mealRow += String.format("%f@", c.getNumericCellValue());
				break;
			case STRING:
				mealRow += String.format("%s@", c.getRichStringCellValue().getString());
				break;
			default:
				System.out.println("Invalid Cell Type");
			}
		}
		mealRow = mealRow.substring(0, mealRow.length() - 1); //remove last @
		
		String[] nutrientNames = {"calories", "fat","saturatedFat", "cholesterol", "sodium", "carbohydrates", 
				"fiber", "protein", "vitaminA", "vitaminC", "calcium", "iron"};
		String[] data = mealRow.split("@");
		
		double itemId = Double.parseDouble(data[0]);
		double menuItem = Double.parseDouble(data[1]);
		String serviceDate = data[2];
		String diningHall = data[3];
		String servedWhen = data[4];
		String course = data[5];
		String itemName = data[6];
		String portion = data[7];
		double courseSort = Double.parseDouble(data[8]);
		double sortOrder = Double.parseDouble(data[9]);
		
		MealItem meal = new MealItem(itemId, menuItem, serviceDate, diningHall, servedWhen,
				course, itemName, portion, courseSort, sortOrder);
		
		for(int i = 0; i < nutrientNames.length; i++) {
			meal.addNutrientToMealItem(new Nutrient(nutrientNames[i], Double.parseDouble(data[i+10])));
		}
		
		return meal;
		
	}

}
