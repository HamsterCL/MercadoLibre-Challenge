<p align="center">
  <img src="https://http2.mlstatic.com/frontend-assets/ml-web-navigation/ui-navigation/6.4.1/mercadolibre/logo__large_plus.png" width="134" alt="MercadoLibre Logo" />
</p>

  <p align="center">Solución para el desafío de automatización - Mercadolibre</p>


## Descripción

Solución para desafío de automatización utilizando las herramientas:

- Selenium: https://www.selenium.dev/
- Cucumber: https://cucumber.io/
- Serenity-bdd: https://serenity-bdd.info/
- ScreenPlay: https://serenity-bdd.github.io/docs/tutorials/screenplay

El test automatizado comenzará a continuación de la creación y despliegue de los contenedores:
 - automation-challenge
 - report-storage
 - chrome-challenge.

Los test se encontrarán ejecutados en su totalidad para cuando el contenedor "test-automation-challenge" este detenido. En ese momento puede visitar la <a href="http://localhost:8080" target="_blank">pagina de reporte</a>, en donde se visualizará los resultados de los test ejecutados.

## Comando Git para clonar solución

```bash
$ git clone --recurse-submodules https://github.com/HamsterCL/MercadoLibre-Challenge.git
```


## Docker Compose

## Comienzo / start
```bash
$ docker-compose up -d
```

## Detención / stop
```bash
$ docker-compose down
```

## Contacto

- Author - [Hector Modinger S.](mailto:hectormodinger@gmail.com)

## Licencia

Licencia [GNU GENERAL PUBLIC LICENSE](LICENSE).

## NOTA

Favor no utilizar MacBook con procesador M1 o M2, compatibilidad de herramientas de prueba aún en desarrollo.



