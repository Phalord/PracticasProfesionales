---
layout: page
title: "CU-A-4: Eliminar Profesor"
permalink: /design-specification/uc-descriptions/administrator/cu-a-4/
hide_hero: true
---

**ID:** CU-A-4

**Nombre:** Eliminar Profesor

**Autor:** Abner Jeffrey Tapia Cruz

**Fecha de creación:** 27 de marzo de 2020

**Fecha de actualización:** 25 de mayo de 2020

**Descripción** 
El **Administrador** elimina un **`PROFESSOR`** para restringir el acceso a las diferentes funcionalidades y así poder registrar otro. Todo esto con el fin de que haya un control hacia estos **`USER`** y que no más de dos tengan acceso.

**Actor:** **Administrador**

**Disparador:**  
El **Administrador** da clic en el botón “Eliminar profesor” en la vista `View_ProfessorSection`.

**Precondiciones**  
PRE-1. Debe existir al menos un **`PROFESSOR`** registrado y en estado “Activo”.

**Flujo Normal:**  
1. El SPP obtiene los **`PROFESSOR`** de la base de datos para mostrar su información y listarlos en la vista (“View_DeleteProfessor”) con los botones “Eliminar” y “Cancelar”. (Ver EX 1)

2. El **Administrador** selecciona el **`PROFESSOR`** deseado y da clic en el botón “Eliminar”. (Ver FA 2.1).

3. El SPP muestra el diálogo `Dialog_Confirmation` para validar con el mensaje “¿Seguro que desea eliminar el Profesor?” y los botones “Sí” y “Cancelar”.

4. El **Administrador** da clic en el botón “Sí”. (Ver FA 2.2).

5. El SPP pone en estado “No Activo” a **`PROFESSOR`** y muestra el diálogo `Dialog_Information` con el mensaje “Se ha eliminado el Profesor exitosamente” y el botón “Aceptar”. (Ver EX2)

6. El **Administrador** da clic en el botón “Aceptar”.

7. Termina caso de uso.

**Flujos Alternos:**  

1. FA 2.1: Cancelar acción.

	1. El **Administrador** da clic en el botón “Cancelar”
	2. El SPP muestra el diálogo `Dialog_Confirmation` con el mensaje “¿Seguro desea cancelar?” y los botones “Sí” y “No”.
	3. Si el **Administrador** da clic en el botón “Sí” termina caso de uso, si da clic en el botón “No”, regresa al paso 1 del flujo normal.

2. FA 2.2: Cancelar confirmación.

	1. El **Administrador** selecciona la opción “Cancelar”
	2. El SPP regresa al paso 1 del flujo normal.

**Excepciones:**  

1. EX1: EL SPP no puedo conectarse a la base de datos y no obtuvo los **`PROFESSOR`** para mostrarlos en forma de lista**.**

	1. El SPP muestra el diálogo `Dialog_Confirmation` con el mensaje “No se pudieron obtener los Profesores activos. Intente de nuevo.” Y los botones “Cancelar” e “Intentar de nuevo”.
	2. Si el **Administrador** selecciona la opción “Cancelar” termina el caso de uso, si selecciona la opción “Intentar de nuevo” el SPP regresa al paso 1 del flujo normal.

2. EX2: El SPP no pudo conectarse a la base de datos y no guardó la información

	1. El SPP muestra el diálogo `Dialog_Confirmation` con el mensaje “No se pudo eliminar el Profesor. Intente de nuevo.” y los botones “Cancelar” e “Intentar de nuevo”.
	2. Si el **Administrador** da clic en el botón “Cancelar” termina el caso de uso, si selecciona la opción “Intentar de nuevo” el SPP regresa al paso 5 del flujo normal.

**Postcondiciones:**  
Post-1. El SPP cambió un **`PROFESSOR`** a estado “no activo”.

**Incluye (Relación Include):**  
No incluye.

**Extiende (Relación Extend):**  
No extiende.
