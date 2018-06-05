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
import com.activity.service.BaskanActivityService;

@Controller
public class BaskanActivityController {

	@Autowired
	private BaskanActivityService baskanActivityService;
	
	
	@RequestMapping(value="/saveBaskan",method=RequestMethod.POST)
	public ModelAndView saveData(@ModelAttribute("newBaskan") Baskan baskan){
		baskanActivityService.addBaskan(baskan);
		return new ModelAndView("redirect:/addBaskan");
	}
	
	 @RequestMapping(value = "/addBaskan", method = RequestMethod.GET)
	 public ModelAndView addBaskan(@ModelAttribute("newBaskan")  Baskan baskan) {
	  Map<String, Object> model = new HashMap<String, Object>();
	  model.put("baskanlar",  baskanActivityService.getBaskanlar());
	  return new ModelAndView("addBaskan", model);
	 }
	 
	 @RequestMapping(value = "/deleteBaskan{baskanId}", method = RequestMethod.GET)
	 public ModelAndView deleteBaskan(@ModelAttribute("newBaskan") Baskan baskan, 
			 @RequestParam("baskanId") int baskanId) {
		
		Map<String, Object> model = new HashMap<String, Object>();
		
		baskanActivityService.deleteBaskan(baskanId);
		model.put("baskan", baskanActivityService.getBaskan(baskan.getBaskanId()));
		model.put("baskanlar",  baskanActivityService.getBaskanlar());
		
		return new ModelAndView("/addBaskan",model);
				
	 } 
	 
	 @RequestMapping(value = "/editBaskan", method = RequestMethod.GET)
	 public ModelAndView editBaskan(@ModelAttribute("newBaskan")  Baskan baskan) {
	  Map<String, Object> model = new HashMap<String, Object>();
	  model.put("baskan", baskanActivityService.getBaskan(baskan.getBaskanId()));
	  model.put("baskanlar",  baskanActivityService.getBaskanlar());
	  return new ModelAndView("addBaskan", model);
	 }
	
	


}
