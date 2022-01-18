package com.icia.dabyinsa;




import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.icia.dabyinsa.user.dto.BoardEventDto;
import com.icia.dabyinsa.user.dto.MemberDto;
import com.icia.dabyinsa.user.dto.ProductListDto;
import com.icia.dabyinsa.user.service.MainService;
import com.icia.dabyinsa.user.service.MemberService;

@Controller
public class MainController {
   
   @Autowired
   private MainService mserv;
   
   @Autowired
   private MemberService ms;
   
   
   @GetMapping("/")
   public String Index(Model model, HttpServletRequest request, String prod_id, Principal p) {
      
      
      List<ProductListDto> MNPList = mserv.getMainNPList();
      List<ProductListDto> MBPList = mserv.getMainBPList();
      int MBPcount = mserv.getMainBPcnt(prod_id);
      List<BoardEventDto> MBEList = mserv.getMainBEList();
      MemberDto member = ms.login(p.getName());
      
      System.out.println("MNPList : "+MNPList);
      System.out.println("MBPList : "+MBPList);
      System.out.println("MBEList : "+MBEList);
      Map<String, Object> mmap = new HashMap<String, Object>();
      mmap.put("MNPList",MNPList);
      mmap.put("MBPList",MBPList);
      mmap.put("MBPcount",MBPcount);
      mmap.put("MBEList",MBEList);
      mmap.put("member", member);
      
      
      model.addAttribute("mmap", mmap);
      

      List<String> cookieList = new ArrayList<String>();
      Cookie[] cookies = request.getCookies();
      for (int i = 2; i < cookies.length; i++) {
         cookieList.add(cookies[i].getValue());
         System.out.println(cookies[i].getValue());
         
      }
      
      model.addAttribute("val", cookieList);
      
      return "index";
   }
   


   
   @GetMapping("/product/{id}")
   public String product(@PathVariable("id") String prod_id, Model model,
      @RequestParam("p_num1") String num) {
      model.addAttribute("id" , prod_id );
      List<ProductListDto> pList = mserv.getproddetailList();
      
      model.addAttribute("pList", pList);
   
      return "user/product";
   }
   

   
}