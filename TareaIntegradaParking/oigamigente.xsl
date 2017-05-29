<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
<xsl:template match="/">
      <html>
          <body>
          
          <div style="background-color:blue;height:50px;text-align:center;vertical-align:center;font-size:35px;border:2px solid black;box-shadow: 5px 5px;">TRABAJADORES</div>
          <div style="width:80%;margin:auto;">
                    <xsl:for-each select="Trabajadores/Empleado">
                        <table style="width:100%;text-align:center;margin-top:10px;border:2px solid black;box-shadow: 2px 2px;">
                                <tr bgcolor="#9acd32">
                                   <th>TIPO</th><th>NOMBRE</th><th>CONTRASEÑA</th><th>CONTRASEÑA</th><th>CÓDIGO GARAJE</th><th>NOMBRE</th><th>FECHA NACIMIENTO</th><th>DIRECCIÓN</th><th>TELÉFONO</th>
                                </tr>
                            <tr>
                              <td><xsl:value-of select="tipo"/></td>
                              <td><xsl:value-of select="nombre_usuario"/></td>
                              <td><xsl:value-of select="contrasenya"/></td>
                              <td><xsl:value-of select="cod_garaje"/></td>
                              <td><xsl:value-of select="nombre"/></td>
                              <td><xsl:value-of select="fecha_nacimiento"/></td>
                              <td><xsl:value-of select="direccion"/></td>
                              <td><xsl:value-of select="telefono"/></td>
                            </tr>
                    </table>
                    </xsl:for-each>
           </div>
              
          </body>
      </html>
</xsl:template>
</xsl:stylesheet>
