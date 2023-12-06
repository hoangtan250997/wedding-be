package com.personalproject.jarsmanagement.service.impl;

import com.personalproject.jarsmanagement.entity.GuestEntity;
import com.personalproject.jarsmanagement.repository.GuestRepository;
import com.personalproject.jarsmanagement.service.DTO.GuestDTO;
import com.personalproject.jarsmanagement.service.GuestService;
import com.personalproject.jarsmanagement.service.mapper.GuestMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class GuestServiceImpl implements GuestService {
    private final GuestRepository guestRepository;


    @Override
    public List<GuestDTO> findAllGuest() {
           return GuestMapper.INSTANCE.mapToDtos(guestRepository.findAll());
    }

    @Override
    public GuestDTO createGuest(GuestDTO guestDTO) {

        GuestEntity guestEntity = GuestEntity.builder()
                .name(guestDTO.getName())
                .num(guestDTO.getNum())
                .wish(guestDTO.getWish())
                .build();

        guestRepository.save(guestEntity);

        return GuestMapper.INSTANCE.mapToDto(guestRepository.save(guestEntity));
    }


 }
