package com.korea.petclinic.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.korea.petclinic.service.ReservationService;
import com.korea.petclinic.vo.ReservationVO;
import com.korea.petclinic.vo.StatusCountVO;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("reservation")
@RequiredArgsConstructor
public class ReservationController {

	private final ReservationService reservationService;
	
	//전체조회
	@GetMapping
	public List<ReservationVO> findAll(){
		return reservationService.findAll();
	}
	
	@PostMapping
	public int insert(@RequestBody ReservationVO vo) {
		return reservationService.insert(vo);
	}
	
	@GetMapping("{id}")
	public ReservationVO findbyId(@PathVariable Long id) {
		return reservationService.findById(id);
	}
	
	
	//insert,update,delete 쿼리를 실행하고난 결과 -> 이 쿼리를 실행하고 나서
	//영향을 받은 행의 개수를 반환
	//예약 정보 수정
	@PutMapping("{id}")
	public int update(@PathVariable Long id, @RequestBody ReservationVO vo) {
		vo.setId(id);
		return reservationService.update(vo);
	}
	
	@DeleteMapping("{id}")
	public int delete(@PathVariable Long id) {
		return reservationService.delete(id);
	}
	
	//검색 기준을 선택하여 조회하기
	//사용자가 전달한 searchType값에 따라 다른 기준으로 예약 정보 검색하기
	//사용 가능한 검색 기준
	//pet : 반려동물 이름을 통한 검색
	//owner : 보호자 이름을 통한 검색
	//doctor : 담당 수의사 이름을 통한 검색
	
	//GET /reservation/search-detail?searchType=pet&keyword=초코
	//GET /reservation/search-detail?searchType=owner&keyword=김민수
	//GET /reservation/search-detail?searchType=doctor&keyword=이준호
	@GetMapping("search-detail")
	public List<ReservationVO> searchDetail(
			@RequestParam String searchType,
			@RequestParam String keyword){
		return reservationService.searchDetail(searchType, keyword);
	}
	
	//진료 예약 정보를 예상 진로비 순으로 정렬하여 조회하기
	//사용자가 sort값을 전달
	
	//asc : 가격 낮은 순
	//desc : 가격 높은 순
	
	//GET /reservation/sort?sort=asc
	@GetMapping("sort")
	public List<ReservationVO> findAllSort(@RequestParam(required=false) String sort){
		return reservationService.findAllSort(sort);
	}
	
	//전체 예상 진료비
	//GET /reservation/total-price
	@GetMapping("total-price")
	public Integer getTotalPrice() {
		return reservationService.getTotalPrice();
	}
	
	//예약 상태별 개수 출력
	//GET /reservation/status-count
	@GetMapping("status-count")
	public List<StatusCountVO> getStatusCount() {
		return reservationService.getStatusCount();
	}
	
	
	
	
	
	
	
	
}
