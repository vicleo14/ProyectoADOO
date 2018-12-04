
package vista;

import controladores.Administrador;
import controladores.Gestor;
import controladores.Organizador;
import controladores.UsuarioRegistrado;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class formModificarOrganizador extends HttpServlet {
    private Organizador org;
    private Administrador ad;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("  <head>");
            out.println("    <meta charset='utf-8'>");
            out.println("      ");
            out.println("    <!--Importa las fuentes que se usan para los icono de Google-->");
            out.println("    <link type='text/css' rel='stylesheet' href='css/font.css' />");
            out.println("    <!--");
            out.println("      Importa los estilos de Materialize obtenidos de https://materializecss.com/");
            out.println("    -->");
            out.println("    <link type='text/css' rel='stylesheet' href='css/materialize.css'  media='screen,projection'/>");
            out.println("    <style>");
            out.println("      .cuerpo");
            out.println("      {");
            out.println("        min-height: 75vh;");
            out.println("      }");
            out.println("      nav .input-field");
            out.println("      {");
            out.println("        padding-bottom: 0;");
            out.println("      }");
            out.println("      nav .input-field #search");
            out.println("      {");
            out.println("          border:none;");
            out.println("          padding-bottom: 10px;");
            out.println("          color:white;");
            out.println("          text-align: center;");
            out.println("      }");
            out.println("      nav .input-field #search:focus");
            out.println("      {");
            out.println("          color:black;");
            out.println("      }");
            out.println("    </style>");
            out.println("    <!--Se usa para indicar que esta pagina sera responsive-->");
            out.println("    <meta name='viewport' content='width=device-width, initial-scale=1.0'/>");
            out.println("  </head>");
            out.println("  <body>");
            out.println("    <!--Seccion de la barra de navegacion.-->");
            out.println("    <nav class='indigo darken-4 nav-extended'>");
            out.println("      <div class='nav-wrapper'>");
            out.println("        <a href='#' class='brand-logo center titulo' ><img src='img/logo.png' />ESCOMeevent</a>");
            out.println("        <!--Zona del boton de menu hasta la etiqueta </ul>-->");
            out.println("        <ul id='nav-mobile' class='left '>");
            out.println("          <li>");
            out.println("            <a href='#' data-activates='menu' class='menu' id='iconomenu'><i class='material-icons'>menu</i>");
            out.println("            </a>");
            out.println("          </li>");
            out.println("        </ul>  ");
            out.println("      </div>");
            out.println("      <div class='nav-content'>");
            out.println("        <!--Zona para permitir la navegacion al usuario entre las pestanias-->");
            out.println("        <div class='col s12'>");
            out.println("          <a href='index.html' class='breadcrumb'>Home</a>");
            out.println("          <a href='#!' class='breadcrumb'>Modificar Organizador</a>");/*---------------*/
            out.println("        </div>");
            out.println("      </div>");
            out.println("    </nav>");
            out.println("    <div class='container white'>");
            out.println("      <ul id='menu' class='sidenav'>");
            out.println("        <li>");
            out.println("          <div class='user-view'>");
            out.println("            <div class='background'>");
            out.println("              <img src='img/f1.png'>");
            out.println("            </div>");
            out.println("            <a><img class='circle' src='img/imgPerfil.jpg'></a>");
            out.println("            <a><span class='white-text name'>Bienvenido(a):"+ad.getNombre()+"</span></a>");
            out.println("          </div>");
            out.println("        </li>");
            out.println("        <li><a href='RedireccionarInicio'>Inicio</a></li>");
            out.println("        <li><a href='VistaProximosEventos'>Próximos Eventos</a></li>");
            out.println("        <li><a href='CerrarSesion'>Cerrar Sesión</a></li>");
            out.println("        <li><a href='#'>Acerca de</a></li>");
            out.println("      </ul>");
            out.println("    </div>");
            out.println("    <!--");
            out.println("        Colocar a partir de estas lineas el contenido de la pagina");
            out.println("    -->");
            out.println("   <div class='row'>");
            out.println("    <div class='col s12 offset-m3 m6'>");
            out.println("      <div class='card grey lighten-3'>");
            out.println("        <div class='card-content black-text '>");
            out.println("          <span class='card-title pink-text darken-3-text'>Modificar organizador</span>");/*---------------*/
            out.println("          <p>Esta sección permite corregir datos de los organizadores que ya están registrados. Si se desea eliminar al organizador, da click en el botón que se encuentra al final del formulario </p>");
            out.println("          <form action='ModificarOrganizador' method='post'>");
            out.println("             <div class='row'>");
            out.println("              <div class='input-field col s12'>");
            out.println("                <input  id='clvOrg' type='text'  name='clvOrg' class='validate' value='"+org.getClave()+"' required maxlength='10' readonly>");
            out.println("                <label class='active' for='clvOrg'>Clave del organizador</label>");
            out.println("              </div>");
            out.println("              <div class='input-field col s12'>");
            out.println("                <input  id='nombre' type='text'  name='nombre' class='validate' maxlength='44' required value='"+org.getNombre()+"' >");
            out.println("                <label class='active' for='nombre'>Nombre del Organizador:</label>");
            out.println("              </div>");
            out.println("              <div class='input-field col s12'>");
            out.println("                <input  id='contac' type='text'  name='contac' class='validate' maxlength='60' required value='"+org.getContacto()+"'>");
            out.println("                <label class='active' for='contac'>Contacto del organizador:</label>");
            out.println("              </div>");
            out.println("                <button class='btn waves-effect waves-light' type='button' name='action' onClick='window.location=\"EliminarOrganizador?claveOrganizador="+org.getClave()+"\"'>Eliminar organizador");
            out.println("                  <i class='material-icons right'>error</i>");
            out.println("                </button>");
            out.println("                <button class='btn waves-effect waves-light' type='submit' name='action'>Guardar cambios");
            out.println("                  <i class='material-icons right'>send</i>");
            out.println("                </button>");
            out.println("              </div>");
            out.println("            </div>");
            out.println("          </form>      ");
            out.println("      </div>");
            out.println("    </div>");
            out.println("  </div>");
            out.println("    <script type='text/javascript' src='js/jquery-1.12.1.min.js'></script>");
            out.println("    <script type='text/javascript' src='js/materialize.min.js'></script>");
            out.println("    <script type='text/javascript' src='js/maps.js'></script>");
            out.println("    <!--");
            out.println("      Seccion para codigo incrustado de JavaScript colocar abajo de este comentario.");
            out.println("    -->");
            out.println("    <script type='text/javascript'>");
            out.println("      $(function(){");
            out.println("        $('#iconomenu').sideNav(");
            out.println("        {");
            out.println("          edge:'left',");
            out.println("          draggable:true,");
            out.println("          closeOnClick:true");
            out.println("        });");
            out.println("      })");
            out.println("");
            out.println("      function generarClv()");
            out.println("      {");
            out.println("      	var hoy = new Date();");
            out.println("		var mm = hoy.getMonth()+1;");
            out.println("		var yyyy = hoy.getFullYear();");
            out.println("		var clave= String(yyyy).substring(2,4)+mm.toString(16)+document.getElementById('nombre').value .replace(/ /g,'').substring(0,4);");
            out.println("		document.getElementById('clvOrg').value=clave;");
            out.println("      }");
            out.println("    </script>");
            out.println("  </body>");
            out.println("</html>");
        }
    }

 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        HttpSession sesion=request.getSession();
        UsuarioRegistrado us=(UsuarioRegistrado)sesion.getAttribute("usuario");
        if(us==null)
        {
            System.out.println("No hay sesion iniciada");
            response.sendRedirect("VistaLogIn");
        }
        else if( us instanceof Gestor)
        {
            response.sendRedirect("VistaInicioGestor");
        }
        else if(us instanceof Administrador)
        {
            ad=(Administrador)us;
             String cveOrg=request.getParameter("cOrg");
            org=new Organizador(cveOrg);
            processRequest(request, response);
            
        }
        else
        {
            System.out.println("El tipo de usuario no es administrador");
            response.sendRedirect("VistaInicioUsuario");
        }
       
        
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}