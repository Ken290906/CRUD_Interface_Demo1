package com.example.crud_interface_demo1.service.impl;

import com.example.crud_interface_demo1.entity.SanPham;
import com.example.crud_interface_demo1.repository.SPRepository;
import com.example.crud_interface_demo1.service.SPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SPServiceImpl implements SPService {

    @Autowired
    private SPRepository spRepo;

    @Override
    public List<SanPham> getAll() {
        return  spRepo.findAll();
    }

    @Override
    public SanPham insert(SanPham sp) {
        return spRepo.save(sp);
    }

    @Override
    public boolean delete(Integer id) {
        Optional<SanPham> sp = spRepo.findById(id);
        if(sp.isPresent()) {
            spRepo.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public SanPham update(SanPham sp) {
        SanPham editSP = spRepo.findById(sp.getId()).orElse(null);
        if(editSP != null) {
            editSP.setMaSanPham(sp.getMaSanPham());
            editSP.setTenSanPham(sp.getTenSanPham());
            editSP.setTrangThai(sp.getTrangThai());

            return spRepo.save(sp);
        }
        return null;
    }

    @Override
    public SanPham findById(Integer id) {
        return spRepo.findById(id).orElse(null);
    }

    @Override
    public Page<SanPham> phanTrang(Pageable pageable) {
        return spRepo.phanTrang(pageable);
    }

}
