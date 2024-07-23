CREATE DATABASE PROYECTO_DAWI;
USE  PROYECTO_DAWI;

-- Creación de la tabla USUARIO
CREATE TABLE USUARIO (
    codUsuario INT PRIMARY KEY AUTO_INCREMENT,
    segundoNombre VARCHAR(100),
    apellido VARCHAR(100),
    correo VARCHAR(255),
    nombre VARCHAR(100),
    contrasena VARCHAR(255),
    imagen VARCHAR(255),
    telefono VARCHAR(20),
    estado TINYINT NOT NULL
);
-- Creación de la tabla EVENTO
CREATE TABLE EVENTO (
    codEvento INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(70),
    descripcion VARCHAR(255),
    imagen VARCHAR(255),
    fechaInicio DATE,
    fechaFin DATE,
    hora TIME,
    ubicacion VARCHAR(255),
    precio DECIMAL(10, 2),
    estado TINYINT NOT NULL,
    codUsuario INT,
    FOREIGN KEY (codUsuario) REFERENCES USUARIO(codUsuario)
);
-- Creación de la tabla COMENTARIOS
CREATE TABLE COMENTARIOS (
    codComentario INT PRIMARY KEY AUTO_INCREMENT,
    codUsuario INT,
    codEvento INT,
    mensaje VARCHAR(255),
    Fecha DATE,
    valoracion INT,
    estado TINYINT NOT NULL,
    FOREIGN KEY (codUsuario) REFERENCES USUARIO(codUsuario),
    FOREIGN KEY (codEvento) REFERENCES EVENTO(codEvento)
);
-- Creación de la tabla DETALLE_PAGO
CREATE TABLE DETALLE_PAGO (
    codDetalle INT PRIMARY KEY AUTO_INCREMENT,
    codUsuario INT,
    codEvento INT,
    monto DECIMAL(10, 2),
    hora TIME,
    fechaPago DATE,
    estado TINYINT NOT NULL,
    FOREIGN KEY (codUsuario) REFERENCES USUARIO(codUsuario),
    FOREIGN KEY (codEvento) REFERENCES EVENTO(codEvento)
);

-- Creación de la tabla ENTRADAS
CREATE TABLE ENTRADAS (
    codEntrada INT PRIMARY KEY AUTO_INCREMENT,
    codUsuario INT,
    codEvento INT,
    precio DECIMAL(10, 2),
    fecha DATE,
    hora TIME,
    estado TINYINT NOT NULL,
    cantidad INT NOT NULL,
    FOREIGN KEY (codUsuario) REFERENCES USUARIO(codUsuario),
    FOREIGN KEY (codEvento) REFERENCES EVENTO(codEvento)
);

-- Insertar usuarios
INSERT INTO USUARIO (segundoNombre, apellido, correo, nombre, contrasena, imagen, telefono, estado) VALUES
('John', 'Doe', 'john.doe@example.com', 'John Doe', 'contraseña123', 'avatar1.jpg', '123456789', 1),
('Jane', 'Smith', 'jane.smith@example.com', 'Jane Smith', 'contraseña456', 'avatar2.jpg', '987654321', 1),
('Alice', 'Johnson', 'alice.johnson@example.com', 'Alice Johnson', 'contraseña789', 'avatar3.jpg', '555555555', 1);

-- Insertar eventos
INSERT INTO EVENTO (nombre, descripcion, imagen, fechaInicio, fechaFin, hora, ubicacion, precio, estado, codUsuario) VALUES
('Conferencia de Tecnología', 'Una conferencia sobre las últimas tendencias en tecnología.', '../../../assets/images/imagen-1.png', '2024-05-01', '2024-05-03', '09:00:00', 'Centro de Convenciones', 25.00, 0, 1),
('Festival de Música Indie', 'Un festival de música alternativa con bandas emergentes.', '../../../assets/images/imagen-2.jpg', '2024-05-05', '2024-05-07', '10:00:00', 'Parque de la Ciudad', 30.00, 1, 2),
('Exposición de Arte Contemporáneo', 'Una exposición que presenta obras de artistas contemporáneos.', '../../../assets/images/imagen-3.jpg', '2024-05-10', '2024-05-12', '11:00:00', 'Galería de Arte Moderno', 20.00, 1, 3),
('Torneo de Golf', 'Un torneo de golf abierto para aficionados y profesionales.', '../../../assets/images/imagen-4.jpg', '2024-05-15', '2024-05-17', '12:00:00', 'Club de Golf Sunset', 35.00, 0, 1),
('Carrera de 10K Solidaria', 'Una carrera benéfica para recaudar fondos para obras sociales.', '../../../assets/images/imagen-5.jpg', '2024-05-20', '2024-05-22', '13:00:00', 'Parque Metropolitano', 40.00, 1, 2),
('Feria Gastronómica Internacional', 'Una feria que ofrece una variedad de cocina de diferentes países.', '../../../assets/images/imagen-6.png', '2024-05-25', '2024-05-27', '14:00:00', 'Paseo Gastronómico', 45.00, 1, 3),
('Convención de Cómics y Cosplay', 'Una convención para fanáticos de los cómics y el cosplay.', '../../../assets/images/imagen-7.png', '2024-05-30', '2024-06-01', '15:00:00', 'Centro de Convenciones', 50.00, 0, 1),
('Festival de Cine Independiente', 'Un festival que presenta películas independientes de todo el mundo.', '../../../assets/images/imagen-8.png', '2024-06-05', '2024-06-07', '16:00:00', 'Teatro de la Ciudad', 55.00, 1, 2),
('Concierto de Jazz en Vivo', 'Un concierto que presenta artistas de jazz en vivo.', '../../../assets/images/imagen-9.png', '2024-06-10', '2024-06-12', '17:00:00', 'Club de Jazz Nocturno', 60.00, 0, 3);

