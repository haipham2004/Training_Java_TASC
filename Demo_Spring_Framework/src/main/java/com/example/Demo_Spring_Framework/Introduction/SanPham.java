package com.example.Demo_Spring_Framework.Introduction;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SanPham {

    private String maSanPham;

    private String tenSanPham;

    private int soLuong;

    private Double gia;
}
