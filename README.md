# 🚀  TalkIe Toki - Plataforma de Diálogo Comunitario

¡Bienvenido/a al repositorio de la **TalkIe Toki**! Este proyecto es una potente **API RESTful** diseñada para simular un espacio dinámico donde las comunidades pueden **publicar ideas, iniciar debates y fomentar un diálogo constructivo**. Es la herramienta perfecta para fortalecer la interacción y el intercambio de conocimientos.

---

### ✨ Características Destacadas

* **💡 Publicación de Ideas:** Los usuarios pueden fácilmente crear, organizar y compartir sus ideas con toda la comunidad.
* **🗣️ Diálogo Comunitario:** Fomenta discusiones activas y significativas, permitiendo a los miembros interactuar y colaborar.
* **🔒 Autenticación Robusta con JWT:** Asegura que solo los usuarios autorizados puedan acceder y participar, utilizando JSON Web Tokens para una seguridad eficiente.
* **📄 API Completamente Documentada:** Explora y prueba todos los endpoints de la API de forma interactiva gracias a la integración con **OpenAPI (Swagger UI)**.
* **🛡️ Manejo de Excepciones Personalizado:** Nuestro sistema de errores es robusto y ofrece mensajes claros y específicos para una mejor experiencia del desarrollador y del usuario.

---

### 🛠️ Tecnologías Utilizadas

Este proyecto está construido con herramientas modernas y estándares de la industria para asegurar escalabilidad y mantenibilidad:

* **Java 24:** El corazón del proyecto, utilizando las últimas características del lenguaje.
* **Spring Boot:** Para un desarrollo rápido y eficiente de microservicios.
* **Spring Security:** Proporcionando seguridad a nivel empresarial para tu API.
* **JSON Web Tokens (JWT):** Estándar de la industria para autenticación segura sin estado.
* **OpenAPI (Swagger UI):** Simplificando la exploración y el consumo de la API.
* **Base de Datos (PostgreSQL por defecto)** Configuración inicial para un arranque rápido y pruebas.
    * 🔄 **¡Flexible!** Cambia fácilmente a **H2, MySQL, Oracle** o tu base de datos preferida ajustando unas pocas líneas en la configuración.

---

### ⚙️ Requisitos Previos

Antes de iniciar, asegúrate de tener lo siguiente en tu entorno:

* **Java Development Kit (JDK) 24**
* **Apache Maven** (para la gestión de dependencias y la construcción del proyecto)

---

### 🚀 Configuración y Ejecución Local

¡Poner en marcha el proyecto es sencillo! Sigue estos pasos:

1.  **Clonar el Repositorio:**
    ```bash
    git clone <https://github.com/JuanBM0308/TalkIe-Toki-Api.git>
    cd nombre-del-repositorio # O el nombre de tu carpeta de proyecto
    ```
2.  **Configurar la Base de Datos:**
    ```properties
    # Ejemplo para PostgreSQL
    spring.datasource.url=jdbc:postgresql://localhost:5432/your_database_name
    spring.datasource.username=your_username
    spring.datasource.password=your_password
    spring.jpa.hibernate.ddl-auto=update # O 'none', 'create', 'create-drop' según tu necesidad
    spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
    ```
    ⚠️ **Importante:** Asegúrate de que el driver JDBC correspondiente (e.g., `postgresql` para PostgreSQL) esté incluido en tu `pom.xml`.

3.  **Construir el Proyecto:**
    ```bash
    mvn clean install
    ```
4.  **Ejecutar la Aplicación:**
    ```bash
    mvn spring-boot:run
    ```
    La aplicación se iniciará por defecto en: `http://localhost:8080`.

---

### 🌐 Accediendo a la Documentación de la API (OpenAPI/Swagger UI)

Una vez que la aplicación esté en línea, la documentación interactiva estará disponible en:

* **URL:** `http://localhost:8080/swagger-ui.html`

¡Desde aquí podrás explorar todos los endpoints, realizar pruebas directamente y entender los modelos de datos!

---

### 📐 Estructura del Proyecto

El proyecto sigue una **arquitectura limpia y modular**, con capas bien definidas para cada funcionalidad por ser tan pequeño. Esto asegura una alta **mantenibilidad, escalabilidad y separación de responsabilidades**.

---

### 🤝 Contribución

¡Me encanta recibir contribuciones! Si tienes ideas para mejorar, encuentras algún error o quieres añadir nuevas funcionalidades:

