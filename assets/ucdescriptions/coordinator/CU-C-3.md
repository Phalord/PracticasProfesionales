---
layout: page
title: "CU-C-3: Eliminar Proyecto"
permalink: /design-specification/uc-descriptions/coordinator/cu-c-3/
hide_hero: true
---

**ID:** CU-C-3

**Nombre:** Eliminar Proyecto

**Autor:** Abner Jeffrey Tapia Cruz

**Fecha de creación:** 27 de marzo de 2020

**Fecha de actualización:** 25 de mayo de 2020

**Descripción:**  
El Coordinador elimina un **`PROJECT`** del sistema para que los practicantes ya no lo puedan ver.

**Actor:**  
*Coordinador*

**Disparador:**  
El *Coordinador* da clic el botón “Eliminar Proyecto” en la vista [`View_ProjectSection`][VPSE].

**Precondiciones**  
Pre-1. Debe de haber por lo menos un **`PROJECT`** registrado.

**Flujo Normal:**  
  1. El *SPP* obtiene de la base de datos los **`PROJECT`**, los muestra en forma de lista en la vista [`View_DeleteProject`][VDPT] y muestra los botones “Eliminar” (por cada **`PROJECT`**) y el botón “Cancelar” en la parte inferior izquierda de la ventana. (Ver EX 1).
  2. El *Coordinador* da clic en el botón “Eliminar” para el **`PROJECT`** deseado. (Ver FA 1).
  3. El *SPP* muestra la información del **`PROJECT`** seleccionado en la vista [`View_ProjectInformation`][VPIN] y los botones “Eliminar” y “Cancelar”.
  4. El *Coordinador* da clic en el botón “Eliminar”. (Ver FA 2).
  5. El *SPP* muestra el diálogo [`Dialog_Confirmation`][DLCO] para validar con el mensaje “¿Seguro desea eliminar el Proyecto seleccionado?” y los botones “Sí” y “Cancelar”.
  6. El *Coordinador* da clic en el botón “Sí”. (Ver FA 3).
  7. El *SPP* elimina el **`PROJECT`** del sistema y de la base de datos y muestra el diálogo [`Dialog_Success`][DLSU] con el botón “Aceptar”. (Ver EX 2)
  8. El *Coordinador* da clic en el botón “Aceptar”.
  9. Termina caso de uso

**Flujos Alternos:**  
  1. *Cancelar acción*
	 1. El *Coordinador* da clic en el botón “Cancelar”
	 2. Termina el caso de uso
  2. *Cancelar selección*
	 1. El *Coordinador* da clic en el botón “Cancelar”
	 2. El *SPP* muestra el diálogo [`Dialog_Confirmation`][DLCO] con el mensaje “¿Seguro desea cancelar?” y los botones “Sí” y “No”.
	 3. Si el *Coordinador* da clic en el botón “Sí” termina caso de uso, si no, regresa al paso 1 del flujo normal.
  3. *Cancelar confirmación*
	 1. El *Coordinador* da clic en el botón “Cancelar”.
	 2. El *SPP* regresa el paso 3 del flujo normal.

**Excepciones:**  
  1. *El SPP no pudo conectarse a la base de datos para obtener los **`PROJECT`** y mostrar la lista.*
     1. El *SPP* muestra el diálogo [`Dialog_ConnectionError`][DLCE] con el mensaje “Imposible acceder a la sección. Intente más tarde” y muestra el botón “Aceptar”.
	 2. El *Coordinador* da clic en el botón “Aceptar”.
	 3. Termina el caso de uso.
  2. *El SPP no se pudo conectar a la base de datos para guardar la información*
	 1. El *SPP* muestra el diálogo [`Dialog_ConnectionError`][DLCE] con el mensaje “Error, no se pudo eliminar el Proyecto. Intentar más tarde.” y los botones “Intentar de nuevo” y “Cancelar”.
	 2. Si el *Coordinador* da clic en el botón “Intentar de nuevo” el *SPP* regresa al paso 7 del flujo normal, si selecciona la opción “Cancelar” termina el caso de uso.

**Postcondiciones:**  
Post-1. Se eliminó un **`PROJECT`** del *SPP* y de la base de datos.

**Incluye (Relación Include):**  
No incluye.

**Extiende (Relación Extend):**  
No extiende.

[VPSE]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/coordinator/View_PractitionerSection.png "`View_PractitionerSection` Prototype"
[VPIN]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/practitioner/View_ProjectInformation.png "`View_ProjectInformation` Prototype"
[VDPT]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/coordinator/View_DeleteProject.png "`View_DeleteProject` Prototype"
[DLCO]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/generals/Dialog_Confirmation.png "`Dialog_Confirmation` Prototype"
[DLSU]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/generals/Dialog_Success.png "`Dialog_Success` Prototype"
[DLCE]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/generals/Dialog_ConnectionError.png "`Dialog_ConnectionError` Prototype"