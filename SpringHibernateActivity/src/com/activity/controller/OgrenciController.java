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

import com.activity.model.Etkinlik;
import com.activity.model.Ogrenci;
import com.activity.service.EtkinlikService;
import com.activity.service.OgrenciService;

@Controller
public class OgrenciController {

	@Autowired
	private OgrenciService ogrenciService;
	
	@Autowired
	private EtkinlikService etkinlikService;

	
	@RequestMapping(value="/saveStudent",method=RequestMethod.POST)
	public ModelAndView saveData(@ModelAttribute("newStudent") Ogrenci ogrenci, Etkinlik etkinlik){	
		System.out.println(etkinlik.getId());
		int etkinlikId = etkinlik.getId();
		etkinlik = etkinlikService.getEtkinlik(etkinlikId);
		ogrenciService.addOgrenci(ogrenci,etkinlik);
		return new ModelAndView("redirect:/addOgrenci");
	}
	
	 @RequestMapping(value = "/addOgrenci", method = RequestMethod.GET)
	 public ModelAndView addogrenci(@ModelAttribute("newStudent")  Ogrenci ogrenci) {
	  Map<String, Object> model = new HashMap<String, Object>();
	  model.put("ogrenciler",  ogrenciService.getOgrenciler());
	  model.put("etkinlikler",  etkinlikService.getEtkinlikler());
	  return new ModelAndView("addStudent", model);
	 }
	 
	 @RequestMapping(value = "/deleteOgrenci{id}", method = RequestMethod.GET)
	 public ModelAndView deleteogrenci(@ModelAttribute("newStudent") Ogrenci ogrenci, 
			 @RequestParam("id") int id) {
		
		Map<String, Object> model = new HashMap<String, Object>();		
		ogrenciService.deleteOgrenci(id);
		model.put("ogrenciler",  ogrenciService.getOgrenciler());
		model.put("etkinlikler",  etkinlikService.getEtkinlikler());	
		return new ModelAndView("addStudent",model);
				
	 } 
	 
	 @RequestMapping(value = "/editOgrenci", method = RequestMethod.GET)
	 public ModelAndView editogrenci(@ModelAttribute("newStudent")  Ogrenci ogrenci) {
	  Map<String, Object> model = new HashMap<String, Object>();
	  model.put("ogrenci", ogrenciService.getOgrenci(ogrenci.getId()));
	  model.put("ogrenciler",  ogrenciService.getOgrenciler());
	  model.put("etkinlikler",  etkinlikService.getEtkinlikler());
	  return new ModelAndView("addStudent", model);
	 }
	
	
}
