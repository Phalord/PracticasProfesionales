--- 
layout: page 
title: "CU-U-1: Consultar Buzón" 
permalink: /design-specification/uc-descriptions/user/cu-u-1/ 
hide_hero: true 
---

**ID:** CU-U-1  

**Nombre:** Consultar Buzón  

**Autor:** Victor Arturo Ruiz Cuervo  

**Fecha de creación:** 27 de Marzo de 2020  

**Fecha de actualización:** 05 de Mayo de 2020  

**Descripción:**  
El *Usuario* consulta los mensajes recibidos y enviados para mantenerse informado sobre asuntos académicos sobre la Experiencia Educativa.   

**Actor:**  
*Usuario*  

**Disparador:**  
El *Usuario* selecciona la opción “Buzón” en el menú desplegable de la ventana principal del *Usuario*.   

**Precondiciones:**  
PRE-1. Debe existir al menos un `USER` en el sistema.   

**Flujo Normal:**  
  1. El *SPP* despliega la ventana [`View_MessageSection`][VMSE], muestra una lista de mensajes recibidos, una visualización de ellos y 3 botones ubicados en la parte lateral izquierda: “Mensaje nuevo”, “Recibidos” y “Enviados”.
  2. El *Usuario* selecciona un botón de la lista alterna de mensajes. (Ver FA-1, FA-2, FA-3 y FA-4) 
  3. Termina el caso de uso.

**Flujos Alternos:**  
  1. *Eliminar mensaje*
	  1. El *Usuario* da clic en un mensaje y después hace clic en la opción "Eliminar".
	  2. El *SPP* muestra un [`Dialog_Confirmation`][DLCO] con las opciones “Confirmar” y “Cancelar”. 
	  3. El *Usuario* selecciona la opción “Confirmar” y el SSP elimina el mensaje y retoma el flujo normal, si no, selecciona la opción “Cancelar” y el *SPP* cierra el [`Dialog_Confirmation`][DLCO] sin borrar el mensaje y retoma el flujo normal.
  2. *Mensaje nuevo*
	  1. Ver caso de uso CU-U-2.
  3. *Mensajes recibidos*
	  1. El *Usuario* da clic en el botón "Recibidos".
	  2. El *SPP* filtra la bandeja de mensajes por aquellos que haya recibido de otros usuarios y retoma el flujo normal del caso de uso.
  4. *Mensajes enviados*
	  1. El *Usuario* da clic en el botón "Enviados".
	  2. El *SPP* filtra la bandeja de mensajes por aquellos que se hayan enviado desde el equipo del *Usuario* y retoma el flujo normal del caso de uso.

**Excepciones:**  
   1. *Error al eliminar mensaje*
	   1. El *SPP* muestra un [`Dialog_ConnectionError`][DLCE] con el botón "Aceptar". 
	   2. El *Practicante* da clic en el botón “Aceptar".
	   3. El *SPP* cierra el [`Dialog_ConnectionError`][DLCE] y retoma el flujo normal desde el paso 2.

**Postcondiciones:**  
POST-1. El *SPP* muestra una vista previa del primer mensaje.  

**Incluye (Relación Include):**  
No incluye.  

**Extiende (Relación Extend):**  
No extiende.  

[VMSE]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/generals/View_MessageSection.png "`View_MessageSection` Prototype"
[DLCO]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/generals/Dialog_Confirmation.png "`Dialog_Confirmation` Prototype"
[DLCE]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/generals/Dialog_ConnectionError.png "`Dialog_ConnectionError` Prototype"