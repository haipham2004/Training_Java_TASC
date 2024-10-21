package com.example.Demo_Java_Collection.set_interface;

import java.util.EnumSet;

public class Demo_EnumSet {

    enum HoaQua {
        TAO, Chuoi, CAM, Nho, XOAI
    }

    public static class EnumSetDemo {
        public static void main(String[] args) {

            EnumSet<HoaQua> hoaQuaNhietDoi = EnumSet.of(HoaQua.XOAI, HoaQua.Chuoi);
            EnumSet<HoaQua> tatCaHoaQua = EnumSet.allOf(HoaQua.class);


            System.out.println("Hoa quả nhiệt đới: " + hoaQuaNhietDoi);
            System.out.println("Tất cả hoa quả: " + tatCaHoaQua);


            if (hoaQuaNhietDoi.contains(HoaQua.XOAI)) {
                System.out.println("Xoài là một loại hoa quả nhiệt đới.");
            }


            EnumSet<HoaQua> motSoHoaQua = EnumSet.range(HoaQua.TAO, HoaQua.CAM);
            System.out.println("Một số hoa quả: " + motSoHoaQua);
        }
    }
}
