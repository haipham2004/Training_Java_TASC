package com.example.Demo_Java_Collection.list_interface;

import java.util.ArrayList;
import java.util.LinkedList;

public class Demo_HieuSuat {

    public static void main(String[] args) {
        //ArrayList và LinkedList

        //Test add

        ArrayList arrayList=new ArrayList();

        long n= (long) 1E7;

        long time=System.currentTimeMillis();
        for(int i=0;i<n;i++){
          arrayList.add(i);
        }
        System.out.println("Time chạy ArrayList: "+(System.currentTimeMillis()-time) +"ms");

        LinkedList linkedList=new LinkedList();

         time=System.currentTimeMillis();

        for(int i=0;i<n;i++){
            linkedList.add(i);
        }
        System.out.println("Time chạy LinkedList: "+(System.currentTimeMillis()-time)+"ms");

//        --> Do duyệt từ mảng từ đầu nên ArrayList nhanh hơn:

        //Test thêm phần tử vào đầu mảng:
        time=System.currentTimeMillis();
        arrayList.add(0,"2132212333");
        System.out.println("Time add arrayList: "+(System.currentTimeMillis()-time)+"ms");

        time=System.currentTimeMillis();
        linkedList.addFirst("2132212333");
        System.out.println("Time add linkedList: "+(System.currentTimeMillis()-time)+"ms");

//       --> arrayList chậm hơn do phải dịch chuyển các vị trí phần tử để chèn phần tử vào;
      //Test truy xuất
        time=System.currentTimeMillis();
        arrayList.get((int) (n/2));
        System.out.println("Time get arrayList: "+(System.currentTimeMillis()-time)+"ms");

        time=System.currentTimeMillis();
        linkedList.get((int) (n/2));
        System.out.println("Time get linkedList: "+(System.currentTimeMillis()-time)+"ms");

        //ArrayList truy xuất nhanh hơn thông qua chỉ số index, linkedList chậm hơn do phải duyệt qua các nút
    }
}
