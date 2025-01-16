package com.example.crud_interface_demo1.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

@Getter
@Setter
@Entity
@Table(name = "san_pham")
public class SanPham {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Đảm bảo thêm dòng này
    private Integer id;

    @Size(max = 50)
    @NotNull
    @Nationalized
    @Column(name = "ma_san_pham", nullable = false, length = 50)
    private String maSanPham;

    @Size(max = 50)
    @NotNull
    @Nationalized
    @Column(name = "ten_san_pham", nullable = false, length = 50)
    private String tenSanPham;

    @Size(max = 50)
    @NotNull
    @Nationalized
    @Column(name = "trang_thai", nullable = false, length = 50)
    private String trangThai;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_danh_muc", nullable = false)
    private DanhMuc idDanhMuc;

}