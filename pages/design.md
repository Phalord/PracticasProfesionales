---
layout: page
title: Especificación de Diseño
permalink: /design-specification/
toc: true
---

## Datos escorlares
**Docente:** Dr. Jorge Octavio Ocharán Hernández

**Experiencia Educativa:** Principios de Diseño de Software

**Dev Team:**
  * Ruiz Cuervo Victor Arturo
  * Sandoval Bravo Alejandro
  * Tapia Cruz Abner Jeffrey

## Introducción
El objetivo principal del *Sistema para Prácticas Profesionales* es proporcionar apoyo a los actores más frecuentes de esta experiencia educativa (EE), los cuales son: el Coordinador de las Prácticas Profesionales, los docentes que imparten la EE y los alumnos que la cursan; buscando, principalmente, reducir el tiempo de trabajo del coordinador y otorgar la posibilidad de realizar todo el proceso de una manera más rápida y eficaz.

El contenido de esta *Especificación de Diseño* comienza con el [planteamiento del problema](#situación-actual), sobre cómo se lleva, actualmente, el proceso de las Prácticas Profesionales. Después pasamos a la [definición de requerimientos](#definición-de-requerimientos), sección dividida en las siguientes secciones: [diagramas de paquetes de Casos de uso](#diagrama-de-paquetes-de-casos-de-uso), [diagramas de casos de uso por paquetes](#diagramas-de-casos-de-uso-por-paquetes), [descripciones de casos de uso](#descripción-de-casos-de-uso) y [diagramas de actividades por caso de uso](#diagramas-de-actividades-por-caso-de-uso). Continuando con el [apartado de diseño](#diseño), donde incorporamos el [Modelo de Dominio](#diagrama-de-clases-del-modelo-de-dominio), como diagrama de clases, del Sistema.

## Situación actual
Los proceso de la EE Prácticas Profesionales, como la entrega de documentos por parte de los alumnos toman mucho tiempo y pueden ser entorpecidos. Algunas actividades que el Coordinador de la EE realiza son exhaustivas y, en promedio, se pierden hasta dos días por corregir errores inesperados. Estas situaciones llevan a la necesidad de un nuevo sistema con el cual se puedan gestionar los datos y proceso adecuadamente y, de esta manera, facilitarlos.

## Definición de Requerimientos
### Diagrama de paquetes de Casos de Uso
[Paquetes de Casos de Uso][PCU]

### Diagramas de Casos de Uso por paquetes
[Paquete Administrador][CUA]

[Paquete Coordinador][CUC]

[Paquete Profesor][CUP]

[Paquete Practicante][CUS]

[Paquete Usuario][CUU]

[PCU]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/tree/gh-pages/assets/imgs/packages/usecasepackages.png
[CUA]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/tree/gh-pages/assets/imgs/packages/administratorpackage.png
[CUC]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/tree/gh-pages/assets/imgs/packages/coordinatorpackage.png
[CUP]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/tree/gh-pages/assets/imgs/packages/professorpackage.png
[CUS]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/gh-pages/assets/imgs/packages/practitionerpackage.png
[CUU]: https://raw.githubusercontent.com/Phalord/PracticasProfesionales/tree/gh-pages/assets/imgs/packages/userpackage.png

### Descripción de Casos de Uso
#### Descripción: Administrador
#### Descripción: Coordinador
#### Descripción: Profesor
#### Descripción: Practicante
  1. [Solicitar Proyecto][SOPR]
  2. [Añadir Horario][ANHO]
  3. [Generar Reporte Parcial][GRPA]
  4. [Añadir Reporte Parcial][ARPA]
  5. [Generar Reporte Mensual][GRME]
  6. [Añadir Reporte Mensual][ARME]
  7. [Generar Autoevaluación][GAUT]
  8. [Añadir Autoevaluación][AAUT]
  9. [Añadir Actividad][AACT]
  10. [Añadir Bitácora Personal][APSP]
  11. [Añadir Plan de Actividades][APAC]

[SOPR]: https://phalord.github.io/PracticasProfesionales/design-specification/uc-descriptions/practitioner/cu-pr-1/
[ANHO]: https://phalord.github.io/PracticasProfesionales/design-specification/uc-descriptions/practitioner/cu-pr-2/
[GRPA]: https://phalord.github.io/PracticasProfesionales/design-specification/uc-descriptions/practitioner/cu-pr-3/
[ARPA]: https://phalord.github.io/PracticasProfesionales/design-specification/uc-descriptions/practitioner/cu-pr-4/
[GRME]: https://phalord.github.io/PracticasProfesionales/design-specification/uc-descriptions/practitioner/cu-pr-5/
[ARME]: https://phalord.github.io/PracticasProfesionales/design-specification/uc-descriptions/practitioner/cu-pr-6/
[GAUT]: https://phalord.github.io/PracticasProfesionales/design-specification/uc-descriptions/practitioner/cu-pr-7/
[AAUT]: https://phalord.github.io/PracticasProfesionales/design-specification/uc-descriptions/practitioner/cu-pr-8/
[AACT]: https://phalord.github.io/PracticasProfesionales/design-specification/uc-descriptions/practitioner/cu-pr-9/
[APSP]: https://phalord.github.io/PracticasProfesionales/design-specification/uc-descriptions/practitioner/cu-pr-10/
[APAC]: https://phalord.github.io/PracticasProfesionales/design-specification/uc-descriptions/practitioner/cu-pr-11/

#### Descripción: Usuario

### Diagramas de Actividades por Caso de Uso
#### Actividad: Administrador
#### Actividad: Coordinador
#### Actividad: Profesor
  1. [Solicitar Proyecto][ASOPR]
  2. [Añadir Horario][AANHO]
  3. [Generar Reporte Parcial][AGRPA]
  4. [Añadir Reporte Parcial][AARPA]
  5. [Generar Reporte Mensual][AGRME]
  6. [Añadir Reporte Mensual][AARME]
  7. [Generar Autoevaluación][AGAUT]
  8. [Añadir Autoevaluación][AAAUT]
  9. [Añadir Actividad][AAACT]
  10. [Añadir Bitácora Personal][AAPSP]
  11. [Añadir Plan de Actividades][AAPAC]

[ASOPR]: https://github.com/Phalord/PracticasProfesionales/blob/gh-pages/assets/imgs/activities/practitioner/act1.png?raw=true "Solicitar Proyecto"
[AANHO]: https://github.com/Phalord/PracticasProfesionales/blob/gh-pages/assets/imgs/activities/practitioner/act2.png?raw=true "Añadir Horario"
[AGRPA]: https://github.com/Phalord/PracticasProfesionales/blob/gh-pages/assets/imgs/activities/practitioner/act3.png?raw=true "Generar Reporte Parcial"
[AARPA]: https://github.com/Phalord/PracticasProfesionales/blob/gh-pages/assets/imgs/activities/practitioner/act4.png?raw=true "Añadir Reporte Parcial"
[AGRME]: https://github.com/Phalord/PracticasProfesionales/blob/gh-pages/assets/imgs/activities/practitioner/act5.png?raw=true "Generar Reporte Mensual"
[AARME]: https://github.com/Phalord/PracticasProfesionales/blob/gh-pages/assets/imgs/activities/practitioner/act6.png?raw=true "Añadir Reporte Mensual"
[AGAUT]: https://github.com/Phalord/PracticasProfesionales/blob/gh-pages/assets/imgs/activities/practitioner/act7.png?raw=true "Generar Autoevaluación"
[AAAUT]: https://github.com/Phalord/PracticasProfesionales/blob/gh-pages/assets/imgs/activities/practitioner/act8.png?raw=true "Añadir Autoevaluación"
[AAACT]: https://github.com/Phalord/PracticasProfesionales/blob/gh-pages/assets/imgs/activities/practitioner/act9.png?raw=true "Añadir Actividad"
[AAPSP]: https://github.com/Phalord/PracticasProfesionales/blob/gh-pages/assets/imgs/activities/practitioner/act10.png?raw=true "Añadir Bitácora Personal" 
[AAPAC]: https://github.com/Phalord/PracticasProfesionales/blob/gh-pages/assets/imgs/activities/practitioner/act11.png?raw=true "Añadir Plan de Actividades"

#### Actividad: Practicante
#### Actividad: Usuario

## Diseño
### Diagrama de Clases del Modelo de Dominio

## Conclusiones
En resumen, lo presentado en esta *Especificación de Diseño* fue una breve descripción de la situación actual sobre el proceso de prácticas profesionales, los [diagramas de casos de uso](#diagramas-de-casos-de-uso-por-paquetes) y algunas [descripciones](#descripción-de-casos-de-uso) de estos, ya que tomamos algunos que consideramos relevantes para esta versión, además de sus respectivos [diagramas de actividad](#diagramas-de-actividades-por-caso-de-uso). Todo esto fue mostrado con la finalidad de dar a entender o, por lo menos, generar una pequeña idea de como será el funcionamiento del sistema y explicar el por qué sería conveniente su realización, pues, como se mencionó anteriormente en la [introducción](#introducción), el sistema permitirá un desarrollo eficaz y rápido del proceso al automatizarlo mediante el uso de Software.