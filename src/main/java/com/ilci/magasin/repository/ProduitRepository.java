package com.ilci.magasin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ilci.magasin.entity.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Integer>{

}
