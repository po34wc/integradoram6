CREATE DEFINER=`root`@`localhost` PROCEDURE `ProcesaHistorial`(IN idparam integer)
Begin
CREATE TEMPORARY TABLE temp_historial
SELECT
	'O' AS Fuente,
	DATE(fecha) AS Fecha,
    usuario.nombre AS NombreOri,
    usuario.apellido AS ApellidoOri,
    tipo,
    IF(tipo IN ('RETIRO', 'TRANSFERENCIA'), monto * -1, monto) AS monto,
    '123456789012345678901234567890123456789012345' AS NombreDes,
    '123456789012345678901234567890123456789012345' AS ApellidoDes,
    idusuario_origen,
    idusuario_destino
FROM transaccion
LEFT JOIN usuario ON transaccion.idusuario_origen = usuario.idusuario
WHERE idusuario_destino = idparam OR idusuario_origen = idparam;

UPDATE temp_historial
LEFT JOIN usuario ON temp_historial.idusuario_destino = usuario.idusuario
SET NombreDes = usuario.nombre,
    ApellidoDes = usuario.apellido;

CREATE TEMPORARY TABLE temp_historial2
SELECT 
	'P' AS Fuente,
	Fecha,
    '123456789012345678901234567890123456789012345' AS NombreOri,
    '123456789012345678901234567890123456789012345' AS ApellidoOri,
    Tipo,
    Monto * -1 AS Monto,
    usuario.Nombre AS NombreDes,
    usuario.apellido AS ApellidoDes,
    idusuario_origen,
    idusuario_destino
FROM temp_historial
LEFT JOIN usuario ON idusuario_destino = idusuario
WHERE idusuario_destino = idparam AND idusuario_origen <> idparam;

UPDATE temp_historial2
LEFT JOIN usuario ON temp_historial2.idusuario_origen = usuario.idusuario
SET NombreOri = usuario.nombre,
    ApellidoOri = usuario.apellido;

INSERT INTO temp_historial
SELECT * FROM temp_historial2;

DELETE FROM temp_historial WHERE idusuario_origen <> idparam AND fuente = 'O';

SELECT 
	@n := @n + 1 AS id,
	temp_historial.* 
FROM temp_historial, (SELECT @n := 0) m;
End