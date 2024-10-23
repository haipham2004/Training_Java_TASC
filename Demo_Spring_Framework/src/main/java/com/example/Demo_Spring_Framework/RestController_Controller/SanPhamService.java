package com.example.Demo_Spring_Framework.RestController_Controller;

import com.example.Demo_Spring_Framework.RestController_Controller.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SanPhamService {

    private List<SanPham> sanPhamList=new ArrayList<>();

    public SanPhamService() {
        sanPhamList.add(new SanPham("SP01","Điện thoại1",10, 67800.0));
        sanPhamList.add(new SanPham("SP02","Điện thoại2",12, 77800.0));
        sanPhamList.add(new SanPham("SP03","Điện thoại3",13, 88800.0));
    }

    public List<SanPham> getSanPhamList() {
        return sanPhamList;
    }

    public SanPham checkMaSanPham(String ma){

        for (SanPham sanPham:sanPhamList){
            if(sanPham.getMaSanPham().equals(ma)){
                return sanPham;
            }
        }
        throw  new ResourceNotFoundException("Không tìnm thấy sản phẩm có ma: "+ma);
    }


    public SanPham add(SanPham sanPham) {
        for (SanPham sp : sanPhamList) {
            if (sp.getMaSanPham().equals(sanPham.getMaSanPham())) {
                throw new IllegalArgumentException("Mã sản phẩm đã tồn tại");
            }
        }
        sanPhamList.add(sanPham);
        return sanPham;
    }

    public SanPham updateSanPham(String maSanPham, SanPham updatedSanPham) {
        for (int i = 0; i < sanPhamList.size(); i++) {
            SanPham sanPham = sanPhamList.get(i);
            if (sanPham.getMaSanPham().equals(maSanPham)) {
                sanPham.setTenSanPham(updatedSanPham.getTenSanPham());
                sanPham.setGia(updatedSanPham.getGia());
                sanPham.setSoLuong(updatedSanPham.getSoLuong());
                return sanPham;
            }
        }
        return null;
    }

    public void deleteSanPham(String maSanPham) {
        boolean found = false;

        for (int i = 0; i < sanPhamList.size(); i++) {
            SanPham sanPham = sanPhamList.get(i);
            if (sanPham.getMaSanPham().equals(maSanPham)) {
                sanPhamList.remove(i);
                found = true;
                break;
            }
        }

        if (!found) {
            throw new ResourceNotFoundException("Không tìm thấy sản phẩm có mã: " + maSanPham);
        }
    }

}


