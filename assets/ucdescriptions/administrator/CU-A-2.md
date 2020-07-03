---
layout: page
title: "CU-A-2: Registrar Profesor"
permalink: /design-specification/uc-descriptions/administrator/cu-a-2/
hide_hero: true
---

**ID:** CU-A-4

**Nombre:** Registrar Profesor

**Autor:** Abner Jeffrey Tapia Cruz

**Fecha de creación:** 27 de marzo de 2020

**Fecha de actualización:** 2 de Julio de 2020

**Descripción:**  
El *Administrador* podrá registrar un **`PROFESSOR`** para que este pueda tener acceso a las diferentes funciones que le permite administrar un Practicante, evitando pérdidas de tiempo a la hora realizar algunas actividades.

**Actor:**  
*Administrador*

**Disparador:**  
El *Administrador* da clic en el botón “Registrar profesor” en la vista [`View_ProfessorSection`][VPSN].

**Precondiciones**  
Pre-1. Si ya existen **`PROFESSOR`** registrados, a lo más uno debe de estar en el estado “Activo”.

**Flujo Normal:**  
  1. <a id="FN1"><i></i></a>El *SPP* despliega la vista de registro [`View_AddProfessor`][VAPR] donde solicita el nombre, apellido paterno, apellido materno, número de personal, turno, contraseña del **`PROFESSOR`** y muestra los botones “Registrar” y “Cancelar”.
  2. <a id="FN2"><i></i></a>El *Administrador* ingresa el nombre, apellido paterno, apellido materno, número de personal, turno, contraseña del **`PROFESOR`** y selecciona el botón “Registrar”. (Ver <a href="#FA1">FA 1</a>) (Ver <a href="#FA3">FA 3</a>).
  3. El *SPP* muestra el diálogo [`Dialog_Confirmation`][DLCO] para validar que los datos introducidos sean los correctos, el diálogo muestra el mensaje “¿Seguro que desea registrar el Profesor con esos datos?” con los botones “Sí” y “Cancelar”.
  4. El *Administrador* da clic en el botón “Sí”. (Ver <a href="#FA2">FA 2</a>)
  5. EL *SPP* genera el username del **`USER`** con el número de personal añadiendo una “p” antes del número y muestra el diálogo [`Dialog_Information`][DLI] con el nombre de usuario y el botón “Aceptar”.
  6. El *Administrador* da clic en el botón “Aceptar”.
  7. <a id="FN7"><i></i></a>El *SPP* guarda un **`PROFESSOR`** en la base de datos, cambia su estado a “activo” y muestra el diálogo [`Dialog_Success`][DLSU] con el botón “Aceptar”. (Ver <a href="#EX1">EX 1</a>)
  8. El *Administrador* da clic en el botón “Aceptar”.
  9. Termina caso de uso.
	
**Flujos Alternos:**  
1. <a id="FA1"><i></i></a>*Cancelar registro*
	1. El *Administrador* da clic en el botón “Cancelar”
	2. El *SPP* muestra el diálogo [`Dialog_Confirmation`][DLCO] con el mensaje “¿Seguro desea cancelar?” y los botones “Sí” y “No”
	3. Si el *Administrador* da clic el botón “Sí”, termina el caso de uso, si selecciona el botón “No” entonces regresa al <a href="#FN2">FN-2</a> con la información ya ingresada anteriormente.

2. <a id="FA2"><i></i></a>*Cancelar confirmación*
	1. El *Administrador* da clic en el botón “Cancelar”
	2. El *SPP* regresa al <a href="#FN1">FN-1</a> con la información ya ingresada previamente.

3. <a id="FA3"><i></i></a>*Información inválida*
	1. El *Administrador* ingresa información inválida en los campos que se solicita
	2. El *SPP* muestra el diálogo [`Dialog_InvalidInformation`][DLII] con el mensaje "Se ha ingresado información no válida, por favor ingrese los datos correctamente". junto con el botón "Aceptar".
	3. El *Administrador* da clic en el botón "Aceptar".
	4. El *SPP* regresa al <a href="#FN1">FN-1</a>.

**Excepciones:**  
1. <a id="EX1"><i></i></a>*Error al conectar con la base de datos.*
	1.	El *SPP* muestra el diálogo [`Dialog_ConnectionError`][DLCE] con el mensaje “No se pudo registrar el Profesor. Intente de nuevo.” y los botones “Cancelar registro” e “Intentar de nuevo”. 
	2.	Si el *Administrador* da clic en el botón “Cancelar registro” termina el caso de uso, si selecciona la opción “Intentar de nuevo” el *SPP* regresa <a href="#FN7">FN-7</a>.

**Postcondiciones:**  
Post-1. El *SPP* guardó un **`PROFESSOR`** en la base de datos y se cambió su estado a “activo”.

**Incluye (Relación Include):**  
No incluye.

**Extiende (Relación Extend):**  
No extiende.

[VPSN]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/administrator/View_ProfessorSection.png "`View_ProfessorSection` Prototype"
[VAPR]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/administrator/View_AddProfessor.png "`View_AddProfessor` Prototype"
[DLII]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/generals/Dialog_InvalidInformation.png "`Dialog_InvalidInformation` Prototype"
[DLCO]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/generals/Dialog_Confirmation.png "`Dialog_Confirmation` Prototype"
[DLCE]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/generals/Dialog_ConnectionError.png "`Dialog_ConnectionError` Prototype"
[DLSU]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/generals/Dialog_Success.png "`Dialog_Success` Prototype"
[DLI]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/generals/Dialog_Information.png "`Dialog_Information` Prototype"