---
layout: page
title: "CU-PR-1: Solicitar Proyecto"
permalink: /design-specification/uc-descriptions/practitioner/cu-pr-1/
hide_hero: true
---

**ID:** CU-PR-1

**Nombre:** Solicitar Proyecto

**Autor:** Sandoval Bravo Alejandro

**Fecha de creación:** 20 de marzo de 2020

**Fecha de actualización:** 24 de mayo de 2020

**Descripción**  
El *Practicante* deberá poder seleccionar hasta tres `PROJECT` como opciones para enviar un `PROJECT REQUEST` y poder ser asignado a uno de los `PROJECT` seleccionados.

**Actor:**  
*Practicante*

**Disparador**  
El *Practicante* da clic al botón "Solicitar Proyecto" en la vista `View_ProjectSection`

**Precondiciones**  
Pre-1. Debe haber, por lo menos, 1 `PROJECT` sin asignar en la Base de Datos.

Pre-2. El Practicante no ha enviado su `PROJECT REQUEST`.

**Flujo Normal:**
  1. El *SPP* recupera los `PROJECT` de la Base de Datos y los muestra en `View_ProjectRequest` con disposición cuadriculada; cada cuadro contiene una imagen representativa del proyecto y dos botones: "Visualizar" y "Seleccionar"; hasta abajo dos botones "Solicitar" y "Cancelar". EX-1.
  2. El *Practicante* da clic al botón "Seleccionar" en los `PROJECT` que quiera marcar como opción y da clic al botón "Solicitar". FA-1 FA-2 F-4 F-5
  3. El *SPP* muestra un diálogo `Dialog_Confirmation` con los botones "Confirmar" y "No".
  4. El *Practicante* da clic al botón "Confirmar". FA-3
  5. El *SPP* cierra el `Dialog_Confirmation` y añade los `PROJECT` al `PROJECT REQUEST` y lo guarda en la Base de Datos; y muestra un `Dialog_Success`.

**Flujos Alternos:**
  1. *Regresar*
     1. El *Practicante* da clic en el botón "Regresar".
     2. El *SPP* termina el Caso de Uso.
  2. *Visualizar Proyecto*
     1. El *Practicante* da clic al botón "Visualizar".
     2. El *SPP* muestra la interfaz `View_ProjectInformation`, que al final contiene un botón "Regresar".
     3. El *Practicante* da clic en el botón "Regresar"
     4. El *SPP* cierra `View_ProjectInformation`.
  3. *Cancelar Confirmación*
     1. El *Practicante* da clic en el botón "NO".
     2. El *SPP* cierra el `Dialog_Confirmation` y regresa al FN-2.
  4. *Máxima cantidad de solicitudes alcanzadas*
     1. El *SPP* muestra el diálogo `Dialog_MaxReached`. Regresa al FN-1.
  5. *Quitar Proyecto*
     1. El *Practicante* da clic en el botón "Quitar".
     2. El *SPP* quita la selección de ese proyecto.

**Excepciones:**
   1. *Error al conectar con Base de Datos*
      1. El *SPP* muestra un diálogo de mensaje `Dialog_ConnectionError`.

**Postcondiciones:**  
Post-1. El `PROJECT REQUEST` se guardó correctamente en la Base de Datos.

**Incluye (Relación Include):**  
No incluye.

**Extiende (Relación Extend):**  
No extiende.