1.  Haz un "fork" de este repositorio.
2.  Crea una nueva rama (`git checkout -b feature/AmazingFeature`).
3.  Realiza tus cambios y haz "commit" (`git commit -m 'Add some AmazingFeature'`).
4.  Haz "push" a la rama (`git push origin feature/AmazingFeature`).
5.  Abre un "Pull Request".

---

### 📝 Licencia

Este proyecto está bajo la **Licencia MIT**. Siéntete libre de usarlo, modificarlo y distribuirlo. Para más detalles, consulta la [Licencia MIT](https://opensource.org/license/mit).

---
---
---

# 🚀 TalkIe Toki - Community Dialogue Platform

Welcome to the **TalkIe Toki** repository! This project is a powerful **RESTful API** designed to simulate a dynamic space where communities can **publish ideas, initiate debates, and foster constructive dialogue**. It's the perfect tool for strengthening interaction and knowledge exchange.

---

### ✨ Key Features

* **💡 Idea Publishing:** Users can easily create, organize, and share their ideas with the entire community.
* **🗣️ Community Dialogue:** Fosters active and meaningful discussions, allowing members to interact and collaborate.
* **🔒 Robust JWT Authentication:** Ensures that only authorized users can access and participate, using JSON Web Tokens for efficient security.
* **📄 Fully Documented API:** Explore and test all API endpoints interactively thanks to the integration with **OpenAPI (Swagger UI)**.
* **🛡️ Custom Exception Handling:** Our error handling system is robust and provides clear, specific messages for a better developer and user experience.

---

### 🛠️ Technologies Used

This project is built with modern tools and industry standards to ensure scalability and maintainability:

* **Java 24:** The core of the project, leveraging the latest language features.
* **Spring Boot:** For rapid and efficient microservice development.
* **Spring Security:** Providing enterprise-grade security for your API.
* **JSON Web Tokens (JWT):** Industry standard for secure stateless authentication.
* **OpenAPI (Swagger UI):** Simplifying API exploration and consumption.
* **Database (PostgreSQL by default):** Initial configuration for quick startup and testing.
    * 🔄 **Flexible!** Easily switch to **H2, MySQL, Oracle**, or your preferred database by adjusting a few lines in the configuration.

---

### ⚙️ Prerequisites

Before getting started, make sure you have the following installed in your environment:

* **Java Development Kit (JDK) 24**
* **Apache Maven** (for dependency management and project build)

---

### 🚀 Local Setup and Running

Getting the project up and running is straightforward! Follow these steps:

1.  **Clone the Repository:**
    ```bash
    git clone [https://github.com/JuanBM0308/TalkIe-Toki-Api.git](https://github.com/JuanBM0308/TalkIe-Toki-Api.git)
    cd your-project-folder-name # Or your actual project folder name
    ```
2.  **Configure the Database:**
    The project is set up to use **PostgreSQL by default**. Update the `src/main/resources/application.properties` (or `application.yml`) file with your database credentials:

    ```properties
    # Example for PostgreSQL
    spring.datasource.url=jdbc:postgresql://localhost:5432/your_database_name
    spring.datasource.username=your_username
    spring.datasource.password=your_password
    spring.jpa.hibernate.ddl-auto=update # Or 'none', 'create', 'create-drop' based on your needs
    spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
    ```
    ⚠️ **Important:** Ensure the corresponding JDBC driver (e.g., `postgresql` for PostgreSQL) is included in your `pom.xml`.

3.  **Build the Project:**
    ```bash
    mvn clean install
    ```
4.  **Run the Application:**
    ```bash
    mvn spring-boot:run
    ```
    The application will start by default at: `http://localhost:8080`.

---

### 🌐 Accessing API Documentation (OpenAPI/Swagger UI)

Once the application is online, interactive API documentation will be available at:

* **URL:** `http://localhost:8080/swagger-ui.html`

From here, you can explore all available endpoints, test them directly, and understand the data models!

---

### 📐 Project Structure

The project follows a **clean and modular architecture**, with well-defined layers for each functionality due to its compact size. This ensures high **maintainability, scalability, and separation of concerns**.

---

### 🤝 Contributing

I love receiving contributions! If you have ideas for improvement, find a bug, or want to add new features:

1.  Fork this repository.
2.  Create a new branch (`git checkout -b feature/AmazingFeature`).
3.  Make your changes and commit (`git commit -m 'Add some AmazingFeature'`).
4.  Push to the branch (`git push origin feature/AmazingFeature`).
5.  Open a Pull Request.

---

### 📝 License

This project is licensed under the **MIT License**. Feel free to use, modify, and distribute it. For more details, see the [MIT License](https://opensource.org/license/mit).

---