package com.nix.menshykov.weather.fetcher.persistence.repository;

import com.nix.menshykov.weather.fetcher.persistence.entity.RequestInfo;

public interface RequestInfoRepository {

    void add(RequestInfo requestInfo);

}
