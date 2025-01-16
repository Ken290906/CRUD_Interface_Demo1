package com.example.crud_interface_demo1.repository;

import com.example.crud_interface_demo1.entity.SanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SPRepository extends JpaRepository<SanPham, Integer> {

    @Query("SELECT sp FROM SanPham sp")
    Page<SanPham> phanTrang(Pageable pageable);

}
