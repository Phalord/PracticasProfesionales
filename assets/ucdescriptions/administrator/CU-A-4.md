---
layout: page
title: "CU-A-4: Eliminar Profesor"
permalink: /design-specification/uc-descriptions/administrator/cu-a-4/
hide_hero: true
---

**ID:** CU-A-6

**Nombre:** Eliminar Profesor

**Autor:** Abner Jeffrey Tapia Cruz

**Fecha de creación:** 27 de marzo de 2020

**Fecha de actualización:** 2 de Julio de 2020

**Descripción:** 
El *Administrador* elimina un **`PROFESSOR`** para restringir el acceso a las diferentes funcionalidades y así poder registrar otro. Todo esto con el fin de que haya un control hacia estos **`USER`** y que no más de dos tengan acceso.

**Actor:**  
*Administrador*

**Disparador:**  
El *Administrador* da clic en el botón “Eliminar profesor” en la vista [`View_ProfessorSection`][VPSN].

**Precondiciones:**  
PRE-1. Debe existir al menos un **`PROFESSOR`** registrado y en estado “Activo”.

**Flujo Normal:**  
  1. <a id="FN1"><i></i></a>El *SPP* obtiene los **`PROFESSOR`** de la base de datos para mostrar su información y listarlos en la vista [`View_DeleteProfessor`][VDPR] con los botones “Eliminar” y “Cancelar”. (Ver <a href="#EX1">EX 1</a>)
  2. El *Administrador* selecciona el **`PROFESSOR`** deseado y da clic en el botón “Eliminar”. (Ver <a href="#FA1">FA 1</a>)
  3. El *SPP* muestra el diálogo [`Dialog_Confirmation`][DLCO] para validar con el mensaje “¿Seguro que desea eliminar el Profesor?” y los botones “Sí” y “Cancelar”.
  4. El *Administrador* da clic en el botón “Sí”. (Ver <a href="#FA2">FA 2</a>)
  5. <a id="FN5"><i></i></a>El *SPP* pone en estado “No Activo” a **`PROFESSOR`** y muestra el diálogo [`Dialog_Success`][DLSU] con el botón “Aceptar”. (Ver <a href="#EX2">EX 2</a>)
  6. El *Administrador* da clic en el botón “Aceptar”.
  7. Termina caso de uso.

**Flujos Alternos:**  

1. <a id="FA1"><i></i></a>*Cancelar acción*
	1. El *Administrador* da clic en el botón “Cancelar”
	2. El *SPP* muestra el diálogo [`Dialog_Confirmation`][DLCO] con el mensaje “¿Seguro desea cancelar?” y los botones “Sí” y “No”.
	3. Si el *Administrador* da clic en el botón “Sí” termina caso de uso, si da clic en el botón “No”, regresa al <a href="#FN1">FN-1.</a>
2. <a id="FA2"><i></i></a>*Cancelar confirmación*
	1. El *Administrador* selecciona la opción “Cancelar”
	2. El *SPP* regresa al <a href="#FN1">FN-1.</a>

**Excepciones:**  

1. <a id="EX1"><i></i></a>*Error al conectarse con la base de datos y obtener la información.*
	1. El *SPP* muestra el diálogo [`Dialog_ConnectionError`][DLCE] con el mensaje “No se pudieron obtener los Profesores activos. Intente de nuevo.” Y el botón "Aceptar".
	2. El *Administrador* da clic en el botón "Aceptar.
	3. Termina el caso de uso.
2. <a id="EX2"><i></i></a>*Error al conectarse con la base de datos y guardar la información.*
	1. El *SPP* muestra el diálogo [`Dialog_ConnectionError`][DLCE] con el mensaje “No se pudo eliminar el Profesor. Intente de nuevo.” y los botones “Cancelar” e “Intentar de nuevo”.
	2. Si el *Administrador* da clic en el botón “Cancelar” termina el caso de uso, si selecciona la opción “Intentar de nuevo” el *SPP* regresa al <a href="#FN5">FN-5.</a>

**Postcondiciones:**  
Post-1. El *SPP* cambió un **`PROFESSOR`** a estado “no activo”.

**Incluye (Relación Include):**  
No incluye.

**Extiende (Relación Extend):**  
No extiende.

[VPSN]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/administrator/View_ProfessorSection.png "`View_ProfessorSection` Prototype"
[DLCE]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/generals/Dialog_ConnectionError.png "`Dialog_ConnectionError` Prototype"
[DLCO]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/generals/Dialog_Confirmation.png "`Dialog_Confirmation` Prototype"
[DLSU]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/generals/Dialog_Success.png "`Dialog_Success` Prototype"
[VDPR]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/administrator/View_DeleteProfessor.png "`View_DeleteProfessor` Prototype" 