package net.dev.onlineshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.dev.shoppingbackend.dao.CategoryDAO;
import net.dev.shoppingbackend.daoimpl.CategoryDAOimpl;
import net.dev.shoppingbackend.dto.Category;


@Controller
public class pageController {

	@Autowired
	private CategoryDAO categoryDAO;

	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Home");

		// passing the list of catrgories
		mv.addObject("categories", categoryDAO.list());

		mv.addObject("userclickHome", true);
		return mv;
	}

	@RequestMapping(value = "/about")
	public ModelAndView about() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "About Us");
		mv.addObject("userclickAbout", true);
		return mv;
	}

	@RequestMapping(value = "/contact")
	public ModelAndView contact() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Contact Us");
		mv.addObject("userclickContact", true);
		return mv;
	}

	/*
	 * method to load all the products and based on category
	 **/
	@RequestMapping(value = "/show/all/products")
	public ModelAndView showAllProducts() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "All Products");

		// passing the list of catrgories
		mv.addObject("categories", categoryDAO.list());

		mv.addObject("userclickAllProducts", true);
		return mv;
	}

	@RequestMapping(value = "/show/category/{id}/products")
	public ModelAndView showCategoryProducts(@PathVariable("id") int id) {

		ModelAndView mv = new ModelAndView("page");
		// categoryDAO to fetch a single category

		Category category = null;

		category = categoryDAO.get(id);

		
		mv.addObject("title", category.getName());

		// passing the list of catrgories
		mv.addObject("categories", categoryDAO.list());
		
		//passing the single category object
		mv.addObject("category", category);

		mv.addObject("userclickCategoryProducts", true);
		return mv;
	}

}
