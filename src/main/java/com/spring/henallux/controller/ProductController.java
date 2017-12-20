package com.spring.henallux.controller;

import com.spring.henallux.dataAccess.DAO.AchatDAO;
import com.spring.henallux.dataAccess.DAO.MaterielDAO;
import com.spring.henallux.dataAccess.DAO.TraductionMaterielDAO;
import com.spring.henallux.model.MaterielModel;
import com.spring.henallux.model.TraductionMaterielModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

import static com.spring.henallux.controller.Constants.ConstantsController.MATERIEL_PAGE;
import static com.spring.henallux.controller.MyAccountController.BASKET;


@Controller
@RequestMapping(value="/products")
@SessionAttributes({MyAccountController.CURRENT_USER, BASKET})
public class ProductController {

	@Autowired
	private MaterielDAO materielDAO;

	@Autowired
	private TraductionMaterielDAO traductionMaterielDAO;

	@ModelAttribute(value = "productList")
	public List<MaterielModel> getProductList()
    {
		System.out.println("getproductList()");
		//System.out.println(materielDAO.find(1));
		return materielDAO.findAll();
		//System.out.println(materielDAO.);
	}

	@ModelAttribute(value = "translationProductList")
	public List<TraductionMaterielModel> getTranslationList()
    {
	    return traductionMaterielDAO.findAll();
    }

	@RequestMapping(method=RequestMethod.GET)
	public String home(Model model) 
	{
		//model.addAttribute("productList", materielDAO.findAll());
		System.out.println("INSIDE product Controller");
		return MATERIEL_PAGE;
	}
	
	

}
