---
layout: page
title: "CU-C-2: Asignar Proyecto"
permalink: /design-specification/uc-descriptions/coordinator/cu-c-2/
hide_hero: true
---
<style>
   a.disabled {
      color: #03989E;
      pointer-events: none;
      cursor: default;
   }
</style>

**ID:** CU-C-2

**Nombre:** Asignar Proyecto

**Autor:** Sandoval Bravo Alejandro

**Fecha de creación:** 20 de marzo de 2020

**Fecha de actualización:** 24 de mayo de 2020

**Descripción:**  
El *Coordinador* podrá asignar, a un **`PRACTITIONER`**, un **`PROJECT`** registrado para que el practicante pueda seguir con el proceso de la **`EDUCATIONAL EXPERIENCE`**

**Actor:**  
*Coordinador*

**Disparador:**  
El *Coordinador* da clic al botón "Asignar Proyecto" en la vista [`View_PractitionerSection`][VPSE].

**Precondiciones:**  
Pre-1. Debe haber, al menos, un **`PROJECT REQUEST`** en la Base de Datos.

**Flujo Normal:**
  1. El <a id="fn_1"></a> *SPP* recupera los **`PROJECT REQUEST`** de la Base de Datos y los muestra en la interfaz [`View_ProjectRequests`][VPRE]; la cual contiene tarjetas por solicitud con los botones "Asignar" al lado de cada proyecto de la solicitud, y un botón "Regresar". <a href="#ex_1">EX-1</a>
  2. El <a id="fn_2"></a> *Coordinador* busca al **`PRACTITIONER`** y da clic al botón "Asignar" del **`PROJECT`** que desee. <a href="#fa_1">FA-1</a>
  3. El <a id="fn_3"></a> *SPP* recupera la información del **`PRACTITIONER`** y del **`PROJECT`** de la base de datos y muestra una ventana emergente de confirmación [`View_AssignationConfirmation`][VACO] con los botones "Asignar" y "Cancelar". <a href="#ex_1">EX-1</a>
  4. El *Coordinador* da clic al botón "Asignar". <a href="#fa_2">FA-2</a>
  5. El <a id="fn_5"></a> *SPP* valida que el **`PROYECTO`** no se encuentre asignado (FA-3) y realiza la asignación del **`PROJECT`** en la Base de Datos; cambia el estado del **`PROJECT REQUEST`** a "Asignado" y muestra un [`Dialog_Succes`][DLSU]. <a href="#ex_1">EX-1</a>
  6. Termina el Caso de Uso.

**Flujos Alternos:**
  1. <a id="fa_1" class="disabled"><i>Cancelar Caso de Uso</i></a>
     1. El *Practicante* da clic al botón "Regresar".
     2. El *SPP* regresa a la [`View_PractitionerSection`][VPSE].
     3. Termina el Caso de Uso.
  2. <a id="fa_2" class="disabled"><i>Cancelar Confirmación</i></a>
     1. El *Practicante* da clic al botón "Cancelar"
     2. El *SPP* cierra la ventana [`View_AssignationConfirmation`][VACO] y regresa al FN-2.
  3. <a id="fa_3" class="disabled"><i>Proyecto ya se encuentra Asignado</i></a>
     1. El *SPP* muestra un diálogo [`Dialog_ProjectAlreadyAssigned`][DLAA].
     2. El *Practicante* da clic al botón "Aceptar"
     3. El *SPP* cierra el [`Dialog_ProjectAlreadyAssigned`][DLAA] regresa al FN-2.

**Excepciones:**
   1. <a id="ex_1" class="disabled"><i>Error al conectar con Base de Datos</i></a>
      1. El *SPP* muestra un [`Dialog_ConnectionError`][DLCE] con el botón "Aceptar".
      2. El *Practicante* da clic en el botón "Aceptar".
      3. El *SPP* cierra el [`Dialog_ConnectionError`][DLCE] y [<a href="#fn_1">FN-1</a>]: Despliega la ventana sin **`PROJECT REQUEST`**; [<a href="#fn_3">FN-3</a>, <a href="#fn_5">FN-5</a>]: regresa al <a href="#fn_2">FN-2</a>.


**Postcondiciones:**  
Post-1. El **`PRACTITIONER`** queda asignado al **`PROJECT`** en la Base de Datos.

**Incluye (Relación Include):**  
No incluye.

**Extiende (Relación Extend):**  
No extiende.

[VPSE]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/coordinator/View_PractitionerSection.png "`View_PractitionerSection` Prototype"
[VPRE]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/coordinator/View_ProjectRequests.png "`View_ProjectRequests` Prototype"
[VACO]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/coordinator/View_AssignationConfirmation.png "`View_AssignationConfirmation` Prototype"
[DLSU]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/generals/Dialog_Success.png "`Dialog_Success` Prototype"
[DLAA]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/coordinator/Dialog_ProjectAlreadyAssigned.png "`Dialog_ProjectAlreadyAssigned` Prototype"
[DLCE]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/generals/Dialog_ConnectionError.png "`Dialog_ConnectionError` Prototype"