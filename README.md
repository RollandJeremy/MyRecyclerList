# EgyGod
![CultureBox](https://culturebox.francetvinfo.fr/sites/default/files/assets/images/2018/12/maxstockfr009463.jpg)
## Membre de l'équipe (3A-ESIEA):
* Rolland Jérémy
## Présentation
Projet android mettant en scène un double écran : un avec une liste et l'autre avec les données de l'item.
EgyGod est une application android présentant différents Dieux Egyptiens. Il permet de connaître les caractéristiques de chacun d'eux.
Pourquoi passer d'un site à un autre pour les connaître quand on peut toujours les avoir à porter de main?

## Consignes Respectées
* Deux écrans : l'un avec une liste et l'autre avec les données de l'item
* Des données en cache
* Appel à une API REST
* Notifications PUSH Firebase
* Filtrage de la liste en fonction du nom des Dieux
* Utilisation du Gitflow
* Une Architecture MVC

## Caractéristiques
<img
    src="https://zupimages.net/up/19/14/5c6t.jpg" 
    height="400px" 
    width="250px" 
/>
### Les Propriétés des Dieux

EgyGod propose un large choix de propriété. Notamment le type de dieu, son rôle, son affiliation (les relations entre les dieux), son symbole majeur, ses attributs, son ou ses éléments et son animal totem ! Tout cela réalisé à l'aide du ScrollView pour la lisibilité. Il n'y a pas seulement de la documentation écrite mais des images pour donner du relief à l'application.

<img
    src="https://zupimages.net/up/19/14/362o.jpg" 
    height="400px" 
    width="250px" 
/>
<img
    src="https://zupimages.net/up/19/14/6dvt.jpg" 
    height="400px" 
    width="250px" 
/>
### Une API personnelle
EgyGod possède une API personnelle. En effet, elle n'est utilisée par personne d'autres. Pour le moment seulement quelques dieux sont sur l'API. Elle est hébergé sur le github sous un autre répertoire. Etant sur le github, il est facile de la maintenir et de la mettre à jour (ajout d'autres dieux à venir). Les plus importants suivant le mythe osirien sont opérationnels (voir image ci-dessus)

### Un Cache
La masse de donnée d'EgyGod est relativement basse car il n'existe pas des centaines de dieux. Un cache a été implémenté afin de pouvoir, dans le cas où internet ferait faux bond, avoir la totalité de ses données présentes. L'application peut donc être utilisée avec ou sans internet sans restriction ! Il suffit d'au moins l'avoir chargé une fois avec internet préalablement.

<img
    src="https://zupimages.net/up/19/14/isib.jpg" 
    height="400px" 
    width="250px" 
/>

### Des Notifications

Afin de rendre l'application un peu plus attractive et publicitaire, les notifications PUSH ont été implantées dans l'application. Pour ce faire, EgyGod est connecté à Firebase.

<img
    src="https://zupimages.net/up/19/14/lnyq.jpg" 
    height="400px" 
    width="250px" 
/>

### Un Filtre

Plusieurs dieux sont disponibles sur l'application. Il serait plus facile de pouvoir chercher un dieu rapidement au lieu de scroller pour arriver jusqu'à lui ! C'est pourquoi EgyGod possède un système de filtrage - barre de recherche. On peut donc les trouver grâce à leurs noms.

<img
    src="https://zupimages.net/up/19/14/lnyq.jpg" 
    height="400px" 
    width="250px" 
/>
<img
    src="https://zupimages.net/up/19/14/bo5b.jpg" 
    height="400px" 
    width="250px" 
/>
### Gitflow et Architecture MVC

Enfin, vous pouvez le voir via le github, le gitflow a été utilisé afin de mener à bien le projet. Cela a permis de bien organiser le projet. De plus l'architecture MVC a été utilisée et le projet est assez clair et ordonné.
