# *SAP Next-Gen 2020*
## Projet : Application web de Gestion des formations de la Douane Tunisienne

### Configuration de base du projet en local
> NB: Après avoir cloné le projet sur votre machine, il faudrait faire quelques modifications 
> dans le fichier `application.properties`.

Pour trouver le fichier `application.properties`, il se trouve dans : `formations > src > main > resources`.

> Dans le fichier `application.properties`, vous allez modifier les lignes `2` et `3`.  
> ligne `2` : le nom d'utilisateur de votre base de données **Autre que `root`**  
> ligne `3` : le mot de passe de votre utilisateur base de données
>> Pour celui qui voudrais modifier le fichier `README.md`, le guide pour éditer un fichier Markdown est celui-ci : <https://www.markdownguide.org>

### Création de la base de données
**Il faudrait créer la base de données sur MySQL Workbench 8.0**  
La commande est : `create database FormationsDouane;`

> L'application démarre sur <localhost:8000>

Lorsque l'application démarre, elle affiche la page 'index.html'.
Ceci est une structure MVC de Spring Boot et Thymeleaf.

#### *Merci!* 