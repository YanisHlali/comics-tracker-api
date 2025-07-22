# Comics Tracker API
> ⚠️ **Attention : Le dossier `data` n'est pas inclus dans ce dépôt car les données sont confidentielles.**

API REST pour explorer et suivre les comics Marvel, leurs événements, périodes, issues, auteurs et éditions françaises.

---

## 📦 Ce dépôt est lié au projet Comics Tracker (Next.js)

Cette API alimente l'application web [Comics Tracker](https://github.com/YanisHlali/comics-tracker), développée avec Next.js et TypeScript, permettant de visualiser, filtrer et explorer les comics Marvel par périodes, séries, issues, événements et éditions françaises.

### Fonctionnalités principales de l'application web

- **Navigation par périodes** : Parcours chronologique des comics Marvel.
- **Liste des issues** : Visualisation détaillée des issues, avec filtres avancés (auteurs, titre, édition française, etc.).
- **Séries** : Regroupement des issues par séries, avec recherche et statistiques de traduction.
- **Événements** : Accès aux grands événements Marvel, avec catégorisation des issues principales et tie-ins.
- **Éditions françaises** : Identification visuelle des issues traduites et accès aux informations d’édition.
- **Comic Viewer** : Lecteur d’images optimisé pour desktop et mobile, avec navigation, zoom, et gestion des pages doubles.
- **Filtres et recherche** : Filtres dynamiques pour affiner la recherche par titre, auteur, période, etc.
- **Interface moderne** : UI responsive, dark mode, animations, et navigation fluide.

## Fonctionnalités principales

- **Liste des périodes** : `/api/periods` pour obtenir toutes les périodes Marvel (Marvel Now, All-New All-Different, Ultimate Universe...)
- **Liste des événements** : `/api/events` pour obtenir tous les événements Marvel, filtrables par période.
- **Issues, auteurs, éditions françaises** : accès aux données via endpoints dédiés (à compléter selon les contrôleurs disponibles).

## Structure des données

Les données sont stockées en JSON dans `src/main/resources/data/` :
- `periods.json` : périodes Marvel
- `marvel_now/events.json`, `issues.json`, `french_editions.json` : données spécifiques à chaque période
- `characters.json`, `pencillers.json`, `writers.json` : métadonnées sur les personnages et auteurs

## Technologies

- **Spring Boot 3**
- **Java 17**
- **Base de données H2 en mémoire** (pour le développement)

## Installation & Lancement

1. Cloner le projet :
   ```shell
   git clone https://github.com/YanisHlali/comics-tracker-api.git
   ```
2. Lancer l'API :
   ```shell
   ./mvnw spring-boot:run
   ```
   ou sous Windows :
   ```shell
   mvnw.cmd spring-boot:run
   ```
3. Accéder à l'API sur [http://localhost:8080](http://localhost:8080)

## Exemple de requêtes

- Liste des périodes : `GET /api/periods`
- Liste des événements : `GET /api/events`
- Filtrer les événements par période : `GET /api/events?periodName=marvel_now`

## Auteur

Yanis Hlali
