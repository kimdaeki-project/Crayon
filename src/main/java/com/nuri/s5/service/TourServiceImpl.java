package com.nuri.s5.service;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.nuri.s5.dao.TourDAOImpl;
import com.nuri.s5.dao.TourFilesDAO;
import com.nuri.s5.model.TourFilesVO;
import com.nuri.s5.model.TourNoticeVO;
import com.nuri.s5.util.FileSaver;

@Service
public class TourServiceImpl implements TourService {

	@Inject
	private TourDAOImpl tourDAOImpl; 
	
	@Inject
	private TourFilesDAO tourFilesDAO;
	
	@Inject
	private FileSaver fs;
	
	
	public int fileWrite(TourFilesVO tourFilesVO)throws Exception{
		return tourFilesDAO.fileWite(tourFilesVO);
	}
	
	@Override
	public int tourWrite(TourNoticeVO tourNoticeVO, MultipartFile[] file, HttpSession session) throws Exception {
		
		String realPath = session.getServletContext().getRealPath("resources/upload/tour");
		System.out.println(realPath);
		TourFilesVO tourFilesVO = new TourFilesVO();
		int result = tourDAOImpl.tourWrite(tourNoticeVO);
		
		for (MultipartFile multipartFile : file) {
			if(multipartFile.getOriginalFilename() != "") {
				String fileName = fs.fileSave(realPath, multipartFile);
				tourFilesVO.setNum(tourNoticeVO.getNum());
				tourFilesVO.setFname(fileName);
				tourFilesVO.setOname(multipartFile.getOriginalFilename());
				tourFilesDAO.fileWite(tourFilesVO);
			}
		}
		
		return result;
	}

}