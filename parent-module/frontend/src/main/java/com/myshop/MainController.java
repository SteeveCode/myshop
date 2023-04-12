package com.myshop;

import java.util.List;

import com.myshop.category.CategoryRepository;
import com.myshop.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.myshop.common.entity.Category;

@Controller
public class MainController {

	@Autowired private CategoryService categoryService;
	@Autowired private CategoryRepository repo;
	
	@GetMapping("/")
	public String viewHomePage(Model model) {
		List<Category> listCategories = categoryService.listNoChildrenCategories();
		model.addAttribute("listCategories", listCategories);
		
		return "index";
	}
}
