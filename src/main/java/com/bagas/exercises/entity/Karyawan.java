package com.bagas.exercises.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter

@Table(name = "karyawan", schema = "finance")

public class Karyawan {
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
    private String alamat;
    @Column(nullable = false)
    private LocalDate dob;
    @Column(nullable = false)
    private String nama;
    @Column(nullable = false)
    private Boolean status;

    public Karyawan() {
    }

    public Karyawan(Integer id, LocalDateTime createdDate, LocalDateTime updatedDate, LocalDateTime deletedDate, String alamat, LocalDate dob, String nama, Boolean status) {
        this.id = id;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.deletedDate = deletedDate;
        this.alamat = alamat;
        this.dob = dob;
        this.nama = nama;
        this.status = status;
    }
}