Download of clone de code naar uw device.

Download de .idea.zip uit de mail, zet hem in dezelfde map als de readme.md en pak hem uit.

##Database
Zorg ervoor dat u de database importeert in uw database structuur

Ik weet alleen hoe dit moet worden gedaan in phpmyadmin. Zet in XAMPP de apache en de MySQL modules aan.

##API
Importeer de code naar een Idea naar keuze. Ik heb dit in IntelliJ gedaan.

Zodra de code klaar is voor gebruikt druk op het knopje om het project uit runnen.

Vervolgens krijgt u 
```
2022-03-24 21:59:47.810  INFO 3976 --- [           main] c.e.d.DataprocessingApplication          : Started DataprocessingApplication in 3.649 seconds (JVM running for 4.243)
```
Dat betekend dat de API klaar is voor gebruik.

##API documentation
Als je naar
```http://localhost:8080/swagger-ui/```
gaat dan kan je de documentatie zien over de functies van de API.

##Website
Als je naar de website wil die in verbinding staat met de website die
met de api samenhangt, ga naar het mapje Front-end en druk op een .html file.

Op de HTML pagina kan je op zoek naar bijvoorbeeld stats, vertalingen of informatie over een bepaalde pokemon die je zelf in moet voeren.

##Feedback
U gaf aan dat de volgende put niet werkt
```
{
"id": 1,
"pokedexNumber": 2,
"name": "Ivysaurx",
"alternateForm": "",
"height": 1.0,
"weight": 13.0,
"primaryType": "Grass",
"classification": "Seed Pokemon",
"orignal": null,
"legendary": ""
}
```
Als u het op de volgende manier doet werkt het wel (in dit geval pas je de primarytype aan naar poison)
```
{
  "id": 1,
  "pokedexNumber": 1,
  "name": "\"Bulbasaurx\"",
  "alternateForm": "",
  "height": 0.7,
  "weight": 6.9,
  "primaryType": "\"poison\"",
  "classification": "\"Seed Pokemon\"",
  "legendary": "",
  "orignal": null
}
```