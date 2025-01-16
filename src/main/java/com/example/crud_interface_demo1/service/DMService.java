package com.example.crud_interface_demo1.service;

import com.example.crud_interface_demo1.entity.DanhMuc;

import java.util.List;

public interface DMService {
    List<DanhMuc> getList();

    DanhMuc findById(Integer id);
}
