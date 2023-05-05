package com.ssafy.raid.ranking.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CharacterClass")
public class CharacterClass {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer characterClassId;
    
    @Column(nullable = false)
    private String characterClassName;
    
    
}