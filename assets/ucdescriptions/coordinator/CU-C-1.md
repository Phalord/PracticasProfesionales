--- 
layout: page 
title: "CU-C-1: Registrar proyecto" 
permalink: /design-specification/uc-descriptions/coordinator/cu-c-1/ 
hide_hero: true 
---
**ID:** CU-C-1  

**Nombre:** Registrar proyecto  

**Autor:** Victor Arturo Ruiz Cuervo  

**Fecha de creación:** 27 de Marzo de 2020  

**Fecha de actualización:** 05 de Junio de 2020  

**Descripción**  
El **Coordinador** registra un nuevo ``PROJECT`` en el sistema para que los ``PRACTICING`` puedan visualizar su información, evitando pérdidas de tiempo en comunicación presencial y que siempre esté disponible dicha información.   

**Actor:** **Coordinador**  

**Disparador**  
El **Coordinador** da clic en el botón “Registrar proyecto” en la ventana ``View_ProjectSection``   

**Precondiciones**  
PRE-1. Debe haber al menos un ``COORDINATOR`` en el sistema.  
PRE-2. Debe de haber al menos un ``PROJECT_RESPONSIBLE`` que siga laborando en la ``RELATED_COMPANY``  

**Flujo Normal:**  
1.	El SPP despliega la ventana ``View_AddProject`` la cual muestra la primera sección llamada “Datos de empresa” la cual contiene las etiquetas: Nombre de empresa, Dirección, Ciudad, Estado y Teléfono. Después, está la sección “Datos del responsable del proyecto” y contiene las etiquetas: Nombre, Cargo y Correo electrónico; y por último, la sección "Datos del proyecto" con las etiquetas Nombre, Descripción y Recursos. Cada una de las etiquetas contiene una caja de texto al lado y al final, aparecen 2 botones “Registrar” y “Cancelar”.
2.	El **Coordinador** procede a ingresar la información solicitada por el SSP y da clic en el botón “Registrar”. (Ver FA-1). 
3.	El SSP valida la información ingresada por el **Coordinador** , guarda esa información (``PROJECT``) en la base de datos y despliega un ``Dialog_Success`` con el botón "Aceptar"(Ver FA-2, EX-1). 
4.	El **Coordinador** da clic en el botón "Aceptar".
5.	El SPP cierra el ``Dialog_Success``.
6.	Fin del caso de uso.

**Flujos Alternos (FA):**  
  1. *Cancelar acción*
	  1.	El **Coordinador** da clic en el botón “Cancelar”.
	  2.	El SPP muestra un ``Dialog_Confirmation`` junto con los botones “Confirmar” y “Cancelar”. 
	  3.	El **Coordinador** selecciona la opción “Confirmar” y el SSP termina el caso de uso, si no, selecciona la opción “Cancelar” y el SPP continúa con el proceso en el paso 2 del flujo normal.
  2.	*Información inválida*
	  1.	El SPP despliega un ``Dialog_InvalidInformation`` con el botón "Aceptar".
	  2.	El **Coordinador** hace clic en el botón "Aceptar".
	  3.	El SPP cierra el ``Dialog_InvalidInformation`` y regresa al paso 2 del flujo normal.

**Excepciones:**  
   1. *Error al conectar con la base de datos*
	   1.	El SPP muestra un ``Dialog_ConnectionError`` con el botón "Aceptar". 
	   2.	El **Coordinador** da clic en el botón “Aceptar".
	   3.	El SPP cierra el ``Dialog_ConnectionError`` y retoma el flujo normal desde el paso 2. 

**Postcondiciones:**  
POST-1. El ``PROJECT`` se guardó en la base de datos y se cambió su estado a “Activo”.   

**Incluye (Relación Include):**    
No incluye.  

**Extiende (Relación Extend):**    
No extiende.  
