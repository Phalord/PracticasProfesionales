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

**Fecha de actualización:** 30 de Junio de 2020  

**Descripción:**  
El *Usuario* consulta los mensajes recibidos y enviados para mantenerse informado sobre asuntos académicos sobre la Experiencia Educativa.   

**Actor:**  
*Usuario*  

**Disparador:**  
El *Usuario* selecciona la opción “Buzón” en el menú desplegable de la ventana principal del *Usuario*.   

**Precondiciones:**  
PRE-1. Debe existir al menos un **`USER`** en el sistema.   

**Flujo Normal:**  
  1. El *SPP* despliega la ventana [`View_MessageSection`][VMSE], muestra una lista de mensajes recibidos, una visualización de ellos y 3 botones ubicados en la parte lateral izquierda: “Mensaje nuevo”, “Recibidos” y “Enviados”.
  2. <a id="fn-2"><i></i></a>El *Usuario* selecciona un botón de la lista alterna de mensajes. (Ver <a href="#eliminar">FA-1</a>, <a href="#nuevo_mensaje">FA-2</a>, <a href="#mensajes_recibidos">FA-3</a> y <a href="#mensajes_enviados">FA-4</a>) 
  3. Termina el caso de uso.

**Flujos Alternos:**  
  1. <a id="eliminar"><i></i></a>*Eliminar mensaje*
	  1. El *Usuario* da clic en un mensaje y después hace clic en la opción "Eliminar".
	  2. El *SPP* elimina el mensaje de la lista y despliega un [`Dialog_Success`][DLSU] con el botón "Aceptar". (Ver <a href="#error_eliminar">EX-1</a>)
	  3. El *Usuario* da clic en "Aceptar".
	  4. El *SPP* cierra el [`Dialog_Success`][DLSU] y retoma el proceso en el <a href="#fn-2">FN-2</a>.
  2. <a id="nuevo_mensaje"><i></i></a>*Mensaje nuevo*
	  1. Ver caso de uso <a href="https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/ucdescriptions/user/CU-U-2.md">CU-U-2</a>.
  3. <a id="mensajes_recibidos"><i></i></a>*Mensajes recibidos*
	  1. El *Usuario* da clic en el botón "Recibidos".
	  2. El *SPP* filtra la bandeja de mensajes por aquellos que haya recibido de otros usuarios y retoma el <a href="#fn-2">FN-2</a>.
  4. <a id="mensajes_enviados"><i></i></a>*Mensajes enviados*
	  1. El *Usuario* da clic en el botón "Enviados".
	  2. El *SPP* filtra la bandeja de mensajes por aquellos que se hayan enviado desde el equipo del *Usuario* y retoma el <a href="#fn-2">FN-2</a>.

**Excepciones:**  
   1. <a id="error_eliminar"><i></i></a>*Error al eliminar mensaje*
	   1. El *SPP* muestra un [`Dialog_ConnectionError`][DLCE] con el botón "Aceptar". 
	   2. El *Practicante* da clic en el botón “Aceptar".
	   3. El *SPP* cierra el [`Dialog_ConnectionError`][DLCE] y retoma el <a href="#fn-2">FN-2</a>.

**Postcondiciones:**  
POST-1. El *SPP* muestra una vista previa del primer mensaje.  

**Incluye (Relación Include):**  
No incluye.  

**Extiende (Relación Extend):**  
No extiende.  

[VMSE]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/user/View_MessageSection.png "`View_MessageSection` Prototype"
[DLCO]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/generals/Dialog_Confirmation.png "`Dialog_Confirmation` Prototype"
[DLCE]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/generals/Dialog_ConnectionError.png "`Dialog_ConnectionError` Prototype"
[DLSU]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/generals/Dialog_Success.png "`Dialog_Success` Prototype"
