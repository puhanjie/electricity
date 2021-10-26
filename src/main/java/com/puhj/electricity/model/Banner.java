package com.puhj.electricity.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "banner", schema = "electricity", catalog = "")
public class Banner extends BaseEntity {
    @Id
    private Long id;
    private String name;
    private String description;
    private String title;
    private String img;
    @OneToMany
    @JoinColumn(name = "bannerId")
    private List<BannerItem> items;
}
