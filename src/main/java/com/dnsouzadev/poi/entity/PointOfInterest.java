package com.dnsouzadev.poi.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_point_of_interest")
public class PointOfInterest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private Long x;

    private Long y;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getX() {
        return x;
    }

    public void setX(Long x) {
        this.x = x;
    }

    public Long getY() {
        return y;
    }

    public void setY(Long y) {
        this.y = y;
    }

    public PointOfInterest(String name, Long x, Long y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }

    public PointOfInterest() {
    }
}
