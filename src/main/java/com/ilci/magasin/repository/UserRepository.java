package com.ilci.magasin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ilci.magasin.entity.Personne;

@Repository
public interface UserRepository extends JpaRepository<Personne, Integer>{

	Personne findPersonneByLoginAndMdp(String login, String mdp);

}
