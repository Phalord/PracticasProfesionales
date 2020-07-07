---
layout: page
title: Justificaciones del Diseño
permalink: /design-justifications/
---

## Medio de entrega

Realizar este tipo de documentación en un procesador de texto puede volverse algo extremadamente complicado, razón por la que hemos decidido escribirlo en `Markdown`, pues, para nosotros, significaba facilitar la creación de dicha documentación. Sin embargo, la elaboración del documento no es solo tedioso, sino que el leerlo también puede tornarse complicado o lento; es por esta razón que optamos por aprovechar las ventajas que nos proporciona `Markdown` y elaboramos una página web gracias a `GitHub Pages` y `Jekyll`.

## Definición de Requerimientos

### 2.1. Diagrama de paquetes
Hemos decidio eliminar al Actor *Usuario* pues solo existía por el sistema de mensajería; el cual, al encontrarse con una prioridad baja, optamos por omitirla para la primera versión del sistema. Por otro lado comtemplamos a los Actores *Administrador*, *Coodinador*, *Practicante* y *Profesor* como los actores para el diagrama de paquetes, agrupando los casos de uso por Actor y dándoles una numeración coninúa del 1 al 26, sin embargo, consideramos que agrupar por funcionalidad es una mejor opción a tomar en cuenta par futuros diseños.

### Diagrama de Casos de Uso por paquete
Diseñamos los diagramas de casos de uso por paquete, agrupando los casos de uso por Actor. Por lo que en los diagramas mostramos los casos de uso que realiza cada actor con su respectiva numeración, junto con los límites del sistema.

### Diagramas Actividades Por Caso de Uso
Realizamos algunos de los diagramas con particiones entre Sistema y Actor según consideramos conveniente.

#### CU-C-5
Al elaborar la descripción de este Caso de Uso en particular, se identificaron los flujos alternos *Agregar Empresa* y *Agregar responsable del Proyecto*. Estos flujos, al ser amplios, se ha decidido separarlos del Diagrama de Actividad principal y elaborar un Diagrama por cada uno de los dos flujos alternos.

## Diseño

Diseñamos con base en el modelo ICONIX, > ICONIX Process, as shown in the chapter’s opening figure, is a minimalist, streamlined approach that focuses on that area that lies in between use cases and code. Its emphasis is on what needs to happen at that point in the life cycle where you’re starting out: < , por lo que las desiciones tomadas fueron tomadas de esta metodología. Los diagramas fueron realizados con la herramienta de modelado Enterprise Architect.

### Diagrama de clases del modelo de Domino
Consideramos las clases que conforman el dominio del sistema, es decir, las clases más significativas dentro del dominio del problema. De esta manera realizamos un análisis orientado a objetos, haciendo también uso de la abstración y vocabulario del dominio. 

### Diagramas de Robustez Por Caso de Uso

Pese a no formar parte de UML, el análisis de robustez pertence al modelo ICONIX por lo que se realizaron los diagramas por caso de uso. Para realizar dicho análisis, identificamos los elementos frontera, objetos entidad y controladores. De esta manera logramos identificar inconsistencias en las descripciones de casos de uso, así como nuevas relaciones en el diagrama de clases.

### Diagramas de Secuencia Por Caso de Uso

Se modeló la interacción entre los objetos del sistema, por medio de mensajes. Presentamos los objetos por orden de aparción y se implementó el patrón de diseño DAO en el modelado.

### Diagramas de máquinas de estados

Diseñamos los diagramas de acuerdo a los objetos que consideramos que podrían cambiar su "estado" dentro del sistema, estos objetos son `Activity`, `Project`, `ProjectRequest` y `ProjectAssignment`.

Para los estados de los objetos de la Clase ProjectAssignment decidímos utilizar "activo, "inconcluso", y "concluido", porque en caso de que termine el semestre, si la materia es concluida de forma satsifactoria con el proyecto asigando, entonces cambia a "concluido". En caso de que tuviera un mal desempeño sería el estado "inconcluso", en el caso del estado "activo", se refiere al estado en que se encuentra en el transcurso del proyecto.





