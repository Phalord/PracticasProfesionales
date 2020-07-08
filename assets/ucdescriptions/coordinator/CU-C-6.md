---
layout: page
title: "CU-C-10: Registrar Practicante"
permalink: /design-specification/uc-descriptions/coordinator/cu-c-10/
hide_hero: true
---

**ID:** CU-C-10

**Nombre:** Registrar Practicante

**Autor:** Abner Jeffrey Tapia Cruz

**Fecha de creación:** 27 de marzo de 2020

**Fecha de actualización:** 2 de Julio de 2020

**Descripción:**  
El *Coordinador* registra un nuevo **`PRACTITIONER`** en el sistema dándole un usuario y contraseña para que este pueda acceder al *SPP* y tener un registro de ellos.

**Actor:**  
*Coordinador*

**Disparador:**  
El *Coordinador* da clic en el botón “Registrar Practicante” en la vista [`View_PractitionerSection`][VPSE].

**Precondiciones:**  
No tiene precondiciones.

**Flujo Normal:**  
  1. <a id="FN1"><i></i></a>El *SPP* despliega la vista de registro [`View_AddPractitioner`][VAPT] y solicita la matricula, nombre, apellidos, y turno del **`PRACTITIONER`**. También se muestran los botones “Registrar” y “Cancelar” en la parte inferior de la ventana.
  2. <a id="FN2"><i></i></a>El *Coordinador* ingresa la información solicitada y da clic en el botón “Registrar”. (Ver <a href="#FA1">FA 1</a>) (Ver <a href="#FA3">FA 3</a>).
  3. El *SPP* muestra el diálogo [`Dialog_Confirmation`][DLCO] para validar que los datos introducidos sean los correctos, el diálogo muestra el mensaje “¿Seguro que desea registrar el Practicante con esos datos?” y los botones “Sí” y “Cancelar”.
  4. El *Coordinador* da clic en el botón “Sí”. (Ver <a href="#FA2">FA 2</a>)
  5. EL *SPP* genera el username del **`USER`** con la matrícula y muestra el diálogo [`Dialog_Information`][DLI] con el nombre de usuario y el botón “Aceptar”.
  6. El *Coordinador* da clic en el botón “Aceptar”.
  7. <a id="FN7"><i></i></a>El *SPP* guarda un **`PRACTITIONER`** en la base de datos, cambia su estado a "Activo", le asigna una contraseña generada aleatoriamente y muestra el diálogo [`Dialog_Success`][DLSU] con el botón “Aceptar”. (Ver <a href="#EX1">EX 1</a>)
  8. El *Coordinador* da clic en el botón “Aceptar”.
  9. Fin del caso de uso.

**Flujos Alternos:**  
   1. <a id="FA1"><i></i></a>*Cancelar registro*
      1. El *Coordinador* da clic en el botón “Cancelar”
      2. El *SPP* muestra el diálogo [`Dialog_Confirmation`][DLCO] con el mensaje “¿Seguro desea cancelar?” con los botones “Sí” y “No”
      3. Si el *Coordinador* da clic en el botón “Sí”, termina el caso de uso, si selecciona el botón “No” entonces regresa al <a href="#FN2">FN-2</a> con la información ya ingresada anteriormente.
   2. <a id="FA2"><i></i></a>*Cancelar confirmación*
      1. El *Coordinador* da clic en el botón “Cancelar”
      2. El *SPP* regresa al <a href="#FN1">FN-1</a> con la información ya ingresada anteriormente.
   3. <a id="FA3"><i></i></a>*Información inválida.*
      1. El *Coordinador* ingresa información inválida en los campos que se solicita
      2.  El *SPP* muestra el diálogo [`Dialog_InvalidInformation`][DLII] con el mensaje "Se ha ingresado información no válida, por favor ingrese los datos correctamente". junto con el botón "Aceptar".
      3.  El *Coordinador* da clic en el botón "Aceptar".
      4.  El *SPP* regresa al <a href="#FN1">FN-1</a>.

**Excepciones:**  
   1. <a id="EX1"><i></i></a>*Error al concectar con la base de datos y guardar la información.*
      1. El *SPP* muestra el diálogo [`Dialog_ConnectionError`][DLCE] con el mensaje “No se pudo registrar el Practicante. Intente de nuevo.” y los botones “Cancelar registro” e “Intentar de nuevo”.
      2. Si el *Coordinador* da clic en el botón “Cancelar registro” termina el caso de uso, si selecciona la opción “Intentar de nuevo” el *SPP* regresa al <a href="#FN7">FN-7</a>.

**Postcondiciones:**  
Post-1. El *SPP* guardó un **`PRACTITIONER`** en la base de datos y se cambió su estado a “activo”.

**Incluye (Relación Include):**  
No incluye.

**Extiende (Relación Extend):**  
No extiende.

[VPSE]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/coordinator/View_PractitionerSection.png "`View_PractitionerSection` Prototype"
[VAPT]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/coordinator/View_AddPractitioner.png "`View_AddPractitioner` Prototype"
[DLCO]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/generals/Dialog_Confirmation.png "`Dialog_Confirmation` Prototype"
[DLSU]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/generals/Dialog_Success.png "`Dialog_Success` Prototype"
[DLCE]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/generals/Dialog_ConnectionError.png "`Dialog_ConnectionError` Prototype"
[DLII]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/generals/Dialog_InvalidInformation.png "`Dialog_InvalidInformation` Prototype"
[DLI]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/generals/Dialog_Information.png "`Dialog_Information` Prototype"