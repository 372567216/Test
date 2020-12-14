package com.example.demo.repository;

import com.example.demo.entity.Params;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParamsRepository extends JpaRepository<Params, String> {

  @Cacheable(cacheNames = "ParamsByParam1AndParam2")
  Params findByParam1AndParam2(String param1, String param2);
}