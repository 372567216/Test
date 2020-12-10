package com.example.demo.service;

import com.example.demo.DTO.ParamsDTO;
import com.example.demo.entity.Params;

public interface IParamsService {

  Params insert(ParamsDTO dto);
}
