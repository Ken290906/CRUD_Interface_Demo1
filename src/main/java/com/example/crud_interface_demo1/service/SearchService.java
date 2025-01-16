package com.example.crud_interface_demo1.service;

import com.example.crud_interface_demo1.entity.SanPham;
import com.example.crud_interface_demo1.repository.SPRepository;
import com.example.crud_interface_demo1.repository.SearchQueryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {
    @Autowired
    private SearchQueryRepository searchRepo;

    @Autowired
    private SPRepository spRepo;

    public Page<SanPham> listAll(String keyword, Pageable pageable) {
        if(keyword != null && !keyword.trim().isEmpty()) {
            try {
                Integer id = Integer.parseInt(keyword);
                return searchRepo.search(id, keyword, pageable);
            } catch (NumberFormatException e) {
                return searchRepo.search(null, keyword, pageable); // Không truyền id khi keyword không phải số
            }
        }
        return spRepo.phanTrang(pageable);
    }
}
