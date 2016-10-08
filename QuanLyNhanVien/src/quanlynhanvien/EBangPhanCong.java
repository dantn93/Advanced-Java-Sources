/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlynhanvien;

/**
 *
 * @author snow
 */
public enum EBangPhanCong {
    record1("2014-04-20", 3, 3, 2),
    record2("2014-05-28", 6, 3, 2),
    record3("2014-05-08", 2, 3, 2),
    record4("2014-07-10", 6, 3, 2),
    record5("2014-05-26", 3, 3, 2),
    record6("2014-07-24", 5, 3, 2),
    record7("2014-07-07", 6, 3, 2),
    record8("2014-05-30", 2, 3, 2),
    record9("2014-07-01", 6, 3, 2),
    record10("2014-07-31", 4, 3, 2),
    record11("2014-07-19", 6, 3, 2),
    record12("2014-07-28", 3, 3, 2),
    record13("2014-09-11", 2, 3, 2),
    record14("2014-08-15", 1, 3, 2),
    record15("2014-09-09", 1, 3, 2),
    record16("2014-08-18", 3, 3, 2),
    record17("2014-09-25", 2, 3, 2),
    record18("2014-10-16", 6, 3, 2),
    record19("2014-10-23", 5, 3, 2),
    record20("2014-10-19", 5, 3, 2),
    record21("2014-10-27", 3, 3, 2),
    record22("2014-11-04", 3, 3, 2),
    record23("2014-11-12", 1, 3, 2),
    record24("2014-11-06", 6, 3, 2),
    record25("2014-11-28", 6, 3, 2),
    record26("2014-12-01", 2, 3, 2),
    record27("2014-12-06", 6, 3, 2),
    record28("2014-12-16", 6, 3, 2),
    record29("2014-12-28", 4, 3, 2),
    record30("2015-01-05", 4, 3, 2);

    private String ngayBatDau;
    private int soNgay;
    private int IdNhanVien;
    private int IdLoaiCongViec;

    private EBangPhanCong(String ngayBatDau, int soNgay, int IdNhanVien, int IdLoaiCongViec) {
        this.ngayBatDau = ngayBatDau;
        this.soNgay = soNgay;
        this.IdNhanVien = IdNhanVien;
        this.IdLoaiCongViec = IdLoaiCongViec;
    }

}
