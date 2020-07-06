---
layout: page
title: "CU-PR-20: Generar Reporte Mensual"
permalink: /design-specification/uc-descriptions/practitioner/cu-pr-20/
hide_hero: true
---

**ID:** CU-PR-20

**Nombre:** Generar Reporte Mensual

**Autor:** Abner Jeffrey Tapia Cruz

**Fecha de creación:** 27 de marzo de 2020

**Fecha de actualización:** 2 de Julio de 2020

**Descripción:**  
El *Practicante* generará un reporte mensual con una lista de las actividades realizadas y dando una descripción que él crea prudente, además de comentarios personales, guardando esta información que podrá ser consultada por un **`PROFESSOR`** y pueda ser calificada.

**Actor:**  
*Practicante*

**Disparador:**  
El *Practicante* da clic en el botón “generar reporte mensual” en la vista [`View_GenerateDocumentation`][VGDN].

**Precondicione:**  
Pre-1. Debe existir al menos un **`PRACTITIONER`** registrado.

**Flujo Normal:**  
  1. <a id="FN1"><i></i></a>El *SPP* despliega la vista [`View_GenerateMonthlyReport`][VGMR] y solicita el nombre de la actividad que realizó y la descripción junto con los botones de “Aceptar” y “Cancelar”.
  2. <a id="FN2"><i></i></a>El *Practicante* ingresa el nombre de la actividad con su descripción y da clic en el botón “Aceptar”. (Ver <a href="#FA1">FA 1)</a>
  3. El *SPP* muestra el diálogo [`Dialog_Confirmation`][DLCO] con el mensaje “¿Quieres agregar otra actividad?” junto con los botones “Sí” y “No”.
  4. El *Practicante* da clic en el botón “No”. (Ver <a href="#FA2">FA 2</a>)
  5. El *SPP* muestra el diálogo [`Dialog_Confirmation`][DLCO] con el mensaje “¿Deseas Finalizar tu reporte?” con los botones “Aceptar” y “Cancelar”.
  6. El *Practicante* pulsa el botón “Aceptar”. (Ver <a href="#FA3">FA 3</a>)
  7. <a id="FN7"><i></i></a>El *SPP* genera un **`REPORT`** con la información entregada por el *Practicante*, lo guarda en el sistema y en la base de datos, finalmente muestra el diálogo [`Dialog_Sucess`][DLSU] con el botón “Aceptar”. (Ver <a href="#EX1">EX 1</a>)
  8. El *Practicante* da clic en el botón “Aceptar”.
  9. Fin del caso de uso.

**Flujos Alternos:**  
  1. <a id="FA1"><i></i></a>*Cancelar acción*
     1. El *Practicante* selecciona la opción “Cancelar”
     2. El *SPP* muestra el diálogo [`Dialog_Confirmation`][DLCO] con el mensaje “¿Seguro que deseas cancelar?” junto con botones “Sí” y “No”
     3. Si el *Practicante* da clic en el botón “Sí” termina el caso de uso, si no, vuelve al <a href="#FN2">FN-2</a> con la información ingresada anteriormente.
  2. <a id="FA2"><i></i></a>*Añadir otra actividad*
     1. El *Practicante* pulsa el botón “Sí”.
     2. El *SPP* regresa al <a href="#FN1">FN-1</a>.
  3. <a id="FA3"><i></i></a>*No finalizar el reporte*
     1. El *Practicante* da clic en el botón “Cancelar”
     2. EL *SPP* muestra el diálogo [`Dialog_Confirmation`][DLCO] con el botón “Aceptar”
     3.  El *Practicante* da clic en el botón “Aceptar”
     4.  El *SPP* vuelve al <a href="#FN1">FN-1</a> con la información ingresada anteriormente.

**Excepciones:**  

1. <a id="EX1"><i></i></a>*Error al acceder a la base de datos*
	1. El *SPP* muestra el diálogo [`Dialog_ConnectionError`][DLCE] con el mensaje “Error, no se puede generar el reporte. Intenté de nuevo.” Junto con los botones “Intentar de nuevo” y “Cancelar”.
	2. Si el *Practicante* selecciona la opción “Intentar de nuevo” el *SPP* regresa al <a href="#FN7">FN-7</a>, si selecciona la opción “Cancelar” termina el caso de uso.

**Postcondiciones:**  

Post-1. Se guardó un **`REPORT`** en el sistema y la base de datos.

**Incluye (Relación Include):**  
No incluye.

**Extiende (Relación Extend):**  
No extiende.

[VGDN]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/practitioner/View_GenerateDocumentation.png "`View_GenerateDocumentation` Prototype"
[VGMR]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/practitioner/View_GeneratePartialReport.png "`View_GeneratePartialReport` Prototype"
[DLSU]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/generals/Dialog_Success.png "`Dialog_Success` Prototype"
[DLCO]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/generals/Dialog_Confirmation.png "`Dialog_Confirmation` Prototype"
[DLCE]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/generals/Dialog_ConnectionError.png "`Dialog_ConnectionError` Prototype"