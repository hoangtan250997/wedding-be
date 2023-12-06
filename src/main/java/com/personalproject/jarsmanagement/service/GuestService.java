package com.personalproject.jarsmanagement.service;

import com.personalproject.jarsmanagement.service.DTO.GuestDTO;

import java.util.List;

public interface GuestService {


    List<GuestDTO> findAllGuest();


    GuestDTO createGuest(GuestDTO guestDTO);






}
