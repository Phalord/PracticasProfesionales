---
layout: page
title: "CU-C-5: Generar reporte de indicadores"
permalink: /design-specification/uc-descriptions/coordinator/cu-c-5/
hide_hero: true
---

**ID:** CU-C-5

**Nombre:** Generar Reporte de Indicadores

**Autor:** Abner Jeffrey Tapia Cruz

**Fecha de creación:** 27 de marzo de 2020

**Fecha de actualización:** 2 de Julio de 2020

**Descripción:**  
El *Coordinador* genera los **`REPORT`** que necesite de los indicadores para obtener la información que requiere y reportarla a su superior.

**Actor:**  
*Coordinador*

**Disparador:**  
El Coordinador da clic en el botón “Indicadores” en la vista [`View_CoordinatorMenu`][VCMN].

**Precondiciones:**  
Pre-1. Debe existir al menos un **`PRACTITIONER`** registrado.

**Flujo Normal:**  
  1. <a id="FN1"><i></i></a>El *SPP* muestra los diferentes **`FILTER`** recuperados de la base de datos que pueden tener los indicadores en la vista [`View_IndicatorsReport`][VIRP] y los botones “Cancelar” y “Generar PDF”. (Ver <a href="#EX1">EX 1</a>).
  2. El *Coordinador* selecciona el **`FILTER`** que desea aplicar.
  3. El *SPP* muestra el indicador correspondiente.
  4. El *Coordinador* da clic en el botón de “Generar PDF”. (Ver <a href="#FA1">FA 1</a>)
  5. El *SPP* genera un archivo PDF con los indicadores del **`FILTER`** y muestra el diálogo [`Dialog_Success`][DLSU] con el botón “Aceptar”. (Ver <a href="#EX2">EX 2</a>)
  6. El *Coordinador* da clic en el botón “Aceptar”.
  7. Termina el caso el uso.

**Flujos Alternos:**  
  1. <a id="FA1"><i></i></a>*Cancelar acción*
    1. El *Coordinador* da clic en el botón “Cancelar”
    2. El *SPP* muestra el diálogo [`Dialog_Confirmation`][DLCO] con el mensaje “¿Seguro desea cancelar?” y los botones “Sí” y “No”.
    3. Si el *Coordinador* da clic en el botón “Sí”, termina caso de uso, sino, el *SPP* regresa al <a href="#FN1">FN-1</a> con la información ya ingresada anteriormente. 

**Excepciones:**  
  1. <a id="EX1"><i></i></a>*Error al conectar con Base de Datos*
    1. El *SPP* muestra el diálogo [`Dialog_ConnectionError`][DLCE] con el mensaje “No se pudo filtrar los indicadores del proyecto. Intente de nuevo.” y el botón "Aceptar".
    2. El *Coordinador* da clic en el botón “Aceptar."
    3. Termina el caso de uso.
  2. <a id="EX2"><i></i></a>*Falta de espacio en disco*
    1. El *SPP* muestra el diálogo [`Dialog_Error`][DLER] con el mensaje “No hay suficiente espacio de almacenamiento para generar el pdf” y el botón “Aceptar”
    2. El *Coordinador* da clic en el botón “Aceptar”
    3. Termina el caso de uso.

**Postcondiciones:**  
Post-1. Se generó el **`REPORT`** de indicadores.

**Incluye (Relación Include):**  
No incluye.

**Extiende (Relación Extend):**  
No extiende.

**Filtros:**  
1. Género
2. Edad
3. Fecha
4. Tipo de proyecto

[VCMN]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/coordinator/View_CoordinatorMenu.png "`View_CoordinatorMenu` Prototype"
[VIRP]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/coordinator/View_IndicatorsReport.png "`View_IndicatorsReport` Prototype"
[DLCO]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/generals/Dialog_Confirmation.png "`Dialog_Confirmation` Prototype"
[DLSU]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/generals/Dialog_Success.png "`Dialog_Success` Prototype"
[DLCE]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/generals/Dialog_ConnectionError.png "`Dialog_ConnectionError` Prototype"
[DLER]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/generals/Dialog_Error.png "`Dialog_Error` Prototype"