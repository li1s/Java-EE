/** 
 * @ autor Lebedev Sergey - L1is
 * В данном сервлете описана схема работа серверной части 
 * и ответ от сервера на введенные пользователем данные 
 * с клиентской части
 * Для запуска приложения используем сервер приложений Apache TomCat
 */

package ru.unlimit;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/MyServlet") // Анотация
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Задаем метод обработчик GET \ POST запросов по которым клиент будет получать
	 * ответ от сервера по ввденым им с клиентской части данных с файла
	 * NewFile1.html берем переменные которые эти данные хранят: firstname \
	 * lastname \ job \ gender \ age18 В полях gender \ age18 делаем проверку на
	 * NULL значения если пользователь ничего не указал Далее выводим эти данные в
	 * WEB форме Для отображения русской раскладки используем приведение к формату
	 * UTF-8
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String job = request.getParameter("job");
		String gender = request.getParameter("gender");
		if (gender == null) {
			gender = " Парамент не был указан ";
		}
		String age18 = request.getParameter("age18");
		if (age18 == null) {
			age18 = " Парамент не был указан ";
		}

		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");

		PrintWriter out = response.getWriter();
		out.println("<h3>Профиль сотрудника</h3>");
		out.println("Имя: " + firstname + "<br>");
		out.println("Фамилия: " + lastname + "<br>");
		out.println("Профессия: " + job + "</br>");
		out.println("Пол: " + gender + "</br>");
		out.println("Старше 18: " + age18 + "</br>");
		out.close();
	}

}
