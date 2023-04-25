package Bai1;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Account {
    Scanner scan=new Scanner(System.in);
    public double sotien;
    public long sotk;
    public String tentk,trangthai;
    public double lai=0.035;

    public Account() {
    }
    

    public Account(double sotien, long sotk, String tentk) {
        this.sotien = 50;
        this.sotk = 999999;
        this.tentk = "Chưa xác định";
    }

    public Account(long sotk, String tentk) {
        this.sotk = sotk;
        this.tentk = tentk; 
    }
    
    
    public double getSotien() {
        return sotien;
    }

    public void setSotien(double sotien) {
        if(sotien<50){
            this.sotien = sotien;
        }
    }

    public long getSotk() {
        return sotk;
    }

    public void setSotk(long sotk) {
        if(sotk<0&&sotk==999999){
            this.sotk = sotk;
        }
    }

    public String getTentk() {
        return tentk;
    }

    public void setTentk(String tentk) {
        if(tentk==""){
            this.tentk = tentk;
        }
    }

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }

    @Override
    public String toString() {
        Locale local=new Locale("vi", "vn");
        NumberFormat formatter=NumberFormat.getCurrencyInstance(local);
        return sotk + "-" + tentk + "-" + sotien;
    }
    
    public double napTien(){
        double nap;
        System.out.println("Nhập số tiền banuj cần nạp:");
        nap =scan.nextDouble();
        if (nap>=0){
            sotien=nap+sotien;
            System.out.println("Bạn vửa nạp "+nap+"vào tài khoản");
        }else{
            System.out.println("Số tiền nạp vào không hợp lệ!!!");
            
        }
        return nap;
    }
    
    public double rutTien(){
        double rut;
        System.out.println("Nhập số tiền cần rút:");
        rut=scan.nextDouble();
        if(rut<=sotien){
            sotien=sotien-rut;
            System.out.println("Bạn vừa rút "+rut+"trong tài khoản");
            
        }else{
            System.out.println("Số tiền không hợp lệ!");
            return rutTien();
                    
        }
        return rut;
    }
    
    public double daoHan(){
        sotien=sotien+sotien*lai;
        System.out.println("Bạn vừa được "+sotien+" từ đáo hạn ngân hàng");
        return sotien;
    }
    
}
