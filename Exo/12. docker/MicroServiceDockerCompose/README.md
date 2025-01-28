# Documentation de l'API

Cette documentation couvre les endpoints de l'API pour la gestion des livres et des auteurs. L'API utilise deux services principaux : `auteur-api` et `book-api`.

## Prérequis

Avant de pouvoir interagir avec les API, vous devez démarrer les services en utilisant Docker Compose.

### 1. Cloner ou récupérer le projet
Assurez-vous que vous avez récupéré le projet avec les deux services (auteur et book).

### 2. Lancer les services

Placez-vous à la racine du projet où se trouve le fichier `docker-compose.yml`. Puis, exécutez la commande suivante pour démarrer les services avec Docker Compose :

```bash
docker-compose up
```

# Route pour l'API auteur

1. GET /auteur

```bash
GET http://localhost:8082/auteur
```

Reponse attendue :
```bash
[
  {
    "id": 1,
    "nom": "Toto"
  },
  {
    "id": 2,
    "nom": "Jean"
  }
]

```

2. PUT /auteur/{id}

```bash
PUT http://localhost:8082/auteur/1
Content-Type: application/json

{
  "nom": "Toto"
}

```
Reponse attendue: 

```bash
{
  "id": 1,
  "nom": "Toto Modifié"
}

```

3. DELETE /auteur/{id}

```bash
DELETE http://localhost:8082/auteur/1

```
Reponse attendue: 

```bash
{
  "message": "Auteur supprimé"
}

```

4. GET /auteur/{id}

```bash
GET http://localhost:8082/auteur/1

```
Reponse attendue: 

```bash
{
  "id": 1,
  "nom": "Toto"
}

```

5. POST /auteur

```bash
POST http://localhost:8082/auteur
Content-Type: application/json

{
  "nom": "Toto"
}

```
Reponse attendue: 

```bash
{
  "id": 3,
  "nom": "Toto"
}

```


# Route pour l'API book

1. GET /book

```bash
GET http://localhost:8081/book

```
Reponse attendue: 

```bash
[
  {
    "id": 1,
    "titre": "Le Livre 1",
    "id_auteur": 1
  },
  {
    "id": 2,
    "titre": "Le Livre 2",
    "id_auteur": 2
  }
]

```

2. GET /book/agregation_nom_auteur

```bash
GET http://localhost:8081/book/agregation_nom_auteur

```
Reponse attendue: 

```bash
[
  {
    "id": 1,
    "titre": "Le Livre 1",
    "id_auteur": 1,
    "auteur_nom": "Toto"
  },
  {
    "id": 2,
    "titre": "Le Livre 2",
    "id_auteur": 2,
    "auteur_nom": "Jean"
  }
]

```

3. GET /book/{id}

```bash
GET http://localhost:8081/book/1

```
Reponse attendue: 

```bash
{
  "id": 1,
  "titre": "Le Livre 1",
  "id_auteur": 1
}

```

4. PUT /book/{id}

```bash
PUT http://localhost:8081/book/1
Content-Type: application/json

{
  "titre": "Le Livre 1 Modifié",
  "id_auteur": 1
}

```
Reponse attendue: 

```bash
{
  "id": 1,
  "titre": "Le Livre 1 Modifié",
  "id_auteur": 1
}

```

5. DELETE /book/{id}

```bash
DELETE http://localhost:8081/book/1

```
Reponse attendue: 

```bash
{
  "message": "Livre supprimé"
}

```

6. POST /book

```bash
POST http://localhost:8081/book
Content-Type: application/json

{
  "titre": "Nouveau Livre",
  "id_auteur": 2
}

```
Reponse attendue: 

```bash
{
  "id": 3,
  "titre": "Nouveau Livre",
  "id_auteur": 2
}

```