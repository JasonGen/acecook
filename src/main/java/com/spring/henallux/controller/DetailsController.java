package com.spring.henallux.controller;

import com.spring.henallux.dataAccess.DAO.MaterielDAO;
import com.spring.henallux.model.Basket;
import com.spring.henallux.model.LigneCommandeModel;
import com.spring.henallux.model.MaterielModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
@RequestMapping(value="/details")
@SessionAttributes({MyAccountController.CURRENT_USER, MyAccountController.BASKET})
public class DetailsController {

	@Autowired
	private MaterielDAO materielDAO;
    private MaterielModel materielModel;

	@ModelAttribute(value = "ligneCommande")
	public LigneCommandeModel ligneCommandeModel(){
		return new LigneCommandeModel();
	}

	@RequestMapping(value = "/{idProduct}",method=RequestMethod.GET)
	public String home(Model model, @PathVariable ("idProduct") Integer id)
	{
		if(id != null){
			materielModel = materielDAO.find(id);
			if(materielModel != null){
				model.addAttribute("materiel", materielModel);
			}
		}
		return "integrated:details";
	}

	@RequestMapping(value = "/addCart", method = RequestMethod.POST)
	public String addToCart(Model model
			, @ModelAttribute(value = "basket")Basket basket
			, @Valid @ModelAttribute(value = "ligneCommande") LigneCommandeModel ligneCommandeModel, final BindingResult errors){
		if(!errors.hasErrors())
		{
			ligneCommandeModel.setMateriel(materielModel);
			ligneCommandeModel.setPrixReel(materielModel.getPrix());
			Integer idProduct = ligneCommandeModel.getMateriel().getIdMateriel();
			basket.getProducts().put(idProduct, ligneCommandeModel);
			if(basket.getProducts().containsKey(ligneCommandeModel.getMateriel().getIdMateriel())){

				Integer quantity = basket.getProducts().get(idProduct).getNombrePieces();
				quantity = ligneCommandeModel.getNombrePieces();
				basket.getProducts().get(ligneCommandeModel.getMateriel().getIdMateriel()).setNombrePieces(quantity);
			}
		}
		return "integrated:details";
	}
}
