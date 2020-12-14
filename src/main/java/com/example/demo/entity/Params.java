package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Data
@Entity
@Table(name = "t_params")
public class Params implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  /**
   * id
   */
  @GenericGenerator(name = "system-uuid", strategy = "uuid")
  @GeneratedValue(generator = "system-uuid")
  @Column(name = "user_id")
  private String userId;
  @Column(name = "param1")
  private String param1;
  @Column(name = "param2")
  private String param2;

}
