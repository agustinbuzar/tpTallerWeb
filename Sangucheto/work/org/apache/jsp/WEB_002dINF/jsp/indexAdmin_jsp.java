/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.68
 * Generated at: 2016-07-14 21:22:07 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class indexAdmin_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("  <!-- Theme Made By www.w3schools.com - No Copyright -->\r\n");
      out.write("  <title>[SanguCheto]</title>\r\n");
      out.write("  <meta charset=\"utf-8\">\r\n");
      out.write("  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("  <link rel=\"stylesheet\" href=\"http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css\">\r\n");
      out.write("  <link href=\"http://fonts.googleapis.com/css?family=Montserrat\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("  <link href=\"https://fonts.googleapis.com/css?family=Pacifico\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("  <link href=\"http://fonts.googleapis.com/css?family=Lato\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js\"></script>\r\n");
      out.write("  <script src=\"http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js\"></script>\r\n");
      out.write("  <link href=\"css/sangucheto.css\" rel=\"stylesheet\">  \r\n");
      out.write("</head>\r\n");
      out.write("<body id=\"myPage\" data-spy=\"scroll\" data-target=\".navbar\" data-offset=\"60\">\r\n");
      out.write("\r\n");
      out.write("<nav class=\"navbar navbar-default navbar-fixed-top\">\r\n");
      out.write("  <div class=\"container\">\r\n");
      out.write("    <div class=\"navbar-header\">\r\n");
      out.write("      <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\"#myNavbar\">\r\n");
      out.write("        <span class=\"icon-bar\"></span>\r\n");
      out.write("        <span class=\"icon-bar\"></span>\r\n");
      out.write("        <span class=\"icon-bar\"></span>\r\n");
      out.write("      </button>\r\n");
      out.write("      <a class=\"navbar-brand sangucheto\" href=\"indexAdmin\">SanguCheto</a>\r\n");
      out.write("        <p class=\"navbar-brand text-verde\">-[GOD MODE]-</p>     \r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"collapse navbar-collapse\" id=\"myNavbar\">\r\n");
      out.write("      <ul class=\"nav navbar-nav navbar-right\">\r\n");
      out.write("      \t<li><a href=\"agregarIngredienteStock\">ALTA&nbsp;</a></li>\r\n");
      out.write("      \t<li><a href=\"verStock\">STOCK&nbsp;</a></li>\r\n");
      out.write("        <li><a href=\"armarSanguche\">ARMAR</a></li>\r\n");
      out.write("        <li><a href=\"index\"><span class=\"glyphicon glyphicon-log-out\"></span></a></li>\r\n");
      out.write("      </ul>\r\n");
      out.write("    </div>\r\n");
      out.write("  </div>\r\n");
      out.write("</nav>\r\n");
      out.write("\r\n");
      out.write("<div class=\"jumbotron-admin text-center\">\r\n");
      out.write("  <h1 class=\"sangucheto\">SanguCheto</h1>\r\n");
      out.write("  <br>\r\n");
      out.write("  <div class=\"row\">\r\n");
      out.write("  <div class=\"col-sm-3\"></div>\r\n");
      out.write("  <div class=\"col-sm-6\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t<a href=\"agregarIngredienteStock\"><button type=\"button\" class=\"btn btn-default\">Alta Ingrediente</button></a> &nbsp;\r\n");
      out.write("\t\t\t<a href=\"verStock\"><button type=\"button\" class=\"btn btn-default\">Stock Ingrediente</button></a>\r\n");
      out.write("\t\t\t<br><br>\r\n");
      out.write("\t\t\t<a href=\"autoCompletar\"><button type=\"button\" class=\"btn btn-success\">Boton Magico</button></a>\t\r\n");
      out.write("\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("  <p class=\"text-center\">Sangucheto - BigChegusanRecords - 2016</p>\r\n");
      out.write("<script>\r\n");
      out.write("$(document).ready(function(){\r\n");
      out.write("  // Add smooth scrolling to all links in navbar + footer link\r\n");
      out.write("  $(\".navbar a, footer a[href='#myPage']\").on('click', function(event) {\r\n");
      out.write("    // Make sure this.hash has a value before overriding default behavior\r\n");
      out.write("    if (this.hash !== \"\") {\r\n");
      out.write("      // Prevent default anchor click behavior\r\n");
      out.write("      event.preventDefault();\r\n");
      out.write("\r\n");
      out.write("      // Store hash\r\n");
      out.write("      var hash = this.hash;\r\n");
      out.write("\r\n");
      out.write("      // Using jQuery's animate() method to add smooth page scroll\r\n");
      out.write("      // The optional number (900) specifies the number of milliseconds it takes to scroll to the specified area\r\n");
      out.write("      $('html, body').animate({\r\n");
      out.write("        scrollTop: $(hash).offset().top\r\n");
      out.write("      }, 900, function(){\r\n");
      out.write("   \r\n");
      out.write("        // Add hash (#) to URL when done scrolling (default click behavior)\r\n");
      out.write("        window.location.hash = hash;\r\n");
      out.write("      });\r\n");
      out.write("    } // End if\r\n");
      out.write("  });\r\n");
      out.write("  \r\n");
      out.write("  $(window).scroll(function() {\r\n");
      out.write("    $(\".slideanim\").each(function(){\r\n");
      out.write("      var pos = $(this).offset().top;\r\n");
      out.write("\r\n");
      out.write("      var winTop = $(window).scrollTop();\r\n");
      out.write("        if (pos < winTop + 600) {\r\n");
      out.write("          $(this).addClass(\"slide\");\r\n");
      out.write("        }\r\n");
      out.write("    });\r\n");
      out.write("  });\r\n");
      out.write("})\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
