package com.nix.menshykov.weather.fetcher.persistence.repository;

import com.nix.menshykov.weather.fetcher.persistence.entity.RequestInfo;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Transactional
@NoArgsConstructor
public class RequestInfoRepositoryImpl implements RequestInfoRepository {

    @Setter
    @PersistenceContext(unitName = "request-info-jpa")
    private EntityManager entityManager;

    @Override
    public void add(RequestInfo requestInfo) {
        entityManager.persist(requestInfo);
    }
}
