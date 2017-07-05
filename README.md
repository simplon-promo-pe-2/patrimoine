## Etape 1

Matérialiser dans votre workspace Eclipse votre propre copie du projet Maven présent dans ce dépôt.

Pour ce faire, vous pouvez décider de :

- jouer complètement le jeu de l'utilisation de Git/Github (fork, clone)
- vous passer de Git et simplement télécharger le contenu du dépôt

:question: : Observez les fichiers **pom.xml** et **persistence.xml**

## Etape 2

Executer les commandes suivantes et interpréter le compte-rendu d'exécution : 

- **mvn clean compile**
- **mvn clean test**

## Etape 3

Le fichier persistence.xml est incomplet, basez vous sur vos connaissances et les éléments identifiant la base de données pour le compléter.

Corriger également le nom de l'unité de persistence en vous basant sur le nom utilisé dans **VilleJpaTest**

:question: Observer une évolution dans le message d'erreur rencontré lors de l'exécution du test **VilleJpaTest** qui peut vous permettre de penser que votre configuration est pertinente.

## Etape 4

Enrichir la classe Ville en mettant en place le mapping avec la table CITIES en utilisant les annotations JPA.

Votre mapping pourra être considéré comme valide à partir du moment où **VilleJpaTest** sera passant (ou le résultat de la commande **mvn clean test** en SUCCESS)

:question: Avez vous essayé de mettre des annotations à la fois sur les attributs et les getters de la classe **Ville** ?

:question: Observer la structure de la classe **VilleJpaTest**, en particulier la façon dont est déclarée la méthode de test ainsi que les instructions utilisées pour vérifier la bonne correspondance entre le résultat attendu et le résultat obtenu.

## Etape 5

Enrichir le test unitaire et mapping pour également couvrir la latitude et la longitude

## Etape 6

Ajouter dans Eclipse la "Vue" **Data Source Explorer** qui vous permet de vous connecter à la base de données et de l'explorer.
Dans cette vue, sur l'élément représentant votre connexion vous pouvez via clic droit > Open SQL Scrapbook ouvrir une fenêtre vous permettant d'exécuter une requête SQL.

Exécuter une requête via ce client intégré et constater que le résultat est le même que celui que vous auriez obtenu avec un client SQL classique.

## Etape 7

Utiliser la fonction **Generate Entities** from Table de **JPA Tools** pour générer l'entité **Monument** (ne pas se préoccuper de la relation avec la ville pour l'instant).

Observer le résultat et le comparer avec votre mapping de la classe **Ville**, puis écrire un nouveau test unitaire **MonumentJpaTest** à l'image du test unitaire déjà existant pour les villes.

Une fois le test passant, en profiter pour essayer de refactorer la classe **Monument** à votre goût

## Etape 8

Matérialiser la relation entre les classes **Ville** et **Monument** au sens Java.

Une fois que vous êtes satisfait de cette modélisation, enrichissez l'une des classes de test afin d'ajouter un nouveau scénario dont l'objectif sera de tester que la relation est bien chargée. L'objectif est que ce nouveau test compile mais qu'il ne soit pas passant (dans la mesure où le mapping n'a pas encore été enrichi).

Mettez à jour votre mapping JPA afin de configurer la (ou les) relation(s) mise(s) en place et faire passer le nouveau test unitaire (sans régression sur les tests existants).

:question: Avez-vous modélisé une relation unidirectionnelle ou bi-directionnelle ?

## Etape 9

Dans le package *co.simplon.poleEmploi.patrimoine.dao*, définir une interface **MonumentDao** avec la méthode suivante : *Monument getVMonumentById(Long id);*

Créer une classe **MonumentJpaDao** dans le package *co.simplon.poleEmploi.patrimoine.dao* qui va implémenter l'interface **MonumentDao**. Vous pouvez vous inspirer du code présent dans **VilleJpaTest** pour réaliser l'implémentation.

Enrichir la méthode *main* de la classe **GestionnairePatrimoine** pour appeler la méthode *Monument getMonumentById(Long id);* à partir de l'id passé en argument du programme, et afficher une représentation textuelle du monument obtenu dans la console.

:question: Avez-vous affiché les informations de la ville dans laquelle se trouve le monument ?

## Etape 10

Ajouter à l'interface **MonumentDao** une méthode *void deleteMonumentById(Long id);* et réaliser son implémentation dans **MonumentJpaDao**.

Enrichir la méthode *main* de la classe **GestionnairePatrimoine** pour appeler la méthode *void deleteMonumentById(Long id)* à partir de l'id passé en argument du programme.

:question: Avez-vous vérifié si le monument a été supprimé mais que la ville n'a (évidemment) pas été supprimée de son côté ?

## Etape 11

Enrichir le fichier **persistence.xml** avec la propriété *hibernate.show_sql* à la valeur *true* et reexecuter le programme **GestionnairePatrimoine**

Observer les requêtes SQL exécutées par JPA.

## Etape 12

Ajouter à l'interface **MonumentDao** une méthode *Monument createMonument(Monument monument);* et réaliser son implémentation dans **MonumentJpaDao**.

Enrichir la méthode *main* de la classe **GestionnairePatrimoine** pour appeler la méthode *Monument createMonument(Monument monument);* avec un monument créé pour l'occasion

:question: Avez-vous vérifié que l'instance de **Monument** renvoyée par la méthode *createMonument* comportait un id qui correspond à celui positionné par la base de données de façon automatique ?

## Etape 13 (Bonus, sujet plus avancé)

Prendre connaissance des tables VISITORS et VISITS, comprendre leur utilité et créer en SQL des données en lien avec un monument de votre choix.

Enrichir le modèle métier Java, son mapping avec la base de données, et écrire une méthode de test ciblant les données créées afin de valider la cohérence du mapping.

:question: Avez-vous modélisé une relation unidirectionnelle ou bi-directionnelle ?
