package dataStructureAlgorithms.collection.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import dataStructureAlgorithms.collection.Guest;
import dataStructureAlgorithms.collection.Room;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GuestServiceTest {

	GuestService service;
	
	Room piccadilly = new Room("Piccadilly", "Guest Room", 3, 125.00);
	Room cambridge = new Room("Cambridge", "Premiere Room", 4, 175.00);
	Room westminister = new Room("Westminister", "Premiere Room", 4, 175.00);
	Room oxford = new Room("Oxford", "Suite", 5, 225.0);
	Room victoria = new Room("Victoria", "Suite", 5, 225.0);
	Room manchester = new Room("Manchester", "Suite", 5, 225.0);
	
	Guest john, maria, sonia, siri, bob;

	@BeforeEach
	void setUp() throws Exception {
		
		this.service = new GuestService();

		john = new Guest("John", "Doe", false);
		/*
		john.getPreferredRooms().addAll(List.of(oxford, victoria, manchester));
		*/
		john.setPreferredRooms(oxford);
		john.setPreferredRooms(victoria);
		john.setPreferredRooms(manchester);

		maria = new Guest("Maria", "Doe", true);
		/*
		maria.getPreferredRooms().addAll(List.of(cambridge, oxford));
		*/
		maria.setPreferredRooms(cambridge);
		maria.setPreferredRooms(oxford);

		sonia = new Guest("Sonia", "Doe", true);
		/*
		sonia.getPreferredRooms().addAll(List.of(cambridge));
		*/
		sonia.setPreferredRooms(cambridge);

		siri = new Guest("Siri", "Doe", true);

		bob = new Guest("Bob", "Doe", false);
	
	}

	@Test
	void testFilterByFavoriteRoom() {
		this.service.checkIn(bob);
		this.service.checkIn(maria);
		this.service.checkIn(sonia);
		this.service.checkIn(john);
		this.service.checkIn(siri);

		//assertTrue(GuestService.filterByFavoriteRoom(List.of(john, maria, sonia, siri, bob), cambridge).containsAll(List.of(maria, sonia)));
		List<Guest> gustByfavRoom = Arrays.asList(john, maria, sonia, siri, bob);
		List<Guest> cambridgeRoomGuest = Arrays.asList(maria, sonia);
		assertTrue((GuestService.filterByFavoriteRoom(gustByfavRoom, cambridge).containsAll(cambridgeRoomGuest)));
		//assertFalse(GuestService.filterByFavoriteRoom(List.of(john, maria, sonia, siri, bob), cambridge).containsAll(List.of(john, siri, sonia)));
		List<Guest> gustByfavRoom2 = Arrays.asList(john, maria, sonia, siri, bob);
		List<Guest> cambridgeRoomGuest2 = Arrays.asList(john, siri, sonia);
		assertFalse((GuestService.filterByFavoriteRoom(gustByfavRoom2, cambridge).containsAll(cambridgeRoomGuest2)));
		//assertTrue(GuestService.filterByFavoriteRoom(List.of(john, maria, sonia, siri, bob), oxford).containsAll(List.of(john)));
		List<Guest> gustByfavRoom3 = Arrays.asList(john, maria, sonia, siri, bob);
		List<Guest> cambridgeRoomGuest3 = Arrays.asList(john);
		assertTrue((GuestService.filterByFavoriteRoom(gustByfavRoom3, oxford).containsAll(cambridgeRoomGuest3)));
		//assertFalse(GuestService.filterByFavoriteRoom(List.of(john, maria, sonia, siri, bob), oxford).containsAll(List.of(maria,sonia, siri, bob)));
		List<Guest> gustByfavRoom4 = Arrays.asList(john, maria, sonia, siri, bob);
		List<Guest> cambridgeRoomGuest4 = Arrays.asList(maria,sonia, siri, bob);
		assertFalse((GuestService.filterByFavoriteRoom(gustByfavRoom4, oxford).containsAll(cambridgeRoomGuest4)));
		//assertTrue(GuestService.filterByFavoriteRoom(List.of(john, maria, sonia, siri, bob), victoria).isEmpty());
		List<Guest> gustByfavRoom5 = Arrays.asList(john, maria, sonia, siri, bob);
		assertFalse(GuestService.filterByFavoriteRoom(gustByfavRoom5, victoria).isEmpty());
	}

	@Test
	void testSwapPosition() {
		
		this.service.checkIn(bob);
		this.service.checkIn(maria);
		this.service.checkIn(sonia);
		this.service.checkIn(john);
		this.service.checkIn(siri);
		
		//this.service.swapPosition(maria, john);
		//this.service.swapPosition(siri, bob);
	
		List<Guest> guests = this.service.getCheckInList();
		assertEquals(0, guests.indexOf(maria));
		assertEquals(1, guests.indexOf(sonia));
		assertEquals(2, guests.indexOf(siri));
		assertEquals(3, guests.indexOf(bob));
		assertEquals(4, guests.indexOf(john));
		
	}


	@Test
	void testCheckIn() {
		
		this.service.checkIn(bob);
		this.service.checkIn(maria);
		this.service.checkIn(sonia);
		this.service.checkIn(john);
		this.service.checkIn(siri);
	/*
		List<Guest> guests = this.service.getCheckInList();
		assertEquals(0, guests.indexOf(maria));
		assertEquals(1, guests.indexOf(sonia));
		assertEquals(2, guests.indexOf(siri));
		assertEquals(3, guests.indexOf(bob));
		assertEquals(4, guests.indexOf(john));
		*/

		List<Guest> guests = this.service.getCheckInList();
		assertEquals(0, guests.indexOf(maria));
		assertEquals(1, guests.indexOf(sonia));
		assertEquals(2, guests.indexOf(siri));
		assertEquals(3, guests.indexOf(bob));
		assertEquals(4, guests.indexOf(john));
	}

}
