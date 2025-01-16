package com.example.crud_interface_demo1.repository;

import com.example.crud_interface_demo1.entity.DanhMuc;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DMRepository extends JpaRepository<DanhMuc, Integer> {
}
