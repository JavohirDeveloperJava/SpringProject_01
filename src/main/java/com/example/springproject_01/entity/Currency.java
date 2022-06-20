package com.example.springproject_01.entity;

import com.example.springproject_01.entity.template.AbsEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;


import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Currency extends AbsEntity {


}
