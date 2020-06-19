---
layout: page
title: "CU-PR-11: Añadir Plan de Actividades"
permalink: /design-specification/uc-descriptions/practitioner/cu-pr-11/
hide_hero: true
---

**ID:** CU-PR-11

**Nombre:** Añadir Plan de Actividades

**Autor:** Sandoval Bravo Alejandro

**Fecha de creación:** 25 de marzo de 2020

**Fecha de actualización:** 24 de mayo de 2020

**Descripción:**  
El *Practicante* deberá poder subir una versión PDF de su **`ACTIVITIES SCHEDULE`**.

**Actor:**  
*Practicante*

**Disparador:**  
El *Practicante* da clic al botón "Añadir Plan de Act." en la interfaz [`View_UploadDocumentation`][VUDC].

**Precondiciones:** 
Pre-1. El *Practicante* debe tener asignado un **`PROJECT`**.

**Flujo Normal:**
  1. El *SPP* muestra la interfaz [`View_UploadDocument`][VUDT], con los botones "Seleccionar Archivo", "Subir" y "Regresar".
  2. El *Practicante* da clic al botón "Seleccionar Archivo". FA-1
  3. El *SPP* abre el explorador de archivos del Sistema Operativo (SO).
  4. El *Practicante* busca su **`ACTIVITIES SCHEDULE`** en el explorador de archivos, lo selecciona y da clic en "Cargar". FA-2
  5. El *SPP* carga el **`ACTIVITIES SCHEDULE`**. EX-1
  6. El *Practiante* da clic en el botón "Subir".
  7. El *SPP* muestra un diálogo [`Dialog_Confirmation`][DLCO] con dos botones "Cancelar" y "Confirmar".
  8. El *Practicante* da clic en el botón "Confirmar". FA-3
  9. El *SPP* guarda el **`ACTIVITIES SCHEDULE`** en la Base de Datos y muestra un [`Dialog_Succes`][DLSU]. EX-2

**Flujos Alternos:**
  1. *Regresar*
     1. El *Practicante* da clic en el botón "Regresar".
     2. El *SPP* termina el Caso de Uso.
  2. *Cancelar Cargar Documento*
     1. El *Practicante* da clic al botón "Cancelar" del explorador de archivos.
     2. El *SO* cierra el explorador de archivos y regresa el enfoque al *SPP*, regresando al FN-2.
  3. *Cancelar Confirmación*
     1. El *Practicante* da clic en el botón "Cancelar".
     2. El *SPP* cierra el [`Dialog_Confirmation`][DLCO] y regresa al FN-2.

**Excepciones:**
   1. *Error al cargar el **`ACTIVITIES SCHEDULE`***
      1. El *SPP* muestra un [`Dialog_Error`][DLER] y regresa al FN-2
   2. *Error al conectar con Base de Datos*
      1. El *SPP* no puede conectarse con la Base de Datos para guardar el **`ACTIVITIES SCHEDULE`**.
      2. El *SPP* muestra un diálogo de mensaje [`Dialog_ConnectionError`][DLCE].

**Postcondiciones:**  
Post-1. El **`ACTIVITIES SCHEDULE`** se guardó en la Base de Datos.

**Incluye (Relación Include):**  
No incluye.

**Extiende (Relación Extend):**  
No extiende.

[VUDC]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/practitioner/View_UploadDocumentation.png "`View_UploadDocumentation` Prototype"
[VUDT]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/generals/View_UploadDocument.png "`View_UploadDocument` Prototype"
[DLCO]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/generals/Dialog_Confirmation.png "`Dialog_Confirmation` Prototype"
[DLSU]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/generals/Dialog_Success.png "`Dialog_Success` Prototype"
[DLCE]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/generals/Dialog_ConnectionError.png "`Dialog_ConnectionError` Prototype"
[DLER]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/generals/Dialog_Error.png "`Dialog_Error` Prototype"