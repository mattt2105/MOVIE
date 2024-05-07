package com.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Getter
@Setter
@Table (name = "mst_movie")
public class MovieModel {
    @Id
    @Column (name = "id", nullable = false, length = 50)
    private Integer id;

    @Column(name = "title", length = 255)
    private String title;

    @Column(name = "description", length = 255)
    private String description;

    @Column(name = "rating", length = 255)
    private Float rating;

    @Column(name = "image", length = 255)
    private String image;

    @Column(name = "createdAt", length = 255)
    private Date created_at;

    @Column(name = "updateAt", length = 255)
    private Date updated_at;

}
