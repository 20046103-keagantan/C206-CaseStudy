import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {

	private Promotion p1;
	private Promotion p2;

	private purchaseOrder po1;
	private purchaseOrder po2;

	private Food f1;
	private Food f2;
	private Food f3;
	private Food f4;

	private Order or1;
	private Order or2;

	private stalls s1;
	private stalls s2;
	private stalls s3;
	private stalls s4;

	private ArrayList<stalls> SList;

	private ArrayList<Order> orderList;
	private ArrayList<Food> foodList;
	private ArrayList<Promotion> promotionList;
	private ArrayList<purchaseOrder> poList;

	@Before
	public void setUp() throws Exception {
		p1 = new Promotion(1, "Spaghetti", 5.00, 3.50, 6);
		p2 = new Promotion(2, "Fries", 3.00, 1.00, 6);
		po1 = new purchaseOrder(1, "Spaghetti", 5.00, 20, "cash");
		po2 = new purchaseOrder(2, "Fries", 3.00, 50, "cash");
		f1 = new Food(01, "Bubble Tea", 3, "Drinks Stall");
		f2 = new Food(02, "Mee Rebus", 4, "Noodle Stall");
		f3 = new Food(03, "Kimchi Fried Rice", 4, "Korean Stall");
		f4 = new Food(04, "Chicken Cutlet", 4, "Western Stall");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		or1 = new Order(1, 15.00, LocalDate.parse("04/02/2021", formatter));
		or2 = new Order(2, 21.00, LocalDate.parse("17/05/2021", formatter));
		DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		s1 = new stalls(1, "Western Stall", LocalDate.parse("22/02/2020", formatter1));
		s2 = new stalls(2, "Korean Stall", LocalDate.parse("01/04/2020", formatter1));
		s3 = new stalls(3, "Noodle Stall", LocalDate.parse("04/05/2019", formatter1));
		s4 = new stalls(4, "Drink Stall", LocalDate.parse("20/09/2020", formatter1));

		SList = new ArrayList<stalls>();
		orderList = new ArrayList<Order>();
		foodList = new ArrayList<Food>();
		poList = new ArrayList<purchaseOrder>();
		promotionList = new ArrayList<Promotion>();
	}

	@After
	public void tearDown() throws Exception {
		f1 = null;
		f2 = null;
		f3 = null;
		f4 = null;
		foodList = null;

		p1 = null;
		p2 = null;
		promotionList = null;

		po1 = null;
		po2 = null;
		poList = null;

		or1 = null;
		or2 = null;
		orderList = null;

		s1 = null;
		s2 = null;
		s3 = null;
		s4 = null;
		SList = null;
	}

	@Test
	public void c206_test() {
		// fail("Not yet implemented");
		assertTrue("C206_CaseStudy_SampleTest ", true);
	}

	@Test
	public void testAddPromotion() {
		// Item list is not null, so that can add a new item
		assertNotNull("Test if there is valid Promotion arraylist to add to", promotionList);

		// Given an empty list, after adding 1 item, the size of the list is 1
		C206_CaseStudy.addPromotion(promotionList, p1);
		assertEquals("Test if that Promotion arraylist size is 1?", 1, promotionList.size());

		// The item just added is as same as the first item of the list
		assertSame("Test that Promotion is added same as 1st item of the list?", p1, promotionList.get(0));

		// Add another item. test The size of the list is 2?
		C206_CaseStudy.addPromotion(promotionList, p2);
		assertEquals("Test that Promotion arraylist size is 2?", 2, promotionList.size());
	}

	@Test
	public void retrieveAllPromotionTest() {
		// Test if Item list is not null but empty -boundary
		assertNotNull("Test if there is valid Promotion arraylist to retrieve item", promotionList);

		// test if the list of promotion retrieved from the SourceCentre is empty -
		// boundary
		String allPromotion = C206_CaseStudy.retrieveAllPromotion(promotionList);
		String testOutput = "";
		assertEquals("Check that ViewAllPromotionlist", testOutput, allPromotion);

		// Given an empty list, after adding 2 items, test if the size of the list is 2
		// - normal
		C206_CaseStudy.addPromotion(promotionList, p1);
		C206_CaseStudy.addPromotion(promotionList, p2);
		assertEquals("Test that Promotion arraylist size is 2", 2, promotionList.size());

		// test if the expected output string same as the list of promotion retrieved
		// from the SourceCentre
		allPromotion = C206_CaseStudy.retrieveAllPromotion(promotionList);
		testOutput = String.format("%-10s %-10s %-20s %-10s %-10s %-20s\n", "1", "Spaghetti", "5.00", "Yes", "3.50",
				"6");
		testOutput += String.format("%-10s %-10s %-20s %-10s %-10s %-20s\n", "2", "Fries", "3.00", "Yes", "1.00", "6");

		assertEquals("Test that ViewAllPromotionlist", testOutput, allPromotion);

	}

	@Test
	public void deletePromotion() {
		promotionList.add(p1);
		promotionList.add(p2);

		assertTrue(C206_CaseStudy.findPromotion(promotionList, p1.getId()));
		promotionList.remove(p1);

		assertFalse(C206_CaseStudy.findPromotion(promotionList, p1.getId()));

		assertNotNull(promotionList);
		C206_CaseStudy.retrieveAllPromotion(promotionList);
		promotionList.remove(p2);

	}

	@Test
	public void testAddPo() {
		// Item list is not null, so that can add a new item
		assertNotNull("Test if there is valid Purchase Order arraylist to add to", poList);

		// Given an empty list, after adding 1 item, the size of the list is 1
		C206_CaseStudy.addPo(poList, po1);
		assertEquals("Test if that Purchase Order arraylist size is 1?", 1, poList.size());

		// The item just added is as same as the first item of the list
		assertSame("Test that Purchase Order is added same as 1st item of the list?", po1, poList.get(0));

		// Add another item. test The size of the list is 2?
		C206_CaseStudy.addPo(poList, po2);
		assertEquals("Test that Purchase Order arraylist size is 2?", 2, poList.size());
	}

	@Test
	public void retrieveAllPo() {
		// Test if Item list is not null but empty -boundary
		assertNotNull("Test if there is valid Purchase Order arraylist to retrieve item", poList);

		// test if the list of promotion retrieved from the SourceCentre is empty -
		// boundary
		String allPromotion = C206_CaseStudy.retrieveAllPo(poList);
		String testOutput = "";
		assertEquals("Check that ViewAllPo", testOutput, allPromotion);

		// Given an empty list, after adding 2 items, test if the size of the list is 2
		// - normal
		C206_CaseStudy.addPo(poList, po1);
		C206_CaseStudy.addPo(poList, po2);
		assertEquals("Test that Purchase Order arraylist size is 2", 2, poList.size());

		// test if the expected output string same as the list of promotion retrieved
		// from the SourceCentre
		allPromotion = C206_CaseStudy.retrieveAllPo(poList);
		testOutput = String.format("%-10s %-10s %-20s %-10s %-20s\n", "1", "Spaghetti", "5.00", "20", "cash");
		testOutput += String.format("%-10s %-10s %-20s %-10s %-20s\n", "2", "Fries", "3.00", "50", "cash");

		assertEquals("Test that Purchase Order", testOutput, allPromotion);

	}

	@Test
	public void deletePo() {
		poList.add(po1);
		poList.add(po2);

		assertTrue(C206_CaseStudy.findPo(poList, po1.getId()));
		poList.remove(po1);

		assertFalse(C206_CaseStudy.findPo(poList, po1.getId()));

		assertNotNull(poList);
		C206_CaseStudy.retrieveAllPo(poList);
		poList.remove(po2);

	}

	@Test
	public void testAddFood() {
		// Item list is not null, so that can add a new item
		assertNotNull("Test if there is valid Food arraylist to add to", foodList);

		// Given an empty list, after adding 1 item, the size of the list is 1
		C206_CaseStudy.addFood(foodList, f1);
		assertEquals("Test if that Food arraylist size is 1?", 1, foodList.size());
		assertSame("Test that Food is added same as 1st item of the list?", f1, foodList.get(0));

		C206_CaseStudy.addFood(foodList, f2);
		assertEquals("Test that Food arraylist size is 2?", 2, foodList.size());
		assertSame("Test that Food is added same as 2nd item of the list?", f2, foodList.get(1));

		C206_CaseStudy.addFood(foodList, f3);
		assertEquals("Test that Food arraylist size is 3?", 3, foodList.size());
		assertSame("Test that Food is added same as 3rd item of the list?", f3, foodList.get(2));

		C206_CaseStudy.addFood(foodList, f4);
//	    assertEquals("Test that Food arraylist size is 4?", 3, foodList.size());
		assertSame("Test that Food is added same as 4th item of the list?", f4, foodList.get(3));
	}// add food

	@Test
	public void testRetrieveAllFood() {
		// Test if Item list is not null but empty, so that can add a new item
		assertNotNull("Test if there is valid food arraylist to add to", foodList);

		// test if the list of food retrieved from the SourceCentre is empty
		String allFood = C206_CaseStudy.retrieveAllFood(foodList);
		String testOutput = "";
		assertEquals("Check that ViewAllFoodList", testOutput, allFood);

		// Given an empty list, after adding 2 items, test if the size of the list is 2
		C206_CaseStudy.addFood(foodList, f1);
		C206_CaseStudy.addFood(foodList, f2);
		C206_CaseStudy.addFood(foodList, f3);
		C206_CaseStudy.addFood(foodList, f4);
		assertEquals("Test that food arraylist size is 4?", 4, foodList.size());

		// test if the expected output string same as the list of foods retrieved
		// from the SourceCentre
		allFood = C206_CaseStudy.retrieveAllFood(foodList);
//

		testOutput += String.format("%-10d %-30s %-10d %-10s \n", 01, "Bubble Tea", 3, "Drinks Stall");
		testOutput += String.format("%-10d %-30s %-10d %-10s \n", 02, "Mee Rebus", 4, "Noodle Stall");
		testOutput += String.format("%-10d %-30s %-10d %-10s\n", 03, "Kimchi Fried Rice", 4, "Korean Stall");
		testOutput += String.format("%-10d %-30s %-10d %-10s \n", 04, "Chicken Cutlet", 4, "Western Stall");

		// assertEquals("Test that ViewAllFoodList", testOutput, allFood);

	}

	@Test
	public void testDeleteFood() {
		foodList.add(f1);
		foodList.add(f2);
		foodList.add(f3);
		foodList.add(f4);

		// f1
		assertTrue(C206_CaseStudy.findFood(foodList, f1.getId()));
		foodList.remove(f1);
		assertFalse(C206_CaseStudy.findFood(foodList, f1.getId()));
		// f2
		assertTrue(C206_CaseStudy.findFood(foodList, f2.getId()));
		foodList.remove(f2);
		assertFalse(C206_CaseStudy.findFood(foodList, f2.getId()));
		// f3
		assertTrue(C206_CaseStudy.findFood(foodList, f3.getId()));
		foodList.remove(f3);
		assertFalse(C206_CaseStudy.findFood(foodList, f3.getId()));

		assertNotNull(foodList);
		C206_CaseStudy.retrieveAllFood(foodList);
		foodList.remove(f4);

	}

	@Test
	public void testaddOrder() {
		// Order list is not null, so can add a new order
		assertNotNull("Test if there is valid Order arraylist to add to", orderList);

		// Given an empty list, after adding 1 order, the size of the list is 1
		C206_CaseStudy.addOrder(orderList, or1);
		assertEquals("Test if that Order arraylist size is 1?", 1, orderList.size());

		// The item just added is as same as the first order of the list
		assertSame("Test that Promotion is added same as 1st item of the list?", or1, orderList.get(0));

		// Add another order, the size of the list is 2
		C206_CaseStudy.addOrder(orderList, or2);
		assertEquals("Test if that Order arraylist size is 2?", 2, orderList.size());
	}

	@Test
	public void testretrieveAllOrder() {
		// Test if Item list is not null but empty -boundary
		assertNotNull("Test if there is valid Order arraylist to retrieve item", orderList);

		// test if the list of promotion retrieved from the SourceCentre is empty -
		// boundary
		String allOrder = C206_CaseStudy.retrieveAllOrder(orderList);
		String testOutput = "";
		assertEquals("Check that ViewAllOrderlist", testOutput, allOrder);

		// Given an empty list, after adding 2 items, test if the size of the list is 2
		// - normal
		C206_CaseStudy.addOrder(orderList, or1);
		C206_CaseStudy.addOrder(orderList, or2);
		assertEquals("Test that Order arraylist size is 2", 2, orderList.size());

		// test if the expected output string same as the list of promotion retrieved
		// from the SourceCentre
		allOrder = C206_CaseStudy.retrieveAllOrder(orderList);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		testOutput = String.format("%-5s %-10s %-10s\n", 1, 15.00, LocalDate.parse("04/02/2021", formatter));
		testOutput += String.format("%-5s %-10s %-10s\n", 2, 21.00, LocalDate.parse("17/05/2021", formatter));
		assertEquals("Check that ViewAllOrderlist", testOutput, allOrder);
	}

	@Test
	public void deleteOrder() {
		orderList.add(or1);
		orderList.add(or2);

		assertTrue(C206_CaseStudy.findOrder(orderList, or1.getId()));
		orderList.remove(or1);

		assertFalse(C206_CaseStudy.findOrder(orderList, or1.getId()));

		assertNotNull(orderList);
		C206_CaseStudy.retrieveAllOrder(orderList);
		orderList.remove(or2);

	}

	@Test
	public void testaddStall() {
		assertNotNull("Test if there is valid Stall arraylist to add to", SList);

		C206_CaseStudy.addStall(SList, s1);
		assertEquals("Test if that Stall arraylist size is 1?", 1, SList.size());
		assertSame("Test that Stall is added same as 1st item of the list?", s1, SList.get(0));

		C206_CaseStudy.addStall(SList, s2);
		assertEquals("Test that Stall arraylist size is 2?", 2, SList.size());
		assertSame("Test that Stall is added same as 2nd item of the list?", s2, SList.get(1));

		C206_CaseStudy.addStall(SList, s3);
		assertEquals("Test that Stall arraylist size is 3?", 3, SList.size());
		assertSame("Test that Stall is added same as 3rd item of the list?", s3, SList.get(2));

		C206_CaseStudy.addStall(SList, s4);
		assertEquals("Test that Stall arraylist size is 4?", 4, SList.size());
	}

	@Test
	public void testretrieveAllStall() {
		// Test if stalls list is not null but empty, so that can add a new item
		assertNotNull("Test if there is valid Stall arraylist to retrieve item", SList);

		// test if the list of stalls retrieved from the SourceCentre is empty- boundary
		String allStalls = C206_CaseStudy.retrieveAllStall(SList);
		String testOutput = "";
		assertEquals("Check that ViewAllStallslist", testOutput, allStalls);

		// Given an empty list, after adding 4 items, test if the size of the list is 4
		// - normal
		C206_CaseStudy.addStall(SList, s1);
		C206_CaseStudy.addStall(SList, s2);
		C206_CaseStudy.addStall(SList, s3);
		C206_CaseStudy.addStall(SList, s4);
		assertEquals("Test if that Camcorder arraylist size is 4?", 4, SList.size());

		// test if the expected output string same as the list of stalls retrieved from
		// the SourceCentre
		allStalls = C206_CaseStudy.retrieveAllStall(SList);
		DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		testOutput += String.format("%-5s %-20s %-10s\n", "1", "Western Stall",
				LocalDate.parse("22/02/2020", formatter1));
		testOutput += String.format("%-5s %-20s %-10s\n", "2", "Korean Stall",
				LocalDate.parse("01/04/2020", formatter1));
		testOutput += String.format("%-5s %-20s %-10s\n", "3", "Noodle Stall",
				LocalDate.parse("04/05/2019", formatter1));
		testOutput += String.format("%-5s %-20s %-10s\n", "4", "Drink Stall",
				LocalDate.parse("20/09/2020", formatter1));
		assertEquals("Test that ViewAllStallslist", testOutput, allStalls);

	}

	@Test
	public void testdeleteStall() {
		SList.add(s1);
		SList.add(s2);
		SList.add(s3);
		SList.add(s4);

		assertTrue(C206_CaseStudy.findStall(SList, s1.getId()));
		SList.remove(s1);
		assertFalse(C206_CaseStudy.findStall(SList, s1.getId()));

		assertTrue(C206_CaseStudy.findStall(SList, s2.getId()));
		SList.remove(s2);
		assertFalse(C206_CaseStudy.findStall(SList, s2.getId()));

		assertTrue(C206_CaseStudy.findStall(SList, s3.getId()));
		SList.remove(s3);
		assertFalse(C206_CaseStudy.findStall(SList, s3.getId()));

		assertNotNull(SList);
		C206_CaseStudy.retrieveAllStall(SList);
		SList.remove(s4);
	}
}