package Bai2;
 
import java.util.Scanner;
 
public class Main {
    static Scanner sc = new Scanner(System.in);
    static void nhapCD(CD CD) {
        System.out.print("Nhap ma CD: ");
        CD.setMaCD(sc.nextInt());
        sc.nextLine();
        System.out.print("Nhap ten CD : ");
        CD.setTuaCD(sc.nextLine());
        System.out.print("Nhap so luong bai hat : ");
        CD.setSoBH(sc.nextInt());
        System.out.print("Nhap gia thanh : ");
        CD.setGiaThanh(sc.nextFloat());
    }
    public static void main(String[] args) {
        CD alb[] = null;
        int a, n = 0;
        boolean flag = true;
        do {
            System.out.println("Ban chon lam gi?");
            System.out.println("1.Nhap thong tin CD \n" +
                    "2.Xuat danh sach CD.\n" + "3.Tinh tong gia thanh \n" + "4.Tong so luong CD \n" +
                    "5.Sap xep giam dan theo gia thanh\n"+"6.Sap xep tang dan theo tua CD CD\n"+"7.Thoat");
            do{
            a = sc.nextInt();
            switch (a) {
                case 1:
                    System.out.println("Nhap so luong CD : ");
                    n = sc.nextInt();
                    alb = new CD[n];
                    for (int i = 0; i < n; i++) {
                        System.out.println("CD thu " + (i + 1)+": ");
                        alb[i] = new CD();
                        nhapCD(alb[i]);
                    }
                    break;
                case 2:
                    System.out.printf("%-10s %-20s %-10s %-20s \n", "Ma CD", "Tua CD", "So bai hat", "Gia thanh");
                    for (int i = 0; i < n; i++) {
                        alb[i].hienThiCD();
                    }
                    break;
                case 3:
                    int tong = 0;
                    for (int i = 0; i < n; i++) {
                        tong += alb[i].getGiaThanh();
                    }
                    System.out.println("" +
                            "Tong gia thanh la : " + tong);
                    break;
                case 4:
                    System.out.println("Tong so luong CD la : " + n);
                    break;
                case 5:
                    CD temp = alb[0];
                    for (int i = 0; i < n - 1; i++) {
                        for (int j = i + 1; j < n; j++) {
                            if (alb[i].getGiaThanh() < alb[j].getGiaThanh()) {
                                temp = alb[j];
                                alb[j] = alb[i];
                                alb[i] = temp;
                            }
                        }
                    }
                    System.out.println("Sap xep thanh cong, nhap so 2 de kem tra!");
                    break;
                case 6:
                    temp = alb[0];
                    for (int i = 0; i < n - 1; i++) {
                        for (int j = i + 1; j < n; j++) {
                            if (alb[i].getTuaCD().compareTo(alb[j].getTuaCD())>0) {
                                temp = alb[j];
                                alb[j] = alb[i];
                                alb[i] = temp;
                            }
                        }
                    }
                    System.out.println("Sap xep thanh cong, Nhap so 2 de kiem tra!");
                    break;
                case 7:
                    System.out.println("Goodbye");
                    flag = false;
                    break;
                default:
                    System.out.println("So khong hop le!!");break;
            }
        }while (flag) ;
       }while(a!=7);
    }
}