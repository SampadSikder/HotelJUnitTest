import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class HotelTest {

    private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private static final PrintStream originalOut = System.out;
    private static final InputStream originalIn = System.in;
    private Hotel hotel;

    @BeforeAll
    public static void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterAll
    public static void restoreStreams() {
        System.setOut(originalOut);
        System.setIn(originalIn);
    }

    @Test
    public void testCustDetails(){
        String input = "John\n1234567890\nMale\nJane\n9876543210\nFemale\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        Scanner mockScanner = new Scanner(System.in);

        // Create a Hotel object and set the mock Scanner
        Hotel hotel = new Hotel();
        hotel.sc = mockScanner;

        // Call CustDetails with some inputs
        int roomType = 1;
        int roomNumber = 0;
        hotel.CustDetails(roomType, roomNumber);

        assertEquals("John", hotel.hotel_ob.luxury_doublerrom[roomNumber].name);
        assertEquals("1234567890", hotel.hotel_ob.luxury_doublerrom[roomNumber].contact);
        assertEquals("Male", hotel.hotel_ob.luxury_doublerrom[roomNumber].gender);
        assertEquals("Jane", hotel.hotel_ob.luxury_doublerrom[roomNumber].name2);
        assertEquals("9876543210", hotel.hotel_ob.luxury_doublerrom[roomNumber].contact2);
        assertEquals("Female", hotel.hotel_ob.luxury_doublerrom[roomNumber].gender2);
    }
    @Test
    public void testCustDetails2(){
        String input = "John\n1234567890\nMale\nJane\n9876543210\nFemale\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        Scanner mockScanner = new Scanner(System.in);

        // Create a Hotel object and set the mock Scanner
        Hotel hotel = new Hotel();
        hotel.sc = mockScanner;

        // Call CustDetails with some inputs
        int roomType = 2;
        int roomNumber = 0;
        hotel.CustDetails(roomType, roomNumber);


        assertEquals("John", hotel.hotel_ob.deluxe_doublerrom[roomNumber].name);
        assertEquals("1234567890", hotel.hotel_ob.deluxe_doublerrom[roomNumber].contact);
        assertEquals("Male", hotel.hotel_ob.deluxe_doublerrom[roomNumber].gender);
        assertEquals("Jane", hotel.hotel_ob.deluxe_doublerrom[roomNumber].name2);
        assertEquals("9876543210", hotel.hotel_ob.deluxe_doublerrom[roomNumber].contact2);
        assertEquals("Female", hotel.hotel_ob.deluxe_doublerrom[roomNumber].gender2);
    }

    @Test
    public void testCustDetails3(){
        String input = "John\n1234567890\nMale";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        Scanner mockScanner = new Scanner(System.in);

        // Create a Hotel object and set the mock Scanner
        Hotel hotel = new Hotel();
        hotel.sc = mockScanner;

        // Call CustDetails with some inputs
        int roomType = 3;
        int roomNumber = 0;
        hotel.CustDetails(roomType, roomNumber);


        assertEquals("John", hotel.hotel_ob.luxury_singleerrom[roomNumber].name);
        assertEquals("1234567890", hotel.hotel_ob.luxury_singleerrom[roomNumber].contact);
        assertEquals("Male", hotel.hotel_ob.luxury_singleerrom[roomNumber].gender);
    }

    @Test
    public void testCustDetails4(){
        String input = "John\n1234567890\nMale";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        Scanner mockScanner = new Scanner(System.in);

        // Create a Hotel object and set the mock Scanner
        Hotel hotel = new Hotel();
        hotel.sc = mockScanner;

        // Call CustDetails with some inputs
        int roomType = 4;
        int roomNumber = 0;
        hotel.CustDetails(roomType, roomNumber);


        assertEquals("John", hotel.hotel_ob.deluxe_singleerrom[roomNumber].name);
        assertEquals("1234567890", hotel.hotel_ob.deluxe_singleerrom[roomNumber].contact);
        assertEquals("Male", hotel.hotel_ob.deluxe_singleerrom[roomNumber].gender);
    }

    @Test
    public void testCustDetailsWithInvalidInput() {
        String invalidInput = "John\n1234567890\n"; // Missing gender
        ByteArrayInputStream inputStream = new ByteArrayInputStream(invalidInput.getBytes());
        System.setIn(inputStream);
        Scanner mockScanner = new Scanner(System.in);
        Hotel hotel = new Hotel();
        hotel.sc = mockScanner;


        int roomType = 5;
        int roomNumber = 0;
        hotel.CustDetails(roomType, roomNumber);

        String printedOutput = outContent.toString().trim();
        String expectedOutput = "Wrong option";
        assertEquals(expectedOutput, printedOutput);

    }

    @Test
    public void testBookroomValidInput() {
        int roomType = 1;

        int selectedRoomNumber = 1;
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        hotel.bookroom(roomType);

        System.setOut(System.out);

        assertTrue(outContent.toString().contains("Room Booked"));
    }

    @Test
    public void testBookroomValidInput2() {
        int roomType = 2;

        int selectedRoomNumber = 1;
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        hotel.bookroom(roomType);

        System.setOut(System.out);

        assertTrue(outContent.toString().contains("Room Booked"));
    }
    @Test
    public void testBookroomValidInput3() {
        int roomType = 3;

        int selectedRoomNumber = 1;
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        hotel.bookroom(roomType);

        System.setOut(System.out);

        assertTrue(outContent.toString().contains("Room Booked"));
    }
    @Test
    public void testBookroomValidInput4() {
        int roomType = 4;

        int selectedRoomNumber = 1;
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        hotel.bookroom(roomType);

        System.setOut(System.out);

        assertTrue(outContent.toString().contains("Room Booked"));
    }
    @Test
    public void testBookroomWithInvalidRoomType() {
        Hotel hotel = new Hotel();
        hotel.sc = new Scanner(System.in);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        hotel.bookroom(5); // Invalid room type

        System.setOut(System.out);

        assertTrue(outContent.toString().contains("Enter valid option"));
    }

    @Test
    public void testWrongBillDeluxeDoubleRoom() {
        Hotel hotel = new Hotel();

        // Create a sample deluxe double room and add some food items to it
        Doubleroom deluxeDoubleRoom = new Doubleroom("Alice", "1111111111", "Female", "Bob", "2222222222", "Male");
        deluxeDoubleRoom.food.add(new Food(2, 3)); // Pasta
        deluxeDoubleRoom.food.add(new Food(4, 2)); // Coke

        // Set the deluxe double room in the hotel
        hotel.hotel_ob.deluxe_doublerrom[1] = deluxeDoubleRoom;

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        hotel.bill(1, 2);

        System.setOut(System.out);

        double expectedOutput = 2000.0;
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testBillDeluxeDoubleRoom() {
        Hotel hotel = new Hotel();

        // Create a sample deluxe double room and add some food items to it
        Doubleroom deluxeDoubleRoom = new Doubleroom("Alice", "1111111111", "Female", "Bob", "2222222222", "Male");
        deluxeDoubleRoom.food.add(new Food(2, 3)); // Pasta
        deluxeDoubleRoom.food.add(new Food(4, 2)); // Coke

        // Set the deluxe double room in the hotel
        hotel.hotel_ob.deluxe_doublerrom[1] = deluxeDoubleRoom;

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        hotel.bill(1, 2);

        System.setOut(System.out);

        double expectedOutput = 3240.0;
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testBillLuxurySingleRoom() {
        Hotel hotel = new Hotel();

        // Create a sample luxury single room and add some food items to it
        Singleroom luxurySingleRoom = new Singleroom("Eve", "3333333333", "Female");
        luxurySingleRoom.food.add(new Food(1, 1)); // Sandwich

        // Set the luxury single room in the hotel
        hotel.hotel_ob.luxury_singleerrom[2] = luxurySingleRoom;

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        double bill=hotel.bill(2, 3);

        System.setOut(System.out);

        double expectedOutput = 2250.0;
        assertEquals(expectedOutput, bill);
    }

    @Test
    public void testBillDeluxeSingleRoom() {
        Hotel hotel = new Hotel();

        // Create a sample deluxe single room and add some food items to it
        Singleroom deluxeSingleRoom = new Singleroom("Charlie", "4444444444", "Male");
        deluxeSingleRoom.food.add(new Food(3, 2)); // Noodles
        deluxeSingleRoom.food.add(new Food(4, 1)); // Coke

        // Set the deluxe single room in the hotel
        hotel.hotel_ob.deluxe_singleerrom[3] = deluxeSingleRoom;

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        double bill=hotel.bill(3, 4);

        System.setOut(System.out);

        double expectedOutput = 1370.0;
        assertEquals(expectedOutput, expectedOutput);
    }

    @Test
    public void testCalculatePriceForSandwich() {
        Food sandwich = new Food(1, 2); // Item 1 represents Sandwich, quantity = 2
        double expectedPrice = 2 * 50.0; // Price for a Sandwich is 50, so total price = 2 * 50

        assertEquals(expectedPrice, sandwich.price, 0.01); // Use an appropriate delta (tolerance) value
    }

    @Test
    public void testCalculatePriceForPasta() {
        Food pasta = new Food(2, 3); // Item 2 represents Pasta, quantity = 3
        double expectedPrice = 3 * 60.0; // Price for Pasta is 60, so total price = 3 * 60

        assertEquals(expectedPrice, pasta.price, 0.01); // Use an appropriate delta (tolerance) value
    }

    @Test
    public void testCalculatePriceForNoodles() {
        Food noodles = new Food(3, 4); // Item 3 represents Noodles, quantity = 4
        double expectedPrice = 4 * 70.0; // Price for Noodles is 70, so total price = 4 * 70

        assertEquals(expectedPrice, noodles.price, 0.01); // Use an appropriate delta (tolerance) value
    }

    @Test
    public void testCalculatePriceForCoke() {
        Food coke = new Food(4, 5); // Item 4 represents Coke, quantity = 5
        double expectedPrice = 5 * 30.0; // Price for Coke is 30, so total price = 5 * 30

        assertEquals(expectedPrice, coke.price, 0.01); // Use an appropriate delta (tolerance) value
    }




    @Test
    public void testDeallocateLuxuryDoubleRoomWithCheckout() {
        Hotel hotel = new Hotel();
        hotel.sc = new Scanner(System.in);

        // Create a luxury double room and set it in the hotel
        Doubleroom luxuryDoubleRoom = new Doubleroom("Alice", "1111111111", "Female", "Bob", "2222222222", "Male");
        hotel.hotel_ob.luxury_doublerrom[0] = luxuryDoubleRoom;

        // Capture the output and simulate user input for checkout (y)
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        ByteArrayInputStream inContent = new ByteArrayInputStream("y\n".getBytes());
        System.setOut(new PrintStream(outContent));
        System.setIn(inContent);

        hotel.deallocate(0, 1); // Deallocate luxury double room

        System.setOut(System.out);
        System.setIn(System.in);

        assertTrue(outContent.toString().contains("Deallocated successfully"));
        assertNull(hotel.hotel_ob.luxury_doublerrom[0]); // Ensure the room is deallocated
    }

    @Test
    public void testDeallocateLuxuryDoubleRoomWithoutCheckout() {
        Hotel hotel = new Hotel();
        hotel.sc = new Scanner(System.in);

        // Create a luxury double room and set it in the hotel
        Doubleroom luxuryDoubleRoom = new Doubleroom("Alice", "1111111111", "Female", "Bob", "2222222222", "Male");
        hotel.hotel_ob.luxury_doublerrom[0] = luxuryDoubleRoom;

        // Capture the output and simulate user input for no checkout (n)
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        ByteArrayInputStream inContent = new ByteArrayInputStream("n\n".getBytes());
        System.setOut(new PrintStream(outContent));
        System.setIn(inContent);

        hotel.deallocate(0, 1); // Deallocate luxury double room

        System.setOut(System.out);
        System.setIn(System.in);

        assertTrue(outContent.toString().contains("Room used by Alice"));
        assertNotNull(hotel.hotel_ob.luxury_doublerrom[0]); // Ensure the room is not deallocated
    }

    @Test
    public void testDeallocateEmptyLuxuryDoubleRoom() {
        Hotel hotel = new Hotel();
        hotel.sc = new Scanner(System.in);

        // Capture the output and simulate user input for no checkout (n)
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        ByteArrayInputStream inContent = new ByteArrayInputStream("n\n".getBytes());
        System.setOut(new PrintStream(outContent));
        System.setIn(inContent);

        hotel.deallocate(0, 1); // Deallocate empty luxury double room

        System.setOut(System.out);
        System.setIn(System.in);

        assertTrue(outContent.toString().contains("Empty Already"));
    }

    @Test
    public void testDeallocateInvalidRoomType() {
        Hotel hotel = new Hotel();
        hotel.sc = new Scanner(System.in);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        hotel.deallocate(0, 5); // Invalid room type

        System.setOut(System.out);

        assertTrue(outContent.toString().contains("Enter valid option"));
    }

    @Test
    public void testOrderFoodForLuxuryDoubleRoom() {
        Hotel hotel = new Hotel();
        hotel.sc = new Scanner(System.in);

        // Create a luxury double room and set it in the hotel
        Doubleroom luxuryDoubleRoom = new Doubleroom("Alice", "1111111111", "Female", "Bob", "2222222222", "Male");
        hotel.hotel_ob.luxury_doublerrom[0] = luxuryDoubleRoom;

        // Capture the output and simulate user input for ordering food items
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        ByteArrayInputStream inContent = new ByteArrayInputStream("1\n2\n3\nn\n".getBytes());
        System.setOut(new PrintStream(outContent));
        System.setIn(inContent);

        hotel.order(0, 1); // Order food for luxury double room

        System.setOut(System.out);
        System.setIn(System.in);

        assertTrue(outContent.toString().contains("Do you want to order anything else ? (y/n)"));

        // Verify that food items are added to the correct room's food list
        assertEquals(3, hotel.hotel_ob.luxury_doublerrom[0].food.size());
    }

    @Test
    public void testOrderWithNullPointerException() {
        Hotel hotel = new Hotel();
        hotel.sc = new Scanner(System.in);

        // Try to order food for a room that is not booked
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        ByteArrayInputStream inContent = new ByteArrayInputStream("1\n2\n3\nn\n".getBytes());
        System.setOut(new PrintStream(outContent));
        System.setIn(inContent);

        hotel.order(0, 1); // Try to order food for an unbooked room

        System.setOut(System.out);
        System.setIn(System.in);

        assertTrue(outContent.toString().contains("Room not booked"));
    }

    @Test
    public void testOrderWithGenericException() {
        Hotel hotel = new Hotel();
        hotel.sc = new Scanner(System.in);

        // Simulate an exception while ordering food
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        ByteArrayInputStream inContent = new ByteArrayInputStream("InvalidInput\nn\n".getBytes());
        System.setOut(new PrintStream(outContent));
        System.setIn(inContent);

        hotel.order(0, 1); // Simulate an exception while ordering food

        System.setOut(System.out);
        System.setIn(System.in);

        assertTrue(outContent.toString().contains("Cannot be done"));
    }


    @Test
    public void testOrderFoodForDeluxeDoubleRoom() {
        Hotel hotel = new Hotel();
        hotel.sc = new Scanner(System.in);

        // Create a deluxe double room and set it in the hotel
        Doubleroom deluxeDoubleRoom = new Doubleroom("Carol", "3333333333", "Female", "Dave", "4444444444", "Male");
        hotel.hotel_ob.deluxe_doublerrom[0] = deluxeDoubleRoom;

        // Capture the output and simulate user input for ordering food items
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        ByteArrayInputStream inContent = new ByteArrayInputStream("1\n2\n3\nn\n".getBytes());
        System.setOut(new PrintStream(outContent));
        System.setIn(inContent);

        hotel.order(0, 2); // Order food for deluxe double room

        System.setOut(System.out);
        System.setIn(System.in);

        assertTrue(outContent.toString().contains("Do you want to order anything else ? (y/n)"));

        // Verify that food items are added to the correct room's food list
        assertEquals(3, hotel.hotel_ob.deluxe_doublerrom[0].food.size());
    }

    @Test
    public void testOrderFoodForLuxurySingleRoom() {
        Hotel hotel = new Hotel();
        hotel.sc = new Scanner(System.in);

        // Create a luxury single room and set it in the hotel
        Singleroom luxurySingleRoom = new Singleroom("Eve", "5555555555", "Female");
        hotel.hotel_ob.luxury_singleerrom[0] = luxurySingleRoom;

        // Capture the output and simulate user input for ordering food items
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        ByteArrayInputStream inContent = new ByteArrayInputStream("1\n2\n3\nn\n".getBytes());
        System.setOut(new PrintStream(outContent));
        System.setIn(inContent);

        hotel.order(0, 3); // Order food for luxury single room

        System.setOut(System.out);
        System.setIn(System.in);

        assertTrue(outContent.toString().contains("Do you want to order anything else ? (y/n)"));

        // Verify that food items are added to the correct room's food list
        assertEquals(3, hotel.hotel_ob.luxury_singleerrom[0].food.size());
    }

    @Test
    public void testOrderFoodForDeluxeSingleRoom() {
        Hotel hotel = new Hotel();
        hotel.sc = new Scanner(System.in);

        // Create a deluxe single room and set it in the hotel
        Singleroom deluxeSingleRoom = new Singleroom("Frank", "6666666666", "Male");
        hotel.hotel_ob.deluxe_singleerrom[0] = deluxeSingleRoom;

        // Capture the output and simulate user input for ordering food items
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        ByteArrayInputStream inContent = new ByteArrayInputStream("1\n2\n3\nn\n".getBytes());
        System.setOut(new PrintStream(outContent));
        System.setIn(inContent);

        hotel.order(0, 4); // Order food for deluxe single room

        System.setOut(System.out);
        System.setIn(System.in);

        assertTrue(outContent.toString().contains("Do you want to order anything else ? (y/n)"));

        // Verify that food items are added to the correct room's food list
        assertEquals(3, hotel.hotel_ob.deluxe_singleerrom[0].food.size());
    }

}


