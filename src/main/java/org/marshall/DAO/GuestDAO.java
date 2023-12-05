package org.marshall.DAO;

import jakarta.enterprise.context.RequestScoped;
import org.marshall.config.BaseDAO;
import org.marshall.entity.GuestEntity;

@RequestScoped
public class GuestDAO extends BaseDAO<GuestEntity> {
    public GuestDAO() {
        super(GuestEntity.class);
    }
}
