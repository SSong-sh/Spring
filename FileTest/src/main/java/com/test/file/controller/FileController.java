package com.test.file.controller;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileController {
	
	@Autowired
	private ServletContext servletContext;

	@GetMapping("/add.do")
	public String add() {
		return "add";
	}
	
	@PostMapping("/addok.do")
	public String addok(Model model, String txt, MultipartFile attach, HttpServletRequest req) {
		
		System.out.println("txt: " + txt);
		System.out.println(attach.getName());
		System.out.println(attach.getOriginalFilename());
		System.out.println(attach.getContentType());
		System.out.println(attach.getSize());
		System.out.println(attach.isEmpty());
		
		String path = servletContext.getRealPath("/resources/files");
		System.out.println(path);
		
		
		try {
			
			//파일명 중복 체크
			//1. 넘버링
			//2. 고유 식별자
			//	- 시간_파일명
			//	- 난수_파일명
			//3. UUID > Universally Unique ID > 네트워크 상에서 고유성이 보장되는 ID 만들기
			
			// 	- 시간+ 난수 조합
			
			
			String filename = getFileName(attach.getOriginalFilename());
			//String filename = System.nanoTime() + "_" + attach.getOriginalFilename();
			
			//UUID uuid = UUID.randomUUID();
			//String filename = uuid + "_" + attach.getOriginalFilename();
			
			//업로드 파일을 원하는 곳으로 이동하기
			File file = new File(path +"\\" + filename);
			attach.transferTo(file);
			
			model.addAttribute("txt", txt);
			model.addAttribute("filename" , filename);
			model.addAttribute("orgfilename", attach.getOriginalFilename());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "addok";
	}

	private String getFileName(String filename) {
		
		//저장폴더 > 파일명 중복?
		//filename = test.txt
		
		String path = servletContext.getRealPath("/resources/files");
		
		int n = 1; //인덱스 숫자
		
		int index = filename.lastIndexOf(".");
		
		String tempName = filename.substring(0,index);//test
		
		String tempExt = filename.substring(index); //.txt
		
		while(true) {
			
			File file = new File(path + "\\" + filename); //files\test.txt
			
			if(file.exists()) {
				//있다 > 중복 > 파일명 변경
				//test.txt > text_1.txt
				filename = tempName + "_" + n + tempExt; //test_1.txt
				
				n++;
				
				
			} else {
				//없다 > 사용가능 
				
				return filename;
			}
			
			
		}

	}
	
	
	@GetMapping(value = "/download.do", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	@ResponseBody
	public ResponseEntity<Resource> downloadFile(@RequestHeader("User-Agent") String userAgent, String filename, HttpServletRequest req) {

		String path = req.getRealPath("/resources/files");
		Resource resource = new FileSystemResource(path + "\\" + filename);

		if (resource.exists() == false) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		String resourceName = resource.getFilename();

		// remove UUID
		String resourceOriginalName = resourceName.substring(resourceName.indexOf("_") + 1);

		HttpHeaders headers = new HttpHeaders();
		try {

			String downloadName = null;

			if (userAgent.contains("Trident")) {
				downloadName = URLEncoder.encode(resourceOriginalName, "UTF-8").replaceAll("\\+", " ");
			} else if (userAgent.contains("Edge")) {
				downloadName = URLEncoder.encode(resourceOriginalName, "UTF-8");
			} else {
				downloadName = new String(resourceOriginalName.getBytes("UTF-8"), "ISO-8859-1");
			}


			headers.add("Content-Disposition", "attachment; filename=" + downloadName);

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		return new ResponseEntity<Resource>(resource, headers, HttpStatus.OK);
	}
	
	@PostMapping ("/multi_addok.do")
	public String multi_addok(Model model, String txt, MultipartFile[] attach) {
		
		String path = servletContext.getRealPath("/resources/files");

		for (MultipartFile file : attach) {
			
			try {
				
				String filename = getFileName(file.getOriginalFilename());

			
				file.transferTo(new File(path +"\\" + filename));
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		model.addAttribute("txt", txt);
		model.addAttribute("attach" , attach);
		
		return "addok";
	}
}
