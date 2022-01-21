<h1 align="center"> 
**OPENWEATHER** </h1>

* [INTRODUZIONE](#intro)
* [ROTTE](#rotte)
* [TEST](#test)
* [AUTORI](#autori)



<a name="intro"></a>
##INTRODUZIONE

La nostra applicazione permette, inserendo una città a piacere, di osservare la velocità del vento in un range temporale di 5 giorni e di fare statistiche riguardanti la temperatura massima, minima, media e la varianza.

Il riferimento API di OpenWeather utilizzato nel nostro progetto è:

http://api.openweathermap.org/data/2.5/forecast?q={CityName}&appid={APIkey}

* *CityName* è il nome della città di riferimento inserita
* *APIkey* è la chiave di accesso al servizio

Per effettuare richieste, all'utente basterà avviare l'applicazione OpenWeatherApplication come SpringBoot App, poi con Postman, fare richieste inserendo le rotte qui di seguito.  


<a name="rotte"></a>
##ROTTE
L'utente può fare richieste tramite Postman all'indirizzo:
-------
**localhost:8080**  </h1>
-------

Può scegliere queste rotte: </h1>

|Tipo  | Rotta                                                    | Descrizione                                                  |
|----- |----------------------------------------------------------  |--------------------------------------------------------------|
| ` GET` | `/speed/cityName= {NomeCittà}`                           | *Serve a visualizzare in un file JSON la velocità del vento* |
| ` GET ` | `/save?cityName={NomeCittà}`                             | *Salva il file in formato JSON*                              |
| ` GET ` | `/savehour?cityName={NomeCittà}`                         | *Salva il file JSON ogni ora*                                |
| ` GET ` | `/hour/stats?cityName={NomeCittà}?sceltaGiorno={Giorni}` | *Rotta che genera il file JSON e visualizza le statistiche*  |
| ` GET ` | `/stats?cityName={NomeCittà}?sceltaGiorno={Giorni}`      | *Rotta che visualizza le statistiche*                        |

<a name="1"></a>
##1. /speed/cityName= {NomeCittà}

         "Data":"2022-01-25 21:00:00"
      },
      {
         "Vento(Speed)":1.43,
         "Data":"2022-01-25 21:00:00"
      },
      {
         "Vento(Speed)":1.43,
         "Data":"2022-01-25 21:00:00"
      },
      {
         "Vento(Speed)":1.43,
         "Data":"2022-01-25 21:00:00"
      },
      {
         "Vento(Speed)":1.43,
         "Data":"2022-01-25 21:00:00"
      },
      {
         "Vento(Speed)":1.43,
         "Data":"2022-01-25 21:00:00"
      },
      {
         "Vento(Speed)":1.43,
         "Data":"2022-01-25 21:00:00"
      },
      {
         "Vento(Speed)":1.43,
         "Data":"2022-01-25 21:00:00"
      },
      {
         "Vento(Speed)":1.43,
         "Data":"2022-01-25 21:00:00"
      }
]
}

 <a name="2"></a> 
## 2. /save?cityName={NomeCittà}
Verrà visualizzata una scritta come: </h1>

**E' stato salvato il file: C:\Users\monte\Documents\ProgettoPO\src\main\resources\Ancona-2022-01-20.json**

<a name="3"></a>
##3. /savehour?cityName={NomeCittà}
Verrà visualizzata una scritta come: </h1>

**Il file -C:\Users\monte\Documents\ProgettoPO\src\main\resources\Ancona_SalvataggioOgniOra.json- si sta aggiornando**

<a name="4"></a>
##4. /hour/stats?cityName={NomeCittà}?sceltaGiorno={Giorni}

"Nome città":"Milan", </h1>
"Numero di giorni scelti":2, </h1>
"Statistiche":[
    {
        "Valore minimo":279.9,
        "Varianza della temperatura percepita":81422.89364,
        "Varianza di temperatura reale":82002.30901333333,
        "Valore medio della temperatura reale":277.2625,
        "Valore massimo":279.9,
        "Valore medio della temperatura percepita":276.28125
    }
    ]
}

<a name="5"></a> 
##5. /stats?cityName={NomeCittà}?sceltaGiorno={Giorni}
{
"Nome città":"Montegiorgio",
"Numero di giorni scelti":2,
"Statistiche":[
{
    "Valore minimo":279.13,
    "Varianza della temperatura percepita":80664.05856666666,
    "Varianza di temperatura reale":81477.82582666668,
    "Valore medio della temperatura reale":276.37375,
    "Valore massimo":279.13,
    "Valore medio della temperatura percepita":274.98687499999994
    }
]
}

<a name="test"></a>
##TEST
Abbiamo infine inserito classi test per i salvataggi e per testare una città a scelta.

<a name="autori"></a>
##AUTORI
**MICHELE COSTANZI** </h1>
**VALERIA CANNONE** </h1>
