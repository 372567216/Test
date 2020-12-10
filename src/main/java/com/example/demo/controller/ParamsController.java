package com.example.demo.controller;

import com.example.demo.DTO.ParamsDTO;
import com.example.demo.config.entity.ResultEntity;
import com.example.demo.entity.Params;
import com.example.demo.service.IParamsService;
import com.example.demo.utils.AssertUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ParamsController {

  @Autowired
  IParamsService paramsService;


  @PostMapping("/insert")
  public ResultEntity<Params> insert(@RequestBody ParamsDTO dto){
    valid(dto);
    return ResultEntity.ok(paramsService.insert(dto));
  }

  private void valid(ParamsDTO dto) {
    AssertUtils.isFalse(StringUtils.isEmpty(dto.getParam1()),"不能为空");
    AssertUtils.isFalse(StringUtils.isEmpty(dto.getParam2()),"不能为空");
  }
}
