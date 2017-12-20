package com.spring.henallux.model;

import java.util.HashMap;
import java.util.Map;


public class Basket {

    private Map<Integer, LigneCommandeModel> products = new HashMap<Integer, LigneCommandeModel>();

    public Map<Integer, LigneCommandeModel> getProducts() {
        return products;
    }

    public void setProducts(Map<Integer, LigneCommandeModel> products) {
        this.products = products;
    }

    public Integer getNumberArticles()
    {
        Integer somme = 0;
        for(LigneCommandeModel lc:products.values())
        {
            somme += lc.getNombrePieces();
        }
        return somme;
    }

    public Double prixTotalAchats()
    {
        Double total = 0.00;
        for(LigneCommandeModel lc:products.values())
        {
            total += (lc.getNombrePieces() * lc.getPrixReel());
        }
        return total;
    }
}