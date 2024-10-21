package com.example.Demo_Spring_Framework.Introduction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("san-pham")
public class SanPhamRest {

    private SanPhamService sanPhamService;

    @Autowired
    public SanPhamRest(SanPhamService sanPhamService) {
        this.sanPhamService = sanPhamService;
    }

    @GetMapping("xin-chao")
    public ResponseEntity<String> xinChao(){
        return ResponseEntity.ok("Xin chào Hải Phạm YKA");
    }

    @GetMapping("hien-thi")
    public ResponseEntity<List<SanPham>> getList(){
        return ResponseEntity.ok(sanPhamService.getSanPhamList());
    }

    @GetMapping("/sanpham/{ma}")
    public ResponseEntity<?> checkMaSanPham(@PathVariable String ma) {
        SanPham sanPham = sanPhamService.checkMaSanPham(ma);

        if (sanPham != null) {
            return ResponseEntity.ok(sanPham);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Không tồn tại sản phẩm có mã: "+ma);
        }
    }

    @PostMapping
    public ResponseEntity<SanPham> add(@RequestBody SanPham sanPham){
        return ResponseEntity.ok(sanPhamService.add(sanPham));
    }

    @PutMapping("{maSanPham}")
    public ResponseEntity<SanPham> updateSanPham(
            @PathVariable String maSanPham,
            @RequestBody SanPham updatedSanPham) {

        SanPham updatedProduct = sanPhamService.updateSanPham(maSanPham, updatedSanPham);

        if (updatedProduct != null) {
            return ResponseEntity.ok(updatedProduct);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
