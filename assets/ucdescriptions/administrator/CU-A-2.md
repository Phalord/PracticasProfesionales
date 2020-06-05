---
layout: page
title: "CU-A-2: Registrar Profesor"
permalink: /design-specification/uc-descriptions/administrator/cu-a-2/
hide_hero: true
---

**ID:** CU-A-2

**Nombre:** Registrar Profesor

**Autor:** Abner Jeffrey Tapia Cruz

**Fecha de creación:** 27 de marzo de 2020

**Fecha de actualización:** 5 de Junio de 2020

**Descripción**  
El **Administrador** podrá registrar un **`PROFESSOR`** para que este pueda tener acceso a las diferentes funciones que le permite administrar un Practicante, evitando pérdidas de tiempo a la hora realizar algunas actividades.

**Actor:** **Administrador**

**Disparador:**  
El **Administrador** da clic en el botón “Registrar profesor” en la vista `View_ProfessorSection`.

**Precondiciones**  
Pre-1. Si ya existen **`PROFESSOR`** registrados, a lo más uno debe de estar en el estado “Activo”.

**Flujo Normal:**  
 1. El SPP despliega la vista de registro `View_AddProfessor `donde solicita el nombre, apellido paterno, apellido materno, número de personal, turno, tipo de usuario, contraseña del **`PROFESSOR`** y muestra los botones “Registrar” y “Cancelar”.

2. El **Administrador** ingresa el nombre, apellido paterno, apellido materno, número de personal, turno, tipo de usuario, contraseña del **`PROFESOR`** y selecciona el botón “Registrar”. (Ver FA 2.1) (Ver FA 2.3).

3. 	El SPP muestra el diálogo `Dialog_Confirmation` para validar que los datos introducidos sean los correctos, el diálogo muestra el mensaje “¿Seguro que desea registrar el Profesor con esos datos?” con los botones “Sí” y “Cancelar”.

4. El **Administrador** da clic en el botón “Sí”. (Ver FA 2.2)

5. EL SPP genera el username del **`USER`** con el número de personal añadiendo una “p” antes del número y muestra el diálogo `Dialog_Information` con el nombre de usuario y el botón “Aceptar”.

6.	El **Administrador** da clic en el botón “Aceptar”.

7.	El SPP guarda un **`PROFESSOR`** en la base de datos, cambia su estado a “activo” y muestra el diálogo `Dialog_Information` con el Mensaje “¡Profesor registrado exitosamente!” y el botón “Aceptar”. (Ver EX1)

8.	El **Administrador** da clic en el botón “Aceptar”.

9.	Termina caso de uso.
	
**Flujos Alternos:**  
1. FA 2.1: Cancelar registro.
	1. El **Administrador** da clic en el botón “Cancelar”
	2. El SPP muestra el diálogo `Dialog_Confirmation` con el mensaje “¿Seguro desea cancelar?” y los botones “Sí” y “No”
	3. Si el **Administrador** da clic el botón “Sí”, termina el caso de uso, si selecciona el botón “No” entonces regresa al paso 2 del flujo normal con la información ya ingresada anteriormente.

2. FA 2.2: Cancelar confirmación
	1. El **Administrador** da clic en el botón “Cancelar”
	2. El SPP regresa al flujo normal con la información ya ingresada previamente.

3. FA 2.3: Información inválida.
	1. El **Administrador** ingresa información inválida en los campos que se solicita
	2. El SPP muestra el diálogo `Dialog_InvalidInformation` con el mensaje "Se ha ingresado información no válida, por favor ingrese los datos correctamente". junto con el botón "Aceptar".
	3. El **Administrador** da clic en el botón "Aceptar".
	4. El SPP regresa al paso 2 del flujo normal.

**Excepciones:**  
1. EX1: El SPP no pudo conectarse a la base de datos y no guardó la información
	1.	El SPP muestra el diálogo `Dialog_Confirmation` con el mensaje “No se pudo registrar el Profesor. Intente de nuevo.” y los botones “Cancelar registro” e “Intentar de nuevo”. 
	2.	Si el **Administrador** da clic en el botón “Cancelar registro” termina el caso de uso, si selecciona la opción “Intentar de nuevo” el SPP regresa al paso 7 del flujo normal

**Postcondiciones:**  
Post-1. El SPP guardó un **`PROFESSOR`** en la base de datos y se cambió su estado a “activo”.

**Incluye (Relación Include):**  
No incluye.

**Extiende (Relación Extend):**  
No extiende.
