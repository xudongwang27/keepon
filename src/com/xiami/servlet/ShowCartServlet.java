package com.xiami.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xiami.model.Goods;



@WebServlet("/showCart")
public class ShowCartServlet extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		List<Goods> goodsList = (List<Goods>)session.getAttribute("cart");
		if(goodsList == null || goodsList.size()==0){
			System.out.println("°×À´Ò»ÌË!");
		}else{
			for (Goods goods : goodsList) {
				System.out.println(goods.getId() + "---" + goods.getName() + "--" + goods.getCount());
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
