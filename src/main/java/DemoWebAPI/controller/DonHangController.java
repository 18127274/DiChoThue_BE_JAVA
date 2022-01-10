package DemoWebAPI.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import DemoWebAPI.model.DonHang;
import DemoWebAPI.repository.DonHangRepository;

@RestController
@CrossOrigin
@RequestMapping(value = "/api")
public class DonHangController {

	@Autowired
	DonHangRepository repo;
	@Autowired
	MongoTemplate mongoTemplate;
	@Autowired
	MongoOperations mongoOperation;

//	@PostMapping("/nhanvien")
//	public ResponseEntity<NhanVien> ThemNhanVien(@RequestBody NhanVien nhanvien) {
//		try {
//			NhanVien _nhanvien = repo.save(new NhanVien(nhanvien.getManv(), nhanvien.getHoten(),
//					nhanvien.getSoNamKinhNghiem(), nhanvien.isThuviec()));
//			return new ResponseEntity<>(_nhanvien, HttpStatus.CREATED);
//		} catch (Exception e) {
//			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}
//
//	@PutMapping("/nhanvien/{id}")
//	public ResponseEntity<NhanVien> CapNhatNhanVien(@PathVariable("id") String id, @RequestBody NhanVien nhanvien) {
//		Optional<NhanVien> nhanvienData = repo.findById(id);
//
//		if (nhanvienData.isPresent()) {
//			NhanVien _nhanvien = nhanvienData.get();
//			_nhanvien.setHoten(nhanvien.getHoten());
//			_nhanvien.setSoNamKinhNghiem(nhanvien.getSoNamKinhNghiem());
//			_nhanvien.setThuviec(nhanvien.isThuviec());
//			return new ResponseEntity<>(repo.save(_nhanvien), HttpStatus.OK);
//		} else {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
//	}
//
//	@DeleteMapping("/nhanvien/{id}")
//	public ResponseEntity<HttpStatus> XoaMotNhanVien(@PathVariable("id") String id) {
//		try {
//		    repo.deleteById(id);
//		    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//		  } catch (Exception e) {
//		    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//		  }
//	}
//
//	@DeleteMapping("/nhanvienall")
//	public ResponseEntity<HttpStatus> XoaTatCaNhanVien() {
//		try {
//		    repo.deleteAll();
//		    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//		  } catch (Exception e) {
//		    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//		  }
//	}

	@GetMapping("/xemdonhang")

	public ResponseEntity<List<DonHang>> XemDanhSachDonHang() {
		try {
			List<DonHang> donhanglst = new ArrayList<DonHang>();


			repo.findAll().forEach(donhanglst::add);

			if (donhanglst.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(donhanglst, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@GetMapping("/xemdonhang/{MaShipper_input}")
	public ResponseEntity<List<DonHang>> XemDanhSachDonHangShipper(@PathVariable(value = "MaShipper_input") String MaShipper_input) {

		try {
			List<DonHang> donhanglst = new ArrayList<DonHang>();
			Query q = new Query();
			q.addCriteria(Criteria.where("MaShipper").is(MaShipper_input));
			donhanglst = mongoTemplate.find(q, DonHang.class);
			if (donhanglst.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
	
			return new ResponseEntity<>(donhanglst, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@PutMapping("/capnhatdonhang")
	public ResponseEntity<DonHang> CapNhatTinhTrangDonHang(@RequestParam ("MaShipper_input") String MaShipper_input, 
			@RequestParam ("MaDH_input") String MaDH_input, @RequestParam ("TinhTrang_input") String TinhTrang_input) {

		try {
			Query q = new Query();
			q.addCriteria(Criteria.where("MaShipper").is(MaShipper_input).and("MaDH").is(MaDH_input));
			DonHang donhang = mongoTemplate.findOne(q, DonHang.class);
			donhang.setTinhTrangDonHang(TinhTrang_input);
			return new ResponseEntity<>(repo.save(donhang), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/themdonhang")
	public ResponseEntity<DonHang> ThemDonHang(@RequestBody DonHang donhang) {
		try {
			DonHang _donhang = repo.save(new DonHang(donhang.getMaDH(), donhang.getMaGH(),
					donhang.getMaNCC(), donhang.getMaPhuongThuc(), donhang.getMaShipper(), donhang.getPhiShip(), donhang.getNgayLapDon(), 
					donhang.getTinhTrangDonHang(),  donhang.getTinhTrangThanhToan(),  donhang.getPhiShip()));
			return new ResponseEntity<>(_donhang, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