INSERT INTO COMENTARIOS (codUsuario, codEvento, mensaje, Fecha, valoracion, estado)
VALUES 
-- Comentarios para el evento 1
(1, 1, '¡Excelente evento!', '2024-05-05', 5, 1),
(2, 1, 'Me encantó la presentación', '2024-05-05', 4, 1),

-- Comentarios para el evento 2
(1, 2, 'Esperaba más', '2024-05-06', 3, 1),
(2, 2, 'Interesante tema', '2024-05-07', 4, 1),
(1, 2, 'Buena selección de expositores', '2024-05-07', 5, 1),
(3, 2, 'Repetiría la experiencia', '2024-05-07', 5, 1),

-- Comentarios para el evento 3
(2, 3, 'No estuvo mal', '2024-05-08', 3, 1),
(1, 3, 'Regular', '2024-05-08', 2, 1),
(3, 3, 'Podría mejorar', '2024-05-08', 2, 1),

-- Comentarios para el evento 4
(3, 4, 'Fue espectacular', '2024-05-09', 5, 1),
(2, 4, 'Me gustó mucho la dinámica', '2024-05-09', 5, 1),
(1, 4, 'Excelentes ponentes', '2024-05-09', 4, 1),
(3, 4, 'Muy bien organizado', '2024-05-09', 5, 1),
(2, 4, 'Aprendí mucho', '2024-05-10', 5, 1),

-- Comentarios para el evento 5
(1, 5, 'No estuvo a la altura de las expectativas', '2024-05-10', 2, 1),
(3, 5, 'Interesante pero podría mejorar', '2024-05-10', 3, 1),
(2, 5, 'Regular en general', '2024-05-10', 2, 1),
(1, 5, 'Temas poco relevantes', '2024-05-11', 2, 1),

-- Comentarios para el evento 6
(2, 6, 'Una experiencia enriquecedora', '2024-05-11', 4, 1),
(1, 6, 'Me hubiera gustado más interacción', '2024-05-11', 3, 1),
(3, 6, 'Buen contenido', '2024-05-11', 4, 1),
(2, 6, 'Buena organización en general', '2024-05-12', 4, 1),
(1, 6, 'Podría mejorar la logística', '2024-05-12', 3, 1),

-- Comentarios para el evento 7
(3, 7, 'Gran experiencia', '2024-05-12', 5, 1),
(2, 7, 'Muy interesante', '2024-05-12', 4, 1),
(1, 7, 'Excelente selección de temas', '2024-05-12', 5, 1),
(3, 7, 'Aprendí mucho', '2024-05-13', 5, 1),
(2, 7, 'Mejoraría la duración de las charlas', '2024-05-13', 4, 1),

-- Comentarios para el evento 8
(1, 8, 'Excelente oportunidad de networking', '2024-05-13', 5, 1),
(2, 8, 'Me gustó la variedad de temas', '2024-05-13', 4, 1),
(1, 8, 'Bien organizado', '2024-05-14', 4, 1),
(3, 8, 'Interesante para ampliar conocimientos', '2024-05-14', 4, 1),

-- Comentarios para el evento 9
(2, 9, 'Podría haber más actividades interactivas', '2024-05-14', 3, 1),
(1, 9, 'Más diversidad en los expositores', '2024-05-14', 4, 1),
(3, 9, 'Buena oportunidad de aprendizaje', '2024-05-14', 4, 1),
(2, 9, 'Recomendaría el evento', '2024-05-15', 4, 1),
(1, 9, 'Excelente ubicación', '2024-05-15', 5, 1),
(3, 9, 'Faltó más dinamismo en las actividades', '2024-05-15', 3, 1),
(2, 9, 'Buenas instalaciones', '2024-05-16', 4, 1);

-- Insertar entradas
INSERT INTO ENTRADAS (codUsuario, codEvento, precio, fecha, hora, estado, cantidad) VALUES
(1, 1, 50.00, '2024-05-01', '09:00:00', 1, 2),
(1, 1, 25.00, '2024-05-01', '09:00:00', 1),
(2, 2, 30.00, '2024-05-05', '10:00:00', 1),
(3, 3, 20.00, '2024-05-10', '11:00:00', 1),
(1, 4, 35.00, '2024-05-15', '12:00:00', 1),
(2, 5, 40.00, '2024-05-20', '13:00:00', 1),
(3, 6, 45.00, '2024-05-25', '14:00:00', 1);

DELIMITER //
CREATE PROCEDURE buscar_usuario_por_codigo(
    IN p_codigo_usuario INT,
    OUT p_seg_nombre VARCHAR(100),
    OUT p_apellido VARCHAR(100),
    OUT p_correo VARCHAR(255),
    OUT p_telefono VARCHAR(20),
    OUT p_comentario TEXT
)
BEGIN
    SELECT u.segundoNombre, u.apellido, u.correo, u.telefono, c.mensaje
    INTO p_seg_nombre, p_apellido, p_correo, p_telefono, p_comentario
    FROM USUARIO u
    LEFT JOIN COMENTARIOS c ON u.codUsuario = c.codUsuario
    WHERE u.codUsuario = p_codigo_usuario;
END //
DELIMITER ;

select*from USUARIO
select*from EVENTO
select*from COMENTARIOS
select*from DETALLE_PAGO;
select*from ENTRADAS;