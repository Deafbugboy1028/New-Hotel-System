import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Customer extends User {

	public Customer() {
	}

	public void reserve() {

	}

	public void cancel() {

	}

	public void askQuestions(Scanner sc, ArrayList<Hotel> hotels,
			ArrayList<String> resInfo) {

		double price;
		price = 0;

		int choice = 0;
		String string = null;
		while (true) {
			System.out.println("Thanks for choosing L4 Hotels. \n\nWould you like to make 1) a reservation or 2) cancel an existing booking ?");
			choice = sc.nextInt();
			switch (choice) {
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

				System.out.println("Here is your choice of rooms for hotel type chosen.\n\nWhich room would you like ?\n");

				for (int i = 0; i < hotels.get(hotelChoice - 1).getRoomList().size(); i++) {
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

				System.out.println("Please enter your forename name please !");
				String name = sc.next(); // verify later
				hotels.get(hotelChoice - 1).getRoomList().get(roomChoice - 1).setName(name);

				System.out.println("Please enter your contact number " + name);
				int number = sc.nextInt();
				hotels.get(hotelChoice - 1).getRoomList().get(roomChoice - 1).setNum(number);
				String roomInfo = roomType + "," + number;
				resInfo.add(roomInfo);

				System.out.println("Thanks, your number will be used as a reference for your current booking.");

				System.out.println("How many nights do you plan to stay.?");
				int nights = sc.nextInt();
				hotels.get(hotelChoice - 1).getRoomList().get(roomChoice - 1).setNights(nights);

				System.out.println("And finally, what day of the week will you be arriving.");
				String arrives = sc.next();

				int i = 0;
				/*
				 * while(true){
				 * 
				 * if(hotels.get(hotelChoice -1).getRoomList().get(roomChoice
				 * -1).getDays()[i].compareToIgnoreCase(arrives)==0) {
				 * 
				 * price += hotels.get(hotelChoice
				 * -1).getRoomList().get(roomChoice -1).getRates()[i]; } else
				 * if(i== hotels.get(hotelChoice
				 * -1).getRoomList().get(roomChoice -1).getDays().length ){ i=0;
				 * } }
				 */
				
				System.out.println("The resevation has been made.\n\nDue to a billing malfunction we cannot at this moment proccess the bill. You may pay on checkout :-D");
				System.out.println("\nAdmin note: Successful reservations have been written to, and are viewable in resInfo.csv");
				System.out.println("\nEnd of session, program will terminate now :-) ");

				break;

			case 2:
				while (true) {
					System.out.println("Sorry to hear you will not be staying with us. \n\nPlease enter your phone number which was used when you first booked with us to reference your reservation");
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
					}
				}
			}

			break;

		}
	}
}
