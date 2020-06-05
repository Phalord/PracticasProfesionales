--- 
layout: page 
title: "CU-PF-1: Generar actividad" 
permalink: /design-specification/uc-descriptions/professor/cu-pf-1/ 
hide_hero: true 
---

**ID:** CU-PF-1  

**Nombre:** Generar actividad  

**Autor:** Victor Arturo Ruiz Cuervo  

**Fecha de creación:** 27 de Marzo de 2020  

**Fecha de actualización:** 05 de Junio de 2020  

**Descripción:**  
El *Profesor* podrá generar una `ACTIVITY` y se le notificará a los `PRACTICING` para que sea realizada en un plazo que el *Profesor* elija.  

**Actor:**  
*Profesor*  

**Disparador:**  
El *Profesor* da clic en la opción “Generar actividad” de la ventana `View_ActivitySection`.  

**Precondiciones**  
PRE-1. Debe existir al menos un `PROFESSOR` en el sistema.  
PRE-2. El `PROFESSOR` debe tener asignado como mínimo un `PRACTICING`.   

**Flujo Normal:**  
1. El *SPP* despliega la ventana `View_AddActivity` y muestra 3 etiquetas: Titulo, Descripción y Fecha de entrega. Las primeras dos etiquetas tienen campos de texto a sus costados mientras que la última tiene un `DatePicker` debajo donde se puede seleccionar una fecha en específico. Por último, se muestran 2 botones “Publicar” y “Cancelar”. 
2. El *Profesor* ingresa un título y descripción para la `ACTIVITY`, selecciona una fecha límite de entrega haciendo clic en un día cualquiera y da clic el botón “Publicar”. (Ver FA-1).
3. El *SPP* valida los datos ingresados, publica en el área de actividades la nueva `ACTIVITY`, la guarda en la base de datos y muestra un `Dialog_Success` con el botón "Aceptar". (Ver FA-2 y EX-1) 
4. El *Profesor* da clic en el botón "Aceptar".
5. El *SPP* cierra el `Dialog_Success`.
6. Fin del caso de uso.

**Flujos Alternos:**    
  1. *Cancelar acción*
	  1. El *Profesor* da clic en el botón “Cancelar”.
	  2. El *SPP* muestra un `Dialog_Confirmation` junto con los botones “Confirmar” y “Cancelar”. 
	  3. El *Profesor* selecciona la opción “Confirmar” y el *SPP* termina el caso de uso, si no, selecciona la opción “Cancelar” y el *SPP* continúa con el proceso en el paso 2 del flujo normal.
  2. *Información inválida*
	  1. El *SPP* despliega un `Dialog_InvalidInformation` con el botón "Aceptar".
	  2. El *Profesor* hace clic en el botón "Aceptar".
	  3. El *SPP* cierra el `Dialog_InvalidInformation` y regresa al paso 2 del flujo normal.

**Excepciones:**    
   1. *Error al conectar con la base de datos*
	   1. El *SPP* muestra un `Dialog_ConnectionError` con el botón "Aceptar". 
	   2. El *Profesor* da clic en el botón “Aceptar".
	   3. El *SPP* cierra el `Dialog_ConnectionError`y retoma el flujo normal desde el paso 2.

**Postcondiciones:**  
POST-1. La `ACTIVITY` se encuentra en el sistema en estado “Activo”.  

**Incluye (Relación Include):**  
No incluye.  

**Extiende (Relación Extend):**    
No extiende.    
