-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : jeu. 11 mai 2023 à 11:01
-- Version du serveur : 8.0.31
-- Version de PHP : 8.0.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `ilci_w3_magasin_corrige`
--

-- --------------------------------------------------------

--
-- Structure de la table `personne`
--

DROP TABLE IF EXISTS `personne`;
CREATE TABLE IF NOT EXISTS `personne` (
  `id` int NOT NULL AUTO_INCREMENT,
  `date_inscription` datetime(6) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `login` varchar(255) DEFAULT NULL,
  `mdp` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `sexe` varchar(255) DEFAULT NULL,
  `statut` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `personne`
--

INSERT INTO `personne` (`id`, `date_inscription`, `email`, `login`, `mdp`, `nom`, `prenom`, `sexe`, `statut`) VALUES
(1, '2023-05-09 11:57:28.330114', 'rou07@hotmail.com', 'ilci', 'ilci', 'Diallo', 'Abdoulaye', 'homme', 1);

-- --------------------------------------------------------

--
-- Structure de la table `produit`
--

DROP TABLE IF EXISTS `produit`;
CREATE TABLE IF NOT EXISTS `produit` (
  `id` int NOT NULL AUTO_INCREMENT,
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `image` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `libelle` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `prix` double NOT NULL,
  `quantite` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `produit`
--

INSERT INTO `produit` (`id`, `description`, `image`, `libelle`, `prix`, `quantite`) VALUES
(1, 'Le PC Gamer RGB RAINBOW SKY est conçu pour battre des records de performance et pour jouer fluidement même sur de gros jeux. La Carte Graphique Nvidia Geforce RTX 3060 Ti 8GO LHR vous permet de profiter d\'une puissance absolue en Full HD 1080 (1920x1080) et même en QHD 2K 1440P (2560x1440).', 'pc.jpeg', 'pc gamer', 800, 3),
(2, 'Choisir vos préférences en matière de cookies\r\nNous utilisons des cookies et des outils similaires qui sont nécessaires pour vous permettre d\'effectuer des achats, pour améliorer vos expériences d\'achat et fournir nos services, comme détaillé dans notre Avis sur les cookies. Nous utilisons également ces cookies pour comprendre comment les clients utilisent nos services (par exemple, en mesurant les visites sur le site) afin que nous puissions apporter des améliorations.', 'clavier.jpg', 'Clavier', 35, 25);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
