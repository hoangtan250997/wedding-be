package com.personalproject.jarsmanagement.api;

import com.personalproject.jarsmanagement.entity.GuestEntity;
import com.personalproject.jarsmanagement.service.DTO.GuestDTO;
import com.personalproject.jarsmanagement.service.GuestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/guest")
public class GuestResources {
    private final GuestService guestService;

    @GetMapping
    ResponseEntity<List<GuestDTO>> findAllIncomeSource() {
         return ResponseEntity.ok(guestService.findAllGuest());
    }
    @PostMapping
    ResponseEntity<GuestEntity> createGuest(@RequestBody GuestDTO guestDTO) {

            return ResponseEntity.ok(guestService.createGuest(guestDTO));

    }


}
