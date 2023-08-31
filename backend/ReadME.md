# Backend a redux-library demo alkalmazáshoz

## Adattípusok

### Book típus

Az alkalmazás egyetlen típust használ, a Book típust. A Book típus egy könyvet reprezentál, és a következő mezőkből áll:

- id: azonosító, egyedi az alkalmazásban
- title: cím
- author: szerző
- year: kiadás éve
- state: állapot, a könyv állapota lehet UNREAD, READING, READ
- coverUrl: borítókép URL-je

## Végpontok

### api/books

Az [alábbi linken](https://api.postman.com/collections/25207031-65464538-c9de-4894-95db-7d0e379dcc65?access_key=PMAT-01H96G0D8JMAM34A2TFRZK1SW8) található egy Postman collection, amelyben megtalálhatóak a következő végpontok:

#### POST /api/books

Új könyv létrehozása. A könyv adatait a request body-ban kell megadni, a következő formátumban:

```json
{
  "title": "A könyv címe",
  "author": "A könyv szerzője",
  "year": 2021,
  "state": "UNREAD",
  "coverUrl": "https://picsum.photos/200/300"
}
```

#### GET /api/books

Összes könyv lekérdezése. A visszatérési érték egy lista, amelyben a könyvek adatai találhatóak. Paraméterben megadható a `name` query paraméter, hogy csak azokat a könyveket kapjuk vissza, amelyek címe tartalmazza a megadott szöveget.

```
/api/books              --> összes könyv lekérdezése
/api/books?name=Harry   --> az összes címében Harry-t tartalmazó könyv lekérdezése
```

#### GET /api/books/{id}

Egy könyv lekérdezése azonosító alapján. A visszatérési érték a könyv adatai.

#### PUT /api/books/{id}

Frissíti a megadott ID-jű könyv adatait. A könyv adatait a request body-ban kell megadni, a következő formátumban:

```json
{
  "title": "A könyv címe",
  "author": "A könyv szerzője",
  "year": 2021,
  "state": "UNREAD",
  "coverUrl": "https://picsum.photos/200/300"
}
```

#### DELETE /api/books/{id}

Törli a megadott ID-jű könyvet.

#### DELETE /api/books

Törli az összes könyvet.