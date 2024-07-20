# DATASHIELD DOCUMENTATION

## I - Présentation de l'entreprise

Datashield est une entreprise informatique composée de 04 personnes avec des compétences différentes à savoir:

- ATCHEMI Djori Succès: Développeur, Data Scientist, Administrateur de base de donnée & Chef Projet
- BILAZA Tchaa Jeff: Développeur, Expert en Cybersécurité
- BISSIALO Lénica Lucie: Experte en Cybersécurité
- MALLY Théophile Gracio: Ingénieur Génie Logiciel, DevOps

Datashield s'engage à fournir une gamme complète de services informatiques spécialisés, répondant ainsi aux besoins évolutifs de ses clients dans un environnement numérique en constante évolution. Doté d'une expertise solide en analyse de données, sécurité informatique, cybersécurité, administration et audit des bases de données, Data Shield est déterminé à offrir des solutions de
pointe pour sécuriser, gérer et optimiser les actifs numériques de ses clients.

## II - Présentation du projet

Le projet consiste en la conception et la mise en place d'une infrastructure réseau (composition de plusieurs services) innovante visant à répondre aux besoins croissants de notre clientèle, notamment une application web. Le service web représente une opportunité unique pour notre entreprise de renforcer sa présence en ligne, d'interagir plus efficacement avec nos clients et de fournir des solutions personnalisées et adaptées à leurs besoins spécifiques.

Le contexte du projet est le déploiement de microservices au travers des technologies de conteneurisation.

1. **Objectifs**
    
    La mise en place des services essentiels pour le bon fonctionnement de l’infrastructure :
    
    - **Base de données** : Ce service permettra d’enregistrer dans des tables, les données générées durant le fonctionnement de l’application web
    - **Web** : Ce service permettra de répondre aux requêtes des utilisateurs désirant accéder à l’application web à l’adresse  “*webappl.datashield.tg*”
    - **Mail** :  Ce service permettra d’envoyer et de recevoir des mails via les adresses des utilisateurs et des adresses de contact de l’entreprise comme “*contact@datashield.tg*” et “*info@datashield.tg*”
    - **DNS** : Ce service permettra de résoudre le nom de domaine “*datashield.tg*”
    - **Pare-feu** : Ce service permettra de filtrer grâce à un ensemble de règle bien défini, les trafics qui auront lieu dans le réseau
    
2. **Résultats attendus**
    - Évolutivité dynamique du nombre d’instance de chaque service afin de s’adapter au pic de monté de charge
    - Une politique de sécurité définissant les trafics autorisés et ceux non autorisés et
    mis en place
    - Accessibilité de certains services depuis l’extérieur (Web, Mail, DNS) et d’autres non (Base de données)

## III - Livrables

### 1 - Repository Github

 [https://github.com/shamuz-sa/DataShield_Entreprise](https://github.com/shamuz-sa/DataShield_Entreprise)

Une fois sur le lien de notre projet, il faut premièrement le cloner en local en tapant dans le terminal la commande suivante :

```bash
git clone https://github.com/shamuz-sa/DataShield_Entreprise.git
```

Après clonage, toujours dans le terminal il faut se positionner dans le dossier du projet en suivant le chemin :

```bash
cd chemin_vers_le_dossier/DataShield_Entreprise
```

**⚠️** **A partir de cette étape Il faut s’assurer d’avoir docker et docker compose installé sur sa machine avant de continuer**

Pour construire les images docker et lancer les conteneurs de nos services, il faut taper la commande suivante :

```docker
docker-compose up --build
```

Une fois que que tous les conteneurs seront créés et lancés, il faudra impérativement configurer sa machine (précisément sa carte réseau) afin d'utiliser le service DNS qui tourne actuellement dans le container dns. La configuration de la carte réseau divers d’un système à l’autre (Windows, MacOs, Linux…). Prière de se référer aux spécificités de son système.

Le service DNS a pour adresse XXX.XXX.XXX.XXX


Une fois le DNS configuré sur sa machine, on peut accéder à notre site web à l'adresse suivante :

```
webapp.datashield.io
```

Notre serveur de messagerie est accessible quant à elle à cette adresse :

```
127.0.0.1:555
```

### 2 - Cahier des charges

Le cahier des charges est le fichier Cahier_Des_Charges.pdf dans le ficher DataShield.zip

### 3 - Topologie réseau et plan d’adressage

![topologie_reseau01.png](/topologie_reseau01.png)

### 4 - Vidéo de présentation

Une courte vidéo pour expliquer le projet et la gestion de l’équipe projet.

### 5- Code python

Il s’agit d’un code python qui nous permettra de faire des manipulations sur notre base de donnée qui contient des données clientes.
