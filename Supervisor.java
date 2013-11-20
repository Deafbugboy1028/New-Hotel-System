import java.util.ArrayList;
import java.util.Scanner;

public class Supervisor extends User {

	private String password;

	public Supervisor() {
		password = "5up3rv150r";
	}

	public void checkIn() {
	}

	public void checkOut() {
	}

	public void applyDiscount() {
	}

	public void requestData() {
	}

	
	public void reserve() {
		

	}

	
	public void cancel() {
		

	}

	public void askQuestions(Scanner sc, ArrayList<Hotel>hotels, ArrayList<String> resInfo) {
		
		int choice =0;
		
	System.out.println("Hello Supervisor. Please enter correct password to login to L4 Hotel's Reservation System.");
	
		while (sc.next().compareTo(password) != 0) {
			System.out.println("Incorrect password, Please try again...");
			}
		System.out.println("Thank you & welcome to the L4 reservation console. \n\nWould you like to make a (1) reservation or (2) cancelation on behalf of the customer.");
		choice = sc.nextInt();
		
		switch(choice){
		case 1: 
			System.out.println("Which hotel type would you like: 1) 5*, 2) 4* or 3) 3*");
			int hotelChoice;
			while(true)
			{
				try {
					 hotelChoice = sc.nextInt();
					break;
				} catch (Exception e){
					System.out.println("Please enter a valid token");
					continue;
				}
			}

			System.out.println("Here is your choice of rooms for hotel type chosen.\n\nWhich room would you like to reserve for the customer ?\n");

			for (int i = 0; i < hotels.get(hotelChoice - 1).getRoomList()
					.size(); i++) {
				System.out.println(i+ 1+ ")"+ hotels.get(hotelChoice - 1).getRoomList().get(i).getType() + " ");

			}
			int roomChoice = sc.nextInt();
			hotels.get(hotelChoice - 1).getRoomList().get(roomChoice - 1).setNum(hotels.get(hotelChoice - 1).getRoomList().get(roomChoice - 1).getNum() - 1);
			
			String roomType = hotels.get(hotelChoice - 1).getRoomList().get(roomChoice - 1).getType();

			while (true) {
				System.out.println("How many adults will be staying. ?");
				int adults = sc.nextInt();
				
				if (adults > hotels.get(hotelChoice - 1).getRoomList().get(roomChoice - 1).getMaxAdults()) {
					System.out.println("Currently the max Adult occupancy for this room is "+ hotels.get(hotelChoice - 1).getRoomList().get(roomChoice - 1).getMaxAdults());
					continue; // brings you back to the start of the loop
				}
				
				hotels.get(hotelChoice - 1).getRoomList().get(roomChoice - 1).setCurrentAdults(adults);
				
				break;
			}

			while (true) {
				System.out.println("How many children will be staying. ?");
				int children = sc.nextInt();
				
				if (children > hotels.get(hotelChoice - 1).getRoomList().get(roomChoice - 1).getMaxChildren()) {
					System.out.println("Currently the max child occupancy for this room is "+ hotels.get(hotelChoice - 1).getRoomList().get(roomChoice - 1).getMaxChildren());
					continue;
				}
				hotels.get(hotelChoice - 1).getRoomList().get(roomChoice - 1).setCurrentChildren(children);
				break;
			}

			System.out.println("Please enter the customers forename name please.");
			String name = sc.next(); // verify later
			hotels.get(hotelChoice - 1).getRoomList().get(roomChoice - 1).setName(name);

			System.out.println("Please enter their contact number ");
			int number = sc.nextInt();
			hotels.get(hotelChoice - 1).getRoomList().get(roomChoice - 1).setNum(number);
			String roomInfo = roomType + "," + number;
			resInfo.add(roomInfo);

			System.out.println("Thanks, their number will be used as a reference for their booking.");

			System.out.println("How many nights do they plan to stay.?");
			int nights = sc.nextInt();
			hotels.get(hotelChoice - 1).getRoomList().get(roomChoice - 1).setNights(nights);

			System.out
					.println("And finally, what day of the week will they be arriving.");
			String arrives = sc.next();
			
			System.out.println("The resevation has been made.\n\nDue to a billing malfunction we cannot at this moment proccess the bill.");
			System.out.println("\nEnd of session, program will terminate now :-) ");
			break;

		case 2:
			while (true) {
				System.out.println("Please enter the customers phone number which was used when they first booked with us to reference their reservation");
				int phoneNum = sc.nextInt();
				
				for (int j = 0; j < resInfo.size(); j++) {
					String[] resInfoLine = new String[2];
					resInfoLine = resInfo.get(j).split(",");
					System.out.println(resInfoLine[0]);
					
					if (phoneNum == Integer.parseInt(resInfoLine[1]))
					{
						for(int k=0; k<hotels.size(); k++){
							for(int l=0; l<hotels.get(k).getRoomList().size(); l++){
								if(hotels.get(k).getRoomList().get(l).getType().compareToIgnoreCase(resInfoLine[0])==0){
									hotels.get(k).getRoomList().get(l).setNum(hotels.get(k).getRoomList().get(l).getNum() +1);
									break;
								}
							}
						}
					}
					if (j == resInfo.size()){
						System.out.println("Sorry number wasnt found, Please re-enter.");
						
					}
				}break;
		
		
	}
	
		
		
		
}		
}	
		
		
}