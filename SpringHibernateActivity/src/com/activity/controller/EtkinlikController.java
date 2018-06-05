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
import com.activity.model.Kulup;
import com.activity.service.EtkinlikService;
import com.activity.service.KulupActivityService;

@Controller
public class EtkinlikController {
	
	@Autowired
	private EtkinlikService etkinlikService;

	@Autowired
	private KulupActivityService kulupActivityService;
	
	
	@RequestMapping(value="/saveEtkinlik",method=RequestMethod.POST)
	public ModelAndView saveData(@ModelAttribute("newEtkinlik") Etkinlik etkinlik){
		int kulupId = etkinlik.getKulup().getKulupId();
		Kulup kulup = kulupActivityService.getKulup(kulupId);
		etkinlikService.addEtkinlik(etkinlik,kulup);
		return new ModelAndView("redirect:/addEtkinlik");
	}
	
	 @RequestMapping(value = "/addEtkinlik", method = RequestMethod.GET)
	 public ModelAndView addEtkinlik(@ModelAttribute("newEtkinlik")  Etkinlik etkinlik) {
	  Map<String, Object> model = new HashMap<String, Object>();
	  model.put("etkinlikler",  etkinlikService.getEtkinlikler());
	  model.put("kulupler", kulupActivityService.getKulupler());
	  return new ModelAndView("addEtkinlik", model);
	 }
	 
	 @RequestMapping(value = "/deleteEtkinlik{id}", method = RequestMethod.GET)
	 public ModelAndView deleteetkinlik(@ModelAttribute("newEtkinlik") Etkinlik etkinlik, 
			 @RequestParam("id") int id) {
		
		Map<String, Object> model = new HashMap<String, Object>();		
		etkinlikService.deleteEtkinlik(id);
		model.put("etkinlikler",  etkinlikService.getEtkinlikler());
		model.put("kulupler", kulupActivityService.getKulupler());		
		return new ModelAndView("/addEtkinlik",model);
				
	 } 
	 
	 @RequestMapping(value = "/editEtkinlik", method = RequestMethod.GET)
	 public ModelAndView editetkinlik(@ModelAttribute("newEtkinlik")  Etkinlik etkinlik) {
	  Map<String, Object> model = new HashMap<String, Object>();
	  model.put("etkinlik", etkinlikService.getEtkinlik(etkinlik.getId()));
	  model.put("etkinlikler",  etkinlikService.getEtkinlikler());
	  model.put("kulupler", kulupActivityService.getKulupler());
	  return new ModelAndView("addEtkinlik", model);
	 }
	
	
}
