---
layout: page
title: "CU-C-6: Registrar Practicante"
permalink: /design-specification/uc-descriptions/coordinator/cu-c-6/
hide_hero: true
---

**ID:** CU-C-6

**Nombre:** Registrar Practicante

**Autor:** Abner Jeffrey Tapia Cruz

**Fecha de creación:** 27 de marzo de 2020

**Fecha de actualización:** 5 de Junio de 2020

**Descripción**  
El **Coordinador** registra un nuevo **`PRACTITIONER`** en el sistema dándole un usuario y contraseña para que este pueda acceder al SPP y tener un registro de ellos.

**Actor:** **Coordinador**

**Disparador:**  
El **Coordinador** da clic en el botón “Registrar Practicante” en la vista `View_PractitionerSection` .

**Precondiciones**  
No tiene precondiciones.

**Flujo Normal:**  
1. El SPP despliega la vista de registro `View_AddPractitioner` y solicita la matricula, nombre, apellido paterno, apellido materno, tipo de usuario y turno del **`PRACTITIONER`**. También se muestran los botones “Registrar” y “Cancelar” en la parte inferior de la ventana.

2. El **Coordinador** ingresa la información solicitada y da clic en el botón “Registrar”. (Ver FA 2.1) (Ver FA 2.3).

3. El SPP muestra el diálogo `Dialog_Confirmation` para validar que los datos introducidos sean los correctos, el diálogo muestra el mensaje “¿Seguro que desea registrar el Practicante con esos datos?” y los botones “Sí” y “Cancelar”.

4. El **Coordinador** da clic en el botón “Sí”. (Ver FA 2.2)

5. EL SPP genera el username del **`USER`** con la matrícula y muestra el diálogo `Dialog_Information` con el nombre de usuario y el botón “Aceptar”.

6. El **Coordinador** da clic en el botón “Aceptar”.

7. El SPP guarda un **`PRACTITIONER`** en la base de datos, le asigna una contraseña generada aleatoriamente y muestra el diálogo `Dialog_Information` con el Mensaje “¡Practicante registrado exitosamente!” y el botón “Aceptar”. (Ver EX1)

8. El **Coordinador** da clic en el botón “Aceptar”.

9. Fin del caso de uso.

**Flujos Alternos:**  
1. FA 2.1: Cancelar registro

	1. El **Coordinador** da clic en el botón “Cancelar”
	2. El SPP muestra el diálogo `Dialog_Confirmation` con el mensaje “¿Seguro desea cancelar?” con los botones “Sí” y “No”
	3. Si el **Coordinador** da clic en el botón “Sí”, termina el caso de uso, si selecciona el botón “No” entonces regresa al paso 2 del flujo normal con la información ya ingresada anteriormente.

2. FA 2.2: Cancelar confirmación.

	1. El **Coordinador** da clic en el botón “Cancelar”
	2. El SPP regresa al flujo normal con la información ya ingresada anteriormente.

3. FA 2.3: Información inválida.
	1. El **Coordinador** ingresa información inválida en los campos que se solicita
	2. El SPP muestra el diálogo `Dialog_InvalidInformation` con el mensaje "Se ha ingresado información no válida, por favor ingrese los datos correctamente". junto con el botón "Aceptar".
	3. El **Coordinador** da clic en el botón "Aceptar".
	4. El SPP regresa al paso 2 del flujo normal.

**Excepciones:**  
1. EX1: El SPP no pudo conectarse a la base de datos y no guardó la información

	1. El SPP muestra el diálogo `Dialog_Confirmation` con el mensaje “No se pudo registrar el Practicante, Intente de nuevo.” y los botones “Cancelar registro” e “Intentar de nuevo”.
	2. Si el **Coordinador** da clic en el botón “Cancelar registro” termina el caso de uso, si selecciona la opción “Intentar de nuevo” el SPP regresa al paso 7 del flujo normal.

**Postcondiciones:**  
Post-1. El SPP guardó un **`PRACTITIONER`** en el sistema y la base de datos.

**Incluye (Relación Include):**  
No incluye.

**Extiende (Relación Extend):**  
No extiende.
