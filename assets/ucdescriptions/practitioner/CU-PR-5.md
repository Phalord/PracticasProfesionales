---
layout: page
title: "CU-PR-5: Generar reporte mensual"
permalink: /design-specification/uc-descriptions/practitioner/cu-pr-5/
hide_hero: true
---

**ID:** CU-PR-5

**Nombre:** Generar reporte mensual

**Autor:** Abner Jeffrey Tapia Cruz

**Fecha de creación:** 27 de marzo de 2020

**Fecha de actualización:** 26 de mayo de 2020

**Descripción**  
El **`PRACTITIONER`** generará un reporte mensual con una lista de las actividades realizadas y dando una descripción que él crea prudente, además de comentarios personales, guardando esta información que podrá ser consultada por un **`PROFESSOR`** y pueda ser calificada.

**Actor:** **Practicante**

**Disparador:**  
El **Practicante** da clic en el botón “generar reporte mensual” en la vista `View_Documentation`.

**Precondiciones**  
Pre-1. Debe existir al menos un **`PRACTITIONER`** registrado.

**Flujo Normal:**  
1. El SPP despliega la vista `View_MonthlyReport` y solicita el nombre de la actividad que realizó y la descripción junto con los botones de “Aceptar” y “Cancelar”.

2. El **Practicante** ingresa el nombre de la actividad con su descripción y da clic en el botón “Aceptar”. (Ver FA2.1)

3. El SPP muestra el diálogo `Dialog_Confirmation` con el mensaje “¿Quieres agregar otra actividad?” junto con los botones “Sí” y “No”.

4. El **Practicante** da clic en el botón “No”. (Ver FA 2.2)

5. El SPP muestra el diálogo `Dialog_Confirmation` con el mensaje “¿Deseas Finalizar tu reporte?” con los botones “Aceptar” y “Cancelar”.

6. El **Practicante** pulsa el botón “Aceptar”. (Ver FA 2.3)

7. El SPP genera un **`REPORT`** con la información entregada por el **Practicante**, lo guarda en el sistema y en la base de datos, finalmente muestra el diálogo `Dialog_Information` con el mensaje “¡Se ha generado el reporte exitosamente!” junto con el botón “Aceptar”. (Ver EX1)

8. El **Practicante** da clic en el botón “Aceptar”.

9. Fin del caso de uso.

**Flujos Alternos:**  

1. FA 2.1: Cancelar acción

	1. El **Practicante** selecciona la opción “Cancelar”
	2. El SPP muestra el diálogo `Dialog_Confirmation` con el mensaje “¿Seguro que deseas cancelar?” junto con botones “Sí” y “No”
	3. Si el **Practicante** da clic en el botón “Sí” termina el caso de uso, si no, vuelve al paso 2 del flujo normal con la información ingresada anteriormente.

2. FA 2.2: Añadir otra actividad

	1. El **Practicante** pulsa el botón “Sí”.
	2. El SPP regresa el flujo al paso 1.

3. FA 2.3: No finalizar el reporte.

	1. El **Practicante** da clic en el botón “Cancelar”
	2. EL SPP muestra el diálogo `Dialog_Information` con mensaje “los cambios aún no han sido guardados” junto con el botón “Aceptar”
	3. El **Practicante** da clic en el botón “Aceptar”
	4. El SPP vuelve al paso 2 del flujo normal con la información ingresada anteriormente.

**Excepciones:**  

1. EX1: El SPP no puede acceder a la base de datos**.**

	1. El SPP muestra el diálogo `Dialog_Confirmation` con el mensaje “Error, no se puede generar el reporte. Intenté de nuevo.” Junto con los botones “Intentar de nuevo” y “Cancelar”.
	2. Si el **Practicante** selecciona la opción “Intentar de nuevo” el SPP regresa al paso 7 del flujo normal, si selecciona la opción “Cancelar” termina el caso de uso.

**Postcondiciones:**  

Post-1. Se guardó un **`REPORT`** en el sistema y la base de datos.

**Incluye (Relación Include):**  
No incluye.

**Extiende (Relación Extend):**  
No extiende.
