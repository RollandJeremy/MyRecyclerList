# EgyGod
![CultureBox](https://culturebox.francetvinfo.fr/sites/default/files/assets/images/2018/12/maxstockfr009463.jpg)
## Membre de l'équipe (3A-ESIEA):
* Rolland Jérémy
## Présentation
Projet android mettant en scène un double écran : un avec une liste et l'autre avec les données de l'item.
EgyGod est une application android présentant différent Dieux Egyptiens. Il permet de connaître les caractéristiques de chacun d'eux.
Pourquoi passer d'un site à un autre pour les connaître quand on peut toujours les avoir à porter de main?

## Consignes Respectées
* Deux écrans : l'un avec une liste et l'autre avec les données de l'item
* Des données en cache
* Appel à une API REST
* Notifications PUSH Firebase
* Filtrage de la liste en fonction du nom des Dieux
* Utilisation du Gitflow
* Une Architecture MVC

## Caractéristique
Mettre une photo
### Les Propriétés des Dieux
Photo
EgyGod propose un large choix de propriété. Notamment le type de dieu, son rôle, son affiliation (les relations entre les dieux), son symbole majeur, ses attributs, son ou ses éléments et son animal totem ! Tout cela réaliser à l'aide du ScrollView pour la lisibilité. Il n'y a pas seulement de la documentation écrite mais des images pour donner du relief à l'application.
photo

### Une API personnel
EgyGod possède une API personnel. En effet, elle n'est utilisée par personne d'autres. Pour le moment seulement quelques dieux sont sur l'API. Elle est héberger sur le github sous un autre répertoire. Etant sur le github, il est facile de la maintenir et de la mettre à jour (ajour d'autres dieux à venir). Les plus importants suivant le mythe osirien sont opérationnels (voir image ci-haut)

### Un Cache
La masse de donnée d'EgyGod est relativement basse car il n'existe pas des centaines de dieux. Un cache a été implémenté afin de pouvoir, dans le cas où internet ferait faux bond, avoir la totalité de ses données présentes. L'application peut donc être utilisé avec ou sans internet sans restriction ! Il suffit d'au moins l'avoir charger une fois avec internet préalablement.

PHOTO(àfaire)

### Des Notifications

Afin de rendre l'application un peu plus abstractif et publicitaire, les notifications PUSH ont été implanté dans l'application. Pour ce faire, EgyGod est connecté à Firebase.

PHOTO

### Un Filtre

Plusieurs dieux sont disponibles sur l'application. Il serait plus facile de pouvoir chercher un dieu rapidement au lieu de scroller pour arriver jusqu'à lui ! C'est pourquoi EgyGod possède un système de filtrage - barre de recherche. On peut donc les trouver grâce à leurs noms.

### Gitflow et Architecture MVC

Enfin, vous pouvez le voir via le github, le gitflow a été utilisé afin de mener à bien le projet. Cela a permit de bien organiser le projet. De plus l'architecture MVC a été utilisé et le projet est assez clair et ordonné.
