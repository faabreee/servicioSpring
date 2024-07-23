# Proyecto de Gestión de Eventos y Usuarios

Este proyecto es una aplicación desarrollada con Spring que funciona como un servicio proporcionando endpoints para la gestión de eventos y usuarios.

## Descripción

El proyecto permite realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) tanto para eventos como para usuarios. Los endpoints están diseñados para facilitar la administración de estas entidades, ofreciendo una interfaz RESTful para interactuar con la aplicación.

## Características

- Gestión de eventos:
  - Crear, leer, actualizar y eliminar eventos.
  - Listar todos los eventos activos.
  
- Gestión de usuarios:
  - Crear, leer, actualizar y eliminar usuarios.
  - Autenticación y autorización de usuarios.

## Ejecución

Por defecto, la aplicación se ejecuta en el puerto `8081`. Si deseas cambiar el puerto de ejecución, puedes hacerlo modificando el archivo `application.properties` de la siguiente manera:
server.port=8081


## Endpoints
- Comentarios
  - GET /comentario/lista/{codEvento} - Listar comentarios por evento
  - POST /comentario/agregar - Agregar nuevo comentario
  - DELETE /comentario/eliminar/{id} - Eliminar comentario
- Entradas
  - GET /entrada/lista/{usuario} - Listar entradas del usuario
  - POST /entrada/agregar - Agregar entrada
- Eventos
  - GET /evento/lista/{usuario} - Listar eventos creados por el usuario
  - GET /evento/listado - Listar todos los eventos con estado 1
  - GET /evento/ver/{codEvento} - Buscar eventos por codEvento
  - POST /evento/agregar - Agregar evento
  - PUT /evento/actualizar - Actualizar evento
  - DELETE /evento/eliminar/{id} - Eliminar evento por código
  - PUT /evento/estado/{codEvento}/{estado} - Cambiar el estado de un evento
- Usuarios
  - GET /user/listar - Listar usuarios con estado 1
  - GET /user/buscar/{codUsuario} - Buscar usuario por codUsuario
  - POST /user/guardar - Guardar usuario
  - PUT /user/actualizar - Actualizar usuario
  - DELETE /user/eliminar/{codUsuario} - Eliminar usuario por codUsuario

