package com.puhj.electricity.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class SaleExplain extends BaseEntity {
    @Id
    private Long id;
    private Boolean fixed;
    private String text;
    private Long spuId;
    private Long index;
    private Long replaceId;
}
