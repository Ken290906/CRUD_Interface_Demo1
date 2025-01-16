package com.example.crud_interface_demo1.repository;

import com.example.crud_interface_demo1.entity.TaiKhoan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TKRepository extends JpaRepository<TaiKhoan, Integer> {
    @Query("SELECT tk FROM TaiKhoan tk WHERE (tk.email = ?1 OR tk.username = ?1) AND tk.password = ?2")
    public List<TaiKhoan> User(String emailORusername, String password);
}
