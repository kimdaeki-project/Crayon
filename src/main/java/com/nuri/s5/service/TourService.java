package com.nuri.s5.service;

import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

import com.nuri.s5.model.TourNoticeVO;

public interface TourService {
	
	public int tourWrite(TourNoticeVO tourNoticeVO, MultipartFile [] file, HttpSession session)throws Exception;
}