package com.activity.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.activity.model.Baskan;
import com.activity.model.Kulup;
import com.activity.service.BaskanActivityService;
import com.activity.service.KulupActivityService;

@Controller
public class KulupActivityController {

	@Autowired
	private KulupActivityService kulupActivityService;
	
	@Autowired
	private BaskanActivityService baskanActivityService;

	@RequestMapping("/")
	public String home(){	
		
		return "index";
	}
	
	@RequestMapping(value="/saveKulup",method=RequestMethod.POST)
	public ModelAndView saveKulup(@ModelAttribute("newKulup") Kulup kulup){
		int baskanId = kulup.getBaskan().getBaskanId();
		Baskan baskan = baskanActivityService.getBaskan(baskanId);
		kulupActivityService.addKulup(kulup,baskan);
		return new ModelAndView("redirect:/addKulup");
	}
	
	@RequestMapping(value="/addKulup",method=RequestMethod.GET)
	public ModelAndView saveData(@ModelAttribute("newKulup") Kulup kulup){
		Map<String, Object> model = new HashMap<String,Object>();
		model.put("baskanlar",  baskanActivityService.getBaskanlar());
		model.put("kulupler", kulupActivityService.getKulupler());
		return new ModelAndView("addKulup",model);
	}
	
	@RequestMapping(value="/deleteKulup{kulupId}",method=RequestMethod.GET)
	public ModelAndView deleteKulup(@ModelAttribute("newKulup") Kulup kulup,
			@RequestParam("kulupId") int kulupId){
		
		kulupActivityService.deleteKulup(kulup.getKulupId());
		Map<String, Object> model = new HashMap<String,Object>();
		model.put("baskanlar",  baskanActivityService.getBaskanlar());
		model.put("kulupler", kulupActivityService.getKulupler());
		return new ModelAndView("redirect:/addKulup");
	}

	
	@RequestMapping(value="/editKulup",method=RequestMethod.GET)
	public ModelAndView editKulup(@ModelAttribute("newKulup") Kulup kulup){
		Map<String, Object> model = new HashMap<String,Object>();
		model.put("kulup", kulupActivityService.getKulup(kulup.getKulupId()));
		model.put("baskanlar",  baskanActivityService.getBaskanlar());
		model.put("kulupler", kulupActivityService.getKulupler());
		return new ModelAndView("addKulup",model);
	}
	
}
