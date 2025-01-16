package com.example.crud_interface_demo1.service.impl;

import com.example.crud_interface_demo1.entity.DanhMuc;
import com.example.crud_interface_demo1.repository.DMRepository;
import com.example.crud_interface_demo1.service.DMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DMServiceImpl implements DMService {

    @Autowired
    private DMRepository repoDM;

    @Override
    public List<DanhMuc> getList() {
        return repoDM.findAll();
    }

    @Override
    public DanhMuc findById(Integer id) {
        return repoDM.findById(id).orElse(null);
    }


}
