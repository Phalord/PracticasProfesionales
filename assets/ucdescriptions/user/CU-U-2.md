--- 
layout: page 
title: "CU-U-2: Enviar mensaje" 
permalink: /design-specification/uc-descriptions/user/cu-u-2/ 
hide_hero: true 
---

**ID:** CU-U-2  

**Nombre:** Enviar mensaje  

**Autor:** Victor Arturo Ruiz Cuervo  

**Fecha de creación:** 27 de Marzo de 2020  

**Fecha de actualización:** 30 de Junio de 2020  

**Descripción:**  
El *Usuario* redacta un mensaje para poder comunicarse de manera directa e instantánea con otro **`USER`**.  

**Actor:**  
*Usuario*  

**Disparador:**  
El *Usuario* selecciona la opción “Nuevo Mensaje” en la ventana [`View_MessageSection`][VMSE].   

**Precondiciones:**  
PRE-1. Debe existir al menos dos **`USER`** en el sistema.  

**Flujo Normal:**  
 1. El *SPP* despliega la ventana [`View_NewMessage`][VNME] la cual contiene 3 etiquetas con sus respectivas cajas de texto para ingresar información, estas son: “Destinatario”, “Asunto”, “Contenido”. Al final de la interfaz se encuentran los botones “Enviar” y “Cancelar”. 
 2. <a id="fn-2"><i></i></a>El *Usuario* ingresa la información correspondiente y selecciona la opción “Enviar”. (Ver <a href="#cancelar_accion">FA-1</a>).
 3. El *SPP* valida los campos de texto, envía el mensaje y despliega un [`Dialog_Success`][DLSU] con el botón "Aceptar". (Ver <a href="#info_invalida">FA-2</a>, <a href="#empty_text">FA-3</a> y <a href="#error_conect">EX-1</a>)
 4. El *Usuario* da clic en el botón "Aceptar".
 5. El *SPP* cierra el [`Dialog_Success`][DLSU].
 6. Fin del caso de uso.

**Flujos Alternos:**  
  1. <a id="cancelar_accion"><i></i></a>*Cancelar acción*
	  1. El *Usuario* da clic en el botón "Cancelar". 
	  2. El *SPP* despliega la ventana [`View_MessageSection`][VMSE] y termina el caso de uso.
  2. <a id="info_invalida"><i></i></a>*Destinatario inválido*
	  1. El *SPP* despliega un [`Dialog_InvalidAddressee`][DLIA] con el botón “Aceptar”. 
	  2. El *Usuario* selecciona la opción “Aceptar”.
	  3. El *SPP* cierra el [`Dialog_InvalidAddressee`][DLIA] y retoma el <a href="#fn-2">FN-2</a>.
  3. <a id="empty_text"><i></i></a>*Cuadro sin información*
	  1. El *SPP* despliega un [`Dialog_EmptyTextBox`][DLET] con el botón “Aceptar”. 
	  2. El *Usuario* selecciona la opción “Aceptar”.
	  3. El *SPP* cierra el [`Dialog_EmptyBox`][DLET] y retoma el <a href="#fn-2">FN-2</a>.

**Excepciones:**  
  1. <a id="error_conect"><i></i></a>*Error de red*
     1. El *SPP* muestra un [`Dialog_ConnectionError`][DLCE] con el botón "Aceptar". 
     2. El *Practicante* da clic en el botón “Aceptar".
     3. El *SPP* cierra el [`Dialog_ConnectionError`][DLCE] y retoma el <a href="#fn-2">FN-2</a>.

**Postcondiciones:**  
POST-1. El destinatario recibe el mensaje en la bandeja de entrada.   

**Incluye (Relación Include):**  
No incluye.  

**Extiende (Relación Extend):**  
Si el *Usuario* da clic en “Cancelar” estando en la ventana [`View_NewMessage`][VNME] extienda al C.U “Consultar buzón” (<a href="https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/ucdescriptions/user/CU-U-1.md">CU-U-1</a>)  

[VMSE]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/user/View_MessageSection.png "`View_MessageSection` Prototype"
[VNME]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/user/View_NewMessage.png "`View_NewMessage` Prototype"
[DLIA]:https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/generals/Dialog_InvalidAdressee.png "`Dialog_InvalidAdressee` Prototype"
[DLET]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/user/Dialog_EmptyTextBox.png "`Dialog_EmptyTextBox` Prototype"
[DLSU]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/generals/Dialog_Success.png "`Dialog_Success` Prototype"
[DLCO]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/generals/Dialog_Confirmation.png "`Dialog_Confirmation` Prototype"
[DLCE]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/prototypes/generals/Dialog_ConnectionError.png "`Dialog_ConnectionError` Prototype"
