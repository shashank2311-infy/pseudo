package com.infy.sport.service.service;

import com.infy.sport.service.VO.ResponseTemplateVO;
import com.infy.sport.service.entity.Sport;
import com.infy.sport.service.exception.SportException;

import java.util.List;

public interface SportService {
    public List<Sport> getAllSports() throws SportException;
    public ResponseTemplateVO getSportWithStudent(Long sportId) throws SportException;
    public Long addSport(Sport sport) throws SportException;
}
