package com.icia.dabyinsa.user.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icia.dabyinsa.board.qrcode.dto.QfileDto;
import com.icia.dabyinsa.user.dao.ProductDao;
import com.icia.dabyinsa.user.dto.ProductListDto;
import com.icia.dabyinsa.user.dto.BoardQnaDto;
import com.icia.dabyinsa.user.dto.BoardReviewDto;

@Service
public class ProductService {

	@Autowired
	private ProductDao pDao;
	
	@Autowired
	private HttpSession session;
	
	// 상품 목록 (전체 + 검색)
	public List<ProductListDto> getProductList(String keyword) {
		return pDao.getpList(keyword);
	}
	

	// 상품 개수 (전체 + 검색)
	public int getProductcnt(String keyword)  {
		return pDao.getProductcnt(keyword);
	}	

	

	// 상품 상세 페이지 이동
	public List<ProductListDto> getproddetailList() {
		return pDao.getdetailList();
	}
	
	public String getimg(String prod_id) {
	return pDao.getcookie(prod_id);
	}
	
	
	
	//상품 문의 / 후기 게시판 출력
	public List<BoardReviewDto> getreviewList(String prod_id) {
		return pDao.getreviewList(prod_id);
	}
	public List<BoardQnaDto> getqnaList(String prod_id) {
		return pDao.getqnaList(prod_id);
	}

	

	public void getimg(ProductListDto pimg, HttpServletResponse res) {
		//이 메소드가 직접 사용자의 컴퓨터로 파일을 전송
		//이 때 response 객체를 사용.
		
		//실제 파일 저장 경로(upload폴더)에서 파일 가져오기
		String realPath = session.getServletContext()
				.getRealPath("/");
		realPath = realPath.substring(0, realPath.lastIndexOf("webapp")) + "resources/static/product/";
		
		//파일 이름을 원래 이름으로 변경
				String oName = pimg.getOriname();
				
				realPath += pimg.getSysname();
				
				//서버 폴더에서 파일을 가져오는 통로(stream)
				InputStream is = null;
				//사용자 컴퓨터로 파일을 보내는 통로(stream)
				OutputStream os = null;
				
				try {
					//파일명 인코딩(한글 깨짐 방지)
					String dfName = URLEncoder.encode(oName, "UTF-8");
					
					File file = new File(realPath);
					is = new FileInputStream(file);
					
					//인터넷을 통해 전달하기 위한 설정
					res.setContentType("application/octet-stream");
					res.setHeader("content-Disposition", 
							"attachment; filename=\"" + dfName + "\"");
					//attachment; filename="그림1.png"
					
					//보내는 통로 생성
					os = res.getOutputStream();
					
					//파일 전송(byte 단위로 전송)
					byte[] buffer = new byte[1024];
					int length;
					while((length = is.read(buffer)) != -1) {
						os.write(buffer, 0, length);
					}
				} catch (Exception e) {
					//e.printStackTrace();			
				} finally {
					try {
						os.flush();
						os.close();
						is.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			
		
	}
}