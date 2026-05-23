# 🎵 TP Streaming - API REST Musical
**Trabajo Práctico Nº 3 - Programación III** 
Carrera: Ingeniería en Sistemas de Información

---

# 👥 Integrantes

- Hernández Domínguez Tatiana Ayelen - DNI: 45.563.479
- Ochoa Candela Maribel - DNI: 46.401.137
- Sibilia María Giuliana - DNI: 46.723.876

---

# 📖 Descripción del Proyecto

Aplicación desarrollada en Java y Spring Boot que simula una plataforma de streaming musical mediante una API REST.
El sistema nos permite gestionar canciones, artistas y reproducciones, implementando búsquedas, reproducción concurrente de canciones y endpoints REST para consulta de información musical.
Además, se implementó manejo concurrente para el incremento seguro del contador de reproducciones.

---

# 🛠️ Tecnologías Utilizadas

- Lenguaje: Java 17
- Framework: Spring Boot
- Gestor de Dependencias: Apache Maven
- API REST
- Postman
- IDE: Visual Studio Code
- Control de versiones: Git y GitHub

---

# ⚙️ Funcionalidades

## 🎵 Canciones

✔ Listar todas las canciones  
✔ Buscar canción por ID  
✔ Buscar canciones filtradas por título y artista  
✔ Incrementar contador de reproducciones  
✔ Reproducción concurrente segura  

---

## 🎤 Artistas

✔ Listar artistas  
✔ Buscar artista por ID  
✔ Buscar artista por nombre  

---

## 🔄 Concurrencia

✔ Incremento concurrente de reproducciones utilizando estructuras thread-safe  
✔ Simulación de múltiples reproducciones simultáneas mediante requests REST  

---

# 🌐 Endpoints Principales

## Canciones
- GET /api/canciones
- GET /api/canciones/{id}
- GET /api/canciones/buscar?titulo=xxx&artista=yyy

## Artistas
- GET /api/artistas

---

## 📂 Estructura del proyecto

- `model` → entidades del dominio   
- `service` → lógica de negocio  
- `service/strategy` → estrategias de reproducción y playlists
 

