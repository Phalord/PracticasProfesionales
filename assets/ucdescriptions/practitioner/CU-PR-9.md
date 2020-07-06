---
layout: page
title: "CU-PR-24: Añadir Actividad"
permalink: /design-specification/uc-descriptions/practitioner/cu-pr-24/
hide_hero: true
---
<style>
   a.disabled {
      color: #03989E;
      pointer-events: none;
      cursor: default;
   }
</style>

**ID:** CU-PR-24

**Nombre:** Añadir Actividad

**Autor:** Sandoval Bravo Alejandro

**Fecha de creación:** 25 de marzo de 2020

**Fecha de actualización:** 24 de mayo de 2020

**Descripción:**  
El *Practicante* deberá poder subir el PDF de su **`ACTIVITY`** para que su **`PROFESSOR`** proceda a calificarla.

**Actor:**  
*Practicante*

**Disparador:**  
El *Practicante* da clic al botón "Añadir Actividad" en la interfaz [`View_UploadDocumentation`][VUDC].

**Precondiciones:**  
Pre-1. El *Practicante* debe tener, al menos, una **`ACTIVITY`** asignada sin entregar.

**Flujo Normal:**
  1. El *SPP* recupera las **`ACTIVITY`** asignadas por el *Profesor* y muestra la interfaz [`View_UploadActivity`][VUDT], con los botones "Seleccionar Archivo", "Subir" y "Regresar". EX-1
  2. El <a id="fn_2"></a> *Practicante* selecciona la **`ACTIVITY`** a subir y da clic al botón "Seleccionar Archivo". <a href="#fa_1">FA-1</a>
  3. El *SPP* abre el Seleccionador de Archivos.
  4. El *Practicante* busca su **`ACTIVITY`** en el seleccionador de archivos, lo selecciona y da clic en "Cargar". <a href="fa_2">FA-2</a>
  5. El *SPP* carga el archivo del **`ACTIVITY`** y muestra el nombre del archivo. <a href="ex_1">EX-1</a>
  6. El <a id="fn_6"></a> *Practicante* da clic en el botón "Subir". <a href="#fa_1">FA-1</a>
  7. El *SPP* muestra un diálogo [`Dialog_Confirmation`][DLCO] con dos botones "Cancelar" y "Confirmar".
  8. El *Practicante* da clic en el botón "Confirmar". <a href="#fa_3">FA-3</a>
  9. El *SPP* guarda el **`ACTIVITY`** en la Base de Datos y muestra un [`Dialog_Success`][DLSU]. <a href="#ex_2">EX-2</a>
  10. El *Practicante* da clic en el botón "Aceptar".
  11. Termina el Caso de Uso.

**Flujos Alternos:**
  1. <a id="fa_1" class="disabled"><i>Cancelar Caso de Uso</i></a>
     1. El *Practicante* da clic en el botón "Atrás".
     2. El *SPP* regresa a la [`View_UploadDocumentation`][VUDC].
     3. Termina el Caso de Uso.
  2. <a id="fa_2" class="disabled"><i>Cancelar Cargar Documento</i></a>
     1. El *Practicante* da clic al botón "Cancelar" del seleccionador de archivos.
     2. El *SPP* cierra el seleccionador de archivos y regresa al <a href="#fn_2">FN-2</a>.
  3. <a id="fa_3" class="disabled"><i>Cancelar Confirmación</i></a>
     1. El *Practicante* da clic en el botón "Cancelar".
     2. El *SPP* cierra el [`Dialog_Confirmation`][DLCO] y regresa al <a href="#fn_6">FN-6</a>.

**Excepciones:**
   1. <a id="ex_1" class="disabled"><i>Error al cargar archivo</i></a>
      1. El *SPP* carga el archivo del **`ACTIVITY`** y muestra un [`Dialog_Error`][DLER].
      2. El *Practicante* da clic en el botón "Aceptar".
      3. El *SPP* regresa al <a href="#fn_2">FN-2</a>.
   2. <a id="ex_2" class="disabled"><i>Error al conectar con Base de Datos</i></a>
      1. El *SPP* guarda el **`ACTIVITY`** en la Base de Datos y muestra un [`Dialog_ConnectionError`][DLCE] con el botón "Aceptar".
      2. El *Practicante* da clic en el botón "Aceptar".
      3. El *SPP* cierra el [`Dialog_ConnectionError`][DLCE] y regresa al <a href="#fn_6">FN-6</a>.

**Postcondiciones:**  
Post-1. La **`ACTIVITY`** se guardó en la Base de Datos.

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