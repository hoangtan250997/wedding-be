package com.personalproject.jarsmanagement.service;

import com.personalproject.jarsmanagement.entity.GuestEntity;
import com.personalproject.jarsmanagement.service.DTO.GuestDTO;

import java.util.List;

public interface GuestService {


    List<GuestDTO> findAllGuest();


    GuestEntity createGuest(GuestDTO guestDTO);






}
