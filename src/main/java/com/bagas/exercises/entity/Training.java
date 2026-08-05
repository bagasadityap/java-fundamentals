package com.bagas.exercises.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "training", schema = "finance")
@Getter
@Setter
public class Training {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "updated_date")
    private LocalDateTime updatedDate;

    @Column(name = "deleted_date")
    private LocalDateTime deletedDate;

    @Column(nullable = false)
    private String pengajar;

    @Column(nullable = false)
    private String tema;

    public Training() {
    }

    public Training(Integer id, LocalDateTime createdDate, LocalDateTime updatedDate, LocalDateTime deletedDate, String pengajar, String tema) {
        this.id = id;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.deletedDate = deletedDate;
        this.pengajar = pengajar;
        this.tema = tema;
    }
}