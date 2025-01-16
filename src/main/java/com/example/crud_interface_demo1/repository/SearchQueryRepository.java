package com.example.crud_interface_demo1.repository;

import com.example.crud_interface_demo1.entity.SanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SearchQueryRepository extends JpaRepository<SanPham, Integer> {
    @Query("SELECT sp FROM SanPham sp WHERE " +
            "(?1 IS NOT NULL AND sp.id = ?1) OR " +
            "(?2 IS NOT NULL AND (sp.maSanPham LIKE %?2% OR sp.tenSanPham LIKE %?2% OR sp.idDanhMuc.maDanhMuc LIKE %?2%))")
    public Page<SanPham> search(Integer id, String keyword, Pageable pageable);

}
