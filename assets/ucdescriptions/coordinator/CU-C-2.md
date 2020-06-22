---
layout: page
title: "CU-C-2: Asignar Proyecto"
permalink: /design-specification/uc-descriptions/coordinator/cu-c-2/
hide_hero: true
---

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
El *Coordinador* da clic al botón "Asignar Proyecto" en la vista [`View_PractitionerSection`][VPSE]

**Precondiciones:**  
Pre-1. Debe haber, al menos, un **`PROJECT REQUEST`** en la Base de Datos.

**Flujo Normal:**
  1. El *SPP* recupera los **`PROJECT REQUEST`** de la Base de Datos y los muestra en la interfaz [`View_ProjectRequests`][VPRE]; la cual contiene tarjetas por solicitud con los botones "Asignar" al lado de cada proyecto de la solicitud, y un botón "Regresar". EX-1
  2. El *Coordinador* busca al **`PRACTITIONER`** y da clic al botón "Asignar" del **`PROJECT`** que desee. FA-1
  3. El *SPP* recupera la información del **`PRACTITIONER`** y del **`PROJECT`** de la base de datos y muestra una ventana emergente de confirmación [`View_AssignationConfirmation`][VACO] con los botones "Asignar" y "Cancelar". EX-1
  4. El *Coordinador* da clic al botón "Asignar". FA-2
  5. El *SPP* valida que el **`PROYECTO`** no se encuentre asignado. FA-3
  6. El *SPP* realiza la asignación del **`PROJECT`** en la Base de Datos y cambia el estado del **`PROJECT REQUEST`** a "Asignado" y muestra un [`Dialog_Succes`][DLSU]. EX-1

**Flujos Alternos:**
  1. *Regresar*
     1. El *Practicante* da clic al botón "Regresar".
     2. El *SPP* termina el Caso de Uso.
  2. *Cancelar Confirmación*
     1. El *Practicante* da clic al botón "Cancelar"
     2. El *SPP* cierra la ventana [`View_AssignationConfirmation`][VACO] y regresa al FN-2.
  3. *Proyecto ya se encuentra Asignado*
     1. El *SPP* muestra un diálogo [`Dialog_ProjectAlreadyAssigned`][DLAA].
     2. El *Practicante* da clic al botón "Aceptar"
     3. El *SPP* cierra el [`Dialog_ProjectAlreadyAssigned`][DLAA] regresa al FN-2.

**Excepciones:**
   1. *Error al conectar con Base de Datos*
      1. El *SPP* muestra un diálogo de mensaje [`Dialog_ConnectionError`][DLCE].
      2. El *Practicante* da clic en el botón "Aceptar".
      3. El *SPP* cierra el [`Dialog_ConnectionError`][DLCE].


**Postcondiciones:**  
Post-1. El **`PRACTITIONER`** queda asignado al **`PROJECT`** en la Base de Datos.

**Incluye (Relación Include):**  
No incluye.

**Extiende (Relación Extend):**  
No extiende.

[VPSE]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/coordinator/View_PractitionerSection.png "`View_PractitionerSection` Prototype"
[VPRE]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/coordinator/View_ProjectAssignation.png "`View_ProjectAssignation` Prototype"
[VACO]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/coordinator/View_AssignationConfirmation.png "`View_AssignationConfirmation` Prototype"
[DLSU]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/generals/Dialog_Success.png "`Dialog_Success` Prototype"
[DLAA]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/coordinator/Dialog_ProjectAlreadyAssigned.png "`Dialog_ProjectAlreadyAssigned` Prototype"
[DLCE]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/generals/Dialog_ConnectionError.png "`Dialog_ConnectionError` Prototype"