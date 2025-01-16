package com.example.crud_interface_demo1.controller;

import com.example.crud_interface_demo1.entity.DanhMuc;
import com.example.crud_interface_demo1.entity.SanPham;
import com.example.crud_interface_demo1.entity.TaiKhoan;
import com.example.crud_interface_demo1.repository.TKRepository;
import com.example.crud_interface_demo1.service.DMService;
import com.example.crud_interface_demo1.service.SPService;
import com.example.crud_interface_demo1.service.SearchService;
import com.example.crud_interface_demo1.service.TKService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/san-pham/")
public class MainController {

    @Autowired
    private SPService spSer;

    @Autowired
    private DMService dmSer;

    @Autowired
    private TKService tkSer;

    @Autowired
    private TKRepository tkRepo;

    @Autowired
    private SearchService searchSer;


    @GetMapping("hien-thi")
    public String home(@RequestParam(value = "page", defaultValue = "0") int page, Model model) {
        Pageable pageable = PageRequest.of(page, 5);
        Page<SanPham> sanPhamPage = spSer.phanTrang(pageable);
        List<DanhMuc> listDM = dmSer.getList();
        model.addAttribute("currentPage", sanPhamPage);
        model.addAttribute("listDM", listDM);
        return "index";
    }


    @GetMapping("search-sanPham")
    public String searchSP(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "keyword", required = false) String keyword, // Sửa @Param thành @RequestParam
            Model model) {
        Pageable pageable = PageRequest.of(page, 5);
        Page<SanPham> sanPhamPage = searchSer.listAll(keyword, pageable);

        model.addAttribute("searchInput", keyword);
        model.addAttribute("currentPage", sanPhamPage);
        return "index";
    }

    // Sign up
    @GetMapping("register-form")
    public String signUpForm() {
        return "User/SignUp";
    }
    @PostMapping("register")
    public String taoTK(@ModelAttribute("register")TaiKhoan taiKhoan) {
        tkSer.insert(taiKhoan);
        return "User/Login";
    }

    // Login
    @GetMapping("login-form")
    public String loginForm() {
        return "User/SignIn";
    }
    @PostMapping("login")
    public String loginTK(
            @RequestParam("emailORusername") String emailORusername,
            @RequestParam("password") String password,
            Model model
    ) {
        List<TaiKhoan> tk = tkRepo.User(emailORusername, password);
        if(!tk.isEmpty()) {
            return "redirect:/san-pham/hien-thi";
        } else {
            model.addAttribute("error", "Sai tai khoan hoac mat khau");
            return "User/SignIn";
        }

    }


    // Add
    @PostMapping("addSanPham")
    public String insertSP(@ModelAttribute("addSanPham") SanPham sanPham, @RequestParam Integer idDanhMuc) {
        DanhMuc dm = dmSer.findById(idDanhMuc);
        sanPham.setIdDanhMuc(dm);
        spSer.insert(sanPham);
        return "redirect:/san-pham/hien-thi";
    }

    // Delete
    @GetMapping("xoaSP/{id}")
    public String deleteDM(@RequestParam(value = "page", defaultValue = "0") int page,@PathVariable("id")Integer id, Model model) {
        Pageable pageable = PageRequest.of(page, 5);
        Page<SanPham> sanPhamPage = spSer.phanTrang(pageable);

        model.addAttribute("currentPage", sanPhamPage);
        spSer.delete(id);
        return "redirect:/san-pham/hien-thi";
    }

    // Edit
    @GetMapping("editSP/{id}")
    public String loadForm(@RequestParam(value = "page", defaultValue = "0") int page,@PathVariable("id") Integer id, Model model) {
        Pageable pageable = PageRequest.of(page, 5);
        Page<SanPham> sanPhamPage = spSer.phanTrang(pageable);
        model.addAttribute("sp", null);

        List<DanhMuc> listDM = dmSer.getList();
        SanPham sp = spSer.findById(id);

        model.addAttribute("currentPage", sanPhamPage);
        model.addAttribute("listDM", listDM);
        model.addAttribute("sp", sp);

        return "index";
    }

    @PostMapping("editSP/editSanPham")
    public String editSP(@RequestParam(value = "page", defaultValue = "0") int page,@ModelAttribute("sanPham") SanPham sanPham, Model model) {
        Pageable pageable = PageRequest.of(page, 5);
        Page<SanPham> sanPhamPage = spSer.phanTrang(pageable);

        model.addAttribute("currentPage", sanPhamPage);
        spSer.update(sanPham);
        return "redirect:/san-pham/hien-thi";
    }


}
