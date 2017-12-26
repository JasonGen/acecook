package com.spring.henallux.controller;

import com.spring.henallux.dataAccess.DAO.AchatDAO;
import com.spring.henallux.dataAccess.DAO.LigneCommandeDAO;
import com.spring.henallux.dataAccess.Entity.AchatEntity;
import com.spring.henallux.model.AchatModel;
import com.spring.henallux.model.Basket;
import com.spring.henallux.model.ClientModel;
import com.spring.henallux.model.LigneCommandeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.Date;
import java.util.stream.Collectors;

import static com.spring.henallux.controller.Constants.ConstantsController.*;
import static com.spring.henallux.controller.MyAccountController.BASKET;
import static com.spring.henallux.controller.MyAccountController.CURRENT_USER;


@Controller
@RequestMapping(value = "/cart")
@SessionAttributes({CURRENT_USER, BASKET})
public class CartController {

    @Autowired
    private AchatDAO achatDAO;


    @RequestMapping(method = RequestMethod.GET)
    public String home(Model model) {
        return "integrated:cart";
    }

    @RequestMapping(value = "/confirmOrder", method = RequestMethod.GET)
    public String getConfirmOrder(@ModelAttribute(value = BASKET) Basket basket
            , @ModelAttribute(value = CURRENT_USER) ClientModel clientModel) {
        if (clientModel.getEmail() == null) {
            return REDIRECT_MYACCOUNT;
        } else {
            AchatModel achatModel = new AchatModel();
            achatModel.setClient(clientModel);
            achatModel.setDateAchat(new Date());

            //on ajoute à la commande toutes les lignes de commandes qui se trouve dans notre panier.
            achatModel.setLigneCommandeModelList(basket.getProducts().values());

            achatDAO.save(achatModel);

            return REDIRECT_HOME;
        }
    }
}
