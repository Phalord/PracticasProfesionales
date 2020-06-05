---
layout: page
title: "CU-A-1: Registrar Coordinador"
permalink: /design-specification/uc-descriptions/administrator/cu-a-1/
hide_hero: true
---

**ID:** CU-A-1

**Nombre:** Registrar Coordinador

**Autor:** Abner Jeffrey Tapia Cruz

**Fecha de creación:** 27 de marzo de 2020

**Fecha de actualización:** 5 de Junio de 2020

**Descripción:**  
El *Administrador* podrá registrar un **`COORDINATOR`** para que pueda tener acceso a diferentes funciones que le permitirán administrar un practicante, los diferentes proyectos de las empresas y generar los reportes correspondientes.

**Actor:**  
*Administrador* 

**Disparador:**  
El *Administrador* da clic en el botón “Registrar Coordinador” en la vista [`View_CoordinatorSection`][VCSE].

**Precondiciones**  
Pre-1. Si ya existen otros **`USER`** **`COORDINATOR`** registrados anteriormente, a lo más uno debe de estar en el estado “Activo”.

**Flujo Normal:**  

  1. El *SPP* muestra la vista de registro [`View_AddCoordinator`][VACR] en donde se solicita el nombre, el número de personal, el tipo de usuario y la contraseña del **`COORDINATOR`**. También se muestran las opciones “Registrar” y “Cancelar” en la parte inferior de la ventana.
  2. El *Administrador* ingresa el nombre del Coordinador, el número de personal, el tipo de usuario, la contraseña y da clic en el botón “Registrar”. (Ver FA 1) (Ver FA 3)
  3. El *SPP* despliega el diálogo [`Dialog_Confirmation`][DLCO] para validar que los datos introducidos sean los correctos, el diálogo muestra el mensaje “¿Seguro que desea registrar el Coordinador con esos datos?” y los botones “Sí” y “Cancelar”.
  4. El *Administrador* da clic en el botón “Sí”. (Ver FA 2)
  5. EL *SPP* genera el username del **`USER`** con el número de personal añadiendo una “c” antes del número y muestra el diálogo `Dialog_Information` con el nombre de usuario y el botón “Aceptar”.
  6. El *Administrador* da clic en el botón “Aceptar”.
  7. El *SPP* guarda un **`COORDINATOR`** en la base de datos, cambia su estado a “activo” y muestra el diálogo [`Dialog_Success`][DLSU] con el Mensaje “¡Coordinador registrado exitosamente!” y el botón “Aceptar”. (Ver EX 1)
  8. El *Administrador* da clic en el botón “Aceptar”.
  9. Termina el caso de uso.
  
**Flujos Alternos:**  
1. *Cancelar registro*
	1. El *Administrador* da clic en el botón “Cancelar”
	2. El *SPP* despliega el diálogo [`Dialog_Confirmation`][DLCO] que muestra el mensaje “¿Seguro desea cancelar?” con los los botones “Sí” y “No”
	3. Si el *Administrador* da clic en el botón “Sí”, termina el caso de uso, si selecciona el botón “No” entonces regresa al paso 2 del flujo normal con la información ya ingresada anteriormente.
2. *Cancelar confirmación*
	1. El *Administrador* da clic en el botón “Cancelar”
	2. El *SPP* regresa al flujo normal con la información ya ingresada anteriormente.
3. *Información inválida*
	1. El *Administrador* ingresa información inválida en los campos que se solicita
	2. El *SPP* muestra el diálogo [`Dialog_InvalidInformation`][DLII] con el mensaje "Se ha ingresado información no válida, por favor ingrese los datos correctamente". junto con el botón "Aceptar".
	3. El *Administrador* da clic en el botón "Aceptar".
	4. El *SPP* regresa al paso 2 del flujo normal.

**Excepciones:**  
1. El *SPP* no pudo conectarse a la base de datos y no se guardó la información.
 
	1. El *SPP* muestra el diálogo [`Dialog_Confirmation`][DLCO] con el mensaje “No se pudo registrar el Coordinador. Intente de nuevo.” y los botones “Cancelar registro” e “Intentar de nuevo”.
	2. Si el *Administrador* da clic en el botón “Cancelar registro” termina el caso de uso, si selecciona la opción “Intentar de nuevo” el *SPP* regresa al paso 7 del flujo normal.

**Postcondiciones:**  
Post-1. El *SPP* guardó un **`COORDINATOR`** en la base de datos y se cambió su estado a “activo”.

**Incluye (Relación Include):**  
No incluye.

**Extiende (Relación Extend):**  
No extiende.

[VACR]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/administrator/View_AddCoordinator.png "`View_AddCoordinator` Prototype"
[VCSE]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/administrator/View_CoordinatorSection.png "`View_CoordinatorSection` Prototype"
[DLCO]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/generals/Dialog_Confirmation.png "`Dialog_Confirmation` Prototype"
[DLSU]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/generals/Dialog_Success.png "`Dialog_Success` Prototype"
[DLII]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/generals/Dialog_InvalidInformation.png "`Dialog_InvalidInformation` Prototype"