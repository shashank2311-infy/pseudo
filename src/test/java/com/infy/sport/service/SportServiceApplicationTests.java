package com.infy.sport.service;

import com.infy.sport.service.entity.Sport;
import com.infy.sport.service.exception.SportException;
import com.infy.sport.service.repository.SportRepository;

import com.infy.sport.service.service.SportServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
class SportServiceApplicationTests {

	@Test
	void contextLoads() {
	}

	@InjectMocks
	public SportServiceImpl sportService;

	@Mock
	public SportRepository sportRepository;

	@Test
	public void getAllSportTest() throws Exception
	{
		List<Sport> sportList=new ArrayList<>();
		Sport sport=new Sport();
		sport.setSportId(201L);
		sport.setSportName("Football");
		sport.setStudentId(101L);
		sportList.add(sport);

		Sport sport1=new Sport();
		sport1.setSportId(202L);
		sport1.setSportName("Cricket");
		sport1.setStudentId(102L);
		sportList.add(sport1);

		Mockito.when(sportRepository.findAll()).thenReturn(sportList);
		Assertions.assertEquals(sportService.getAllSports(), sportList);
	}

	@Test
	public void addSports() throws Exception
	{
		Sport sport=new Sport();
		sport.setSportId(201L);
		sport.setSportName("Football");
		sport.setStudentId(101L);

		Mockito.when(sportRepository.save(sport)).thenReturn(sport);
		Assertions.assertEquals(sportService.addSport(sport),sport.getSportId());

	}

}
