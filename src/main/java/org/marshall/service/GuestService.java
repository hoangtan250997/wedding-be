package org.marshall.service;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.marshall.DAO.GuestDAO;
import org.marshall.entity.GuestEntity;

@RequestScoped
public class GuestService {

    @Inject
    GuestDAO guestDAO;

    @Transactional
    public GuestEntity create(GuestEntity guest){
        GuestEntity entity = GuestEntity.builder()
                .name(guest.getName())
                .numberPhone(guest.getNumberPhone())
                .wish(guest.getWish())
                .build();
        return guestDAO.create(entity);
    }
}
