package com.infy.sport.service.controller;

import com.infy.sport.service.VO.ResponseTemplateVO;
import com.infy.sport.service.entity.Sport;
import com.infy.sport.service.exception.SportException;
import com.infy.sport.service.service.SportServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/sports")
public class SportController {

    @Autowired
    SportServiceImpl sportService;
    Logger logger = Logger.getLogger(SportController.class.getName());

    @PostMapping("/sport")
    public ResponseEntity<Long> addSport(@RequestBody Sport sport) throws Exception
    {
        try
        {
            logger.info("Inside addSport of SportController");
            sportService.addSport(sport);
            ResponseEntity<Long> response=new ResponseEntity<Long>(sport.getSportId(), HttpStatus.CREATED);
            return response;
        }
        catch(SportException e)
        {
            logger.info("Inside catchBlock of SportException of getAllSport in SportController");
            throw new SportException(e.getMessage());
        }
        catch(Exception e)
        {
            logger.info("Inside catchBlock of GenericException of getAllSport in SportController");
            throw new Exception("There Is Some Internal Issue!!");
        }

    }

    @GetMapping("/{sportId}")
    public ResponseEntity<ResponseTemplateVO> getSportWithStudent(@PathVariable("sportId") Long sportId) throws Exception{
        try
        {
            logger.info("Inside getSportWithStudent of SportController");
            ResponseTemplateVO sport=sportService.getSportWithStudent(sportId);
            ResponseEntity<ResponseTemplateVO> response=new ResponseEntity<ResponseTemplateVO>(sport, HttpStatus.OK);
            return response;
        }
        catch(SportException e)
        {
            logger.info("Inside catchBlock of SportException of getSportWithStudent in SportController");
            throw new SportException(e.getMessage());
        }
        catch(Exception e)
        {
            logger.info("Inside catchBlock of GenericException of getSportWithStudent in SportController");
            throw new Exception("There Is Some Internal Issue!!");
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<Sport>> getAllSports() throws Exception{
        try
        {
            logger.info("Inside getAllSports of SportController");
            List<Sport> sportList=sportService.getAllSports();
            ResponseEntity<List<Sport>> response=new ResponseEntity<List<Sport>>(sportList, HttpStatus.OK);
            return response;
        }
        catch (SportException e)
        {
            logger.info("Inside catchBlock of SportException of getAllSports in SportController");
            throw new SportException(e.getMessage());
        }
        catch(Exception e)
        {
            logger.info("Inside catchBlock of GenericException of getAllSports in SportController");
            throw new Exception("There Is Some Internal Issue!!");
        }
    }


}
