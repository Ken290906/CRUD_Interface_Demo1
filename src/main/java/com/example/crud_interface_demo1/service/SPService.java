package com.example.crud_interface_demo1.service;

import com.example.crud_interface_demo1.entity.SanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SPService {
    List<SanPham> getAll();

    SanPham insert(SanPham sp);

    boolean delete(Integer id);


    SanPham update(SanPham sp);

    SanPham findById(Integer id);

    Page<SanPham> phanTrang(Pageable pageable);
}
