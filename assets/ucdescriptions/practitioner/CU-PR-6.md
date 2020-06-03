---
layout: page
title: "CU-PR-6: Añadir Reporte Mensual"
permalink: /design-specification/uc-descriptions/practitioner/cu-pr-6/
hide_hero: true
---

**ID:** CU-PR-6

**Nombre:** Añadir Reporte Mensual

**Autor:** Sandoval Bravo Alejandro

**Fecha de creación:** 25 de marzo de 2020

**Fecha de actualización:** 24 de mayo de 2020

**Descripción**  
El *Practicante* deberá poder subir una versión PDF de su `MONTHLY REPORT`.

**Actor:**  
*Practicante*

**Disparador:**  
El *Practicante* da clic al botón "Añadir Reporte Mensual" en la interfaz `View_UploadDocumentation`.

**Precondiciones**  
Pre-1. El *Practicante* debe estar asignado a un `PROJECT`.
Pre-2. El *Practicante* debe tener asignada al menos 1 `ACTIVITY` sin completar.

**Flujo Normal:**
  1. El *SPP* muestra la interfaz `View_UploadDocument`, con los botones "Seleccionar Archivo", "Subir" y "Regresar".
  2. El *Practicante* da clic al botón "Seleccionar Archivo". FA-1
  3. El *SPP* abre el explorador de archivos del Sistema Operativo (SO).
  4. El *Practicante* busca su `MONTHLY REPORT` en el explorador de archivos, lo selecciona y da clic en "Cargar". FA-2
  5. El *SPP* carga el `MONTHLY REPORT`. EX-1
  6. El *Practiante* da clic en el botón "Subir".
  7. El *SPP* muestra un diálogo `Dialog_Confirmation` con dos botones "Cancelar" y "Confirmar".
  8. El *Practicante* da clic en el botón "Confirmar". FA-3
  9. El *SPP* guarda el `MONTHLY REPORT` en la Base de Datos y muestra un `Dialog_Succes`. EX-2

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
   1. *Error al cargar el `MONTHLY REPORT`*
      1. El *SPP* muestra un `Dialog_Error` y regresa al FN-2
   2. *Error al conectar con Base de Datos*
      1. El *SPP* no puede conectarse con la Base de Datos para guardar el `MONTHLY REPORT`.
      2. El *SPP* muestra un diálogo de mensaje `Dialog_ConnectionError`.

**Postcondiciones:**  
Post-1. El `MONTHLY REPORT` se guardó en la Base de Datos.

**Incluye (Relación Include):**  
No incluye.

**Extiende (Relación Extend):**  
No extiende.