---
layout: page
title: "CU-PR-9: Añadir Actividad"
permalink: /design-specification/uc-descriptions/practitioner/cu-pr-9/
hide_hero: true
---

**ID:** CU-PR-9

**Nombre:** Añadir Actividad

**Autor:** Sandoval Bravo Alejandro

**Fecha de creación:** 25 de marzo de 2020

**Fecha de actualización:** 24 de mayo de 2020

**Descripción**  
El *Practicante* deberá poder subir el PDF de su `ACTIVITY` para que su `PROFESSOR` proceda a calificarla.

**Actor:**  
*Practicante*

**Disparador:**  
El *Practicante* da clic al botón "Añadir Horario" en la interfaz `View_UploadDocumentation`.

**Precondiciones**  
Pre-1. El *Practicante* debe tener, al menos, una `ACTIVITY` asignada sin entregar.

**Flujo Normal:**
  1. El *SPP* muestra la interfaz `View_UploadDocument`, con los botones "Seleccionar Archivo", "Subir" y "Regresar".
  2. El *Practicante* da clic al botón "Seleccionar Archivo". FA-1
  3. El *SPP* abre el explorador de archivos del Sistema Operativo (SO).
  4. El *Practicante* busca su `ACTIVITY` en el explorador de archivos, lo selecciona y da clic en "Cargar". FA-2
  5. El *SPP* carga la `ACTIVITY`. EX-1
  6. El *Practiante* da clic en el botón "Subir".
  7. El *SPP* muestra un diálogo `Dialog_Confirmation` con dos botones "Cancelar" y "Confirmar".
  8. El *Practicante* da clic en el botón "Confirmar". FA-3
  9. El *SPP* guarda la `ACTIVITY` en la Base de Datos y muestra un `Dialog_Succes`. EX-2

**Flujos Alternos:**
  1. *Regresar*
     1. El *Practicante* da clic en el botón "Regresar".
     2. El *SPP* termina el Caso de Uso.
  2. *Cancelar Cargar Documento*
     1. El *Practicante* da clic al botón "Cancelar" del explorador de archivos.
     2. El *SO* cierra el explorador de archivos y regresa el enfoque al *SPP*, regresando al FN-2.
  3. *Cancelar Confirmación*
     1. El *Practicante* da clic en el botón "Cancelar".
     2. El *SPP* cierra el `Dialog_Confirmation` y regresa al FN-2.

**Excepciones:**
   1. *Error al cargar la `ACTIVITY`*
      1. El *SPP* muestra un `Dialog_Error` y regresa al FN-2
   2. *Error al conectar con Base de Datos*
      1. El *SPP* no puede conectarse con la Base de Datos para guardar la `ACTIVITY`.
      2. El *SPP* muestra un diálogo de mensaje `Dialog_ConnectionError`.

**Postcondiciones:**  
Post-1. La `ACTIVITY` se guardó en la Base de Datos.

**Incluye (Relación Include):**  
No incluye.

**Extiende (Relación Extend):**  
No extiende.