package com.spring.henallux.controller;

import com.spring.henallux.Service.CryptingPassword;
import com.spring.henallux.model.Basket;
import com.spring.henallux.model.ClientModel;
import com.spring.henallux.model.LoginForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.spring.henallux.dataAccess.DAO.ClientDAO;
import sun.rmi.runtime.Log;

import static com.spring.henallux.controller.Constants.ConstantsController.*;
import static com.spring.henallux.controller.MyAccountController.BASKET;


@Controller
@RequestMapping(value="/myAccount")
@SessionAttributes({MyAccountController.CURRENT_USER,BASKET })
public class MyAccountController {

	public static final String CURRENT_USER = "currentUser";
	public static final String BASKET = "basket";

	@Autowired
	private ClientDAO clientDAOImpl;

	@Autowired
	private CryptingPassword cryptingPassword;

	@ModelAttribute(BASKET)
	public Basket getBasket(){
		return new Basket();
	}

	@ModelAttribute(CURRENT_USER)
	public ClientModel getCurrentClient(){
		return new ClientModel();
	}

	@ModelAttribute(value = "loginForm")
	public LoginForm getLoginForm(){
		return new LoginForm();
	}

	@RequestMapping(method=RequestMethod.GET)
	public String home(Model model)
	{
		return "integrated:myAccount";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(Model model, @ModelAttribute(value = "loginForm")LoginForm loginForm, @ModelAttribute(value = "userForm")ClientModel client)
	{
		//TODO : appel service cryptage

		String cryptedPassword = null;

		try {
			cryptedPassword = cryptingPassword.cryptedPassword(loginForm.getPassword());
		} catch (Exception e) {
			e.printStackTrace();
		}

		ClientModel clientModel = clientDAOImpl.existForEmailAndPassword(loginForm.getEmail(), cryptedPassword);
		if(clientModel == null){

			return MYACCOUNT;
		}else
		{
		    client.setMotDePasse(clientModel.getMotDePasse());
		    client.setIdClient(clientModel.getIdClient());
		    client.setNumTel(clientModel.getNumTel());
		    client.setNom(clientModel.getNom());
		    client.setPrenom(clientModel.getPrenom());
			client.setCodePostal(clientModel.getCodePostal());
			client.setNumeroRue(clientModel.getNumeroRue());
			client.setRue(clientModel.getRue());
			client.setVille(clientModel.getVille());
            client.setDateNaiss(clientModel.getDateNaiss());
            model.addAttribute(CURRENT_USER, client);
		}
		return REDIRECT_HOME;
	}
}
