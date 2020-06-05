--- 
layout: page 
title: "CU-C-7: Actualizar proyecto" 
permalink: /design-specification/uc-descriptions/coordinator/cu-c-7/ 
hide_hero: true 
---
**ID:** CU-C-7

**Nombre:** Actualizar proyecto  

**Autor:** Victor Arturo Ruiz Cuervo  

**Fecha de creación:** 27 de Marzo de 2020  

**Fecha de actualización:** 24 de Junio de 2020  

**Descripción:**  
El *Coordinador* actualiza la información de un `PROJECT` ya existente en el sistema para que los `PRACTICING` no se encuentren desactualizados en cuanto a la información del `PROJECT`.   

**Actor:**  
*Coordinador*  

**Disparador**  
El *Coordinador* da clic en el botón “Actualizar proyecto” de la ventana `View_ProjectSection`  

**Precondiciones:**  
PRE-1. Debe haber al menos un `COORDINATOR` en el sistema.    
PRE-2. Debe de haber al menos un `PROJECT` en la base de datos.    

**Flujo Normal:**    
1. El *SPP* despliega la ventana `View_ChooseProject` la cual muestra una lista de los `PROJECT` almacenados junto con un botón “Cancelar”. Además de la instrucción de seleccionar un `PROJECT` en una etiqueta.
2. El *Coordinador* selecciona el `PROJECT` que quiere editar. (Ver FA-1). 
3. El *SPP* despliega la ventana `View_AddProject` *(Ver caso de uso CU-C-1)*. 
4. El *Coordinador* ingresa la información actualizada en los cuadros de texto correspondientes y da clic en el botón “Registrar”. (Ver FA-1) 
5. El *SPP* valida la información ingresada, actualiza y guarda la información modificada; y muestra un `Dialog_Success`con el botón "Aceptar". (Ver FA-2, EX-1).
6. El *Coordinador* da clic en la opción "Aceptar".
7. El *SPP* cierra el `Dialog_Success` y despliega la ventana `View_ChooseProject`.
8.	Fin del caso de uso.

**Flujos Alternos:**  
  1. *Cancelar acción*
	  1. El *Coordinador* da clic en el botón “Cancelar”.
	  2. El *SPP* muestra un `Dialog_Confirmation` junto con los botones “Confirmar” y “Cancelar”. 
	  3. El *Coordinador* selecciona la opción “Confirmar” y el SSP termina el caso de uso, si no, selecciona la opción “Cancelar” y el *SPP* continúa con el proceso en el paso actual del flujo normal.
  2. *Información inválida*
	  1. El *SPP* despliega un `Dialog_InvalidInformation` con el botón "Aceptar".
	  2. El *Coordinador* hace clic en el botón "Aceptar".
	  3. El *SPP* cierra el `Dialog_InvalidInformation` y regresa al paso 4 del flujo normal.

**Excepciones:**  
  1. *Error al conectar con la base de datos*
	   1. El *SPP* muestra un `Dialog_ConnectionError` con el botón "Aceptar". 
	   2. El *Coordinador* da clic en el botón “Aceptar".
	   3. El *SPP* cierra el `Dialog_ConnectionError`y retoma el flujo normal desde el paso 4. 

**Postcondiciones:**  
POST-1. El `PROJECT` se guardó en la base de datos y se cambió su estado a “Activo”.   

**Incluye (Relación Include):**  
No incluye.  

**Extiende (Relación Extend):**  
No extiende.  
