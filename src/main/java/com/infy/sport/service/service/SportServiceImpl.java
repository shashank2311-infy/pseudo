package com.infy.sport.service.service;

import com.infy.sport.service.VO.ResponseTemplateVO;
import com.infy.sport.service.VO.Student;
import com.infy.sport.service.entity.Sport;
import com.infy.sport.service.exception.SportException;
import com.infy.sport.service.repository.SportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class SportServiceImpl implements SportService {

    @Autowired
    SportRepository sportRepository;

    @Autowired
    private RestTemplate restTemplate;

    Logger logger = Logger.getLogger(SportServiceImpl.class.getName());

    @Override
    public List<Sport> getAllSports() throws SportException {
        logger.info("Inside getAllSports of SportServiceImpl");
        Iterable<Sport> sportIterable=sportRepository.findAll();
        if(sportIterable==null)
        {
            throw new SportException("No Sport Found");
        }
        List<Sport> sportList=new ArrayList<>();
        for(Sport s:sportIterable)
        {
            Sport s1=new Sport();
            s1.setSportId(s.getSportId());
            s1.setSportName(s.getSportName());
            s1.setStudentId(s.getStudentId());
            sportList.add(s1);
        }
        return sportList;

    }

    @Override
    public ResponseTemplateVO getSportWithStudent(Long sportId) throws SportException {
        logger.info("Inside getSportWithStudent of SportServiceImpl");
        ResponseTemplateVO responseTemplateVO=new ResponseTemplateVO();
        Optional<Sport> optionalSport=sportRepository.findById(sportId);
        Sport sport=optionalSport.orElseThrow(()-> new SportException("No Sport found with Id "+sportId));

        Student student=restTemplate.getForObject("http://localhost:9011/students/"+sport.getStudentId(), Student.class);
        responseTemplateVO.setSport(sport);
        responseTemplateVO.setStudent(student);
        return responseTemplateVO;

    }

    @Override
    public Long addSport(Sport sport) throws SportException {
        logger.info("Inside addSport of SportServiceImpl");
        if(sportRepository.findById(sport.getSportId())!=null)
        {
            throw new SportException("Sport with id "+sport.getSportId()+" already exists");
        }
        Sport sport1=new Sport();
        sport1.setSportId(sport.getSportId());
        sport1.setSportName(sport.getSportName());
        sport1.setStudentId(sport.getStudentId());
        sportRepository.save(sport1);
        return sport1.getSportId();
    }
}
