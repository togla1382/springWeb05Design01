package com.green.nowon.service;

import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

public interface FaqService {

	void list(Model model, String division, int page);

	void listFoAjax(ModelAndView mv, String division, int page);

}
