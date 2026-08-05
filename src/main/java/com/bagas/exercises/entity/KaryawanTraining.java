package com.bagas.exercises.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "karyawan_training", schema = "finance")
@Getter
@Setter
public class KaryawanTraining {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "karyawan_id", nullable = false)
    private Karyawan karyawan;

    @ManyToOne
    @JoinColumn(name = "training_id", nullable = false)
    private Training training;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "updated_date")
    private LocalDateTime updatedDate;

    @Column(name = "deleted_date")
    private LocalDateTime deletedDate;

    public KaryawanTraining() {
    }

    public KaryawanTraining(Integer id, Karyawan karyawan, Training training, LocalDateTime createdDate, LocalDateTime updatedDate, LocalDateTime deletedDate) {
        this.id = id;
        this.karyawan = karyawan;
        this.training = training;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.deletedDate = deletedDate;
    }
}