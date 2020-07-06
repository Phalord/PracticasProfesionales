---
layout: page
title: "CU-C-8: Eliminar Practicante"
permalink: /design-specification/uc-descriptions/coordinator/cu-c-8/
hide_hero: true
---

**ID:** CU-C-8

**Nombre:** Eliminar Practicante

**Autor:** Abner Jeffrey Tapia Cruz

**Fecha de creación:** 27 de marzo de 2020

**Fecha de actualización:** 2 de Julio de 2020

**Descripción:**  
El *Coordinador* elimina un **`PRACTITIONER`** del sistema para que ya no tenga acceso a las funcionalidades, guardando el historial de dicho **`PRACTITIONER`** permitiendo su posterior consulta.

**Actor:**  
*Coordinador*

**Disparador:**  
El **Administrador** da clic en el botón “Eliminar practicante” en la vista [`View_PractitionerSection`][VPSE].

**Precondiciones:**  
Pre-1. PRE-1. Debe existir al menos un **`PRACTITIONER`** registrado.

**Flujo Normal:**  
  1. <a id="FN1"><i></i></a>El *SPP* recupera los **`PRACTITIONER`** de la base de datos, y muestra su información muestra en forma de lista en la vista [`View_DeletePractitioner`][VDPI] con los botones “Eliminar” y “Cancelar” en la esquina inferior izquierda. (Ver <a href="#EX2">EX 1</a>).
  2. El *Coordinador* selecciona el Practicante deseado y da clic en “Eliminar”. (Ver <a href="#FA1">FA 1</a>).
  3. El *SPP* muestra el diálogo [`Dialog_Confirmation`][DLCO] para validar con el mensaje “¿Seguro desea eliminar el Practicante seleccionado?” y los botones “Sí” y “Cancelar”.
  4. El *Coordinador* da clic en el botón “Sí”. (Ver <a href="#FA2">FA 2</a>).
  5. <a id="FN5"><i></i></a>El *SPP* cambia el estado del **`PRACTITIONER`** a "No activo" y muestra el diálogo [`Dialog_Success`][DLSU] con el mensaje “Se ha eliminado el practicante exitosamente” y el botón “Aceptar”. (Ver <a href="#EX2">EX 2</a>)
  6. El *Coordinador* da clic en el botón “Aceptar”.
  7. Termina caso de uso

**Flujos Alternos:**  
  1. <a id="FA1"><i></i></a>*Cancelar acción*
     1. El *Coordinador* da clic en el botón “Cancelar”
     2. El *SPP* muestra el diálogo [`Dialog_Confirmation`][DLCO] con el mensaje “¿Seguro desea cancelar?” y los botones “Sí” y “No”.
	  3. Si el *Coordinador* da clic en el botón “Sí” termina caso de uso, si no, regresa al <a href="#FN1">FN-1</a>.
  2. <a id="FA2"><i></i></a>*Cancelar confirmación*
     1. El *Coordinador* da clic en el botón “Cancelar”.
     2.  El *SPP* regresa al <a href="#FN1">FN-1</a>.

**Excepciones:**  
   1. <a id="EX1"><i></i></a>*Error al conectar con Base de Datos y obtener la información.*
      1. El *SPP* muestra un diálogo de mensaje [`Dialog_ConnectionError`][DLCE].
      2. El *Coordinador* da clic en el botón "Aceptar".
      3. Termina el caso de uso.
   2. <a id="EX2"><i></i></a>*Error al conectar con Base de Datos y guardar la información.*
      1. El *SPP* muestra el diálogo [`Dialog_ConectionError`][DLCE] con el mensaje “Error, no se pudo eliminar el Practicante. Intenté de nuevo.” junto con los botones "Intentar de nuevo" y "Cancelar".
      2. Si el *Coordinador* da clic en el botón Cancelar termina el caso de uso, sino, regresa al <a href="#FN5">FN-5</a>. 

**Postcondiciones:**  
Post-1. El SPP cambió un **`PRACTITIONER`** a estado “no activo”.

**Incluye (Relación Include):**  
No incluye.

**Extiende (Relación Extend):**  
No extiende.

[VPSE]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/coordinator/View_PractitionerSection.png "`View_PractitionerSection` Prototype"
[VPIN]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/practitioner/View_ProjectInformation.png "`View_ProjectInformation` Prototype"
[VDPI]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/coordinator/View_DeletePractitioner.png "`View_DeletePractitioner` Prototype"
[DLCO]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/generals/Dialog_Confirmation.png "`Dialog_Confirmation` Prototype"
[DLSU]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/generals/Dialog_Success.png "`Dialog_Success` Prototype"
[DLCE]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/generals/Dialog_ConnectionError.png "`Dialog_ConnectionError` Prototype"