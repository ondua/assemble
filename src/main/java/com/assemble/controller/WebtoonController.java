package com.assemble.controller;

import java.io.File;
import java.util.Calendar;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.assemble.service.WebtoonService;
import com.assemble.vo.WebtoonVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
@Controller
public class WebtoonController {
	
	@Autowired
	private WebtoonService webtoonService;
	
	
	@RequestMapping("/webtooninsert")
	public String webtooninsert () {
		
		return "insert/webtooninsert";
	}
	@PostMapping("webinsert")
	public String webinsert( HttpServletRequest request,  HttpServletResponse response, WebtoonVO wb) throws Exception{
		String saveFolder=request.getRealPath("/resources/upload");
		System.out.println(saveFolder);
		int fileSize = 5*1024*1024; //이진파일 업로드 최대크기(5M)
		MultipartRequest multi=null;
		multi = new MultipartRequest(request,saveFolder,fileSize,"UTF-8");
		String webtoon_title = multi.getParameter("webtoon_title");
		String webtoon_writer = multi.getParameter("webtoon_writer");
		String webtoon_cont =multi.getParameter("webtoon_cont");
		String webtoon_tag1 = multi.getParameter("webtoon_tag1");
		String webtoon_tag2 = multi.getParameter("webtoon_tag2");
		int webtoon_complete = Integer.parseInt(multi.getParameter("webtoon_complete"));
		String webtoon_platform = multi.getParameter("webtoon_platform");
		
		File upFile = multi.getFile("webtoon_thumbnail");//첨부된 파일을 가져온다.
		if(upFile != null) {
			String fileName = upFile.getName();//첨부된 파일명을 구함
			Calendar cal=Calendar.getInstance();//칼렌더는 추상클래스로 new로 객체 생성을
			//못한다. 하지만 년월일 시분초 값을 반환할 때 사용
			int year=cal.get(Calendar.YEAR);//년도값
			int month = cal.get(Calendar.MONTH)+1;//월값, +1을 한 이유는 1월이 0으로 반환
			//되기 때문이다.
			int date = cal.get(Calendar.DATE);//일값
			
            String homedir=saveFolder+"/"+year+"-"+month+"-"+date;//오늘날짜 폴더
            //경로를 저장
            File path01=new File(homedir);
            
            if(!(path01.exists())) {//오늘날짜 폴더경로가 없다면
            	path01.mkdir();//오늘날짜 폴더를 생성
            }
            
            Random r=new Random();//난수(정해지지 않은 임의의 숫자)를 발생시키는 클래스
            int random=r.nextInt(100000000);//0이상 1억미만의 임의의 정수 숫자 난수 발생
            
            /* 첨부파일 확장자를 구함 */
            int index=fileName.lastIndexOf(".");// .를 맨오른쪽 부터 찾아서 가장 먼저 나
            //오는 .위치번호를 맨 왼쪽부터 카운터 해서 구함. 첫문자는 0부터 시작
            String fileExtendsion = fileName.substring(index+1);// 첨부파일에서 .
            //이후 부터 마지막 문자까지 구함. 첨부파일 확장자를 구함
            String refileName = "bbs"+year+month+date+random+"."+fileExtendsion;
            //bbs년월일1억미만랜덤숫자.확장자 즉 새로운 첨부파일명을 구함
            String fileDBName="/"+year+"-"+month+"-"+date+"/"+refileName;
            //데이터베이스에 저장될 레코드값
            
            upFile.renameTo(new File(homedir+"/"+refileName));//변경된 이진파일로 생성
            //된 폴더경로에 실제 업로드
            
            wb.setWebtoon_thumbnail(fileDBName);
		}else {//첨부파일이 없는 경우
			String fileDBName="";
			wb.setWebtoon_thumbnail(fileDBName);
		}
		wb.setWebtoon_title(webtoon_title);
		wb.setWebtoon_writer(webtoon_writer);
		wb.setWebtoon_cont(webtoon_cont);
		wb.setWebtoon_complete(webtoon_complete);
		wb.setWebtoon_platform(webtoon_platform);
		wb.setWebtoon_tag1(webtoon_tag1);
		wb.setWebtoon_tag2(webtoon_tag2);
		
		this.webtoonService.insertwebtoon(wb);
		return "index";
	}
}
