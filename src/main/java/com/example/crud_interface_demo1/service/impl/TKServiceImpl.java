package com.example.crud_interface_demo1.service.impl;

import com.example.crud_interface_demo1.entity.TaiKhoan;
import com.example.crud_interface_demo1.repository.TKRepository;
import com.example.crud_interface_demo1.service.TKService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TKServiceImpl implements TKService {

    @Autowired
    private TKRepository tkRepo;

    @Override
    public TaiKhoan insert(TaiKhoan taiKhoan) {
        return tkRepo.save(taiKhoan);
    }



}
