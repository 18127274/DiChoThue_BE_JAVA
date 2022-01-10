package DemoWebAPI.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
//import javax.persistence.Column;

@Document(collection = "DONHANG")
public class DonHang {
	@Id
	private String ID;
	private String MaDH;
	private String MaGH;
	private String MaNCC;
	private String MaPhuongThuc;
	private String MaShipper;
	private float PhiShip;
	private String NgayLapDon;
	private String TinhTrangThanhToan;
//	@Column()
	private String TinhTrangDonHang;
	private Float TongTien; 
	
	
	
	public String getID() {
		return ID;
	}



	public void setID(String iD) {
		ID = iD;
	}



	public DonHang(String maDH, String maGH, String maNCC, String maPhuongThuc, String maShipper, float phiShip,
			String ngayLapDon, String tinhTrangThanhToan, String tinhTrangDonHang, Float tongTien) {
		super();
		MaDH = maDH;
		MaGH = maGH;
		MaNCC = maNCC;
		MaPhuongThuc = maPhuongThuc;
		MaShipper = maShipper;
		PhiShip = phiShip;
		NgayLapDon = ngayLapDon;
		TinhTrangThanhToan = tinhTrangThanhToan;
		TinhTrangDonHang = tinhTrangDonHang;
		TongTien = tongTien;
	}



	public DonHang() {
		super();
	}


	public String getMaDH() {
		return MaDH;
	}



	public void setMaDH(String maDH) {
		MaDH = maDH;
	}



	public String getMaGH() {
		return MaGH;
	}



	public void setMaGH(String maGH) {
		MaGH = maGH;
	}



	public String getMaNCC() {
		return MaNCC;
	}



	public void setMaNCC(String maNCC) {
		MaNCC = maNCC;
	}



	public String getMaPhuongThuc() {
		return MaPhuongThuc;
	}



	public void setMaPhuongThuc(String maPhuongThuc) {
		MaPhuongThuc = maPhuongThuc;
	}



	public String getMaShipper() {
		return MaShipper;
	}



	public void setMaShipper(String maShipper) {
		MaShipper = maShipper;
	}



	public float getPhiShip() {
		return PhiShip;
	}



	public void setPhiShip(float phiShip) {
		PhiShip = phiShip;
	}



	public String getNgayLapDon() {
		return NgayLapDon;
	}



	public void setNgayLapDon(String ngayLapDon) {
		NgayLapDon = ngayLapDon;
	}



	public String getTinhTrangThanhToan() {
		return TinhTrangThanhToan;
	}



	public void setTinhTrangThanhToan(String tinhTrangThanhToan) {
		TinhTrangThanhToan = tinhTrangThanhToan;
	}



	public String getTinhTrangDonHang() {
		return TinhTrangDonHang;
	}



	public void setTinhTrangDonHang(String tinhTrangDonHang) {
		TinhTrangDonHang = tinhTrangDonHang;
	}



	public Float getTongTien() {
		return TongTien;
	}



	public void setTongTien(Float tongTien) {
		TongTien = tongTien;
	}
	
	
}
