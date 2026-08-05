package com.bagas.exercises.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "rekening", schema = "finance")
@Getter
@Setter
public class Rekening {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "karyawan_id", nullable = false)
    private Karyawan karyawan;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "updated_date")
    private LocalDateTime updatedDate;

    @Column(name = "deleted_date")
    private LocalDateTime deletedDate;

    @Column(name = "nama_bank", nullable = false)
    private String namaBank;

    @Column(name = "nomor_rekening", nullable = false)
    private String nomorRekening;

    public Rekening() {
    }

    public Rekening(Integer id, Karyawan karyawan, LocalDateTime createdDate, LocalDateTime updatedDate, LocalDateTime deletedDate, String namaBank, String nomorRekening) {
        this.id = id;
        this.karyawan = karyawan;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.deletedDate = deletedDate;
        this.namaBank = namaBank;
        this.nomorRekening = nomorRekening;
    }
}