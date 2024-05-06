package com.capstone.landlorddata.service;
	
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.capstone.landlorddata.entity.Landlord;
import com.capstone.landlorddata.exception.LandlordNotFoundException;
import com.capstone.landlorddata.repository.LandlordRepository;

@SpringBootTest(properties = "eureka.client.enabled=false")
public class LandlordServiceTest {
		@InjectMocks
		private LandlordServiceImpl landlordService;
		@Mock
		private LandlordRepository landlordRepository;
		@Test
		public void testviewLandlord() {
			Landlord landlord=new Landlord();
			landlord.setLandlordId(101);
			landlord.setLandlordName("Swathi");
			landlord.setLandlordAge(21);
			landlord.setMobileNo("9876543210");
			
			when(landlordRepository.findById(101)).thenReturn(Optional.of(landlord));
			Landlord actualObj=landlordService.viewLandlord(101);
			assertEquals("Swathi",actualObj.getLandlordName());
		}
		@Test
		public void testViewLandlordException() {
			
			when(landlordRepository.findById(200)).thenThrow(new LandlordNotFoundException("Landlord is not existing with id:200"));
			assertThrows(LandlordNotFoundException.class, () -> landlordService.viewLandlord(200));
		}
		@Test
		public void testViewAllLandlords() {
			Landlord landlord=new Landlord();
			landlord.setLandlordId(101);
			landlord.setLandlordName("Swathi");
			landlord.setLandlordAge(21);
			landlord.setMobileNo("9876543210");
			
			Landlord landlord1=new Landlord();
			landlord1.setLandlordId(102);
			landlord1.setLandlordName("Sri");
			landlord1.setLandlordAge(23);
			landlord1.setMobileNo("9701559224");
			
			List<Landlord> landlords=new ArrayList<>();	
			landlords.add(landlord);
			landlords.add(landlord1);
			when(landlordRepository.findAll()).thenReturn(landlords);
			List<Landlord> landlordList=landlordService.viewAllLandlords();
			assertEquals(2,landlordList.size());
			
		}
		@Test
		void testDeleteLandlordById() {
			Landlord landlord=new Landlord();
			landlord.setLandlordId(101);
			landlord.setLandlordName("Swathi");
			landlord.setLandlordAge(21);
			landlord.setMobileNo("9876543210");

			when(landlordRepository.findById(101)).thenReturn(Optional.of(landlord));
			doNothing().when(landlordRepository).delete(landlord);

			landlordService.deleteLandlordById(101);;
			verify(landlordRepository, times(1)).findById(101);
			verify(landlordRepository, times(1)).delete(landlord);
			
		}
		@Test
		void testDeleteLandlordException() {
			Landlord landlord=new Landlord();
			landlord.setLandlordId(101);
			landlord.setLandlordName("Swathi");
			landlord.setLandlordAge(21);
			landlord.setMobileNo("9876543210");

			when(landlordRepository.findById(101)).thenThrow(new LandlordNotFoundException("landlord is not existing with id:101"));
			assertThrows(LandlordNotFoundException.class, () -> landlordService.deleteLandlordById(101));
			verify(landlordRepository, times(0)).delete(landlord);
			
		}
		@Test
		public void testSaveLandlord() {
		    Landlord landlord = new Landlord();
		    landlord.setLandlordName("Swathi");
		    landlord.setLandlordAge(21);
		    landlord.setMobileNo("987654321");

		    when(landlordRepository.save(landlord)).thenReturn(landlord);

		    Landlord addedLandlord = landlordService.saveLandlord(landlord);

		    verify(landlordRepository, times(1)).save(landlord);
		    assertEquals(landlord, addedLandlord);
		    assertEquals("Swathi", addedLandlord.getLandlordName());
		    assertEquals(21, addedLandlord.getLandlordAge());
		    assertEquals("987654321", addedLandlord.getMobileNo());
		}
		@Test
		public void testUpdateLandlord() {
		    Landlord landlord = new Landlord();
		    landlord.setLandlordId(1);
		    landlord.setLandlordName("Swathi");
		    landlord.setLandlordAge(21);
		    landlord.setMobileNo("9876543210");

		    when(landlordRepository.findById(1)).thenReturn(Optional.of(landlord));
		    when(landlordRepository.save(landlord)).thenReturn(landlord);

		    landlord.setLandlordName("Swathi");
		    landlord.setLandlordAge(21);
		    landlord.setMobileNo("9876543210");

		    Landlord updatedLandlord = landlordService.updateLandlord(landlord);

		    verify(landlordRepository, times(1)).findById(1);
		    verify(landlordRepository, times(1)).save(landlord);
		    assertEquals(landlord, updatedLandlord);
		    assertEquals("Swathi", updatedLandlord.getLandlordName());
		    assertEquals(21, updatedLandlord.getLandlordAge());
		    assertEquals("9876543210", updatedLandlord.getMobileNo());
		}
		@Test
		public void testUpdateLandlordWithException() {
		    Landlord landlord = new Landlord();
		    landlord.setLandlordId(1);
		    landlord.setLandlordName("Reshma");
		    landlord.setLandlordAge(21);
		    landlord.setMobileNo("6789054321");

		    when(landlordRepository.findById(1)).thenReturn(Optional.empty());

		    assertThrows(LandlordNotFoundException.class, () -> landlordService.updateLandlord(landlord));
		    verify(landlordRepository, times(1)).findById(1);
		    verify(landlordRepository, times(0)).save(landlord);
		}
		
	 
	}

