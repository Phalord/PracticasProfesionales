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

**Descripción**  
El Coordinador elimina un **`PROJECT`** del sistema para que los practicantes ya no lo puedan ver.

**Actor:** **Coordinador**

**Disparador:**  
El **Coordinador** da clic el botón “Eliminar Proyecto” en la vista `View_ProjectSection`.

**Precondiciones**  
Pre-1. Debe de haber por lo menos un **`PROJECT`** registrado.

**Flujo Normal:**  
1. El SPP obtiene de la base de datos los **`PROJECT`**, los muestra en forma de lista en la vista `View_DeleteProject` y muestra los botones “Eliminar” (por cada **`PROJECT`**) y el botón “Cancelar” en la parte inferior izquierda de la ventana. (Ver EX1).

2. El **Coordinador** da clic en el botón “Eliminar” para el **`PROJECT`** deseado. (Ver FA 2.1).

3. El SPP muestra la información del **`PROJECT`** seleccionado en la vista `View_ProjectInformation` y los botones “Eliminar” y “Cancelar”.

4. El **Coordinador** da clic en el botón “Eliminar”. (Ver FA2.2).

5. El SPP muestra el diálogo `Dialog_Confirmation` para validar con el mensaje “¿Seguro desea eliminar el Proyecto seleccionado?” y los botones “Sí” y “Cancelar”.

6. El **Coordinador** da clic en el botón “Sí”. (Ver FA 2.3).

7. El SPP elimina el **`PROJECT`** del sistema y de la base de datos y muestra el diálogo `Dialog_Information` con el mensaje “Se ha eliminado el proyecto exitosamente” y el botón “Aceptar”. (Ver EX2)

8. El **Coordinador** da clic en el botón “Aceptar”.

9. Termina caso de uso

**Flujos Alternos:**  

1. FA 2.1: Cancelar acción.

	1. El **Coordinador** da clic en el botón “Cancelar”
	2. Termina el caso de uso

2. FA 2.2: Cancelar selección.

	1. El **Coordinador** da clic en el botón “Cancelar”
	2. El SPP muestra el diálogo `Dialog_Confirmation` con el mensaje “¿Seguro desea cancelar?” y los botones “Sí” y “No”.
	3. Si el **Coordinador** da clic en el botón “Sí” termina caso de uso, si no, regresa al paso 1 del flujo normal.

3. FA 2.3: Cancelar confirmación.

	1. El **Coordinador** da clic en el botón “Cancelar”.
	2. El SPP regresa el paso 3 del flujo normal.

**Excepciones:**  

1. EX1: El SPP no pudo conectarse a la base de datos para obtener los **`PROJECT`** y mostrar la lista.

	1. El SPP muestra el diálogo `Dialog_Warning` con el mensaje “Imposible acceder a la sección. Intente más tarde” y muestra el botón “Aceptar”.
	2. El **Coordinador** da clic en el botón “Aceptar”.
	3. Termina el caso de uso.

2. EX2: El SPP no se pudo conectar a la base de datos para guardar la información.

	1. El SPP muestra el diálogo `Dialog_Confirmation` con el mensaje “Error, no se pudo eliminar el Proyecto. Intentar más tarde.” y los botones “Intentar de nuevo” y “Cancelar”.
	2. Si el **Coordinador** da clic en el botón “Intentar de nuevo” el SPP regresa al paso 7 del flujo normal, si selecciona la opción “Cancelar” termina el caso de uso.

**Postcondiciones:**  
Post-1. Se eliminó un **`PROJECT`** del SPP y de la base de datos.

**Incluye (Relación Include):**  
No incluye.

**Extiende (Relación Extend):**  
No extiende.
