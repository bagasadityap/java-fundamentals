package com.bagas.exercises.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "detail_karyawan", schema = "finance")
@Getter
@Setter
public class DetailKaryawan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "karyawan_id", nullable = false)
    private Karyawan karyawan;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "updated_date")
    private LocalDateTime updatedDate;

    @Column(name = "deleted_date")
    private LocalDateTime deletedDate;

    @Column(nullable = false)
    private String nik;

    @Column(nullable = false)
    private String npwp;

    public DetailKaryawan() {
    }

    public DetailKaryawan(Integer id, Karyawan karyawan, LocalDateTime createdDate, LocalDateTime updatedDate, LocalDateTime deletedDate, String nik, String npwp) {
        this.id = id;
        this.karyawan = karyawan;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.deletedDate = deletedDate;
        this.nik = nik;
        this.npwp = npwp;
    }
}