---
layout: page
title: "CU-C-4: Eliminar Practicante"
permalink: /design-specification/uc-descriptions/coordinator/cu-c-4/
hide_hero: true
---

**ID:** CU-C-4

**Nombre:** Eliminar Practicante

**Autor:** Abner Jeffrey Tapia Cruz

**Fecha de creación:** 27 de marzo de 2020

**Fecha de actualización:** 25 de mayo de 2020

**Descripción:**  
El *Coordinador* elimina un **`PRACTITIONER`** del sistema para que ya no tenga acceso a las funcionalidades, guardando el historial de dicho **`PRACTITIONER`** permitiendo su posterior consulta.

**Actor:**  
*Coordinador*

**Disparador:**  
El **Administrador** da clic en el botón “Eliminar practicante” en la vista [`View_PractitionerSection`][VPSE].

**Precondiciones:**  
Pre-1. PRE-1. Debe existir al menos un **`PRACTITIONER`** registrado.

**Flujo Normal:**  
  1. El *SPP* recupera los **`PRACTITIONER`** de la base de datos, los muestra en forma de lista en la vista [`View_DeletePractitioner`][VDPI] y coloca los botones “Eliminar” por cada **`PRACTITIONER`** y el botón “Cancelar” en la esquina inferior izquierda. (Ver EX 1).
  2. El *Coordinador* selecciona el Practicante deseado y da clic en “Eliminar”. (Ver FA 1).
  3. El *SPP* muestra la información del **`PRACTITIONER`** seleccionado en la vista [`View_PractitionerInformation`][VPIN] con los botones “Eliminar” y “Cancelar”.
  4. El *Coordinador* da clic en el botón “Eliminar”. (Ver FA 2).
  5. El *SPP* muestra el diálogo [`Dialog_Confirmation`][DLCO] para validar con el mensaje “¿Seguro desea eliminar el Practicante seleccionado?” y los botones “Sí” y “Cancelar”.
  6. El *Coordinador* da clic en el botón “Sí”. (Ver FA 3).
  7. El *SPP* elimina el **`PRACTITIONER`** del sistema y de la base de datos y muestra el diálogo `Dialog_Information` con el mensaje “Se ha eliminado el practicante exitosamente” y el botón “Aceptar”. (Ver EX 2)
  8. El *Coordinador* da clic en el botón “Aceptar”.
  9. Termina caso de uso

**Flujos Alternos:**  
  1. *Cancelar acción*
     1. El *Coordinador* da clic en el botón “Cancelar”
     2. Termina el caso de uso
  2. *Cancelar opción  seleccionada*
     1. El *Coordinador* da clic en el botón “Cancelar”
     2. El *SPP* muestra el diálogo [`Dialog_Confirmation`][DLCO] con el mensaje “¿Seguro desea cancelar?” y los botones “Sí” y “No”.
     3. Si el *Coordinador* da clic en el botón “Sí”, termina caso de uso, si no, regresa al paso 1 del flujo normal.
  3. *Cancelar confirmación*
     1. El *Coordinador* da clic en el botón “Cancelar”.
     2.  El *SPP* regresa el paso 3 del flujo normal

**Excepciones:**  
   1. *Error al conectar con Base de Datos*
      1. El *SPP* muestra un diálogo de mensaje [`Dialog_ConnectionError`][DLCE].

**Postcondiciones:**  
Post-1. Se eliminó un **`PRACTITIONER`** del *SPP* y de la base de datos.

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